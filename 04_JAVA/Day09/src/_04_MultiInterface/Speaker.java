package _04_MultiInterface;

// Speaker 인터페이스는 스피커가 가져야 할 기본적인 기능을 정의합니다.
// 이 인터페이스를 구현하는 클래스는 `music()` 메소드를 반드시 구현해야 합니다.
public interface Speaker {
    // 추상 메소드: `music()`
    // 스피커를 통해 음악을 재생하는 기능을 정의합니다.
    void music();
}
