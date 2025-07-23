public class _01_For1 {
    public static void main(String[] args) {
        int sum = 0;

        for(int i = 0; i <= 10; i++) {
            System.out.println("안녕하세요.");
        }

        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        System.out.println(sum);

        for (int i = 5; i > 0; i--) {
            System.out.println(i);
        }

        for (int i = 1; i <= 10; i += 2) {
            System.out.println(i);
        }

        sum = 0;

        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);


        sum = 0;

        for (int i = 1; i <= 100; i++) {
            if(i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
