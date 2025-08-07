package _05_Inheritance_camera;

// FactoryCam 클래스는 Camera 클래스를 상속받는 자식 클래스입니다.
// 공장 카메라만의 특성과 기능을 정의합니다.
public class FactoryCam extends Camera {
    // 생성자: FactoryCam 객체를 생성할 때 호출됩니다.
    // `super("공장 카메라")`를 통해 부모 클래스(Camera)의 생성자를 호출하여 `name`을 초기화합니다.
    public FactoryCam() {
        super("공장 카메라");
    }

    // [1] 메소드 오버라이딩: `takePicture()`
    // 부모 클래스의 `takePicture()` 메소드를 재정의합니다.
    // `@Override` 어노테이션은 이 메소드가 오버라이딩되었음을 명시합니다.
    @Override
    public void takePicture() {
        System.out.println("사진을 촬영합니다."); // 공장 카메라만의 사진 촬영 메시지
    }

    // [2] 메소드 오버라이딩 및 부모 메소드 호출: `recordVideo()`
    // 부모 클래스의 `recordVideo()` 메소드를 재정의합니다.
    // `detectFire()` 메소드를 먼저 호출한 후, `super.recordVideo()`를 통해 부모의 기능을 실행합니다.
    @Override
    public void recordVideo() {
        detectFire(); // 공장 카메라 고유의 화재 감지 기능 호출
        super.recordVideo(); // 부모 클래스의 동영상 녹화 기능 호출
    }

    // [3] FactoryCam 고유의 메소드: `detectFire()`
    // 공장 카메라에만 있는 화재 감지 기능입니다.
    public void detectFire() {
        System.out.println("화재를 감지했습니다!");
    }

    // [4] 메소드 오버라이딩: `showMainFeature()`
    // 부모 클래스의 `showMainFeature()` 메소드를 재정의하여 공장 카메라의 주요 기능을 설명합니다.
    @Override
    public void showMainFeature() {
        System.out.printf("%s의 주요 기능 : 화재감지%n", this.name);
    }
}
