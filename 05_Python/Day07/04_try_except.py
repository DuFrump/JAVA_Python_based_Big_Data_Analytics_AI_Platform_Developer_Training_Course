# 예외처리
import os

# 현재 파일의 디렉토리 경로
script_dir = os.path.dirname(os.path.abspath(__file__))
# 저장할 파일의 전체 경로
file_path = os.path.join(script_dir, "file.txt")

# FileNotFoundError
# f = open("나는 없는 파일", 'r')

# ZeroDivisionError
# a = 4 / 0
# print(a)

# IndexError
# a = [1, 2, 3]
# print(a[3])

a = 3
b = 0

print()
print("----- 1번 방법 -----")

try:
    c = a / b
    print(c)
except:
    print("0으로 나눌 수 없습니다.")

print()
print("----- 2번 방법 -----")

try:
    c = a / b
    print(c)
except ZeroDivisionError:
    print("0으로 나눌 수 없습니다.")


print()
print("----- 3번 방법 -----")

try:
    c = a / b
    print(c)
except ZeroDivisionError as e:
    print(e)


# 여러가지 예외 처리하기

print()
print("----- 여러가지 예외 처리하기 -----")

# try:
#     x = int(input("분자 입력: "))
#     y = int(input("분모 입력: "))
#     result = x / y
#     print(f'결과: {result}')

# except ValueError:
#     print("숫자만 입력하세요!")

# except ZeroDivisionError:
#     print("분모에 0을 넣을 수 없습니다!")

print("-----재밌는 숫자-----")
print()
a = 142857
print(a * 1)
print(a * 2)
print(a * 3)
print(a * 4)
print(a * 5)
print(a * 6)
print(a * 7)

print()
print("----- 여러가지 예외 처리하기 2 -----")

# try:
#     x = int(input("분자 입력: "))
#     y = int(input("분모 입력: "))
#     result = x / y
#     print(f'결과: {result}')

# except Exception as e:
#     print("오류 발생: ", e)

# # try문 정상 종료시 실행됨.
# else:
#     print("잘 마쳤습니다.")

try:
    f = open(file_path, "r")
    data = f.read()
    # 기타 로직 수행

except FileNotFoundError:
    print("파일이 없습니다.")

# 예외 발생 여부와 상관없이 실행됨.
finally:
    print("파일 처리 완료")
    if 'f' in locals(): 
        # 현재 함수나 코드블록 내에 존재하는 지역 변수들의 이름과 값이 담긴 딕셔너리 반환
        f.close()
