package _03_Phone2;

public class Person {
    Phone p;

    Person (Phone p) {
        this.p = p;
    }

    void buyNewPhone(Phone p) {
        this.p = p;
        System.out.println("= = = = = = = = = =");
        System.out.println("새 핸드폰을 샀습니다.");
    }

    void turnOnPhone() {
        p.powerOn();
    }

    void turnOffPhone() {
        p.powerOff();
    }

    void watchYouTube() {
        if (p.isOn()) {
            p.watchYouTube();
        } else {
            System.out.println("폰이 꺼져서 유튜브를 볼 수 없습니다.");
        }
    }

    void chargePhone() {
        p.charge();
    }
}
