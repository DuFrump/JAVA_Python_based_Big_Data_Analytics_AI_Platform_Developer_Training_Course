package _06_Detector;

// FireDetector 클래스는 Detectable 인터페이스를 구현(implements)합니다.
// 화재 감지기의 기능을 정의합니다.
public class FireDetector implements Detectable {
    // `detect()` 메소드 구현: 화재를 감지하는 기능을 정의합니다.
    @Override
    public void detect() {
        System.out.println("일반 성능으로 화재를 감지합니다.");
    }
}
