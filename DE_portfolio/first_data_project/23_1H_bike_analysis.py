# 라이브러리
import pandas as pd
import matplotlib.pyplot as plt
plt.rcParams['font.family'] = 'Malgun Gothic' 
plt.rcParams['axes.unicode_minus'] = False

# 데이터 불러오기
d_23_1H = pd.read_csv("clansed_data/23_2H_GPT_Version.csv")

d_23_1H['기준년월'] = pd.to_datetime(d_23_1H['기준년월'], format='%Y%m')
d_23_1H = d_23_1H.sort_values(by='기준년월')

plt.figure(figsize=(14, 6))
for gu in d_23_1H['자치구'].unique():
    subset = d_23_1H[d_23_1H['자치구'] == gu]
    plt.plot(subset['기준년월'], subset['대여건수'], label=gu)

plt.legend(bbox_to_anchor=(1.01, 1), loc='upper left')
plt.title('자치구별 월간 따릉이 대여건수')
plt.xlabel('기준년월')
plt.ylabel('대여건수')
plt.grid(True)
plt.tight_layout()
plt.show()