package _05_Practice_Computer;

// Main 클래스는 ComputerRoom 클래스를 사용하여 다양한 컴퓨터 객체를 관리하고 제어하는 예제입니다.
// 다형성(Polymorphism)의 강력함을 보여줍니다.
public class Main {
    public static void main(String[] args) {
        // ComputerRoom 객체 생성
        ComputerRoom cr1 = new ComputerRoom();

        // [1] 다형성을 활용하여 ComputerRoom의 Computer 타입 변수에 다양한 자식 객체 할당
        // `Computer computer1 = new Samsung();` 와 같이 부모 타입으로 자식 객체를 참조합니다.
        // 이렇게 하면 `ComputerRoom` 클래스는 특정 브랜드에 종속되지 않고 유연하게 컴퓨터를 관리할 수 있습니다.
        cr1.computer1 = new Samsung(); // computer1은 Samsung 객체를 참조
        cr1.computer2 = new LG();      // computer2는 LG 객체를 참조
        cr1.computer3 = new Samsung(); // computer3은 Samsung 객체를 참조
        cr1.computer4 = new LG();      // computer4는 LG 객체를 참조

        System.out.println("--- 모든 컴퓨터 전원 켜기 ---");
        // `allPowerOn()` 메소드 호출 시, 각 computer 변수가 참조하는 실제 객체(Samsung, LG)에 따라
        // 오버라이딩된 `powerOn()` 메소드가 실행됩니다.
        cr1.allPowerOn();
        // 예상 출력:
        // 컴퓨터 전원이 켜졌습니다!
        // I love Samsung!
        // 컴퓨터 전원이 켜졌습니다!
        // 사랑해요! LG!
        // 컴퓨터 전원이 켜졌습니다!
        // I love Samsung!
        // 컴퓨터 전원이 켜졌습니다!
        // 사랑해요! LG!

        System.out.println("
--- 모든 컴퓨터 전원 끄기 ---");
        // `allPowerOff()` 메소드 호출 시,
        // Samsung 객체는 Computer의 `powerOff()`를, LG 객체는 LG의 `powerOff()`를 호출합니다.
        cr1.allPowerOff();
        // 예상 출력:
        // 컴퓨터 전원이 꺼졌습니다!
        // 컴퓨터 전원이 꺼졌습니다!
        // 사랑해요! LG!
        // 컴퓨터 전원이 꺼졌습니다!
        // 컴퓨터 전원이 꺼졌습니다!
        // 사랑해요! LG!
    }
}
