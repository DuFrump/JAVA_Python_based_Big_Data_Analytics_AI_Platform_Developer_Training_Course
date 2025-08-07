package _04_MultiInterface;

// Main 클래스는 다중 인터페이스 구현과 다형성을 확인하는 예제입니다.
public class Main {
    public static void main(String[] args) {
        // [1] BlueToothMIC 객체 생성 및 직접 사용
        // BlueToothMIC 클래스는 Speaker와 Microphone 인터페이스를 모두 구현합니다.
        BlueToothMIC bm = new BlueToothMIC();

        System.out.println("--- BlueToothMIC 직접 사용 ---");
        bm.music(); // Speaker 인터페이스의 메소드
        bm.sing();  // Microphone 인터페이스의 메소드

        System.out.println("
----------------------------------------
");

        // [2] 다형성: Microphone 인터페이스 타입으로 BlueToothMIC 객체 참조
        // `Microphone m = bm;`
        // - `m`은 Microphone 타입이므로, Microphone 인터페이스에 정의된 메소드만 호출할 수 있습니다.
        // - 실제 객체는 BlueToothMIC이므로, BlueToothMIC에서 구현된 `sing()` 메소드가 호출됩니다.
        Microphone m = bm;
        System.out.println("--- Microphone 타입으로 참조 ---");
        m.sing(); // 호출 가능
        // m.music(); // 에러: Microphone 인터페이스에는 music() 메소드가 정의되어 있지 않음
        System.out.println("m.music()은 컴파일 에러 발생 (Microphone 타입에 없음)");

        System.out.println("
----------------------------------------
");

        // [3] 다형성: Speaker 인터페이스 타입으로 BlueToothMIC 객체 참조
        // `Speaker s = bm;`
        // - `s`는 Speaker 타입이므로, Speaker 인터페이스에 정의된 메소드만 호출할 수 있습니다.
        // - 실제 객체는 BlueToothMIC이므로, BlueToothMIC에서 구현된 `music()` 메소드가 호출됩니다.
        Speaker s = bm;
        System.out.println("--- Speaker 타입으로 참조 ---");
        // s.sing(); // 에러: Speaker 인터페이스에는 sing() 메소드가 정의되어 있지 않음
        System.out.println("s.sing()은 컴파일 에러 발생 (Speaker 타입에 없음)");
        s.music(); // 호출 가능
    }
}
