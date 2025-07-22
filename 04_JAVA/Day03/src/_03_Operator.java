public class _03_Operator {
    public static void main(String[] args) {

        // 이중 . 삼항 연산자를 이용해서 크다/작다/같다를 판별하기
        // 1. a와 b 중 누가 큰지 "a가 크다, 혹은 b가 크다" 둘 중에 하나 받아오기.
        int a = 11;
        int b = 11;

        String result = a > b ? "a가 크다!" : "a가 작다!";
        System.out.println(result);

        // 2. "a가 크다" or "b가 크다" or "둘이 같다" 중 하나 받아오기
        result = (a >= b) ? (a == b ? "a와 b는 같다." : "a는 b보다 크다.") : "a는 b보다 작다.";
        System.out.println(result);

//        if (a >= b) {
//            if (a == b) {
//                System.out.println("a와 b는 같다.");
//            } else {
//                System.out.println("a는 b보다 크다.");
//            }
//        } else {
//            System.out.println("a는 b보다 작다.");
//        }
    }
}
