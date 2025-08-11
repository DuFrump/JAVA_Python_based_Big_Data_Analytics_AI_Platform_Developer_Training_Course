package _05_Practice_Computer;

/**
 * 안녕하세요, 두프룸프님! 이번에는 '컴퓨터실'을 만들어 여러 대의 컴퓨터를 관리하는 예제를 살펴볼 거예요.
 * 이 `ComputerRoom` 클래스는 우리가 앞서 만든 `Computer`, `LG`, `Samsung` 클래스들을 활용하여
 * '다형성(Polymorphism)'이 실제 애플리케이션에서 어떻게 유용하게 사용되는지 보여줍니다.
 *
 * 다형성을 사용하면 다양한 종류의 컴퓨터(LG, Samsung 등)를 모두 'Computer'라는 하나의 타입으로 묶어서
 * 일괄적으로 제어할 수 있게 됩니다. 이는 코드의 유연성과 확장성을 크게 높여줍니다.
 *
 * 이 예제에서는 다음을 중점적으로 살펴볼 거예요:
 * 1. 부모 클래스 타입의 참조 변수로 다양한 자식 객체를 저장하는 방법
 * 2. 다형성을 통해 동일한 메소드 호출이 실제 객체에 따라 다르게 동작하는 원리
 *
 * 자, 그럼 컴퓨터실을 함께 운영해볼까요?
 */
public class ComputerRoom {
    // [1] 다형성 활용: 부모 클래스(`Computer`) 타입의 참조 변수로 자식 클래스 객체를 참조
    // 이렇게 `Computer` 타입으로 변수를 선언하면, `Samsung`, `LG` 등
    // `Computer`를 상속받는 어떤 종류의 컴퓨터 객체든 이 변수에 저장할 수 있습니다.
    // 이는 코드의 유연성을 극대화하여, 나중에 새로운 컴퓨터 브랜드가 추가되어도
    // 이 `ComputerRoom` 클래스의 코드를 크게 변경할 필요가 없게 해줍니다.
    Computer computer1;
    Computer computer2;
    Computer computer3;
    Computer computer4;

    // [참고] 만약 아래와 같이 특정 자식 클래스 타입으로 선언했다면,
    // 해당 타입의 객체만 저장할 수 있어 유연성이 떨어지고, 다양한 컴퓨터를 관리하기 어려워집니다.
    // Samsung computer1; // 이 변수에는 Samsung 컴퓨터만 저장 가능
    // LG computer2;      // 이 변수에는 LG 컴퓨터만 저장 가능

    // 모든 컴퓨터의 전원을 켜는 메소드
    void allPowerOn() {
        System.out.println("--- 모든 컴퓨터 전원 켜기 ---");
        // 각 `computer` 변수가 참조하는 실제 객체(Samsung, LG, Computer)에 따라
        // 오버라이딩된 `powerOn()` 메소드가 호출됩니다. 이것이 바로 다형성입니다!
        // 예를 들어, `computer1`이 `LG` 객체라면 `LG`의 `powerOn()`이, `computer2`가 `Samsung` 객체라면 `Samsung`의 `powerOn()`이 실행됩니다.
        computer1.powerOn();
        computer2.powerOn();
        computer3.powerOn();
        computer4.powerOn();
    }

    // 모든 컴퓨터의 전원을 끄는 메소드
    void allPowerOff() {
        System.out.println("--- 모든 컴퓨터 전원 끄기 ---");
        // `powerOff()` 메소드는 `Samsung` 클래스에서는 오버라이딩되지 않았고,
        // `LG` 클래스에서는 오버라이딩되었습니다.
        // 따라서 `Samsung` 객체는 부모인 `Computer`의 `powerOff()`를 호출하고,
        // `LG` 객체는 `LG` 자체의 `powerOff()`를 호출합니다.
        // 이 또한 다형성의 한 예시로, 동일한 메소드 호출이 객체의 실제 타입에 따라 다르게 동작하는 것을 보여줍니다.
        computer1.powerOff();
        computer2.powerOff();
        computer3.powerOff();
        computer4.powerOff();
    }
}
