// 안녕하세요, 두프룸프님!
// 이 파일은 `switch` 문을 좀 더 심화해서 배우는 예제입니다.
// 특히 여러 `case`를 묶어서 처리하는 방법과, 동일한 로직을 `if-else if-else` 문으로 어떻게 구현할 수 있는지 비교해볼 거예요.

import java.util.Scanner; // 사용자 입력을 위한 Scanner 클래스를 불러옵니다.

public class _18_Switch2 { // 클래스 선언
    public static void main(String[] args) { // main 메서드: 프로그램 시작점

        // 장학금 지급 기준 시나리오를 가정해봅시다.
        // 1등: 100만원
        // 2등, 3등: 50만원
        // 그 외: 없음

        Scanner sc = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성

        System.out.print("당신의 등수를 입력하세요 : ");
        int ranking = sc.nextInt(); // 사용자로부터 등수를 정수 형태로 입력받습니다.

        System.out.println("\n--- switch 문으로 구현 ---");
        // `switch` 문을 사용하여 등수에 따라 다른 장학금 메시지를 출력합니다.
        // ★ 중요: Java 12부터는 `case`에 여러 값을 콤마(,)로 구분하여 지정할 수 있습니다.
        // 이전 버전에서는 `case 2: case 3:` 처럼 `break` 없이 연속으로 써야 했습니다.
        switch(ranking) {
            case 1: // ranking이 1일 경우
                System.out.println("장학금 100만원.");
                break; // 해당 case 실행 후 switch 문을 빠져나갑니다.
            case 2, 3: // ranking이 2 또는 3일 경우 (Java 12+ 문법)
                System.out.println("장학금 50만원.");
                break;
            default: // 위에 나열된 어떤 case에도 해당하지 않을 경우 (1, 2, 3등이 아닐 경우)
                System.out.println("아쉽지만 장학금은 제공되지 않습니다.");
                // default는 보통 마지막에 오므로 break를 생략해도 되지만, 명시적으로 붙여도 상관없습니다.
        }

        System.out.println("\n--- if-else if-else 문으로 구현 ---");
        // 동일한 장학금 지급 로직을 `if-else if-else` 문으로도 구현할 수 있습니다.
        // `switch` 문이 특정 값에 대한 분기에 유리하다면,
        // `if-else if-else`는 범위 조건이나 복합적인 조건에 더 유연하게 사용될 수 있습니다.
        if(ranking == 1) { // 만약 등수가 1이라면...
            System.out.println("장학금 100만원.");
        } 
        // 만약 등수가 1이 아니고, 등수가 2이거나 3이라면...
        // `||` (OR) 연산자를 사용하여 두 조건을 묶습니다.
        else if(ranking == 2 || ranking == 3) {
            System.out.println("장학금 50만원.");
        } 
        // 위의 어떤 조건에도 해당하지 않는다면...
        else {
            System.out.println("아쉽지만 장학금은 제공되지 않습니다.");
        }

        sc.close(); // Scanner 자원 해제

        // 이 예제를 통해 `switch` 문과 `if-else if-else` 문이 어떻게 유사한 로직을 다르게 표현하는지,
        // 그리고 각 문법의 장단점을 이해하셨기를 바랍니다.
        // 상황에 따라 더 적절하고 가독성 좋은 문법을 선택하는 것이 중요해요!
    }
}
