import pandas as pd
import numpy as np

# 전처리 (auto-mpg.csv) [horsepower]
df = pd.read_csv('./Day13/data/auto-mpg.csv')
df.columns = ['mpg', 'cylinders', 'displacement', 'horsepower', 'weight', 'acceleration', 
              'model year', 'origin', 'name']

df.info()
print()
print(df)


# 누락 데이터 확인하기
print(df[df['horsepower'] == '?'])
print()


# 누락 데이터 처리하기 (행을 지우거나, 채워 넣거나)
df['horsepower'] = df['horsepower'].replace('?', np.nan)
df = df.dropna(subset=['horsepower'], axis=0)


# 필요 없는 컬럼 삭제하기
df = df.drop(['cylinders', 'displacement', 'origin', 'weight', 'model year'], axis=1)
print(df)
print()


# 단위 변환
df['horsepower'] = df['horsepower'].astype('float')
df.info()
print()


# 범주 나눠보기 -> 범주별로 인코딩하기
count, bin_dividers = np.histogram(df['horsepower'], bins=3)
print(count)
print()
print(bin_dividers)
print()
print(df.describe())
print()

bin_names = ['저출력', '보통출력', '고출력']

df['hp_bin'] = pd.cut(x=df['horsepower'], bins=bin_dividers, labels=bin_names, include_lowest=True)
print(df)
print()


# 중복행 확인 (및 제거)
from sklearn.preprocessing import OneHotEncoder

encoder = OneHotEncoder(sparse_output=False)
encoded = encoder.fit_transform(df)
encoded_df = pd.DataFrame(encoded, columns=encoder.get_feature_names_out(df.columns))

print(encoded_df)
print('----------------')
print()


# 데이터 스케일링 (minmax, standard)
from sklearn.preprocessing import MinMaxScaler, StandardScaler

df['horsepower_minmax'] = MinMaxScaler().fit_transform(df[['horsepower']])
print(df['horsepower_minmax'])
print()

df['horsepower_standard'] = StandardScaler().fit_transform(df[['horsepower']])
print(df['horsepower_standard'].round(2))
print()