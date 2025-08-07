package _11_Quiz.BurgerType;

// ShrimpBurger 클래스는 Hamburger 클래스를 상속받는 자식 클래스입니다.
// 새우 버거만의 특성과 조리 과정을 정의합니다.
public class ShrimpBurger extends Hamburger {
    // 생성자: ShrimpBurger 객체를 생성할 때 호출됩니다.
    // `super("새우버거")`를 통해 부모 클래스(Hamburger)의 생성자를 호출하여 `name`을 초기화합니다.
    public ShrimpBurger() {
        super("새우버거");
    }

    // 메소드 오버라이딩: `cook()`
    // 부모 클래스(Hamburger)의 `cook()` 메소드를 재정의합니다.
    // `super.cook()`을 통해 부모의 기본적인 조리 과정을 실행한 후, 새우 버거만의 추가 재료를 출력합니다.
    @Override
    public void cook() {
        super.cook(); // "양상추", "패티" 등 기본적인 재료 출력
        System.out.println("새우 추가"); // 새우 버거에 새우 추가
    }
}