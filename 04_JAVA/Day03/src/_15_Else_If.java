// `if-else if-else` 조건문을 사용하여 여러 조건에 따라 다른 코드를 실행하는 예제입니다.
// 조건의 순서가 중요하며, 각 `else if`는 이전 조건이 거짓일 때만 평가됩니다.

import java.util.Scanner;

public class _15_Else_If {
    public static void main(String[] args) {
        // [1] 숫자 비교 예제
        int fav_num = 10; // 좋아하는 숫자

        // 조건 1: fav_num이 10보다 작은가?
        if(fav_num < 10) {
            System.out.println("좋아하는 숫자가 10보다 작군요.");
        } 
        // 조건 2: fav_num이 10보다 큰가? (첫 번째 조건이 거짓일 때만 검사)
        else if(fav_num > 10) {
            System.out.println("좋아하는 숫자가 10보다 크군요.");
        } 
        // 모든 조건이 거짓일 때 (fav_num이 10보다 작지도 않고, 크지도 않을 때 = 10일 때)
        else {
            System.out.println("좋아하는 숫자가 10이군요.");
        }

        System.out.println("
----------------------------------------
");

        // [2] 나이대별 분류 예제
        Scanner sc = new Scanner(System.in);
        System.out.print("나이를 입력하세요 : ");
        int age = sc.nextInt();

        // 조건의 순서가 중요합니다. 더 넓은 범위의 조건을 먼저 검사하면 안 됩니다.
        // 예를 들어, `age > 6`을 `age > 19`보다 먼저 검사하면, 20세도 '어린이'로 분류될 수 있습니다.

        // 조건 1: 나이가 19세 초과인가? (성인)
        if(age > 19) {
            System.out.println("성인입니다.");
        } 
        // 조건 2: 나이가 13세 초과인가? (청소년) - 19세 이면서 13세 초과
        else if(age > 13) {
            System.out.println("청소년입니다.");
        } 
        // 조건 3: 나이가 6세 초과인가? (어린이) - 13세 이면서 6세 초과
        else if(age > 6) {
            System.out.println("어린이입니다.");
        } 
        // 모든 조건이 거짓일 때 (나이가 6세 이하일 때 = 유아)
        else {
            System.out.println("유아입니다.");
        }

        sc.close(); // Scanner 자원 해제
    }
}
