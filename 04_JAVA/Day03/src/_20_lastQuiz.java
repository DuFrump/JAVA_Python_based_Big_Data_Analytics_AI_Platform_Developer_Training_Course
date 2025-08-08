// 안녕하세요, 두프룸프님!
// 이 파일은 오늘 배운 모든 개념들(변수, Scanner, 조건문 if, 논리 연산자 등)을 총동원하여
// '주차 요금 계산기'를 만드는 마지막 퀴즈 예제입니다.
// 실제 생활에서 접할 수 있는 문제를 코드로 해결하는 연습을 해볼 거예요!

import java.util.Scanner; // 사용자 입력을 위한 Scanner 클래스를 불러옵니다.

public class _20_lastQuiz { // 클래스 선언
    public static void main(String[] args) { // main 메서드: 프로그램 시작점

        // 1. Scanner 객체 생성: 사용자 입력을 받기 위한 준비입니다.
        Scanner sc = new Scanner(System.in);

        // 2. 사용자로부터 주차 시간 입력받기
        System.out.print("주차 시간을 알려주세요 (시간 단위): ");
        // sc.nextInt(): 사용자로부터 정수 형태의 주차 시간을 입력받아 `hour` 변수에 저장합니다.
        int hour = sc.nextInt();

        // 3. 경차 여부 입력받기
        System.out.print("경차입니까? (true/false): ");
        // sc.nextBoolean(): 사용자로부터 `true` 또는 `false`를 입력받아 `isSmallCar` 변수에 저장합니다.
        // (대소문자 구분 없이 true/false만 입력 가능합니다.)
        boolean isSmallCar = sc.nextBoolean();

        // 4. 장애인 차량 여부 입력받기
        System.out.print("장애인 차량입니까? (true/false): ");
        // 마찬가지로 `sc.nextBoolean()`을 사용하여 `isDisabled` 변수에 저장합니다.
        boolean isDisabled = sc.nextBoolean();

        // 5. 주차 요금 관련 상수 설정
        // `final` 키워드를 붙이면 변수의 값을 한 번 할당한 후에는 변경할 수 없는 '상수'가 됩니다.
        // 상수는 보통 대문자로 이름을 짓는 것이 관례입니다.
        final int FEE_PER_HOUR = 4000; // 시간당 주차 요금 (4000원)
        final int MAX_FEE = 30000;    // 일일 최대 주차 요금 (30000원)

        // 6. 기본 주차 요금 계산
        // 주차 시간(hour)에 시간당 요금(FEE_PER_HOUR)을 곱하여 기본 요금을 계산합니다.
        int totalFee = FEE_PER_HOUR * hour;

        // 7. 최대 요금 제한 적용
        // `if` 조건문을 사용하여 계산된 요금이 일일 최대 요금을 초과하는지 확인합니다.
        // 만약 초과한다면, `totalFee`를 `MAX_FEE`로 설정하여 최대 요금을 넘지 않도록 합니다.
        if (totalFee > MAX_FEE) {
            totalFee = MAX_FEE;
        }

        // 8. 할인 적용 (경차 또는 장애인 차량)
        // `if` 조건문과 논리 연산자 `||` (OR)를 사용하여 할인 조건을 확인합니다.
        // `isSmallCar`가 true이거나 `isDisabled`가 true이면 (둘 중 하나라도 해당하면) 할인을 적용합니다.
        // 할인은 요금을 절반(50%)으로 줄이는 것입니다.
        if (isSmallCar || isDisabled) {
            totalFee = totalFee / 2; // 50% 할인 적용
        }

        // 9. 최종 주차 요금 출력
        // 계산된 최종 주차 요금을 화면에 출력합니다.
        System.out.println("주차 요금은 " + totalFee + "원입니다.");

        // 10. Scanner 자원 해제
        // 사용이 끝난 Scanner 객체는 시스템 자원 관리를 위해 반드시 닫아주는 것이 좋습니다.
        sc.close();

        // 이 퀴즈를 통해 오늘 배운 다양한 개념들이 실제 프로그램을 만드는 데 어떻게 유기적으로 사용되는지
        // 잘 이해하셨기를 바랍니다. 아주 잘하셨어요, 두프룸프님!
    }
}
