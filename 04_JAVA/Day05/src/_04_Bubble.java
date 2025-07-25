public class _04_Bubble {
    public static void main(String[] args) {

        int[] arr = {1, 6, 3, 7, 5, 9};

        int temp;

        for (int i = arr.length -1 ; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {

                if(arr[j] > arr[j+1]) {
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("정렬 끝");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }





    }
}
