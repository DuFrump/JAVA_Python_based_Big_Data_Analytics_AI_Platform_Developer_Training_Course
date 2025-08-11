/**
 * 안녕하세요, 두프룸프님! 이번에는 'NormalReporter' 클래스를 통해
 * 'Reportable' 인터페이스를 어떻게 '구현(implement)'하는지 배워볼 거예요.
 * 인터페이스가 제시한 '규약'을 클래스가 어떻게 지켜나가는지 이해하는 데 핵심적인 부분입니다.
 *
 * <오늘 배울 핵심 개념>
 * 1.  **인터페이스 구현 (`implements`)**: 
 *     - 클래스가 인터페이스의 규약을 따르겠다고 선언할 때 `implements` 키워드를 사용해요.
 *       (예: `public class NormalReporter implements Reportable`)
 *     - 인터페이스를 구현하는 클래스는 인터페이스에 정의된 모든 추상 메소드를 반드시 오버라이딩하여 구현해야 합니다.
 *       만약 하나라도 구현하지 않으면, 해당 클래스도 추상 클래스로 선언해야 해요.
 *
 * 2.  **`@Override` 어노테이션**: 
 *     - 이 어노테이션은 메소드가 인터페이스의 메소드를 '구현'하거나 부모 클래스의 메소드를 '재정의'한다는 것을 컴파일러에게 알려주는 역할을 해요.
 *     - 코드의 가독성을 높이고, 잠재적인 오류를 컴파일 시점에 발견하는 데 도움을 줍니다.
 *
 * 이 'NormalReporter' 클래스는 'Reportable' 인터페이스의 `report()` 메소드를 구체적으로 구현함으로써,
 * 일반적인 보고 기능을 어떻게 수행하는지 보여줍니다.
 * 함께 코드를 보면서 인터페이스 구현의 실제 사례를 익혀봅시다!
 */

package _07_Reporter;

// NormalReporter 클래스는 Reportable 인터페이스를 구현(implements)합니다.
// 'implements Reportable'을 통해 Reportable 인터페이스에 정의된 모든 추상 메소드를
// 이 클래스에서 반드시 오버라이딩하여 구현해야 합니다.
public class NormalReporter implements Reportable {
    /**
     * `report()` 메소드 구현: 일반 화재 신고 기능을 정의합니다.
     * `@Override` 어노테이션은 이 메소드가 Reportable 인터페이스의 `report()` 메소드를 구현한다는 것을 명시합니다.
     */
    @Override
    public void report() {
        System.out.println("일반 화재 신고를 진행합니다.");
    }
}