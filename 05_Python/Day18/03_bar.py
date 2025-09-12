import matplotlib.pyplot as plt
import pandas as pd

from matplotlib import font_manager, rc
font_path = 'C:/Windows/Fonts/malgun.ttf'
font_name = font_manager.FontProperties(fname=font_path).get_name()
rc('font', family=font_name)
plt.rcParams['axes.unicode_minus'] = False
pd.set_option('display.width', 500)

# --------------------------------------------------------------------

df = pd.read_excel('./Day17/data/시도별_전출입_인구수.xlsx')

print(df.head())
print()

df = df.ffill()
print(df.head()) 
print()

# 전출지 = 서울, 전입지 = 서울빼고  -->> 서울을 나간사람들 (네튤농 - 순정)

mask = (df['전출지별'] == '서울특별시') & (df['전입지별'] != '서울특별시')
df_seoul = df[mask]
df_seoul = df_seoul.drop(['전출지별'], axis=1)
df_seoul = df_seoul.rename({'전입지별':'전입지'}, axis=1)
df_seoul = df_seoul.set_index('전입지')
print(df_seoul)
print()

col_years = list(map(str, range(2010, 2018)))
df_4 = df_seoul.loc[['충청남도', '경상북도', '강원도', '전라남도'], col_years]
print(df_4.head())
df_4 = df_4.T

# 스타일 지정
plt.style.use('ggplot')

# 막대 그래프 그리기
df_4.plot(kind='bar', figsize=(16, 8), width=0.5, color=['orange', 'green', 'skyblue', '#004855'])

plt.title('서울 - 지방권 인구 이동', size=20)
plt.xlabel('연도', size=13)
plt.ylabel('인구 수', size=13)

plt.show()