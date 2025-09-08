import pandas as pd
import seaborn as sns

pd.set_option('display.unicode.east_asian_width', True)
pd.set_option('display.max_columns', None)
pd.set_option('display.width', 500)

titanic = sns.load_dataset('titanic')
df = titanic.loc[:, ['age', 'sex', 'class', 'fare', 'survived']]

# class로 groupby
# observed=True -- 데이터, 실제 있는 조합만 만들겠다.
grouped = df.groupby(['class'], observed=True)

print(grouped) # 객체 반환
print()

# 표준 편차 집계
std_all = grouped.std(numeric_only=True)
print(std_all.round(3))
print()

# as_index=False 옵션 달아보기
std_all_index = df.groupby(['class'], observed=True, as_index=False).std(numeric_only=True)
print(std_all_index.round(3))
print()

# 그룹화 후 컬럼 선택
print(std_all['fare'].round(3))
print()

# 그룹화 후(grouped) 컬럼 선택 이후 집계(numeric_only=True)
std_fare = grouped['fare'].std(numeric_only=True)
print(std_fare.round(3))
print()

# 그룹별로 선택된 컬럼들의 집계 결과
std_age_survived = grouped[['age', 'survived']].std(numeric_only=True)
print(std_age_survived.round(3))
print()

# 그룹화 후, describe
print(grouped.describe())
print()

# 그룹에 대한 Null이 아닌 값 집계  
print(grouped[['class', 'sex']].value_counts())
print()

# 비교해보기 1
print(df['class'].value_counts())
print()

# 비교해보기 2
print(df[['class', 'sex']].value_counts())
print()


# ---------- 여러 함수나 컬럼 별 다른 함수를 쓰기 위한 agg 함수 ----------
# 그룹 객체에 aggregate() 메서드 적용
agg_mean = grouped.aggregate('mean', numeric_only=True)
print(agg_mean)
print()

# agg() 함수로도 같은 기능 사용 가능
agg_mean2 = grouped.agg('mean', numeric_only=True)
print(agg_mean2)
print()

# 여러 집계 함수를 적용
agg_all = grouped.agg(['min', 'max'])
print(agg_all)
print()

# 더 구체적으로 적용
agg_sep = grouped.agg({'fare':['min', 'max'], 'age':'mean'})
print(agg_sep)
print()

def min_max(x):
    return x.max() - x.min()

# 각 그룹의 최대값과 최소값의 차이를 계산해서 그룹별로 집계
agg_minmax = grouped[['age', 'fare']].agg(min_max)
print(agg_minmax)
print()