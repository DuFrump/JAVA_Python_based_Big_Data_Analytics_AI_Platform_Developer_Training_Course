/**
 * 안녕하세요, 두프룸프님! 이번 예제에서는 '인터페이스의 다중 상속'과 '다중 구현'이
 * 복합적으로 사용될 때 '다형성'이 어떻게 작동하는지 심층적으로 분석해 볼 거예요.
 * `TJmic`이라는 클래스가 `BlueToothMIC2` 인터페이스를 구현하고,
 * `BlueToothMIC2` 인터페이스는 다시 `Microphone`과 `Speaker` 인터페이스를 상속받는 복잡한 구조입니다.
 * 이 구조에서 각 인터페이스 타입으로 `TJmic` 객체를 참조했을 때 어떤 메소드를 호출할 수 있는지
 * 명확히 이해하는 것이 이번 학습의 핵심입니다.
 *
 * <오늘 배울 핵심 개념>
 * 1.  **인터페이스 상속 계층 구조**: 
 *     - `Microphone`과 `Speaker`는 독립적인 인터페이스입니다.
 *     - `BlueToothMIC2`는 `Microphone`과 `Speaker`를 `extends`하여 두 인터페이스의 모든 추상 메소드를 물려받습니다.
 *     - `TJmic` 클래스는 `BlueToothMIC2` 인터페이스를 `implements`하여 `BlueToothMIC2`가 가진 모든 추상 메소드를 구현합니다.
 *
 * 2.  **다형성 (Polymorphism) 심화**: 
 *     - `TJmic` 객체는 `TJmic` 타입뿐만 아니라, `BlueToothMIC2`, `Microphone`, `Speaker` 타입으로도 참조될 수 있습니다.
 *     - 이때, 참조 변수의 타입이 호출 가능한 메소드를 결정합니다.
 *       실제 객체가 어떤 메소드를 가지고 있든 상관없이, 참조 변수의 타입에 정의된 메소드만 호출할 수 있어요.
 *
 * 3.  **컴파일 시점의 타입 체크 (복습)**: 
 *     - 자바 컴파일러는 메소드 호출이 유효한지 컴파일 시점에 확인합니다.
 *     - 참조 변수의 타입에 해당 메소드가 정의되어 있지 않으면, 실제 객체가 그 메소드를 가지고 있더라도 컴파일 에러가 발생합니다.
 *
 * 이 예제를 통해 인터페이스를 활용한 복잡한 시스템 설계에서 다형성이 어떻게 동작하며,
 * 코드의 유연성과 타입 안전성을 동시에 확보하는지 이해할 수 있을 거예요.
 * 함께 코드를 분석하며 다형성의 중요한 특징을 완벽하게 마스터해 봅시다!
 */

package _04_MultiInterface;

// Main2 클래스는 인터페이스 상속 관계에서 다형성이 어떻게 작동하는지 확인하는 예제입니다.
// 프로그램의 시작점인 main 메소드를 포함하고 있습니다.
public class Main2 {
    public static void main(String[] args) {
        // [1] TJmic 객체 생성 및 직접 사용
        // TJmic 클래스는 BlueToothMIC2 인터페이스를 구현하며,
        // BlueToothMIC2는 Microphone과 Speaker를 상속합니다.
        // 따라서 TJmic 객체는 이 모든 인터페이스의 메소드를 직접 호출할 수 있습니다.
        TJmic tj = new TJmic();

        System.out.println("--------TJmic 객체 직접 사용---------");
        tj.connect(); // BlueToothMIC2 인터페이스의 메소드 (TJmic에서 구현됨)
        tj.music();   // Speaker 인터페이스의 메소드 (TJmic에서 구현됨)
        tj.sing();    // Microphone 인터페이스의 메소드 (TJmic에서 구현됨)

        System.out.println("\n----------------------------------------\n");

        // [2] 다형성: TJmic 객체를 BlueToothMIC2 인터페이스 타입으로 업캐스팅
        // `BlueToothMIC2 bm = tj;`
        // - `bm`은 `BlueToothMIC2` 타입으로 선언되었기 때문에,
        //   `BlueToothMIC2` 인터페이스와 그 부모 인터페이스들(Microphone, Speaker)에 정의된
        //   모든 메소드를 호출할 수 있습니다.
        BlueToothMIC2 bm = tj;
        System.out.println("--------- TJmic 객체를 BlueToothMIC2로 타입 변환 ---------");
        bm.connect(); // BlueToothMIC2에 정의됨
        bm.music();   // Speaker에 정의됨 (BlueToothMIC2가 상속받음)
        bm.sing();    // Microphone에 정의됨 (BlueToothMIC2가 상속받음)

        System.out.println("\n----------------------------------------\n");

        // [3] 다형성: TJmic 객체를 Microphone 인터페이스 타입으로 업캐스팅
        // `Microphone m = tj;`
        // - `m`은 `Microphone` 타입으로 선언되었기 때문에,
        //   오직 `Microphone` 인터페이스에 정의된 메소드만 호출할 수 있습니다.
        Microphone m = tj;
        System.out.println("--------- TJmic 객체를 Microphone로 타입 변환 ---------");
        // m.connect(); // 컴파일 에러 발생!
        // 이유: `Microphone` 인터페이스에는 `connect()` 메소드가 정의되어 있지 않습니다.
        // m.music();   // 컴파일 에러 발생!
        // 이유: `Microphone` 인터페이스에는 `music()` 메소드가 정의되어 있지 않습니다.
        System.out.println("m.connect(), m.music()은 컴파일 에러 발생 (Microphone 타입에 없음)");
        m.sing(); // Microphone에 정의됨

        System.out.println("\n----------------------------------------\n");

        // [4] 다형성: TJmic 객체를 Speaker 인터페이스 타입으로 업캐스팅
        // `Speaker s = tj;`
        // - `s`는 `Speaker` 타입으로 선언되었기 때문에,
        //   오직 `Speaker` 인터페이스에 정의된 메소드만 호출할 수 있습니다.
        Speaker s = tj;
        System.out.println("--------- TJmic 객체를 Speaker로 타입 변환 ---------");
        // s.connect(); // 컴파일 에러 발생!
        // 이유: `Speaker` 인터페이스에는 `connect()` 메소드가 정의되어 있지 않습니다.
        // s.sing();    // 컴파일 에러 발생!
        // 이유: `Speaker` 인터페이스에는 `sing()` 메소드가 정의되어 있지 않습니다.
        System.out.println("s.connect(), s.sing()은 컴파일 에러 발생 (Speaker 타입에 없음)");
        s.music(); // Speaker에 정의됨
    }
}