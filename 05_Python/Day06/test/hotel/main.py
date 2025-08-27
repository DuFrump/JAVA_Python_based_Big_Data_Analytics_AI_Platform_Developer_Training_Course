'''
아래의 조건에 따라 호텔관리 프로그램을 만드시오.
- 조회, 입실, 퇴실, 종료 기능을 제공
- 조회시 호실과 투숙객 이름을 2차원으로 배열 (아래 구현 예시 참조)
- 투숙객 현황을 텍스트파일(txt)로 저장하여 프로그램 재시작 시에 로드 가능하도록 구현
- 각종 예외 상황 처리 및 안내 문구 구현 
- 코드에 대한 자세한 설명을 주석으로 넣으시오

<주의사항>
텍스트파일 생성 경로는 루트 디렉토리로 설정 -  './hotel.txt' 
텍스트 파일은 없는 경우 새로 만들어져야함.
 
<제출>
코드를 복사하여 붙여 넣기.

<구현 예시>
101    102    103

----   ----    ----

201    202    203

----    joy     ----

301    302    303

----    ----      kai
'''


# 고객 데이터 파일 경로
DATA_FILE_PATH = "./hotel.txt"
# 고객 데이터를 저장할 빈 딕셔너리 (!!전역 변수로 설정!!)
rooms = {}

# 데이터 불러오기
def load_data():
    # 파일이 있을 경우 딕셔너리로 넣기. (room(방 번호)을 키, guest를 밸류 값으로)
    # Try 문을 사용해 고객 정보 데이터 파일이 존재하는지 확인
    try:
        with open(DATA_FILE_PATH, "r", encoding="utf-8") as f:
            for line in f:
                line = line.strip()
                if line:
                    # 각 라인을 ','을 기준으로 나누고 앞을 room, 뒤를 guest에 담기
                    room, guest = line.split(',')
                    # rooms의 키값은 room, 밸류값은 guest (연결)
                    rooms[room] = guest
        f.close() # 자원 효율성을 위해 파일 닫기

    # 불러올 파일이 없을 경우 새로운 파일 생성
    except FileNotFoundError:
        print(f"'{DATA_FILE_PATH}' 파일을 찾을 수 없어 새로 생성합니다.")
        # 101, 102, 103, 201, 202, 203, 301, 302, 303호 생성
        for floor in range(1, 4):
            for room_num in range(1, 4):
                rooms[f"{floor}0{room_num}"] = "---" # rooms의 초기 밸류 값은 ---로 설정
    
    # rooms 딕셔너리를 반환
    return rooms

# 데이터 저장하기
def save_data():
    # 데이터 파일을 writing 모드로 열기 (편집 가능)
    with open(DATA_FILE_PATH, "w", encoding="utf-8") as f:
        # {room},{guest}의 형태로 데이터 저장
        for room, guest in sorted(rooms.items()):
            f.write(f"{room},{guest}\n")
    f.close()

# 호텔 객실 현황 확인 기능
def view_status():
    print("\n\n------------ 호텔 객실 현황표 ------------\n")

    # 전체 객실 호수와 객실에 묵고 있는 고객 이름 출력 (딕셔너리 rooms에서 정보를 가져옴)
    for floor in range (1, 4):
        for room_num in range(1, 4):
            room = f"{floor}0{room_num}"
            print(f"{"||" + room + "호" + "||":^8}", end="\t")
        print()

        for room_num in range(1, 4):
            room = f"{floor}0{room_num}"
            guest = rooms.get(room, "---")
            print(f"{guest:^8}", end="\t")
        print()
        print()

    print("------------------------------------------\n\n")

# 입실 기능
def check_in_guest():
    room_num = input("입실할 방 번호를 입력하세요: ")

    # 존재하지 않는 방 번호에 입실 시도 시 에러 문구 출력
    if room_num not in rooms:
        print(f"\n!!! {room_num}호는 존재하지 않는 방입니다. !!!")
        return # return을 사용해 처음 화면으로 이동

    # 이미 고객이 있는 방에 입실 시도 시 에러 문구 출력
    if rooms[room_num] != "---":
        print(f"\n!!! {room_num}호는 이미 입실 중입니다. !!!")
        return # return을 사용해 처음 화면으로 이동

    # 에러가 나지 않을 상황이면 실행
    guest_name = input("입실할 고객의 이름을 입력하세요: ")
    # 객실 이름 변경
    rooms[room_num] = guest_name
    print(f"\n** {room_num}호에 {guest_name}님이 입실하셨습니다. **")
    save_data()

# 퇴실 기능
def check_out_guest():
    room_num = input("퇴실할 방 번호를 입력하세요: ")

    # 존재하지 않는 방 번호를 입력 시 에러 문구 출력
    if room_num not in rooms:
        print(f"\n!!! {room_num}호는 존재하지 않는 방입니다. !!!")
        return # return을 사용해 처음 화면으로 이동

    # 빈 방을 퇴실 시 에러 문구 출력
    if rooms[room_num] == "---":
        print(f"\n!!! {room_num}호는 빈 방입니다. !!!")
        return # return을 사용해 처음 화면으로 이동

    # 에러가 나지 않을 상황이면 실행
    guest_name = rooms[room_num]
    # 객실 비우기
    rooms[room_num] = "---"
    print(f"\n** {room_num}호의 {guest_name}님이 퇴실하셨습니다. **")
    # 저장
    save_data()


# 메인 함수
def main():
    # !! 프로그램 시작 시 저장 데이터 로드 !!
    load_data()

    # While 문을 사용해 break문이 나오기 전까지 무한 루프
    while True:
        print("\n--- 호텔 관리 프로그램 ---")
        print("1. 객실 현황   2. 입실   3. 퇴실   4. 종료")
        choice = input("메뉴를 선택하세요: ")

        if choice == '1':
            view_status()
        elif choice == '2':
            check_in_guest()
        elif choice == '3':
            check_out_guest()
        elif choice == '4':
            print("\n프로그램을 종료합니다.")
            break # 프로그램 종료
        else:
            # 1 ~ 4 이외의 키를 입력시 에러 문구 출력
            print("!!! 잘못된 메뉴 선택입니다. 다시 시도하세요. !!!")


# 메인 함수 실행
main()


# 주석을 달아 놓고 나서 소스코드 변경을 더 하는 바람에 말이 뭔가 안되는 주석이 있을 수 있습니다ㅎㅎ,, 시간이 타이트해서 마저 주석 업데이트를 다 하지 못 했습니다.