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