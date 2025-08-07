package _04_MultiInterface;

// BlueToothMIC2 인터페이스는 Microphone 인터페이스와 Speaker 인터페이스를 상속(extends)합니다.
// 인터페이스는 클래스와 달리 다중 상속(`extends` 여러 인터페이스)이 가능합니다.
// 이 인터페이스를 구현하는 클래스는 Microphone, Speaker, 그리고 BlueToothMIC2에 정의된
// 모든 추상 메소드를 구현해야 합니다.
public interface BlueToothMIC2 extends Microphone, Speaker {
    // 새로운 추상 메소드: `connect()`
    // 블루투스 마이크의 연결 기능을 정의합니다.
    void connect();
}
