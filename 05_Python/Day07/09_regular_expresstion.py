# 정규 표현식 (regular expression)

data = """
Park 800905-1049118
Kim 700905-1247458
Lee 760123-2130054
"""

for line in data.split("\n"):
    print(line)
    for word in line.split(" "):
        print(word)

print('123'.isdigit()) # True
print('a123'.isdigit()) # False

words = ['apple', 'banana', 'mango']

print(" ".join(words)) # apple banana mango

# 주민번호 뒷자리 *표 처리
# Park 800905-*******
# Kim 700905-*******
# Lee 760123-*******

for line in data.split("\n"):
    if line.strip() == "":
        continue
    name, id = line.split()
    frontId, backId = id.split("-")
    cryp = frontId + "-" + backId[0] + "******"
    print(name, cryp)
print()
print()


print("============================ re ============================")

import re

data = """
Park 800905-1049118
Kim 700905-1247458
Lee 760123-2130054
"""

pat = re.compile("(\d{6})[-]\d{7}")
print(pat.sub("\g<1>-*******", data))
