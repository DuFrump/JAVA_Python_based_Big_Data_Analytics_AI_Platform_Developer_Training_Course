public class _06_Continue {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 0; i <= 100; i++) {

            if (i % 2 != 0) {
                continue;
            }
            sum += i;
        }

        System.out.printf("짝수의 합: %d", sum);
    }
}
