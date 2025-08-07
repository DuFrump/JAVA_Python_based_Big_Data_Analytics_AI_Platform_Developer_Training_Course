package _04_MultiInterface;

// TJmic 클래스는 BlueToothMIC2 인터페이스를 구현(implements)합니다.
// BlueToothMIC2는 Microphone과 Speaker 인터페이스를 상속받으므로,
// TJmic 클래스는 이 세 인터페이스에 정의된 모든 추상 메소드를 구현해야 합니다.
public class TJmic implements BlueToothMIC2 {
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

    // [3] BlueToothMIC2 인터페이스의 `connect()` 메소드 구현
    @Override
    public void connect() {
        System.out.println("핸드폰과 블루투스 연결이 완료 되었습니다.");
    }

}
