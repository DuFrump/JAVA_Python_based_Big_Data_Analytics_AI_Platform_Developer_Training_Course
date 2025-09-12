# ----------------------------------------------------------------------------
import matplotlib.pyplot as plt
import pandas as pd

from matplotlib import font_manager, rc
# 한글 표기
font_path = 'C:/Windows/Fonts/malgun.ttf'
font_name = font_manager.FontProperties(fname=font_path).get_name()
rc('font', family=font_name)
# 음수표기
plt.rcParams['axes.unicode_minus'] = False
# 터미널 너비
pd.set_option('display.width', 500)
pd.set_option('display.unicode.east_asian_width', True)
# ----------------------------------------------------------------------------

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

# ------------ figure만 만들어 놓고 axes만 그때 그때 추가하기 ------------

# fig, axes = plt.subplot(2, 2, figsize=(10,8))
# axes[0, 1].plot(자료, 디자인)
# axes[0, 1].set_title('타이틀')

fig = plt.figure(figsize=(10, 5))

ax = fig.add_subplot(1, 1, 1) # 그래프를 추가하게 되면 (1, 2, 1) 등으로 수정해야함. 
ax.plot(sr_one, marker='o', markerfacecolor='orange', markersize=5, color='olive', linewidth=2, label='서울 -> 경기')
ax.legend()

# y축 범위 (5만 ~ 80만)
ax.set_ylim(50000, 800000)
# 타이틀 '서울 -> 경기 이동 인구', 사이즈 20
ax.set_title('서울 -> 경기 이동 인구', size=20)
# 엑스라벨 '기간', 사이즈 12
ax.set_xlabel('기간', size=12)
# 와이라벨 '이동 인구 수', 사이즈 12
ax.set_ylabel('이동 인구 수', size=12)
# 엑스 눈금 라벨 75도 회전 (5년 단위로 라벨 붙히기)
ax.set_xticks(range(0, len(sr_one.index), 5))
ax.set_xticklabels(sr_one.index[::5], rotation=75, color='magenta')
ax.tick_params(axis='x', labelsize=10, color='salmon', length=10, width=3)

# ax2 = fig.add_subplot(1, 2, 2)
# ax2.plot([1, 2, 3], [4, 5, 6])

plt.show()


# ----------- 여러 그래프 그려보기 add_subplot -----------

# 1970 ~ 2017 문자열 리스트로 뽑아오기
col_years = list(map(str, range(1970, 2018)))
df_3 = df_seoul.loc[['충청남도', '경상북도', '강원도'], col_years]
print(df_3.head())
print()

fig = plt.figure(figsize=(18, 5))
ax = fig.add_subplot(1, 1, 1)

ax.plot(col_years, df_3.loc['충청남도', :], marker='o', markersize=3, color='olive', label='서울 -> 충남')
ax.plot(col_years, df_3.loc['경상북도', :], marker='o', markersize=3, color='skyblue', label='서울 -> 경북')
ax.plot(col_years, df_3.loc['강원도', :], marker='o', markersize=3, color='pink', label='서울 -> 강원')

ax.set_title('서울 -> 충남, 경북, 강원 인구 이동', size=20)
ax.set_xlabel('기간', size=12)
ax.set_ylabel('이동 인구 수', size=12)
# ax.set_xticks(range(0, len(col_years), 5))
ax.set_xticklabels(col_years, rotation=90)
ax.tick_params(axis='x', labelsize=10)
ax.tick_params(axis='y', labelsize=10)

ax.legend()
plt.show()


# ----------- 세 지역을 시리즈로 빼서 만들기 -----------

sr1 = df_seoul.loc['충청남도']
sr2 = df_seoul.loc['경상북도']
sr3 = df_seoul.loc['강원도']

# 도화지 만들어서
fig, ax = plt.subplots(figsize=(18, 5))

ax.plot(sr1, marker='o', markersize=3, color='olive', label='서울 -> 충남')
ax.plot(sr2, marker='o', markersize=3, color='skyblue', label='서울 -> 경북')
ax.plot(sr3, marker='o', markersize=3, color='pink', label='서울 -> 강원')

ax.set_title('서울 -> 충남, 경북, 강원 인구 이동', size=20)
ax.set_xlabel('기간', size=12)
ax.set_ylabel('이동 인구 수', size=12)
ax.set_xticks(range(0, len(col_years), 5))
ax.tick_params(axis='x', labelsize=10)
ax.tick_params(axis='y', labelsize=10)

ax.legend()
plt.show()


# ---------- 4 분할 그래프 ----------

col_years = list(map(str, range(1970, 2018)))
df_3 = df_seoul.loc[['충청남도', '경상북도', '강원도'], col_years]

plt.style.use('ggplot')

fig = plt.figure(figsize=(16, 8))
ax1 = fig.add_subplot(221) # , 생략 가능
ax2 = fig.add_subplot(222)
ax3 = fig.add_subplot(223)
ax4 = fig.add_subplot(224)

sr1 = df_seoul.loc['충청남도']
sr2 = df_seoul.loc['경상북도']
sr3 = df_seoul.loc['강원도']
sr4 = df_seoul.loc['전라남도']

plt.suptitle('서울에서 지방권 인구 이동')

ax1.plot(sr1, marker='o', markersize=3, color='olive', label='서울 -> 충남')
ax1.set_title('서울 -> 충남 인구 이동')
ax2.plot(sr2, marker='o', markersize=3, color='skyblue', label='서울 -> 경북')
ax2.set_title('서울 -> 경북 인구 이동')
ax3.plot(sr3, marker='o', markersize=3, color='pink', label='서울 -> 강원')
ax3.set_title('서울 -> 강원 인구 이동')
ax4.plot(sr4, marker='o', markersize=3, color='purple', label='서울 -> 전남')
ax4.set_title('서울 -> 전남 인구 이동')

for ax in fig.axes:
    ax.set_xlabel('기간', size=12)
    ax.set_ylabel('이동 인구 수', size=12)
    ax.tick_params(axis='x', labelsize=10, rotation=75)
    ax.tick_params(axis='y', labelsize=10)
    ax.legend()
    ax.grid(True)

plt.tight_layout() 
plt.show()