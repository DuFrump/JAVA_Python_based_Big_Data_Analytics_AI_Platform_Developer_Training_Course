// System.out.printf() 메소드를 사용하여 형식(format)에 맞춰 출력하는 방법을 배우는 예제입니다.
// printf는 'print formatted'의 줄임말입니다.

public class _01_Printf {
    public static void main(String[] args) {
        // %d : 정수(decimal)
        System.out.printf("저는 대학교 %d학년에 재학 중입니다.", 3);
        System.out.println(); // 줄바꿈

        // 여러 개의 형식 지정자 사용하기
        // %d: 정수, %f: 실수(float), %s: 문자열(string)
        System.out.printf("%d은 첫 번째, %f은 두 번째, %s은 세 번째.", 1, 2.0, "셋"); // 오타 수정: "색" -> "셋"
        System.out.println("\n"); // 줄바꿈 2번

        // 출력 공간 확보하기
        // %5d: 5칸의 공간을 확보하고 오른쪽 정렬하여 정수 출력
        System.out.println("---오른쪽 정렬---");
        System.out.printf("%5d\n", 1);
        System.out.printf("%5d\n", 12);
        System.out.printf("%5d\n", 123);
        System.out.printf("%5d\n", 1234);
        System.out.printf("%5d\n", 12345);

        // %-5d: 5칸의 공간을 확보하고 왼쪽 정렬하여 정수 출력
        System.out.println("---왼쪽 정렬---");
        System.out.printf("%-5d\n", 1);
        System.out.printf("%-5d\n", 12);
        System.out.printf("%-5d\n", 123);
        System.out.printf("%-5d\n", 1234);
        System.out.printf("%-5d\n", 12345);
        System.out.println();

        // 소수점 자릿수 지정하기
        // %.1f: 소수점 첫째 자리까지 표시
        System.out.printf("%.1f\n", 1.234567); // 1.2
        // %.2f: 소수점 둘째 자리까지 표시 (셋째 자리에서 반올림)
        System.out.printf("%.2f\n", 1.234567); // 1.23
        // %.3f: 소수점 셋째 자리까지 표시 (넷째 자리에서 반올림)
        System.out.printf("%.3f\n", 1.234567); // 1.235
        System.out.println();

        // 변수를 사용하여 출력하기
        int grade = 3;
        System.out.printf("저는 대학교 %d학년에 재학 중입니다.", grade);
    }
}
