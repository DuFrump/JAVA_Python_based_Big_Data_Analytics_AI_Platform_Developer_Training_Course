import java.util.Scanner;

public class _08_Scanner {
    public static void main(String[] args) {
//        int age = 32;

        Scanner sc = new Scanner(System.in);

        System.out.printf("나이를 입력해 주세요. : ");
        int age = sc.nextInt();

        System.out.printf("내 나이는 %d세 입니다.\n", age);

        String name, address;
        int age1;
        double height;

        System.out.printf("이름, 주소, 나이, 키를 띄어쓰기로 입력해주세요. : ");
        name = sc.next();
        address = sc.next();
        age1 = sc.nextInt();
        height = sc.nextDouble();

        System.out.printf("당신의 이름은 %s이고, 거주 주소는 %s이고, 나이는 %d이고, 키는 %.1fcm입니다.", name, address, age1, height);
    }
}