package _05_Inheritance_camera;

/**
 * ActionCam 클래스는 Camera 클래스를 상속받는 '자식 클래스'입니다.
 * 'extends Camera'를 통해 Camera의 모든 속성과 기능을 물려받습니다.
 *
 * 이 클래스에서는 특히 'final' 키워드의 사용법에 대해 배워볼 거예요.
 * 'final'은 '마지막', '최종'이라는 뜻처럼, 한 번 정해지면 변경할 수 없도록 만드는 역할을 합니다.
 * 필드에 붙으면 '상수', 메소드에 붙으면 '오버라이딩 불가'라는 의미를 가집니다.
 *
 * 액션 카메라만의 고유한 특징과 기능을 추가하면서 'final'의 의미를 함께 살펴봅시다.
 */
public class ActionCam extends Camera {

    // === 필드 (Fields) ===
    /**
     * [1] final 필드 (상수)
     * 'final' 키워드가 붙은 변수는 한 번 초기화되면 그 값을 변경할 수 없는 '상수(Constant)'가 됩니다.
     * 마치 불변의 진리처럼, 프로그램이 실행되는 동안 항상 같은 값을 유지해야 할 때 사용합니다.
     * 일반적으로 상수는 모든 글자를 대문자로 표기하고, 단어와 단어 사이는 언더스코어(_)로 연결하는 것이 관례입니다.
     */
    public final String LENS = "광각렌즈"; // 액션 카메라의 렌즈는 항상 광각렌즈!

    // === 생성자 (Constructor) ===
    /**
     * ActionCam 객체를 생성할 때 호출되는 생성자입니다.
     * 'super("액션 카메라")'를 통해 부모 클래스(Camera)의 생성자를 호출하여
     * Camera의 name 필드를 "액션 카메라"로 초기화합니다.
     */
    public ActionCam() {
        super("액션 카메라");
    }

    // === 메소드 (Methods) ===

    /**
     * [2] final 메소드
     * 'final' 키워드가 붙은 메소드는 자식 클래스에서 '오버라이딩(재정의)'할 수 없습니다.
     * 즉, 이 메소드의 기능은 이 ActionCam 클래스에서 최종적으로 결정되며,
     * 이 ActionCam을 상속받는 또 다른 자식 클래스(예: SlowActionCam)에서는
     * makeVideo() 메소드를 변경할 수 없다는 의미입니다.
     *
     * 이 메소드는 액션 카메라로 촬영한 비디오를 제작하는 기능을 정의합니다.
     */
    public final void makeVideo() {
        System.out.printf("%s : %s로 촬영한 비디오를 제작%n", this.name, this.LENS);
    }

    /**
     * [3] 부모 클래스의 메소드 오버라이딩 (showMainFeature)
     * 부모인 Camera 클래스의 showMainFeature() 메소드를 ActionCam에 맞게 재정의합니다.
     * 액션 카메라의 주요 기능에 '광각렌즈 비디오 제작' 기능을 추가하여 보여줍니다.
     *
     * '@Override' 어노테이션은 이 메소드가 부모의 메소드를 오버라이딩했음을 명시적으로 알려줍니다.
     */
    @Override
    public void showMainFeature() {
        System.out.printf("%s의 주요 기능 : 사진 촬영, 동영상 녹화, %s 비디오 제작%n", this.name, this.LENS);
    }
}