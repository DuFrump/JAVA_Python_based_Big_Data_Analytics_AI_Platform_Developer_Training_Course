package _05_Inheritance_camera;

public class _0805_11_Final {
    public static void main(String[] args) {
        // Final
        ActionCam actionCam = new ActionCam();
//        actionCam.lens = "표준렌즈"; --> lens 필드가 파이널 필드라서 바꿀 수 없다!
        actionCam.recordVideo();
        actionCam.makeVideo();

        System.out.println("=================================");

        SlowActionCam slowActionCam = new SlowActionCam();
        slowActionCam.recordVideo();
        slowActionCam.makeVideo();
    }
}
