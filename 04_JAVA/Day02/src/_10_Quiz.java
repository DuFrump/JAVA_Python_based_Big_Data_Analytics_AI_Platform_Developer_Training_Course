// Scanner를 활용하여 사용자로부터 입력을 받아 문장을 완성하는 퀴즈입니다.

import java.util.Scanner;

public class _10_Quiz {
    public static void main(String[] args) {
        // Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        // 1. 배우는 언어를 입력받기
        System.out.print("무슨 언어를 배우시나요? : ");
        // next()를 사용하여 단어(공백 없는 문자열)를 입력받아 lang 변수에 저장
        String lang = sc.next();

        // 2. next() 사용 후 남아있을 수 있는 엔터(\n)를 비워주기 위한 처리
        // 이 코드가 없으면 바로 다음 nextLine()이 입력을 기다리지 않고 넘어가버릴 수 있습니다.
        sc.nextLine();

        // 3. 배운 소감을 입력받기
        System.out.print("\n배우시니 어떠신가요? (소감을 문장으로 입력) : ");
        // nextLine()을 사용하여 띄어쓰기가 포함된 한 줄 전체를 입력받아 exp 변수에 저장
        String exp = sc.nextLine();

        // 4. 입력받은 내용을 조합하여 최종 문장 출력
        System.out.printf("\n[%s]를 배우니 [%s]!", lang, exp);

        // Scanner 자원 해제
        sc.close();
    }
}
