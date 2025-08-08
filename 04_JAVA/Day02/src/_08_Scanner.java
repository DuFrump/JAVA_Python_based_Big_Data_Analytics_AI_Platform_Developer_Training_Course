/**
 * 사용자로부터 키보드 입력을 받기 위한 `Scanner` 클래스 사용법을 배웁니다.
 * `Scanner`는 콘솔(터미널)에서 사용자가 입력하는 값을 프로그램으로 가져올 때 사용합니다.
 * 마치 은행에서 번호표를 뽑고 차례를 기다리는 것처럼, 사용자의 입력을 기다렸다가 받아오는 역할을 합니다.
 */

// 1. Scanner 클래스를 사용하기 위해 `java.util` 패키지에서 가져옵니다(import).
//    import 문은 다른 패키지에 있는 클래스를 현재 파일에서 사용하겠다고 선언하는 것입니다.
//    Ctrl + Shift + O (Eclipse/IntelliJ) 단축키로 자동 import 할 수 있습니다.
import java.util.Scanner;

public class _08_Scanner {
    public static void main(String[] args) {

        // 2. Scanner 객체(Object)를 생성합니다.
        //    객체 생성은 클래스를 실제로 사용할 수 있는 형태로 만드는 과정입니다.
        //    `new Scanner(System.in)`은 "키보드(System.in)로부터 입력을 받을 준비를 하는 Scanner"를 만듭니다.
        Scanner sc = new Scanner(System.in);

        // ------------------- 첫 번째 예제: 정수(나이) 입력받기 -------------------
        System.out.print("나이를 입력해 주세요. : "); // 사용자에게 무엇을 입력해야 하는지 안내하는 메시지

        // 3. Scanner의 메소드를 사용하여 입력을 받습니다.
        //    `sc.nextInt()`: 사용자가 입력한 값 중에서 다음 "정수"를 읽어들입니다.
        //    사용자가 숫자를 입력하고 Enter를 누를 때까지 프로그램은 잠시 멈춰서 기다립니다.
        int age = sc.nextInt();

        System.out.printf("내 나이는 %d세 입니다.%n%n", age);

        // ------------------- 두 번째 예제: 여러 정보 한 번에 입력받기 -------------------
        String name, address;
        int age1;
        double height;

        System.out.println("이름, 주소, 나이, 키를 띄어쓰기로 구분하여 입력해주세요. (예: 홍길동 서울 20 175.5)");
        System.out.print("입력: ");

        // `sc.next()`: 띄어쓰기(공백) 또는 줄바꿈을 기준으로 "단어(token)"를 하나씩 읽어들입니다.
        // `sc.nextInt()`: 다음 "정수"를 읽어들입니다.
        // `sc.nextDouble()`: 다음 "실수"를 읽어들입니다.
        name = sc.next();
        address = sc.next();
        age1 = sc.nextInt();
        height = sc.nextDouble();

        System.out.printf("%n당신의 이름은 %s이고, 거주 주소는 %s이고, 나이는 %d이고, 키는 %.1fcm입니다.%n", name, address, age1, height);

        // 4. Scanner 사용이 끝나면 자원을 해제해주는 것이 좋습니다.
        //    `sc.close()`: Scanner 객체가 사용하던 시스템 자원(키보드 입력 스트림)을 닫아줍니다.
        //    이것은 마치 사용한 수도꼭지를 잠그는 것과 같습니다. 자원을 효율적으로 관리하기 위해 중요합니다.
        sc.close();
    }
}