package _07_Reporter;

public class VideoReporter implements Reportable {
    @Override
    public void report() {
        System.out.println("영상과 함께 신고를 진행합니다.");
    }
}
