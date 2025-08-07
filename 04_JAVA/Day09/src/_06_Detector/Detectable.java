package _06_Detector;

// Detectable 인터페이스는 감지 기능이 있는 모든 객체가 가져야 할 공통적인 기능을 정의합니다.
// 이 인터페이스를 구현하는 클래스는 `detect()` 메소드를 반드시 구현해야 합니다.
public interface Detectable {
    // 추상 메소드: `detect()`
    // 무언가를 감지하는 기능을 정의합니다.
    void detect();
}
