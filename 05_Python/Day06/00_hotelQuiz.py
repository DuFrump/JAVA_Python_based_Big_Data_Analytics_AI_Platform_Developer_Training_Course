import os
from textwrap import dedent

customer_data_path = './Day06/고객데이터.txt'

f = open(customer_data_path, "w", encoding="utf-8")

def main(): 
    while (True) :
        prompt = dedent("""
        ============================================
        1. 조회  2.입실  3.퇴실  4.종료

        원하시는 기능을 선택해주세요. (숫자 입력) : 
        ============================================
        """)
        select = int(input(prompt))

        if select == 1:
            check_list()
            continue
        elif select == 2:
            check_in()
            continue
        elif select == 3:
            check_out()
            continue
        elif select == 4:
            print("종료 기능을 선택하셨습니다.")
            break
        else:
            print("잘못된 입력입니다. 다시 입력해주세요.")
            continue

def check_list():
    print("조회 기능을 선택하셨습니다.")

    f_check = open(customer_data_path, "r", encoding="utf-8")

    if f_check == "":
        print("불러올 고객 정보가 없습니다.")
    else:
        print("1. 전체 고객 명단 출력")
        print("2. 특정 고객 명단 출력")
        menu = input("원하시는 기능을 선택해주세요. (숫자 입력) : ")

        if menu == 1:
            print(f_check.read())


    f_check.close()

def check_in():
    print("입실 기능을 선택하셨습니다.")
    name = input("고객님의 성함을 입력해주세요. : ")
    birth = input("고객님의 생년월일을 입력해주세요. : ")
    room_number = input("고객님이 예약하실 방번호를 입력해주세요. : ")

    try:
        with open(customer_data_path, "a", encoding="utf-8") as f:
            for line in f:
                customer_data = line.strip().split(',')[-1]
                if customer_data == room_number:
                    print(f"{room_number}는 이미 사용 중이거나 예약된 방입니다.")
                    return
    except FileNotFoundError:
        pass

    f.write(f"{name},{birth},{room_number}\n")
    print(f"{name}님의 {room_number} 입실이 완료되었습니다.")


def check_out():
    print("퇴실 기능을 선택하셨습니다.")
    name_to_checkout = input("고객님의 성함을 입력해주세요. : ")
    birth_to_checkout = input("고객님의 생년월일을 입력해주세요. : ")

    file_path = "./Day06/고객데이터.txt"
    remaining_customers = []
    customer_found = False
    checked_out_room = ""

    try:
        # 1. 파일을 읽어 퇴실할 고객을 제외한 나머지 고객 정보를 리스트에 저장합니다.
        with open(file_path, "r", encoding="utf-8") as f:
            for line in f:
                # 데이터 파싱 (이름, 생년월일, 방번호)
                customer_data = line.strip().split(',')
                if len(customer_data) < 3:  # 비어있거나 잘못된 형식의 줄은 건너뜁니다.
                    continue
                
                name, birth, room_number = customer_data

                # 퇴실할 고객 정보와 일치하는지 확인합니다.
                if name == name_to_checkout and birth == birth_to_checkout:
                    customer_found = True
                    checked_out_room = room_number
                    # 일치하는 고객은 리스트에 추가하지 않고 건너뜁니다 (삭제 효과).
                else:
                    # 퇴실하지 않는 고객 정보는 리스트에 다시 추가합니다.
                    remaining_customers.append(line)

        # 2. 고객 정보를 찾았다면, 남은 고객 정보로 파일을 덮어씁니다.
        if customer_found:
            with open(file_path, "w", encoding="utf-8") as f:
                f.writelines(remaining_customers)
            print(f"\n=> {checked_out_room}호 {name_to_checkout}님의 퇴실 처리가 완료되었습니다.\n")
        else:
            print("\n=> 일치하는 고객 정보가 없습니다. 이름과 생년월일을 다시 확인해주세요.\n")

    except FileNotFoundError:
        print("불러올 고객 정보가 없습니다.")


main()