package _05_Practice_Computer;

// LG 클래스는 Computer 클래스를 상속받는 자식 클래스(Subclass)입니다.
// LG 컴퓨터만의 특화된 전원 동작을 정의합니다.
public class LG extends Computer {
    // 메소드 오버라이딩: `powerOn()`
    // 부모 클래스(Computer)의 `powerOn()` 메소드를 재정의합니다.
    // `super.powerOn()`을 통해 부모의 기능을 먼저 실행한 후, LG만의 메시지를 추가합니다.
    @Override
    void powerOn() {
        super.powerOn(); // "컴퓨터 전원이 켜졌습니다!" 출력
        System.out.println("사랑해요! LG!"); // LG 컴퓨터만의 추가 메시지
    }

    // 메소드 오버라이딩: `powerOff()`
    // 부모 클래스(Computer)의 `powerOff()` 메소드를 재정의합니다.
    // `super.powerOff()`을 통해 부모의 기능을 먼저 실행한 후, LG만의 메시지를 추가합니다.
    @Override
    void powerOff() {
        super.powerOff(); // "컴퓨터 전원이 꺼졌습니다!" 출력
        System.out.println("사랑해요! LG!"); // LG 컴퓨터만의 추가 메시지
    }
}
