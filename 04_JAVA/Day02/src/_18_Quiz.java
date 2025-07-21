import java.util.Scanner;

public class _18_Quiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("당신의 키는 몇입니까? : ");
        double height = sc.nextDouble();

        String result = height > 120 ? "탑승 가능하십니다." : "탑승 불가능하십니다.";
        System.out.println(result);
    }
}
