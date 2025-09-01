# json 입출력

import json
import os

# 현재 파일의 디렉토리 경로
script_dir = os.path.dirname(os.path.abspath(__file__))
# 저장할 파일의 전체 경로
file_path = os.path.join(script_dir, "basic.json")

data = {
    "name": "Alice",
    "age": 30,
    "hobbies": ["reading", "traveling"],
    "married": False,
    "children": None
}

# 제이슨 파일로 덤프하기 (생성하다)
with open(file_path, "w", encoding="utf-8") as f:
    json.dump(data, f, ensure_ascii=False, indent=4)

# 제이슨파일 로드하기
with open(file_path, "r", encoding="utf-8") as f:
    loaded_data = json.load(f)

print()
print(loaded_data)
print()
