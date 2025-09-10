import pandas as pd
import numpy as np

pd.set_option('display.unicode.east_asian_width', True)

# 미션용 데이터프레임 생성
data = {'이름': ['철수', '영희', '민수', '영수', '민지', '준수', '예은'],
        '성별': ['남', '여', '남', '남', '여', '남', '여'],
        '반': ['1반', '1반', '2반', '2반', '3반', '3반', '1반'],
        '과목': ['국어', '수학', '국어', '과학', '수학', '과학', '국어'],
        '점수': [80, 95, 85, 90, 75, 100, 90]}
df = pd.DataFrame(data)

print("--- 원본 데이터프레임 ---")
print(df)
print()

'''
미션 1: 그룹 연산
'반'을 기준으로 데이터를 그룹화하고, 각 반의 평균 점수를 구하는 코드를 작성해 주세요.

'성별'을 기준으로 그룹화하여 각 성별의 '점수'에 대한 최대값, 최소값, 평균을 한 번에 구하는 코드를 작성해 주세요.

미션 2: 데이터 재구조화
'성별'과 '과목'을 기준으로 '점수'의 평균을 계산하여 피벗 테이블(Pivot Table)을 만드는 코드를 작성해 주세요. (인덱스는 '성별', 컬럼은 '과목'이 되도록)

위에서 만든 피벗 테이블을 다시 원래의 형태로 되돌려 (unpivot) '성별', '과목', '점수' 열을 가진 데이터프레임으로 만드는 코드를 작성해 주세요.
'''

print()
print("----- 미션 1 -----")
print()

grouped_class = df.groupby('반')
group_mean = grouped_class['점수'].mean()

print(grouped_class)
print()
print(group_mean.round(2))
print()

grouped_gender = df.groupby('성별')

print(grouped_gender.describe())


print()
print("----- 미션 2 -----")
print()

pivot_table = pd.pivot_table(df, index='성별', columns='과목', values='점수', aggfunc='mean')
print(pivot_table)
print()

unpivot_df = pivot_table.stack().reset_index()
unpivot_df.columns = ['성별', '과목', '점수']
print(unpivot_df)
print()