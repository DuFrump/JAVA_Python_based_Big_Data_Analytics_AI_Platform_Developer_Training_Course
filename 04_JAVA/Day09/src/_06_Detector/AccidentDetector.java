package _06_Detector;

public class AccidentDetector implements Detectable {
    @Override
    public void detect() {
        System.out.println("일반 성능으로 사고를 감지합니다.");
    }
}
