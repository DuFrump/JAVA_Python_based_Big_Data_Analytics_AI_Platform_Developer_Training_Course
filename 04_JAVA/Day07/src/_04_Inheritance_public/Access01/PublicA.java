package _04_Inheritance_public.Access01;

/**
 * PublicA 클래스는 Parent 클래스와 같은 패키지(_04_Inheritance_public.Access01)에 있습니다.
 * 같은 패키지 내에서 Parent 클래스의 멤버(필드와 메소드)에 어떻게 접근할 수 있는지 보여주는 예제입니다.
 *
 * 여기서 우리는 'public', 'protected', 'default' 접근 제어자가
 * 같은 패키지 내에서 어떻게 동작하는지 명확하게 확인할 수 있습니다.
 */
public class PublicA { // public 클래스: 어디서든 접근 가능

    // PublicA 클래스 자체의 필드와 메소드도 정의할 수 있습니다.
    public int publicAField = 10;

    // private 생성자: 이 클래스 외부에서는 PublicA 객체를 직접 생성할 수 없습니다.
    // 보통 특정 패턴(싱글톤 등)을 강제하거나, 팩토리 메소드를 통해 객체를 생성하도록 할 때 사용합니다.
    private PublicA() {
        // 이 생성자는 PublicA 클래스 내부에서만 호출될 수 있습니다.
    }

    // PublicA 객체를 생성하여 반환하는 public static 메소드 (팩토리 메소드 패턴의 간단한 예시)
    public static PublicA createPublicAInstance() {
        return new PublicA(); // private 생성자를 클래스 내부에서 호출
    }

    public void testAccessToParent() {
        System.out.println("\n--- PublicA에서 Parent 멤버 접근 테스트 (같은 패키지) ---");
        Parent parent = new Parent(); // 같은 패키지이므로 Parent 객체 생성 가능

        // 1. public 멤버 접근: 어디서든 접근 가능
        System.out.println("Parent.publicField: " + parent.publicField);
        parent.publicMethod();

        // 2. protected 멤버 접근: 같은 패키지 내에서는 접근 가능
        System.out.println("Parent.protectedField: " + parent.protectedField);
        parent.protectedMethod();

        // 3. default (package-private) 멤버 접근: 같은 패키지 내에서는 접근 가능
        System.out.println("Parent.defaultField: " + parent.defaultField);
        parent.defaultMethod();

        // 4. private 멤버 접근: 같은 클래스 내에서만 접근 가능 (Parent 클래스 내부에서만)
        // 아래 코드는 컴파일 에러를 발생시킵니다. 주석 처리하여 에러를 방지합니다.
        // System.out.println("Parent.privateField: " + parent.privateField); // 에러!
        // parent.privateMethod(); // 에러!
        System.out.println("Parent.privateField와 privateMethod는 같은 패키지라도 직접 접근 불가능합니다.");
        System.out.println("private 멤버는 해당 클래스 내부에서만 접근할 수 있습니다.");

        // Parent 클래스 내의 public 메소드를 통해 private 메소드를 간접적으로 호출하는 것은 가능합니다.
        parent.callPrivateMethod();
    }
}