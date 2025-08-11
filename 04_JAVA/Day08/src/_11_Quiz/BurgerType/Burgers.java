package _11_Quiz.BurgerType;

/**
 * 안녕하세요, 두프룸프님! 이번 퀴즈에서는 '햄버거'를 예시로 상속과 다형성을 복습해볼 거예요.
 * 이 `Burgers` 클래스는 모든 햄버거의 가장 기본적인 속성(이름)과 조리 과정을 나타내는 '부모 클래스(Superclass)'입니다.
 * 마치 모든 햄버거가 이름이 있고, 기본적인 조리 과정을 거치는 것처럼요.
 *
 * 이 클래스는 다양한 종류의 햄버거(예: 불고기 버거, 새우 버거)들이 공통적으로 사용할 수 있는 기반을 제공합니다.
 * 자식 클래스들은 이 부모 클래스의 속성과 기능을 물려받아 자신만의 특별한 재료를 추가하거나,
 * 부모의 조리 과정을 자신에게 맞게 변경(오버라이딩)할 수 있답니다.
 */
public class Burgers {
    // 필드(Field): 햄버거의 '속성'을 나타내는 변수입니다.
    String name; // 햄버거의 이름을 저장하는 변수입니다. (예: "불고기 버거", "새우 버거")

    // 생성자(Constructor): `Burgers` 객체를 만들 때 호출되는 특별한 메소드예요.
    // 이 생성자를 통해 햄버거의 이름을 처음 만들 때 설정해 줄 수 있습니다.
    Burgers(String name) {
        this.name = name; // 매개변수로 받은 name 값을 이 객체의 name 필드에 저장합니다.
    }

    // 메소드(Method): 햄버거의 '기능'을 나타내는 동작입니다.
    // 햄버거를 조리하는 과정을 출력하는 메소드입니다.
    // 이 메소드는 자식 클래스에서 오버라이딩되거나 확장될 수 있습니다.
    void cook() {
        System.out.printf("--- %s 조리 시작 ---%n", name);
        System.out.printf("%s 재료%n", name);
        System.out.println("양상추");
        System.out.println("패티");

        // 햄버거 이름에 따라 추가 재료를 출력합니다.
        // [개선점 제안]: 현재는 `if-else if` 문을 사용하여 햄버거 이름에 따라 추가 재료를 분기하고 있습니다.
        // 하지만 이는 새로운 햄버거 종류가 추가될 때마다 이 `cook()` 메소드를 수정해야 하는 단점이 있습니다.
        // 더 객체 지향적인 방법은 각 자식 클래스(예: `ShrimpBurger`, `CheeseBurger`)에서
        // 이 `cook()` 메소드를 오버라이딩하여 자신만의 추가 재료를 출력하도록 하는 것입니다.
        // 이렇게 하면 `Burgers` 클래스는 수정할 필요 없이 확장만 하면 되므로,
        // '개방-폐쇄 원칙(Open-Closed Principle)'을 더 잘 따를 수 있습니다.
        if (name.contains("새우")) {
            System.out.println("새우 추가");
        } else if (name.contains("치즈")) {
            System.out.println("치즈 추가");
        }
        System.out.printf("--- %s 조리 완료 ---%n", name);
    }
}
