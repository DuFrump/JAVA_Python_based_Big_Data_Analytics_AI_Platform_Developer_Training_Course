// `switch` 문에서 `break`를 의도적으로 생략하여 `fall-through`를 활용하는 예제입니다.
// 이 패턴은 특정 상황에서 유용하지만, 코드의 흐름을 명확히 이해해야 합니다.

public class _19_Switch3 {
    public static void main(String[] args) {
        // 장학금 계산 시나리오:
        // 기본 장학금: 40만원
        // 3등급: 기본 장학금 + 10만원 (총 50만원)
        // 2등급: 3등급 장학금 + 10만원 (총 60만원)
        // 1등급: 2등급 장학금 + 10만원 (총 70만원)

        int grade = 4; // 학생의 등급 (1, 2, 3, 그 외)
        int scholarship = 400000; // 기본 장학금 40만원

        System.out.printf("초기 장학금: %d원, 등급: %d%n", scholarship, grade);

        // switch 문에서 break를 의도적으로 생략하여 등급에 따라 추가 장학금을 누적합니다.
        switch(grade) {
            case 1: // 등급이 1일 경우: 아래 모든 case의 코드가 실행됩니다.
                System.out.println("1등급 추가 장학금 10만원");
                scholarship += 100000; // scholarship = 40만 + 10만 = 50만 (만약 grade가 1이라면)
            case 2: // 등급이 2일 경우: case 1은 건너뛰고 여기서부터 아래 코드가 실행됩니다.
                System.out.println("2등급 추가 장학금 10만원");
                scholarship += 100000; // scholarship = (이전 값) + 10만 = 60만 (만약 grade가 2라면)
            case 3: // 등급이 3일 경우: case 1, 2는 건너뛰고 여기서부터 아래 코드가 실행됩니다.
                System.out.println("3등급 추가 장학금 10만원");
                scholarship += 100000; // scholarship = (이전 값) + 10만 = 50만 (만약 grade가 3이라면)
            default: // 위에 나열된 어떤 case에도 해당하지 않을 경우 (예: grade가 4일 경우)
                // default에는 break를 명시적으로 넣어주는 것이 좋습니다.
                // 특히 default가 마지막이 아닐 경우 fall-through를 막기 위해 필수입니다.
                System.out.println("기본 장학금만 적용됩니다.");
                break;
        }

        System.out.printf("최종 장학금은 %d원입니다.\n", scholarship);

        // 예시 결과:
        // grade = 1 -> scholarship = 40만 + 10만 + 10만 + 10만 = 70만
        // grade = 2 -> scholarship = 40만 + 10만 + 10만 = 60만
        // grade = 3 -> scholarship = 40만 + 10만 = 50만
        // grade = 4 -> scholarship = 40만
    }
}
