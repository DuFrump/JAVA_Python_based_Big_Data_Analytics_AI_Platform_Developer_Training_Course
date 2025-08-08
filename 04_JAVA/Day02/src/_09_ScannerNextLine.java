/**
 * `Scanner` 클래스 사용 시 `next()`와 `nextLine()` 메소드의 중요한 차이점과
 * 이들을 함께 사용할 때 발생할 수 있는 문제점, 그리고 그 해결 방법을 배웁니다.
 * 이 내용은 사용자 입력을 정확하게 처리하기 위해 반드시 이해해야 합니다.
 */

import java.util.Scanner;

public class _09_ScannerNextLine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ------------------- 1. next() vs nextLine() -------------------
        // 두 메소드는 입력을 읽어들이는 기준이 다릅니다.

        // `next()`:
        // - 띄어쓰기(공백), 탭(tab), 줄바꿈(Enter)을 "구분자(delimiter)"로 사용하여 단어(token) 하나를 읽어옵니다.
        // - 공백 앞까지만 읽고, 공백 뒤의 내용은 버퍼에 남겨둡니다.
        // - 예시: "Hello World"를 입력하면 "Hello"만 읽고 " World"는 버퍼에 남습니다.
        System.out.print("자기소개를 띄어쓰기 포함해서 입력하세요 (next() 사용): ");
        String intro1 = sc.next(); // 사용자가 "안녕하세요 저는 두프룸프입니다." 라고 입력하면 "안녕하세요"만 저장됩니다.
        System.out.println("next()로 받은 내용: " + intro1);

        // [중요] next()는 엔터(줄바꿈 문자 \n)를 소비하지 않고 버퍼에 남겨둡니다.
        // 다음 nextLine() 호출 시 이 남아있는 \n을 바로 읽어버리는 문제가 발생할 수 있습니다.
        // 따라서 next() 사용 후에는 남아있는 엔터를 비워주는 작업이 필요합니다.
        sc.nextLine(); // 버퍼에 남아있는 엔터("\n")를 읽어서 버립니다. (다음 nextLine()을 위해)

        // `nextLine()`:
        // - 줄바꿈(Enter)을 기준으로 한 줄 전체를 읽어옵니다.
        // - 띄어쓰기(공백)를 포함한 모든 내용을 읽습니다.
        // - 엔터("\n")까지 읽고, 엔터는 소비합니다.
        System.out.print("\n자기소개를 띄어쓰기 포함해서 다시 입력하세요 (nextLine() 사용): ");
        String intro2 = sc.nextLine(); // "안녕하세요 저는 두프룸프입니다." 라고 입력하면 한 줄 전체가 저장됩니다.
        System.out.println("nextLine()으로 받은 내용: " + intro2);

        System.out.println("\n--------------------------------\n");

        // ------------------- 2. nextInt(), nextDouble() 등과 nextLine()을 함께 사용할 때의 문제점 -------------------
        // `nextInt()`, `nextDouble()`, `nextBoolean()` 등은 숫자나 특정 타입의 값만 읽어오고,
        // 사용자가 입력한 "엔터(줄바꿈 문자 \n)"는 입력 버퍼에 그대로 남겨둡니다.
        // 이 상태에서 바로 `nextLine()`을 호출하면, `nextLine()`은 버퍼에 남아있던 이 엔터("\n")를 읽어와서
        // 마치 사용자가 아무것도 입력하지 않고 바로 엔터를 누른 것처럼 동작하여, 실제 입력을 받지 못하고 바로 다음 코드로 넘어갑니다.

        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt(); // 사용자가 '20'을 입력하고 엔터를 누르면, '20'만 age에 저장되고 '\n'은 버퍼에 남습니다.

        System.out.print("이름을 입력하세요: ");
        // 이 nextLine()은 버퍼에 남아있던 '\n'을 바로 읽어버려서, 사용자로부터 이름을 입력받을 기회조차 없이 넘어갑니다.
        String name = sc.nextLine();

        System.out.printf("[문제 발생] 나이: %d, 이름: '%s' (이름이 비어있음)%n", age, name); // 이름이 비어있는 것을 확인

        System.out.println("\n--- 3. 해결 방법 ---\n");

        // `nextInt()` 등 토큰 기반 메소드 사용 후, `nextLine()`을 한 번 더 호출하여
        // 버퍼에 남아있는 엔터("\n")를 "비워주는" 작업을 해주면 됩니다.

        System.out.print("나이를 다시 입력하세요: ");
        int age2 = sc.nextInt();

        // [해결 코드]: 남아있는 엔터("\n")를 소모하기 위한 `sc.nextLine()` 호출
        // 이 줄이 버퍼에 남아있던 엔터를 읽어서 버려주므로, 다음 `nextLine()`이 정상적으로 동작합니다.
        sc.nextLine(); 

        System.out.print("이름을 다시 입력하세요: ");
        String name2 = sc.nextLine(); // 이제 정상적으로 이름을 입력받을 수 있습니다.

        System.out.printf("[해결 완료] 나이: %d, 이름: '%s'%n", age2, name2);

        // Scanner 사용이 끝나면 반드시 닫아주어 자원을 해제합니다.
        sc.close();
    }
}