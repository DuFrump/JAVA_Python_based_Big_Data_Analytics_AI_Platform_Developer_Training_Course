package _03_TypeChange_calendar;

/**
 * 안녕하세요, 두프룸프님! 이번에는 `Calendar` 클래스를 상속받는 '탁상 달력'을 만들어볼 거예요.
 * `DeskCalendar` 클래스는 `Calendar` 클래스의 '자식 클래스(Subclass)'입니다.
 * 탁상 달력은 일반 달력의 기본적인 속성(색상, 월 수)과 기능(정보 출력)을 물려받으면서도,
 * 자신만의 특별한 기능(책상에 세우기)을 가지고 있고, 어떤 기능(벽에 걸기)은 부모와 다르게 동작할 수 있죠.
 *
 * 이 예제에서는 다음을 중점적으로 살펴볼 거예요:
 * 1. 부모 클래스의 생성자를 호출하여 필드를 초기화하는 방법 (`super()`)
 * 2. 부모 클래스의 메소드를 자식 클래스에서 '재정의(Overriding)'하는 방법 (`@Override`)
 * 3. 자식 클래스만의 고유한 메소드를 추가하는 방법
 *
 * 자, 그럼 탁상 달력을 함께 만들어볼까요?
 */
public class DeskCalendar extends Calendar {
    // 생성자(Constructor): `DeskCalendar` 객체를 만들 때 호출됩니다.
    // `super(color, months)`는 부모 클래스인 `Calendar`의 생성자를 호출하는 거예요.
    // 이렇게 하면 부모 클래스에서 정의된 `color`와 `months` 필드를 초기화할 수 있답니다.
    DeskCalendar(String color, int months) {
        super(color, months);
    }

    // [1] 메소드 오버라이딩(Method Overriding): `hanging()` 메소드
    // `@Override` 어노테이션은 이 메소드가 부모 클래스(`Calendar`)의 `hanging()` 메소드를
    // 재정의(Overriding)했다는 것을 명확히 알려줍니다.
    // 탁상 달력도 벽에 걸 수는 있지만, 일반 달력과는 다르게 '추가 고리'가 필요하다는 설명을 추가했어요.
    // 이렇게 하면 같은 이름의 메소드라도 객체의 종류에 따라 다르게 동작하게 할 수 있죠!
    @Override
    void hanging() {
        System.out.printf("%s 달력을 벽에 걸려면 추가 고리 필요.%n", color);
    }

    // [2] `DeskCalendar` 고유의 메소드: `onTheDesk()`
    // 이 메소드는 `DeskCalendar` 클래스에만 있는 특별한 기능이에요.
    // 탁상 달력은 책상 위에 세워둘 수 있는 특징이 있죠? 그 기능을 코드로 표현한 것입니다.
    void onTheDesk() {
        System.out.printf("%s 달력은 책상에 세울 수 있습니다.%n", color);
    }
}
