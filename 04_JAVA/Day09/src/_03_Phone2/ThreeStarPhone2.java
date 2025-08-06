package _03_Phone2;

public class ThreeStarPhone2 implements Phone {
    int batteryCapacity = 35;
    boolean isOn = false;

    @Override
    public void powerOn() {
        if (batteryCapacity > 30) {
            System.out.println("☆☆☆ 핸드폰이 켜졌습니다 ☆☆☆\n");
            isOn = true;
        } else {
            System.out.println("☆☆☆ 배터리 부족 ☆☆☆");
        }
    }

    @Override
    public void powerOff() {
        System.out.println("☆☆☆ 핸드폰이 꺼집니다 ☆☆☆");
        isOn = false;
    }

    @Override
    public boolean isOn() {
        if (isOn) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void watchYouTube() {
        if (batteryCapacity > 10) {
            System.out.println("유튜브 좀 보겠습니다.");
            batteryCapacity -= 10;
            System.out.printf("배터리 잔량 : %d%%%n", batteryCapacity);
        } else {
            System.out.println("배터리가 많이 없으므로 보지 않겠습니다.");
            powerOff();
        }
    }

    @Override
    public void charge() {
        if (batteryCapacity < Phone.MAX_BATTERY_CAPACITY - 20) {
            System.out.println("충전을 시작하겠습니다.");
            batteryCapacity += 5;
            System.out.printf("배터리 잔량 : %d%%%n", batteryCapacity);
        } else {
            System.out.println("배터리가 충분한거 같습니다.");
            System.out.printf("배터리 잔량 : %d%%%n", batteryCapacity);
        }
    }
}
