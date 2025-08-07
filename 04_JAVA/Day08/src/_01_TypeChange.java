// 다형성(Polymorphism)의 기본 개념을 배우는 예제입니다.
// 다형성은 하나의 객체가 여러 가지 형태를 가질 수 있는 능력을 의미합니다.

// 부모 클래스 정의
class Parent {
    String name = "부모";
    void showName() {
        System.out.println("저는 " + name + "입니다.");
    }
}

// 자식 클래스 정의: Parent 클래스를 상속받습니다.
class Child extends Parent {
    String name = "자식"; // 부모와 같은 이름의 필드를 가질 수 있습니다. (필드 오버라이딩은 아님)
    @Override
    void showName() {
        System.out.println("저는 " + name + "입니다.");
    }
}

public class _01_TypeChange {
    public static void main(String[] args) {
        // [1] 일반적인 객체 생성
        Parent p1 = new Parent(); // Parent 타입의 참조 변수 p1이 Parent 객체를 참조
        Child c1 = new Child();   // Child 타입의 참조 변수 c1이 Child 객체를 참조

        System.out.println("--- 일반적인 객체 참조 ---");
p1.showName(); // 출력: 저는 부모입니다.
c1.showName(); // 출력: 저는 자식입니다.

        System.out.println(" ---------------------------------------- ");

        // [2] 다형성(Polymorphism)의 핵심: 부모 클래스 타입의 참조 변수가 자식 클래스 객체를 참조
        // `Parent p2 = new Child();`
        // - p2는 Parent 타입이지만, 실제 참조하는 객체는 Child 타입입니다.
        // - p2를 통해서는 Parent 클래스에 정의된 멤버(필드, 메소드)만 접근할 수 있습니다.
        // - 하지만 메소드를 호출할 경우, 실제 객체(Child)에 오버라이딩된 메소드가 호출됩니다.
        Parent p2 = new Child();
        Parent p3 = c1; // Child 타입의 객체 c1을 Parent 타입의 p3로 참조

        System.out.println("--- 다형성을 이용한 객체 참조 ---");
p2.showName(); // 출력: 저는 자식입니다. (Child의 showName() 호출)
p3.showName(); // 출력: 저는 자식입니다. (Child의 showName() 호출)

        // [3] 참조 변수와 실제 객체의 동일성 확인
        // p3와 c1은 같은 Child 객체를 참조하고 있습니다.
        if (p3 == c1) {
            System.out.println("p3와 c1은 같은 객체를 참조하고 있습니다.");
        }

        // [4] 필드 접근 시 주의사항
        // 다형성에서 필드에 접근할 때는 참조 변수의 타입에 따라 결정됩니다.
        // 메소드 오버라이딩과는 다릅니다.
        System.out.println(" --- 필드 접근 시 주의사항 ---");
        System.out.println("p2.name: " + p2.name); // 출력: 부모 (참조 변수 타입인 Parent의 name 필드)
        System.out.println("c1.name: " + c1.name); // 출력: 자식 (실제 객체인 Child의 name 필드)
    }
}
