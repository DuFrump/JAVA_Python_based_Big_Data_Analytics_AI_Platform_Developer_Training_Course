# for 문

test_list  = ['one', 'two', 'three']

print(test_list)

for i in test_list:
    print(i)
print()

a = [(1, 2), (3, 4), (5, 6)]
print(a)

for (first, last) in a:
    print(first + last)
print()

print("----- for문 응용 -----")
marks = [90, 25, 67, 45, 80]

number = 0
for mark in marks:
    number += 1
    if mark >= 60:
        print(f"{number}번 학생은 합격입니다.")
    else:
        print(f"{number}번 학생은 불합격입니다.")
print()

print("----- for문 응용 2 : continue -----")
number = 0
for mark in marks:
    number = number + 1
    if mark < 60:
        continue
    print("%d번 학생 축하합니다. 합격입니다" % number)
print()

print("----- for문 응용 3 : range -----")
a = range(10)
print(a)

a = range(1, 11)
print(a)

add = 0 
for i in range(1, 11):
    add += i
print(add)

for i in range(5):
    i += 1
    print(f"안녕하세요. {i}번 째 인사입니다.")
print()

marks = [90, 25, 67, 45, 80]
for i in range(len(marks)):
    print(f"{i + 1}번 학생, 시험 수고하셨습니다.")
    if marks[i] < 60:
        print()
        continue
    else:
        print(f"{i + 1}번 학생 축하합니다. 합격입니다.")
        print()

# for문으로 구구단 짜보기
print("----- 원래 구구단 -----")
for i in range(2, 10):
    print(f"----- {i}단 -----")
    for j in range(1, 10):
        print(f"{i} x {j} = {i * j}")
    print()
print()


print("----- 가로 구구단 -----")
for i in range(2, 10):
    print(f"{i}단", end=":\t")
    for j in range(1, 10):
        print(f"{i} x {j} = {i * j}", end = "\t")
    print()
print()


print("----- 세로 구구단 -----")
for a in range(2, 10):
    print(f"--- {a}단 ---", end="\t")
print()

for i in range(1, 10):
    for j in range(2, 10):
        print(f"{j} x {i} = {i * j}", end = "\t")
    print()
print()