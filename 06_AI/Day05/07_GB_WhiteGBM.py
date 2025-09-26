import pandas as pd
from sklearn.preprocessing import StandardScaler, LabelEncoder
from sklearn.model_selection import train_test_split, RandomizedSearchCV
from lightgbm import LGBMClassifier  # LightGBM Classifier 임포트
from scipy.stats import uniform, randint
from imblearn.over_sampling import SMOTE
from sklearn.metrics import accuracy_score, f1_score, roc_auc_score
import numpy as np

# 데이터 로드 (파일 경로 확인)
dataset = pd.read_csv("./Day05/data/LungCancer.csv") 


# -------------------------------------------------------------------
# 1. 데이터 클리닝 및 특성 공학 (Feature Engineering)
# -------------------------------------------------------------------

# 불필요한 열 제거
dataset = dataset.drop(['id', 'diagnosis_date', 'end_treatment_date'], axis=1)

# 수치형 결측치 처리 (평균값으로 대체)
numerical_impute_cols = ['age', 'bmi', 'cholesterol_level']
for col in numerical_impute_cols:
    dataset[col] = dataset[col].fillna(dataset[col].mean())

# 1-1. [특성 공학] 질병 점수 (Illness Score) 생성
illness_cols = ['hypertension', 'asthma', 'cirrhosis', 'other_cancer']
dataset['Illness_Score'] = dataset[illness_cols].sum(axis=1) 

# 1-2. [특성 공학] 나이/BMI 구간 생성
dataset['Age_Group'] = pd.cut(dataset['age'], bins=[0, 50, 65, dataset['age'].max() + 1], labels=['Age_Under_50', 'Age_Mid_50_65', 'Age_Over_65'], right=False)
dataset['BMI_Category'] = pd.cut(dataset['bmi'], bins=[0, 18.5, 25, 30, dataset['bmi'].max() + 1], labels=['BMI_Underweight', 'BMI_Normal', 'BMI_Overweight', 'BMI_Obese'], right=False)


# -------------------------------------------------------------------
# 2. 범주형 데이터 인코딩
# -------------------------------------------------------------------
le = LabelEncoder()

# Label Encoding (순서 또는 이진 데이터)
dataset['cancer_stage_encoded'] = le.fit_transform(dataset['cancer_stage']) + 1
dataset['family_history_encoded'] = le.fit_transform(dataset['family_history'])

# One-Hot Encoding (순서 없는 데이터)
nominal_cols = ['gender', 'country', 'smoking_status', 'treatment_type', 'Age_Group', 'BMI_Category']
dataset = pd.get_dummies(dataset, columns=nominal_cols, drop_first=True) 

# 원본 문자열 및 사용된 이진 숫자 컬럼 삭제
dataset = dataset.drop(['cancer_stage', 'family_history'] + illness_cols, axis=1)


# -------------------------------------------------------------------
# 3. 데이터 분리 및 스케일링
# -------------------------------------------------------------------
X = dataset.drop('survived', axis=1)
y = dataset['survived']

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

scaler = StandardScaler()
X_train_scaled = scaler.fit_transform(X_train)
X_test_scaled = scaler.transform(X_test)


# -------------------------------------------------------------------
# 4. ⭐ SMOTE (불균형 해소) 적용 및 튜닝 ⭐
# -------------------------------------------------------------------
smote = SMOTE(random_state=42)
X_train_resampled, y_train_resampled = smote.fit_resample(X_train_scaled, y_train)


# 1. LightGBM 모델의 하이퍼파라미터 탐색 공간 정의
params_lgbm = {
    'n_estimators': randint(low=1000, high=2000), 
    'learning_rate': uniform(0.01, 0.08),
    'num_leaves': randint(low=20, high=60),     # Lighter, faster trees
    'max_depth': randint(low=5, high=12),       
    'min_child_samples': randint(low=15, high=30),
    'subsample': uniform(0.7, 0.3),
    'colsample_bytree': uniform(0.7, 0.3)
}

# 2. RandomizedSearchCV 객체 생성 (LGBMClassifier 사용)
lgbm_rscv = RandomizedSearchCV(
    # metric='logloss', verbose=-1은 출력 로그를 끄고 이진 분류에 적합한 설정을 유지합니다.
    estimator=LGBMClassifier(random_state=42, n_jobs=-1, metric='logloss', verbose=-1), 
    param_distributions=params_lgbm, 
    n_iter=20, # 반복 횟수 조정
    cv=3,       # 교차 검증 횟수 조정
    scoring='f1', # ⭐ F1-SCORE를 기준으로 최적화 (불균형 데이터 필수)
    n_jobs=-1, 
    random_state=42
)

print("LightGBM Randomized Search 최적화 시작 (F1-Score 기준)...")

# 3. SMOTE된 데이터로 학습
lgbm_rscv.fit(X_train_resampled, y_train_resampled)

# 4. 가장 좋은 모델 객체 및 결과 추출
best_lgbm = lgbm_rscv.best_estimator_
y_pred = best_lgbm.predict(X_test_scaled)
y_proba = best_lgbm.predict_proba(X_test_scaled)[:, 1]


# -------------------------------------------------
# 5. 최종 성능 평가 (F1-Score 및 ROC AUC)
# -------------------------------------------------
print("\n------------------- LightGBM 최종 성능 평가 -------------------")
print('가장 점수가 높은 조합 (Final Params):', lgbm_rscv.best_params_)

# 최종 성능 지표 계산
test_accuracy = accuracy_score(y_test, y_pred)
test_f1 = f1_score(y_test, y_pred)
test_auc = roc_auc_score(y_test, y_proba)


print(f"1. 테스트 정확도 (Accuracy): {test_accuracy:.4f} (이 값은 불균형으로 인해 왜곡될 수 있음)")
print(f"2. 테스트 F1-Score: {test_f1:.4f} ⭐ (소수 클래스 예측 실력)")
print(f"3. 테스트 ROC AUC: {test_auc:.4f} ⭐ (클래스 구별 능력)")
print("--------------------------------------------------------------------")