package _04_Inheritance_public;

// Access01 패키지의 PublicA 클래스를 import 합니다.
// DefaultC 클래스는 default 접근 제어자이므로 다른 패키지에서는 import 할 수 없습니다.
import _04_Inheritance_public.Access01.PublicA;
// import _04_Inheritance_public.Access01.DefaultC; // 에러: DefaultC is not public in _04_Inheritance_public.Access01; cannot be accessed from outside package

public class PublicB {
    public static void main(String[] args) {
        // [1] PublicA 클래스 접근 테스트
        // PublicA 클래스는 public이므로 다른 패키지에서도 import하여 사용할 수 있습니다.
        // 하지만 PublicA의 생성자가 private이므로, 외부에서 직접 객체를 생성할 수 없습니다.
        // 아래 주석을 해제하면 컴파일 에러가 발생합니다.
        // PublicA a = new PublicA(15); // 에러: PublicA() has private access in PublicA
        // a.printA();

        System.out.println("PublicA 클래스는 public이지만, 생성자가 private이라 객체 생성이 불가능합니다.");

        System.out.println("
----------------------------------------
");

        // [2] DefaultC 클래스 접근 테스트
        // DefaultC 클래스는 default 접근 제어자이므로 다른 패키지에서는 접근할 수 없습니다.
        // 따라서 아래 코드는 컴파일 에러를 발생시킵니다.
        // DefaultC c = new DefaultC(); // 에러: DefaultC is not public in _04_Inheritance_public.Access01; cannot be accessed from outside package
        // c.variableC = 300;

        System.out.println("DefaultC 클래스는 default 접근 제어자이므로 다른 패키지에서 접근 불가능합니다.");
        System.out.println("컴파일 에러를 확인하려면 주석 처리된 코드를 해제하세요.");
    }
}
