import pandas as pd
from sklearn.preprocessing import StandardScaler, LabelEncoder
from sklearn.model_selection import train_test_split, RandomizedSearchCV
from xgboost import XGBClassifier
from scipy.stats import uniform, randint
from imblearn.over_sampling import SMOTE # ⭐ 불균형 해소 라이브러리 임포트
import numpy as np
from sklearn.metrics import f1_score, roc_auc_score # 최종 평가 지표 임포트

# -------------------------------------------------------------------
# 0. 데이터 로드 및 초기 정보
# -------------------------------------------------------------------
# 파일 경로를 확인하세요.
dataset = pd.read_csv("./Day05/data/LungCancer.csv") 


# -------------------------------------------------------------------
# 1. 데이터 클리닝 및 결측치 처리
# -------------------------------------------------------------------
# 불필요한 열 (id, 날짜) 제거
dataset = dataset.drop(['id', 'diagnosis_date', 'end_treatment_date'], axis=1)

# 수치형 결측치 처리 (평균값으로 대체)
numerical_impute_cols = ['age', 'bmi', 'cholesterol_level']
for col in numerical_impute_cols:
    dataset[col] = dataset[col].fillna(dataset[col].mean())


# -------------------------------------------------------------------
# 2. 특성 공학 (Feature Engineering) 및 인코딩
# -------------------------------------------------------------------

# 2-1. [특성 공학] 질병 점수 (Illness Score) 생성
illness_cols = ['hypertension', 'asthma', 'cirrhosis', 'other_cancer']
dataset['Illness_Score'] = dataset[illness_cols].sum(axis=1) 


# 2-2. [특성 공학] 나이 구간 및 BMI 카테고리 생성 
bins_age = [0, 50, 65, dataset['age'].max() + 1]
labels_age = ['Age_Under_50', 'Age_Mid_50_65', 'Age_Over_65']
dataset['Age_Group'] = pd.cut(dataset['age'], bins=bins_age, labels=labels_age, right=False)

bins_bmi = [0, 18.5, 25, 30, dataset['bmi'].max() + 1]
labels_bmi = ['BMI_Underweight', 'BMI_Normal', 'BMI_Overweight', 'BMI_Obese']
dataset['BMI_Category'] = pd.cut(dataset['bmi'], bins=bins_bmi, labels=labels_bmi, right=False)


# 2-3. 범주형 데이터 인코딩
le = LabelEncoder()

# Label Encoding (순서 또는 이진 데이터)
dataset['cancer_stage_encoded'] = le.fit_transform(dataset['cancer_stage']) + 1
dataset['family_history_encoded'] = le.fit_transform(dataset['family_history'])

# One-Hot Encoding (순서 없는 데이터)
nominal_cols = ['gender', 'country', 'smoking_status', 'treatment_type', 'Age_Group', 'BMI_Category']
dataset = pd.get_dummies(dataset, columns=nominal_cols, drop_first=True) 

# 원본 문자열 및 사용된 이진 숫자 컬럼 삭제 (Illness_Score에 합산됨)
dataset = dataset.drop(['cancer_stage', 'family_history'] + illness_cols, axis=1)


# -------------------------------------------------------------------
# 3. 데이터 분리 및 스케일링
# -------------------------------------------------------------------

X = dataset.drop('survived', axis=1)
y = dataset['survived']

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# 스케일링 (SMOTE를 적용하기 전에 스케일링을 먼저 해야 합니다.)
scaler = StandardScaler()
X_train_scaled = scaler.fit_transform(X_train)
X_test_scaled = scaler.transform(X_test)


# -------------------------------------------------------------------
# 4. ⭐ SMOTE (불균형 해소) 적용 ⭐
# -------------------------------------------------------------------
smote = SMOTE(random_state=42)
# 훈련 세트만 오버샘플링하여 소수 클래스 샘플을 생성합니다.
X_train_resampled, y_train_resampled = smote.fit_resample(X_train_scaled, y_train)

print(f"✅ SMOTE 적용 후 훈련 데이터 수: {X_train_resampled.shape[0]}개")
print("-------------------------------------------------")


# -------------------------------------------------------------------
# 5. XGBoost 튜닝 및 학습 (RandomizedSearchCV)
# -------------------------------------------------------------------

# 1. 모델에 적용시킬 파라미터 옵션 지정
params_aggressive = {
    'max_depth': randint(low=8, high=16), 
    'min_child_weight': randint(1, 10),
    'gamma': uniform(0, 0.5), 
    'n_estimators': randint(low=1000, high=2000), 
    'learning_rate': uniform(0.01, 0.11), 
}

# 2. RandomizedSearchCV 객체 생성 및 실행 (SMOTE된 데이터 사용)
xgb_rscv_agg = RandomizedSearchCV(
    estimator=XGBClassifier(n_jobs=-1, random_state=42, eval_metric='logloss'), 
    param_distributions=params_aggressive, 
    n_iter=15, # 탐색 횟수
    cv=3,       # 교차 검증 횟수
    scoring='accuracy',
    n_jobs=-1, 
    random_state=42,
    verbose=0 # 출력 로그를 끕니다. (간결하게)
)

print("XGBoost Randomized Search 최적화 시작...")
# 3. SMOTE된 데이터를 사용해 학습
xgb_rscv_agg.fit(X_train_resampled, y_train_resampled)

# 4. 가장 좋은 모델 객체 받아오기
best_xgb_tuned = xgb_rscv_agg.best_estimator_ 


# -------------------------------------------------
# 6. 최종 예측 및 다중 지표 평가
# -------------------------------------------------

# 훈련 세트 스코어 (최적화 후)
train_accuracy = best_xgb_tuned.score(X_train_resampled, y_train_resampled) # resampled 데이터로 평가
test_accuracy = best_xgb_tuned.score(X_test_scaled, y_test)

y_pred = best_xgb_tuned.predict(X_test_scaled)
y_proba = best_xgb_tuned.predict_proba(X_test_scaled)[:, 1]

print("\n------------------- 최종 성능 평가 (SMOTE 적용) -------------------")
print('가장 점수가 높은 조합 (Final Params):', xgb_rscv_agg.best_params_)

print(f"1. 훈련 세트 정확도 (SMOTE 적용): {train_accuracy:.4f}")
print(f"2. 테스트 정확도 (실력): {test_accuracy:.4f}")
print("--- 불균형 데이터 지표 ---")
print(f"3. 테스트 F1-Score: {f1_score(y_test, y_pred):.4f}")
print(f"4. 테스트 ROC AUC: {roc_auc_score(y_test, y_proba):.4f}")
print("------------------------------------------------------------------")