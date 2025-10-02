import numpy as np
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split, GridSearchCV, RandomizedSearchCV
from sklearn.ensemble import ExtraTreesClassifier
from xgboost import XGBClassifier
from scipy.stats import uniform, randint
from sklearn.metrics import classification_report, confusion_matrix, roc_curve, auc, f1_score, make_scorer

# 한글 폰트 설정
plt.rcParams['font.family'] ='Malgun Gothic'
plt.rcParams['axes.unicode_minus'] =False

# 데이터 셋 불러오기
titanic = sns.load_dataset('titanic')
# ========================================================================================================================================================


# ========================================================================================================================================================
# 타이타닉 데이터 전처리
## 불필요한 컬럼 제거 및 Null 값 처리
titanic = titanic.drop(['embarked', 'class', 'who', 'adult_male', 'deck', 'embark_town', 'alive', 'alone'], axis=1)

# Null 값 채우기: pclass를 기준으로 그룹을 나누어 각 그룹의 나이 평균값을 사용 (수업 내용 반영)
titanic['age'] = titanic['age'].fillna(titanic.groupby('pclass')['age'].transform('mean'))

# 'sex' 열을 숫자로 변환 (female: 0, male: 1)
# (이전에 중복 실행 오류가 있었던 부분을 여기 한 번만 실행되도록 최종 확정)
titanic['sex'] = titanic['sex'].map({'female': 0, 'male': 1})

# ========================================================================================================================================================


# ========================================================================================================================================================
# 그리드/랜덤 서치를 통한 최적의 파라미터 찾기

## 데이터 셋을 훈련/테스트 셋으로 나누기
data = titanic[['pclass', 'sex', 'age', 'sibsp', 'parch', 'fare']]
target = titanic['survived']

train_input, test_input, train_target, test_target = train_test_split(
    data, target, test_size=0.2, random_state=42)


## -------------- ExtraTrees Grid Search --------------
params_gs = {'n_estimators': [50, 100, 200],
             'max_depth': [5, 10, 15],
             'min_samples_split': [2, 5, 10]}

gs = GridSearchCV(ExtraTreesClassifier(random_state=42), params_gs, n_jobs=-1)
gs.fit(train_input, train_target)

print("-------------- 그리드 서치 (ExtraTrees) --------------")
print('가장 점수가 높은 조합:', gs.best_params_)
print('가장 높은 검증 점수:', gs.best_score_)
et_model = gs.best_estimator_


## -------------- XGBoost Random Search --------------
params_rs = {
    'n_estimators': randint(1000, 3000),
    'max_depth': randint(5, 15),
    'learning_rate': uniform(0.001, 0.15),
    'subsample': uniform(0.6, 0.4),
    'scale_pos_weight': [1, 1.25, 1.5, 1.75, 2.0, 2.25, 2.5] # 불균형 해결 옵션 추가
}

# XGBoost 랜덤 서치 (Accuracy 기준)
rs = RandomizedSearchCV(XGBClassifier(random_state=42, eval_metric='logloss'), 
                        param_distributions=params_rs, n_iter=100, n_jobs=-1, verbose=0, random_state=42)
rs.fit(train_input, train_target)

print("-------------- 랜덤 서치 (XGBoost) --------------")
print('가장 좋은 조합:', rs.best_params_)
print('가장 좋은 조합의 검증 점수:', rs.best_score_)


# ========================================================================================================================================================
# ⭐⭐ 최적의 scale_pos_weight 찾기 (F1-Score 기준으로 최종 적용) ⭐⭐
# ========================================================================================================================================================
print("\n-------------- scale_pos_weight 최적화 (F1-Score 기준) --------------")

# 1. rs.best_params_에서 나머지 최적 파라미터만 추출 (scale_pos_weight 중복 방지)
best_params_no_weight = rs.best_params_.copy()
if 'scale_pos_weight' in best_params_no_weight:
    del best_params_no_weight['scale_pos_weight']

# 2. scale_pos_weight만 별도로 F1-Score를 기준으로 탐색할 그리드 설정
weight_range = [1.0, 1.25, 1.5, 1.75, 2.0, 2.25, 2.5, 2.75, 3.0] 
weight_params = {'scale_pos_weight': weight_range}

f1_scorer = make_scorer(f1_score)
gs_weight = GridSearchCV(XGBClassifier(**best_params_no_weight, random_state=42, n_jobs=-1, eval_metric='logloss'), 
                         weight_params, scoring=f1_scorer, cv=5, n_jobs=-1)
gs_weight.fit(train_input, train_target)

# 3. 최적의 weight 결과 추출 및 최종 모델 적용
optimal_weight = gs_weight.best_params_['scale_pos_weight']
optimal_f1_score = gs_weight.best_score_

print(f"F1-Score 기준 최적의 scale_pos_weight: {optimal_weight}")
print(f"최적의 F1-Score (검증 세트): {optimal_f1_score:.4f}")

# 4. 최종 XGBoost 모델 재설정 및 재학습 (NotFittedError 방지)
xgb_model = XGBClassifier(**best_params_no_weight, 
                          scale_pos_weight=optimal_weight, # F1 최적의 weight 적용
                          random_state=42, 
                          eval_metric='logloss')
xgb_model.fit(train_input, train_target) # ⭐ 학습 필수!

# ========================================================================================================================================================


# ========================================================================================================================================================
# 모델 성능 평가 (ROC 그래프 필수 포함)

## -------------- ExtraTrees 성능 평가 --------------
print("\n-------------- ExtraTrees 성능 평가 --------------")
et_pred = et_model.predict(test_input)
print("\n<Classification Report>")
print(classification_report(test_target, et_pred))

### Confusion Matrix
plt.figure(figsize=(8, 6))
sns.heatmap(confusion_matrix(test_target, et_pred), annot=True, fmt='d', cmap='Blues').set_title('ExtraTrees 혼동 행렬')
plt.show()

### ROC Curve
et_pred_proba = et_model.predict_proba(test_input)[:, 1]
fpr_et, tpr_et, _ = roc_curve(test_target, et_pred_proba)
roc_auc_et = auc(fpr_et, tpr_et)


## -------------- XGBoost 성능 평가 (최적화 완료) --------------
print("\n-------------- XGBoost 성능 평가 (최적화 완료) --------------")
xgb_pred = xgb_model.predict(test_input)
print("\n<Classification Report>")
print(classification_report(test_target, xgb_pred))

### Confusion Matrix
plt.figure(figsize=(8, 6))
sns.heatmap(confusion_matrix(test_target, xgb_pred), annot=True, fmt='d', cmap='Blues').set_title('XGBoost 혼동 행렬')
plt.show()

### ROC Curve
xgb_pred_proba = xgb_model.predict_proba(test_input)[:, 1]
fpr_xgb, tpr_xgb, _ = roc_curve(test_target, xgb_pred_proba)
roc_auc_xgb = auc(fpr_xgb, tpr_xgb)


## -------------- 두 모델 ROC Curve 비교 --------------
plt.figure(figsize=(10, 8))

plt.plot(fpr_et, tpr_et, lw=2, label=f'ExtraTrees ROC 곡선 (면적 = {roc_auc_et:0.2f})')
plt.plot(fpr_xgb, tpr_xgb, lw=2, label=f'XGBoost ROC 곡선 (면적 = {roc_auc_xgb:0.2f})')
plt.plot([0, 1], [0, 1], color='navy', lw=2, linestyle='--') # 랜덤 성능 (0.50)

plt.xlim([0.0, 1.0])
plt.ylim([0.0, 1.05])
plt.xlabel('FPR (위양성률)')
plt.ylabel('TPR (재현율)')
plt.title('ROC 곡선 비교')
plt.legend(loc="lower right")
plt.show()
# ========================================================================================================================================================