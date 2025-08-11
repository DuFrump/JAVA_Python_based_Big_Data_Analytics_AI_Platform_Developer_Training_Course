package _04_Inheritance_public; // 이 패키지는 Access01, Access02와 다릅니다.

// Parent 클래스는 Access01 패키지에 있으므로 import 해야 합니다.
import _04_Inheritance_public.Access01.Parent;
// PublicA 클래스도 Access01 패키지에 있으므로 import 합니다.
import _04_Inheritance_public.Access01.PublicA;
// DefaultC 클래스는 default 접근 제어자이므로 다른 패키지에서는 import 할 수 없습니다.
// import _04_Inheritance_public.Access01.DefaultC; // 에러 발생!

/**
 * PublicB 클래스는 Parent, PublicA, DefaultC 클래스와 '다른 패키지'에 있습니다.
 * 이 클래스는 상속 관계가 없는 완전히 독립적인 클래스에서
 * 다른 패키지에 있는 클래스들의 멤버에 어떻게 접근할 수 있는지 보여주는 최종 예제입니다.
 *
 * 이 파일을 통해 'public', 'protected', 'default', 'private' 접근 제어자의
 * 모든 규칙을 종합적으로 정리하고 이해할 수 있습니다.
 */
public class PublicB {
    public static void main(String[] args) {
        System.out.println("--- 다른 패키지 내 클래스 멤버 접근 테스트 (PublicB) ---");

        // 1. Parent 클래스 멤버 접근 테스트
        System.out.println("\n--- Parent 클래스 멤버 접근 ---");
        // Parent 클래스 자체는 public이므로 다른 패키지에서도 객체 생성은 가능합니다.
        Parent parent = new Parent();

        // public 멤버: 어디서든 접근 가능
        System.out.println("Parent.publicField: " + parent.publicField);
        parent.publicMethod();

        // protected 멤버: 다른 패키지에서 상속 관계가 아니면 접근 불가능
        // Child 클래스에서는 상속 관계였기 때문에 접근 가능했지만, 여기서는 상속 관계가 아닙니다.
        // 아래 코드는 컴파일 에러를 발생시킵니다. 주석 처리하여 에러를 방지합니다.
        // System.out.println(parent.protectedField); // 에러!
        // parent.protectedMethod(); // 에러!
        System.out.println("Parent.protectedField와 protectedMethod는 다른 패키지에서 상속 관계가 아니므로 접근 불가능합니다.");

        // default (package-private) 멤버: 다른 패키지에서는 접근 불가능
        // 아래 코드는 컴파일 에러를 발생시킵니다. 주석 처리하여 에러를 방지합니다.
        // System.out.println(parent.defaultField); // 에러!
        // parent.defaultMethod(); // 에러!
        System.out.println("Parent.defaultField와 defaultMethod는 다른 패키지이므로 접근 불가능합니다.");

        // private 멤버: 해당 클래스 내에서만 접근 가능 (Parent 클래스 내부에서만)
        // 아래 코드는 컴파일 에러를 발생시킵니다. 주석 처리하여 에러를 방지합니다.
        // System.out.println(parent.privateField); // 에러!
        // parent.privateMethod(); // 에러!
        System.out.println("Parent.privateField와 privateMethod는 다른 패키지이므로 접근 불가능합니다.");

        // 2. DefaultC 클래스 접근 테스트
        System.out.println("\n--- DefaultC 클래스 접근 ---");
        // DefaultC 클래스는 default 접근 제어자이므로 다른 패키지에서는 아예 import도, 객체 생성도 불가능합니다.
        // DefaultC defaultC = new DefaultC(); // 에러!
        System.out.println("DefaultC 클래스는 default 접근 제어자이므로 다른 패키지에서는 접근 불가능합니다.");

        // 3. PublicA 클래스 객체 생성 및 멤버 접근 테스트
        System.out.println("\n--- PublicA 클래스 객체 생성 및 멤버 접근 ---");
        // PublicA 클래스는 public이지만, 생성자가 private이므로 직접 객체 생성이 불가능합니다.
        // PublicA a = new PublicA(); // 에러!

        // PublicA 클래스 내부에 PublicA 객체를 반환하는 public static 메소드가 있다면,
        // 그 메소드를 통해 객체를 얻을 수 있습니다.
        PublicA publicAInstance = PublicA.createPublicAInstance();
        System.out.println("PublicA 객체 생성 (팩토리 메소드 사용): " + publicAInstance);
        System.out.println("PublicA.publicAField: " + publicAInstance.publicAField);
        // PublicA의 testAccessToParent() 메소드는 PublicA 내부에서 Parent 멤버에 접근하는 것을 보여줍니다.
        // 이 메소드 자체는 public이므로 호출 가능합니다.
        publicAInstance.testAccessToParent();

        System.out.println("\n--- 모든 접근 테스트 완료 ---");
        System.out.println("다른 패키지에서는 public 멤버만 직접 접근 가능하며,");
        System.out.println("protected, default, private 멤버는 접근 불가능하다는 것을 확인했습니다.");
        System.out.println("특히 protected는 상속 관계에서만 다른 패키지 접근을 허용합니다.");
    }
}