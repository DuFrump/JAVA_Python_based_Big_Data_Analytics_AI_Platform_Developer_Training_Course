import java.util.Arrays;

public class _11_Arrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 7, 9, 8, 4, 6, 3};

        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));


        int[] arr01 = {1, 2, 3};
        int[] arr02 = arr01;

        arr02[1] = 10;

        System.out.println(Arrays.toString(arr01));
        System.out.println(Arrays.toString(arr02));

        int[] arr03 = {1, 2, 3};
        int[] arr04 = Arrays.copyOf(arr03, arr03.length);

        arr03[2] = 10;

        System.out.println(Arrays.toString(arr03));
        System.out.println(Arrays.toString(arr04));
    }
}
