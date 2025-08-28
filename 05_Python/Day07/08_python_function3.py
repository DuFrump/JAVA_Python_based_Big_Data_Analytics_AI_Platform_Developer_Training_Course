print()
print("----- pow -----")
print() # 제곱

print(pow(2, 4))
print(pow(2, 100))


print()
print("----- range -----")
print() # 사이 길이 반환

print(list(range(5))) # 0, 1, 2, 3, 4
print(list(range(5, 10))) # 5, 6, 7, 8, 9

print(list(range(1, 10, 2))) # 1, 3, 5, 7, 9

print(list(range(0, -11, -2))) # 0, -2, -4, -6, -8, -10
print(list(range(0, -11, -1))) # 0, -1, -2, -3, -4, -5, -6, -7, -8, -9, -10


print()
print("----- round -----")
print() # 반올림/내림해서 반환

print(round(4.6)) # 5
print(round(4.2)) # 4
print(round(4.5)) # 가까운 짝수 쪽으로 붙음
print(round(5.5)) # 가까운 짝수 쪽으로 붙음
print(round(4.51)) # 5
print(round(4.5000000000001)) # 5

print(round(5.678, 2)) # 5.68


print()
print("----- sorted -----")
print() # 정렬해서 리스트로 반환

print(sorted([3, 1, 2])) # 1, 2, 3
print(sorted(['a', 'b', 'c'])) # a, b, c
print(sorted('zero')) # e, o, r, z
print(sorted([3, 2, 1])) # 1, 2, 3


print()
print("----- str -----")
print() # 문자열로 반환

print(str(3)) # 문자열 3
print(str('hi')) # 변화 없음


print()
print("----- sum -----")
print() # 합계 반환

print(sum([1, 2, 3])) # 6
print(sum([4, 5, 6])) # 15


print()
print("----- tuple -----")
print() # 반복 가능한 데이터를 튜플로 반환

print(tuple('abc')) # a, b, c
print(tuple([1, 2, 3])) # 1, 2, 3
print(tuple((1, 2, 3))) # 1, 2, 3


print()
print("----- type -----")
print() # 데이터 타입을 반환

print(type("abc")) # str
print(type(123)) # int
print(type('a')) # str
print(type([])) # list
print(type(open('test', 'w')))


print()
print("----- zip -----")
print()

print(list(zip([1, 2, 3], [4, 5, 6]))) # 1, 4 / 2, 5 / 3, 6
print(list(zip([1, 2, 3], [4, 5, 6], [7, 8, 9]))) # 1, 4, 7 / 2, 5, 8 / 3, 6, 9
print(list(zip('abc', 'def'))) # a, d / b, e / c, f