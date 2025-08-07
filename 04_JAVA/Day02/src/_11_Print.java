// `System.out.println()`과 `System.out.print()`의 차이점을 배우는 예제입니다.

public class _11_Print {
    public static void main(String[] args) {
        // [1] System.out.println()
        // ln은 line의 약자로, 괄호 안의 내용을 출력한 후 "자동으로 줄을 바꿔줍니다."
        System.out.println("우하하하"); // "우하하하" 출력 후 줄바꿈
        System.out.println("무야호");   // "무야호" 출력 후 줄바꿈

        System.out.println("--------------------------");

        // [2] System.out.print()
        // 괄호 안의 내용을 출력하기만 하고, "줄을 바꾸지 않습니다."
        // 따라서 다음에 오는 출력은 같은 줄에 이어서 나오게 됩니다.
        System.out.print("안녕 ");      // "안녕 " 출력 (줄바꿈 없음)
        System.out.println("길동아?");  // "길동아?"를 이어서 출력하고 줄바꿈
        // 결과: 안녕 길동아?

        System.out.print("행복해 ");    // "행복해 " 출력 (줄바꿈 없음)
        System.out.println("보이는구나."); // "보이는구나."를 이어서 출력하고 줄바꿈
        // 결과: 행복해 보이는구나.

        System.out.print("즐거워 ");    // "즐거워 " 출력 (줄바꿈 없음)
        System.out.println("보이니 좋다."); // "보이니 좋다."를 이어서 출력하고 줄바꿈
        // 결과: 즐거워 보이니 좋다.

        System.out.print("잘 살아");     // "잘 살아" 출력 (줄바꿈 없음)
        // 프로그램이 여기서 끝나므로, 마지막 줄바꿈은 눈에 보이지 않습니다.
    }
}
