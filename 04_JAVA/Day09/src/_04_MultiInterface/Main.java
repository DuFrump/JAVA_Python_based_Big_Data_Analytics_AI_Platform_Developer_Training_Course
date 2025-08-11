/**
 * 안녕하세요, 두프룸프님! 이번 예제에서는 '인터페이스의 다중 구현'과
 * 그로 인한 '다형성'이 어떻게 동작하는지 자세히 살펴볼 거예요.
 * 하나의 클래스가 여러 인터페이스를 구현했을 때, 각 인터페이스 타입으로 참조하면
 * 어떤 메소드를 호출할 수 있고, 어떤 메소드는 호출할 수 없는지 명확히 이해하는 것이 중요합니다.
 *
 * <오늘 배울 핵심 개념>
 * 1.  **인터페이스의 다중 구현 복습**:
 *     - `BlueToothMIC` 클래스는 `Speaker`와 `Microphone` 두 인터페이스를 동시에 구현합니다.
 *     - 이는 `BlueToothMIC` 객체가 `Speaker`의 역할도 하고, `Microphone`의 역할도 할 수 있다는 의미입니다.
 *
 * 2.  **인터페이스를 통한 다형성**:
 *     - `BlueToothMIC` 객체를 `Microphone` 타입의 참조 변수로 참조할 수 있고,
 *       `Speaker` 타입의 참조 변수로도 참조할 수 있습니다.
 *     - 하지만 이때 중요한 것은, 참조 변수의 타입에 따라 호출할 수 있는 메소드가 제한된다는 점입니다.
 *       실제 객체가 어떤 메소드를 가지고 있든 상관없이, 참조 변수의 타입에 정의된 메소드만 호출할 수 있어요.
 *
 * 3.  **컴파일 시점의 타입 체크**:
 *     - 자바 컴파일러는 메소드 호출이 유효한지 컴파일 시점에 확인합니다.
 *     - 만약 참조 변수의 타입에 해당 메소드가 정의되어 있지 않으면, 실제 객체가 그 메소드를 가지고 있더라도 컴파일 에러가 발생합니다.
 *
 * 이 예제를 통해 인터페이스를 통한 다형성이 어떻게 코드의 유연성을 제공하면서도,
 * 타입 안전성을 유지하는지 이해할 수 있을 거예요.
 * 함께 코드를 분석하며 다형성의 중요한 특징을 익혀봅시다!
 */

package _04_MultiInterface;

// Main 클래스는 다중 인터페이스 구현과 다형성을 확인하는 예제입니다.
// 프로그램의 시작점인 main 메소드를 포함하고 있습니다.
public class Main {
    public static void main(String[] args) {
        // [1] BlueToothMIC 객체 생성 및 직접 사용
        // BlueToothMIC 클래스는 Speaker와 Microphone 인터페이스를 모두 구현합니다.
        // 따라서 BlueToothMIC 객체는 두 인터페이스의 모든 메소드를 직접 호출할 수 있습니다.
        BlueToothMIC bm = new BlueToothMIC();

        System.out.println("--- BlueToothMIC 직접 사용 ---");
        bm.music(); // Speaker 인터페이스의 메소드 (BlueToothMIC에서 구현됨)
        bm.sing();  // Microphone 인터페이스의 메소드 (BlueToothMIC에서 구현됨)

        System.out.println("\n----------------------------------------\n");

        // [2] 다형성: Microphone 인터페이스 타입으로 BlueToothMIC 객체 참조
        // `Microphone m = bm;`
        // - `m`은 `Microphone` 타입으로 선언되었기 때문에, `Microphone` 인터페이스에 정의된 메소드만 호출할 수 있습니다.
        // - 실제 객체는 `BlueToothMIC`이므로, `BlueToothMIC`에서 구현된 `sing()` 메소드가 호출됩니다.
        Microphone m = bm;
        System.out.println("--- Microphone 타입으로 참조 ---");
        m.sing(); // 호출 가능: Microphone 인터페이스에 `sing()` 메소드가 정의되어 있음
        // m.music(); // 컴파일 에러 발생!
        // 이유: `m`은 `Microphone` 타입이므로, `Microphone` 인터페이스에 `music()` 메소드가 정의되어 있지 않습니다.
        // 실제 객체 `bm`이 `music()` 메소드를 가지고 있더라도, 참조 변수의 타입이 허용하지 않습니다.
        System.out.println("m.music()은 컴파일 에러 발생 (Microphone 타입에 music() 메소드가 없음)");

        System.out.println("\n----------------------------------------\n");

        // [3] 다형성: Speaker 인터페이스 타입으로 BlueToothMIC 객체 참조
        // `Speaker s = bm;`
        // - `s`는 `Speaker` 타입으로 선언되었기 때문에, `Speaker` 인터페이스에 정의된 메소드만 호출할 수 있습니다.
        // - 실제 객체는 `BlueToothMIC`이므로, `BlueToothMIC`에서 구현된 `music()` 메소드가 호출됩니다.
        Speaker s = bm;
        System.out.println("--- Speaker 타입으로 참조 ---");
        // s.sing(); // 컴파일 에러 발생!
        // 이유: `s`는 `Speaker` 타입이므로, `Speaker` 인터페이스에 `sing()` 메소드가 정의되어 있지 않습니다.
        System.out.println("s.sing()은 컴파일 에러 발생 (Speaker 타입에 sing() 메소드가 없음)");
        s.music(); // 호출 가능: Speaker 인터페이스에 `music()` 메소드가 정의되어 있음
    }
}