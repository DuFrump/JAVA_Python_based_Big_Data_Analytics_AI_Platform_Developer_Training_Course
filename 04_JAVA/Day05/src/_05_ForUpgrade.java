// 향상된 `for` 문(Enhanced For Loop 또는 For-Each Loop)의 사용법을 배우는 예제입니다.정확한 실수 평균을 얻습니다.
// 향상된 `for` 문은 배열이나 컬렉션의 모든 요소를 순회할 때 코드를 더 간결하고 읽기 쉽게 만들어줍니다.

public class _05_ForUpgrade {
    public static void main(String[] args) {

        // [1] 점수 배열의 총점과 평균 계산
        int[] score = {90, 92, 93}; // 학생들의 점수 배열

        int sum = 0;   // 총점을 저장할 변수
        double avg = 0; // 평균을 저장할 변수

        // 일반 for 문 (주석 처리됨)
        /*
        for (int i = 0; i < score.length; i++) {
            sum += score[i];
        }
        */

        // 향상된 for 문 (For-Each Loop)
        // `for (타입 변수명 : 배열 또는 컬렉션)`
        // 배열의 각 요소를 `val` 변수에 순서대로 할당하면서 반복합니다.
        System.out.println("--- 향상된 for 문으로 총점 계산 ---");
        for(int val : score) {
            sum += val; // `sum = sum + val;` 와 동일
        }

        // 평균 계산 (총점을 배열의 길이로 나눔)
        // `(double)sum`으로 형변환하여 정확한 실수 평균을 얻습니다.
        avg = (double) sum / score.length; // score.length는 3

        System.out.println("총점: " + sum); // 출력: 275
        System.out.println("평균: " + avg); // 출력: 91.666...

        System.out.println("
----------------------------------------
");

        // [2] 문자열 배열의 요소 출력
        String[] ggurugi = {"똘기", "떵이", "호치", "새촘이"}; // 캐릭터 이름 배열

        System.out.println("--- 향상된 for 문으로 캐릭터 이름 출력 ---");
        // String 타입의 배열이므로, `String ggu` 변수를 사용합니다.
        for(String ggu : ggurugi) {
            System.out.println(ggu); // 각 캐릭터 이름을 출력
        }

        // 향상된 for 문은 배열의 모든 요소를 순회할 때 매우 편리하지만,
        // 인덱스 값을 직접 사용해야 하거나, 배열의 요소를 변경해야 할 때는 일반 for 문을 사용해야 합니다.
    }
}
