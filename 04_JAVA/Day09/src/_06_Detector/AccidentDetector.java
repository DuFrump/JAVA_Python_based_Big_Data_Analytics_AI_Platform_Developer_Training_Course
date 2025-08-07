package _06_Detector;

// AccidentDetector 클래스는 Detectable 인터페이스를 구현(implements)합니다.
// 사고 감지기의 기능을 정의합니다.
public class AccidentDetector implements Detectable {
    // `detect()` 메소드 구현: 사고를 감지하는 기능을 정의합니다.
    @Override
    public void detect() {
        System.out.println("일반 성능으로 사고를 감지합니다.");
    }
}
