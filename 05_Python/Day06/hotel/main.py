import os

# --- 전역 변수 정의 ---
# 데이터 파일명
DATA_FILE = "data.txt"
# 현재 스크립트의 디렉토리 경로
SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
# 데이터 파일의 전체 경로
DATA_FILE_PATH = os.path.join(SCRIPT_DIR, DATA_FILE)
# 호텔 방 상태를 저장할 딕셔너리
rooms = {}

# --- 함수 정의 ---

def load_data():
    """
    데이터 파일에서 방 정보를 읽어와 딕셔너리로 반환합니다.
    파일이 없으면 기본 방 정보를 생성합니다.
    """
    loaded_rooms = {}
    try:
        with open(DATA_FILE_PATH, "r", encoding="utf-8") as f:
            for line in f:
                line = line.strip()
                if line:
                    room, guest = line.split(',')
                    loaded_rooms[room] = guest
    except FileNotFoundError:
        print(f"'{DATA_FILE_PATH}' 파일을 찾을 수 없어 새로 생성합니다.")
        for floor in range(1, 4):
            for room_num in range(1, 4):
                loaded_rooms[f"{floor}0{room_num}"] = "---"
    return loaded_rooms

def save_data():
    """
    현재 방 상태를 데이터 파일에 저장합니다.
    """
    with open(DATA_FILE_PATH, "w", encoding="utf-8") as f:
        for room, guest in sorted(rooms.items()):
            f.write(f"{room},{guest}\n")

def view_status():
    """
    현재 호텔의 모든 방 상태를 출력합니다.
    """
    print("\n--- 호텔 상태 ---")
    for floor in range(1, 4):
        for room_num in range(1, 4):
            room = f"{floor}0{room_num}"
            guest = rooms.get(room, "---")
            print(f"{room}호: {guest}", end="\t")
        print()
    print("-----------------\n")

def check_in_guest():
    """
    고객을 입실시키는 과정을 처리합니다.
    """
    global rooms
    room_num = input("입실할 방 번호를 입력하세요: ")
    if room_num not in rooms:
        print(f"!!! {room_num}호는 존재하지 않는 방입니다.")
        return

    if rooms[room_num] != "---":
        print(f"!!! {room_num}호는 이미 입실 중입니다.")
        return

    guest_name = input("입실할 고객의 이름을 입력하세요: ")
    rooms[room_num] = guest_name
    print(f"*** {room_num}호에 {guest_name}님이 입실하셨습니다.")
    save_data()

def check_out_guest():
    """
    고객을 퇴실시키는 과정을 처리합니다.
    """
    global rooms
    room_num = input("퇴실할 방 번호를 입력하세요: ")
    if room_num not in rooms:
        print(f"!!! {room_num}호는 존재하지 않는 방입니다.")
        return

    if rooms[room_num] == "---":
        print(f"!!! {room_num}호는 빈 방입니다.")
        return

    guest_name = rooms[room_num]
    rooms[room_num] = "---"
    print(f"*** {room_num}호의 {guest_name}님이 퇴실하셨습니다.")
    save_data()

# --- 메인 로직 ---

# 프로그램 시작 시 데이터 로드
rooms = load_data()

while True:
    print("\n--- 호텔 관리 프로그램 (절차지향 버전) ---")
    print("1. 객실 현황   2. 입실   3. 퇴실   4. 종료")
    choice = input("메뉴를 선택하세요: ")

    if choice == '1':
        view_status()
    elif choice == '2':
        check_in_guest()
    elif choice == '3':
        check_out_guest()
    elif choice == '4':
        print("프로그램을 종료합니다.")
        break
    else:
        print("!!! 잘못된 메뉴 선택입니다. 다시 시도하세요.")