import numpy as np
import pandas as pd
pd.set_option('display.unicode.east_asian_width', True)

print()
print('----- 시리즈 산술 연산 -----')
print()

student1 = pd.Series({'국어':100, '수학':95, '영어':90})
print(student1)
print()

percentage = student1 / 200
print(percentage)
print(type(percentage))
print()

student2 = pd.Series({'국어':80, '수학':75, '영어':60})

# 키 값이 동일한 벨류를 찾아서 연산, (키-벨류로 판단하기 때문에 작성 순서가 달라도 상관 없음)
addition = student1 + student2
print(addition)
print(type(addition))
print()

subtraction = student1 - student2
print(subtraction)
print(type(subtraction))
print()

multiplication = student1 * student2
print(multiplication)
print(type(multiplication))
print()

division = round(student1 / student2)
print(division)
print(type(division))
print()

df = pd.DataFrame([student1, student2, addition, subtraction, multiplication, division], index=['학생1', '학생2', '덧셈', '뺄샘', '곱', '나눗셈'])
print(df)
print()
print(df.T)
print()


print()
print('----- NaN이 나오는 경우 -----')
print()

student1 = pd.Series({'국어':np.nan, '수학':95, '영어':90})
student2 = pd.Series({'국어':80, '수학':75})

addition = student1 + student2
subtraction = student1 - student2
multiplication = student1 * student2
division = round(student1 / student2)

df = pd.DataFrame([addition, subtraction, multiplication, division], index=['덧셈', '뺄샘', '곱셈', '나눗셈'])
print(df.T)
print()


print()
print('----- 연산메서드 (NaN 값 채우기) -----')
print()

student1 = pd.Series({'국어':np.nan, '수학':95, '영어':90})
student2 = pd.Series({'국어':80, '수학':75})

sr_add = student1.add(student2, fill_value=0)
sr_sub = student1.sub(student2, fill_value=0)
sr_mul = student1.mul(student2, fill_value=0)
sr_div = round(student1.div(student2, fill_value=0))

df = pd.DataFrame([sr_add, sr_div, sr_mul, sr_sub], index=['가', '감', '승', '제'])
print(df.T)
print()