numbers = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

# 람다식 하나 만들기 map 혹은 filter 넣어서 (리스트)
filtering = list(filter(lambda x : x % 2 == 0, numbers))
result = list(map(lambda x : x ** 2, filtering))

print(result)
print()

# 리스트 컴프리헨션으로 바꾸기
list_comprehension1 = [x for x in numbers if x % 2 == 0]
list_comprehension2 = [x ** 2 for x in list_comprehension1]

print(list_comprehension2)