// `for` 반복문의 기본적인 사용법과 다양한 활용 예시를 배우는 예제입니다.
// `for` 문은 특정 코드 블록을 정해진 횟수만큼 반복 실행할 때 사용합니다.

public class _01_For1 {
    public static void main(String[] args) {
        // [1] 기본적인 for 문 구조
        // for (초기화; 조건식; 증감식) {
        //     반복할 코드
        // }
        // - 초기화: 반복문이 시작될 때 한 번만 실행됩니다. (예: int i = 0;)
        // - 조건식: 매 반복마다 평가됩니다. 조건식이 참(true)이면 반복을 계속하고, 거짓(false)이면 반복을 종료합니다.
        // - 증감식: 각 반복이 끝날 때마다 실행됩니다. (예: i++)

        System.out.println("--- 10번 반복 출력 ---");
        for(int i = 0; i <= 9; i++) { // i가 0부터 9까지 (총 10번) 반복
            System.out.println("안녕하세요.");
        }

        System.out.println("
----------------------------------------
");

        // [2] 0부터 9까지의 합계 계산
        int sum = 0;
        System.out.println("--- 0부터 9까지의 합계 ---");
        for (int i = 0; i < 10; i++) {
            sum += i; // sum = sum + i; 와 동일
        }
        System.out.println("합계: " + sum); // 출력: 45

        System.out.println("
----------------------------------------
");

        // [3] 역순으로 반복하기
        System.out.println("--- 5부터 1까지 역순 출력 ---");
        for (int i = 5; i > 0; i--) { // i가 5부터 1까지 (총 5번) 반복
            System.out.println(i);
        }

        System.out.println("
----------------------------------------
");

        // [4] 특정 간격으로 반복하기
        System.out.println("--- 1부터 10까지 홀수만 출력 ---");
        for (int i = 1; i <= 10; i += 2) { // i가 1부터 시작하여 2씩 증가
            System.out.println(i);
        }

        System.out.println("
----------------------------------------
");

        // [5] 1부터 100까지의 합계 계산
        sum = 0; // sum 변수 초기화
        System.out.println("--- 1부터 100까지의 합계 ---");
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("합계: " + sum); // 출력: 5050

        System.out.println("
----------------------------------------
");

        // [6] 1부터 100까지 짝수의 합계 계산
        sum = 0; // sum 변수 초기화
        System.out.println("--- 1부터 100까지 짝수의 합계 ---");
        for (int i = 1; i <= 100; i++) {
            if(i % 2 == 0) { // i가 짝수인지 확인 (2로 나누어 나머지가 0이면 짝수)
                sum += i;
            }
        }
        System.out.println("짝수 합계: " + sum); // 출력: 2550
    }
}
