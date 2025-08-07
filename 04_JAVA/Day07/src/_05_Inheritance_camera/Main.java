package _05_Inheritance_camera;

// Main 클래스는 Camera, FactoryCam, SpeedCam 클래스를 사용하여 객체를 생성하고
// 상속과 다형성(Polymorphism)의 개념을 확인하는 예제입니다.
public class Main {
    public static void main(String[] args) {
        // [1] 각 클래스의 객체 생성
        Camera c01 = new Camera("일반 카메라");
        FactoryCam fc01 = new FactoryCam(); // FactoryCam의 생성자에서 name이 "공장 카메라"로 설정됨
        SpeedCam sc01 = new SpeedCam();     // SpeedCam의 생성자에서 name이 "과속 단속 카메라"로 설정됨

        // 각 객체의 name 필드 출력
        System.out.println("--- 각 카메라의 이름 ---");
        System.out.println(c01.name);
        System.out.println(fc01.name);
        System.out.println(sc01.name);

        System.out.println("\n==============================\n");

        // [2] 일반 카메라 (Camera)의 메소드 호출
        System.out.println("--- 일반 카메라 기능 ---");
        c01.showMainFeature(); // Camera 클래스의 showMainFeature() 호출
        c01.takePicture();     // Camera 클래스의 takePicture() 호출
        c01.recordVideo();     // Camera 클래스의 recordVideo() 호출

        System.out.println("\n==============================\n");

        // [3] 공장 카메라 (FactoryCam)의 메소드 호출
        System.out.println("--- 공장 카메라 기능 ---");
        fc01.showMainFeature(); // FactoryCam에서 오버라이딩된 showMainFeature() 호출
        fc01.takePicture();     // FactoryCam에서 오버라이딩된 takePicture() 호출
        fc01.recordVideo();     // FactoryCam에서 오버라이딩된 recordVideo() 호출 (내부적으로 detectFire() 호출)

        System.out.println("\n==============================\n
");

        // [4] 과속 단속 카메라 (SpeedCam)의 메소드 호출
        System.out.println("--- 과속 단속 카메라 기능 ---");
        sc01.showMainFeature(); // SpeedCam에서 오버라이딩된 showMainFeature() 호출
        sc01.takePicture();     // SpeedCam에서 오버라이딩된 takePicture() 호출 (내부적으로 checkSpeed(), recognizeNumber() 호출)
        sc01.recordVideo();     // SpeedCam에서 오버라이딩된 recordVideo() 호출 (내부적으로 checkSpeed(), recognizeNumber() 호출)


        // -------------------------------- 다형성 (Polymorphism) -------------------------------------
        // 다형성: 하나의 객체가 여러 가지 형태를 가질 수 있는 능력
        // 부모 클래스 타입의 참조 변수로 자식 클래스의 객체를 참조할 수 있습니다.
        // 이 경우, 부모 클래스에 정의된 메소드만 호출할 수 있지만,
        // 실제 실행되는 메소드는 자식 클래스에서 오버라이딩된 메소드입니다.

        System.out.println("\n================= 다형성 부분 ===================\n");

        // Camera 타입의 배열을 선언하고, 각기 다른 자식 클래스의 객체를 할당합니다.
        Camera[] cameras = new Camera[3];

        cameras[0] = new Camera();     // 일반 카메라 객체
        cameras[1] = new FactoryCam(); // FactoryCam 객체 (Camera 타입으로 참조)
        cameras[2] = new SpeedCam();   // SpeedCam 객체 (Camera 타입으로 참조)

        // 향상된 for 문을 사용하여 배열의 모든 카메라 객체를 순회합니다.
        for (Camera cam : cameras) {
            // 각 객체의 showMainFeature() 메소드를 호출합니다.
            // 실제 호출되는 메소드는 객체의 실제 타입(FactoryCam, SpeedCam)에 따라 달라집니다.
            // 이것이 바로 다형성의 핵심입니다.
            cam.showMainFeature();
        }

        // 추가 예시: ActionCam과 SlowActionCam
        System.out.println("\n--- ActionCam과 SlowActionCam 다형성 ---");
        Camera[] actionCameras = new Camera[2];
        actionCameras[0] = new ActionCam();
        actionCameras[1] = new SlowActionCam();

        for (Camera cam : actionCameras) {
            cam.showMainFeature();
            // cam.makeVideo(); // 에러: Camera 클래스에는 makeVideo() 메소드가 정의되어 있지 않음
            // 자식 클래스 고유의 메소드를 호출하려면 형변환(다운캐스팅)이 필요합니다.
            if (cam instanceof ActionCam) { // cam이 ActionCam 타입의 인스턴스인지 확인
                ((ActionCam) cam).makeVideo(); // ActionCam으로 형변환 후 makeVideo() 호출
            }
        }
    }
}