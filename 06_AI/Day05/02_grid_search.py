import pandas as pd

wine = pd.read_csv('https://bit.ly/wine_csv_data')

print(wine.head())
print()
wine.info()
print()
print(wine.describe())
print()

data = wine[['alcohol', 'sugar', 'pH']]
target = wine['class']
print(target.unique())
print()

from sklearn.model_selection import train_test_split

# 훈련 - 테스트 나누기
train_input, test_input, train_target, test_target = train_test_split(
    data, target, test_size=0.2, random_state=42)

# 그리드 서치
from sklearn.tree import DecisionTreeClassifier
from sklearn.model_selection import GridSearchCV

params = {'min_impurity_decrease':[0.0001, 0.0002, 0.0003, 0.0004, 0.0005]}

# n_jobs -- CPU 코어 개수 최대
gs = GridSearchCV(DecisionTreeClassifier(random_state=42), params, n_jobs=-1)

# 파라미터를 돌아가며 교차 검증
# 가장 최적의 파라미터 조합 결과가 나오면, 그 조합으로 모델 최종 훈련
gs.fit(train_input, train_target)

# 가장 좋은 모델 객체 조합 받아오기
dt = gs.best_estimator_

print('그리드 서치 종료 후 훈련 셋 스코어')
print(dt.score(train_input, train_target))
print()

print('가장 점수가 높은 조합')
print(gs.best_params_)
print()

print('각 조합에 대한 검증 점수')
print(gs.cv_results_['mean_test_score'])
print()

print('가장 점수가 높은 조합 - 방법 2')
print(gs.cv_results_['params'][gs.best_index_])
print()

import numpy as np
# 여러 파라미터 서치하기
params = {'min_impurity_decrease': np.arange(0.0001, 0.001, 0.0001),
          'max_depth': range(5, 20, 1),
          'min_samples_split': range(2, 100, 10)}

gs = GridSearchCV(DecisionTreeClassifier(random_state=42), params, n_jobs=-1)
gs.fit(train_input, train_target)
# 교차검증 완료

print('가장 점수가 높은 조합')
print(gs.best_params_)
print()

print('가장 높은 검증 점수')
print(np.max(gs.cv_results_['mean_test_score']))
print(gs.best_score_)
print()

# 가장 좋은 모델 객체 조합 받아오기
dt = gs.best_estimator_

print('그리드 서치 종료 후 훈련 셋 스코어')
print(dt.score(train_input, train_target))
print()
print('그리드 서치 종료 후 테스트 셋 스코어')
print(dt.score(test_input, test_target))
print()


# -------------- 랜덤 서치 --------------

from scipy.stats import uniform, randint

params = {'min_impurity_decrease': uniform(0.0001, 0.001),
          'max_depth': randint(20, 50),
          'min_samples_split': randint(2, 25),
          'min_samples_leaf': randint(1, 25)}

from sklearn.model_selection import RandomizedSearchCV

rs = RandomizedSearchCV(DecisionTreeClassifier(random_state=42), params, n_iter=100, n_jobs=-1, random_state=42)
rs.fit(train_input, train_target)

print()
print("-------------- 랜덤 서치 --------------")
print()

print('가장 좋은 조합')
print(rs.best_params_)
print()

print('가장 좋은 조합의 검증 점수')
print(np.max(rs.cv_results_['mean_test_score']))
print(rs.best_score_)
print()

dt = rs.best_estimator_

print('테스트 세트 스코어')
print(dt.score(train_input, train_target)) # A = print(rs.best_score_) <== 이거와 다른 값이 나오는 이유는, A는 교차 검증(세트를 나눠서 스코어를 낸 값의 최대값)이고, line 115는 전체 트레인 세트 값이라서.
print(dt.score(test_input, test_target))