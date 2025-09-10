import pandas as pd
import numpy as np

pd.set_option('display.unicode.east_asian_width', True)

# 미션용 데이터프레임 생성
data = {'이름': ['철수', '영희', '민수', '영수', np.nan, '민지'],
        '성별': ['남', '여', '남', '남', '여', np.nan],
        '나이': [15, 17, np.nan, 20, 16, 18],
        '점수': [80, 95, 85, 90, 75, 100],
        '반': ['1반', '1반', '2반', '2반', '3반', '3반']}
df = pd.DataFrame(data)

print("--- 원본 데이터프레임 ---")
print(df)
print()
print()

'''
미션 1: 결측치 처리
df에 있는 모든 결측치(NaN)가 몇 개인지 확인하는 코드를 작성해 주세요.

'나이' 열의 결측치를 해당 열의 평균값으로 채워주세요.

'성별' 열의 결측치를 '남녀' 열에서 가장 많이 등장하는 값으로 채워주세요.

미션 2: 데이터 변환 및 가공
'나이' 열의 값들을 10대와 20대로 나누고, 그 결과를 새로운 '연령대' 열로 만들어주세요.

'점수' 열을 기준으로 데이터를 내림차순으로 정렬하고, 그 결과를 df_sorted 변수에 저장해 주세요.

미션 3: 데이터 선택 및 필터링
나이가 18세 이상인 사람들의 데이터만 선택하는 코드를 작성해 주세요.

'점수'가 90점 이상이면서 '반'이 '1반'인 사람들의 데이터만 선택하는 코드를 작성해 주세요.
'''

print()
print("----- 미션 1 -----")
print()

print(df.isnull().sum())
print()

df = df.fillna({'나이': df['나이'].mean()})
df = df.fillna({'성별': df['성별'].mode()[0]})

print(df)
print()


print()
print("----- 미션 2 -----")
print()

df['연령대'] = df['나이'] // 10 * 10
print(df)
print()

df_sorted = df.sort_values(by='점수', ascending=False)
print(df_sorted)
print()

print()
print("----- 미션 3 -----")
print()

print(df[df['나이'] >= 18])
print()

print(df[(df['점수']>= 90) & (df['반'] == '1반')])
print()