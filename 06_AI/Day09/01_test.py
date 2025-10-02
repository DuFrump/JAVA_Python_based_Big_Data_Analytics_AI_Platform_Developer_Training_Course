'''
머신러닝 분류모델 학습 코드를 작성하시오.

=======================================

타이타닉 데이터를 이용하여,
수업시간에 배운 머신러닝 모델 2가지를 학습 시킨뒤,
성능을 비교/평가하세요.

<코드>
전처리 및 간단한 시각화
최적의 하이퍼 파라미터를 찾기 위한 그리드 서치 시행
다양한 성능평가시 ROC 그래프 필수 포함


코드를 완성하고 결과를 ppt에 정리하세요. (사진 + 설명)

<ppt>
데이터 전처리를 왜 그렇게 하엿는지 이유를 상세히 기술하세요.
각종 시각화, 그래프, 터미널 출력화면 등 이미지 삽입 (+ 설명)
발표용이 아닌 채점용이므로 디자인은 하지 않아도 됩니다.

!! 수업시간에 배운 내용들로 하세요 !!

=======================================

<제출>
홍길동.py
홍길동.pptx

위 두 파일을 압축하지 말고 디스코드 메세지로 보내 주세요.
(TMS 업로드는 10/13 에 진행 예정)

=======================================

평가 - 오전
수업 - 오후1
면담 & 프로젝트 팀 발표 - 오후2 
'''

# ========================================================================================================================================================
import numpy as np
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

# 한글 폰트 설정
plt.rcParams['font.family'] ='Malgun Gothic'
plt.rcParams['axes.unicode_minus'] =False

# 데이터 셋 불러오기
titanic = sns.load_dataset('titanic')
# ========================================================================================================================================================



# ========================================================================================================================================================
# 타이타닉 데이터 전처리 및 시각화 작업
## 불필요한 컬럼 제거 (탑승 위치 / deck / alive / alone / adult_male / who / class ...)
titanic = titanic.drop(['embarked', 'class', 'who', 'adult_male', 'deck', 'embark_town', 'alive', 'alone'], axis=1)

## Null 값 채우기
### (현재 남아있는 컬럼 중 Null 값을 가지고 있는 컬럼은 age 밖에 없고, age 컬럼의 Null 값은 pclass를 기준으로 그룹을 나누어 각 그룹의 나이 평균값을 넣기)
titanic['age'] = titanic['age'].fillna(titanic.groupby('pclass')['age'].transform('mean'))

### Null 값 전처리 확인 하기
titanic.info()
print()

## 해당 데이터 셋을 이용한 시각화 작업
### 생존자/사망자 수 시각화
sns.countplot(x='survived', data=titanic)
plt.title('생존자/사망자 수 (사망: 0 / 생존: 1)')
plt.show()

### 성별에 따른 생존자/사망자 수 시각화
sns.countplot(x='sex', hue='survived', data=titanic)
plt.title('성별에 따른 생존자/사망자 수')
plt.show()

### 객실 등급에 따른 생존자/사망자 수 시각화
sns.countplot(x='pclass', hue='survived', data=titanic)
plt.title('객실 등급에 따른 생존자/사망자 수')
plt.show()

### 나이 분포에 따른 생존자/사망자 수 시각화
sns.histplot(data=titanic, x='age', hue='survived', kde=True)
plt.title('나이 분포에 따른 생존자/사망자 수')
plt.show()

### 요금 분포에 따른 생존자/사망자 수 시각화
sns.histplot(data=titanic, x='fare', hue='survived', kde=True)
plt.title('요금 분포에 따른 생존자/사망자 수')
plt.show()

### 상관관계 히트맵
## 'sex' 열을 숫자로 변환 (female: 0, male: 1) // male, female로 되어있어서, 학습이 불가능
titanic['sex'] = titanic['sex'].map({'female': 0, 'male': 1})
plt.figure(figsize=(10, 8))
sns.heatmap(titanic.corr(), annot=True, cmap='coolwarm')
plt.title('상관관계 히트맵')
plt.show()

## 전처리 확인하기
titanic.info()
print()
# ========================================================================================================================================================



# ========================================================================================================================================================
# 그리드 서치를 통한 최적의 파라미터 찾기

## 데이터 셋을 훈련/테스트 셋으로 나누기
from sklearn.model_selection import train_test_split

data = titanic[['pclass', 'sex', 'age', 'sibsp', 'parch', 'fare']]
target = titanic['survived']

train_input, test_input, train_target, test_target = train_test_split(data, target, test_size=0.2, random_state=42)


## -------------- 그리드 서치 (ExtraTrees) --------------
from sklearn.ensemble import ExtraTreesClassifier
from sklearn.model_selection import GridSearchCV

params_gs = {'n_estimators': [50, 100, 200],
          'max_depth': [5, 10, 15],
          'min_samples_split': [2, 5, 10]}

gs = GridSearchCV(ExtraTreesClassifier(random_state=42), params_gs, n_jobs=-1)
gs.fit(train_input, train_target)

print("-------------- 그리드 서치 (ExtraTrees) --------------")
print('가장 점수가 높은 조합:', gs.best_params_)
print('가장 높은 검증 점수:', gs.best_score_)

et_model = gs.best_estimator_
print('그리드 서치 종료 후 훈련 셋 스코어:', et_model.score(train_input, train_target))
print('그리드 서치 종료 후 테스트 셋 스코어:', et_model.score(test_input, test_target))
print()


## -------------- 랜덤 서치 (XGBoost) --------------
from xgboost import XGBClassifier
from sklearn.model_selection import RandomizedSearchCV
from scipy.stats import uniform, randint

params_rs = {
    'n_estimators': randint(1000, 3000),
    'max_depth': randint(5, 15),
    'learning_rate': uniform(0.001, 0.15),
    'subsample': uniform(0.6, 0.4),
    'scale_pos_weight': [1.8, 1.9, 2.0, 2.1, 2.2]
}

rs = RandomizedSearchCV(XGBClassifier(random_state=42, eval_metric='logloss'), param_distributions=params_rs, n_iter=100, n_jobs=-1, verbose=2, random_state=42)
rs.fit(train_input, train_target)

print("-------------- 랜덤 서치 (XGBoost) --------------")
print('가장 좋은 조합:', rs.best_params_)
print('가장 좋은 조합의 검증 점수:', rs.best_score_)

xgb_model = rs.best_estimator_
print('랜덤 서치 종료 후 훈련 셋 스코어:', xgb_model.score(train_input, train_target))
print('랜덤 서치 종료 후 테스트 셋 스코어:', xgb_model.score(test_input, test_target))
print()


''' (머신 튜닝 이후 찾은 가장 최적의 값)
-------------- 그리드 서치 (ExtraTrees) --------------  
가장 점수가 높은 조합: {'max_depth': 15, 'min_samples_split': 5, 'n_estimators': 100}
가장 높은 검증 점수: 0.8258051807347581
그리드 서치 종료 후 훈련 셋 스코어: 0.9171348314606742
그리드 서치 종료 후 테스트 셋 스코어: 0.8268156424581006

-------------- 랜덤 서치 (XGBoost) --------------
가장 좋은 조합: {'learning_rate': np.float64(0.08186856720009172), 'max_depth': 4, 'n_estimators': 152, 'subsample': np.float64(0.7957811041110252)}
가장 좋은 조합의 검증 점수: 0.8384713877671626
랜덤 서치 종료 후 훈련 셋 스코어: 0.9087078651685393
랜덤 서치 종료 후 테스트 셋 스코어: 0.8212290502793296
'''
# ========================================================================================================================================================



# ========================================================================================================================================================
# 모델 성능 평가 (ROC 그래프 필수 포함)
from sklearn.metrics import classification_report, confusion_matrix, roc_curve, auc

## -------------- ExtraTrees 성능 평가 --------------
print("-------------- ExtraTrees 성능 평가 --------------")
print()
et_pred = et_model.predict(test_input)

### Classification Report
print("<Classification Report>")
print(classification_report(test_target, et_pred))
print()

### Confusion Matrix
plt.figure(figsize=(8, 6))
sns.heatmap(confusion_matrix(test_target, et_pred), annot=True, fmt='d', cmap='Blues')
plt.title('ExtraTrees 혼동 행렬')
plt.xlabel('예측값')
plt.ylabel('실제값')
plt.show()

### ROC Curve
et_pred_proba = et_model.predict_proba(test_input)[:, 1]
fpr, tpr, thresholds = roc_curve(test_target, et_pred_proba)
roc_auc_et = auc(fpr, tpr)

plt.figure(figsize=(8, 6))
plt.plot(fpr, tpr, color='darkorange', lw=2, label=f'ROC 곡선 (면적 = {roc_auc_et:0.2f})')
plt.xlim([0.0, 1.0])
plt.ylim([0.0, 1.05])
plt.xlabel('FPR')
plt.ylabel('TPR')
plt.title('ExtraTrees ROC 곡선')
plt.legend(loc="lower right")
plt.show()


## -------------- XGBoost 성능 평가 --------------
print("-------------- XGBoost 성능 평가 --------------")
print()
xgb_pred = xgb_model.predict(test_input)

### Classification Report
print("<Classification Report>")
print(classification_report(test_target, xgb_pred))
print()

### Confusion Matrix
plt.figure(figsize=(8, 6))
sns.heatmap(confusion_matrix(test_target, xgb_pred), annot=True, fmt='d', cmap='Blues')
plt.title('XGBoost 혼동 행렬')
plt.xlabel('예측값')
plt.ylabel('실제값')
plt.show()

### ROC Curve
xgb_pred_proba = xgb_model.predict_proba(test_input)[:, 1]
fpr, tpr, thresholds = roc_curve(test_target, xgb_pred_proba)
roc_auc_xgb = auc(fpr, tpr)

plt.figure(figsize=(8, 6))
plt.plot(fpr, tpr, color='darkorange', lw=2, label=f'ROC 곡선 (면적 = {roc_auc_xgb:0.2f})')
plt.xlim([0.0, 1.0])
plt.ylim([0.0, 1.05])
plt.xlabel('FPR')
plt.ylabel('TPR')
plt.title('XGBoost ROC 곡선')
plt.legend(loc="lower right")
plt.show()


## -------------- 두 모델 ROC Curve 비교 --------------
plt.figure(figsize=(10, 8))

### ExtraTrees ROC
et_pred_proba = et_model.predict_proba(test_input)[:, 1]
fpr_et, tpr_et, _ = roc_curve(test_target, et_pred_proba)
roc_auc_et = auc(fpr_et, tpr_et)
plt.plot(fpr_et, tpr_et, lw=2, label=f'ExtraTrees ROC 그래프 (면적 = {roc_auc_et:0.2f})')

### XGBoost ROC
xgb_pred_proba = xgb_model.predict_proba(test_input)[:, 1]
fpr_xgb, tpr_xgb, _ = roc_curve(test_target, xgb_pred_proba)
roc_auc_xgb = auc(fpr_xgb, tpr_xgb)
plt.plot(fpr_xgb, tpr_xgb, lw=2, label=f'XGBoost ROC 그래프 (면적 = {roc_auc_xgb:0.2f})')

### Plotting
plt.xlim([0.0, 1.0])
plt.ylim([0.0, 1.05])
plt.xlabel('FPR')
plt.ylabel('TPR')
plt.title('ROC 곡선 비교')
plt.legend(loc="lower right")
plt.show()
# ========================================================================================================================================================