package _05_Inheritance_camera;

public class FactoryCam extends Camera {
    public FactoryCam() {
        super("공장 카메라");
    }

    @Override
    public void takePicture() {
        System.out.println("사진을 촬영합니다.");
    }

    @Override
    public void recordVideo() {
        detectFire();
        super.recordVideo();
    }

    public void detectFire() {
        System.out.println("화재를 감지했습니다!");
    }

    @Override
    public void showMainFeature() {
        System.out.printf("%s의 주요 기능 : 화재감지%n", this.name);
    }
}
