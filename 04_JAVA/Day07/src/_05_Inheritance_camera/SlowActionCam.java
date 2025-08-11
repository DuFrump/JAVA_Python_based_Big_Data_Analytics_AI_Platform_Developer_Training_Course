package _05_Inheritance_camera;

/**
 * SlowActionCam 클래스는 ActionCam 클래스를 상속받는 '자식 클래스'입니다.
 * 'extends ActionCam'을 통해 ActionCam의 모든 속성과 기능을 물려받습니다.
 *
 * 이로써 'Camera -> ActionCam -> SlowActionCam'으로 이어지는
 * '다단계 상속(Multi-level Inheritance)'의 구조를 가지게 됩니다.
 *
 * 이 클래스에서는 특히 'final' 메소드가 자식 클래스에서 오버라이딩될 수 없다는
 * 중요한 규칙을 다시 한번 확인해 볼 거예요.
 * 슬로우 액션 카메라만의 특성을 정의하면서 이 규칙을 함께 살펴봅시다.
 */
public class SlowActionCam extends ActionCam {

    // === 생성자 (Constructor) ===
    /**
     * SlowActionCam 객체를 생성할 때 호출되는 생성자입니다.
     *
     * ActionCam 클래스에는 매개변수 없는 기본 생성자가 존재하므로,
     * SlowActionCam의 생성자에서 'super()'를 명시적으로 호출하지 않아도
     * 컴파일러가 자동으로 'super()'를 첫 줄에 삽입해줍니다.
     * 따라서 부모인 ActionCam의 생성자가 먼저 호출되고, 그 안에서 Camera의 생성자가 호출되어
     * name 필드가 "액션 카메라"로 초기화됩니다.
     *
     * 이후, 이 생성자에서는 name 필드를 "슬로우 액션 카메라"로 다시 설정합니다.
     */
    public SlowActionCam() {
        // super(); // ActionCam의 기본 생성자가 호출됩니다. (생략 가능)
        this.name = "슬로우 액션 카메라"; // name 필드를 "슬로우 액션 카메라"로 재설정
    }

    // === 메소드 (Methods) ===

    /**
     * [중요] final 메소드 오버라이딩 불가!
     * 부모 클래스인 ActionCam의 makeVideo() 메소드는 'final'로 선언되어 있습니다.
     * 'final' 메소드는 자식 클래스에서 오버라이딩(재정의)할 수 없습니다.
     *
     * 만약 아래 주석 처리된 코드를 해제하면 컴파일 에러가 발생할 것입니다.
     * 이는 'final' 키워드가 메소드의 기능을 최종적으로 확정하여,
     * 더 이상 변경되지 않도록 보호하는 역할을 한다는 것을 보여줍니다.
     */
    // @Override
    // public void makeVideo() { // 에러: makeVideo() in ActionCam cannot be overridden
    //     System.out.printf("%s : %s로 촬영한 슬로우 비디오 제작.%n", this.name, this.LENS);
    // }

    /**
     * 부모 클래스(ActionCam)의 showMainFeature() 메소드를 재정의합니다.
     * showMainFeature() 메소드는 ActionCam에서 'final'이 아니었으므로,
     * SlowActionCam에서 자유롭게 오버라이딩할 수 있습니다.
     *
     * 슬로우 액션 카메라의 주요 기능에 '슬로우 모션 비디오 제작' 기능을 강조합니다.
     */
    @Override
    public void showMainFeature() {
        System.out.printf("%s의 주요 기능 : 사진 촬영, 동영상 녹화, 슬로우 모션 비디오 제작%n", this.name);
    }
}