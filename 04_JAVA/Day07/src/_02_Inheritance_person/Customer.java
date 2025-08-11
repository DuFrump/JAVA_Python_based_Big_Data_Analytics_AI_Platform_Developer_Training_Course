package _02_Inheritance_person;

/**
 * 자, 이제 Person 클래스를 상속받는 '자식 클래스'인 Customer를 살펴볼 시간입니다.
 * 'extends Person' 키워드를 통해 Customer가 Person의 모든 속성과 기능을 물려받았다는 것을 알 수 있죠.
 *
 * 이 Customer 클래스는 일반적인 사람(Person)의 특징 외에,
 * '회원 번호(memberID)'라는 고객만의 특별한 속성을 가질 거예요.
 *
 * 가장 중요한 부분은 바로 '생성자'입니다.
 * 부모 클래스(Person)에 생성자가 있기 때문에, 자식 클래스(Customer)의 생성자에서는
 * 반드시 부모의 생성자를 먼저 호출해줘야 해요.
 * 이 과정을 'super()' 키워드를 통해 어떻게 하는지 자세히 알아봅시다!
 */
public class Customer extends Person {
    // === 필드 (Fields) ===
    // Person 클래스로부터 name, age, gender를 물려받았습니다.
    // 여기에 고객만의 속성인 '회원 번호'를 추가합니다.
    int memberID; // 고객의 회원 번호를 저장할 변수

    // === 생성자 (Constructor) ===
    /**
     * Customer 객체를 생성할 때 호출되는 생성자입니다.
     *
     * 매개변수를 보면, 부모인 Person이 필요로 하는 name, age, gender와
     * 자식인 Customer가 필요로 하는 memberID를 모두 받고 있습니다.
     *
     * 여기서 가장 중요한 것은 바로 'super(name, age, gender);' 이 한 줄입니다!
     *
     * 'super()'는 부모 클래스의 생성자를 호출하는 역할을 해요.
     * 자식 클래스의 생성자 안에서는 반드시 'super()' 호출이 첫 번째 줄에 와야 합니다.
     * 왜냐하면 자식이 태어나기 전에 부모가 먼저 준비되어야 하는 것과 같은 이치예요.
     * 부모의 필드(name, age, gender)는 부모의 생성자가 초기화해야 하므로,
     * 자식은 부모에게 그 초기화 책임을 넘기는 것이죠.
     */
    Customer(String name, int age, char gender, int memberID) {
        // 부모 클래스(Person)의 생성자를 호출하여 name, age, gender 필드를 초기화합니다.
        super(name, age, gender);
        // Customer 클래스 고유의 필드인 memberID를 초기화합니다.
        this.memberID = memberID;
    }

    // === 메소드 (Methods) ===
    /**
     * 이 메소드는 Customer 클래스에 새로 추가된 기능입니다.
     * 고객이 입장할 때의 정보를 출력하는 역할을 합니다.
     * 부모 클래스의 info() 메소드와는 다른, Customer만의 특별한 기능이죠.
     */
    void enter() {
        // Person 클래스의 info() 메소드에서 성별을 문자열로 변환하는 로직을 이미 가지고 있으므로,
        // 여기서는 간단히 출력만 하도록 하겠습니다.
        // 만약 Person의 info()를 호출하고 싶다면 super.info();를 사용할 수 있습니다.
        String genderString = (gender == 'M') ? "남자" : "여자"; // 삼항 연산자로 간단하게 성별 문자열 변환

        System.out.printf("회원번호: %d / 이름: %s / 나이: %d / 성별: %s // 입장하셨습니다.%n",
                memberID, name, age, genderString);
    }

    /**
     * 메소드 오버라이딩(Method Overriding) 예시:
     * 부모 클래스(Person)의 info() 메소드를 Customer 클래스에 맞게 재정의합니다.
     * 고객은 일반 사람 정보 외에 회원 번호도 함께 보여주고 싶을 때 유용합니다.
     */
    @Override // @Override 어노테이션은 이 메소드가 부모의 메소드를 오버라이딩했음을 명시적으로 알려줍니다.
    void info() {
        super.info(); // 먼저 부모(Person)의 info() 메소드를 호출하여 기본 정보를 출력합니다.
        System.out.println("회원 번호: " + memberID); // 그 다음, Customer만의 추가 정보인 회원 번호를 출력합니다.
    }
}