print("----- 클래스로 만들기 -----")
print()

class Calculator:
    def __init__(self):
        self.result = 0

    def add(self, num):
        self.result += num
        return self.result
    
    def sub(self, num):
        self.result -= num
        return self.result
    
    def mul(self, num):
        self.result *= num
        return self.result
    
    def div(self, num):
        self.result /= num
        return self.result


cal1 = Calculator()
cal2 = Calculator()

print(cal1.add(3))
print(cal1.add(4))
print(cal1.mul(10))
print()
print(cal2.add(1))
print(cal2.add(9))
print(cal1.mul(10))
print()

# 사칙연산 클래스
'''
a = FourCal()

a.setdata(4, 2)

a.add() >>> 6
a.mul() >>> 8
a.sub() >>> 2
a.div() >>> 2
'''

class FourCal:
    def __init__(self, first, second):
        self.first = first
        self.second = second

    def add(self):
        result = self.first + self.second
        return result
    
    def mul(self):
        result = self.first * self.second
        return result
    
    def sub(self):
        result = self.first - self.second
        return result
    
    def div(self):
        result = self.first / self.second
        return result

a = FourCal(4, 2)
print(type(a))
print()

print(a.first)
print(a.second)
print()

print(a.add())
print(a.mul())
print(a.sub())
print(a.div())
print()


print("----- 클래스 상속 -----")
print()

class MoreFourCal(FourCal):

    third = 777

    def pow(self):
        result = self.first ** self.second
        return result
    
    # 메서드 오버라이딩
    def div(self):
        if self.second == 0:
            print("0으로 나눌 수 없습니다.")
            return 0
        else:
            return self.first / self.second

b = MoreFourCal(5, 2)

print(b.add())
print(b.mul())
print(b.sub())
print(b.div())
print()

print(b.pow())
print()

c = MoreFourCal(4, 0)
print(c.div()) # 메서드 오버라이딩 이후 error가 안 뜨게 된다. (0으로 나눴을 시 errorException을 설정해 놨기 때문)
print()

print(MoreFourCal.third)
print(b.third)
print(c.third)

