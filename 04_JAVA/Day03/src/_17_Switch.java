// 안녕하세요, 두프룸프님!
// 이 파일은 자바의 또 다른 조건문인 `switch` 문에 대해 배우는 예제입니다.
// `switch` 문은 하나의 변수(또는 표현식)의 값에 따라 여러 가지 경우 중 하나를 선택하여 실행할 때 사용해요.
// `if-else if-else`와 비슷하지만, 특정 상황에서 더 간결하고 가독성 좋게 코드를 작성할 수 있게 해줍니다.

import java.util.Scanner; // 사용자 입력을 위한 Scanner 클래스를 불러옵니다.

public class _17_Switch { // 클래스 선언
    public static void main(String[] args) { // main 메서드: 프로그램 시작점

        // [1] 기본적인 switch 문
        // `switch (변수 또는 표현식) { case 값1: ... break; case 값2: ... break; default: ... }` 구조입니다.
        // - `switch` 괄호 안의 값과 일치하는 `case` 블록이 실행됩니다.
        // - `break` 문을 만나면 `switch` 문을 완전히 빠져나갑니다.
        // - `default`는 어떤 `case`에도 해당하지 않을 때 실행되는 블록입니다. (선택 사항)

        int num = 1; // 정수형 변수 num에 1 할당

        System.out.println("--- switch 예제 1 ---");
        switch(num) { // num 변수의 값을 기준으로 어떤 case를 실행할지 결정합니다.
            case 1: // num의 값이 1일 경우 이 블록이 실행됩니다.
                System.out.println("숫자는 1입니다.");
                break; // `break`를 만나면 switch 문을 종료하고 다음 코드로 넘어갑니다.
            case 7: // num의 값이 7일 경우 이 블록이 실행됩니다.
                System.out.println("숫자는 7입니다.");
                break;
            default: // num의 값이 1도 7도 아닐 경우 이 블록이 실행됩니다.
                System.out.println("1도 7도 아닙니다.");
                // `default`는 보통 switch 문의 마지막에 위치하므로 `break`를 생략해도 되지만,
                // 만약 `default`가 중간에 있다면 `break`를 꼭 붙여야 합니다.
        }

        System.out.println("\n----------------------------------------\n"); // 구분선

        // [2] 사용자 입력을 받는 switch 문
        Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성

        System.out.print("1 ~ 5 사이의 숫자를 입력하세요 : ");
        int num1 = sc.nextInt(); // 사용자로부터 정수 값을 입력받습니다.

        System.out.println("--- switch 예제 2 ---");
        switch(num1) {
            case 1:
                System.out.println("숫자는 1입니다.");
                break;
            case 2:
                System.out.println("숫자는 2입니다.");
                break;
            case 3:
                System.out.println("숫자는 3입니다.");
                break;
            case 4:
                System.out.println("숫자는 4입니다.");
                break;
            case 5:
                System.out.println("숫자는 5입니다.");
                break;
            default:
                System.out.println("1 ~ 5 사이의 숫자가 아닙니다.");
        }

        sc.close(); // Scanner 자원 해제

        // [중요] break 문이 없을 경우 (Fall-through, 폴스루 현상)
        // `switch` 문에서 `break` 문을 사용하지 않으면, 해당 `case`가 실행된 후
        // 다음 `case`의 코드까지 이어서 계속 실행됩니다. 이를 'fall-through'라고 합니다.
        // 의도적으로 사용할 수도 있지만, 대부분의 경우 논리적인 버그의 원인이 되므로 주의해야 합니다!
        System.out.println("\n--- break 없는 switch (Fall-through) ---");
        int day = 3; // 요일을 나타내는 숫자 (1:월, 2:화, 3:수...)
        switch (day) {
            case 1:
                System.out.println("월요일");
            case 2:
                System.out.println("화요일");
            case 3:
                System.out.println("수요일"); // day가 3이므로 여기서부터 실행됩니다.
            case 4:
                System.out.println("목요일"); // break가 없으므로 '수요일' 출력 후 이어서 '목요일'도 실행됩니다.
            default:
                System.out.println("주말"); // break가 없으므로 이어서 '주말'도 실행됩니다.
        }
        // 예상 출력:
        // 수요일
        // 목요일
        // 주말
        // 이처럼 `break`가 없으면 의도치 않은 결과가 나올 수 있으니 항상 주의해야 합니다!
    }
}
