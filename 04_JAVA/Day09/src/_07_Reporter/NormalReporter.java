package _07_Reporter;

// NormalReporter 클래스는 Reportable 인터페이스를 구현(implements)합니다.
// 일반적인 보고 기능을 정의합니다.
public class NormalReporter implements Reportable {
    // `report()` 메소드 구현: 일반 화재 신고 기능을 정의합니다.
    @Override
    public void report() {
        System.out.println("일반 화재 신고를 진행합니다.");
    }
}
