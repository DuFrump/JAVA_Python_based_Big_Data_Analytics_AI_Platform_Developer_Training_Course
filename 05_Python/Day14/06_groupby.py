import seaborn as sns
import pandas as pd

pd.set_option('display.unicode.east_asian_width', True)

titanic = sns.load_dataset('titanic')
df = titanic.loc[:, ['age', 'sex', 'class', 'fare', 'survived']]

print(df.head())
print()

# class 열을 기준으로 그룹화하기
grouped = df.groupby(['class'], observed=True)
print(grouped)
print()

for key, group in grouped:
    print(f'key : {key}')
    print(f'number : {len(group)}')
    print(group.head())
    print()
print()

# 연산 메서드 적용
average = grouped.mean(numeric_only=True)
print(average.round(2))
print()

group3 = grouped.get_group(('Third',))
print(group3.head())
print()

group_two = df.groupby(['class', 'sex'], observed=True)

for key, group in group_two:
    print(f'key : {key}')
    print(f'number : {len(group)}')
    print(group.head())
    print()
print()

# group_two에 연산 메서드 적용
average_two = group_two.mean(numeric_only=True)
print(average_two)
print()

group3f = group_two.get_group(('Third', 'female'))
print(group3f.head())
print()

# 필터링으로 'Third', 'female' 만 뽑기.
group3f = df[(df['class'] == 'Third') & (df['sex'] == 'female')]
print(group3f.head())
print()