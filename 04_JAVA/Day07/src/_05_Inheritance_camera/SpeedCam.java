package _05_Inheritance_camera;

/**
 * SpeedCam 클래스는 Camera 클래스를 상속받는 '자식 클래스'입니다.
 * 'extends Camera'를 통해 Camera의 모든 속성과 기능을 물려받습니다.
 *
 * 이 클래스에서는 '과속 단속 카메라'라는 특수한 목적에 맞게
 * 부모의 기능을 오버라이딩하고, 새로운 고유 기능을 추가하는 방법을 배워볼 거예요.
 * 특히, 오버라이딩된 메소드 안에서 새로운 기능을 먼저 수행한 후
 * 부모의 기능을 호출하거나, 완전히 새로운 동작을 정의하는 패턴을 살펴봅시다.
 */
public class SpeedCam extends Camera {

    // === 생성자 (Constructor) ===
    /**
     * SpeedCam 객체를 생성할 때 호출되는 생성자입니다.
     * 'super("과속 단속 카메라")'를 통해 부모 클래스(Camera)의 생성자를 호출하여
     * Camera의 name 필드를 "과속 단속 카메라"로 초기화합니다.
     */
    public SpeedCam() {
        super("과속 단속 카메라");
    }

    // === 메소드 (Methods) ===

    /**
     * [1] 메소드 오버라이딩: takePicture()
     * 부모 클래스(Camera)의 takePicture() 메소드를 재정의합니다.
     * 과속 단속 카메라의 특성상, 사진을 촬영하기 전에 '속도 측정'과 '차량 번호 식별' 기능을 먼저 수행합니다.
     * 그 후에 'super.takePicture()'를 통해 부모 클래스의 원래 사진 촬영 기능을 호출합니다.
     */
    @Override
    public void takePicture() {
        checkSpeed();        // 속도 측정 기능 호출
        recognizeNumber();   // 차량 번호 식별 기능 호출
        super.takePicture(); // 부모 클래스의 사진 촬영 기능 호출
    }

    /**
     * [2] 메소드 오버라이딩: recordVideo()
     * 부모 클래스(Camera)의 recordVideo() 메소드를 재정의합니다.
     * 이 메소드에서도 '속도 측정'과 '차량 번호 식별' 기능을 먼저 수행합니다.
     * 하지만 여기서는 'super.recordVideo()'를 호출하는 대신,
     * 과속 단속 카메라만의 동영상 녹화 메시지를 직접 출력합니다.
     * 이는 부모의 기능을 완전히 대체하는 오버라이딩의 예시입니다.
     */
    @Override
    public void recordVideo() {
        checkSpeed();      // 속도 측정 기능 호출
        recognizeNumber(); // 차량 번호 식별 기능 호출
        System.out.println("동영상을 녹화합니다."); // 과속 단속 카메라만의 동영상 녹화 메시지
    }

    /**
     * [3] SpeedCam 고유의 메소드: checkSpeed()
     * 이 메소드는 SpeedCam 클래스에만 존재하는 고유한 기능입니다.
     * 차량의 속도를 측정하는 역할을 합니다.
     */
    public void checkSpeed() {
        System.out.println("속도를 측정합니다.");
    }

    /**
     * [4] SpeedCam 고유의 메소드: recognizeNumber()
     * 이 메소드도 SpeedCam 클래스에만 존재하는 고유한 기능입니다.
     * 차량의 번호판을 식별하는 역할을 합니다.
     */
    public void recognizeNumber() { // 'void void' -> 'void'로 수정했습니다.
        System.out.println("차량 번호를 식별합니다.");
    }

    /**
     * [5] 메소드 오버라이딩: showMainFeature()
     * 부모 클래스(Camera)의 showMainFeature() 메소드를 재정의하여
     * 과속 단속 카메라의 주요 기능을 설명합니다.
     * 여기서는 과속 단속 카메라의 핵심 기능인 '과속 단속'을 강조합니다.
     */
    @Override
    public void showMainFeature() {
        System.out.printf("%s의 주요 기능 : 과속 단속%n", this.name);
    }
}