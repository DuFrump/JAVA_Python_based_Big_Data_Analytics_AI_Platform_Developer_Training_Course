import java.sql.SQLOutput;

public class _12_MultiArray {
    public static void main(String[] args) {
        int[][] seats = new int[2][3];

        seats[0][0] = 1;
        seats[0][1] = 2;
        seats[0][2] = 3;
        seats[1][0] = 4;
        seats[1][1] = 5;
        seats[1][2] = 6;

        System.out.println(seats.length);
        System.out.println(seats[0].length);
        System.out.println(seats[1].length);
        System.out.println(seats[1][1]);


        int[][] arr05 = new int[3][];
        arr05[0] = new int[1];
        arr05[1] = new int[3];
        arr05[2] = new int[2];
    }
}
