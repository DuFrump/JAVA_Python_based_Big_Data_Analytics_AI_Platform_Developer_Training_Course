# 클래스가 필요한 이유.

result1 = 0

def add1(num):
    global result
    result += num
    return result

print(add1(3))
print(add1(4))

result2 = 0

def add2(num):
    global result2
    result2 += num
    return result2

print(add2(3))
print(add2(4))
print()


print("----- 클래스로 만들기 -----")
