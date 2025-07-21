public class _17_Operator5 {
    public static void main(String[] args) {
        // 조건 연산자
        // 조건식 ? 피연산자1 : 피연산자2;
        //        (참일 경우) (거짓일 경우)

        int num = (7 > 1) ? 1 : 2;
        System.out.println(num);

        int x = 1;
        int y = 5;

        int max = (x > y) ? x : y;
        System.out.println(max);

        int min = (x > y) ? y : x;
        System.out.println(min);

    }
}
