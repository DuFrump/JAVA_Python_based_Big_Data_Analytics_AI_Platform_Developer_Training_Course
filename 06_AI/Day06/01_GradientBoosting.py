# 그라디언트 부스팅
# 히스토그램 기반 그라디언트 부스팅 (데이터 변수를 구간으로 나눔! - 분할 조건 빨리 찾기)

# <비슷한 알고리즘> - GB 기반 알고리즘 3대장!
# (히스토그램 기반 가능)
# XGBoost - GB를 기반으로 해서 화려한 옵션 (덜 빠르지만 깊이가 깊은 모델)
# lightGBM - XGBoost 경량화 버전 (빠르지만 깊이감이 얕은 모델)
# CatBoost - 범주형 처리에 특화 (범주 전처리 안 해도 됨!)

# XGBoost
import numpy as np
import pandas as pd
from sklearn.model_selection import train_test_split

wine = pd.read_csv('https://bit.ly/wine_csv_data')

data = wine[['alcohol', 'sugar', 'pH']]
target = wine['class']

train_input, test_input, train_target, test_target = train_test_split(data, target, test_size=0.2, random_state=42)

# ------------------------------------------------------------------------------------------------------------------

# 그라디언트 부스팅 모델

from sklearn.ensemble import GradientBoostingClassifier
from sklearn.model_selection import cross_validate

gb = GradientBoostingClassifier(random_state=42)
# 교차 검증
scores = cross_validate(gb, train_input, train_target, return_train_score=True, n_jobs=-1)

print(np.mean(scores['train_score']), np.mean(scores['test_score']))


# 옵션 설정해보기
gb = GradientBoostingClassifier(n_estimators=500, learning_rate=0.2, random_state=42)
# 교차 검증
scores = cross_validate(gb, train_input, train_target, return_train_score=True, n_jobs=-1)

print(np.mean(scores['train_score']), np.mean(scores['test_score']))

# 학습
gb.fit(train_input, train_target)

# 스코어
print(gb.score(train_input, train_target))
print(gb.score(test_input, test_target))

# 특성 중요도
print(gb.feature_importances_)


# 히스토그램 기반 GB 모델

from sklearn.ensemble import HistGradientBoostingClassifier

hgb = HistGradientBoostingClassifier(random_state=42)
# 교차 검증
scores = cross_validate(hgb, train_input, train_target, return_train_score=True, n_jobs=-1)

print(np.mean(scores['train_score']), np.mean(scores['test_score']))

# 학습
hgb.fit(train_input, train_target)

# 학습 이후 스코어
print(hgb.score(train_input, train_target))
print(hgb.score(test_input, test_target))