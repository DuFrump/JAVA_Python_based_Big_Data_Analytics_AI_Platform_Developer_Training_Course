package _05_Inheritance_camera;

// `final` 키워드의 사용법을 배우는 예제입니다.
// `final`은 변수, 메소드, 클래스에 사용될 수 있으며, 각각 다른 의미를 가집니다.
public class _0805_11_Final {
    public static void main(String[] args) {
        // [1] `final` 필드 (변수) 예시
        // `ActionCam` 클래스의 `lens` 필드는 `final`로 선언되어 있습니다.
        ActionCam actionCam = new ActionCam();

        // `final` 필드는 한 번 초기화되면 값을 변경할 수 없습니다.
        // 아래 주석을 해제하면 컴파일 에러가 발생합니다.
        // actionCam.lens = "표준렌즈"; // 에러: cannot assign a value to final variable lens
        System.out.println("ActionCam의 렌즈: " + actionCam.lens);

        actionCam.recordVideo(); // Camera 클래스에서 상속받은 메소드
        actionCam.makeVideo();   // ActionCam 클래스의 고유 메소드 (final 메소드)

        System.out.println("
=================================
");

        // [2] `final` 메소드 예시
        // `ActionCam` 클래스의 `makeVideo()` 메소드는 `final`로 선언되어 있습니다.
        // 따라서 `SlowActionCam` 클래스에서는 `makeVideo()` 메소드를 오버라이딩할 수 없습니다.
        SlowActionCam slowActionCam = new SlowActionCam();
        slowActionCam.recordVideo(); // Camera 클래스에서 상속받은 메소드
        slowActionCam.makeVideo();   // ActionCam 클래스의 final 메소드 호출

        // [참고] `final` 클래스
        // 클래스에 `final` 키워드를 붙이면 해당 클래스는 더 이상 상속될 수 없습니다.
        // 예: `public final class MyFinalClass { ... }`
        // 이는 보안이나 일관성 유지가 필요할 때 사용됩니다. (예: String 클래스)
    }
}
