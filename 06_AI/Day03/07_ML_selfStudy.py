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
input_data_cat = dataset[['gender', 'smoking_status', 'cancer_stage']]

# gender는 더미 변수로 변환 (bool 타입, 0과 1)
gender_dummies = pd.get_dummies(input_data_cat['gender'])
print("1. gender 더미 데이터")
print(gender_dummies)
print("-----------------------")

from sklearn.preprocessing import LabelEncoder

# smoking_status와 cancer_stage는 1부터 시작하는 정수형으로 변환
le = LabelEncoder()
smoking_encoded = le.fit_transform(input_data_cat['smoking_status']) + 1
cancer_encoded = le.fit_transform(input_data_cat['cancer_stage']) + 1

smoking_unpack = le.inverse_transform(smoking_encoded - 1)
cancer_unpack = le.inverse_transform(cancer_encoded - 1)

# 원본 input_data1에 결합
input_data1 = pd.concat([dataset['age'], gender_dummies], axis=1)
input_data1['smoking_status_encoded'] = smoking_encoded
input_data1['cancer_stage_encoded'] = cancer_encoded

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
lr = LogisticRegression()
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