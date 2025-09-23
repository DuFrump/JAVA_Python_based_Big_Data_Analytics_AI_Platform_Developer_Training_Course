import pandas as pd

fish = pd.read_csv('https://bit.ly/fish_csv_data')
print(fish.head())
print()

# fish.to_csv('./data/fish_data.csv', index=False) 
# 저장 하고 싶으면 실행 한번 하세요

# 물고기 종류 확인 (7개)
print(pd.unique(fish['Species']))
print()

'''
'Bream' 'Roach' 'Whitefish' 'Parkki' 'Perch' 'Pike' 'Smelt'
참붕어 붉은줄납줄개  백어      파르키    농어   가시고기   빙어
'''

# 인풋 데이터
fish_input = fish[['Weight', 'Length', 'Diagonal', 'Height', 'Width']]

print(fish_input.head())
print()

# 타겟 데이터
fish_target = fish['Species']

# 훈련/테스트 셋 분리 (디폴트 몇대몇? 75:25)
from sklearn.model_selection import train_test_split

train_input, test_input, train_target, test_target = train_test_split(
    fish_input, fish_target, random_state=42)

# 스케일링(표준화)
from sklearn.preprocessing import StandardScaler

ss = StandardScaler()
ss.fit(train_input)
train_scaled = ss.transform(train_input)
test_scaled = ss.transform(test_input)

# 최근접 이웃으로 분류하기
from sklearn.neighbors import KNeighborsClassifier

kn = KNeighborsClassifier(n_neighbors=3)
kn.fit(train_scaled, train_target)

print('최근접 이웃 훈련/테스트 스코어')
print(kn.score(train_scaled, train_target))
print(kn.score(test_scaled, test_target))
print()

# 타켓값 출력
print('최근접 이웃 타깃값 출력')
print(kn.classes_)
print()

print('상위 5개 행 예측')
print(kn.predict(test_scaled[:5]))
print()

import numpy as np

# 클래스별 확률 출력
proba = kn.predict_proba(test_scaled[:5])
print(np.round(proba, decimals=4))
print()

# --------------- 로지스틱 리그레션 ---------------

import matplotlib.pyplot as plt

# 시그모이드 함수 만들어보기
# 특징 - 0에서 1 사이

z = np.arange(-5, 5, 0.1)
phi = 1 / (1 + np.exp(-z))

plt.plot(z, phi)
plt.xlabel('z')
plt.ylabel('phi')
plt.show()


# -------------------- 넘피 배열의 불리언 인덱싱 --------------------

char_arr = np.array(['A', 'B', 'C', 'D', 'E'])

print(char_arr[[True, False, True, False, False]])
print()

# 브림, 스멜트만 필터링 (조건)
bream_smelt_indexes = (train_target == 'Bream') | (train_target == 'Smelt')
# 필터링 조건 적용 (훈련 인풋)
train_bream_smelt = train_scaled[bream_smelt_indexes]
# 필터링 조건 적용 (훈련 타겟)
target_bream_smelt = train_target[bream_smelt_indexes]

print('훈련 데이터')
print(train_bream_smelt)
print()
print('훈련 타겟 데이터')
print(target_bream_smelt)
print()


# Logistic Regression
from sklearn.linear_model import LogisticRegression

# 훈련
lr = LogisticRegression()
lr.fit(train_bream_smelt, target_bream_smelt)

print('LR 상위 5개 행 예측')
print(lr.predict(train_bream_smelt[:5]))
print()

print('LR 상위 5행 예측의 확률')
proba = lr.predict_proba(train_bream_smelt[:5])
print(proba.round(4))
print()

print('LR 클래스 확인')
print(lr.classes_)
print()

print('파라미터 확인 ((가중치, 편향))')
print(lr.coef_)
print(lr.intercept_)
print()


# z 값 뽑아보기 (시그모이드 통과 전 값)
decisions = lr.decision_function(train_bream_smelt[:5])
print(decisions)

from scipy.special import expit # 시그모이드 함수

print('상위 5행 시그모이드 값 - 양성(1)일 확률')
print(expit(decisions))
print()