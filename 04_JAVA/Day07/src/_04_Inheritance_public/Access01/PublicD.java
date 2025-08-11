package _04_Inheritance_public.Access01;

/**
 * PublicD 클래스는 Parent, PublicA, DefaultC 클래스와 같은 패키지(_04_Inheritance_public.Access01)에 있습니다.
 * 이 클래스는 같은 패키지 내에서 다른 클래스들의 멤버에 어떻게 접근할 수 있는지,
 * 특히 'private' 생성자를 가진 클래스의 객체를 어떻게 생성하는지 보여주는 예제입니다.
 *
 * 이 파일을 통해 'public', 'protected', 'default' 접근 제어자의 동작을 다시 한번 확인하고,
 * 'private' 접근 제어자의 엄격함을 이해할 수 있습니다.
 */
public class PublicD {
    public static void main(String[] args) {
        System.out.println("--- 같은 패키지 내 클래스 멤버 접근 테스트 (PublicD) ---");

        // 1. Parent 클래스 멤버 접근 테스트
        System.out.println("\n--- Parent 클래스 멤버 접근 ---");
        Parent parent = new Parent(); // 같은 패키지이므로 Parent 객체 생성 가능

        // public 멤버: 접근 가능
        System.out.println("Parent.publicField: " + parent.publicField);
        parent.publicMethod();

        // protected 멤버: 같은 패키지이므로 접근 가능
        System.out.println("Parent.protectedField: " + parent.protectedField);
        parent.protectedMethod();

        // default 멤버: 같은 패키지이므로 접근 가능
        System.out.println("Parent.defaultField: " + parent.defaultField);
        parent.defaultMethod();

        // private 멤버: 접근 불가능 (컴파일 에러 발생)
        // System.out.println(parent.privateField); // 에러!
        // parent.privateMethod(); // 에러!
        System.out.println("Parent의 private 멤버는 PublicD에서 직접 접근할 수 없습니다.");
        parent.callPrivateMethod(); // public 메소드를 통한 간접 호출은 가능

        // 2. DefaultC 클래스 멤버 접근 테스트
        System.out.println("\n--- DefaultC 클래스 멤버 접근 ---");
        // DefaultC 클래스 자체가 default 접근 제어자이지만, 같은 패키지이므로 객체 생성 가능
        DefaultC defaultC = new DefaultC();
        System.out.println("DefaultC.variableC: " + defaultC.variableC); // public 필드 접근 가능
        defaultC.defaultMethodInDefaultClass(); // default 메소드 접근 가능

        // 3. PublicA 클래스 객체 생성 및 멤버 접근 테스트
        System.out.println("\n--- PublicA 클래스 객체 생성 및 멤버 접근 ---");
        // PublicA 클래스의 생성자는 'private'으로 선언되어 있습니다.
        // 따라서 PublicD 클래스에서는 PublicA의 생성자를 직접 호출하여 객체를 생성할 수 없습니다.
        // 아래 주석을 해제하면 컴파일 에러가 발생합니다.
        // PublicA a = new PublicA(); // 에러: PublicA() has private access in PublicA

        // 하지만 PublicA 클래스 내부에 PublicA 객체를 반환하는 public static 메소드가 있다면,
        // 그 메소드를 통해 객체를 얻을 수 있습니다. (팩토리 메소드 패턴)
        PublicA publicAInstance = PublicA.createPublicAInstance();
        System.out.println("PublicA 객체 생성 (팩토리 메소드 사용): " + publicAInstance);
        System.out.println("PublicA.publicAField: " + publicAInstance.publicAField);
        publicAInstance.testAccessToParent(); // PublicA 내부에서 Parent 접근 테스트 메소드 호출

        System.out.println("\n--- 모든 접근 테스트 완료 ---");
        System.out.println("같은 패키지 내에서는 public, protected, default 멤버에 접근 가능하며,");
        System.out.println("private 멤버는 해당 클래스 내부에서만 접근 가능하다는 것을 확인했습니다.");
    }
}