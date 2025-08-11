/**
 * 안녕하세요, 두프룸프님! 오늘은 Java의 객체 지향 프로그래밍에서 매우 중요하고,
 * 때로는 헷갈릴 수 있는 두 가지 개념, '메소드 오버로딩(Overloading)'과 '메소드 오버라이딩(Overriding)'에 대해
 * 명확하게 이해하는 시간을 가질 거예요.
 *
 * 이 두 개념은 이름이 비슷해서 혼동하기 쉽지만, 하는 역할과 적용되는 상황이 완전히 다르답니다.
 * 오버로딩은 '같은 이름의 메소드를 여러 개 만드는 것'이고,
 * 오버라이딩은 '부모의 메소드를 자식 클래스에서 재정의하는 것'이에요.
 *
 * 이 예제에서는 다음을 중점적으로 살펴볼 거예요:
 * 1. 메소드 오버라이딩의 정의와 동작 방식
 * 2. 메소드 오버로딩의 정의와 동작 방식
 * 3. 다형성(Polymorphism)과 오버라이딩의 관계
 * 4. 오버로딩된 메소드를 호출할 때의 주의사항
 *
 * 이 개념들을 잘 이해하면 코드를 더욱 유연하고 효율적으로 작성할 수 있을 거예요!
 */

// [1] Parent1 클래스: 부모 클래스 역할을 하는 `Parent1` 클래스를 정의합니다.
class Parent1 {
    // `display()` 메소드: 이 메소드는 자식 클래스에서 '오버라이딩'될 예정입니다.
    // 부모 클래스에서 기본적으로 제공하는 기능이라고 생각하면 돼요.
    public void display() {
        System.out.println("부모 클래스의 display() 메서드입니다.");
    }
}

// [2] Child1 클래스: `Parent1`을 상속받는 자식 클래스 `Child1`을 정의합니다.
class Child1 extends Parent1 {
    // [2-1] 메소드 오버라이딩(Overriding)
    // - 부모 클래스에 정의된 메소드를 자식 클래스에서 '재정의'하는 것입니다.
    // - 메소드 이름, 매개변수 타입 및 개수, 반환 타입이 모두 부모의 메소드와 '동일'해야 합니다.
    // - `@Override` 어노테이션을 사용하여 오버라이딩임을 명시하는 것이 좋습니다. (컴파일러에게 알려주는 역할)
    @Override
    public void display() {
        System.out.println("자식 클래스의 display() 메서드입니다.");
    }

    // [2-2] 메소드 오버로딩(Overloading)
    // - '같은 클래스 내에서' 메소드 이름은 같지만, 매개변수의 타입이나 개수가 다른 여러 메소드를 정의하는 것입니다.
    // - 반환 타입은 같거나 달라도 상관없습니다. (하지만 보통 같은 반환 타입을 사용해요)
    // - `display()` 메소드를 오버로딩하여 `String` 타입의 매개변수를 받는 버전을 추가합니다.
    //   이렇게 하면 `display()`라는 이름으로 다양한 형태의 호출을 지원할 수 있게 됩니다.
    public void display(String str) {
        System.out.println(str);
    }
}

public class _10_OverloadingOverriding {

    public static void main(String[] args) {
        // [3] 오버라이딩된 메소드 호출
        // `Child1` 객체를 생성하고 `display()`를 호출하면, `Child1`에서 오버라이딩된 메소드가 실행됩니다.
        Child1 ch = new Child1();
        System.out.println("--- 오버라이딩된 메소드 호출 ---");
        ch.display(); // 출력: 자식 클래스의 display() 메서드입니다.

        // `Parent1` 객체를 생성하고 `display()`를 호출하면, `Parent1`의 메소드가 실행됩니다.
        Parent1 pa = new Parent1();
        pa.display(); // 출력: 부모 클래스의 display() 메서드입니다.

        // [4] 다형성(Polymorphism)과 오버라이딩
        // 부모 타입의 참조 변수로 자식 객체를 참조할 때, 오버라이딩된 메소드는 실제 객체(자식)의 메소드가 호출됩니다.
        // 이것이 바로 다형성의 핵심이자, 런타임에 어떤 메소드가 실행될지 결정되는 '동적 바인딩'입니다.
        Parent1 pa1 = new Child1();
        System.out.println("\n--- 다형성으로 오버라이딩된 메소드 호출 ---");
        pa1.display(); // `pa1`은 `Parent1` 타입이지만, 실제 객체는 `Child1`이므로 `Child1`의 `display()` 호출
                       // 출력: 자식 클래스의 display() 메서드입니다.

        // [5] 오버로딩된 메소드 호출
        // `Child1` 객체는 오버로딩된 `display(String str)` 메소드를 직접 호출할 수 있습니다.
        System.out.println("\n--- 오버로딩된 메소드 호출 ---");
        ch.display("이건 문자열을 따로 받게끔 만든 Overloading 메서드입니다.");

        // [중요] 부모 타입의 참조 변수로는 자식 클래스에 오버로딩된 메소드를 직접 호출할 수 없습니다.
        // 왜냐하면 오버로딩된 메소드는 부모 클래(`Parent1`)에는 존재하지 않기 때문입니다.
        // 컴파일러는 참조 변수의 타입(`Parent1`)만 보고 해당 메소드가 있는지 확인합니다.
        // 아래 주석을 해제하면 컴파일 에러가 발생합니다.
        // pa.display("이건 문자열을 따로 받게끔 만든 Overloading 메서드입니다.");
        // 에러 메시지: The method display(String) is undefined for the type Parent1
        System.out.println("\npa.display(\"문자열\")는 컴파일 에러 발생 (Parent1에 해당 오버로딩 메소드 없음)");

        System.out.println("\n두프룸프님, 메소드 오버로딩과 오버라이딩의 차이를 명확히 이해하셨기를 바랍니다!");
    }
}
