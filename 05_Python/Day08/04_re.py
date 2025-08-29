# !! 그루핑 !!
# 1. 여러 문자를 하나로 묶어서 반복 처리
# 2. 매치된 문자열에서 원하는 부분만 추출

import re

p = re.compile('(ABC)+')
m = p.search('ABCABCABC OK?')
print(m) # <re.Match object; span=(0, 9), match='ABCABCABC'>
print(m.group()) # ABCABCABC

p = re.compile(r"\w+\s+\d+[-]\d+[-]\d+")
m = p.search("Park 010-1234-5678")
print()


# 이름 부분만 추출하기
p = re.compile(r"(\w+)\s+(\d+[-]\d+[-]\d+)")
m = p.search("Park 010-1234-5678")

name = m.group(1)
ph = m.group(2)

print(name)
print(ph)
print()


# 문자열 재 참조
p = re.compile(r"(\b\w+)\s+\1")
m = p.search("Paris paris in the the spring").group()
print(m)
print()


print("----- 이메일 사용자 명과 도메인 분리 -----")

text = "문의: hello.world@python.org"
pattern = r"\b([a-zA-Z0-9._%+-]+)@([a-zA-Z0-9.-]+\.[a-zA-Z]{2,})"

match = re.search(pattern, text)
print("전체 : ", match.group(0))
print("사용자명 : ", match.group(1))
print("도메인 : ", match.group(2))
print()


print("----- 이메일 사용자 명과 도메인 분리 -----")

text = '와아아아 대박!! 굿굿굿'
pattern = r"(.)\1{2,}"

result = re.sub(pattern, r"\1\1", text)
print("중복 줄이기 : ", result)
print()


print("----- 전화번호 정규화(하이픈 통일) -----")

text = "고객센터 02-123-1234, 01012341234, 031.123.1234, 010 1234 1234(대표)"

rx = re.compile(r"\b(0\d{1,2})[-. ]?(\d{3,4})[-. ]?(\d{4})\b")

normalized = rx.sub(r"\1-\2-\3", text)
print("정규화 : ", normalized)
print()


m = rx.finditer(text)
print(m)

for i in m:
    print('원본 : ', i.group(0), "| 지역 : ", i.group(1), "| 국번호 : ", i.group(2), "| 가입자 : ", i.group(3))

# finditer로 각 그룹 확인
"""
원본 :  02-123-1234 | 지역 :  02 | 국번호 :  123 | 가입자 :  1234
원본 :  01012341234 | 지역 :  010 | 국번호 :  1234 | 가입자 :  1234
원본 :  031.123.1234 | 지역 :  031 | 국번호 :  123 | 가입자 :  1234
원본 :  010 1234 1234 | 지역 :  010 | 국번호 :  1234 | 가입자 :  1234
"""