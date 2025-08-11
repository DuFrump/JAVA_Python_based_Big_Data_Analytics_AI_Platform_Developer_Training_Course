/**
 * 안녕하세요, 두프룸프님! 이번에는 'TJmic' 클래스를 통해
 * '인터페이스의 다중 상속'과 '다중 구현'이 결합된 상황에서
 * 구현 클래스가 어떤 메소드들을 '반드시' 구현해야 하는지 배워볼 거예요.
 * `TJmic`은 `BlueToothMIC2` 인터페이스를 구현하고,
 * `BlueToothMIC2`는 다시 `Microphone`과 `Speaker` 인터페이스를 상속받는 복잡한 구조입니다.
 * 이 구조에서 `TJmic`이 모든 규약을 어떻게 지켜나가는지 살펴봅시다!
 *
 * <오늘 배울 핵심 개념>
 * 1.  **인터페이스 상속 계층 구조 복습**: 
 *     - `Microphone` (sing() 정의)
 *     - `Speaker` (music() 정의)
 *     - `BlueToothMIC2` (connect() 정의, `Microphone`과 `Speaker` 상속)
 *     - `TJmic` (BlueToothMIC2 구현)
 *
 * 2.  **구현 클래스의 모든 추상 메소드 구현 의무**: 
 *     - `TJmic` 클래스는 `BlueToothMIC2` 인터페이스를 구현합니다.
 *     - `BlueToothMIC2` 인터페이스는 `Microphone`과 `Speaker` 인터페이스를 상속받았으므로,
 *       `BlueToothMIC2`는 `sing()`, `music()`, `connect()` 세 가지 추상 메소드를 모두 가지고 있습니다.
 *     - 따라서 `TJmic` 클래스는 이 세 가지 메소드를 '모두' 오버라이딩하여 구현해야 합니다.
 *       만약 하나라도 빠뜨리면 컴파일 에러가 발생해요.
 *
 * 3.  **`@Override` 어노테이션의 중요성**: 
 *     - 각 메소드 위에 `@Override` 어노테이션을 붙여서,
 *       이 메소드가 인터페이스의 추상 메소드를 구현한다는 것을 명시적으로 나타냅니다.
 *     - 이는 코드의 가독성을 높이고, 개발자의 실수를 컴파일 시점에 잡아내는 데 도움을 줍니다.
 *
 * 이 'TJmic' 클래스는 복잡한 인터페이스 구조 속에서도
 * 모든 규약을 충실히 이행하는 방법을 보여주는 좋은 예시입니다.
 * 함께 코드를 보면서 인터페이스 구현의 완벽한 이해를 다져봅시다!
 */

package _04_MultiInterface;

// TJmic 클래스는 BlueToothMIC2 인터페이스를 구현(implements)합니다.
// BlueToothMIC2는 Microphone과 Speaker 인터페이스를 상속받으므로,
// TJmic 클래스는 이 세 인터페이스(Microphone, Speaker, BlueToothMIC2)에 정의된
// 모든 추상 메소드를 반드시 오버라이딩하여 구현해야 합니다.
public class TJmic implements BlueToothMIC2 {
    /**
     * [1] Microphone 인터페이스의 `sing()` 메소드 구현
     * `@Override` 어노테이션은 이 메소드가 Microphone 인터페이스의 `sing()` 메소드를 구현한다는 것을 명시합니다.
     * 마이크에 대고 노래를 부르는 동작을 정의합니다.
     */
    @Override
    public void sing() {
        System.out.println("마이크에 대고 노래를 부릅니다.");
    }

    /**
     * [2] Speaker 인터페이스의 `music()` 메소드 구현
     * `@Override` 어노테이션은 이 메소드가 Speaker 인터페이스의 `music()` 메소드를 구현한다는 것을 명시합니다.
     * 마이크에 장착된 스피커로 반주가 나오는 동작을 정의합니다.
     */
    @Override
    public void music() {
        System.out.println("마이크에 장착된 스피커로 반주가 나옵니다.");
    }

    /**
     * [3] BlueToothMIC2 인터페이스의 `connect()` 메소드 구현
     * `@Override` 어노테이션은 이 메소드가 BlueToothMIC2 인터페이스의 `connect()` 메소드를 구현한다는 것을 명시합니다.
     * 핸드폰과 블루투스 연결이 완료되는 동작을 정의합니다.
     */
    @Override
    public void connect() {
        System.out.println("핸드폰과 블루투스 연결이 완료 되었습니다.");
    }
}