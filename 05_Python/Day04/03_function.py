# 함수

def add(a, b):
    return a + b

print(add(3, 4))

c = 5
d = 6

print(add(c, d))


print("----- 입력값, 반환값이 있는 경우 -----")
# 실무 표현
def add(a, b):
    result = a + b
    return result

hap = add(4, 7)
print(hap)
print()


print("----- 입력 값이 없는 함수 -----")
def say():
    return 'Hi'

say() # 아무런 값도 안 나옴
a = say()

print(f"{a}, Jihoon!")
print()


print("----- 결과 값이 없는 함수 -----")
def add2(a, b):
    print(f"{a} + {b} = {a + b}")
    print(f"하지만 반환하는 값은 {a} x {b} 입니다.")
    result = a * b
    return result

a = add2(3, 4)
print(a)
print()


print("----- 입력, 결과 값이 없는 함수 -----")
def say2():
    print("Hi")

say2() # 값이 나옴 // Hi
a = say2() # Hi

print(f"{a}, Jihoon!") # None, Jihoon!
print(say2()) # Hi // None
print()


print("----- 매개변수 지정하여 호출하기 -----")
def sub(a, b):
    return a - b

result = sub(3, 4)
print(result)

result = sub(b=4, a=3) # 매개변수 지정하면 순서가 달라도 상관 없음
print(result)
print()


# 4가지 경우 만들기
def mul1(a, b):
    result = a * b
    return result

def mul2(a, b):
    print(a * b)

def mul3():
    result = 2 * 3
    return result

def mul4():
    result = 2 * 3

print(mul1(3, 4))
print(mul2(3, 4))
print(mul3())
print(mul4())
