public class _11_TryCatch {
    public static void main(String[] args) {
        int result = 0;

        try {
            result = 10/0;
            System.out.printf("나누기 결과 : %d%n", result);
        } catch(ArithmeticException e) {
            System.out.println("0으로 나누기는 불가능합니다.");
        }
        System.out.println("프로그램 종료.");
    }
}
