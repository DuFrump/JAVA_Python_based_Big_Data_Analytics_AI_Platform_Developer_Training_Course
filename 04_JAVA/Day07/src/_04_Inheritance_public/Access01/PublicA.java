package _04_Inheritance_public.Access01;

// PublicA 클래스는 `public` 접근 제어자를 가집니다.
// `public` 클래스는 어떤 패키지에서도 접근(import)하여 사용할 수 있습니다.
public class PublicA {
    // `public` 필드: `public` 접근 제어자는 모든 곳에서 접근 가능합니다.
    public int a;

    // `private` 생성자: `private` 접근 제어자는 해당 클래스 내에서만 접근 가능합니다.
    // 따라서 이 생성자는 PublicA 클래스 외부에서는 호출할 수 없습니다.
    // 일반적으로 외부에서 객체 생성을 막거나, 특정 팩토리 메소드를 통해서만 생성되도록 할 때 사용합니다.
    private PublicA(int a) {
        this.a = a;
    }

    // `public` 메소드: `public` 접근 제어자는 모든 곳에서 접근 가능합니다.
    public void printA() {
        System.out.println("PublicA 클래스의 printA() 메서드 입니다.");

    }

    // `DefaultC` 클래스의 인스턴스 생성 (동일 패키지 내이므로 접근 가능)
    DefaultC dc = new DefaultC();

    // `default` (package-private) 메소드: 접근 제어자를 명시하지 않으면 `default`가 됩니다.
    // `default` 접근 제어자는 동일 패키지 내에서만 접근 가능합니다.
    void methodA() {
        dc.variableC = 20; // 동일 패키지 내의 DefaultC 클래스 필드에 접근
    }
}
