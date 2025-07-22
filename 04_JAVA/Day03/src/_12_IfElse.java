public class _12_IfElse {
    public static void main(String[] args) {
        int num = 5;

        if (num > 4) {
            System.out.println(num + "는 4보다 큽니다.");
        } else {
            System.out.println(num + "는 4보다 작거나 같습니다.");
        }

        int a = 3;
        int b = 10;

        if (a > b) {
            System.out.printf("%d는 %d보다 큽니다.", a, b);
        } else {
            System.out.printf("%d는 %d보다 작거나 같습니다.", a, b);
        }
    }
}
