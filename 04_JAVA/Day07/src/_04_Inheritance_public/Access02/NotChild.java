package _04_Inheritance_public.Access02;

// Parent 클래스는 다른 패키지(`_04_Inheritance_public.Access01`)에 있으므로 import 해야 합니다.
import _04_Inheritance_public.Access01.Parent;

// NotChild 클래스는 Parent 클래스를 상속받지만,
// `protected` 멤버에 대한 접근 제한을 보여주는 예제입니다.
public class NotChild extends Parent{
    // `accessTest()` 메소드에서 부모 클래스의 `protected` 멤버에 접근을 시도합니다.
    void accessTest() {
        // Parent 클래스의 객체를 생성합니다.
        Parent p2 = new Parent();

        // [중요] `protected` 멤버는 다른 패키지에서 자식 클래스가 아닌 일반 객체를 통해 직접 접근할 수 없습니다.
        // 아래 주석을 해제하면 컴파일 에러가 발생합니다.
        // p2.accessProtected(); // 에러: accessProtected() has protected access in Parent

        // Child 클래스(동일 패키지 내의 자식 클래스)에서는 `super.accessProtected()`로 접근 가능했지만,
        // NotChild 클래스(다른 패키지 내의 자식 클래스)에서 Parent 객체를 생성하여 접근하는 것은 허용되지 않습니다.
        // 이는 `protected` 접근 제어자가 상속 관계에서만 특별한 접근을 허용하기 때문입니다.
    }
}