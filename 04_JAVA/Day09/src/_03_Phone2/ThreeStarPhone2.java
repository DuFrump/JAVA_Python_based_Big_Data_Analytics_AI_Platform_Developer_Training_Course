package _03_Phone2;

// ThreeStarPhone2 클래스는 Phone 인터페이스를 구현(implements)합니다.
// 인터페이스를 구현하는 클래스는 인터페이스에 정의된 모든 추상 메소드를 반드시 오버라이딩하여 구현해야 합니다.
public class ThreeStarPhone2 implements Phone {
    // 필드: 배터리 잔량과 전원 켜짐 상태를 저장합니다.
    int batteryCapacity = 35; // 초기 배터리 잔량
    boolean isOn = false;     // 초기 전원 상태 (꺼짐)

    // [1] `powerOn()` 메소드 구현: 전원을 켜는 기능
    // 배터리 잔량이 30% 초과일 때만 전원을 켤 수 있습니다.
    @Override
    public void powerOn() {
        if (batteryCapacity > 30) {
            System.out.println("☆☆☆ 핸드폰이 켜졌습니다 ☆☆☆\n");
            isOn = true;
        } else {
            System.out.println("☆☆☆ 배터리 부족 ☆☆☆");
        }
    }

    // [2] `powerOff()` 메소드 구현: 전원을 끄는 기능
    @Override
    public void powerOff() {
        System.out.println("☆☆☆ 핸드폰이 꺼집니다 ☆☆☆");
        isOn = false;
    }

    // [3] `isOn()` 메소드 구현: 전원 켜짐 상태를 반환하는 기능
    @Override
    public boolean isOn() {
        return isOn; // `if (isOn) { return true; } else { return false; }`와 동일
    }

    // [4] `watchYouTube()` 메소드 구현: 유튜브 시청 기능
    // 배터리 잔량이 10% 초과일 때만 유튜브를 시청할 수 있으며, 시청 시 배터리가 소모됩니다.
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

    // [5] `charge()` 메소드 구현: 충전 기능
    // 배터리 잔량이 최대 용량에서 20% 미만일 때만 충전합니다.
    // `Phone.MAX_BATTERY_CAPACITY`는 인터페이스에 정의된 상수입니다.
    @Override
    public void charge() {
        if (batteryCapacity < Phone.MAX_BATTERY_CAPACITY - 20) {
            System.out.println("충전을 시작하겠습니다.");
            batteryCapacity += 5; // 배터리 5% 충전
            System.out.printf("배터리 잔량 : %d%%%n", batteryCapacity);
        } else {
            System.out.println("배터리가 충분한거 같습니다.");
            System.out.printf("배터리 잔량 : %d%%%n", batteryCapacity);
        }
    }
}
