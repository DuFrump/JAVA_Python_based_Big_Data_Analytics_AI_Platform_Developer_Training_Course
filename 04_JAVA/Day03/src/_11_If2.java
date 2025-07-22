public class _11_If2 {
    public static void main(String[] args) {
        int hour = 20;
        boolean morning_coffee = false;

        if(hour > 17 || morning_coffee == true) {
            System.out.println("커피를 마시지 않겠습니다.");
        } else if(hour < 17 || morning_coffee == false) {
            System.out.println("커피 한 잔 하겠습니다.");
        }
    }
}
