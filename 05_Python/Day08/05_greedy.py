import re

print("----- 괄호 안의 내용 뽑기 -----")

text = "오늘의 메뉴는 (자장면)과 (오징어덮밥) 입니다."

pattern = r"\((.*?)\)"

menu = re.findall(pattern, text)
print("메뉴 목록 : ", menu)