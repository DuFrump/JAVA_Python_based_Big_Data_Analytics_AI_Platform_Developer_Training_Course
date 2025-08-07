package _08_Quiz;

// Employee 클래스는 모든 직원의 기본적인 정보를 나타내는 부모 클래스(Superclass)입니다.
// 접근 제어자(private, protected)의 사용법을 보여줍니다.
public class Employee {
    // [1] `private` 필드: `name`
    // `private` 접근 제어자는 해당 클래스 내에서만 접근 가능합니다.
    // 외부에서는 직접 접근할 수 없으며, `public` 메소드(getter/setter)를 통해 접근해야 합니다.
    private String name;

    // [2] `protected` 필드: `position`
    // `protected` 접근 제어자는 동일 패키지 내에서 접근 가능하며,
    // 다른 패키지에서는 이 클래스를 상속받은 자식 클래스에서만 접근 가능합니다.
    protected String position;

    // 생성자: Employee 객체를 생성할 때 이름과 기본 직책을 초기화합니다.
    Employee(String name) {
        this.name = name;
        this.position = "직원"; // 기본 직책은 "직원"으로 설정
    }

    // [3] `public` 메소드 (Getter): `getName()`
    // `private` 필드 `name`의 값을 외부에서 읽을 수 있도록 제공하는 메소드입니다.
    public String getName() {
        return name;
    }

    // [4] `default` (package-private) 메소드: `work()`
    // 접근 제어자를 명시하지 않았으므로 `default` 접근 제어자를 가집니다.
    // 동일 패키지 내에서만 접근 가능합니다.
    void work() {
        System.out.printf("%s은(는) 업무를 수행합니다.%n", name);
    }

    // [5] `default` (package-private) 메소드: `showInfo()`
    // 직원의 이름과 직책을 출력하는 메소드입니다.
    void showInfo() {
        System.out.printf("%s / 직책: %s%n", name, position);
    }
}