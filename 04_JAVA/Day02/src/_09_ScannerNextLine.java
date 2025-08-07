// Scanner 사용 시 `next()`와 `nextLine()`의 차이점과 주의사항을 배우는 예제입니다.

import java.util.Scanner;

public class _09_ScannerNextLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // [1] next() vs nextLine()
        // next()     : 띄어쓰기(공백)를 기준으로 단어를 읽어옵니다.
        // nextLine() : 줄바꿈(Enter)을 기준으로 한 줄 전체를 읽어옵니다.

        System.out.print("자기소개를 띄어쓰기 포함해서 입력하세요 (next() 사용): ");
        String intro1 = sc.next(); // "안녕하세요 저는" 이라고 입력하면 "안녕하세요"만 저장됨
        System.out.println("next()로 받은 내용: " + intro1);

        // 위에서 next()를 사용한 후 버퍼에 남아있는 " 저는"과 엔터 값을 비워주기 위해 추가
        sc.nextLine();

        System.out.print("\n자기소개를 띄어쓰기 포함해서 다시 입력하세요 (nextLine() 사용): ");
        String intro2 = sc.nextLine(); // 입력한 한 줄 전체가 저장됨
        System.out.println("nextLine()으로 받은 내용: " + intro2);

        System.out.println("\n--------------------------------\n");

        // [2] nextInt(), nextDouble() 등과 nextLine()을 함께 사용할 때의 문제점
        // nextInt()는 숫자만 읽어오고, 사용자가 누른 엔터(줄바꿈 문자 \n)는 입력 버퍼에 그대로 남겨둡니다.
        // 이후에 nextLine()을 호출하면, 이 남아있는 엔터를 읽어와서 바로 실행을 종료시켜버리는 문제가 발생합니다.

        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt(); // 숫자(예: 20)만 읽고, 엔터(\n)는 버퍼에 남김

        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine(); // 버퍼에 남아있던 \n을 읽고 즉시 종료되어 이름 입력을 받을 수 없음

        System.out.printf("[문제 발생] 나이: %d, 이름: '%s'\n", age, name); // 이름이 비어있는 것을 확인

        System.out.println("\n--- 해결 방법 ---\n");

        // [3] 해결 방법
        // nextInt() 사용 후, nextLine()을 한 번 더 호출하여 버퍼에 남아있는 엔터(\n)를 비워줍니다.

        System.out.print("나이를 다시 입력하세요: ");
        int age2 = sc.nextInt();

        // 해결 코드: 남아있는 엔터(\n)를 소모하기 위한 sc.nextLine() 호출
        sc.nextLine();

        System.out.print("이름을 다시 입력하세요: ");
        String name2 = sc.nextLine(); // 이제 정상적으로 이름을 입력받을 수 있습니다.

        System.out.printf("[해결 완료] 나이: %d, 이름: '%s'\n", age2, name2);

        sc.close();
    }
}
