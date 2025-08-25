students = ['민수', '영희', '철수', '지영']

points = [3, -2, 0, 5]

'''
5점 이상 : 칭찬 대상
1~4점 : 일반 학생
0점 이하 : 주의 필요
'''
# 최종 출력 결과
'''
민수 : 일반 학생
영희 : 주의 필요
철수 : 주의 필요
지영 : 칭찬 대상
'''

# for, if, zip함수를 활용해서 작성
for i in range(len(students)):
    if points[i] >= 5:
        comment = "칭찬 대상"
    elif 1 <= points[i] <= 4:
        comment = "일반 학생"
    else:
        comment = "주의 필요"

    print(f"{students[i]} : {comment}")        
print()

for student, point in zip(students, points):
    if point >= 5:
        comment = "칭찬 대상"
    elif 1 <= point <= 4:
        comment = "일반 학생"
    else:
        comment = "주의 필요"
  
    print(f"{student} : {comment}")
print()

