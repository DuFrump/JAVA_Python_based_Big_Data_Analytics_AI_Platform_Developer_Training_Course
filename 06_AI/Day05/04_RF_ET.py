import pandas as pd
from sklearn.datasets import fetch_california_housing
from sklearn.ensemble import RandomForestRegressor, ExtraTreesRegressor
from sklearn.model_selection import train_test_split

# 데이터 불러오기
data = fetch_california_housing()

X = pd.DataFrame(data.data, columns=data.feature_names)
# X = X.drop(['Latitude', 'Longitude'], axis=1) # 연관성 없는 데이터 컬럼 삭제
y = pd.Series(data.target)

print(X.head())
print()
X.info()
print()
print(y.head())
print()


# 훈련/테스트 데이터 분할
train_input, test_input, train_target, test_target = train_test_split(X, y, test_size=0.2, random_state=42)

## 데이터 스케일링 과정
from sklearn.preprocessing import StandardScaler

ss = StandardScaler()
ss.fit(train_input)
train_scaled = ss.transform(train_input)
test_scaled = ss.transform(test_input)


# 모델 정의 (2개 / 랜덤 포레스트 / 엑스트라 트리)
rf = RandomForestRegressor(n_jobs=-1, random_state=42)
et = ExtraTreesRegressor(n_jobs=-1, random_state=42)

## 교차 검증 과정을 거친 최적의 해 찾기
from sklearn.model_selection import cross_validate
import numpy as np

scores_rf = cross_validate(rf, train_scaled, train_target, return_train_score=True, n_jobs=-1)
scores_et = cross_validate(et, train_scaled, train_target, return_train_score=True, n_jobs=-1)

## 5번의 교차 검증에 대한 훈련/검증 스코어 평균
print(np.mean(scores_rf['train_score']), np.mean(scores_rf['test_score']))
print(np.mean(scores_et['train_score']), np.mean(scores_et['test_score']))


# 모델 학습
rf.fit(train_scaled, train_target)
et.fit(train_scaled, train_target)


# 성능 평가
print()
print("------------- rf 성능 평가 -------------")
print(rf.score(train_scaled, train_target))
print(rf.score(test_scaled, test_target))
print()
print("------------- et 성능 평가 -------------")
print(et.score(train_scaled, train_target))
print(et.score(test_scaled, test_target))
print()


######################################################
######################################################

'''
*********** 머신 성능 평가표 ***********
------------- rf 성능 평가 -------------
0.9735650982131013
0.8052747336256919

------------- et 성능 평가 -------------
1.0
0.806195896753786
'''
# 과대 적합 징후가 보이기 때문에 일반화 성능을 강화하는데 목표를 둘 수 있다.
# 1. 파라미터 튜닝
## 그리드 서치 과정 (최적화 된 파라미터 값 찾기)
from sklearn.model_selection import GridSearchCV

params = {
    'n_estimators': [50, 100],
    'max_depth': [None, 10, 20],
    'min_samples_split': [2, 5]
}

gs_rf = GridSearchCV(RandomForestRegressor(n_jobs=-1), params, n_jobs=-1, verbose=2)
gs_et = GridSearchCV(ExtraTreesRegressor(n_jobs=-1), params, n_jobs=-1, verbose=2)

gs_rf.fit(train_scaled, train_target)
gs_et.fit(train_scaled, train_target)

# Grid Search 결과에서 최적 모델 객체 받아오기
dt_rf = gs_rf.best_estimator_
dt_et = gs_et.best_estimator_


print('가장 점수가 높은 조합 (gs_rf)')
print(gs_rf.best_params_)
print('가장 높은 검증 점수 (gs_rf)')
print(gs_rf.best_score_)

print('가장 점수가 높은 조합 (gs_et)')
print(gs_et.best_params_)
print('가장 높은 검증 점수 (gs_et)')
print(gs_et.best_score_)
print()


# 전체 튜닝 이후 성능 평가
print()
print("------------- rf 성능 평가 (최적화 후) -------------")
print(dt_rf.score(train_scaled, train_target)) 
print(dt_rf.score(test_scaled, test_target))  
print()
print("------------- et 성능 평가 (최적화 후) -------------")
print(dt_et.score(train_scaled, train_target))
print(dt_et.score(test_scaled, test_target))
print()



##########################################################
# XGBoost 라이브러리 임포트

from xgboost import XGBRegressor
from sklearn.model_selection import RandomizedSearchCV
from scipy.stats import uniform, randint

# 1. 하이퍼파라미터 탐색 공간 정의
# 'uniform'은 실수 범위, 'randint'는 정수 범위를 무작위로 샘플링합니다.
params = {
    # 트리의 개수: 100개에서 500개 사이의 정수 중 무작위 선택
    'n_estimators': randint(low=100, high=500), 
    
    # 트리의 최대 깊이: 3부터 9까지의 정수 중 무작위 선택 (과대적합 방지)
    'max_depth': randint(low=3, high=10),       
    
    # 학습률: 0.01부터 0.2 사이의 실수 중 무작위 선택
    'learning_rate': uniform(0.01, 0.2),        
    
    # 각 트리가 사용할 데이터 비율: 0.6부터 1.0 사이의 실수 중 무작위 선택
    'subsample': uniform(0.6, 0.4),            
    
    # 각 트리가 사용할 특징(컬럼) 비율: 0.6부터 1.0 사이의 실수 중 무작위 선택
    'colsample_bytree': uniform(0.6, 0.4)      
}

# 2. Randomized Search 객체 생성 및 실행
# n_iter=50: 총 50번의 무작위 조합을 시도 (탐색 횟수)
xgb_rscv = RandomizedSearchCV(
    XGBRegressor(n_jobs=-1, random_state=42), 
    param_distributions=params, 
    n_iter=50, 
    cv=5, # 5-겹 교차 검증 사용
    n_jobs=-1, 
    random_state=42,
    # 회귀 문제이므로 R^2 점수를 사용합니다. (기본값)
)

print("XGBoost Randomized Search 최적화 시작...")

# 최적화 실행
# train_scaled와 train_target은 이전 코드에서 이미 정의되었다고 가정합니다.
xgb_rscv.fit(train_scaled, train_target)

# 3. 결과 출력
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
print(best_xgb.score(test_scaled, test_target))
print("-------------------------------------------------")