public class _09_Array2 {
    public static void main(String[] args) {
//        int[] numbers = new int[10];
//
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = (int)(Math.random() * 30) + 1;
//        }
//
//        int sum = 0;
//
//        for (int i = 0; i < numbers.length ; i++) {
//            if (numbers[i] % 2 == 0) {
//                sum += numbers[i];
//            }
//        }
//
//        for (int i = 0; i < numbers.length; i++) {
//            System.out.printf("%d번째 난수 (1 ~ 30 사이) : %d%n", i + 1, numbers[i]);
//        }
//
//        System.out.printf("짝수 합산 : %d%n", sum);
//        System.out.println(Math.pow(0.5, 10));


        System.out.printf("%n%n===============================================%n");

        int count = 0;

        while (true) {
            System.out.println();
            int sum = 0;

            int[] numbers = new int[10];

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = (int)(Math.random() * 30) + 1;
            }

            for (int i = 0; i < numbers.length ; i++) {
                if (numbers[i] % 2 == 0) {
                    sum += numbers[i];
                }
            }

            for (int i = 0; i < numbers.length; i++) {
                System.out.printf("%d번째 난수 (1 ~ 30 사이) : %d%n", i + 1, numbers[i]);
            }

            System.out.printf("짝수 합산 : %d%n", sum);
            count += 1;

            if(sum == 0){
                break;
            }
        }

        System.out.println();
        System.out.println("총 반복 횟수 : " + count);

    }
}