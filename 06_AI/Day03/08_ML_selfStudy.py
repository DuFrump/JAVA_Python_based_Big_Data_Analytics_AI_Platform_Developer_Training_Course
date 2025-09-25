import pandas as pd
import numpy as np
import seaborn as sns

# ----------------------------------------------------
dataset = pd.read_csv("./Day03/data/LungCancer.csv")

print(dataset.head())
print()
dataset.info()
print()
# ----------------------------------------------------

# ----------------------------------------------------
# 1. 인풋 데이터 분리 및 전처리
input_data_cat = dataset[['age', 'gender', 'smoking_status']]

# gender는 더미 변수로 변환 (bool 타입, 0과 1)
gender_dummies = pd.get_dummies(input_data_cat['gender'])
print("1. gender 더미 데이터")
print(gender_dummies)
print("-----------------------")

from sklearn.preprocessing import LabelEncoder

# smoking_status와 cancer_stage는 1부터 시작하는 정수형으로 변환
le = LabelEncoder()
smoking_encoded = le.fit_transform(input_data_cat['smoking_status']) + 1
smoking_unpack = le.inverse_transform(smoking_encoded - 1)

# 원본 input_data1에 결합
input_data1 = pd.concat([dataset['age'], gender_dummies], axis=1)
input_data1['smoking_status_encoded'] = smoking_encoded

# 2. 타겟 데이터 분리 및 전처리
target_data1 = dataset[['cancer_stage']]
# cancer_stage를 1부터 시작하는 정수형으로 변환
target_encoder = LabelEncoder()
target_data = target_encoder.fit_transform(target_data1) + 1
print("2. cancer_stage 인코딩")
print(target_data)
print("-----------------------")

# 최종 인풋 데이터 확인
print("최종 인풋 데이터 info()")
input_data1.info()
print("-----------------------")
print("최종 인풋 데이터 head()")
print(input_data1.head())
print("-----------------------")
# ----------------------------------------------------


# ----------------------------------------------------
# 훈련/테스트 데이터 세트 분리
from sklearn.model_selection import train_test_split

train_input, test_input, train_target, test_target = train_test_split(input_data1, target_data, random_state=42)
# ----------------------------------------------------


# ----------------------------------------------------
# 로지스틱 리그레션
from sklearn.linear_model import LogisticRegression

# !!옵션 값 들어가는 부분!!
lr = LogisticRegression(max_iter=1000)
lr.fit(train_input, train_target)

print()
print("------------------- 규제 기본 값 -------------------")
default_C = LogisticRegression().C
default_maxiter = LogisticRegression().max_iter
print(default_C)
print(default_maxiter)
print()

print()
print("------------------- 규제 그래프 -------------------")
import matplotlib.pyplot as plt 

train_score = []
test_score = []

C_list = [0.001, 0.01, 0.1, 1, 10, 100, 1000]

for C in C_list:
    lr = LogisticRegression(C=C)
    lr.fit(train_input, train_target)
    train_score.append(lr.score(train_input, train_target))
    test_score.append(lr.score(test_input, test_target))

plt.plot(C_list, train_score, label='train')
plt.plot(C_list, test_score, label='test')
plt.xscale('log')
plt.xlabel('C')
plt.ylabel('R^2')
plt.legend()
plt.show()

train_score_iter = []
test_score_iter = []

max_iter_list = [1, 10, 100, 1000, 10000]

for maxIter in max_iter_list:
    lr = LogisticRegression(max_iter=maxIter)
    lr.fit(train_input, train_target)
    train_score_iter.append(lr.score(train_input, train_target))
    test_score_iter.append(lr.score(test_input, test_target))

plt.plot(max_iter_list, train_score_iter, label='train')
plt.plot(max_iter_list, test_score_iter, label='test')
plt.xscale('log')
plt.xlabel('max_iter')
plt.ylabel('R^2')
plt.legend()
plt.show()  
# ----------------------------------------------------


# ----------------------------------------------------
print()
print('------------- 결과창 -------------')
print()

print('트레인/테스트 스코어')
print(lr.score(train_input, train_target))
print(lr.score(test_input, test_target))
print()

print('LR 상위 5개 행 예측')
print(lr.predict(test_input[:5]))
print()

print('LR 상위 5행 예측의 확률')
proba = lr.predict_proba(test_input[:5])
print(proba.round(4))
print()

print('LR 클래스 확인')
print(lr.classes_)
print(target_encoder.classes_)
print()

print('파라미터 확인 ((가중치, 편향))')
print(lr.coef_)
print(lr.intercept_)
print()
# ----------------------------------------------------


# ----------------------------------------------------
from sklearn.ensemble import ExtraTreesClassifier
from sklearn.model_selection import cross_validate

et = ExtraTreesClassifier(n_jobs=-1, random_state=42)
score = cross_validate(et, train_input, train_target, return_train_score=True, n_jobs=-1)

print()
print(np.mean(score['train_score']), np.mean(score['test_score']))
print()

et.fit(train_input, train_target)
print(et.feature_importances_)
print()

print('테스트 스코어')
print(et.score(test_input, test_target))
# ----------------------------------------------------


# ----------------------------------------------------
# XGBoost를 이용해 학습시켜보기

from xgboost import XGBRegressor
from sklearn.model_selection import RandomizedSearchCV
from scipy.stats import uniform, randint

params = {'n_estimators': randint(low=100, high=500),
          'max_depth': randint(low=3, high=10),
          'learning_rate': uniform(0.01, 0.2),
          'subsample': uniform(0.6, 0.4),
          'colsample_bytree': uniform(0.6, 0.4)}

xgb_rscv = RandomizedSearchCV(
    XGBRegressor(n_jobs=-1, random_state=42), 
    param_distributions=params, 
    n_iter=50, 
    cv=5,
    n_jobs=-1, 
    random_state=42,
    verbose=2
)

# 최적화 실행
xgb_rscv.fit(train_input, train_target)

# 결과 출력
print()
print()
print("-------------------------------------------------")
print('가장 점수가 높은 조합 (XGBoost):')
print(xgb_rscv.best_params_)
print()

print('가장 높은 검증 스코어 (R^2):')
print(xgb_rscv.best_score_)
print()

# 4. 최종 모델을 사용하여 테스트 세트 평가
best_xgb = xgb_rscv.best_estimator_
print('최적화된 XGBoost의 테스트 스코어:')
print()
print(best_xgb.score(test_input, test_target))
print("-------------------------------------------------")
# ----------------------------------------------------