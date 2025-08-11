package _05_Practice_Computer;

/**
 * 안녕하세요, 두프룸프님! 이제 우리가 만든 `Computer`, `LG`, `Samsung` 클래스들과
 * `ComputerRoom` 클래스를 활용하여 다형성의 강력함을 직접 확인해볼 시간이에요.
 *
 * 이 `Main` 클래스에서는 다음을 중점적으로 살펴볼 겁니다:
 * 1. `ComputerRoom` 객체를 생성하고, 그 안에 다양한 종류의 컴퓨터 객체(`Samsung`, `LG`)를 할당하는 방법
 * 2. `ComputerRoom`의 메소드를 호출했을 때, 다형성에 의해 각 컴퓨터 객체의 오버라이딩된 메소드가
 *    어떻게 자동으로 호출되는지 확인하기
 *
 * 코드를 실행하면서 각 컴퓨터의 전원 메시지가 어떻게 다르게 출력되는지 주의 깊게 살펴보세요.
 * 이것이 바로 객체 지향 프로그래밍의 유연성과 확장성을 보여주는 좋은 예시랍니다!
 */
public class Main {
    public static void main(String[] args) {
        // `ComputerRoom` 객체 생성: 이제 이 객체가 우리 컴퓨터실을 관리할 거예요.
        ComputerRoom cr1 = new ComputerRoom();

        // [1] 다형성을 활용하여 `ComputerRoom`의 `Computer` 타입 변수에 다양한 자식 객체 할당
        // `Computer computer1 = new Samsung();` 와 같이 부모 타입(`Computer`)으로 자식 객체(`Samsung`, `LG`)를 참조합니다.
        // 이렇게 하면 `ComputerRoom` 클래스는 특정 브랜드에 종속되지 않고,
        // `Computer`를 상속받는 어떤 종류의 컴퓨터든 유연하게 관리할 수 있게 됩니다.
        cr1.computer1 = new Samsung(); // `computer1`은 `Samsung` 객체를 참조합니다.
        cr1.computer2 = new LG();      // `computer2`는 `LG` 객체를 참조합니다.
        cr1.computer3 = new Samsung(); // `computer3`은 `Samsung` 객체를 참조합니다.
        cr1.computer4 = new LG();      // `computer4`는 `LG` 객체를 참조합니다.

        System.out.println("--- 모든 컴퓨터 전원 켜기 ---");
        // `allPowerOn()` 메소드 호출 시, 각 `computer` 변수가 참조하는 실제 객체(`Samsung`, `LG`)에 따라
        // 오버라이딩된 `powerOn()` 메소드가 실행됩니다. 이것이 다형성의 마법이죠!
        cr1.allPowerOn();
        // 예상 출력:
        // 컴퓨터 전원이 켜졌습니다! (Computer의 powerOn)
        // I love Samsung! (Samsung의 추가 메시지)
        // 컴퓨터 전원이 켜졌습니다! (Computer의 powerOn)
        // 사랑해요! LG! (LG의 추가 메시지)
        // 컴퓨터 전원이 켜졌습니다! (Computer의 powerOn)
        // I love Samsung! (Samsung의 추가 메시지)
        // 컴퓨터 전원이 켜졌습니다! (Computer의 powerOn)
        // 사랑해요! LG! (LG의 추가 메시지)

        System.out.println("--- 모든 컴퓨터 전원 끄기 ---");
        // `allPowerOff()` 메소드 호출 시,
        // `Samsung` 객체는 `powerOff()`를 오버라이딩하지 않았으므로 `Computer`의 `powerOff()`가 호출됩니다.
        // `LG` 객체는 `powerOff()`를 오버라이딩했으므로 `LG`의 `powerOff()`가 호출됩니다.
        cr1.allPowerOff();
        // 예상 출력:
        // 컴퓨터 전원이 꺼졌습니다! (Computer의 powerOff)
        // 컴퓨터 전원이 꺼졌습니다! (Computer의 powerOff)
        // 사랑해요! LG! (LG의 추가 메시지)
        // 컴퓨터 전원이 꺼졌습니다! (Computer의 powerOff)
        // 컴퓨터 전원이 꺼졌습니다! (Computer의 powerOff)
        // 사랑해요! LG! (LG의 추가 메시지)

        System.out.println("두프룸프님, 컴퓨터실 예제를 통해 다형성이 실제 코드에서 어떻게 활용되는지 잘 이해하셨기를 바랍니다!");
    }
}
