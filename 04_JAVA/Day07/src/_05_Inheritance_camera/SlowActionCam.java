package _05_Inheritance_camera;

// SlowActionCam 클래스는 ActionCam 클래스를 상속받는 자식 클래스입니다.
// 슬로우 액션 카메라만의 특성을 정의합니다.
public class SlowActionCam extends ActionCam {
    // 생성자: SlowActionCam 객체를 생성할 때 호출됩니다.
    // 부모 클래스(ActionCam)의 생성자를 호출하지 않고, 직접 name 필드를 초기화합니다.
    // (ActionCam의 생성자가 매개변수 없는 기본 생성자이므로 super() 호출이 생략 가능합니다.)
    public SlowActionCam() {
        this.name = "슬로우 액션 카메라";
    }

    // [중요] `ActionCam` 클래스의 `makeVideo()` 메소드는 `final`로 선언되어 있습니다.
    // `final` 메소드는 자식 클래스에서 오버라이딩(재정의)할 수 없습니다.
    // 아래 주석을 해제하면 컴파일 에러가 발생합니다.
    // @Override
    // public void makeVideo() { // 에러: makeVideo() in ActionCam cannot be overridden
    //     System.out.printf("%s : %s로 촬영한 슬로우 비디오 제작.%n", this.name, this.lens);
    // }

    // [참고] 부모 클래스의 `showMainFeature()` 메소드는 `final`이 아니므로 오버라이딩 가능합니다.
    @Override
    public void showMainFeature() {
        System.out.printf("%s의 주요 기능 : 사진 촬영, 동영상 녹화, 슬로우 모션 비디오 제작%n", this.name);
    }
}
