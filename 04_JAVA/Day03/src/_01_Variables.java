import java.util.Scanner;

public class _01_Variables {
    public static void main(String[] args) {
        System.out.printf("이름을 알려주세요. : ");

        String greeting = "안녕하세요";

        Scanner sc = new Scanner(System.in);
        String name = sc.next();

        System.out.printf("%s! %s님!%n", greeting, name);

        System.out.printf("혹시 오늘의 날씨와 시간을 알려주실 수 있으신가요? : ");
        String weather = sc.next();
        String time = sc.next();

        System.out.printf("아하! 오늘의 날씨는 %s이고, 시간은 %s이군요.%n", weather, time);

        int age = 28;
        double height = 181.5;
        char gender = 'M';
        short seat_number = 1;
        boolean is_goodman = true;

        System.out.printf("저의 이름은 %s이고, 나이는 %d, 키는 %.1f, 성별은 %c입니다. 학원에서 저의 자리는 %d번이고, 저는 좋은 사람입니다. %b!", name, age, height, gender, seat_number, is_goodman);
    }
}
