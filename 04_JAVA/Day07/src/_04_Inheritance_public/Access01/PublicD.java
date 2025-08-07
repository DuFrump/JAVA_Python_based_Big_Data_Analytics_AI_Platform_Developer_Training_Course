package _04_Inheritance_public.Access01;

// PublicD 클래스는 PublicA 클래스의 `private` 생성자에 대한 접근을 테스트하는 예제입니다.
public class PublicD {
    public static void main(String[] args) {
        // PublicA 클래스의 생성자는 `private`으로 선언되어 있습니다.
        // `private` 접근 제어자는 해당 클래스 내에서만 접근 가능하므로,
        // PublicD 클래스에서는 PublicA의 생성자를 직접 호출하여 객체를 생성할 수 없습니다.
        // 아래 주석을 해제하면 컴파일 에러가 발생합니다.
        // PublicA a = new PublicA(10); // 에러: PublicA() has private access in PublicA

        System.out.println("PublicA의 생성자가 private이므로 객체를 생성할 수 없습니다.");
        System.out.println("컴파일 에러를 확인하려면 주석 처리된 코드를 해제하세요.");
    }
}
