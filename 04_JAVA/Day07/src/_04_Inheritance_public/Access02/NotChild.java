package _04_Inheritance_public.Access02;

// 다른 패키지에 있는 Parent 클래스를 사용하기 위해 import 합니다.
import _04_Inheritance_public.Access01.Parent;
// DefaultC 클래스는 default 접근 제어자이므로 다른 패키지에서는 import 할 수 없습니다.
// import _04_Inheritance_public.Access01.DefaultC; // 에러 발생!

/**
 * NotChild 클래스는 Parent 클래스와 다른 패키지(_04_Inheritance_public.Access02)에 있습니다.
 * 그리고 이 클래스는 Parent 클래스를 '상속받지 않습니다'.
 *
 * 이 예제를 통해 'protected' 접근 제어자가 상속 관계가 아닐 때 다른 패키지에서 어떻게 접근 불가능한지,
 * 그리고 'default' 접근 제어자는 다른 패키지에서 아예 접근할 수 없다는 것을 명확하게 보여줄 거예요.
 */
public class NotChild { // Parent를 상속받지 않습니다.

    public void testAccessToParentMembers() {
        System.out.println("\n--- NotChild에서 Parent 멤버 접근 테스트 (다른 패키지, 상속 관계 아님) ---");

        // Parent 클래스 자체는 public이므로 다른 패키지에서도 객체 생성은 가능합니다.
        Parent parent = new Parent();

        // 1. public 멤버 접근: 어디서든 접근 가능
        System.out.println("Parent.publicField: " + parent.publicField);
        parent.publicMethod();

        // 2. protected 멤버 접근: 다른 패키지에서 상속 관계가 아니면 접근 불가능
        // 아래 코드는 컴파일 에러를 발생시킵니다. 주석 처리하여 에러를 방지합니다.
        // System.out.println(parent.protectedField); // 에러!
        // parent.protectedMethod(); // 에러!
        System.out.println("Parent.protectedField와 protectedMethod는 다른 패키지에서 상속 관계가 아니므로 접근 불가능합니다.");

        // 3. default (package-private) 멤버 접근: 다른 패키지에서는 접근 불가능
        // 아래 코드는 컴파일 에러를 발생시킵니다. 주석 처리하여 에러를 방지합니다.
        // System.out.println(parent.defaultField); // 에러!
        // parent.defaultMethod(); // 에러!
        System.out.println("Parent.defaultField와 defaultMethod는 다른 패키지이므로 접근 불가능합니다.");

        // 4. private 멤버 접근: 해당 클래스 내에서만 접근 가능 (Parent 클래스 내부에서만)
        // 아래 코드는 컴파일 에러를 발생시킵니다. 주석 처리하여 에러를 방지합니다.
        // System.out.println(parent.privateField); // 에러!
        // parent.privateMethod(); // 에러!
        System.out.println("Parent.privateField와 privateMethod는 다른 패키지이므로 접근 불가능합니다.");

        System.out.println("\n--- DefaultC 클래스 접근 테스트 (다른 패키지) ---");
        // DefaultC 클래스는 default 접근 제어자이므로 다른 패키지에서는 아예 import도, 객체 생성도 불가능합니다.
        // DefaultC defaultC = new DefaultC(); // 에러!
        System.out.println("DefaultC 클래스는 default 접근 제어자이므로 다른 패키지에서는 접근 불가능합니다.");
    }
}
