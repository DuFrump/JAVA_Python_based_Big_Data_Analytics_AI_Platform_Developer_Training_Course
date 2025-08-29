import re

# 긍정형 전방탐색 (Positive Lookahead)
# 특정 문자가 나오는지 확인만 하고 미포함

text = "apple1 pie and apple2 tart"

pattern = r"apple\d(?= pie)"

matches = re.findall(pattern, text)
print(matches)
print()

# 부정형 전방탐색 (Negative Lookahead)
# 특정 문자가 안 나오는지 확인만 하고 미포함

pattern = r"apple\d(?! pie)"

matches = re.findall(pattern, text)
print(matches)
print()


# 긍정형 후방탐색 (Positive Lookbehind)
# 특정 패턴이 바로 앞에 있는지 확인

text = "apple pie1 and banana pie2"

pattern = r"(?<=apple )pie\d"

matches = re.findall(pattern, text)
print(matches)
print()

# 부정형 후방탐색 (Negative Lookbehind)
# 특정 패턴이 바로 앞에 없는지 확인

text = "apple pie1 and banana pie2"

pattern = r"(?<!apple )pie\d"

matches = re.findall(pattern, text)
print(matches)
print()


# foo.bar auto.bat send.cf
# .bat 파일은 빼고 싶다.
text = "foo.bar auto.bat send.cf"

pattern = r"\b\w*[.](?!bat\b)\w*\b"

matches = re.findall(pattern, text)
print(matches)