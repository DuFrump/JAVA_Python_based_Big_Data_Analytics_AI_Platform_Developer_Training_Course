package _05_Practice_Computer;

/**
 * 안녕하세요, 두프룸프님! 이번에는 `Computer` 클래스를 상속받는 'LG 컴퓨터'를 만들어볼 거예요.
 * `LG` 클래스는 `Computer` 클래스의 '자식 클래스(Subclass)'입니다.
 * LG 컴퓨터는 기본적인 컴퓨터의 전원 제어 기능을 물려받으면서도,
 * 전원을 켜고 끌 때 LG만의 특별한 메시지를 출력하도록 부모의 기능을 '재정의(Overriding)'할 수 있습니다.
 *
 * 이 예제에서는 다음을 중점적으로 살펴볼 거예요:
 * 1. 부모 클래스의 메소드를 자식 클래스에서 '재정의(Overriding)'하는 방법 (`@Override`)
 * 2. 재정의된 메소드 안에서 `super` 키워드를 사용하여 부모의 원래 메소드를 호출하는 방법
 *
 * 자, 그럼 LG 컴퓨터를 함께 만들어볼까요?
 */
public class LG extends Computer {
    // 메소드 오버라이딩(Method Overriding): `powerOn()` 메소드
    // `@Override` 어노테이션은 이 메소드가 부모 클래스(`Computer`)의 `powerOn()` 메소드를
    // 재정의(Overriding)했다는 것을 명확히 알려줍니다.
    // `super.powerOn()`을 호출하여 부모의 전원 켜기 기능을 먼저 실행한 후,
    // LG 컴퓨터만의 특별한 메시지를 추가로 출력하도록 했습니다.
    @Override
    void powerOn() {
        super.powerOn(); // 부모 클래스의 powerOn() 메소드를 호출합니다. (컴퓨터 전원 켜짐 메시지)
        System.out.println("사랑해요! LG!"); // LG 컴퓨터만의 추가 메시지
    }

    // 메소드 오버라이딩(Method Overriding): `powerOff()` 메소드
    // `@Override` 어노테이션은 이 메소드가 부모 클래스(`Computer`)의 `powerOff()` 메소드를
    // 재정의(Overriding)했다는 것을 명확히 알려줍니다.
    // `super.powerOff()`을 호출하여 부모의 전원 끄기 기능을 먼저 실행한 후,
    // LG 컴퓨터만의 특별한 메시지를 추가로 출력하도록 했습니다.
    @Override
    void powerOff() {
        super.powerOff(); // 부모 클래스의 powerOff() 메소드를 호출합니다. (컴퓨터 전원 꺼짐 메시지)
        System.out.println("사랑해요! LG!"); // LG 컴퓨터만의 추가 메시지
    }
}
