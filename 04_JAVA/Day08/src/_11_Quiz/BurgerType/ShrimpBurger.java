package _11_Quiz.BurgerType;

/**
 * 안녕하세요, 두프룸프님! 이번에는 `Hamburger` 클래스를 상속받는 '새우 버거'를 만들어볼 거예요.
 * `ShrimpBurger` 클래스는 `Hamburger` 클래스의 자식 클래스입니다.
 * 새우 버거는 기본적인 햄버거의 조리 과정을 따르면서도,
 * 자신만의 특별한 재료(새우)를 추가하여 조리 과정을 '재정의(Overriding)'합니다.
 *
 * 이 예제에서는 다음을 중점적으로 살펴볼 거예요:
 * 1. 부모 클래스의 생성자를 호출하여 햄버거 이름을 설정하는 방법 (`super()`)
 * 2. 부모 클래스의 메소드를 자식 클래스에서 '재정의(Overriding)'하면서 부모의 기능을 재활용하는 방법 (`super.메소드()`)
 * 3. 자신만의 추가적인 조리 단계를 구현하는 방법
 *
 * 자, 그럼 맛있는 새우 버거를 함께 만들어볼까요?
 */
public class ShrimpBurger extends Hamburger {
    // 생성자(Constructor): `ShrimpBurger` 객체를 만들 때 호출됩니다.
    // `super("새우버거")`는 부모 클래스인 `Hamburger`의 생성자를 호출하는 거예요.
    // 이렇게 하면 `Hamburger` 클래스에서 정의된 `name` 필드를 "새우버거"로 초기화할 수 있답니다.
    public ShrimpBurger() {
        super("새우버거");
    }

    // 메소드 오버라이딩(Method Overriding): `cook()` 메소드
    // `@Override` 어노테이션은 이 메소드가 부모 클래스(`Hamburger`)의 `cook()` 메소드를
    // 재정의(Overriding)했다는 것을 명확히 알려줍니다.
    // `super.cook()`을 호출하여 부모의 기본적인 조리 과정(양상추, 패티 등)을 먼저 실행한 후,
    // 새우 버거만의 특별한 재료인 새우를 추가로 출력하도록 했습니다.
    @Override
    public void cook() {
        super.cook(); // 부모 클래스의 cook() 메소드를 호출하여 기본적인 재료를 출력합니다.
        System.out.println("새우 추가"); // 새우 버거에 새우 추가
    }
}