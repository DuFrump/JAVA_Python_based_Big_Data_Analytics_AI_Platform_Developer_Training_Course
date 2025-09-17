import seaborn as sns
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from matplotlib import font_manager, rc
from pathlib import Path

# --- 기본 설정 ---
# 한글표기
font_path = 'C:/Windows/Fonts/malgun.ttf'
font_name = font_manager.FontProperties(fname=font_path).get_name()
rc('font', family=font_name)
# 음수표기
plt.rcParams['axes.unicode_minus'] = False
# 터미널 너비
pd.set_option('display.width', 500)
pd.set_option('display.max_rows', 500)
pd.set_option('display.max_columns', 50)
pd.set_option('display.unicode.east_asian_width', True)

# --- 상수 및 이름 매핑 정의 ---
DATA_PATH = Path('./Day20/data')
YEARS = range(2020, 2025)

# 국가 이름 표준화를 위한 매핑 딕셔너리 (world_bank_data_25.csv 기준)
COUNTRY_NAME_MAPPING = {
    # WHR Data
    "Taiwan Province of China": "Taiwan",
    "Hong Kong S.A.R. of China": "Hong Kong SAR, China",
    "State of Palestine": "West Bank and Gaza",
    "Congo (Brazzaville)": "Congo, Rep.",
    "Congo (Kinshasa)": "Congo, Dem. Rep.",
    "Eswatini, Kingdom of": "Eswatini",
    "North Macedonia": "Macedonia, FYR",
    "Slovakia": "Slovak Republic",
    "Turkiye": "Turkey",
    # Sleep Data
    "South Korea": "Korea, Rep.",
    "Czech Republic": "Czechia",
    "Hong Kong": "Hong Kong SAR, China",
    "Russia": "Russian Federation",
    "Turkey": "Turkiye",
    "US": "United States",
    "United Kingdom": "United Kingdom",
    "Taiwan": "Taiwan" # WHR과 Sleep 데이터 간의 중간 통일
}

# --- 데이터 로딩 및 전처리 함수 ---

def load_gdp_data(path):
    print("--- 2-1. GDP 데이터 로딩 및 전처리 ---")
    df_gdp = pd.read_csv(path / 'world_bank_data_25.csv')
    df_gdp = df_gdp.rename(columns={'country_name': 'Country name'}).copy()
    df_gdp = df_gdp.query("2020 <= year <= 2024").copy()

    gdp_cols = ['GDP (Current USD)', 'GDP per Capita (Current USD)']
    df_gdp.sort_values(by=['Country name', 'year'], inplace=True)
    for col in gdp_cols:
        df_gdp[col] = df_gdp.groupby('Country name')[col].transform(
            lambda x: x.interpolate(method='linear', limit_direction='both')
        )
    
    # 보간 후에도 남은 결측치가 있는 국가는 분석에서 제외
    df_gdp.dropna(subset=gdp_cols, inplace=True)

    # 성장률 계산
    df_gdp['gdp_growth_rate'] = df_gdp.groupby('Country name')['GDP (Current USD)'].pct_change()
    df_gdp.fillna(0, inplace=True) # 첫 해 성장률 NaN을 0으로 채움
    
    print("GDP 데이터 처리 완료.\n")
    return df_gdp[['Country name', 'year', 'GDP (Current USD)', 'GDP per Capita (Current USD)', 'gdp_growth_rate']]

def load_whr_data(path, name_mapping):
    """WHR 데이터를 로드하고 병합 및 전처리합니다."""
    print("--- 2-2. WHR 데이터 로딩 및 전처리 ---")
    whr_files = {
        2020: 'WHR20.csv', 2021: 'WHR21.csv', 2022: 'WHR22.csv', 
        2023: 'WHR23.csv', 2024: 'WHR24.csv'
    }
    whr_dfs = []
    for year, file in whr_files.items():
        df = pd.read_csv(path / file)
        df['year'] = year
        # 컬럼명 통일
        df.rename(columns={'Country': 'Country name', 'Happiness score': 'Ladder score'}, inplace=True)
        # 국가명 표준화
        df['Country name'] = df['Country name'].replace(name_mapping)
        whr_dfs.append(df)

    whr_all = pd.concat(whr_dfs, ignore_index=True)
    
    # 국가별로 그룹화하여 이전/이후 연도 값으로 결측치 채우기
    whr_all['Ladder score'] = whr_all.groupby('Country name')['Ladder score'].transform(
        lambda x: x.ffill().bfill()
    )
    whr_all.dropna(subset=['Ladder score'], inplace=True)
    
    print("WHR 데이터 처리 완료.\n")
    return whr_all[['Country name', 'year', 'Ladder score']]

def load_sleep_data(path, name_mapping):
    """수면 데이터를 로드하고 전처리합니다."""
    print("--- 2-3. 수면 시간 데이터 로딩 및 전처리 ---")
    df_ash = pd.read_csv(path / 'avg_sleeping25.csv')
    df_ash = df_ash.rename(columns={'country': 'Country name', 'AverageTimeInBedMinutes_2025': 'avg_sleeping_minutes'})
    # 국가명 표준화
    df_ash['Country name'] = df_ash['Country name'].replace(name_mapping)
    
    # 분 단위 데이터 시간 단위로 변경
    df_ash['avg_sleeping_hours'] = df_ash['avg_sleeping_minutes'] / 60
    
    print("수면 시간 데이터 처리 완료.\n")
    return df_ash[['Country name', 'avg_sleeping_hours']]

# --- 데이터 로딩, 전처리 및 병합 실행 ---
df_gdp_final = load_gdp_data(DATA_PATH)
df_whr_final = load_whr_data(DATA_PATH, COUNTRY_NAME_MAPPING)
df_sleep_final = load_sleep_data(DATA_PATH, COUNTRY_NAME_MAPPING)

print("--- 2-4. 최종 데이터 병합 ---")
# 1. GDP와 행복지수 데이터를 inner join하여 기준 데이터 생성
df_combined = pd.merge(df_gdp_final, df_whr_final, on=['Country name', 'year'], how='inner')

# 2. 기준 데이터에 수면 데이터를 left join
df_combined = pd.merge(df_combined, df_sleep_final, on='Country name', how='left')

print("최종 병합 데이터프레임 (상위 5개):")
print(df_combined.head())
print(f"\n병합 후 총 데이터 수: {len(df_combined)}")
print(f"수면 시간 데이터가 있는 국가 수: {df_combined['avg_sleeping_hours'].dropna().nunique()}")
print(f"수면 시간 데이터가 없는 국가 수: {df_combined[df_combined['avg_sleeping_hours'].isnull()]['Country name'].nunique()}")
print("\n")


# --- 3. 데이터 분석 및 시각화 ---
correlation_results = []

for year in YEARS:
    correlation_gdp_growth_happiness = np.nan
    print(f"\n--- {year}년 데이터 분석 및 시각화 ---")
    df_year = df_combined[df_combined['year'] == year].copy()

    # 3-1. GDP 성장률 분석 (2021-2023년)
    if year in range(2020, 2025):
        df_year_gdp = df_year.query('gdp_growth_rate != 0')
        if not df_year_gdp.empty:
            top_gdp = df_year_gdp.nlargest(6, 'gdp_growth_rate')
            bottom_gdp = df_year_gdp.nsmallest(6, 'gdp_growth_rate')

            print(f"[{year}년] GDP 성장률 상위 6개국과 행복 지수:\n{top_gdp[['Country name', 'gdp_growth_rate', 'Ladder score']]}")
            print()
            print(f"[{year}년] GDP 성장률 하위 6개국과 행복 지수:\n{bottom_gdp[['Country name', 'gdp_growth_rate', 'Ladder score']]}\n")

            # 시각화: 그룹별 행복지수 평균 비교 바 차트
            df_gdp_compare = pd.concat([top_gdp.assign(Group='Top 6 Growth'), 
                                        bottom_gdp.assign(Group='Bottom 6 Growth')])
            
            # GDP 성장률과 행복지수 상관관계 계산
            if not df_gdp_compare.empty:
                correlation_gdp_growth_happiness = df_gdp_compare['gdp_growth_rate'].corr(df_gdp_compare['Ladder score'])

            plt.figure(figsize=(10, 6))
            sns.barplot(data=df_gdp_compare, x='Group', y='Ladder score', hue='Group', palette=['#82C09A', '#F28F8F'], dodge=False, legend=False)
            plt.title(f'[{year}년] GDP 성장률 상/하위 그룹 행복지수 평균 비교', fontsize=16, pad=20)
            plt.xlabel('GDP 성장률 그룹', fontsize=12)
            plt.ylabel('평균 행복 지수', fontsize=12)
            plt.ylim(bottom=3)
            plt.show()

    # 3-2. 1인당 GDP, 수면 시간과 행복 지수 관계 분석
    # 수면 데이터가 있는 국가만 필터링하여 상관관계 계산
    df_sleep_corr = df_year.dropna(subset=['avg_sleeping_hours'])
    # 1인당 GDP는 0보다 큰 유효한 데이터만 사용
    df_gdp_corr = df_year.query("`GDP per Capita (Current USD)` > 0")

    # 상관관계 계산
    correlation_gdp_happiness = np.nan
    if not df_gdp_corr.empty:
        correlation_gdp_happiness = df_gdp_corr['GDP per Capita (Current USD)'].corr(df_gdp_corr['Ladder score'])

    correlation_sleep_happiness = np.nan
    if not df_sleep_corr.empty:
        correlation_sleep_happiness = df_sleep_corr['avg_sleeping_hours'].corr(df_sleep_corr['Ladder score'])

    correlation_results.append({
        'Year': year,
        '1인당 GDP-행복지수 상관관계': correlation_gdp_happiness,
        '수면시간-행복지수 상관관계': correlation_sleep_happiness,
        'GDP성장률-행복지수 상관관계': correlation_gdp_growth_happiness
    })

    print(f"[{year}년] 1인당 GDP와 행복 지수 상관관계: {correlation_gdp_happiness:.3f}")
    print()
    print(f"[{year}년] 수면 시간과 행복 지수 상관관계: {correlation_sleep_happiness:.3f}")

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
def summarize_correlations(results):
    print("\n\n--- 4. 최종 상관관계 요약 ---")
    if not results:
        print("분석된 상관관계 결과가 없습니다.")
        return

    correlation_df = pd.DataFrame(results).set_index('Year').copy()
    # 2024년은 GDP 성장률 데이터가 없으므로 NaN 값 제거
    correlation_df.dropna(subset=['GDP성장률-행복지수 상관관계'], how='all', inplace=True)
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

summarize_correlations(correlation_results)

print("\n--- 전체 분석 완료 ---")
