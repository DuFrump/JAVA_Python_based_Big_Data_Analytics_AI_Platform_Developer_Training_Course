// 자바 프로그램의 가장 기본적인 구조를 보여주는 예제 코드입니다.

// public class [클래스명] { ... }
// 자바의 모든 코드는 클래스 안에 작성되어야 합니다.
// 클래스명은 일반적으로 파일명과 동일하게 작성합니다. (예: _01_JavaStart.java)
public class _01_JavaStart {

    // public static void main(String[] args) { ... }
    // main 메소드(method)는 자바 프로그램의 시작점입니다.
    // 프로그램이 실행되면 가장 먼저 이 부분이 실행됩니다.
    public static void main(String[] args) {
        // System.out.println("...");
        // System.out.println()은 괄호 안의 내용을 콘솔(화면)에 출력하는 역할을 합니다.
        // 문자열(String)을 출력할 때는 큰따옴표("")로 감싸줍니다.
        System.out.println("Hi, Java. Nice to meet you!");

        // System.out.println()에 아무 내용도 넣지 않으면 단순히 한 줄을 띄우는 역할을 합니다.
        System.out.println();
    }
}
