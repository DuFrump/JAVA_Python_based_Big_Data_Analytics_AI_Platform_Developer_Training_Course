package _03_TypeChange_calendar;

// Main 클래스는 Calendar와 DeskCalendar 클래스를 사용하여 객체를 생성하고
// 상속 및 다형성의 동작을 확인하는 예제입니다.
public class Main {
    public static void main(String[] args) {
        // [1] Calendar 객체와 DeskCalendar 객체 생성
        Calendar c1 = new Calendar("빨간색", 12);
        DeskCalendar dc1 = new DeskCalendar("검정색", 12);

        System.out.println("--- DeskCalendar 객체 직접 사용 ---");
        c1.hanging();  // Calendar 클래스의 hanging() 호출
        dc1.info();    // DeskCalendar는 info()를 오버라이딩하지 않았으므로 Calendar의 info() 호출
        dc1.hanging(); // DeskCalendar에서 오버라이딩된 hanging() 호출
        dc1.onTheDesk(); // DeskCalendar 고유의 onTheDesk() 호출

        System.out.println("
====================================
");

        // [2] 다형성(Polymorphism) 예시: 부모 클래스 타입으로 자식 클래스 객체 참조
        // `Calendar c2 = new DeskCalendar("파랑색", 12);`
        // - c2는 Calendar 타입이지만, 실제 참조하는 객체는 DeskCalendar 타입입니다.
        // - c2를 통해서는 Calendar 클래스에 정의된 멤버만 접근할 수 있습니다.
        // - 하지만 메소드를 호출할 경우, 실제 객체(DeskCalendar)에 오버라이딩된 메소드가 호출됩니다.
        Calendar c2 = new DeskCalendar("파랑색", 12);

        System.out.println("--- 다형성 (Calendar 타입으로 DeskCalendar 객체 참조) ---");
        c2.info();    // DeskCalendar는 info()를 오버라이딩하지 않았으므로 Calendar의 info() 호출
        c2.hanging(); // DeskCalendar에서 오버라이딩된 hanging() 호출

        // [중요] 자식 클래스 고유의 메소드에는 부모 타입의 참조 변수로 접근할 수 없습니다.
        // 아래 주석을 해제하면 컴파일 에러가 발생합니다.
        // c2.onTheDesk(); // 에러: cannot find symbol (Calendar 클래스에는 onTheDesk() 메소드가 없음)
        System.out.println("c2.onTheDesk()는 컴파일 에러 발생 (자식 고유 메소드 접근 불가)");

        // [3] 다운캐스팅(Downcasting)을 통한 자식 고유 메소드 접근
        // `instanceof` 연산자로 안전하게 형변환 가능한지 확인 후 다운캐스팅합니다.
        if (c2 instanceof DeskCalendar) {
            DeskCalendar dc2 = (DeskCalendar) c2; // Calendar 타입의 c2를 DeskCalendar 타입으로 다운캐스팅
            System.out.println("--- 다운캐스팅 후 자식 고유 메소드 호출 ---");
            dc2.onTheDesk(); // 이제 DeskCalendar 고유의 onTheDesk() 호출 가능
        }
    }
}
