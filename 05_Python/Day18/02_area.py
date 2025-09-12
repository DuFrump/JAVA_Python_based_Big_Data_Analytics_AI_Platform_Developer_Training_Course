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

sr_one = df_seoul.loc['경기도']
print(sr_one)
print()

col_years = list(map(str, range(1970, 2018)))
df_4 = df_seoul.loc[['충청남도', '경상북도', '강원도', '전라남도'], col_years]
print(df_4.head())
print()

df_4 = df_4.T

df_4 = df_4.astype(int)

# 스타일 서식 지정
plt.style.use('ggplot')

# plt.plot(df_4)
df_4.plot(kind='area', stacked=True, alpha=0.5, figsize=(18, 8))

plt.title('서울 -> 타지역 전입 인구 수', size=30)
plt.xlabel('연도', size=20)
plt.ylabel('인구 수', size=20)
plt.legend(fontsize=15)

plt.show()

plt.figure(figsize=(20, 10))
plt.stackplot(df_4.index, df_4.T, alpha=0.2, labels=df_4.columns)
plt.show()


# ---------- 객체를 받아서 해보기 ----------

ax = df_4.plot(kind='area', stacked=True, alpha=0.2, figsize=(20, 10))

ax.set_title('서울 -> 타도시', size=30, color='brown', weight='bold')
ax.set_ylabel('이동 인구 수', size=20, color='#003366')
ax.set_xlabel('연도', size=20, color='#480082')
ax.legend(fontsize=15)
plt.show()


# ----------------------------------------

df = pd.DataFrame({
    'A' : [1, 3, 2, 4],
    'B' : [4, 2, 3, 1],
    'C' : [2, 3, 4, 5]
})

fig, axes = plt.subplots(2, 2, figsize=(10, 8))

# 첫 번째
df['A'].plot(kind='line', ax=axes[0,0], title='Line A')
axes[0, 0].set_title('Line A')
axes[0, 0].set_xlabel('Index')
axes[0, 0].set_ylabel('Value of A')

# 두 번째
df['B'].plot(kind='bar', ax=axes[0,1], title='Bar B')
axes[0, 1].set_title('Bar B')
axes[0, 1].set_xlabel('Index')
axes[0, 1].set_ylabel('Value of B')

# 세 번째
df.plot(kind='scatter', x='A', y='B', ax=axes[1,0], title='Scatter A vs B')
axes[1, 0].set_title('Scatter A vs B')
axes[1, 0].set_xlabel('A')
axes[1, 0].set_ylabel('B')

# 네 번째
df[['A', 'C']].plot(kind='bar', stacked=True, ax=axes[1,1], title='Stacked A & C')
axes[1, 1].set_title('Stacked A & C')
axes[1, 1].set_xlabel('Index')
axes[1, 1].set_ylabel('Values')

plt.tight_layout()
plt.show()