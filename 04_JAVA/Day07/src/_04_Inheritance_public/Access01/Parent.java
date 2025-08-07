package _04_Inheritance_public.Access01;

// Parent 클래스는 `public` 접근 제어자를 가집니다.
// `protected` 접근 제어자의 동작을 보여주기 위한 부모 클래스입니다.
public class Parent {
    // `protected` 메소드: `protected` 접근 제어자는 동일 패키지 내에서 접근 가능하며,
    // 다른 패키지에서는 이 클래스를 상속받은 자식 클래스에서만 접근 가능합니다.
    protected void accessProtected() {
        System.out.println("Protected 멤버에 접근하였습니다.");
    }
}