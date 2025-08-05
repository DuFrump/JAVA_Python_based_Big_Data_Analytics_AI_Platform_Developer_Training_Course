package _05_Inheritance_camera;

public class Main {
    public static void main(String[] args) {
        Camera c01 = new Camera("일반 카메라");
        FactoryCam fc01 = new FactoryCam();
        SpeedCam sc01 = new SpeedCam();

        System.out.println(c01.name);
        System.out.println(fc01.name);
        System.out.println(sc01.name);

        System.out.println("==============================");

        c01.showMainFeature();
        c01.takePicture();
        c01.recordVideo();

        System.out.println("==============================");

        fc01.showMainFeature();
        fc01.takePicture();
        fc01.recordVideo();

        System.out.println("==============================");

        sc01.showMainFeature();
        sc01.takePicture();
        sc01.recordVideo();


        // -------------------------------- 8/5일 다형성 -------------------------------------

        System.out.println();
        System.out.println();
        System.out.println("=================8/5일 다형성 부분===================");
        System.out.println();

        Camera[] cameras = new Camera[3];

        cameras[0] = new Camera();
        cameras[1] = new FactoryCam();
        cameras[2] = new SpeedCam();

        for (Camera cam : cameras) {
            cam.showMainFeature();
        }
    }
}
