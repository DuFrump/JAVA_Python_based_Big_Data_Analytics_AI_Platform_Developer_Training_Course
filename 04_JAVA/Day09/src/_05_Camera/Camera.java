package _05_Camera;

// Camera 클래스는 추상 클래스(Abstract Class)입니다.
// 모든 카메라의 공통적인 기능을 정의하며, 특정 기능(`showMainFeature()`)은 자식 클래스에서 반드시 구현하도록 강제합니다.
public abstract class Camera {
    // 일반 메소드: 카메라의 공통적인 기능을 보여줍니다.
    public void showFeature() {
        System.out.println("사진 촬영, 동영상 녹화");
    }

    // 추상 메소드: `showMainFeature()`
    // - 선언만 있고 구현(몸체)이 없는 메소드입니다.
    // - `abstract` 키워드를 사용하며, 반드시 추상 클래스 내에 선언되어야 합니다.
    // - 이 메소드는 자식 클래스에서 각 카메라의 주요 기능을 오버라이딩하여 구현해야 합니다.
    public abstract void showMainFeature();
}
