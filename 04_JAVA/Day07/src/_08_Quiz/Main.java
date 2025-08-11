package _08_Quiz;

/**
 * 여덟 번째 예제, '퀴즈'의 마지막 파일, Main 클래스입니다!
 * 여기서는 우리가 만든 Employee와 Manager 클래스들의 객체를 생성하고,
 * 그 기능들을 호출하면서 '상속', '메소드 오버라이딩', 그리고 '다형성(Polymorphism)'이라는
 * 자바 객체 지향 프로그래밍의 핵심 개념들을 종합적으로 확인하는 중요한 시간이에요.
 *
 * 'public static void main(String[] args)' 메소드는 자바 프로그램이 시작되는 지점이라는 것,
 * 이제는 잘 아시죠? 여기서 객체를 만들고 메소드를 호출하면서 동작을 살펴봅시다.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("--- [1] 직원 (Employee) 객체 테스트 ---");
        // Employee 객체 생성: 이름을 전달하여 초기화합니다.
        Employee employee1 = new Employee("홍길동");

        // Employee 클래스의 work() 메소드 호출: "홍길동은(는) 업무를 수행합니다." 출력
        employee1.work();
        // Employee 클래스의 showInfo() 메소드 호출: "홍길동 / 직책: 직원" 출력
        employee1.showInfo();

        System.out.println("----------------------------------------");

        System.out.println("--- [2] 관리자 (Manager) 객체 테스트 ---");
        // Manager 객체 생성: 이름을 전달하여 초기화합니다.
        // Manager는 Employee를 상속받았고, work()와 showInfo() 메소드를 오버라이딩했습니다.
        Manager manager1 = new Manager("김철수");

        // Manager에서 오버라이딩된 work() 메소드 호출: "김철수은(는) 회의를 주재합니다." 출력
        manager1.work();
        // Manager에서 오버라이딩된 showInfo() 메소드 호출: "김철수 / 직책: 관리자\n추가 역할: 팀 관리" 출력
        manager1.showInfo();

        System.out.println("----------------------------------------");

        System.out.println("--- [3] 다형성 (Polymorphism) 예시 ---");
        System.out.println("다형성: '하나의 객체가 여러 가지 형태를 가질 수 있는 능력'");
        System.out.println("자바에서는 부모 클래스 타입의 참조 변수로 자식 클래스의 객체를 참조할 수 있습니다.");
        System.out.println("이때, 실제 호출되는 메소드는 참조 변수의 타입이 아닌, 객체의 실제 타입에 따라 결정됩니다.");
        System.out.println("이를 '동적 바인딩(Dynamic Binding)' 또는 '런타임 다형성'이라고 합니다.");

        // Employee 타입의 참조 변수 'polyEmployee'로 Manager 객체를 참조합니다.
        Employee polyEmployee = new Manager("이영희");

        // polyEmployee.work() 호출:
        // 참조 변수의 타입은 Employee이지만, 실제 객체는 Manager이므로
        // Manager 클래스에서 오버라이딩된 work() 메소드가 호출됩니다.
        polyEmployee.work(); // "이영희은(는) 회의를 주재합니다." 출력

        // polyEmployee.showInfo() 호출:
        // 마찬가지로 Manager 클래스에서 오버라이딩된 showInfo() 메소드가 호출됩니다.
        polyEmployee.showInfo(); // "이영희 / 직책: 관리자\n추가 역할: 팀 관리" 출력

        // getName() 메소드는 Employee 클래스에 public으로 정의되어 있으므로,
        // Employee 타입의 참조 변수로도 호출 가능합니다.
        System.out.println("이름: " + polyEmployee.getName()); // "이영희" 출력

        System.out.println("\n--- 모든 퀴즈 예제 테스트 완료 ---");
        System.out.println("상속, 오버라이딩, 그리고 다형성까지 잘 이해하셨기를 바랍니다!");
    }
}