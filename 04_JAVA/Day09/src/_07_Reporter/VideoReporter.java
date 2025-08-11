/**
 * 안녕하세요, 두프룸프님! 이번에는 'VideoReporter' 클래스를 통해
 * 'Reportable' 인터페이스를 어떻게 '구현(implement)'하는지 다시 한번 배워볼 거예요.
 * 'NormalReporter'와 비교하면서 보면 인터페이스 구현의 공통점과 각 보고자의 특화된 기능을 더 명확히 이해할 수 있습니다.
 *
 * <오늘 배울 핵심 개념>
 * 1.  **인터페이스 구현 (`implements`) 복습**: 
 *     - 클래스가 인터페이스의 규약을 따르겠다고 선언할 때 `implements` 키워드를 사용해요.
 *       (예: `public class VideoReporter implements Reportable`)
 *     - 인터페이스를 구현하는 클래스는 인터페이스에 정의된 모든 추상 메소드를 반드시 오버라이딩하여 구현해야 합니다.
 *       만약 하나라도 구현하지 않으면, 해당 클래스도 추상 클래스로 선언해야 해요.
 *
 * 2.  **`@Override` 어노테이션 복습**: 
 *     - 이 어노테이션은 메소드가 인터페이스의 메소드를 '구현'하거나 부모 클래스의 메소드를 '재정의'한다는 것을 컴파일러에게 알려주는 역할을 해요.
 *     - 필수는 아니지만, 사용하면 오타나 잘못된 메소드 시그니처로 인한 오류를 컴파일 시점에 잡아낼 수 있어 매우 유용합니다.
 *
 * 이 'VideoReporter' 클래스는 'Reportable' 인터페이스의 `report()` 메소드를 구체적으로 구현함으로써,
 * 영상 보고자라는 특정 장치가 '보고' 기능을 어떻게 수행하는지 보여줍니다.
 * 함께 코드를 보면서 인터페이스 구현의 실제 사례를 익숙하게 만들어 봅시다!
 */

package _07_Reporter;

// VideoReporter 클래스는 Reportable 인터페이스를 구현(implements)합니다.
// 'implements Reportable'을 통해 Reportable 인터페이스에 정의된 모든 추상 메소드를
// 이 클래스에서 반드시 오버라이딩하여 구현해야 합니다.
public class VideoReporter implements Reportable {
    /**
     * `report()` 메소드 구현: 영상과 함께 신고하는 기능을 정의합니다.
     * `@Override` 어노테이션은 이 메소드가 Reportable 인터페이스의 `report()` 메소드를 구현한다는 것을 명시합니다.
     */
    @Override
    public void report() {
        System.out.println("영상과 함께 신고를 진행합니다.");
    }
}