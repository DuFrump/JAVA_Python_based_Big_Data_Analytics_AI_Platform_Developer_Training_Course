package _08_Quiz;

// Main 클래스는 Employee와 Manager 클래스를 사용하여 객체를 생성하고
// 상속 및 메소드 오버라이딩의 동작을 확인하는 예제입니다.
public class Main {
    public static void main(String[] args) {
        // [1] Employee 객체 생성 및 메소드 호출
        Employee em1 = new Employee("홍길동");

        System.out.println("--- 직원 (Employee) 정보 ---");
        em1.work();     // Employee 클래스의 work() 메소드 호출
        em1.showInfo(); // Employee 클래스의 showInfo() 메소드 호출

        System.out.println("
----------------------------------------
");

        // [2] Manager 객체 생성 및 메소드 호출
        // Manager는 Employee를 상속받았고, work()와 showInfo() 메소드를 오버라이딩했습니다.
        Manager mng1 = new Manager("김철수");

        System.out.println("--- 관리자 (Manager) 정보 ---");
        mng1.work();     // Manager에서 오버라이딩된 work() 메소드 호출
        mng1.showInfo(); // Manager에서 오버라이딩된 showInfo() 메소드 호출

        System.out.println("
----------------------------------------
");

        // [3] 다형성(Polymorphism) 예시
        // 부모 클래스 타입의 참조 변수로 자식 클래스의 객체를 참조할 수 있습니다.
        Employee polyEm = new Manager("이영희");
        System.out.println("--- 다형성 (Employee 타입으로 Manager 객체 참조) ---");
        polyEm.work();     // 실제 객체인 Manager의 work() 메소드 호출
        polyEm.showInfo(); // 실제 객체인 Manager의 showInfo() 메소드 호출
        // polyEm.getName(); // Employee 클래스에 getName()이 public이므로 호출 가능
        System.out.println("이름: " + polyEm.getName());
    }
}
