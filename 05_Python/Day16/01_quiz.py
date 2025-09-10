import pandas as pd
import seaborn as sns

titanic = sns.load_dataset('titanic')

# age 를 평균값으로 채우지 말고
# pclass 별 평균값으로 채우기
# 아니면 다른 방법으로
# age 널 값 대체를 스마트하게 하고 데이터분석 마무리

pclass_age_transform = titanic.groupby('pclass')['age'].transform('mean')

titanic['age'].fillna(pclass_age_transform, inplace=True)

print(titanic.isnull().sum())
print()
print(titanic['age'])
print()