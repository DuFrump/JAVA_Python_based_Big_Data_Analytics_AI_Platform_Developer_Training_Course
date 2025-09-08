import seaborn as sns
import pandas as pd

pd.set_option('display.unicode.east_asian_width', True)

# 엑셀 데이터셋 불러오기
df = pd.read_excel('./Day14/data/주가데이터.xlsx')
print(df.head())
print()

df.info()
print()

# 연, 월, 일 데이터 분리하기
df['연월일'] = df['연월일'].astype('str')
dates = df['연월일'].str.split('-')

print(dates.head())
print()

# 분리된 정보를 각각 새로운 열에 담아서 df에 추가하기
df['연'] = dates.str.get(0)
df['월'] = dates.str.get(1)
df['일'] = dates.str.get(2)

print(df.head())
print()

# expand 옵션
df_expand = df['연월일'].str.split('-', expand=True)
df_expand.columns = ['연', '월', '일']

print(df_expand.head())
print()


# ---------- 타임 스탬프 방법으로 해보기 ----------
df1 = pd.read_excel('./Day14/data/주가데이터.xlsx')
print(df1.head())
print()

df1.info()
print()

df1['new_Date'] = pd.to_datetime(df1['연월일'])

# 연월일 추출
df1['연'] = df1['연월일'].dt.year
df1['월'] = df1['연월일'].dt.month
df1['일'] = df1['연월일'].dt.day
df1['요일'] = df1['연월일'].dt.day_name()

print(df1.head())
print()