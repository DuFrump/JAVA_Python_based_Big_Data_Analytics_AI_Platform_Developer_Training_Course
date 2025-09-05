import pandas as pd

df = pd.read_csv('./Day13/data/stock-data.csv')

df['new_Date'] = pd.to_datetime(df['Date'])
print(df.head())
print()
df.info()
print()