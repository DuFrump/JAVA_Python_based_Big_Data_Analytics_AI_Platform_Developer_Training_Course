/**
 * 안녕하세요, 두프룸프님! 이번에는 'ThreeStarPhone2' 클래스를 통해
 * 'Phone' 인터페이스를 어떻게 '구현(implement)'하는지 다시 한번 배워볼 거예요.
 * 'PineapplePhone2'와 비교하면서 보면 인터페이스 구현의 공통점과 차이점을 더 명확히 이해할 수 있습니다.
 *
 * <오늘 배울 핵심 개념>
 * 1.  **인터페이스 구현 (`implements`) 복습**: 
 *     - 클래스가 인터페이스의 규약을 따르겠다고 선언할 때 `implements` 키워드를 사용해요.
 *       (예: `public class ThreeStarPhone2 implements Phone`)
 *     - 인터페이스를 구현하는 클래스는 인터페이스에 정의된 모든 추상 메소드를 반드시 오버라이딩하여 구현해야 합니다.
 *       만약 하나라도 구현하지 않으면, 해당 클래스도 추상 클래스로 선언해야 해요.
 *
 * 2.  **`@Override` 어노테이션 복습**: 
 *     - 이 어노테이션은 메소드가 인터페이스의 메소드를 '구현'하거나 부모 클래스의 메소드를 '재정의'한다는 것을 컴파일러에게 알려줍니다.
 *     - 코드의 가독성을 높이고, 잠재적인 오류를 컴파일 시점에 발견하는 데 도움을 줍니다.
 *
 * 3.  **인터페이스 상수 사용 복습**: 
 *     - 인터페이스에 정의된 상수(예: `Phone.MAX_BATTERY_CAPACITY`)는
 *       `인터페이스이름.상수이름` 형식으로 직접 접근하여 사용할 수 있습니다.
 *
 * 이 'ThreeStarPhone2' 클래스는 'Phone' 인터페이스의 모든 기능을 구체적으로 구현함으로써,
 * 실제 작동하는 휴대폰의 또 다른 종류를 만들어내는 과정을 보여줍니다.
 * 함께 코드를 보면서 인터페이스 구현의 실제 사례를 익숙하게 만들어 봅시다!
 */

package _03_Phone2;

// ThreeStarPhone2 클래스는 Phone 인터페이스를 구현(implements)합니다.
// 'implements Phone'을 통해 Phone 인터페이스에 정의된 모든 추상 메소드를
// 이 클래스에서 반드시 오버라이딩하여 구현해야 합니다.
public class ThreeStarPhone2 implements Phone {
    // 필드: 배터리 잔량과 전원 켜짐 상태를 저장합니다.
    int batteryCapacity = 35; // 초기 배터리 잔량은 35%로 설정합니다.
    boolean isOn = false;     // 초기 전원 상태는 꺼짐(false)으로 설정합니다.

    /**
     * `powerOn()` 메소드 구현: 휴대폰의 전원을 켜는 기능입니다.
     * `@Override` 어노테이션은 이 메소드가 Phone 인터페이스의 `powerOn()` 메소드를 구현한다는 것을 명시합니다.
     * 배터리 잔량이 30% 초과일 때만 전원을 켤 수 있도록 조건을 설정했습니다.
     */
    @Override
    public void powerOn() {
        if (batteryCapacity > 30) {
            System.out.println("☆☆☆ 핸드폰이 켜졌습니다 ☆☆☆\n");
            isOn = true; // 전원 상태를 켜짐으로 변경합니다.
        } else {
            System.out.println("☆☆☆ 배터리 부족 ☆☆☆"); // 배터리가 부족하면 전원을 켤 수 없다는 메시지를 출력합니다.
        }
    }

    /**
     * `powerOff()` 메소드 구현: 휴대폰의 전원을 끄는 기능입니다.
     * `@Override` 어노테이션은 이 메소드가 Phone 인터페이스의 `powerOff()` 메소드를 구현한다는 것을 명시합니다.
     */
    @Override
    public void powerOff() {
        System.out.println("☆☆☆ 핸드폰이 꺼집니다 ☆☆☆");
        isOn = false; // 전원 상태를 꺼짐으로 변경합니다.
    }

    /**
     * `isOn()` 메소드 구현: 휴대폰의 전원 켜짐 상태를 반환하는 기능입니다.
     * `@Override` 어노테이션은 이 메소드가 Phone 인터페이스의 `isOn()` 메소드를 구현한다는 것을 명시합니다.
     * 현재 `isOn` 필드의 값을 그대로 반환합니다.
     */
    @Override
    public boolean isOn() {
        return isOn; // `if (isOn) { return true; } else { return false; }`와 동일한 표현입니다.
    }

    /**
     * `watchYouTube()` 메소드 구현: 유튜브 시청 기능입니다.
     * `@Override` 어노테이션은 이 메소드가 Phone 인터페이스의 `watchYouTube()` 메소드를 구현한다는 것을 명시합니다.
     * 배터리 잔량이 10% 초과일 때만 유튜브를 시청할 수 있으며, 시청 시 배터리가 10% 소모됩니다.
     * 배터리가 부족하면 자동으로 전원을 끄도록 구현했습니다.
     */
    @Override
    public void watchYouTube() {
        if (batteryCapacity > 10) {
            System.out.println("유튜브 좀 보겠습니다.");
            batteryCapacity -= 10; // 배터리 10% 소모
            System.out.printf("배터리 잔량 : %d%%%n", batteryCapacity);
        } else {
            System.out.println("배터리가 많이 없으므로 보지 않겠습니다.");
            powerOff(); // 배터리가 부족하면 자동으로 전원 끔
        }
    }

    /**
     * `charge()` 메소드 구현: 휴대폰을 충전하는 기능입니다.
     * `@Override` 어노테이션은 이 메소드가 Phone 인터페이스의 `charge()` 메소드를 구현한다는 것을 명시합니다.
     * 배터리 잔량이 `Phone.MAX_BATTERY_CAPACITY` (100%)에서 20% 미만일 때만 충전합니다.
     * 즉, 배터리 잔량이 80% 미만일 때만 충전을 시작하며, 충전 시 배터리가 5% 증가합니다.
     * `Phone.MAX_BATTERY_CAPACITY`는 Phone 인터페이스에 정의된 상수입니다.
     */
    @Override
    public void charge() {
        if (batteryCapacity < Phone.MAX_BATTERY_CAPACITY - 20) { // 배터리 잔량이 80% 미만일 때
            System.out.println("충전을 시작하겠습니다.");
            batteryCapacity += 5; // 배터리 5% 충전
            System.out.printf("배터리 잔량 : %d%%%n", batteryCapacity);
        } else {
            System.out.println("배터리가 충분한거 같습니다.");
            System.out.printf("배터리 잔량 : %d%%%n", batteryCapacity);
        }
    }
}