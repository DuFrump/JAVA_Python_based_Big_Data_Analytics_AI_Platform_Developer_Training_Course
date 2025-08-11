/**
 * 안녕하세요, 두프룸프님! 이번에는 'Person' 클래스를 통해
 * '인터페이스(Interface)'가 어떻게 객체 간의 '느슨한 결합(Loose Coupling)'을 가능하게 하고,
 * 코드의 유연성과 확장성을 높이는지 배워볼 거예요.
 * 사람이 휴대폰을 사용하는 시나리오에서 'Person'이 특정 휴대폰 브랜드에 얽매이지 않고
 * 어떤 휴대폰이든 사용할 수 있도록 설계하는 방법을 살펴봅시다!
 *
 * <오늘 배울 핵심 개념>
 * 1.  **인터페이스 타입의 필드**: 
 *     - `Phone p;`와 같이 인터페이스 타입으로 필드를 선언하면,
 *       이 필드는 해당 인터페이스를 구현한 어떤 클래스의 객체든 참조할 수 있게 됩니다.
 *     - `Person` 클래스는 `Phone` 인터페이스에만 의존하므로, 실제 휴대폰의 종류(PineapplePhone2, ThreeStarPhone2 등)를 몰라도 됩니다.
 *
 * 2.  **의존성 주입 (Dependency Injection)**: 
 *     - `Person` 클래스의 생성자 `Person(Phone p)`를 통해 외부에서 `Phone` 객체를 받아오는 방식을 '의존성 주입'이라고 해요.
 *     - `Person` 클래스 내부에서 직접 `new PineapplePhone2()`와 같이 객체를 생성하지 않고,
 *       외부에서 필요한 객체를 '주입'받음으로써 `Person` 클래스와 특정 휴대폰 클래스 간의 의존성을 제거합니다.
 *     - 이는 코드의 재사용성을 높이고, 테스트를 용이하게 하며, 유지보수를 쉽게 만듭니다.
 *
 * 3.  **다형성 (Polymorphism) 활용**: 
 *     - `p.powerOn()`, `p.watchYouTube()`와 같이 인터페이스의 메소드를 호출하면,
 *       실제 `p`가 참조하는 객체(예: PineapplePhone2 또는 ThreeStarPhone2)에 따라
 *       해당 객체에 구현된 메소드가 실행됩니다.
 *     - `Person` 클래스는 `Phone` 인터페이스의 메소드만 알면 되므로, 새로운 휴대폰이 추가되어도 `Person` 클래스를 수정할 필요가 없습니다.
 *
 * 이 'Person' 클래스는 객체 지향 설계 원칙 중 하나인 '개방-폐쇄 원칙(Open-Closed Principle)'을 잘 보여줍니다.
 * (확장에는 열려 있고, 수정에는 닫혀 있다.)
 * 함께 코드를 분석하며 인터페이스를 통한 유연한 설계의 중요성을 이해해 봅시다!
 */

package _03_Phone2;

// Person 클래스는 Phone 인터페이스를 통해 휴대폰을 사용하는 사람을 나타냅니다.
// `Phone` 인터페이스 타입의 필드를 가짐으로써, 어떤 종류의 휴대폰이든 유연하게 사용할 수 있습니다.
public class Person {
    // 필드: Phone 인터페이스 타입의 참조 변수 `p`.
    // 이 변수는 `Phone` 인터페이스를 구현한 어떤 클래스의 객체든 참조할 수 있습니다.
    // 예를 들어, PineapplePhone2 객체나 ThreeStarPhone2 객체를 참조할 수 있습니다.
    Phone p;

    /**
     * Person 클래스의 생성자입니다.
     * Person 객체를 생성할 때 사용할 Phone 객체를 외부로부터 '주입'받습니다.
     * @param p Person이 사용할 Phone 인터페이스를 구현한 객체
     */
    Person (Phone p) {
        this.p = p;
    }

    /**
     * 새로운 휴대폰을 구매하여 교체하는 기능입니다.
     * @param p 새로 구매한 Phone 인터페이스를 구현한 객체
     */
    void buyNewPhone(Phone p) {
        this.p = p; // 기존 휴대폰을 새로운 휴대폰으로 교체합니다.
        System.out.println("= = = = = = = = = =");
        System.out.println("새 핸드폰을 샀습니다.");
    }

    /**
     * 현재 사용 중인 휴대폰의 전원을 켜는 기능입니다.
     * `p.powerOn()`을 호출하면, `p`가 참조하는 실제 객체(예: PineapplePhone2 또는 ThreeStarPhone2)에
     * 구현된 `powerOn()` 메소드가 실행됩니다. 이것이 다형성입니다.
     */
    void turnOnPhone() {
        p.powerOn();
    }

    /**
     * 현재 사용 중인 휴대폰의 전원을 끄는 기능입니다.
     * `p.powerOff()`를 호출하면, `p`가 참조하는 실제 객체에 구현된 `powerOff()` 메소드가 실행됩니다.
     */
    void turnOffPhone() {
        p.powerOff();
    }

    /**
     * 현재 사용 중인 휴대폰으로 유튜브를 시청하는 기능입니다.
     * 유튜브를 시청하기 전에 휴대폰이 켜져 있는지 확인합니다.
     */
    void watchYouTube() {
        // 휴대폰이 켜져 있을 때만 유튜브를 볼 수 있습니다.
        if (p.isOn()) {
            p.watchYouTube(); // `p`가 참조하는 실제 객체의 `watchYouTube()` 메소드 호출
        } else {
            System.out.println("폰이 꺼져서 유튜브를 볼 수 없습니다.");
        }
    }

    /**
     * 현재 사용 중인 휴대폰을 충전하는 기능입니다.
     * `p.charge()`를 호출하면, `p`가 참조하는 실제 객체에 구현된 `charge()` 메소드가 실행됩니다.
     */
    void chargePhone() {
        p.charge();
    }
}