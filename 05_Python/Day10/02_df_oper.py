import numpy as np
import matplotlib as mp
import pandas as pd
import seaborn as sns

pd.set_option('display.unicode.east_asian_width', True)
pd.set_option('display.max_columns', None)
pd.set_option('display.max_rows', 200)
pd.set_option('display.width', 200)

# 타이타닉 데이터 불러오기

titanic = sns.load_dataset('titanic')
print(titanic.head(100))
titanic.info()
print() 

'''
--------- 타이타닉 데이터 속성 ---------
survived      생 1 사 0
pclass        선실 등급 (숫자형)
sex           성별
age           나이
sibsp         함께 탑승한 형제/자매 수
parch         함께 탑승한 부모/자녀 수
fare          운행비
embarked      탑승 항구 (C = Cherbourg, Q = Queenstown, S = Southampton)
class         선실 등급 (문자형)
who           승객 구분 (성별)
adult_male    성인 남성 구분 (T, F)
deck          선실 위치
embark_town   탑승 도시 이름 (Cherbourg, Queenstown, Southampton)
alive         생존 여부 (y, n)
alone         개인 고객 여부 (T, F)
--------------------------------------
'''

df = titanic.loc[:, ['age', 'fare']]
print(df.head(10))
print()


print()
print("----- 데이터 프레임에 숫자 연산 -----")
print()

addition = df + 10
print(addition.head())



print()
print("----- 데이터 프레임끼리 연산 -----")
print()

print(df.tail())
print()
print(addition.tail())
print()

subtraction = df - addition
print(subtraction.tail())
print()

# NaN 값 채우기
sample1 = subtraction.tail().fillna(0)
print(sample1)
print()
sample1.info()
print()

print(df.tail())
print()
print(addition.tail())
print()

# 양 쪽 모두 NaN 이여서 fill_value 안됨.
sample2 = df.sub(addition, fill_value=0)
print(sample2.tail())
print()
sample2.info()
print()

print(titanic.head())
print()
titanic.info()

titanic = titanic.fillna(0)
print()
titanic.info() 