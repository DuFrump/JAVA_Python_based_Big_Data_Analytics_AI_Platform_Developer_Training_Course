import java.util.Scanner;

public class _10_If1 {
    public static void main(String[] args) {
        int result = 0;

        if(3 > 4) {
            result = 3;
        }
        System.out.println(result);


        Scanner sc = new Scanner(System.in);
        System.out.println("나이를 입력해 주세요 : ");

        int age = sc.nextInt();
        if (age >= 19) {
            System.out.println("성인입니다.");
        } else if(age >= 8) {
            System.out.println("학생입니다.");
        } else {
            System.out.println("어린이/유아입니다.");
        }
        System.out.println("종료 코드 0(으)로 완료된 프로세스");
    }
}
