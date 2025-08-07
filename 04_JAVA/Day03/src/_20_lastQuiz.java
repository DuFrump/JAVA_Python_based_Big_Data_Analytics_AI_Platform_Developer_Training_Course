// 주차 요금을 계산하는 퀴즈입니다.
// 주차 시간, 경차 여부, 장애인 차량 여부를 입력받아 요금을 계산하고,
// 최대 요금 제한 및 할인 적용 로직을 포함합니다.

import java.util.Scanner;

public class _20_lastQuiz {
    public static void main(String[] args) {
        // 1. Scanner 객체 생성: 사용자 입력을 받기 위해 필요합니다.
        Scanner sc = new Scanner(System.in);

        // 2. 사용자로부터 주차 시간 입력받기
        System.out.print("주차 시간을 알려주세요 (시간 단위): ");
        int hour = sc.nextInt();

        // 3. 경차 여부 입력받기
        System.out.print("경차입니까? (true/false): ");
        boolean isSmallCar = sc.nextBoolean();

        // 4. 장애인 차량 여부 입력받기
        System.out.print("장애인 차량입니까? (true/false): ");
        boolean isDisabled = sc.nextBoolean();

        // 5. 주차 요금 관련 상수 설정
        int feePerHour = 4000; // 시간당 주차 요금
        int maxFee = 30000;    // 일일 최대 주차 요금

        // 6. 기본 주차 요금 계산
        int totalFee = feePerHour * hour;

        // 7. 최대 요금 제한 적용
        // 계산된 요금이 최대 요금을 초과하면 최대 요금으로 설정합니다.
        if (totalFee > maxFee) {
            totalFee = maxFee;
        }

        // 8. 할인 적용 (경차 또는 장애인 차량)
        // 경차이거나 장애인 차량이면 요금을 절반으로 할인합니다.
        if (isSmallCar || isDisabled) {
            totalFee = totalFee / 2; // 50% 할인
        }

        // 9. 최종 주차 요금 출력
        System.out.println("주차 요금은 " + totalFee + "원입니다.");

        // 10. Scanner 자원 해제
        sc.close();
    }
}
