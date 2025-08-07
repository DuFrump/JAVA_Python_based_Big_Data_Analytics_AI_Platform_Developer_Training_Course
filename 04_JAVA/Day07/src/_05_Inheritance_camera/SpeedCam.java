package _05_Inheritance_camera;

// SpeedCam 클래스는 Camera 클래스를 상속받는 자식 클래스입니다.
// 과속 단속 카메라만의 특성과 기능을 정의합니다.
public class SpeedCam extends Camera {
    // 생성자: SpeedCam 객체를 생성할 때 호출됩니다.
    // `super("과속 단속 카메라")`를 통해 부모 클래스(Camera)의 생성자를 호출하여 `name`을 초기화합니다.
    public SpeedCam() {
        super("과속 단속 카메라");
    }

    // [1] 메소드 오버라이딩: `takePicture()`
    // 부모 클래스의 `takePicture()` 메소드를 재정의합니다.
    // 속도 측정 및 차량 번호 식별 기능을 추가한 후, 부모의 사진 촬영 기능을 호출합니다.
    @Override
    public void takePicture() {
        checkSpeed();        // 속도 측정 기능 호출
        recognizeNumber();   // 차량 번호 식별 기능 호출
        super.takePicture(); // 부모 클래스의 사진 촬영 기능 호출
    }

    // [2] 메소드 오버라이딩: `recordVideo()`
    // 부모 클래스의 `recordVideo()` 메소드를 재정의합니다.
    // 속도 측정 및 차량 번호 식별 기능을 추가한 후, 자체적인 동영상 녹화 메시지를 출력합니다.
    @Override
    public void recordVideo() {
        checkSpeed();      // 속도 측정 기능 호출
        recognizeNumber(); // 차량 번호 식별 기능 호출
        System.out.println("동영상을 녹화합니다."); // 과속 단속 카메라만의 동영상 녹화 메시지
    }

    // [3] SpeedCam 고유의 메소드: `checkSpeed()`
    // 속도를 측정하는 기능입니다.
    public void checkSpeed() {
        System.out.println("속도를 측정합니다.");
    }

    // [4] SpeedCam 고유의 메소드: `recognizeNumber()`
    // 차량 번호를 식별하는 기능입니다.
    public void void recognizeNumber() {
        System.out.println("차량 번호를 식별합니다.");
    }

    // [5] 메소드 오버라이딩: `showMainFeature()`
    // 부모 클래스의 `showMainFeature()` 메소드를 재정의하여 과속 단속 카메라의 주요 기능을 설명합니다.
    @Override
    public void showMainFeature() {
        System.out.printf("%s의 주요 기능 : 과속 단속%n", this.name);
    }
}
