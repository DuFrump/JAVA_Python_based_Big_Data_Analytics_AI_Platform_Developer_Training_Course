/**
 * 안녕하세요, 두프룸프님! 이번 예제에서는 'Phone'이라는 추상 클래스와
 * 이를 상속받아 구현한 'PineapplePhone' 클래스를 사용하는 방법을 알아볼 거예요.
 * 추상 클래스가 어떻게 '틀'을 제공하고, 자식 클래스가 그 틀을 완성하는지 이해하는 데 도움이 될 겁니다.
 *
 * <오늘 배울 핵심 개념>
 * 1.  **추상 클래스 (Abstract Class) 복습**: 
 *     - 'abstract' 키워드로 선언되며, 직접 객체를 생성할 수 없어요.
 *     - 미완성된 메소드, 즉 '추상 메소드(Abstract Method)'를 가질 수 있습니다.
 *       추상 메소드는 선언만 있고 구현이 없는 메소드예요.
 *     - 추상 클래스를 상속받는 자식 클래스는 부모의 추상 메소드를 반드시 구현(오버라이딩)해야 합니다.
 *
 * 2.  **추상 메소드 구현의 중요성**: 
 *     - 'Phone' 클래스에는 `openingLogo()`라는 추상 메소드가 있어요.
 *     - 'PineapplePhone' 클래스는 이 `openingLogo()` 메소드를 반드시 구현해야만
 *       '완성된' 클래스가 되어 객체를 생성할 수 있습니다.
 *     - 만약 구현하지 않으면 'PineapplePhone'도 추상 클래스가 되어야 해요.
 *
 * 이 예제를 통해 추상 클래스가 어떻게 공통된 기능을 정의하면서도,
 * 각 자식 클래스마다 다르게 구현되어야 할 부분을 강제하는지 명확히 이해할 수 있을 거예요.
 * 함께 코드를 보면서 추상 클래스의 활용법을 익혀봅시다!
 */

package _02_Phone;

// Main 클래스는 Phone 추상 클래스와 이를 구현한 PineapplePhone 클래스를 사용하는 예제입니다.
// 프로그램의 시작점인 main 메소드를 포함하고 있습니다.
public class Main {
    public static void main(String[] args) {
        // [1] PineapplePhone 객체 생성
        // PineapplePhone은 Phone 추상 클래스를 상속받아 모든 추상 메소드를 구현했기 때문에,
        // '완성된' 클래스가 되어 객체 생성이 가능합니다.
        PineapplePhone pp = new PineapplePhone();

        System.out.println("--- 파인애플 폰 동작 ---");

        // [2] `powerOn()` 메소드 호출
        // 이 메소드는 Phone 클래스에 일반 메소드로 정의되어 있으며, PineapplePhone이 상속받아 사용합니다.
        // 자식 클래스에서 별도로 오버라이딩하지 않았으므로 부모의 구현이 그대로 사용됩니다.
        pp.powerOn(); // 출력: 핸드폰이 켜집니다.

        // [3] `openingLogo()` 메소드 호출
        // 이 메소드는 Phone 클래스의 추상 메소드였지만, PineapplePhone 클래스에서 반드시 구현(오버라이딩)했습니다.
        // 따라서 PineapplePhone 객체를 통해 호출하면 PineapplePhone에 구현된 내용이 실행됩니다.
        pp.openingLogo(); // 출력: ★★★

        // [4] `powerOff()` 메소드 호출
        // 이 메소드 역시 Phone 클래스에 일반 메소드로 정의되어 있으며, PineapplePhone이 상속받아 사용합니다.
        pp.powerOff(); // 출력: 핸드폰이 꺼집니다.

        // [참고] 추상 클래스는 직접 객체를 생성할 수 없습니다.
        // 아래 주석을 해제하면 컴파일 에러가 발생합니다.
        // Phone p = new Phone(); // 에러: Phone is abstract; cannot be instantiated
        // 하지만 다형성을 활용하여 추상 클래스 타입으로 자식 객체를 참조할 수는 있습니다.
        // Phone p = new PineapplePhone();
        // p.powerOn();
        // p.openingLogo(); // PineapplePhone의 openingLogo()가 호출됩니다.
    }
}