package _04_Inheritance_public.Access02;

// Parent 클래스는 다른 패키지(`_04_Inheritance_public.Access01`)에 있으므로 import 해야 합니다.
import _04_Inheritance_public.Access01.Parent;

// Child 클래스는 Parent 클래스를 상속받는 자식 클래스입니다.
// `protected` 접근 제어자의 동작을 보여주는 예제입니다.
public class Child extends Parent {
    // `accessTest()` 메소드에서 부모 클래스의 `protected` 멤버에 접근합니다.
    void accessTest() {
        // `super.accessProtected()`:
        // `protected` 멤버는 다른 패키지에 있더라도 자식 클래스에서는 `super` 키워드를 통해 접근할 수 있습니다.
        super.accessProtected(); // Parent 클래스의 protected 메소드 호출

        // [참고] 다른 패키지에 있는 부모 클래스의 객체를 직접 생성하여 `protected` 멤버에 접근하는 것은 불가능합니다.
        // 아래 주석을 해제하면 컴파일 에러가 발생합니다.
        // Parent p1 = new Parent(); // 에러: Parent() has protected access in Parent
        // p1.accessProtected(); // 에러: accessProtected() has protected access in Parent
    }
}
