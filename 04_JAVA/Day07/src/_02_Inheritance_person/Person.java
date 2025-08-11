package _02_Inheritance_person;

/**
 * 두 번째 예제에 오신 것을 환영합니다!
 * 이번에는 '생성자(Constructor)'와 상속의 관계에 대해 깊이 알아볼 거예요.
 *
 * 생성자는 '객체를 생성할 때' 딱 한 번 호출되는 아주 특별한 메소드예요.
 * new Person() 하는 순간에 호출되죠.
 * 주로 객체가 처음 만들어질 때 필요한 값들(이름, 나이 등)을 설정해주는 역할을 합니다.
 *
 * 이 Person 클래스는 '이름', '나이', '성별'을 가진 부모 클래스입니다.
 * 아까 Book 예제와 다른 점은, 이번에는 객체를 만들 때부터 이름, 나이, 성별을
 * 반드시 지정해주도록 '생성자'를 통해 강제하고 있다는 점이에요.
 * 한번 자세히 살펴볼까요?
 */
public class Person {
    // === 필드 (Fields) ===
    String name;   // 이름을 저장할 변수
    int age;       // 나이를 저장할 변수
    char gender;   // 성별을 저장할 변수 ('M' 또는 'F')

    // === 생성자 (Constructor) ===
    /**
     * 이것이 바로 '생성자'입니다. 메소드랑 비슷하게 생겼지만, 몇 가지 특징이 있어요.
     * 1. 이름이 클래스 이름과 똑같습니다. (Person)
     * 2. 리턴 타입(void, int 등)이 없습니다.
     *
     * 이 생성자는 이름(name), 나이(age), 성별(gender) 값을 외부에서 받아서
     * 우리 객체의 필드에 세팅해주는 역할을 합니다.
     *
     * 'this' 키워드의 역할!
     * 매개변수로 받은 name과 필드 이름 name이 똑같죠? 이럴 때 컴퓨터가 헷갈릴 수 있어요.
     * 'this.name'은 "이 객체 자신의 필드인 name"을 명확하게 가리키는 표현입니다.
     * 즉, 'this.name = name;'은 "나의 필드 name에 매개변수로 들어온 name 값을 넣어줘!" 라는 뜻이에요.
     */
    Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // === 메소드 (Methods) ===
    /**
     * 사람의 정보를 출력하는 메소드입니다.
     * 성별 필드(gender)는 'M' 또는 'F'라는 문자(char)로 저장되어 있는데,
     * 출력할 때는 "남자", "여자"와 같이 더 친절하게 보여주도록 간단한 로직을 추가했어요.
     */
    void info() {
        String genderString; // 성별을 문자열로 변환해서 담을 변수

        // 만약 gender 필드 값이 'M'과 같다면
        if (gender == 'M') {
            genderString = "남자";
        } else { // 그렇지 않다면 (즉, 'F'라면)
            genderString = "여자";
        }

        System.out.printf("제 이름은 %s이고, 제 나이는 %d입니다. %s입니다.%n", name, age, genderString);
    }
}