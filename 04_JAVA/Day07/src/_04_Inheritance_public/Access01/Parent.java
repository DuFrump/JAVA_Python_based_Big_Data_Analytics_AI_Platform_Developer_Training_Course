package _04_Inheritance_public.Access01;

/**
 * 네 번째 예제에 오신 것을 환영합니다!
 * 이번에는 '접근 제어자(Access Modifier)'에 대해 배워볼 거예요.
 * 접근 제어자는 클래스, 필드(변수), 메소드에 붙어서
 * '누가 이 요소에 접근할 수 있는지'를 결정하는 역할을 합니다.
 * 마치 건물의 문에 '관계자 외 출입 금지', '직원 전용', '누구나 환영' 같은 팻말을 붙이는 것과 같아요.
 *
 * 자바에는 네 가지 접근 제어자가 있습니다:
 * 1. public: 누구나 접근 가능 (가장 개방적)
 * 2. protected: 같은 패키지 + 다른 패키지의 자식 클래스만 접근 가능
 * 3. default (아무것도 안 붙인 경우): 같은 패키지 내에서만 접근 가능
 * 4. private: 해당 클래스 내에서만 접근 가능 (가장 폐쇄적)
 *
 * 이 Parent 클래스는 이 네 가지 접근 제어자를 모두 사용하여
 * 각 제어자가 어떻게 동작하는지 보여주는 '부모 클래스' 역할을 할 겁니다.
 */
public class Parent { // public 클래스: 어디서든 이 클래스를 사용할 수 있습니다.

    // === 필드 (Fields) ===
    public String publicField = "public 필드: 어디서든 접근 가능";
    protected String protectedField = "protected 필드: 같은 패키지 또는 다른 패키지의 자식 클래스에서 접근 가능";
    String defaultField = "default 필드: 같은 패키지 내에서만 접근 가능"; // 아무것도 안 붙이면 default
    private String privateField = "private 필드: 이 클래스(Parent) 내에서만 접근 가능";

    // === 메소드 (Methods) ===
    public void publicMethod() {
        System.out.println("public 메소드: 어디서든 호출 가능");
    }

    protected void protectedMethod() {
        System.out.println("protected 메소드: 같은 패키지 또는 다른 패키지의 자식 클래스에서 호출 가능");
    }

    void defaultMethod() { // 아무것도 안 붙이면 default
        System.out.println("default 메소드: 같은 패키지 내에서만 호출 가능");
    }

    private void privateMethod() {
        System.out.println("private 메소드: 이 클래스(Parent) 내에서만 호출 가능");
        // private 필드는 같은 클래스 내에서만 접근 가능하므로, 여기서 privateField를 사용할 수 있습니다.
        System.out.println("private 필드 값: " + privateField);
    }

    // private 메소드는 외부에서 직접 호출할 수 없으므로,
    // 같은 클래스 내의 다른 public 메소드를 통해 간접적으로 호출하는 예시를 보여줍니다.
    public void callPrivateMethod() {
        System.out.println("public 메소드에서 private 메소드 호출:");
        privateMethod(); // 같은 클래스 내에서는 private 메소드 호출 가능
    }
}
