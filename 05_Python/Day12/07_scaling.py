import pandas as pd
import numpy as np

pd.set_option('display.unicode.east_asian_width', True)
pd.set_option('display.max_columns', None)
pd.set_option('display.max_rows', 100)

df = pd.read_csv('./Day12/data/auto-mpg.csv')

df.columns = ['mpg', 'cylinders', 'displacement', 'horsepower', 'weight', 'acceleration', 
              'model year', 'origin', 'name']

df.info()
print()

df['horsepower'] = df['horsepower'].replace('?', np.nan)
df = df.dropna(subset=['horsepower'], axis=0)
df['horsepower'] = df['horsepower'].astype('float')


# ---------------------- Min-Max Scaling ----------------------

print(df['horsepower'].describe().round(2))
print()

# 46 ~ 230 -> 0 ~ 1  // (숫자 - 최솟값) / (최댓값 - 최솟값)
df['horsepower_minmax'] = (df['horsepower'] - df['horsepower'].min()) / (df['horsepower'].max() - df['horsepower'].min())
print(df['horsepower_minmax'].round(2))
print()
print(df['horsepower_minmax'].describe().round(2))
print()

# ---------------------- 사이킷런을 이용한 Min-Max Scaling ----------------------

from sklearn.preprocessing import MinMaxScaler

scaler = MinMaxScaler()
df['horsepower_minmax'] = scaler.fit_transform(df[['horsepower']])
print(df['horsepower_minmax'])
print()


# ---------------------- Standard Scaling ----------------------

# horsepower 열에 Standard Scaling 적용
# 정규화 - 데이터를 평균 0, 표준 편차 1이 되도록 스케일링
# (X - 평균) / 표준편차
df['horsepower_std'] = (df['horsepower'] - df['horsepower'].mean()) / df['horsepower'].std()
print(df['horsepower_std'].head(100))
print()

# ---------------------- 사이킷런을 이용한 Standard Scaling ----------------------

from sklearn.preprocessing import StandardScaler

scaler = StandardScaler()
df['horsepower_standard'] = scaler.fit_transform(df[['horsepower']])
print(df['horsepower_standard'])
print()
