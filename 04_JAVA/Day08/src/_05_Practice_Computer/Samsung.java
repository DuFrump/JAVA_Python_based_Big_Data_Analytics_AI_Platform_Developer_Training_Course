package _05_Practice_Computer;

// Samsung 클래스는 Computer 클래스를 상속받는 자식 클래스(Subclass)입니다.
// 삼성 컴퓨터만의 특화된 전원 동작을 정의합니다.
public class Samsung extends Computer {
    // 메소드 오버라이딩: `powerOn()`
    // 부모 클래스(Computer)의 `powerOn()` 메소드를 재정의합니다.
    // `super.powerOn()`을 통해 부모의 기능을 먼저 실행한 후, 삼성만의 메시지를 추가합니다.
    @Override
    void powerOn() {
        super.powerOn(); // "컴퓨터 전원이 켜졌습니다!" 출력
        System.out.println("I love Samsung!"); // 삼성 컴퓨터만의 추가 메시지
    }

    // `powerOff()` 메소드는 오버라이딩하지 않았으므로,
    // Samsung 객체에서 powerOff()를 호출하면 Computer 클래스의 powerOff()가 실행됩니다.
}
