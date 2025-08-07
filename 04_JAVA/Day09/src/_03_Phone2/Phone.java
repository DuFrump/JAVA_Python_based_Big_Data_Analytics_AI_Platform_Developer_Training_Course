package _03_Phone2;

// Phone 인터페이스는 휴대폰이 가져야 할 필수적인 기능들을 정의합니다.
// 인터페이스는 `interface` 키워드를 사용하여 선언하며, 상수와 추상 메소드만을 가질 수 있습니다.
// (Java 8부터 default, static 메소드도 가질 수 있게 됨)
public interface Phone {
    // [1] 상수 필드: `public static final`이 자동으로 붙습니다.
    // 배터리 최대 용량을 나타내는 상수입니다.
    public static final int MAX_BATTERY_CAPACITY = 100;

    // [2] 추상 메소드: `public abstract`이 자동으로 붙습니다.
    // 이 메소드들은 인터페이스를 구현하는 모든 클래스에서 반드시 오버라이딩하여 구현해야 합니다.
    abstract void powerOn();      // 전원 켜기
    abstract void powerOff();     // 전원 끄기
    abstract boolean isOn();      // 전원 켜짐 상태 확인
    abstract void watchYouTube(); // 유튜브 시청
    abstract void charge();       // 충전
}
