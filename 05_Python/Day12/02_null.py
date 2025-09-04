import seaborn as sns

df = sns.load_dataset('titanic')

print(df.isnull().sum(axis=0))
print()

print("---------- 누락 데이터 제거 ----------")
print()

print(df)
print()

# 데이터에 Null 값이 하나라도 있는 row(행)는 다 날림.
df_dropna1 = df.dropna()
df_dropna1.info()
print()

# 데이터에 Null 값이 하나라도 있는 column(열)은 다 날라감
df_dropna2 = df.dropna(axis=1)
df_dropna2.info()
print(df_dropna2)

# 유효한 데이터가 500개 미만이면 열 삭제
df_dropna3 = df.dropna(axis=1, thresh=500)
df_dropna3.info()
print()

# age가 Null 값인 행만 삭제
df_age = df.dropna(subset=['age'], axis=0)
df_age.info()
print()

# age, deck 중 하나라도 Null 값이 있으면 삭제
df_age_deck = df.dropna(subset=['age', 'deck'], axis=0) # how='any'인 상태 (default)
df_age_deck.info()
print()

# age, deck 모두 Null 값이 있으면 삭제
df_age_deck = df.dropna(subset=['age', 'deck'], how='all', axis=0)
df_age_deck.info()
print()


print()
print("---------- age 널 값을 age 평균 값으로 채우기 ----------")
print()

avg_age = df['age'].mean().round(2)
df['age'] = df['age'].fillna(avg_age)

print(df)
print()


print()
print("---------- embark_town (최빈값으로 대체) ----------")
print()

# 숫자형의 통계정보
print(df.describe())
print()

# 문자형의 통계정보
print(df.describe(include=object))
print()

# embark_town의 고유값 별 카운트
most_freq = df['embark_town'].value_counts(dropna=True)
print(most_freq)
print()

# embark_town의 값들 중 가장 빈도 수가 많은 값 (최빈값)
most_freq = df['embark_town'].value_counts(dropna=True).idxmax()
print('최빈값 : ', most_freq)
print()

# embark_town의 값들 중 가장 빈도 수가 많은 값 (최빈값)
# .mode()는 시리즈의 최빈값을 시리즈로 반환
most_freq2 = df['embark_town'].mode()
print(most_freq2)
print()

# embark_town 열의 825 행 부터 830 행 조회
print(df['embark_town'].iloc[825:831])

# embark_town 열의 825 행 부터 830 행 조회.
df_et = df['embark_town'].iloc[825:831]
print(df_et)
print(type(df_et))
print()

df_et1 = df.iloc[820:831]
print(df_et1)
print(type(df_et1))
print()

df_et2 = df.loc[825:830, 'embark_town']
print(df_et2)
print(type(df_et2))
print()

df_et3 = df['embark_town'][820:831]
print(df_et3)
print(type(df_et3))
print()

df_et4 = df.iloc[820:830]['embark_town']
print(df_et4)
print(type(df_et4))
print()

# embark_town 열의 NaN 값을 최빈 값으로 채워 넣기
df['embark_town'] = df['embark_town'].fillna(most_freq)
df['embarked'] = df['embarked'].fillna('S')
df.info()
print()

# NaN 값을 최빈값인 Southampton으로 변경 후 재출력
print(df['embark_town'].iloc[825:831])


print()
print("---------- 근처 값으로 대체 ----------")
print()

df = sns.load_dataset('titanic')

# 데이터프레임 복제하기
df2 = df.copy()

print(df['embark_town'][825:831])
print()

# 이전 행 값으로 넣기
df['embark_town'] = df['embark_town'].ffill()
print(df['embark_town'][825:831])
print()

# 다음 행 값으로 넣기
df2['embark_town'] = df2['embark_town'].bfill()
print(df2['embark_town'][825:831])