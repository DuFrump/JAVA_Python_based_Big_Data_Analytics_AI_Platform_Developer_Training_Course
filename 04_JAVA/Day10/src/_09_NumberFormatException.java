// 잘못된 문자열을 숫자로 형 변환할 때 발생

public class _09_NumberFormatException {
    public static void main(String[] args) {
        String str01 = "11";
        String str02 = "11.2";

        int num01 = Integer.parseInt(str01);
        System.out.printf("String to int : %d%n", num01);

        int num02 = Integer.parseInt(str02);
        System.out.printf("String to int : %d%n", num02);
    }
}
