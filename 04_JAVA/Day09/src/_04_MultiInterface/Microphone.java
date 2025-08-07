package _04_MultiInterface;

// Microphone 인터페이스는 마이크가 가져야 할 기본적인 기능을 정의합니다.
// 이 인터페이스를 구현하는 클래스는 `sing()` 메소드를 반드시 구현해야 합니다.
public interface Microphone {
    // 추상 메소드: `sing()`
    // 마이크를 통해 노래하는 기능을 정의합니다.
    void sing();
}
