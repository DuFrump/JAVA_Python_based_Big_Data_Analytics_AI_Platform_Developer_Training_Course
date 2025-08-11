package _03_TypeChange_calendar;

/**
 * 안녕하세요, 두프룸프님! 이제 `Calendar`와 `DeskCalendar` 클래스를 직접 사용해보면서
 * 우리가 배운 상속, 메소드 오버라이딩, 그리고 다형성 개념이 실제로 어떻게 동작하는지 확인해볼 시간이에요.
 *
 * 이 `Main` 클래스에서는 다음을 중점적으로 살펴볼 겁니다:
 * 1. `Calendar`와 `DeskCalendar` 객체를 직접 생성하여 각자의 메소드를 호출하는 방법
 * 2. 다형성을 활용하여 부모 타입(`Calendar`)의 참조 변수로 자식 객체(`DeskCalendar`)를 참조할 때의 동작 방식
 * 3. 부모 타입으로 참조된 자식 객체의 고유 메소드에 접근하기 위해 '다운캐스팅'을 어떻게 사용하는지
 *
 * 코드를 실행하면서 각 출력 결과를 주의 깊게 살펴보세요. 그럼 시작해볼까요?
 */
public class Main {
    public static void main(String[] args) {
        // [1] `Calendar` 객체와 `DeskCalendar` 객체 직접 생성 및 사용
        // 여기서는 각 클래스의 타입에 맞게 객체를 생성하고 메소드를 호출합니다.
        // 우리가 평소에 객체를 만들고 사용하는 방식과 같아요.
        Calendar c1 = new Calendar("빨간색", 12); // 빨간색 12개월짜리 일반 달력 생성
        DeskCalendar dc1 = new DeskCalendar("검정색", 12); // 검정색 12개월짜리 탁상 달력 생성

        System.out.println("--- DeskCalendar 객체 직접 사용 ---");
        c1.hanging();  // `Calendar` 클래스의 `hanging()` 메소드 호출: "빨간색 달력은 벽에 걸 수 있습니다."
        dc1.info();    // `DeskCalendar`는 `info()`를 오버라이딩하지 않았으므로, 부모인 `Calendar`의 `info()`가 호출됩니다.
                       // 출력: "검정색 달력은 12월까지 있습니다."
        dc1.hanging(); // `DeskCalendar`에서 오버라이딩된 `hanging()` 메소드가 호출됩니다.
                       // 출력: "검정색 달력을 벽에 걸려면 추가 고리 필요."
        dc1.onTheDesk(); // `DeskCalendar` 고유의 `onTheDesk()` 메소드 호출: "검정색 달력은 책상에 세울 수 있습니다."

        System.out.println("\n====================================\n");

        // [2] 다형성(Polymorphism) 예시: 부모 클래스 타입으로 자식 클래스 객체 참조
        // 여기가 바로 다형성의 핵심이죠! `Calendar` 타입의 참조 변수 `c2`가 `DeskCalendar` 객체를 참조합니다.
        // `Calendar c2 = new DeskCalendar("파랑색", 12);`
        // - `c2`는 겉으로는 `Calendar` 타입처럼 보이지만, 실제로는 `DeskCalendar` 객체를 가리키고 있어요.
        // - `c2`를 통해서는 `Calendar` 클래스에 정의된 메소드만 호출할 수 있습니다.
        // - 하지만! 만약 `DeskCalendar`에서 부모의 메소드를 오버라이딩했다면, 실제 객체인 `DeskCalendar`의 오버라이딩된 메소드가 호출됩니다.
        Calendar c2 = new DeskCalendar("파랑색", 12); // 파란색 12개월짜리 탁상 달력을 Calendar 타입으로 참조

        System.out.println("--- 다형성 (Calendar 타입으로 DeskCalendar 객체 참조) ---");
        c2.info();    // `DeskCalendar`는 `info()`를 오버라이딩하지 않았으므로, `Calendar`의 `info()`가 호출됩니다.
                      // 출력: "파랑색 달력은 12월까지 있습니다."
        c2.hanging(); // `DeskCalendar`에서 오버라이딩된 `hanging()` 메소드가 호출됩니다.
                      // 출력: "파랑색 달력을 벽에 걸려면 추가 고리 필요."

        // [중요] 자식 클래스 고유의 메소드에는 부모 타입의 참조 변수로 직접 접근할 수 없습니다.
        // `c2`는 `Calendar` 타입이므로, `Calendar` 클래스에 없는 `onTheDesk()` 메소드를 호출하려고 하면
        // 컴파일러가 해당 메소드를 찾을 수 없다고 오류를 발생시킵니다.
        // 아래 주석을 해제하면 `cannot find symbol` 컴파일 에러가 발생합니다.
        // c2.onTheDesk(); // 에러: Calendar 클래스에는 onTheDesk() 메소드가 없음
        System.out.println("c2.onTheDesk()는 컴파일 에러 발생 (자식 고유 메소드 접근 불가)");

        // [3] 다운캐스팅(Downcasting)을 통한 자식 고유 메소드 접근
        // 부모 타입으로 참조되던 객체를 다시 자식 타입으로 변환하는 것을 '다운캐스팅'이라고 합니다.
        // 다운캐스팅은 런타임 오류(`ClassCastException`)가 발생할 수 있으므로,
        // `instanceof` 연산자로 안전하게 형변환 가능한지 '반드시' 확인한 후 사용해야 합니다.
        if (c2 instanceof DeskCalendar) { // `c2`가 `DeskCalendar`의 인스턴스인지 확인
            DeskCalendar dc2 = (DeskCalendar) c2; // 안전하게 `Calendar` 타입의 `c2`를 `DeskCalendar` 타입으로 다운캐스팅
            System.out.println("--- 다운캐스팅 후 자식 고유 메소드 호출 ---");
            dc2.onTheDesk(); // 이제 `DeskCalendar` 고유의 `onTheDesk()` 메소드를 호출할 수 있어요!
                             // 출력: "파랑색 달력은 책상에 세울 수 있습니다."
        } else {
            System.out.println("c2는 DeskCalendar 타입이 아닙니다. 다운캐스팅 불가.");
        }

        System.out.println("\n두프룸프님, 달력 예제를 통해 상속과 다형성, 그리고 타입 캐스팅이 어떻게 동작하는지 잘 이해하셨기를 바랍니다!");
    }
}

