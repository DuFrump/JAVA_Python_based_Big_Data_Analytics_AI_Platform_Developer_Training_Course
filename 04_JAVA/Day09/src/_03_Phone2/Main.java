/**
 * 안녕하세요, 두프룸프님! 이번 예제에서는 '인터페이스(Interface)'와 '다형성(Polymorphism)'을
 * 활용하여 더욱 유연하고 확장성 있는 프로그램을 만드는 방법을 배워볼 거예요.
 * 사람이 휴대폰을 사용하는 시나리오를 통해 인터페이스의 강력함을 직접 경험해 봅시다!
 *
 * <오늘 배울 핵심 개념>
 * 1.  **인터페이스 (Interface) 복습**: 
 *     - 클래스가 구현해야 할 메소드들의 '규약' 또는 '청사진'을 정의하는 역할을 해요.
 *     - 모든 메소드는 기본적으로 `public abstract`이며, 필드는 `public static final`입니다.
 *     - 인터페이스는 `implements` 키워드를 사용하여 클래스에 의해 구현됩니다.
 *     - 클래스는 여러 개의 인터페이스를 구현할 수 있습니다. (다중 상속의 대안)
 *
 * 2.  **인터페이스를 통한 다형성**: 
 *     - 인터페이스 타입의 참조 변수는 해당 인터페이스를 구현한 모든 클래스의 객체를 참조할 수 있어요.
 *       (예: `Phone phone = new PineapplePhone2();`)
 *     - 이 예제에서는 `Person` 클래스가 `Phone` 인터페이스 타입의 필드를 가짐으로써,
 *       어떤 종류의 휴대폰(PineapplePhone2, ThreeStarPhone2 등)이든 유연하게 사용할 수 있게 됩니다.
 *
 * 3.  **객체 주입 (Dependency Injection)의 개념**: 
 *     - `Person` 객체를 생성할 때 `new Person(new PineapplePhone2())`처럼
 *       사용할 휴대폰 객체를 외부에서 '주입'해주는 방식을 볼 수 있어요.
 *     - 이는 `Person` 클래스가 특정 휴대폰 클래스에 직접적으로 의존하지 않고,
 *       `Phone` 인터페이스라는 추상적인 개념에 의존하게 함으로써 코드의 결합도를 낮추고 유연성을 높입니다.
 *
 * 이 예제를 통해 인터페이스가 어떻게 코드의 재사용성, 유연성, 그리고 확장성을 극대화하는지 이해할 수 있을 거예요.
 * 함께 코드를 분석하며 인터페이스의 진정한 가치를 느껴봅시다!
 */

package _03_Phone2;

// Main 클래스는 Person 클래스와 Phone 인터페이스를 구현한 다양한 휴대폰 클래스를 사용하여
// 휴대폰 사용 시나리오를 시뮬레이션하는 예제입니다.
// 프로그램의 시작점인 main 메소드를 포함하고 있습니다.
public class Main {
    public static void main(String[] args) {
        // [1] Person 객체 생성 및 초기 휴대폰 설정
        // `Person jimin = new Person(new PineapplePhone2());`
        // - `Person` 객체 `jimin`을 생성하면서 `PineapplePhone2` 객체를 생성하여 주입합니다.
        // - `jimin`은 `Phone` 인터페이스를 통해 `PineapplePhone2`의 기능을 사용합니다.
        //   이것이 바로 '다형성'의 한 예시입니다. `jimin`은 `Phone` 타입으로 `PineapplePhone2`를 다룹니다.
        Person jimin = new Person(new PineapplePhone2());

        System.out.println("--- 지민의 첫 번째 휴대폰 (파인애플 폰) ---");
        jimin.turnOnPhone(); // 휴대폰 전원 켜기 (PineapplePhone2의 powerOn() 호출)

        // [2] 유튜브 시청 및 충전 시나리오 (파인애플 폰)
        // for 루프의 조건을 `i <= 6`으로 변경하여 6번 반복하도록 수정했습니다.
        for(int i = 1; i <= 6; i++) {
            jimin.watchYouTube(); // 유튜브 시청 (배터리 소모)

            if (i % 3 == 0) { // 3번째마다 충전
                jimin.chargePhone();
            }
        }

        System.out.println("\n----------------------------------------\n");

        // [3] 새로운 휴대폰 구매 및 교체
        // `jimin.buyNewPhone(new ThreeStarPhone2());`
        // - `jimin`은 새로운 `ThreeStarPhone2` 객체를 구매하여 기존 `PineapplePhone2`를 교체합니다.
        // - `Person` 클래스는 `Phone` 인터페이스를 통해 휴대폰을 다루므로,
        //   어떤 브랜드의 휴대폰(PineapplePhone2, ThreeStarPhone2 등)이든 유연하게 교체하여 사용할 수 있습니다.
        //   이것이 인터페이스를 사용하는 가장 큰 장점 중 하나입니다.
        jimin.buyNewPhone(new ThreeStarPhone2());
        System.out.println("--- 지민의 새 휴대폰 (쓰리스타 폰) ---");
        jimin.turnOnPhone(); // 새 휴대폰 전원 켜기 (ThreeStarPhone2의 powerOn() 호출)

        // [4] 유튜브 시청 및 충전 시나리오 (쓰리스타 폰)
        // for 루프의 조건을 `i <= 5`로 변경하여 5번 반복하도록 수정했습니다.
        for(int i = 1; i <= 5; i++) {
            jimin.watchYouTube(); // 유튜브 시청 (배터리 소모)

            if (i % 2 == 0) { // 2번째마다 충전
                jimin.chargePhone();
            }
        }
    }
}