package _03_Inheritance_computer;

// Samsung 클래스는 Computer 클래스를 상속받는 자식 클래스(Subclass)입니다.
// 삼성 컴퓨터만의 특화된 동작을 정의할 수 있습니다.
public class Samsung extends Computer {
    // 메소드 오버라이딩(Method Overriding):
    // 부모 클래스(Computer)에 있는 `powerOn()` 메소드를 자식 클래스에서 재정의합니다.
    // `@Override` 어노테이션은 이 메소드가 부모 클래스의 메소드를 오버라이딩했음을 명시적으로 나타냅니다.
    // 이는 컴파일러에게 해당 메소드가 오버라이딩되었는지 확인하도록 지시하여 오류를 방지하는 데 도움을 줍니다.
    @Override
    void powerOn() {
        // `super.powerOn()`:
        // 부모 클래스(Computer)의 `powerOn()` 메소드를 호출합니다.
        // 이를 통해 부모 클래스의 원래 기능을 유지하면서 추가적인 동작을 정의할 수 있습니다.
        super.powerOn(); // "컴퓨터가 켜졌습니다." 출력
        System.out.println("!I love Samsung!"); // 삼성 컴퓨터만의 추가 메시지 출력
    }

    // 부모 클래스의 powerOff() 메소드는 별도로 오버라이딩하지 않았으므로,
    // Samsung 객체에서 powerOff()를 호출하면 Computer 클래스의 powerOff()가 실행됩니다.
}
