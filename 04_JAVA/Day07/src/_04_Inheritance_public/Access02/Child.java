package _04_Inheritance_public.Access02;

// 다른 패키지에 있는 Parent 클래스를 사용하기 위해 import 합니다.
// import 문이 없으면 컴파일 에러가 발생합니다.
import _04_Inheritance_public.Access01.Parent;

/**
 * Child 클래스는 Parent 클래스와 다른 패키지(_04_Inheritance_public.Access02)에 있습니다.
 * 이 클래스는 Parent 클래스를 '상속'받는 '자식 클래스'입니다.
 *
 * 이 예제를 통해 'protected' 접근 제어자가 다른 패키지에 있는 자식 클래스에서
 * 어떻게 접근 가능한지, 그리고 'default' 접근 제어자는 왜 접근 불가능한지 명확하게 보여줄 거예요.
 */
public class Child extends Parent { // Parent를 상속받습니다.

    public void testAccessToParentMembers() {
        System.out.println("\n--- Child에서 Parent 멤버 접근 테스트 (다른 패키지, 상속 관계) ---");

        // 1. public 멤버 접근: 어디서든 접근 가능
        System.out.println("Parent.publicField (상속): " + publicField); // 직접 접근 가능
        publicMethod(); // 직접 호출 가능

        // 2. protected 멤버 접근: 다른 패키지라도 자식 클래스에서는 접근 가능
        // protected 멤버는 자식 클래스 내부에서 '상속받은 것처럼' 직접 접근할 수 있습니다.
        System.out.println("Parent.protectedField (상속): " + protectedField); // 직접 접근 가능
        protectedMethod(); // 직접 호출 가능

        // super 키워드를 통해서도 부모의 protected 메소드를 호출할 수 있습니다.
        super.protectedMethod();

        // 3. default (package-private) 멤버 접근: 다른 패키지에서는 접근 불가능
        // 아래 코드는 컴파일 에러를 발생시킵니다. 주석 처리하여 에러를 방지합니다.
        // System.out.println(defaultField); // 에러!
        // defaultMethod(); // 에러!
        System.out.println("Parent.defaultField와 defaultMethod는 다른 패키지이므로 접근 불가능합니다.");

        // 4. private 멤버 접근: 해당 클래스 내에서만 접근 가능 (Parent 클래스 내부에서만)
        // 아래 코드는 컴파일 에러를 발생시킵니다. 주석 처리하여 에러를 방지합니다.
        // System.out.println(privateField); // 에러!
        // privateMethod(); // 에러!
        System.out.println("Parent.privateField와 privateMethod는 다른 패키지이므로 접근 불가능합니다.");

        // 중요: 다른 패키지에 있는 부모 클래스의 객체를 직접 생성하여 protected 멤버에 접근하는 것은 불가능합니다.
        // protected는 '상속 관계'에서만 다른 패키지 접근을 허용합니다.
        // Parent p = new Parent(); // Parent 클래스 자체는 public이라 객체 생성은 가능하지만,
        // p.protectedField; // 에러!
        // p.protectedMethod(); // 에러!
        System.out.println("\n참고: 다른 패키지에서 Parent 객체를 생성하여 protected 멤버에 직접 접근하는 것은 불가능합니다.");
        System.out.println("protected는 상속 관계에서만 다른 패키지 접근을 허용합니다.");
    }
}