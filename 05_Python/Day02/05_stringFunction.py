# 문자열 관련 내장 함수
a = "hobby"
print(a.count('b')) # 2

a = "Python is the best choice"
print(a.find('b')) # 14
print(a.find('k')) # -1

a = "Life is too short"
print(a.index('t')) # 8. 't'가 처음 나오는 위치
# print(a.index('k')) # find()와 달리, index()는 찾는 문자가 없으면 ValueError를 발생시키며 프로그램이 멈춥니다.

a = ","
print(a.join('abcd')) # a,b,c,d
print()


print("----- High/Low Case -----")
a = "hi"
b = "HI"
print(a.upper()) # HI
print(b.lower()) # hi
print()


print("----- Strip -----")
a = " hi "
print(a.lstrip()) # "hi "
print(a.rstrip()) # " hi"
print(a.strip()) # "hi"
print()


print("----- Replace, Split -----")
a = "Life is too short"
print(a.replace("Life", "Your leg")) # Your leg is too short
print(a.split()) # ['Life', 'is', 'too', 'short']

b = "a:b:c:d"
print(b.split(':')) # ['a', 'b', 'c', 'd']
print()


print("----- 문자열이 알파벳으로만 이루어져있는지 확인 -----")
s = "Python"
print(s.isalpha()) # True

s = "Python123"
print(s.isalpha()) # False

s = "Python Good"
print(s.isalpha()) # False
print()


print("----- 문자열이 숫자로만 이루어져있는지 확인 -----")
s = "12345"
print(s.isdigit()) # True

s = "12345abc"
print(s.isdigit()) # False
print()


print("----- 특정 문자열로 시작/끝나는지 확인 -----")
s = "report.xlsx"
print(s.startswith("report")) # True
print(s.endswith(".xlsx")) # True
print()

print("----- Extra -----")
a = "hi"
print(a.upper())
print(a.lower())

a = a.upper()
print(a)