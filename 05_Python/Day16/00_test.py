import seaborn as sns
import pandas as pd

pd.set_option('display.unicode.east_asian_width', True)


# 1.  Seaborn의 titanic 데이터셋을 불러와 titanic 변수에 저장하시오.
print()
print("--------------- 1번 문제 ---------------")
print()

titanic = sns.load_dataset('titanic')

print(titanic)
print()


# 2.  Titanic 데이터의 기본 정보를 조회하시오
print()
print("--------------- 2번 문제 ---------------")
print()

print(titanic.info())
print()


# 3.  Titanic 데이터의 행과 열 개수를 조회하고, 몇 차원 배열인지 조회하시오
print()
print("--------------- 3번 문제 ---------------")
print()

print(f"{titanic.shape[0]}, {titanic.shape[1]}개의 행과 열")
print(titanic.ndim, '차원 배열')
print()


# 4.  첫 3행과 마지막 2행을 조회하시오
print()
print("--------------- 4번 문제 ---------------")
print()

print(titanic.head(3))
print()
print(titanic.tail(2))
print()




# 5.  loc을 사용해 첫 5행에서 열 ['survived','pclass','sex','age']만을 가진 데이터프레임 df_loc을 만들고, 출력하시오.
print()
print("--------------- 5번 문제 ---------------")
print()

df_loc = titanic.loc[:,['survived','pclass','sex','age']].head()
print(df_loc)


# 6.  iloc을 사용해 행 10~14(포함), 열 0~3(포함)을 추출해 df_iloc에 저장하고, 출력하시오.
print()
print("--------------- 6번 문제 ---------------")
print()

df_iloc = titanic.iloc[10:15, 0:4]
print(df_iloc)
print()




# 7.  원본을 훼손하지 않고(inplace=False) titanic에서 열 ['deck','embark_town']을 드랍한 새 데이터프레임 df_drop_cols를 만드시오.
print()
print("--------------- 7번 문제 ---------------")
print()

df_drop_cols = titanic.drop(columns=['deck','embark_town'], inplace=False)
print(df_drop_cols)
print()


# 8.  결측치가 하나라도 있는 행을 드랍한 데이터프레임 df_dropna_rows를 만드시오.
print()
print("--------------- 8번 문제 ---------------")
print()

df_dropna_rows = titanic.dropna(axis=0)
print(df_dropna_rows)
print()




# 9.  각 열별 결측치 개수를 Series로 구하시오.
print()
print("--------------- 9번 문제 ---------------")
print()

print(titanic.isnull().sum())
print()


# 10.  age 열의 결측치 개수만 따로 출력하시오.
print()
print("--------------- 10번 문제 ---------------")
print()

print(f"age 열의 결측치 개수: {titanic['age'].isnull().sum()} 개")
print()




# 11.  age 열의 평균값으로 해당 열의 결측치를 대체한 새로운 시리즈 age_filled를 만드시오(원본 불변).
print()
print("--------------- 11번 문제 ---------------")
print()

age_filled = titanic['age'].fillna(titanic['age'].mean(), inplace=False)
print(age_filled)
print()


# 12.  대체 전후 age의 결측치 개수를 각각 출력하여 비교하시오.
print()
print("--------------- 12번 문제 ---------------")
print()

print(f"대체 전 : {titanic['age'].isnull().sum()} 개 / 대체 후 : {age_filled.isnull().sum()} 개")
print()




# 13.  embarked 열의 최빈값을 describe() 결과로 확인하시오.
print()
print("--------------- 13번 문제 ---------------")
print()

print(f"최빈값 : {titanic['embarked'].describe()['top']}")
print()


# 14.  그 최빈값으로 embarked의 결측치를 대체한 embarked_filled 시리즈를 만드시오(원본 불변).
print()
print("--------------- 14번 문제 ---------------")
print()

topT = titanic['embarked'].mode()[0]
embarked_filled = titanic['embarked'].fillna(topT, inplace=False)

print(embarked_filled)
print()



# 15.  수치형 열 중 ['age','fare']만 선택하여 0~1 범위로 Min-Max 스케일링한 데이터프레임 df_scaled를 만드시오(사전 결측 대체 필요 시 적절히 처리).
print()
print("--------------- 15번 문제 ---------------")
print()

from sklearn.preprocessing import MinMaxScaler

scaler = MinMaxScaler()

df_scaled = titanic.fillna(titanic[['age','fare']].mean(), inplace=False) # 결측치 먼저 처리
df_scaled = scaler.fit_transform(df_scaled[['age','fare']])
df_scaled = pd.DataFrame(df_scaled, columns=['age','fare'])

print(df_scaled)
print()


# 16.  스케일링 후 각 열의 최소/최대가 0과 1에 가깝게 되었는지 describe()로 확인하시오.
print()
print("--------------- 16번 문제 ---------------")
print()

print(df_scaled.describe().T)
print()




# 17.  age를 기준으로 아동(0 ~ 12), 청소년(13 ~ 18) 성인(19 ~ 60), 노인(61 ~ 100) 4구간으로 나누어 새 열 age_bin 을 생성하시오.
print()
print("--------------- 17번 문제 ---------------")
print()

bins = [0, 12, 18, 60, 100]
labels = ['아동', '청소년', '성인', '노인']
titanic = titanic.fillna({'age': titanic['age'].mean()}) # 결측치 처리 (mean으로 통합)
titanic['age_bin'] = pd.cut(titanic['age'], bins=bins, labels=labels)
print(titanic[['age', 'age_bin']])
print()


# 18.  각 구간별 인원수를 구하시오.
print()
print("--------------- 18번 문제 ---------------")
print()

print(titanic['age_bin'].value_counts())
print()




# 19.  pclass와 sex로 그룹화하여 survived의 평균 생존율을 구하시오.
print()
print("--------------- 19번 문제 ---------------")
print()

survived_sp = titanic.groupby(['pclass', 'sex'])['survived'].mean().round(3)
print(survived_sp)
print()


# 20.  위 결과를 생존율 내림차순으로 정렬하시오.
print()
print("--------------- 20번 문제 ---------------")
print()

print(survived_sp.sort_values(ascending=False))
print()


# 21.  age_bin(문항17)과 sex로 그룹화하여 fare의 중앙값을 구하시오.
print()
print("--------------- 21번 문제 ---------------")
print()

fareMedian = titanic.groupby(['age_bin', 'sex'])['fare'].median()
print(fareMedian)
print()