public class _05_DoWhile {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;

        do {
            System.out.println("식사는 하셨습니까?");
            sum += i;
            i++;
        } while (i <= 10);

        System.out.println(sum);
    }
}
