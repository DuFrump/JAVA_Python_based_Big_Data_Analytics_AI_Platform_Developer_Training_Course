package _08_Quiz;

/**
 * 여덟 번째 예제, '퀴즈'에 오신 것을 환영합니다!
 * 이 예제는 '직원'과 '관리자'를 통해 상속과 함께 '접근 제어자'의 개념을 다시 한번 복습하고,
 * 'getter' 메소드의 필요성을 이해하는 데 도움이 될 거예요.
 *
 * 이 Employee 클래스는 모든 직원이 공통적으로 가질 수 있는 '이름'과 '직책'을 정의하는
 * '부모 클래스' 역할을 합니다.
 * 특히, 필드에 적용된 'private'과 'protected' 접근 제어자를 주의 깊게 살펴봅시다.
 */
public class Employee {
    // === 필드 (Fields) ===

    /**
     * [1] private 필드: name
     * 'private' 접근 제어자는 해당 클래스(Employee) 내에서만 이 필드에 직접 접근할 수 있도록 제한합니다.
     * 외부 클래스(심지어 자식 클래스인 Manager에서도)에서는 name 필드에 직접 접근할 수 없습니다.
     * 이는 '정보 은닉(Information Hiding)' 또는 '캡슐화(Encapsulation)'라는 객체 지향의 중요한 원칙을 따르는 것입니다.
     * 외부에서 이 값을 읽거나 변경하려면 'public' 메소드(getter/setter)를 통해서만 가능합니다.
     */
    private String name;

    /**
     * [2] protected 필드: position
     * 'protected' 접근 제어자는 같은 패키지 내에서는 자유롭게 접근 가능하며,
     * 다른 패키지에서는 이 클래스를 상속받은 '자식 클래스'에서만 접근 가능합니다.
     * 'private'보다는 개방적이고, 'default'보다는 상속 관계에서 더 넓은 접근을 허용합니다.
     */
    protected String position;

    // === 생성자 (Constructor) ===
    /**
     * Employee 객체를 생성할 때 호출되는 생성자입니다.
     * 직원의 이름을 매개변수로 받아서 name 필드를 초기화하고,
     * position 필드는 기본값으로 "직원"을 설정합니다.
     */
    Employee(String name) {
        this.name = name;
        this.position = "직원"; // 모든 직원의 기본 직책은 "직원"
    }

    // === 메소드 (Methods) ===

    /**
     * [3] public 메소드 (Getter): getName()
     * 'private'으로 선언된 name 필드의 값을 외부에서 읽을 수 있도록 제공하는 메소드입니다.
     * 'getter' 메소드는 필드 값을 '가져오는(get)' 역할을 합니다.
     * 이렇게 메소드를 통해 간접적으로 접근함으로써, 필드의 유효성을 검사하거나
     * 내부 구현을 변경하더라도 외부 코드에 영향을 주지 않도록 할 수 있습니다.
     */
    public String getName() {
        return name;
    }

    /**
     * [4] default (package-private) 메소드: work()
     * 접근 제어자를 명시하지 않았으므로 'default' 접근 제어자를 가집니다.
     * 이는 같은 패키지(_08_Quiz) 내에서만 이 메소드에 접근할 수 있음을 의미합니다.
     * 직원이 업무를 수행하는 기능을 시뮬레이션합니다.
     */
    void work() {
        System.out.printf("%s은(는) 업무를 수행합니다.%n", name);
    }

    /**
     * [5] default (package-private) 메소드: showInfo()
     * 직원의 이름과 직책을 출력하는 메소드입니다.
     * 이 메소드도 'default' 접근 제어자를 가집니다.
     * 'private' 필드인 name은 같은 클래스 내에서는 직접 접근 가능합니다.
     */
    void showInfo() {
        System.out.printf("%s / 직책: %s%n", name, position);
    }
}
