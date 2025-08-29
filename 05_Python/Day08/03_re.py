import re

print("----- DOTALL -----")

p = re.compile('a.b')
m = p.match('a\nb') # 라인 개행은 못 찾음.
print(m)

p = re.compile('a.b', re.DOTALL)
m = p.match('a\nb') # DOTALL은 .을 제외함 (라인 개행까지 포함해서 매치)
print(m)
print()


print("----- IGNORECASE -----")

p = re.compile('[a-z]+', re.I)
m = p.match('python')
print(m)

m = p.match('Python')
print(m)

m = p.match('PYTHON')
print(m)
print()


print("----- MULTILINE -----")

p = re.compile("^python\s\w+", re.M)

data = """python one
life is too short
python two
you need python
python 3
"""

m = p.findall(data)
print(m)


print("----- 문장의 첫 단어 추출 (멀티 라인) -----")

text = """Hello world
안녕하세요 파이썬
Regex is powerful"""
pattern = r"([a-zA-Z가-힣]+)\w[a-zA-Z가-힣]+"

match = re.search(pattern, text, re.MULTILINE)
print(match.group(1))
