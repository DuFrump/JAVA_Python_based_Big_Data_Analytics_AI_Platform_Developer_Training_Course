import pandas as pd
pd.set_option('display.unicode.east_asian_width', True)

students = {'이름' : ['서준', '우현', '인아'],
            '수학' : [88, 86, 76],
            '영어' : [97, 63, 95],
            '사회' : [91, 74, 66],
            '체육' : [94, 93, 82]
}

df = pd.DataFrame(students)
print(df)
print()

print()
("----- 인덱스 지정 -----")
print()

ndf = df.set_index('이름')
print(ndf)
print()

ndf2 = df.set_index(['이름'])
print(ndf2)
print()

ndf3 = df.set_index('수학')
print(ndf3)
print()

ndf33 = df.set_index('영어')
print(ndf33)
print()

ndf4 = df.set_index(['수학', '영어'])
print(ndf4)
print()


print()
print("----- 인덱스 재배열 -----")
print()

df = pd.DataFrame(students, index=['s1', 's2', 's3'])
print(df)
print()

new_index = ['s1', 's2', 's3', 's4', 's5']
ndf = df.reindex(new_index)
print(ndf)
print()

ndf.loc[['s4', 's5'], '수학'] = [80, 90]
print(ndf)
print()

ndf = df.reindex(new_index, fill_value=0)
print(ndf)
print()


print()
print("----- 인덱스/컬럼 동시 재배열 -----")
print()

ndf = df.reindex(index=new_index, columns=['이름', '수학', '영어', '과학'])
print(ndf) # 인덱스와 컬럼 바꿔주는대로 재생성됨.
print()

print(df)
print()


print()
print("----- reindex 이용한 자리 바꾸기 -----")
print()

ndf = df.reindex(columns=['이름', '영어', '수학', '사회', '체육'])
print(ndf) # 컬럼 위치를 바꿔주고 싶을 때 제격!
print()

ndf = df.reindex(new_index)
print(ndf)
print()

ndf = ndf.fillna(0)
print(ndf)
print()

ndf = ndf.astype({'수학':'int64', '영어':'int64'})
print(ndf)
print(ndf.info())
print()