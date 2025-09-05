import pandas as pd

df = pd.read_csv('./Day13/data/stock-data.csv')

df['new_Date'] = pd.to_datetime(df['Date'])

print(df)

# new_Date 를 인덱스로
# 6/1 이 처음으로 오도록.
# Date 칼럼은 버리자!

print(df[df.index < '2018-06-05'])

# ---------------------------------------------------------------------------------------