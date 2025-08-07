// 사용자로부터 키보드 입력을 받기 위한 `Scanner` 클래스 사용법을 배우는 예제입니다.

// 1. Scanner 클래스를 사용하기 위해 `java.util` 패키지에서 가져옵니다(import).
import java.util.Scanner;

public class _08_Scanner {
    public static void main(String[] args) {
        // 2. Scanner 객체를 생성합니다.
        // System.in은 키보드 입력을 의미합니다.
        Scanner sc = new Scanner(System.in);

        // --- 첫 번째 예제: 나이 입력받기 ---
        System.out.print("나이를 입력해 주세요. : "); // 사용자가 무엇을 입력할지 알려주는 안내 메시지

        // 3. Scanner의 메소드를 사용하여 입력을 받습니다.
        // sc.nextInt()는 사용자가 입력한 정수 값을 읽어들입니다.
        int age = sc.nextInt();

        System.out.printf("내 나이는 %d세 입니다.\n\n", age);

        // --- 두 번째 예제: 여러 정보 한 번에 입력받기 ---
        String name, address;
        int age1;
        double height;

        System.out.println("이름, 주소, 나이, 키를 띄어쓰기로 구분하여 입력해주세요.");
        System.out.print("입력: ");

        // sc.next()는 띄어쓰기(공백) 또는 줄바꿈을 기준으로 단어(token)를 하나씩 읽어들입니다.
        name = sc.next();
        address = sc.next();
        age1 = sc.nextInt();
        height = sc.nextDouble();

        System.out.printf("\n당신의 이름은 %s이고, 거주 주소는 %s이고, 나이는 %d이고, 키는 %.1fcm입니다.\n", name, address, age1, height);

        // 4. Scanner 사용이 끝나면 자원을 해제해주는 것이 좋습니다.
        sc.close();
    }
}
