package _05_Inheritance_camera;

/**
 * FactoryCam 클래스는 Camera 클래스를 상속받는 '자식 클래스'입니다.
 * 'extends Camera'를 통해 Camera의 모든 속성과 기능을 물려받습니다.
 *
 * 이 클래스에서는 '메소드 오버라이딩'을 좀 더 다양하게 활용하는 방법을 배워볼 거예요.
 * 부모의 메소드를 완전히 새로운 기능으로 바꾸거나, 부모의 기능을 사용하면서 추가적인 작업을 하거나,
 * 아예 새로운 기능을 추가하는 등 여러 가지 오버라이딩 패턴을 살펴봅시다.
 *
 * 공장용 카메라만의 특성과 기능을 추가하면서 오버라이딩의 묘미를 느껴보세요!
 */
public class FactoryCam extends Camera {

    // === 생성자 (Constructor) ===
    /**
     * FactoryCam 객체를 생성할 때 호출되는 생성자입니다.
     * 'super("공장 카메라")'를 통해 부모 클래스(Camera)의 생성자를 호출하여
     * Camera의 name 필드를 "공장 카메라"로 초기화합니다.
     */
    public FactoryCam() {
        super("공장 카메라");
    }

    // === 메소드 (Methods) ===

    /**
     * [1] 메소드 오버라이딩: takePicture()
     * 부모 클래스(Camera)의 takePicture() 메소드를 재정의합니다.
     * 여기서는 부모의 기능을 완전히 무시하고, 공장 카메라만의 새로운 사진 촬영 메시지를 출력합니다.
     * '@Override' 어노테이션은 이 메소드가 오버라이딩되었음을 명시적으로 알려줍니다.
     */
    @Override
    public void takePicture() {
        System.out.println("사진을 촬영합니다."); // 공장 카메라만의 사진 촬영 메시지
    }

    /**
     * [2] 메소드 오버라이딩 및 부모 메소드 호출: recordVideo()
     * 부모 클래스(Camera)의 recordVideo() 메소드를 재정의합니다.
     * 이 메소드에서는 먼저 공장 카메라 고유의 '화재 감지' 기능을 호출한 후,
     * 'super.recordVideo()'를 통해 부모 클래스의 원래 동영상 녹화 기능을 실행합니다.
     * 이렇게 하면 부모의 기능을 재사용하면서 자식 클래스만의 추가적인 동작을 수행할 수 있습니다.
     */
    @Override
    public void recordVideo() {
        detectFire(); // 공장 카메라 고유의 화재 감지 기능 호출
        super.recordVideo(); // 부모 클래스의 동영상 녹화 기능 호출
    }

    /**
     * [3] FactoryCam 고유의 메소드: detectFire()
     * 이 메소드는 FactoryCam 클래스에만 존재하는 고유한 기능입니다.
     * 부모 클래스인 Camera에는 없는 기능이죠.
     * 공장 카메라가 화재를 감지했을 때의 동작을 정의합니다.
     */
    public void detectFire() {
        System.out.println("화재를 감지했습니다!");
    }

    /**
     * [4] 메소드 오버라이딩: showMainFeature()
     * 부모 클래스(Camera)의 showMainFeature() 메소드를 재정의하여
     * 공장 카메라의 주요 기능을 설명합니다.
     * 여기서는 공장 카메라의 핵심 기능인 '화재 감지'를 강조합니다.
     */
    @Override
    public void showMainFeature() {
        System.out.printf("%s의 주요 기능 : 화재감지%n", this.name);
    }
}