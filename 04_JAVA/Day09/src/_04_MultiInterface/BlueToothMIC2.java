/**
 * 안녕하세요, 두프룸프님! 이번에는 'BlueToothMIC2' 인터페이스를 통해
 * 자바에서 '인터페이스 간의 다중 상속(Multiple Interface Inheritance)'이 어떻게 가능한지 배워볼 거예요.
 * 클래스는 다중 상속이 안 되지만, 인터페이스는 여러 인터페이스를 `extends` 할 수 있습니다.
 *
 * <오늘 배울 핵심 개념>
 * 1.  **인터페이스 간의 다중 상속**: 
 *     - `public interface BlueToothMIC2 extends Microphone, Speaker`와 같이
 *       쉼표(`,`)로 구분하여 여러 인터페이스를 `extends` 할 수 있어요.
 *     - 이는 'BlueToothMIC2'가 'Microphone'과 'Speaker' 인터페이스의 모든 추상 메소드를
 *       자신의 추상 메소드로 물려받는다는 의미입니다.
 *
 * 2.  **구현 클래스의 의무**: 
 *     - `BlueToothMIC2` 인터페이스를 구현하는 클래스는
 *       `Microphone` 인터페이스의 추상 메소드 (`sing()`), 
 *       `Speaker` 인터페이스의 추상 메소드 (`music()`), 
 *       그리고 `BlueToothMIC2` 인터페이스 자체에 정의된 추상 메소드 (`connect()`)를
 *       '모두' 오버라이딩하여 구현해야 합니다.
 *
 * 3.  **인터페이스 상속의 장점**: 
 *     - 여러 인터페이스의 기능을 하나로 묶어 새로운 인터페이스를 정의할 수 있습니다.
 *     - 이는 코드의 재사용성을 높이고, 복잡한 시스템을 모듈화하는 데 도움을 줍니다.
 *
 * 이 'BlueToothMIC2' 인터페이스는 블루투스 마이크가 가져야 할 모든 기능(노래, 반주, 연결)을
 * 하나의 인터페이스로 통합하여 정의하는 방법을 보여주는 좋은 예시입니다.
 * 함께 코드를 보면서 인터페이스 간의 상속 관계를 이해해 봅시다!
 */

package _04_MultiInterface;

// BlueToothMIC2 인터페이스는 Microphone 인터페이스와 Speaker 인터페이스를 상속(extends)합니다.
// 인터페이스는 클래스와 달리 다중 상속(`extends` 여러 인터페이스)이 가능합니다.
// 이 인터페이스를 구현하는 클래스는 Microphone, Speaker, 그리고 BlueToothMIC2에 정의된
// 모든 추상 메소드를 구현해야 합니다.
public interface BlueToothMIC2 extends Microphone, Speaker {
    /**
     * 새로운 추상 메소드: `connect()`
     * 이 메소드는 BlueToothMIC2 인터페이스 자체에 정의된 추상 메소드입니다.
     * 블루투스 마이크의 연결 기능을 정의합니다.
     * 이 인터페이스를 구현하는 클래스는 이 메소드도 반드시 구현해야 합니다.
     */
    void connect();
}