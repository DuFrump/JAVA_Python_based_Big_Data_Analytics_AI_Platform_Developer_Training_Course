package _11_Quiz.BurgerType;

// Hamburger 클래스는 모든 햄버거의 기본적인 속성과 조리 과정을 나타내는 부모 클래스(Superclass)입니다.
// 이 클래스를 상속받아 다양한 종류의 햄버거를 정의할 수 있습니다.
public class Hamburger {
    // 필드: 햄버거의 이름을 저장합니다. `protected`로 선언하여 자식 클래스에서 접근 가능하도록 합니다.
    protected String name;

    // [1] 기본 생성자: 매개변수 없이 호출될 때, `this("햄버거")`를 통해 다른 생성자를 호출합니다.
    public Hamburger() {
        this("햄버거");
    }

    // [2] 매개변수 있는 생성자: 햄버거 이름을 받아 초기화합니다.
    public Hamburger(String name) {
        this.name = name;
    }

    // 메소드: 햄버거를 조리하는 기본적인 과정을 출력합니다.
    // 이 메소드는 자식 클래스에서 오버라이딩하여 각 햄버거에 맞는 추가 재료를 포함할 수 있습니다.
    public void cook() {
        System.out.printf("--- %s 조리 시작 ---\%n", this.name);
        System.out.println("양상추");
        System.out.println("패티");
        System.out.printf("--- %s 조리 완료 ---\%n", this.name);
    }
}

