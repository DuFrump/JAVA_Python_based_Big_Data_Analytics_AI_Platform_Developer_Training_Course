package _08_Quiz;

// Manager 클래스는 Employee 클래스를 상속받는 자식 클래스(Subclass)입니다.
// 관리자만의 특성과 기능을 정의하고, 부모 클래스의 메소드를 오버라이딩합니다.
public class Manager extends Employee {
    // 생성자: Manager 객체를 생성할 때 호출됩니다.
    // `super(name)`을 통해 부모 클래스(Employee)의 생성자를 호출하여 `name`을 초기화합니다.
    Manager(String name) {
        super(name);
        // `protected` 필드 `position`은 자식 클래스에서 직접 접근하여 변경할 수 있습니다.
        this.position = "관리자"; // 관리자의 직책을 "관리자"로 설정
    }

    // [1] 메소드 오버라이딩: `work()`
    // 부모 클래스(Employee)의 `work()` 메소드를 재정의합니다.
    // 관리자는 일반 직원과 다른 업무(회의 주재)를 수행합니다.
    @Override
    void work() {
        // `getName()` 메소드는 `private` 필드 `name`에 접근하기 위한 `public` getter 메소드입니다.
        String name = getName(); // 부모 클래스의 public 메소드를 통해 private 필드에 접근
        System.out.printf("%s은(는) 회의를 주재합니다.%n", name);
    }

    // [2] 메소드 오버라이딩: `showInfo()`
    // 부모 클래스(Employee)의 `showInfo()` 메소드를 재정의합니다.
    // `super.showInfo()`를 통해 부모의 기능을 먼저 실행한 후, 추가적인 정보를 출력합니다.
    @Override
    void showInfo() {
        super.showInfo(); // 부모 클래스의 showInfo() 메소드 호출 (이름 / 직책 출력)
        System.out.println("추가 역할: 팀 관리"); // 관리자만의 추가 정보
    }
}
