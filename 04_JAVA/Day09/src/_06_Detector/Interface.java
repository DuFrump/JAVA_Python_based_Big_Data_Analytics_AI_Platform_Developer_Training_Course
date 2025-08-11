/**
 * 안녕하세요, 두프룸프님! 이번 예제에서는 '인터페이스(Interface)'와 '다형성(Polymorphism)'이
 * 어떻게 결합되어 코드의 '유연성'과 '확장성'을 극대화하는지 배워볼 거예요.
 * 다양한 종류의 감지기(화재 감지기, 사고 감지기 등)를 하나의 인터페이스로 묶어
 * 일관된 방식으로 처리하는 방법을 살펴봅시다!
 *
 * <오늘 배울 핵심 개념>
 * 1.  **인터페이스 (Interface) 복습**: 
 *     - `Detectable` 인터페이스는 모든 감지기가 가져야 할 공통적인 기능인 `detect()` 메소드를 정의합니다.
 *     - 이 인터페이스를 구현하는 클래스들은 각자의 방식으로 `detect()` 메소드를 구현합니다.
 *
 * 2.  **인터페이스를 통한 다형성**: 
 *     - `Detectable d1 = new FireDetector();`와 같이 인터페이스 타입의 참조 변수가
 *       해당 인터페이스를 구현한 클래스의 객체를 참조할 수 있습니다.
 *     - 이를 통해 `d1`, `d2`, `d3`와 같이 서로 다른 종류의 감지기 객체들을
 *       `Detectable`이라는 하나의 공통된 타입으로 묶어 일관되게 다룰 수 있습니다.
 *
 * 3.  **코드의 유연성 및 확장성**: 
 *     - `d1.detect()`, `d2.detect()`, `d3.detect()`와 같이 동일한 `detect()` 메소드를 호출하지만,
 *       실제 실행되는 내용은 각 객체의 타입에 따라 다르게 동작합니다.
 *     - 가장 중요한 점은, 새로운 종류의 감지기(예: `GasDetector`)가 추가되어도
 *       `main` 메소드의 코드를 수정할 필요 없이 새로운 감지기 객체를 생성하여 `Detectable` 타입으로 참조하기만 하면 됩니다.
 *       이는 코드의 유지보수를 쉽게 하고, 새로운 기능을 추가하기 용이하게 만듭니다.
 *
 * 이 예제를 통해 인터페이스와 다형성이 객체 지향 프로그래밍에서 얼마나 강력한 도구인지 이해할 수 있을 거예요.
 * 함께 코드를 분석하며 이 개념들을 확실히 마스터해 봅시다!
 */

package _06_Detector;

// Interface 클래스는 인터페이스(Interface)의 사용법과 다형성을 확인하는 예제입니다.
// 프로그램의 시작점인 main 메소드를 포함하고 있습니다.
public class Interface {
    public static void main(String[] args) {
        // [1] 다형성 활용: 인터페이스 타입으로 구현 클래스 객체 참조
        // `Detectable` 인터페이스 타입의 참조 변수에 `FireDetector`, `AdvancedFireDetector`, `AccidentDetector` 객체를 할당합니다.
        // 이는 다양한 감지기(서로 다른 클래스의 객체)를 `Detectable`이라는 하나의 공통된 타입으로 묶어
        // 일관된 방식으로 다룰 수 있게 해줍니다. 이것이 바로 다형성의 핵심입니다.
        Detectable d1 = new FireDetector();
        Detectable d2 = new AdvancedFireDetector();
        Detectable d3 = new AccidentDetector();

        System.out.println("--- 다양한 감지기 동작 ---");
        // [2] 단일 메소드 호출을 통한 다양한 동작
        // 각 `Detectable` 타입의 참조 변수에 대해 `detect()` 메소드를 호출합니다.
        // 실제 호출되는 `detect()` 메소드는 객체의 실제 타입(FireDetector, AdvancedFireDetector, AccidentDetector)에 따라 달라집니다.
        // 예를 들어, `d1.detect()`는 `FireDetector`의 `detect()`를, `d2.detect()`는 `AdvancedFireDetector`의 `detect()`를 호출합니다.
        d1.detect(); // FireDetector의 detect() 호출
        d2.detect(); // AdvancedFireDetector의 detect() 호출
        d3.detect(); // AccidentDetector의 detect() 호출

        System.out.println("\n----------------------------------------\n");
        System.out.println("새로운 감지기가 추가되어도 `Interface` 클래스의 코드를 수정할 필요가 없습니다.");
        System.out.println("이는 코드의 유연성과 확장성을 크게 향상시킵니다.");
        System.out.println("예를 들어, `Detectable d4 = new GasDetector();`와 같이 새로운 감지기를 추가해도");
        System.out.println("기존의 `main` 메소드 로직은 그대로 유지됩니다.");
    }
}