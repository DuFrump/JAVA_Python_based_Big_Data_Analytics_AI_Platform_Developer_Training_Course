package _05_Inheritance_camera;

// ActionCam 클래스는 Camera 클래스를 상속받는 자식 클래스입니다.
// 액션 카메라만의 특성을 정의합니다.
public class ActionCam extends Camera {
    // [1] `final` 필드 (상수)
    // `final` 키워드가 붙은 변수는 한 번 초기화되면 값을 변경할 수 없는 상수가 됩니다.
    // 일반적으로 상수는 대문자로 표기합니다.
    public final String lens = "광각렌즈";

    // 생성자: ActionCam 객체를 생성할 때 호출됩니다.
    // `super("액션 카메라")`를 통해 부모 클래스(Camera)의 생성자를 호출하여 `name`을 초기화합니다.
    public ActionCam() {
        super("액션 카메라");
    }

    // [2] `final` 메소드
    // `final` 키워드가 붙은 메소드는 자식 클래스에서 오버라이딩(재정의)할 수 없습니다.
    // 이 메소드는 액션 카메라로 촬영한 비디오를 제작하는 기능을 정의합니다.
    public final void makeVideo() {
        System.out.printf("%s : %s로 촬영한 비디오를 제작%n", this.name, this.lens);
    }

    // [참고] 부모 클래스의 메소드 오버라이딩 (예시)
    // @Override
    // public void showMainFeature() {
    //     System.out.printf("%s의 주요 기능 : 사진 촬영, 동영상 녹화, %s 비디오 제작%n", this.name, this.lens);
    // }
}
