import java.util.Scanner;

public class _20_lastQuiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("주차 시간을 알려주세요: ");
        int hour = sc.nextInt();

        System.out.print("경차입니까? (true/false): ");
        boolean isSmallCar = sc.nextBoolean();

        System.out.print("장애인 차량입니까? (true/false): ");
        boolean isDisabled = sc.nextBoolean();

        int feePerHour = 4000;
        int maxFee = 30000;

        int totalFee = feePerHour * hour;

        if (totalFee > maxFee) {
            totalFee = maxFee;
        }

        if (isSmallCar || isDisabled) {
            totalFee = totalFee / 2;
        }

        System.out.println("주차 요금은 " + totalFee + "원입니다.");
    }
}
