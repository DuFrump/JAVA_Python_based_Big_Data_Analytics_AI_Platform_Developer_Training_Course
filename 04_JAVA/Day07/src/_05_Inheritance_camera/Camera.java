package _05_Inheritance_camera;

// Camera 클래스는 모든 카메라의 기본적인 기능을 정의하는 부모 클래스(Superclass)입니다.
public class Camera {
    // 필드: 카메라의 이름을 저장합니다.
    public String name;

    // [1] 기본 생성자 (Default Constructor)
    // 매개변수 없이 호출될 때, `this("카메라")`를 통해 다른 생성자를 호출하여 `name`을 "카메라"로 초기화합니다.
    public Camera() {
        this("카메라");
    }

    // [2] 매개변수 있는 생성자
    // `protected` 접근 제어자를 가집니다. 동일 패키지 내에서 접근 가능하며,
    // 다른 패키지에서는 이 클래스를 상속받은 자식 클래스에서만 접근 가능합니다.
    protected Camera(String name) {
        this.name = name;
    }

    // 메소드: 사진 촬영 기능을 정의합니다.
    public void takePicture() {
        System.out.printf("%s : 사진을 촬영합니다%n", this.name);
    }

    // 메소드: 동영상 녹화 기능을 정의합니다.
    public void recordVideo() {
        System.out.printf("%s : 동영상을 녹화합니다%n", this.name);
    }

    // 메소드: 카메라의 주요 기능을 보여줍니다.
    public void showMainFeature() {
        System.out.printf("%s의 주요 기능 : 사진 촬영, 동영상 녹화%n", this.name);
    }
}
