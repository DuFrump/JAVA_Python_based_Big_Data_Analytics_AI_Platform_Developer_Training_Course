// Scanner를 사용하여 다양한 데이터 타입의 사용자 입력을 받는 예제입니다.
// 특히 `nextInt()`/`nextDouble()`와 `nextLine()`을 함께 사용할 때의 주의사항을 다룹니다.

import java.util.Scanner;

public class _02_Scanner {
    public static void main(String[] args) {
        String name;    // 이름을 저장할 변수
        double height;  // 키를 저장할 변수
        int age;        // 나이를 저장할 변수
        String address; // 주소지를 저장할 변수

        // Scanner 객체 생성: System.in (표준 입력, 키보드)으로부터 입력을 받습니다.
        Scanner sc = new Scanner(System.in);

        // 1. 이름 입력받기 (next() 사용)
        System.out.print("이름이 어떻게 되시나요? : ");
        // sc.next(): 공백(띄어쓰기, 탭, 엔터)을 기준으로 한 단어(토큰)를 읽어옵니다.
        name = sc.next();

        // 2. 키 입력받기 (nextDouble() 사용)
        System.out.print("%n키가 어떻게 되시나요? (예: 175.5) : ");
        // sc.nextDouble(): 다음 토큰을 double 타입으로 읽어옵니다.
        height = sc.nextDouble();

        // 3. 나이 입력받기 (nextInt() 사용)
        System.out.print("%n나이가 어떻게 되시나요? : ");
        // sc.nextInt(): 다음 토큰을 int 타입으로 읽어옵니다.
        age = sc.nextInt();

        // 4. 주소지 입력받기 (nextLine() 사용 시 주의사항)
        System.out.print("%n주소지는 어떻게 되시나요? (띄어쓰기 포함 가능) : ");
        // [중요] nextInt(), nextDouble() 등은 숫자만 읽고, 사용자가 입력한 엔터(줄바꿈 문자 \n)는
        // 입력 버퍼에 그대로 남겨둡니다. 이 상태에서 nextLine()을 호출하면,
        // nextLine()은 버퍼에 남아있던 엔터(\n)를 읽어와서 바로 입력을 종료해버립니다.
        // 따라서 실제 주소지 입력을 받기 전에, 남아있는 엔터(\n)를 소비하기 위해 nextLine()을 한 번 더 호출해야 합니다.
        sc.nextLine(); // 버퍼에 남아있는 엔터("\n")를 비워주는 역할
        address = sc.nextLine(); // 이제 정상적으로 한 줄 전체를 입력받을 수 있습니다.

        // 입력받은 정보들을 조합하여 출력합니다.
        // %.1f는 소수점 첫째 자리까지 출력하라는 의미입니다. (원래 코드는 %.100f로 되어있어 수정)
        System.out.printf("%n%n%n당신의 이름은 %s이고, 나이는 %d이군요. 또한 키는 %.1fcm, 현재 거주지는 %s입니다.\n", name, age, height, address);

        // Scanner 객체 사용이 끝나면 자원을 해제합니다.
        sc.close();
    }
}
