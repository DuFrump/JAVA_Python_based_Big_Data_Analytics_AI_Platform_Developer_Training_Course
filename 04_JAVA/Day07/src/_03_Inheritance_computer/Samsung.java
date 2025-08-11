package _03_Inheritance_computer;

/**
 * 자, 이제 Computer 클래스를 상속받는 '자식 클래스'인 Samsung을 살펴볼 시간입니다.
 * 'extends Computer' 키워드를 통해 Samsung이 Computer의 모든 속성과 기능을 물려받았다는 것을 알 수 있죠.
 *
 * 삼성 컴퓨터는 일반적인 컴퓨터의 기능(전원 켜고 끄기) 외에,
 * 삼성만의 특별한 기능(예: 빅스비 실행)을 가질 수 있습니다.
 *
 * 여기서는 '메소드 오버라이딩'을 통해 부모의 기능을 자식에 맞게 변경하고,
 * 자식 클래스만의 새로운 기능을 추가하는 방법을 배워볼 거예요.
 */
public class Samsung extends Computer {

    // === 메소드 오버라이딩 (Method Overriding) ===
    /**
     * 부모 클래스(Computer)의 powerOn() 메소드를 Samsung 클래스에 맞게 재정의합니다.
     *
     * '@Override' 어노테이션:
     * 이 어노테이션은 "나는 지금 부모 클래스의 메소드를 재정의하고 있어요!"라고 컴파일러에게 알려주는 역할을 해요.
     * 만약 부모 클래스에 해당 이름의 메소드가 없거나, 매개변수 등이 다르면 컴파일러가 오류를 알려줘서
     * 실수를 줄일 수 있게 도와줍니다. 필수는 아니지만, 사용하는 것이 좋은 습관입니다.
     *
     * 'super.powerOn()':
     * 'super' 키워드는 부모 클래스를 의미한다고 했죠?
     * 'super.powerOn()'은 "부모 클래스인 Computer의 powerOn() 메소드를 먼저 실행해줘!"라는 뜻이에요.
     * 이렇게 하면 부모의 원래 기능을 그대로 사용하면서, 자식 클래스에서 추가적인 동작을 덧붙일 수 있습니다.
     */
    @Override
    void powerOn() {
        super.powerOn(); // 부모 클래스의 powerOn() 메소드 호출 (예: "컴퓨터가 켜졌습니다." 출력)
        System.out.println("!I love Samsung!"); // 삼성 컴퓨터만의 추가 메시지 출력
    }

    // === Samsung 클래스 고유의 메소드 ===
    /**
     * 이 메소드는 Samsung 클래스에만 존재하는 고유한 기능입니다.
     * 부모 클래스인 Computer에는 없는 기능이죠.
     * 삼성 컴퓨터에서 빅스비를 실행하는 기능을 시뮬레이션합니다.
     */
    void runBixby() {
        System.out.println("빅스비가 실행됩니다. 무엇을 도와드릴까요?");
    }

    // 참고: powerOff() 메소드는 오버라이딩하지 않았습니다.
    // 따라서 Samsung 객체에서 powerOff()를 호출하면 Computer 클래스의 powerOff()가 그대로 실행됩니다.
}