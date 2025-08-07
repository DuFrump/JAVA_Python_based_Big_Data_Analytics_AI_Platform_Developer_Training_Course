package _11_Quiz.BurgerType;

// Burgers 클래스는 모든 햄버거의 기본적인 속성과 조리 과정을 나타내는 부모 클래스(Superclass)입니다.
public class Burgers {
    // 필드: 햄버거의 이름을 저장합니다.
    String name;

    // 생성자: Burgers 객체를 생성할 때 햄버거 이름을 초기화합니다.
    Burgers(String name) {
        this.name = name;
    }

    // 메소드: 햄버거를 조리하는 과정을 출력합니다.
    // 이 메소드는 자식 클래스에서 오버라이딩되거나 확장될 수 있습니다.
    void cook() {
        System.out.printf("--- %s 조리 시작 ---\%n", name);
        System.out.printf("%s 재료%n", name);
        System.out.println("양상추");
        System.out.println("패티");

        // 햄버거 이름에 따라 추가 재료를 출력합니다.
        // 이 부분은 자식 클래스에서 오버라이딩하여 각 햄버거에 맞는 재료를 추가하는 것이 더 객체지향적일 수 있습니다.
        if (name.contains("새우")) {
            System.out.println("새우 추가");
        } else if (name.contains("치즈")) {
            System.out.println("치즈 추가");
        }
        System.out.printf("--- %s 조리 완료 ---\%n", name);
    }
}
