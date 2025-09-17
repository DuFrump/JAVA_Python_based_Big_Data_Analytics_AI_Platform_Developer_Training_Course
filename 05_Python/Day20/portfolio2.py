import pandas as pd
import numpy as np
import seaborn as sns
import matplotlib.pyplot as plt
from matplotlib import font_manager, rc
import os

# --- 1단계: 기본 설정 및 데이터 경로 지정 ---

# 한글 폰트 설정을 위한 경로 지정
font_path = 'C:/Windows/Fonts/malgun.ttf'
font_name = font_manager.FontProperties(fname=font_path).get_name()
rc('font', family=font_name)

# 그래프에서 음수 부호가 깨지지 않도록 설정
plt.rcParams['axes.unicode_minus'] = False

# 터미널에 데이터프레임을 출력할 때 너비와 줄 수를 조절
pd.set_option('display.width', 500)
pd.set_option('display.max_rows', 500)
pd.set_option('display.max_columns', 50)
pd.set_option('display.unicode.east_asian_width', True)

# 데이터 파일이 있는 폴더 경로 설정
DATA_PATH = './Day20/data'

# 분석할 연도 범위 설정
YEARS = [2020, 2021, 2022, 2023, 2024]

# 국가 이름을 통일하기 위한 딕셔너리
COUNTRY_NAME_MAPPING = {
    # WHR 데이터 기준
    "Taiwan Province of China": "Taiwan",
    "Hong Kong S.A.R. of China": "Hong Kong SAR, China",
    "State of Palestine": "West Bank and Gaza",
    "Congo (Brazzaville)": "Congo, Rep.",
    "Congo (Kinshasa)": "Congo, Dem. Rep.",
    "Eswatini, Kingdom of": "Eswatini",
    "North Macedonia": "Macedonia, FYR",
    "Slovakia": "Slovak Republic",
    "Turkiye": "Turkey",
    # 수면 데이터 기준
    "South Korea": "Korea, Rep.",
    "Czech Republic": "Czechia",
    "Hong Kong": "Hong Kong SAR, China",
    "Russia": "Russian Federation",
    "Turkey": "Turkiye",
    "US": "United States",
    "United Kingdom": "United Kingdom",
    "Taiwan": "Taiwan"
}

# --- 2단계: 데이터 불러오기 및 전처리 ---

print("--- 2-1. GDP 데이터 로딩 및 전처리 ---")
# GDP 데이터 불러오기
gdp_file_path = os.path.join(DATA_PATH, 'world_bank_data_25.csv')
df_gdp = pd.read_csv(gdp_file_path)

# 컬럼 이름 변경 ('country_name' -> 'Country name')
df_gdp = df_gdp.rename(columns={'country_name': 'Country name'})

# 2020년 ~ 2024년 데이터만 선택
df_gdp = df_gdp[(df_gdp['year'] >= 2020) & (df_gdp['year'] <= 2024)]

# 결측치(비어있는 값) 처리
gdp_cols = ['GDP (Current USD)', 'GDP per Capita (Current USD)']
df_gdp = df_gdp.sort_values(by=['Country name', 'year']) # 국가와 연도 순으로 정렬

# 각 나라별로 비어있는 GDP 값을 앞뒤 연도의 값으로 채워넣기 (보간)
df_gdp[gdp_cols] = df_gdp.groupby('Country name')[gdp_cols].transform(
    lambda x: x.interpolate(method='linear', limit_direction='both')
)

# 보간 후에도 결측치가 남아있는 행은 제거
df_gdp = df_gdp.dropna(subset=gdp_cols)

# GDP 성장률 계산
df_gdp['gdp_growth_rate'] = df_gdp.groupby('Country name')['GDP (Current USD)'].pct_change()
df_gdp = df_gdp.fillna(0) # 첫 해의 성장률(NaN)은 0으로 채움

# 필요한 컬럼만 선택하여 최종 GDP 데이터프레임 생성
df_gdp_final = df_gdp[['Country name', 'year', 'GDP (Current USD)', 'GDP per Capita (Current USD)', 'gdp_growth_rate']]
print("GDP 데이터 처리 완료.\n")


print("--- 2-2. WHR(행복지수) 데이터 로딩 및 전처리 ---")
# 여러 개의 WHR 파일을 하나로 합치기 위한 빈 리스트 생성
whr_files = {
    2020: 'WHR20.csv', 2021: 'WHR21.csv', 2022: 'WHR22.csv',
    2023: 'WHR23.csv', 2024: 'WHR24.csv'
}
whr_dfs = []

# for문을 이용해 각 연도별 WHR 파일 처리
for year, file_name in whr_files.items():
    file_path = os.path.join(DATA_PATH, file_name)
    df = pd.read_csv(file_path)
    df['year'] = year # 'year' 컬럼 추가

    # 컬럼 이름 통일
    df = df.rename(columns={'Country': 'Country name', 'Happiness score': 'Ladder score'})

    # 국가 이름 통일
    df['Country name'] = df['Country name'].replace(COUNTRY_NAME_MAPPING)
    whr_dfs.append(df)

# 모든 WHR 데이터프레임을 하나로 합치기
whr_all = pd.concat(whr_dfs, ignore_index=True)

# 결측치 처리: 국가별로 그룹화하여 이전/이후 연도 값으로 채우기
whr_all['Ladder score'] = whr_all.groupby('Country name')['Ladder score'].transform(
    lambda x: x.ffill().bfill()
)
whr_all = whr_all.dropna(subset=['Ladder score']) # 결측치가 남은 행 제거

# 필요한 컬럼만 선택
df_whr_final = whr_all[['Country name', 'year', 'Ladder score']]
print("WHR 데이터 처리 완료.\n")


print("--- 2-3. 수면 시간 데이터 로딩 및 전처리 ---")
# 수면 데이터 불러오기
sleep_file_path = os.path.join(DATA_PATH, 'avg_sleeping25.csv')
df_sleep = pd.read_csv(sleep_file_path)

# 컬럼 이름 변경
df_sleep = df_sleep.rename(columns={'country': 'Country name', 'AverageTimeInBedMinutes_2025': 'avg_sleeping_minutes'})

# 국가 이름 통일
df_sleep['Country name'] = df_sleep['Country name'].replace(COUNTRY_NAME_MAPPING)

# 분 단위를 시간 단위로 변경
df_sleep['avg_sleeping_hours'] = df_sleep['avg_sleeping_minutes'] / 60

# 필요한 컬럼만 선택
df_sleep_final = df_sleep[['Country name', 'avg_sleeping_hours']]
print("수면 시간 데이터 처리 완료.\n")


print("--- 2-4. 최종 데이터 병합 ---")
# 1. GDP와 행복지수 데이터를 'Country name'과 'year' 기준으로 합치기
df_combined = pd.merge(df_gdp_final, df_whr_final, on=['Country name', 'year'], how='inner')

# 2. 위에서 합친 데이터에 수면 데이터를 'Country name' 기준으로 합치기
df_combined = pd.merge(df_combined, df_sleep_final, on='Country name', how='left')

print("최종 병합 데이터프레임 (상위 5개):")
print(df_combined.head())
print(f"\n병합 후 총 데이터 수: {len(df_combined)}")
print(f"수면 시간 데이터가 있는 국가 수: {df_combined['avg_sleeping_hours'].dropna().nunique()}")
print(f"수면 시간 데이터가 없는 국가 수: {df_combined[df_combined['avg_sleeping_hours'].isnull()]['Country name'].nunique()}")
print("\n")


# --- 3. 데이터 분석 및 시각화 ---
correlation_results = [] # 상관관계 결과를 저장할 리스트

# for문을 이용해 각 연도별로 분석 및 시각화 진행
for year in YEARS:
    print(f"\n--- {year}년 데이터 분석 및 시각화 ---")
    df_year = df_combined[df_combined['year'] == year]

    # 3-1. GDP 성장률 분석
    # 성장률이 0이 아닌 데이터만 선택
    df_year_gdp = df_year[df_year['gdp_growth_rate'] != 0]

    # 데이터가 있을 경우에만 분석 진행
    if not df_year_gdp.empty:
        top_gdp = df_year_gdp.nlargest(6, 'gdp_growth_rate')
        bottom_gdp = df_year_gdp.nsmallest(6, 'gdp_growth_rate')

        print(f"[{year}년] GDP 성장률 상위 6개국과 행복 지수:\n{top_gdp[['Country name', 'gdp_growth_rate', 'Ladder score']]}")
        print()
        print(f"[{year}년] GDP 성장률 하위 6개국과 행복 지수:\n{bottom_gdp[['Country name', 'gdp_growth_rate', 'Ladder score']]}\n")

        # 시각화: 그룹별 행복지수 평균 비교 바 차트
        df_gdp_compare = pd.concat([top_gdp, bottom_gdp])
        df_gdp_compare['Group'] = ['Top 6 Growth'] * 6 + ['Bottom 6 Growth'] * 6

        # GDP 성장률과 행복지수 상관관계 계산
        correlation_gdp_growth_happiness = df_gdp_compare['gdp_growth_rate'].corr(df_gdp_compare['Ladder score'])

        plt.figure(figsize=(10, 6))
        sns.barplot(data=df_gdp_compare, x='Group', y='Ladder score', hue='Group', palette=['#82C09A', '#F28F8F'], dodge=False, legend=False)
        plt.title(f'[{year}년] GDP 성장률 상/하위 그룹 행복지수 평균 비교', fontsize=16, pad=20)
        plt.xlabel('GDP 성장률 그룹', fontsize=12)
        plt.ylabel('평균 행복 지수', fontsize=12)
        plt.ylim(bottom=3)
        plt.show()
    else:
        correlation_gdp_growth_happiness = np.nan

    # 3-2. 1인당 GDP, 수면 시간과 행복 지수 관계 분석
    # 수면 데이터가 있는 국가만 필터링
    df_sleep_corr = df_year.dropna(subset=['avg_sleeping_hours'])
    # 1인당 GDP가 0보다 큰 데이터만 사용
    df_gdp_corr = df_year[df_year['GDP per Capita (Current USD)'] > 0]

    # 상관관계 계산
    correlation_gdp_happiness = df_gdp_corr['GDP per Capita (Current USD)'].corr(df_gdp_corr['Ladder score'])
    correlation_sleep_happiness = df_sleep_corr['avg_sleeping_hours'].corr(df_sleep_corr['Ladder score'])

    # 결과 저장
    correlation_results.append({
        'Year': year,
        '1인당 GDP-행복지수 상관관계': correlation_gdp_happiness,
        '수면시간-행복지수 상관관계': correlation_sleep_happiness,
        'GDP성장률-행복지수 상관관계': correlation_gdp_growth_happiness
    })

    print(f"[{year}년] 1인당 GDP와 행복 지수 상관관계: {correlation_gdp_happiness:.3f}")
    print(f"[{year}년] 수면 시간과 행복 지수 상관관계: {correlation_sleep_happiness:.3f}\n")

    # 시각화
    fig, axes = plt.subplots(1, 2, figsize=(18, 8))
    fig.suptitle(f'[{year}년] 행복에 영향을 미치는 요인 분석', fontsize=18)

    # 1인당 GDP vs 행복 지수
    sns.regplot(ax=axes[0], data=df_gdp_corr, x='GDP per Capita (Current USD)', y='Ladder score',
                scatter_kws={'alpha':0.6, 's':50}, line_kws={'color':'#E63946'})
    axes[0].set_title('1인당 GDP와 행복 지수 관계', fontsize=14, pad=15)
    axes[0].set_xlabel('1인당 GDP (USD)', fontsize=12)
    axes[0].set_ylabel('행복 지수', fontsize=12)

    # 수면 시간 vs 행복 지수
    sns.regplot(ax=axes[1], data=df_sleep_corr, x='avg_sleeping_hours', y='Ladder score',
                scatter_kws={'alpha':0.6, 's':50}, line_kws={'color':'#457B9D'})
    axes[1].set_title('수면 시간과 행복 지수 관계', fontsize=14, pad=15)
    axes[1].set_xlabel('평균 수면 시간 (시)', fontsize=12)
    axes[1].set_ylabel('행복 지수', fontsize=12)

    plt.tight_layout()
    plt.show()


# --- 4. 상관관계 요약 ---
print("\n\n--- 4. 최종 상관관계 요약 ---")
if not correlation_results:
    print("분석된 상관관계 결과가 없습니다.")
else:
    correlation_df = pd.DataFrame(correlation_results)
    correlation_df = correlation_df.set_index('Year')

    # 2024년은 GDP 성장률 데이터가 없으므로 NaN 값 제거
    correlation_df = correlation_df.dropna(subset=['GDP성장률-행복지수 상관관계'], how='all')
    print(correlation_df.round(3))

    plt.style.use('ggplot')
    fig, axes = plt.subplots(1, 3, figsize=(20, 6))
    fig.suptitle('연도별 상관관계 요약', fontsize=16)

    # 1인당 GDP와 행복 지수 상관관계
    gdp_corr_data = correlation_df['1인당 GDP-행복지수 상관관계'].dropna()
    axes[0].bar(gdp_corr_data.index.astype(str), gdp_corr_data.values)
    axes[0].set_title('1인당 GDP와 행복 지수 상관관계')
    axes[0].set_xlabel('연도')
    axes[0].set_ylabel('상관관계')
    axes[0].tick_params(axis='x', rotation=45)
    axes[0].set_ylim(bottom=0, top=1)

    # 수면 시간과 행복 지수 상관관계
    sleep_corr_data = correlation_df['수면시간-행복지수 상관관계'].dropna()
    axes[1].bar(sleep_corr_data.index.astype(str), sleep_corr_data.values, color='salmon')
    axes[1].set_title('수면 시간과 행복 지수 상관관계')
    axes[1].set_xlabel('연도')
    axes[1].set_ylabel('상관관계')
    axes[1].tick_params(axis='x', rotation=45)
    axes[1].set_ylim(bottom=0, top=1)

    # GDP 성장률과 행복 지수 상관관계
    growth_corr_data = correlation_df['GDP성장률-행복지수 상관관계'].dropna()
    axes[2].bar(growth_corr_data.index.astype(str), growth_corr_data.values, color='skyblue')
    axes[2].set_title('GDP 성장률과 행복 지수 상관관계')
    axes[2].set_xlabel('연도')
    axes[2].set_ylabel('상관관계')
    axes[2].tick_params(axis='x', rotation=45)
    axes[2].axhline(0, color='black', linewidth=0.8)
    axes[2].set_ylim(bottom=-0.5, top=0.5)

    plt.tight_layout(rect=[0, 0, 1, 0.95])
    plt.show()

print("\n--- 전체 분석 완료 ---")