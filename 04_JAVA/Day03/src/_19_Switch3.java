// 안녕하세요, 두프룸프님!
// 이 파일은 `switch` 문에서 `break` 키워드를 '의도적으로 생략'하여
// `fall-through` (폴스루) 현상을 활용하는 예제입니다.
// 이 방법은 특정 상황에서 코드를 더 간결하게 만들 수 있지만,
// 코드의 흐름을 정확히 이해하고 사용해야 합니다. 잘못 사용하면 버그의 원인이 될 수 있어요!

public class _19_Switch3 { // 클래스 선언
    public static void main(String[] args) { // main 메서드: 프로그램 시작점

        // 장학금 계산 시나리오를 가정해봅시다.
        // 기본 장학금: 40만원
        // 3등급: 기본 장학금 + 10만원 (총 50만원)
        // 2등급: 3등급 장학금 + 10만원 (총 60만원)
        // 1등급: 2등급 장학금 + 10만원 (총 70만원)
        // 즉, 등급이 높을수록 이전 등급의 장학금에 추가 장학금이 더해지는 구조입니다.

        int grade = 4; // 학생의 등급 (1, 2, 3, 그 외 등급)
        int scholarship = 400000; // 기본 장학금 40만원으로 시작

        System.out.printf("초기 장학금: %d원, 등급: %d%n", scholarship, grade);

        // `switch` 문에서 `break`를 의도적으로 생략하여 등급에 따라 추가 장학금을 누적합니다.
        // `fall-through` 현상: `break`가 없으면 해당 `case`가 실행된 후 다음 `case`로 계속 실행됩니다.
        switch(grade) {
            case 1: // 만약 등급이 1이라면:
                // 1등급은 2등급, 3등급의 추가 장학금까지 모두 받습니다.
                System.out.println("1등급 추가 장학금 10만원");
                scholarship += 100000; // 현재 scholarship에 10만원 추가
                // break가 없으므로 다음 case 2로 실행 흐름이 넘어갑니다.
            case 2: // 만약 등급이 2라면 (또는 등급이 1이어서 fall-through 된 경우):
                // 2등급은 3등급의 추가 장학금까지 받습니다.
                System.out.println("2등급 추가 장학금 10만원");
                scholarship += 100000; // 현재 scholarship에 10만원 추가
                // break가 없으므로 다음 case 3으로 실행 흐름이 넘어갑니다.
            case 3: // 만약 등급이 3이라면 (또는 등급이 1, 2이어서 fall-through 된 경우):
                // 3등급은 자신의 추가 장학금만 받습니다.
                System.out.println("3등급 추가 장학금 10만원");
                scholarship += 100000; // 현재 scholarship에 10만원 추가
                // break가 없으므로 다음 default로 실행 흐름이 넘어갑니다.
            default: // 위에 나열된 어떤 case에도 해당하지 않을 경우 (예: 등급이 4일 경우)
                // 또는 1, 2, 3등급이어서 fall-through 된 경우 마지막으로 실행됩니다.
                System.out.println("기본 장학금만 적용됩니다.");
                // `default`에는 `break`를 명시적으로 넣어주는 것이 좋습니다.
                // 특히 `default`가 `switch` 문의 마지막이 아닐 경우 `fall-through`를 막기 위해 필수입니다.
                break; // switch 문을 종료합니다.
        }

        System.out.printf("최종 장학금은 %d원입니다.%n", scholarship);

        // 이 코드의 실행 결과는 다음과 같습니다:
        // grade = 1 -> scholarship = 40만 (기본) + 10만 (1등급) + 10만 (2등급) + 10만 (3등급) = 70만
        // grade = 2 -> scholarship = 40만 (기본) + 10만 (2등급) + 10만 (3등급) = 60만
        // grade = 3 -> scholarship = 40만 (기본) + 10만 (3등급) = 50만
        // grade = 4 -> scholarship = 40만 (기본) = 40만
        // 이처럼 `fall-through`는 누적 계산이나 여러 조건에 공통적으로 적용되는 로직을 구현할 때 유용하게 사용될 수 있습니다.
    }
}
