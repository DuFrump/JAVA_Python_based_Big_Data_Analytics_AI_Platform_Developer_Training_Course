package _05_Inheritance_camera;

public class ActionCam extends Camera {
    public final String lens = "광각렌즈";

    public ActionCam() {
        super("액션 카메라");
    }

    public final void makeVideo() {
        System.out.printf("%s : %s로 촬영한 비디오를 제작%n", this.name, this.lens);
    }
}
