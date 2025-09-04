# survived  생존여부 (1 / 0)
# pclass    선실 등급 (숫자형)
# sex       성별
# age       나이
# sibsp     함께 탑승한 형제/자매/배우자 수
# parch     함께 탑승함 부모/자녀 수
# fare      탑승요금
# embarked  탑승항구 (C = Cherbourg, Q = Queenstown, S = Southampton)
# class     선실 등급 (문자형)
# who       승객 구분 (man, woman, child)
# adult_male  성인 남성 (True, False)
# deck      선실 위치
# embark_town  탑승도시 이름 (Cherbourg, Queenstown, Southampton)
# alive     생존여부 (yes / no)
# alone     혼자야? (True / False)

import pandas as pd
import seaborn as sns
pd.set_option('display.max_columns', None)
pd.set_option('display.width', 300)
pd.set_option('display.max_rows', 100)

'''
타이타닉 로드하기 (시본)
데이터 구조 확인 
승객의 평균 나이, 평균 요금
age의 결측치를 age의 평균으로 채워 보시고
deck 컬럼 제거
age, parch, class 열만 선택하여 보기
FamiliySize 라는 컬럼에 sibsp + parch + 1(자기자신) (로 해서 총 가족 인원수 컬럼 만들어보기)
IsChild 라는 True/False 컬럼 만들어보기 ( 13살 미만 )
남성과 여성의 평균 나이 비교
id 라는 이름으로 정수 인덱스 주기
'''

# 타이타닉 로드하기 (시본)
df = sns.load_dataset('titanic')

# 데이터 구조 확인 
df.info()
print()
print(df.head())
print()
print(df.tail())
print(df.describe())
print()

# 나이가 80세인 손님의 데이터 가져오기
print(df[df['age'] == 80])
print()

# 승객의 평균 나이, 평균 요금
print(f'평균나이 : {df['age'].mean().round(2)}살')
print()
print('평균요금 : ', df['fare'].mean().round(2))
print()

# age의 결측치를 age의 평균으로 채워 보시고
avg_age = df['age'].mean().round(2)
df['age'] = df['age'].fillna(avg_age)
df.info()
print()

# deck 컬럼 제거
df = df.drop('deck', axis=1)
df.info()
print()

# age, parch, class 열만 선택하여 보기
print(df[['age', 'parch', 'class']].head(20))
print()

# age, parch, class 열만 선택하여 랜덤 추출
print(df[['age', 'parch', 'class']].sample(20))
print()

# FamiliySize 라는 컬럼에 sibsp + parch + 1(자기자신) (로 해서 총 가족 인원수 컬럼 만들어보기)
df['FamilySize'] = df['sibsp'] + df['parch'] + 1
df.info()
print()

# IsChild 라는 True/False 컬럼 만들어보기 ( 13살 미만 )
df['IsChild'] = df['age'] < 13
df.info()
print()
print(df)
print()

# bool 타입의 시리즈를 데이터 []에 넣으면 True에 해당하는 데이터만 필터링
# 남성과 여성의 평균 나이 비교
print('남자 나이 평균: ', round(df[df['sex'] == 'male']['age'].mean(), 2)) 
# 위 코드는 아래 코드와 같음
# df_man = df[df['sex'] == 'male']
# round(df_man['age'].mean(), 2)
print('여자 나이 평균: ', df[df['sex'] == 'female']['age'].mean().round(2))
print()

# id 라는 이름으로 정수 인덱스 주기
print(df)
print()

df = df.reset_index(names='p_id')
print(df)
print()
df = df.set_index('p_id')
print(df)
print()