import java.util.Scanner;

public class _09_ScannerNextLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String today;
        String yesterday;

        System.out.printf("오늘의 기분을 알려주세요. : ");
        today = sc.next();

        System.out.printf("오늘의 당신의 기분 : %s\n", today);

        System.out.printf("그렇다면 어제의 기분은 어떠셨나요? :");
        yesterday = sc.next();

        System.out.printf("어제의 당신의 기분 : %s", yesterday);
    }
}
