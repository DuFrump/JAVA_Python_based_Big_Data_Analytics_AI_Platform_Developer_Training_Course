// 메소드 오버로딩(Overloading)과 오버라이딩(Overriding)의 차이점을 배우는 예제입니다.
// 이 두 개념은 자바의 다형성(Polymorphism)을 구현하는 중요한 요소입니다.

// [1] Parent1 클래스: 부모 클래스
class Parent1 {
    // `display()` 메소드: 자식 클래스에서 오버라이딩될 예정
    public void display() {
        System.out.println("부모 클래스의 display() 메서드입니다.");
    }
}

// [2] Child1 클래스: Parent1을 상속받는 자식 클래스
class Child1 extends Parent1 {
    // [2-1] 메소드 오버라이딩(Overriding)
    // - 부모 클래스에 정의된 메소드를 자식 클래스에서 재정의하는 것입니다.
    // - 메소드 이름, 매개변수 타입 및 개수, 반환 타입이 모두 동일해야 합니다.
    // - `@Override` 어노테이션을 사용하여 오버라이딩임을 명시하는 것이 좋습니다.
    @Override
    public void display() {
        System.out.println("자식 클래스의 display() 메서드입니다.");
    }

    // [2-2] 메소드 오버로딩(Overloading)
    // - 같은 클래스 내에서 메소드 이름은 같지만, 매개변수의 타입이나 개수가 다른 여러 메소드를 정의하는 것입니다.
    // - 반환 타입은 같거나 달라도 상관없습니다.
    // - `display()` 메소드를 오버로딩하여 String 타입의 매개변수를 받는 버전을 추가합니다.
    public void display(String str) {
        System.out.println(str);
    }
}

public class _10_OverloadingOverriding {

    public static void main(String[] args) {
        // [3] 오버라이딩된 메소드 호출
        Child1 ch = new Child1();
        System.out.println("--- 오버라이딩된 메소드 호출 ---");
        ch.display(); // Child1 클래스에서 오버라이딩된 display() 호출

        Parent1 pa = new Parent1();
        pa.display(); // Parent1 클래스의 display() 호출

        // [4] 다형성(Polymorphism)과 오버라이딩
        // 부모 타입의 참조 변수로 자식 객체를 참조할 때, 오버라이딩된 메소드는 실제 객체의 메소드가 호출됩니다.
        Parent1 pa1 = new Child1();
        System.out.println("\n--- 다형성으로 오버라이딩된 메소드 호출 ---");
        pa1.display(); // 실제 객체는 Child1이므로, Child1의 display() 호출

        // [5] 오버로딩된 메소드 호출
        System.out.println("\n--- 오버로딩된 메소드 호출 ---");
        ch.display("이건 문자열을 따로 받게끔 만든 Overloading 메서드입니다.");

        // [중요] 부모 타입의 참조 변수로는 자식 클래스에 오버로딩된 메소드를 직접 호출할 수 없습니다.
        // 왜냐하면 오버로딩된 메소드는 부모 클래스에는 존재하지 않기 때문입니다.
        // 아래 주석을 해제하면 컴파일 에러가 발생합니다.
        // pa.display("이건 문자열을 따로 받게끔 만든 Overloading 메서드입니다.");
        // 에러 메시지: The method display(String) is undefined for the type Parent1
        System.out.println("\npa.display(\"\")는 컴파일 에러 발생 (Parent1에 해당 오버로딩 메소드 없음)");
    }
}
