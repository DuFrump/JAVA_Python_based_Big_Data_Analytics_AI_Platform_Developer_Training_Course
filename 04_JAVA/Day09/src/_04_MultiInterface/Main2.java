package _04_MultiInterface;

// Main2 클래스는 인터페이스 상속 관계에서 다형성이 어떻게 작동하는지 확인하는 예제입니다.
public class Main2 {
    public static void main(String[] args) {
        // [1] TJmic 객체 생성 및 직접 사용
        // TJmic 클래스는 BlueToothMIC2 인터페이스를 구현하며, BlueToothMIC2는 Microphone과 Speaker를 상속합니다.
        TJmic tj = new TJmic();

        System.out.println("--------TJmic 객체 직접 사용---------");
        tj.connect(); // BlueToothMIC2의 메소드
        tj.music();   // Speaker의 메소드
        tj.sing();    // Microphone의 메소드

        System.out.println("\n----------------------------------------\n");

        // [2] 다형성: TJmic 객체를 BlueToothMIC2 인터페이스 타입으로 업캐스팅
        // `BlueToothMIC2 bm = tj;`
        // - `bm`은 BlueToothMIC2 타입이므로, BlueToothMIC2, Microphone, Speaker에 정의된 모든 메소드를 호출할 수 있습니다.
        BlueToothMIC2 bm = tj;
        System.out.println("--------- TJmic 객체를 BlueToothMIC2로 타입 변환 ---------");
        bm.connect();
        bm.music();
        bm.sing();

        System.out.println("\n----------------------------------------\n");

        // [3] 다형성: TJmic 객체를 Microphone 인터페이스 타입으로 업캐스팅
        // `Microphone m = tj;`
        // - `m`은 Microphone 타입이므로, Microphone 인터페이스에 정의된 메소드만 호출할 수 있습니다.
        Microphone m = tj;
        System.out.println("--------- TJmic 객체를 Microphone로 타입 변환 ---------");
        // m.connect(); // 에러: Microphone 인터페이스에는 connect() 메소드가 없음
        // m.music();   // 에러: Microphone 인터페이스에는 music() 메소드가 없음
        System.out.println("m.connect(), m.music()은 컴파일 에러 발생 (Microphone 타입에 없음)");
        m.sing();

        System.out.println("\n----------------------------------------\n");

        // [4] 다형성: TJmic 객체를 Speaker 인터페이스 타입으로 업캐스팅
        // `Speaker s = tj;`
        // - `s`는 Speaker 타입이므로, Speaker 인터페이스에 정의된 메소드만 호출할 수 있습니다.
        Speaker s = tj;
        System.out.println("--------- TJmic 객체를 Speaker로 타입 변환 ---------");
        // s.connect(); // 에러: Speaker 인터페이스에는 connect() 메소드가 없음
        // s.sing();    // 에러: Speaker 인터페이스에는 sing() 메소드가 없음
        System.out.println("s.connect(), s.sing()은 컴파일 에러 발생 (Speaker 타입에 없음)");
        s.music();
    }
}
