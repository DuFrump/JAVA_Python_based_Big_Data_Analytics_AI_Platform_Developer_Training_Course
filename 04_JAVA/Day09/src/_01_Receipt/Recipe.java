package _01_Receipt;

// Recipe 클래스는 추상 클래스(Abstract Class)입니다.
// `abstract` 키워드가 붙은 클래스는 객체를 직접 생성할 수 없습니다.
// 이 클래스는 모든 레시피의 공통적인 속성과 기능을 정의하며,
// 자식 클래스에서 반드시 구현해야 할 추상 메소드를 포함할 수 있습니다.
public abstract class Recipe {
    // 필드: 레시피를 만든 셰프의 이름을 저장합니다.
    String chef;

    // 생성자: Recipe 객체를 생성할 때 셰프 이름을 초기화합니다.
    // 추상 클래스도 생성자를 가질 수 있으며, 자식 클래스에서 `super()`를 통해 호출됩니다.
    Recipe(String chef) {
        this.chef = chef;
    }

    // 일반 메소드: 레시피 정보를 출력합니다.
    void info() {
        System.out.printf("이 레시피는 %s 셰프님의 레시피입니다.%n", chef);
    }

    // [참고] 추상 메소드 (Abstract Method)
    // 추상 메소드는 선언만 있고 구현(몸체)이 없는 메소드입니다.
    // `public abstract void prepare();`
    // 추상 메소드를 하나라도 포함하는 클래스는 반드시 추상 클래스로 선언되어야 합니다.
    // 자식 클래스는 부모의 추상 메소드를 반드시 오버라이딩하여 구현해야 합니다.
}
