/**
 * 안녕하세요, 두프룸프님! 이번 예제에서는 '추상 클래스(Abstract Class)'의 핵심 개념과
 * 이를 활용한 '다형성(Polymorphism)'을 카메라 예제를 통해 다시 한번 깊이 있게 다뤄볼 거예요.
 * 추상 클래스가 어떻게 공통된 기능을 정의하면서도, 자식 클래스에게 특정 기능의 구현을 강제하는지 살펴봅시다.
 *
 * <오늘 배울 핵심 개념>
 * 1.  **추상 클래스 (Abstract Class) 복습**:
 *     - `abstract` 키워드로 선언되며, 직접 객체를 생성할 수 없어요. (예: `new Camera()`는 불가능!)
 *     - 미완성된 메소드, 즉 '추상 메소드(Abstract Method)'를 가질 수 있습니다.
 *       추상 메소드는 선언만 있고 구현이 없는 메소드예요.
 *     - 추상 클래스를 상속받는 자식 클래스는 부모의 추상 메소드를 반드시 구현(오버라이딩)해야 합니다.
 *
 * 2.  **다형성 (Polymorphism) 활용**:
 *     - 추상 클래스 타입의 참조 변수는 자식 클래스의 객체를 참조할 수 있습니다.
 *       (예: `Camera speedCam = new SpeedCam();`)
 *     - 이를 통해 다양한 종류의 카메라 객체(FactoryCam, SpeedCam)를
 *       `Camera`라는 하나의 공통된 타입으로 묶어 일관되게 다룰 수 있습니다.
 *     - `showFeature()`와 같이 부모 클래스에 구현된 일반 메소드는 그대로 사용하고,
 *       `showMainFeature()`와 같이 자식 클래스에서 오버라이딩된 추상 메소드는
 *       실제 객체에 따라 다르게 동작하는 것을 확인할 수 있습니다.
 *
 * 이 예제를 통해 추상 클래스가 어떻게 코드의 구조를 잡고,
 * 다형성과 함께 유연하고 확장 가능한 프로그램을 만드는 데 기여하는지 이해할 수 있을 거예요.
 * 함께 코드를 분석하며 개념을 확실히 다져봅시다!
 */

package _05_Camera;

// `_06_AbstractClass` 클래스는 추상 클래스(Abstract Class)의 사용법과 다형성을 확인하는 예제입니다.
// 프로그램의 시작점인 main 메소드를 포함하고 있습니다.
public class _06_AbstractClass {
    public static void main(String[] args) {
        // [1] 추상 클래스는 직접 객체를 생성할 수 없습니다.
        // `Camera` 클래스는 `abstract` 키워드로 선언된 추상 클래스이므로,
        // 그 자체로는 '미완성된 설계도'와 같아서 직접 객체를 만들 수 없습니다.
        // 아래 주석을 해제하면 컴파일 에러가 발생합니다.
        // Camera camera = new Camera(); // 에러 메시지: Camera is abstract; cannot be instantiated
        System.out.println("Camera는 추상 클래스이므로 직접 객체 생성이 불가능합니다.");

        System.out.println("\n----------------------------------------\n");

        // [2] 추상 클래스를 상속받아 구현한 자식 클래스의 객체 생성
        // `FactoryCam`은 `Camera` 추상 클래스를 상속받아 모든 추상 메소드를 구현했기 때문에,
        // '완성된 설계도'가 되어 객체 생성이 가능합니다.
        FactoryCam factoryCam = new FactoryCam();
        System.out.println("--- FactoryCam 객체 사용 ---");
        factoryCam.showFeature();     // Camera 클래스에서 상속받은 일반 메소드 호출
        factoryCam.showMainFeature(); // FactoryCam에서 구현된 추상 메소드 호출 (오버라이딩된 메소드)

        System.out.println("\n----------------------------------------\n");

        // [3] 다형성(Polymorphism) 활용
        // 추상 클래스 타입의 참조 변수(`Camera`)는 그 추상 클래스를 상속받은 자식 클래스의 객체(`SpeedCam`, `FactoryCam`)를 참조할 수 있습니다.
        // 이는 다양한 종류의 카메라 객체들을 `Camera`라는 하나의 공통된 타입으로 묶어 일관되게 다룰 수 있게 해줍니다.
        Camera speedCam = new SpeedCam(); // Camera 타입으로 SpeedCam 객체 참조
        Camera factoryCamPoly = new FactoryCam(); // Camera 타입으로 FactoryCam 객체 참조

        System.out.println("--- 다형성을 활용한 카메라 기능 ---");
        System.out.println("\n--- SpeedCam --- ");
        speedCam.showFeature();     // Camera 클래스의 showFeature() 호출
        speedCam.showMainFeature(); // 실제 객체인 SpeedCam의 showMainFeature() 호출

        System.out.println("\n--- FactoryCam --- ");
        factoryCamPoly.showFeature();     // Camera 클래스의 showFeature() 호출
        factoryCamPoly.showMainFeature(); // 실제 객체인 FactoryCam의 showMainFeature() 호출

        // 여기서 `showFeature()`는 모든 카메라가 공통적으로 가지는 기능이고,
        // `showMainFeature()`는 각 카메라(공장 카메라, 과속 단속 카메라)마다 핵심 기능이 다르므로
        // 다르게 구현되어야 하는 부분입니다. 다형성을 통해 이 두 가지를 유연하게 처리할 수 있습니다.
    }
}