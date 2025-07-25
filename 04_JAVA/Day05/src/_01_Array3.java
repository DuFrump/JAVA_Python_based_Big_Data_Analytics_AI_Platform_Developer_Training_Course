public class _01_Array3 {
    public static void main(String[] args) {

        char[] cards = {'1', 'L', 'O', '2', 'V', '3', 'E'};
        String myWord = "";

        for(int i = 0; i < cards.length; i++) {

            int word = cards[i];
            if((word >= 65 && word <= 90) || (word >= 97 && word <= 122)) {
                myWord += (char)word;
            }
        }

        System.out.println("여러분 " + myWord + " 합니다.");

    }
}
