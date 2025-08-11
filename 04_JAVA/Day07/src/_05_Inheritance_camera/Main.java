package _05_Inheritance_camera;

/**
 * 다섯 번째 예제의 마지막 파일, Main 클래스입니다!
 * 여기서는 우리가 만든 다양한 카메라 클래스들(Camera, FactoryCam, SpeedCam, ActionCam, SlowActionCam)의
 * 객체를 생성하고, 그 기능들을 호출하면서 '상속'과 '메소드 오버라이딩', 그리고 '다형성(Polymorphism)'이라는
 * 자바 객체 지향 프로그래밍의 핵심 개념들을 종합적으로 확인하는 중요한 시간이에요.
 *
 * 'public static void main(String[] args)' 메소드는 자바 프로그램이 시작되는 지점이라는 것,
 * 이제는 잘 아시죠? 여기서 객체를 만들고 메소드를 호출하면서 동작을 살펴봅시다.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("--- [1] 각 클래스의 객체 생성 및 기본 기능 테스트 ---");

        // Camera 객체 생성: 기본 생성자를 통해 name이 "카메라"로 초기화됩니다.
        Camera c01 = new Camera();
        // FactoryCam 객체 생성: 생성자에서 super("공장 카메라")를 호출하여 name이 "공장 카메라"로 초기화됩니다.
        FactoryCam fc01 = new FactoryCam();
        // SpeedCam 객체 생성: 생성자에서 super("과속 단속 카메라")를 호출하여 name이 "과속 단속 카메라"로 초기화됩니다.
        SpeedCam sc01 = new SpeedCam();
        // ActionCam 객체 생성: 생성자에서 super("액션 카메라")를 호출하여 name이 "액션 카메라"로 초기화됩니다.
        ActionCam ac01 = new ActionCam();
        // SlowActionCam 객체 생성: 생성자에서 name을 "슬로우 액션 카메라"로 재설정합니다.
        SlowActionCam sac01 = new SlowActionCam();

        System.out.println("\n--- 각 카메라의 이름 확인 ---");
        System.out.println("일반 카메라: " + c01.name);
        System.out.println("공장 카메라: " + fc01.name);
        System.out.println("과속 단속 카메라: " + sc01.name);
        System.out.println("액션 카메라: " + ac01.name);
        System.out.println("슬로우 액션 카메라: " + sac01.name);

        System.out.println("\n==============================\n");

        System.out.println("--- [2] 일반 카메라 (Camera) 기능 ---");
        // Camera 클래스에 정의된 기본 메소드들이 호출됩니다.
        c01.showMainFeature();
        c01.takePicture();
        c01.recordVideo();

        System.out.println("\n==============================\n");

        System.out.println("--- [3] 공장 카메라 (FactoryCam) 기능 ---");
        // FactoryCam에서 오버라이딩된 메소드들이 호출됩니다.
        // takePicture()는 부모의 기능을 완전히 대체하고,
        // recordVideo()는 detectFire()를 먼저 호출한 후 super.recordVideo()를 호출합니다.
        fc01.showMainFeature();
        fc01.takePicture();
        fc01.recordVideo();
        fc01.detectFire(); // FactoryCam 고유의 메소드

        System.out.println("\n==============================\n");

        System.out.println("--- [4] 과속 단속 카메라 (SpeedCam) 기능 ---");
        // SpeedCam에서 오버라이딩된 메소드들이 호출됩니다.
        // takePicture()와 recordVideo() 모두 checkSpeed()와 recognizeNumber()를 먼저 호출합니다.
        sc01.showMainFeature();
        sc01.takePicture();
        sc01.recordVideo();
        sc01.checkSpeed();     // SpeedCam 고유의 메소드
        sc01.recognizeNumber(); // SpeedCam 고유의 메소드

        System.out.println("\n==============================\n");

        System.out.println("--- [5] 액션 카메라 (ActionCam) 기능 ---");
        // ActionCam에서 오버라이딩된 showMainFeature()와 final makeVideo()가 호출됩니다.
        ac01.showMainFeature();
        ac01.takePicture(); // Camera의 takePicture() 상속
        ac01.recordVideo(); // Camera의 recordVideo() 상속
        ac01.makeVideo();   // ActionCam 고유의 final 메소드

        System.out.println("\n==============================\n");

        System.out.println("--- [6] 슬로우 액션 카메라 (SlowActionCam) 기능 ---");
        // SlowActionCam에서 오버라이딩된 showMainFeature()와 ActionCam의 final makeVideo()가 호출됩니다.
        sac01.showMainFeature();
        sac01.takePicture(); // Camera의 takePicture() 상속
        sac01.recordVideo(); // Camera의 recordVideo() 상속
        sac01.makeVideo();   // ActionCam의 final makeVideo() 상속 (오버라이딩 불가)

        System.out.println("\n===================================================\n");
        System.out.println("--- [7] 다형성 (Polymorphism)의 이해 ---");
        System.out.println("다형성은 '하나의 객체가 여러 가지 형태를 가질 수 있는 능력'을 의미합니다.");
        System.out.println("자바에서는 부모 클래스 타입의 참조 변수로 자식 클래스의 객체를 참조할 수 있습니다.");
        System.out.println("이때, 실제 호출되는 메소드는 참조 변수의 타입이 아닌, 객체의 실제 타입에 따라 결정됩니다.");
        System.out.println("이를 '동적 바인딩(Dynamic Binding)' 또는 '런타임 다형성'이라고 합니다.");

        // Camera 타입의 배열을 선언하고, 각기 다른 자식 클래스의 객체를 할당합니다.
        Camera[] cameras = new Camera[5]; // 5개의 Camera 객체를 담을 수 있는 배열 생성

        cameras[0] = new Camera();        // Camera 객체
        cameras[1] = new FactoryCam();    // FactoryCam 객체 (Camera 타입으로 참조)
        cameras[2] = new SpeedCam();      // SpeedCam 객체 (Camera 타입으로 참조)
        cameras[3] = new ActionCam();     // ActionCam 객체 (Camera 타입으로 참조)
        cameras[4] = new SlowActionCam(); // SlowActionCam 객체 (Camera 타입으로 참조)

        System.out.println("\n--- 배열을 통한 다형성 활용 ---");
        // 향상된 for 문을 사용하여 배열의 모든 카메라 객체를 순회합니다.
        for (Camera cam : cameras) {
            // 각 객체의 showMainFeature() 메소드를 호출합니다.
            // 참조 변수는 Camera 타입이지만, 실제 호출되는 메소드는
            // 객체의 실제 타입(FactoryCam, SpeedCam, ActionCam, SlowActionCam)에 따라 달라집니다.
            // 이것이 바로 다형성의 핵심입니다.
            cam.showMainFeature();
        }

        System.out.println("\n--- 다형성과 다운캐스팅 (Downcasting) ---");
        System.out.println("부모 타입의 참조 변수로는 자식 클래스에만 있는 고유한 메소드를 직접 호출할 수 없습니다.");
        System.out.println("예: cam.makeVideo(); // 에러! Camera 클래스에는 makeVideo() 메소드가 정의되어 있지 않음");
        System.out.println("자식 클래스 고유의 메소드를 호출하려면 '형변환(다운캐스팅)'이 필요합니다.");

        for (Camera cam : cameras) {
            // instanceof 연산자: 객체가 특정 타입의 인스턴스인지 확인합니다.
            // 안전하게 다운캐스팅하기 위해 반드시 instanceof로 먼저 확인해야 합니다.
            if (cam instanceof ActionCam) {
                // ActionCam 타입으로 다운캐스팅: 부모 타입의 참조 변수를 자식 타입으로 변환합니다.
                // 이렇게 해야 ActionCam에만 있는 makeVideo() 메소드를 호출할 수 있습니다.
                ((ActionCam) cam).makeVideo();
            }
        }
        System.out.println("다운캐스팅을 통해 ActionCam의 makeVideo() 메소드를 호출했습니다.");

        System.out.println("\n--- 모든 카메라 예제 테스트 완료 ---");
        System.out.println("상속, 오버라이딩, final 키워드, 그리고 다형성까지 잘 이해하셨기를 바랍니다!");
    }
}