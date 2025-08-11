package _08_Quiz;

/**
 * Manager 클래스는 Employee 클래스를 상속받는 '자식 클래스'입니다.
 * 'extends Employee'를 통해 Employee의 모든 속성과 기능을 물려받습니다.
 *
 * 이 클래스에서는 '관리자'라는 직책에 맞게 부모의 기능을 오버라이딩하고,
 * 부모 클래스의 'private' 필드와 'protected' 필드에 어떻게 접근하는지 보여줄 거예요.
 */
public class Manager extends Employee {

    // === 생성자 (Constructor) ===
    /**
     * Manager 객체를 생성할 때 호출되는 생성자입니다.
     * 직원의 이름을 매개변수로 받습니다.
     *
     * 'super(name)'을 통해 부모 클래스(Employee)의 생성자를 호출하여
     * Employee의 name 필드를 초기화합니다.
     *
     * 'protected' 필드인 'position'은 자식 클래스에서 직접 접근하여 변경할 수 있습니다.
     * 따라서 여기서 관리자의 직책을 "관리자"로 설정합니다.
     */
    Manager(String name) {
        super(name); // 부모 클래스(Employee)의 생성자 호출
        this.position = "관리자"; // protected 필드에 직접 접근하여 값 변경
    }

    // === 메소드 (Methods) ===

    /**
     * [1] 메소드 오버라이딩: work()
     * 부모 클래스(Employee)의 work() 메소드를 재정의합니다.
     * 관리자는 일반 직원과 다른 업무(회의 주재)를 수행합니다.
     *
     * 'private' 필드인 name에 직접 접근할 수 없으므로,
     * 부모 클래스에서 제공하는 'public' getter 메소드인 getName()을 통해 name 값을 가져옵니다.
     */
    @Override
    void work() {
        // getName() 메소드는 private 필드 name에 접근하기 위한 public getter 메소드입니다.
        String employeeName = getName(); // 부모 클래스의 public 메소드를 통해 private 필드에 접근
        System.out.printf("%s은(는) 회의를 주재합니다.%n", employeeName);
    }

    /**
     * [2] 메소드 오버라이딩: showInfo()
     * 부모 클래스(Employee)의 showInfo() 메소드를 재정의합니다.
     *
     * 'super.showInfo()'를 통해 부모의 showInfo() 기능을 먼저 실행하여
     * 이름과 직책(관리자로 변경된)을 출력합니다.
     * 그 후에 관리자만의 추가 정보("추가 역할: 팀 관리")를 출력합니다.
     */
    @Override
    void showInfo() {
        super.showInfo(); // 부모 클래스의 showInfo() 메소드 호출 (이름 / 직책 출력)
        System.out.println("추가 역할: 팀 관리"); // 관리자만의 추가 정보
    }
}