package _06_Detector;

// Interface 클래스는 인터페이스(Interface)의 사용법과 다형성을 확인하는 예제입니다.
public class Interface {
    public static void main(String[] args) {
        // [1] 다형성 활용: 인터페이스 타입으로 구현 클래스 객체 참조
        // `Detectable` 인터페이스 타입의 참조 변수에 `FireDetector`, `AdvancedFireDetector`, `AccidentDetector` 객체를 할당합니다.
        // 이는 다양한 감지기를 일관된 `Detectable` 타입으로 다룰 수 있게 합니다.
        Detectable d1 = new FireDetector();
        Detectable d2 = new AdvancedFireDetector();
        Detectable d3 = new AccidentDetector();

        System.out.println("--- 다양한 감지기 동작 ---");
        // [2] 단일 메소드 호출을 통한 다양한 동작
        // 각 `Detectable` 타입의 참조 변수에 대해 `detect()` 메소드를 호출합니다.
        // 실제 호출되는 `detect()` 메소드는 객체의 실제 타입(FireDetector, AdvancedFireDetector, AccidentDetector)에 따라 달라집니다.
        // 이것이 바로 인터페이스를 통한 다형성의 핵심입니다.
        d1.detect(); // FireDetector의 detect() 호출
        d2.detect(); // AdvancedFireDetector의 detect() 호출
        d3.detect(); // AccidentDetector의 detect() 호출

        System.out.println("
----------------------------------------
");
        System.out.println("새로운 감지기가 추가되어도 `Interface` 클래스의 코드를 수정할 필요가 없습니다.");
        System.out.println("이는 코드의 유연성과 확장성을 크게 향상시킵니다.");
    }
}
