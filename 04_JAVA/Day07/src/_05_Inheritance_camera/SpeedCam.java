package _05_Inheritance_camera;

public class SpeedCam extends Camera {
    public SpeedCam() {
        super("과속 단속 카메라");
    }

    @Override
    public void takePicture() {
        checkSpeed();
        recognizeNumber();
        super.takePicture();
    }

    @Override
    public void recordVideo() {
        checkSpeed();
        recognizeNumber();
        System.out.println("동영상을 녹화합니다.");
    }

    public void checkSpeed() {
        System.out.println("속도를 측정합니다.");
    }

    public void recognizeNumber() {
        System.out.println("차량 번호를 식별합니다.");
    }

    @Override
    public void showMainFeature() {
        System.out.printf("%s의 주요 기능 : 과속 단속%n", this.name);
    }
}
