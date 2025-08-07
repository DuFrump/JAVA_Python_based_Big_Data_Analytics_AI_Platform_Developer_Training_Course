package _04_MultiInterface;

// BlueToothMIC 클래스는 Speaker 인터페이스와 Microphone 인터페이스를 동시에 구현(implements)합니다.
// 자바는 클래스의 다중 상속은 지원하지 않지만, 인터페이스의 다중 구현은 지원합니다.
// 두 인터페이스에 정의된 모든 추상 메소드를 반드시 오버라이딩하여 구현해야 합니다.
public class BlueToothMIC implements Speaker, Microphone {
    // [1] Microphone 인터페이스의 `sing()` 메소드 구현
    @Override
    public void sing() {
        System.out.println("마이크에 대고 노래를 부릅니다.");
    }

    // [2] Speaker 인터페이스의 `music()` 메소드 구현
    @Override
    public void music() {
        System.out.println("마이크에 장착된 스피커로 반주가 나옵니다.");
    }
}
