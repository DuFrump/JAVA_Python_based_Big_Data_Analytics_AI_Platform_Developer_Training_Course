package _03_Phone2;

// Person 클래스는 Phone 인터페이스를 통해 휴대폰을 사용하는 사람을 나타냅니다.
// `Phone` 인터페이스 타입의 필드를 가짐으로써, 어떤 종류의 휴대폰이든 유연하게 사용할 수 있습니다.
public class Person {
    // 필드: Phone 인터페이스 타입의 참조 변수. 어떤 Phone 구현체든 참조할 수 있습니다.
    Phone p;

    // 생성자: Person 객체를 생성할 때 사용할 Phone 객체를 주입받습니다.
    Person (Phone p) {
        this.p = p;
    }

    // 메소드: 새로운 휴대폰을 구매하여 교체하는 기능
    // `Phone` 타입의 매개변수를 받으므로, 어떤 `Phone` 구현체든 새로운 휴대폰으로 설정할 수 있습니다.
    void buyNewPhone(Phone p) {
        this.p = p;
        System.out.println("= = = = = = = = = =");
        System.out.println("새 핸드폰을 샀습니다.");
    }

    // 메소드: 휴대폰 전원을 켜는 기능
    void turnOnPhone() {
        p.powerOn(); // `p`가 참조하는 실제 객체의 `powerOn()` 메소드 호출
    }

    // 메소드: 휴대폰 전원을 끄는 기능
    void turnOffPhone() {
        p.powerOff(); // `p`가 참조하는 실제 객체의 `powerOff()` 메소드 호출
    }

    // 메소드: 유튜브를 시청하는 기능
    void watchYouTube() {
        // 휴대폰이 켜져 있을 때만 유튜브를 볼 수 있습니다.
        if (p.isOn()) {
            p.watchYouTube(); // `p`가 참조하는 실제 객체의 `watchYouTube()` 메소드 호출
        } else {
            System.out.println("폰이 꺼져서 유튜브를 볼 수 없습니다.");
        }
    }

    // 메소드: 휴대폰을 충전하는 기능
    void chargePhone() {
        p.charge(); // `p`가 참조하는 실제 객체의 `charge()` 메소드 호출
    }
}
