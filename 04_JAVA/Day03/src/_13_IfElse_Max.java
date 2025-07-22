public class _13_IfElse_Max {
    public static void main(String[] args) {
        int a = 4;
        int b = 10;
        int max = 0;

        if(a > b) {
            max = a;
        } else {
            max = b;
        }

        System.out.printf("%d와 %d 중에 큰 수는 %d입니다.", a, b, max);
    }
}
