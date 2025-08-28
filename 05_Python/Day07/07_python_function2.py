print("----- hex -----")
print() # 정수를 입력 받아 16진수 문자열로 반환

print(hex(255))
print(hex(3))


print()
print("----- oct -----")
print() # 정수를 입력 받아 8진수 문자열로 반환

print(oct(3))
print(oct(8))
print(oct(9))
print(oct(16))


print()
print("----- id -----")
print() # 객체의 고유 주소값 반환

a = 3
print(id(3))
print(id(a))

b = a
print(id(b))
print(id(4))


print()
print("----- int -----")
print() # 정수로 반환

a = '3'
print(a) # 3
print(type(a))

a = int(a)
print(a) # 3
print(type(a))

print(int(3.4)) # 3
print(int(3.9)) # 3

print(int('11', 2)) # 3
print(int('1A', 16)) # 26


print()
print("----- isinstance -----")
print() # 해당 클래스의 속하는 인스턴스 유무

class Person: pass

a = Person()
b = 3

print(isinstance(a, Person))
print(isinstance(b, Person))


print()
print("----- len -----")
print() # 길이 반환

a = "가나다라마바사아자차카타파하"
b = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
print(len(a)) # 14
print(len(b)) # 26
print(len([1, 2, 3])) # 3
print(len([1, 'a'])) # 2


print()
print("----- list -----")
print() # 리스트 형식으로 반환

print(list('Python')) # ['P', 'y', 't', 'h', 'o', 'n']
print(list((1, 2, 3))) # [1, 2, 3]

a = [1, 2, 3]
b = a
c = list(a)

print(a) # [1, 2, 3]
print(b) # [1, 2, 3]
print(c) # [1, 2, 3]
print(id(a))
print(id(b))
print(id(c))


print()
print("----- max, min -----")
print() # 최대, 최소 값 반환

print(max([1, 2, 3])) # 3
print(min([1, 2, 3])) # 1
print(max('python')) # y
print(min('python')) # h


print()
print("----- chr/ord -----")
print() # 유니코드 숫자를 입력 받아 해당하는 문자 반환

print(chr(97)) # a
print(chr(44032)) #가

print(ord('a')) # a
print(ord('가')) #가
