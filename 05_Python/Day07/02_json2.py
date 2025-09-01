# 리스트를 제이슨으로 저장/로드 하기

import json
import os

# 현재 파일의 디렉토리 경로
script_dir = os.path.dirname(os.path.abspath(__file__))
# 저장할 파일의 전체 경로
file_path = os.path.join(script_dir, "people.json")

people = [
    {"name": "Tom", "age": 25},
    {"name": "Jane", "age": 28},
    {"name": "Bob", "age": 22}
]

# 제이슨으로 덤프하기
with open(file_path, "w", encoding="utf-8") as f:
    json.dump(people, f, ensure_ascii=False, indent=4)

# 제이슨 파일 불러오기
with open(file_path, "r", encoding="utf-8") as f:
    loaded_people = json.load(f)

print()
print(loaded_people)
print()

for person in loaded_people:
    print(f'{person['name']} is {person['age']} years old')


# Tom is 25 years old
# Jane is 28 years old
# Bob is 22 years old
