package _02_Inheritance_person;

// Person 클래스는 사람의 기본적인 정보를 나타내는 부모 클래스(Superclass)입니다.
// 모든 사람에게 공통적으로 적용될 수 있는 속성과 기능을 정의합니다.
public class Person {
    // 필드(Field): 사람의 속성을 나타내는 변수들입니다.
    String name;   // 이름을 저장하는 문자열 변수
    int age;       // 나이를 저장하는 정수 변수
    char gender;   // 성별을 저장하는 문자 변수 ('M' 또는 'F')

    // 생성자(Constructor): Person 객체를 생성할 때 호출되어 필드를 초기화합니다.
    // `this` 키워드는 현재 객체의 필드를 지칭합니다.
    Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // 메소드(Method): 사람의 정보를 콘솔에 출력하는 기능입니다.
    void info() {
        String genderString = "";

        // 성별(char) 값에 따라 문자열로 변환합니다.
        if (gender == 'M') {
            genderString = "남자";
        } else {
            genderString = "여자";
        }

        System.out.printf("제 이름은 %s이고, 제 나이는 %d입니다. %s입니다.\n", name, age, genderString);
    }
}
