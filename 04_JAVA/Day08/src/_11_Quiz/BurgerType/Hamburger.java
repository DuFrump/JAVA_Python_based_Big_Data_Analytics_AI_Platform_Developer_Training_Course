package _11_Quiz.BurgerType;

/**
 * 안녕하세요, 두프룸프님! 이번에는 `Burgers` 클래스를 상속받는 '햄버거' 클래스를 만들어볼 거예요.
 * `Hamburger` 클래스는 `Burgers` 클래스의 자식 클래스이자, 다른 특정 햄버거들(불고기 버거, 치즈 버거 등)의 부모 클래스 역할을 합니다.
 * 즉, 햄버거의 기본적인 속성과 조리 과정을 정의하고, 이를 자식 클래스들이 물려받아 확장하거나 재정의할 수 있도록 합니다.
 *
 * 이 예제에서는 다음을 중점적으로 살펴볼 거예요:
 * 1. 부모 클래스(`Burgers`)를 상속받는 방법
 * 2. `protected` 접근 제어자를 사용하여 자식 클래스에서 필드에 접근할 수 있도록 하는 방법
 * 3. `this()`를 사용하여 한 생성자에서 다른 생성자를 호출하는 방법
 * 4. 기본적인 햄버거 조리 과정을 정의하고, 자식 클래스에서 오버라이딩할 수 있도록 준비하는 방법
 *
 * 자, 그럼 햄버거의 기본을 함께 다져볼까요?
 */
public class Hamburger extends Burgers {
    // 필드(Field): 햄버거의 이름을 저장합니다.
    // `protected`로 선언하여 자식 클래스(`BulgogiBurger`, `CheeseBurger` 등)에서 이 `name` 필드에 직접 접근할 수 있도록 합니다.
    protected String name;

    // [1] 기본 생성자: 매개변수 없이 `Hamburger` 객체를 생성할 때 호출됩니다.
    // `this("햄버거")`는 이 클래스 내의 다른 생성자(`public Hamburger(String name)`)를 호출하는 거예요.
    // 이렇게 하면 중복 코드를 줄이고, 모든 `Hamburger` 객체가 기본 이름을 가지도록 할 수 있습니다.
    public Hamburger() {
        this("햄버거");
    }

    // [2] 매개변수 있는 생성자: 햄버거 이름을 받아 초기화합니다.
    // `super(name)`은 부모 클래스인 `Burgers`의 생성자를 호출하는 거예요.
    // `Burgers` 클래스에서 `name` 필드를 초기화하는 역할을 합니다.
    public Hamburger(String name) {
        super(name);
        this.name = name; // 이 부분은 super(name)에서 이미 처리되므로 사실상 중복입니다. 제거해도 무방합니다.
    }

    // 메소드(Method): 햄버거를 조리하는 기본적인 과정을 출력합니다.
    // 이 메소드는 자식 클래스에서 오버라이딩하여 각 햄버거에 맞는 추가 재료를 포함할 수 있습니다.
    // `this.name`을 사용하여 현재 객체의 이름을 출력합니다.
    public void cook() {
        System.out.printf("--- %s 조리 시작 ---%n", this.name);
        System.out.println("양상추");
        System.out.println("패티");
        System.out.printf("--- %s 조리 완료 ---%n", this.name);
    }
}

