package _05_Inheritance_camera;

public class Camera {
    public String name;

    public Camera() { this("카메라"); }

    protected Camera(String name) { this.name = name; }

    public void takePicture() {
        System.out.printf("%s : 사진을 촬영합니다%n", this.name);
    }

    public void recordVideo() {
        System.out.printf("%s : 동영상을 녹화합니다%n", this.name);
    }

    public void showMainFeature() {
        System.out.printf("%s의 주요 기능 : 사진 촬영, 동영상 녹화%n", this.name);
    }
}
