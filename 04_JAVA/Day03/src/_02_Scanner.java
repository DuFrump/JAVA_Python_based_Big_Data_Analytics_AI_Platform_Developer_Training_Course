import java.util.Scanner;

public class _02_Scanner {
    public static void main(String[] args) {
        String name;
        double height;
        int age;
        String address;

        Scanner sc = new Scanner(System.in);

        System.out.printf("이름이 어떻게 되시나요? : ");
        name = sc.next();

        System.out.printf("%n키가 어떻게 되시나요? : ");
        height = sc.nextDouble();

        System.out.printf("%n나이가 어떻게 되시나요? : ");
        age = sc.nextInt();

        System.out.printf("%n주소지는 어떻게 되시나요? : ");
        sc.nextLine();              // 버퍼 비우기 반드시 해주자! nextLine을 썼을 경우 엔터키가 버퍼에 남아있어서 그냥 스킵 되는 경우가 있을 수 있으므로,
        address = sc.nextLine();    // 비워준 버퍼를 만들어서 그 쪽 부분을 띄우게 만들기! (nextLine 쓰기 전에 next나 nextLine을 사용했더라면 사용 해주기)

        System.out.printf("%n%n%n당신의 이름은 %s이고, 나이는 %d이군요. 또한 키는 %.100fcm, 현재 거주지는 %s입니다.", name, age, height, address);
    }
}
