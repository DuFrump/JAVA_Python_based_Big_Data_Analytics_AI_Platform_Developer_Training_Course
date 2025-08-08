package _14_Lambda;

/**
 * Java 선생님:
 * 두프룸프님, 드디어 람다 표현식을 직접 사용해볼 시간입니다!
 * 람다는 "이름 없는 함수"라고 했죠? 굳이 클래스를 만들고 메서드에 이름을 붙이는 번거로운 과정 없이,
 * 필요한 기능을 즉석에서 만들어서 변수에 할당하거나 파라미터로 넘겨줄 수 있는 아주 강력한 도구입니다.
 */
public class LambdaEX {
    public static void main(String[] args) {

        // --- 예제 1: 파라미터가 하나인 경우 ---
        System.out.println("--- 예제 1: 파라미터 1개, 반환값 없음 ---");

        // [람다 이전] 익명 클래스를 사용한 방식
        // MyPrinter 인터페이스를 구현하기 위해, 이름 없는 클래스를 즉석에서 만들고, print 메서드를 오버라이드해야 했어요.
        // "이 기능을 딱 한 번만 쓸 건데, 너무 거추장스럽지 않나요?"
        MyPrinter printer_old = new MyPrinter() {
            @Override
            public void print(String message) {
                System.out.println("옛날 방식 출력: " + message);
            }
        };
        printer_old.print("너무 길다!");

        // [람다 도입] 람다 표현식을 사용한 방식
        // "어차피 MyPrinter는 print(String message) 메서드 하나뿐이잖아?"
        // "컴파일러는 우리가 그 메서드를 구현하려는 걸 이미 알고 있어!"
        // 그래서, 굳이 메서드 이름(print)이나 클래스 이름을 쓸 필요 없이, 핵심 로직만 남기는 거예요.
        // (message) -> { System.out.println("출력 : " + message); }
        MyPrinter printer_lambda = (message) -> System.out.println("람다 방식 출력: " + message);

        // 심지어, 파라미터가 하나일 때는 괄호()도 생략할 수 있습니다.
        MyPrinter printer_lambda_simple = message -> System.out.println("람다 방식 (더 간결하게) 출력: " + message);

        printer_lambda.print("정말 간결하다!");
        printer_lambda_simple.print("이게 바로 람다!");


        // --- 예제 2: 파라미터가 없는 경우 ---
        System.out.println("\n--- 예제 2: 파라미터 없음, 반환값 없음 ---");
        // MyRunnable 인터페이스의 run() 메서드는 파라미터가 없습니다.
        // 이럴 땐 비어있는 괄호 ()를 꼭 써줘야 합니다.
        MyRunnable r = () -> System.out.println("새로운 스레드가 실행 중입니다!");
        r.run();


        // --- 예제 3: 파라미터가 여러 개인 경우 ---
        System.out.println("\n--- 예제 3: 파라미터 2개, 반환값 있음 ---");
        // Calculator 인터페이스의 compute(a, b) 메서드는 파라미터가 두 개입니다.
        // 이럴 땐 괄호()를 생략할 수 없어요.
        // 실행문이 한 줄이고, 그 결과가 바로 반환값일 때는 return 키워드와 중괄호{}를 생략할 수 있습니다.
        Calculator add = (a, b) -> a + b; // 원래는 { return a + b; } 입니다.
        Calculator subtract = (a, b) -> a - b;
        System.out.println("10 + 5 = " + add.compute(10, 5));
        System.out.println("10 - 5 = " + subtract.compute(10, 5));


        // --- 예제 4: 파라미터 1개, 반환값 있는 경우 ---
        System.out.println("\n--- 예제 4: 파라미터 1개, 반환값 있음 ---");
        // StringLength 인터페이스의 getLength(s)는 문자열을 받아 길이를 반환합니다.
        StringLength lf = s -> s.length(); // 파라미터가 하나라 괄호 생략, 실행문이 한 줄이라 return 생략!
        System.out.println("'Hello, Lambda!'의 길이는? " + lf.getLength("Hello, Lambda!"));


        // --- 예제 5: boolean을 반환하는 경우 (Predicate) ---
        System.out.println("\n--- 예제 5: 짝수인지 판별하기 ---");
        // Condition 인터페이스의 test(n)는 숫자를 받아 짝수인지 아닌지(true/false)를 반환합니다.
        // 이처럼, 무언가를 받아서 true/false를 반환하는 함수를 'Predicate'라고 부르며, 스트림에서 매우 중요하게 사용됩니다.
        Condition isEven = n -> n % 2 == 0;
        System.out.println("10은 짝수인가요? " + isEven.test(10));
        System.out.println("7은 짝수인가요? " + isEven.test(7));
    }
}