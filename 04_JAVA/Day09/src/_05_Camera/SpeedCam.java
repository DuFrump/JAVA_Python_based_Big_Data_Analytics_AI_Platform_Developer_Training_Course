package _05_Camera;

// SpeedCam 클래스는 Camera 추상 클래스를 상속받는 자식 클래스입니다.
// Camera 클래스의 추상 메소드인 `showMainFeature()`를 반드시 구현해야 합니다.
public class SpeedCam extends Camera {
    // 추상 메소드 구현: `showMainFeature()`
    // 부모 클래스(Camera)의 추상 메소드를 오버라이딩하여 과속 단속 카메라의 주요 기능을 출력합니다.
    @Override
    public void showMainFeature() {
        System.out.println("속도 측정, 번호 인식"); // 과속 단속 카메라의 주요 기능
    }

    // [참고] Camera 클래스의 일반 메소드(`showFeature()`)는 별도로 오버라이딩하지 않아도
    // SpeedCam 객체에서 그대로 사용할 수 있습니다.
}
