package _05_Camera;

// `_06_AbstractClass` 클래스는 추상 클래스(Abstract Class)의 사용법과 다형성을 확인하는 예제입니다.
public class _06_AbstractClass {
    public static void main(String[] args) {
        // [1] 추상 클래스는 직접 객체를 생성할 수 없습니다.
        // 아래 주석을 해제하면 컴파일 에러가 발생합니다.
        // Camera camera = new Camera(); // 에러: Camera is abstract; cannot be instantiated
        System.out.println("Camera는 추상 클래스이므로 직접 객체 생성이 불가능합니다.");

        System.out.println("
----------------------------------------
");

        // [2] 추상 클래스를 상속받아 구현한 자식 클래스의 객체 생성
        // FactoryCam은 Camera 추상 클래스의 추상 메소드를 구현했으므로 객체 생성이 가능합니다.
        FactoryCam factoryCam = new FactoryCam();
        System.out.println("--- FactoryCam 객체 사용 ---");
        factoryCam.showFeature();     // Camera 클래스에서 상속받은 일반 메소드 호출
        factoryCam.showMainFeature(); // FactoryCam에서 구현된 추상 메소드 호출

        System.out.println("
----------------------------------------
");

        // [3] 다형성(Polymorphism) 활용
        // 추상 클래스 타입의 참조 변수는 자식 클래스의 객체를 참조할 수 있습니다.
        // 이를 통해 다양한 카메라 객체를 일관된 방식으로 다룰 수 있습니다.
        Camera speedCam = new SpeedCam();
        Camera factoryCamPoly = new FactoryCam();

        System.out.println("--- 다형성을 활용한 카메라 기능 ---");
        speedCam.showFeature();
        speedCam.showMainFeature(); // SpeedCam에서 구현된 showMainFeature() 호출

        factoryCamPoly.showFeature();
        factoryCamPoly.showMainFeature(); // FactoryCam에서 구현된 showMainFeature() 호출
    }
}
