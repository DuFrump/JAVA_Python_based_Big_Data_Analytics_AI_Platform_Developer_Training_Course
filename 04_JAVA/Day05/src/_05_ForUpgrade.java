/**
 * 두프룸프님, 이번에는 우리가 자주 사용하던 for문을 한 단계 업그레이드 시켜볼게요!
 * 바로 '향상된 for문 (Enhanced for loop)' 또는 'for-each문'이라고 불리는 기능입니다.
 *
 * 이 for문은 배열이나 컬렉션(나중에 배울 거예요)에 들어있는 모든 데이터를
 * 처음부터 끝까지 순서대로 하나씩 꺼내서 사용할 때, 코드를 훨씬 짧고 명확하게 만들어줘요.
 *
 * "배열(score)에 있는 모든 요소(item)에 대해서 다음 작업을 반복해줘" 라고
 * 컴퓨터에게 좀 더 쉽게 이야기하는 방식이라고 생각하면 됩니다. 함께 보시죠!
 */
public class _05_ForUpgrade {
    public static void main(String[] args) {

        // [1] 학생들의 점수가 담긴 배열이 있어요.
        int[] score = {90, 92, 93};

        int sum = 0;   // 점수 총합을 저장할 변수. 0으로 시작해야겠죠?
        double avg = 0; // 평균을 저장할 변수.

        // 우리가 원래 사용하던 일반 for문은 이렇게 생겼었죠?
        // 인덱스(i)를 직접 사용해서 배열의 각 요소에 접근했어요.
        /*
        for (int i = 0; i < score.length; i++) {
            sum += score[i]; // sum = sum + score[i];
        }
        */

        // 짜잔! 이게 바로 향상된 for문입니다. 훨씬 간결하죠?
        // for (타입 변수명 : 배열이름)
        // "score 배열에 있는 모든 정수(int)를 순서대로 val이라는 변수에 담아서 반복해줘" 라는 의미예요.
        // 90이 val에 담겨서 sum에 더해지고, 다음엔 92가, 그 다음엔 93이 val에 담겨 더해집니다.
        System.out.println("--- 향상된 for 문으로 총점 계산 ---");
        for(int val : score) {
            sum += val;
        }

        // 평균을 계산할 때는 주의! 총점(sum)과 개수(score.length)가 모두 정수라서
        // 그냥 나누면 소수점 아래가 버려질 수 있어요.
        // (double)sum 처럼 한쪽을 실수(double)로 바꿔주면, 결과도 실수로 정확하게 나온답니다.
        avg = (double) sum / score.length;

        System.out.println("총점: " + sum); // 90 + 92 + 93 = 275
        System.out.println("평균: " + avg); // 275 / 3 = 91.666...

        System.out.println("\n----------------------------------------\n");

        // [2] 문자열 배열에도 당연히 사용할 수 있어요.
        String[] ggurugi = {"똘기", "떵이", "호치", "새촘이"}; // 추억의 꾸러기 수비대!

        System.out.println("--- 향상된 for 문으로 캐릭터 이름 출력 ---");
        // "ggurugi 배열에 있는 모든 문자열(String)을 순서대로 ggu라는 변수에 담아서 반복해줘"
        for(String ggu : ggurugi) {
            System.out.println(ggu);
        }

        /*
        [선생님 TIP]
        향상된 for문은 정말 편리하지만, 만능은 아니에요.
        - 지금 몇 번째 반복인지 인덱스(i) 값이 필요할 때
        - 배열의 값을 읽기만 하는 게 아니라, 값을 변경하고 싶을 때
        이런 경우에는 인덱스를 직접 다룰 수 있는 일반 for문을 사용해야 한답니다!
        상황에 맞게 적절한 도구를 선택하는 것이 좋은 프로그래머의 자질이에요.
        */
    }
}