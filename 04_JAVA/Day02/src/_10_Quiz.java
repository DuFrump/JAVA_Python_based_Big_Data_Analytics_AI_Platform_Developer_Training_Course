import java.util.Scanner;

public class _10_Quiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("무슨 언어를 배우시나요? : ");
        String lang = sc.next();

        sc.nextLine();

        System.out.printf("\n배우시니 어떠신가요? : ");
        String exp = sc.nextLine();

        System.out.printf("\n%s를 배우니 %s 합니다.", lang, exp);
    }
}
