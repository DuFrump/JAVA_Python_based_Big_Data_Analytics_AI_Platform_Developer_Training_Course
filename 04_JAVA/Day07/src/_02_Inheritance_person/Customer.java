package _02_Inheritance_person;

public class Customer extends Person {
    int memberID;

    Customer(String name, int age, char gender, int memberID) {
        super(name, age, gender);
        this.memberID= memberID;
    }

    void enter() {
        String genderString = "";

        if (gender == 'M') {
            genderString = "남자";
        } else if (gender == 'F') {
            genderString = "여자";
        } else {
            genderString = "존재하지 않는 성별";
        }

        System.out.printf("회원번호 : %d / 이름 : %s / 나이 : %d / 성별 : %s // 입장하셨습니다.%n", memberID, name, age, genderString);
    }
}
