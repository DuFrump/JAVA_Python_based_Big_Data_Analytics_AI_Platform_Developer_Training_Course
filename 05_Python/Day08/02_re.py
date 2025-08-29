import re 

print("----- 영단어만 추출 -----")

text = "Python 정규식, Hello, World! 123"
pattern = '[a-zA-Z]+'

words = re.findall(pattern, text)
print("영어 단어 : ", words)
print()


print("----- 숫자만 추출 -----")

text = "오늘은 2025년 8월 29일, 수업은 3시간!"
pattern = '\d+'

numbers = re.findall(pattern, text)
print("숫자 : ", numbers)
print()


print("----- 특정 단어로 시작하는 단어 찾기 -----")

text = "cat scatter cater catalog catch dog"
pattern = r'\bcat\w*'

matches = re.findall(pattern, text)
print("cat으로 시작하는 단어 : ", matches)
print()


print("----- or -----")

p = re.compile("Crow|Servo")
m = p.match("CrowHello")
print(m)
print()


print("----- 문자열 바꾸기 -----")

p = re.compile('blue|white|red')
m = p.sub('color', 'blue socks and red shoes')
print(m)
print()


print("----- 모든 공백을 하나로 줄이기 -----")

text = "안녕하세요    반갑습니다\t저는  파이썬을 공부하고 있습니다."
pattern = r"\s+"

result = re.sub(pattern, " ", text)
print("공백 정리 : ", result)
print()


print("----- 간단한 URL 찾기 -----")

text = "사이트: http://example.com, 보안: https://secure.org/path"
pattern = r"\bhttps?://[a-zA-Z0-9._%+-/]+"

urls = re.findall(pattern, text)
print("URL 추출 : ", urls)
print()


print("----- 이메일 추출 -----")

text = """
문의: cs@test.co / backup: me.example+dev@sub-domain.example.com
스팸: a@b, user@.com, @nohost, 정상: hello.world@domain.io
"""
pattern = r"[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}"

emails = re.findall(pattern, text)
print("이메일 추출 : ", emails)
print()


print("----- ^ & -----")

# ^Hello >>> 시작이 Hello이여야만 함.
m = re.match(r"^Hello", "Hello, World")
m2 = re.match(r"^Hello", "Well, Hello")

m3 = re.search(r"^a", "apple")
m4 = re.search(r"^a", "banana")

print(m)
print(m2)
print(m3)
print(m4)
print()

# Hello$ >>> 끝이 Hello이여야만 함.
m = re.search(r"Hello$", "Hello, World")
m2 = re.search(r"Hello$", "Well, Hello")

m3 = re.search(r"a$", "apple")
m4 = re.search(r"a$", "banana")

print(m)
print(m2)
print(m3)
print(m4)