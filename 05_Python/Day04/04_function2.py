# 여러 개의 입력값을 받는 함수
# 몇 개의 입력 값을 받을지 정해지지 않았을 때

print("----- 여러 개의 인수를 받는 경우 -----")
def add_many(*args):
    result = 0

    for i in args:
        result += i

    return result

print(add_many(1, 2))
print(add_many(1, 2, 3))
print(add_many(1, 2, 3, 4))
print(add_many(1, 2, 3, 4, 5))
print()

def add_mul(choice, *args):
    if choice == 'add':
        result = 0
        for i in args:
            result += i
    elif choice == 'mul':
        result = 1
        for i in args:
            result *= i
    else:
        result = "더하기 또는 곱하기만 입력해주세요."
    return result
    
print(add_mul('add', 1, 2, 3, 4, 5))
print(add_mul('mul', 1, 2, 3, 4, 5))
print(add_mul('div', 1, 2, 3, 4, 5))
print()


print("----- Key:Value를 인수를 받는 경우 -----")
def print_kwargs(**kwargs):
    print(kwargs)

print_kwargs(a=1)
print_kwargs(name='foo', age=3)
print()
print_kwargs(name='홍길동', age=25, city='서울', job='정의로운 도둑')
print()

def create_profile(**info):
    print("=== 프로필 정보 ===")
    for key, value in info.items():
        print(f"{key}: {value}")

create_profile(name='김철수', age=31, 직업='개발자', 취미='독서')
print()

data = {'이름': '콩순이', '나이': '5살', '직업': '유치원생', '취미': '놀기'}
create_profile(**data)
print()


print("----- 3가지 형식으로 인수를 받는 경우 -----")
def mixed_profile(name, *args, **kwargs):
    print(f"이름: {name}")
    print(f"좋아하는 숫자: {args}")
    print(f"기타 정보: {kwargs}")

mixed_profile('홍길동', 10, 7, 5, age='17살', city='서울')
print()

# mixed_profile2 만들기
name = '번개맨'
fav_number = [3, 7, 9]
extra_info = {'age' : 15, 'city' : '인천'}

# 결과 값
'''
이름: 번개맨
좋아하는 숫자: (3, 4, 5)
== 기타 정보 ==
나이: 15
도시: 인천
'''
def mixed_profile2(name, *fav_number, **extra_info):
    print(f"이름: {name}")
    print(f"좋아하는 숫자: {fav_number}")
    print("== 기타 정보 ==")
    for key, value in extra_info.items():
        print(f"{key}: {value}")

mixed_profile2(name, *fav_number, **extra_info)
print()