package _02_Inheritance_person;

// Customer 클래스는 Person 클래스를 상속받는 자식 클래스(Subclass)입니다.
// 고객에 특화된 정보를 추가하고, 부모 클래스의 기능을 확장하거나 재정의할 수 있습니다.
public class Customer extends Person {
    // 필드(Field): 고객의 추가 속성을 나타내는 변수입니다.
    int memberID; // 회원 번호를 저장하는 정수 변수

    // 생성자(Constructor): Customer 객체를 생성할 때 호출됩니다.
    // `super(name, age, gender);`:
    //   - 부모 클래스(Person)의 생성자를 호출하여 부모 클래스의 필드(name, age, gender)를 초기화합니다.
    //   - 자식 클래스의 생성자에서 부모 클래스의 생성자를 호출할 때는 반드시 첫 줄에 와야 합니다.
    Customer(String name, int age, char gender, int memberID) {
        super(name, age, gender);
        this.memberID = memberID; // Customer 클래스 고유의 필드를 초기화합니다.
    }

    // 메소드(Method): 고객의 입장 정보를 출력하는 기능입니다.
    // 부모 클래스의 `info()` 메소드와는 다른 새로운 기능을 추가합니다.
    void enter() {
        String genderString = "";

        if (gender == 'M') {
            genderString = "남자";
        } else if (gender == 'F') {
            genderString = "여자";
        } else {
            genderString = "존재하지 않는 성별"; // 유효하지 않은 성별 값에 대한 처리
        }

        System.out.printf("회원번호 : %d / 이름 : %s / 나이 : %d / 성별 : %s // 입장하셨습니다.%n", memberID, name, age, genderString);
    }
}
