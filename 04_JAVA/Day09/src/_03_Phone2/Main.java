package _03_Phone2;

// Main 클래스는 Person 클래스와 Phone 인터페이스를 구현한 다양한 휴대폰 클래스를 사용하여
// 휴대폰 사용 시나리오를 시뮬레이션하는 예제입니다.
public class Main {
    public static void main(String[] args) {
        // [1] Person 객체 생성 및 초기 휴대폰 설정
        // `Person jimin = new Person(new PineapplePhone2());`
        // - Person 객체 `jimin`을 생성하면서 `PineapplePhone2` 객체를 주입합니다.
        // - `jimin`은 `Phone` 인터페이스를 통해 `PineapplePhone2`의 기능을 사용합니다. (다형성)
        Person jimin = new Person(new PineapplePhone2());

        System.out.println("--- 지민의 첫 번째 휴대폰 (파인애플 폰) ---");
        jimin.turnOnPhone(); // 휴대폰 전원 켜기

        // [2] 유튜브 시청 및 충전 시나리오 (파인애플 폰)
        for(int i = 1; i <= 6; i++) { // 6번 반복 (원래 1 < 6 이었으나, 6번까지 실행되도록 <=로 변경)
            jimin.watchYouTube(); // 유튜브 시청 (배터리 소모)

            if (i % 3 == 0) { // 3번째마다 충전
                jimin.chargePhone();
            }
        }

        System.out.println("
----------------------------------------
");

        // [3] 새로운 휴대폰 구매 및 교체
        // `jimin.buyNewPhone(new ThreeStarPhone2());`
        // - `jimin`은 새로운 `ThreeStarPhone2` 객체를 구매하여 기존 `PineapplePhone2`를 교체합니다.
        // - `Person` 클래스는 `Phone` 인터페이스를 통해 휴대폰을 다루므로, 어떤 브랜드의 휴대폰이든 교체 가능합니다.
        jimin.buyNewPhone(new ThreeStarPhone2());
        System.out.println("--- 지민의 새 휴대폰 (쓰리스타 폰) ---");
        jimin.turnOnPhone(); // 새 휴대폰 전원 켜기

        // [4] 유튜브 시청 및 충전 시나리오 (쓰리스타 폰)
        for(int i = 1; i <= 5; i++) { // 5번 반복 (원래 1 < 5 이었으나, 5번까지 실행되도록 <=로 변경)
            jimin.watchYouTube(); // 유튜브 시청 (배터리 소모)

            if (i % 2 == 0) { // 2번째마다 충전
                jimin.chargePhone();
            }
        }
    }
}
