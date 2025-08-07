// `while` 반복문의 기본적인 사용법을 배우는 예제입니다.
// `while` 문은 조건식이 참(true)인 동안 코드 블록을 반복 실행합니다.
public class _04_While1 {
    public static void main(String[] args) {
        // [1] 1부터 10까지의 합계 계산 예제
        int sum = 0; // 합계를 저장할 변수
        int i = 1;   // 반복을 위한 카운터 변수 (초기화)

        // while (조건식) {
        //     반복할 코드
        //     증감식 (조건을 변경하여 반복을 종료시킬 수 있도록)
        // }
        // 조건식 (i <= 10)이 참인 동안 반복됩니다.
        while (i <= 10) {
            System.out.println("식사는 하셨습니까?"); // 매 반복마다 출력
            sum += i; // sum = sum + i; 와 동일
            i++;      // i = i + 1; 와 동일 (증감식: i를 1씩 증가시켜 언젠가 조건이 거짓이 되도록 함)
        }
        System.out.println("1부터 10까지의 합계: " + sum); // 출력: 55

        System.out.println("----------------------------------------");

        // [2] `for` 문과 `while` 문의 비교
        // `for` 문은 반복 횟수가 명확할 때 주로 사용하고,
        // `while` 문은 조건이 만족하는 동안 반복해야 할 때 (반복 횟수가 불명확할 때) 주로 사용합니다.
        // 하지만 서로 대체하여 사용할 수 있습니다.

        // `for` 문으로 1부터 10까지 합계 계산
        int sumFor = 0;
        for (int j = 1; j <= 10; j++) {
            sumFor += j;
        }
        System.out.println("for 문으로 계산한 합계: " + sumFor);
    }
}

