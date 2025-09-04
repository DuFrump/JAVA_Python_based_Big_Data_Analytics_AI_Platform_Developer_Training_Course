import pandas as pd
import numpy as np

pd.set_option('display.unicode.east_asian_width', True)
pd.set_option('display.max_columns', None)
pd.set_option('display.max_rows', 100)


df = pd.read_csv('./Day12/data/auto-mpg.csv', header=None)

df.columns = ['mpg', 'cylinders', 'displacement', 'horsepower', 'weight', 'acceleration', 
              'model year', 'origin', 'name']

# horsepower 열의 누락데이터('?') nan으로 바꾼 뒤 drop 한 다음.
# horsepower 열의 타입을 float으로 변환

df['horsepower'] = df['horsepower'].replace('?', np.nan)
df = df.dropna(subset=['horsepower'], axis=0)
df['horsepower'] = df['horsepower'].astype('float')

df.info()
print()
print(df.head(50))


print()
print('---------- horsepower 구간 나누기 ----------')
print()

# 각 구간에 속하는 데이터 개수(count), 경계값 리스트(bin_dividers) 반환
# ex ) bins=3 으로 하면 세 구간으로 균등 분할
count, bin_dividers = np.histogram(df['horsepower'], bins=3)
print(bin_dividers)
print()
print(count)
print()
print(df.describe())

bin_names = ['저출력', '보통 출력', '고출력']

# pd.cut 함수로 각 데이터를 3개의 bin에 할당
df['hp_bin'] = pd.cut(x=df['horsepower'],
                      bins=bin_dividers,
                      labels=bin_names,
                      include_lowest=True)
print(df)