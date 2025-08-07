// `System.out.printf()`의 다양한 형식 지정자(format specifier) 옵션을 배우는 예제입니다.
// `%[플래그][폭][.정밀도]형식지정자` 의 구조를 가집니다.

public class _12_Out {
    public static void main(String[] args) {
        // %n : 플랫폼(OS)에 맞는 줄바꿈 문자를 출력합니다. (println의 ln과 같은 효과)

        System.out.println("--------------정수---------------");
        System.out.printf("%d%n", 1);                  // %d: 정수(decimal) 기본 출력
        System.out.printf("%d %d %d%n", 1, 2, 3);      // 여러 개 사용
        System.out.printf("%6d%n", 1234);             // [폭] 6칸을 확보하고, 오른쪽 정렬
        System.out.printf("%06d%n", 1234);            // [플래그 0] 6칸 확보, 빈칸은 0으로 채움
        System.out.printf("%6d%n", -1234);            // 부호(-)도 자릿수에 포함됨
        System.out.printf("%+6d%n", 1234);            // [플래그 +] 양수일 때도 부호(+)를 표시
        System.out.printf("%+6d%n", -1234);           // 음수는 원래 부호(-) 표시
        System.out.printf("%,12d%n", 300000000);    // [플래그 ,] 3자리마다 콤마(,) 표시
        System.out.printf("%-6d%n%n", 1234);          // [플래그 -] 왼쪽 정렬


        System.out.println("--------------실수---------------");
        System.out.printf("%f%n", Math.PI);           // %f: 실수(floating-point) 기본 출력 (기본 소수점 6자리)
        System.out.printf("%.2f%n", Math.PI);          // [.정밀도] 소수점 2자리까지 표시 (반올림)
        System.out.printf("%6.2f%n", Math.PI);         // [폭.정밀도] 전체 6칸 확보, 소수점 2자리, 오른쪽 정렬
        System.out.printf("%-6.2f%n", Math.PI);        // [플래그 -] 왼쪽 정렬
        System.out.printf("%06.2f%n", Math.PI);        // [플래그 0] 빈칸을 0으로 채움
        System.out.printf("%+6.2f%n%n", Math.PI);      // [플래그 +] 양수 부호(+) 표시


        System.out.println("--------------문자열---------------");
        System.out.printf("%s%n", "JAVA");             // %s: 문자열(String) 기본 출력
        System.out.printf("%6s%n", "JAVA");           // [폭] 6칸 확보, 오른쪽 정렬
        System.out.printf("%-6s%n", "JAVA");          // [플래그 -] 왼쪽 정렬
        System.out.printf("%6.2s%n", "JAVA");         // [폭.정밀도] 6칸 확보, 문자열은 앞에서 2글자만 잘라서 출력
        System.out.printf("%-6.2s%n%n", "JAVA");       // 왼쪽 정렬 + 2글자만 출력


        System.out.println("--------------응용1: println 사용---------------");
        // println으로 표를 만들면 칸을 맞추기 어렵습니다.
        System.out.println("이름 영어 수학 평균");
        System.out.println("나루토 " + 90 + " " + 80 + " " + 85.0);
        System.out.println("사스케 " + 100 + " " + 100 + " " + 100.0);
        System.out.println("사쿠라 " + 95 + " " + 100 + " " + 97.5);


        System.out.printf("%n%n--------------응용2: printf 사용---------------%n");
        // printf를 사용하면 정렬된 표를 깔끔하게 만들 수 있습니다.
        System.out.printf("%-6s %5s %5s %7s%n", "이름", "영어", "수학", "평균"); // 헤더 출력
        System.out.printf("%-6s %5d %5d %7.1f%n", "나루토", 90, 80, 85.0);
        System.out.printf("%-6s %5d %5d %7.1f%n", "사스케", 100, 100, 100.0);
        System.out.printf("%-6s %5d %5d %7.1f%n", "사쿠라", 95, 100, 97.5);


        System.out.printf("%n--------------참고: 글자 폭--------------%n");
        // 영문, 숫자, 공백은 보통 1칸(반각)을 차지합니다.
        System.out.println("ABCDEFG");
        System.out.println("abcdefg");
        // 한글, 한자 등은 보통 2칸(전각)을 차지합니다. (콘솔 환경에 따라 다를 수 있음)
        System.out.println("가나다라마바사");
        System.out.println("가 나 다 라");

    }
}
