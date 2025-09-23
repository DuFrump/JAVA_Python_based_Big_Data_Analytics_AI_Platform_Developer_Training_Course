import pandas as pd
import seaborn as sns

# ----------------------------------------------------
titanic = sns.load_dataset('titanic')

print(titanic.head())
print()
titanic.info()
print()
# ----------------------------------------------------


# ----------------------------------------------------
# 전처리 과정 및 데이터 분리

# 'Age' 열의 NaN 값 제외하기
titanic.dropna(subset=['age'], inplace=True)

# 인풋 데이터 분리
input_data = titanic[['sex', 'age', 'pclass']]
print('----------------------------')
input_data.info()
print('----------------------------')
# input_data에 있는 문자열 열을 숫자로 변환
input_data = pd.get_dummies(input_data, columns=['sex'])

# 타겟 데이터 분리
target_data = titanic['survived']
# ----------------------------------------------------


# ----------------------------------------------------
# 훈련/테스트 세트 분리
from sklearn.model_selection import train_test_split

train_input, test_input, train_target, test_target = train_test_split(input_data, target_data, random_state=42)
# ----------------------------------------------------


# ----------------------------------------------------
# 스케일링 (표준화 작업)
from sklearn.preprocessing import StandardScaler

ss = StandardScaler()
ss.fit(train_input)
train_scaled = ss.transform(train_input)
test_scaled = ss.transform(test_input)
# ----------------------------------------------------


# ----------------------------------------------------
# 로지스틱 리그레션
from sklearn.linear_model import LogisticRegression

lr = LogisticRegression(C=0.1)
lr.fit(train_scaled, train_target)

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
    lr.fit(train_scaled, train_target)
    train_score.append(lr.score(train_scaled, train_target))
    test_score.append(lr.score(test_scaled, test_target))

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
    lr.fit(train_scaled, train_target)
    train_score_iter.append(lr.score(train_scaled, train_target))
    test_score_iter.append(lr.score(test_scaled, test_target))

plt.plot(max_iter_list, train_score_iter, label='train')
plt.plot(max_iter_list, test_score_iter, label='test')
plt.xscale('log')
plt.xlabel('max_iter')
plt.ylabel('R^2')
plt.legend()
plt.show()

print()     
# ----------------------------------------------------


# ----------------------------------------------------
print()
print('------------- 결과창 -------------')
print()

print('트레인/테스트 스코어')
print(lr.score(train_scaled, train_target))
print(lr.score(test_scaled, test_target))
print()

print('LR 상위 5개 행 예측')
print(lr.predict(test_scaled[:5]))
print()

print('LR 상위 5행 예측의 확률')
proba = lr.predict_proba(test_scaled[:5])
print(proba.round(4))
print()

print('LR 클래스 확인')
print(lr.classes_)
print()

print('파라미터 확인 ((가중치, 편향))')
print(lr.coef_)
print(lr.intercept_)
print()
# ----------------------------------------------------