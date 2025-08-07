package _07_Reporter;

// VideoReporter 클래스는 Reportable 인터페이스를 구현(implements)합니다.
// 영상과 함께 보고하는 기능을 정의합니다.
public class VideoReporter implements Reportable {
    // `report()` 메소드 구현: 영상과 함께 신고하는 기능을 정의합니다.
    @Override
    public void report() {
        System.out.println("영상과 함께 신고를 진행합니다.");
    }
}
