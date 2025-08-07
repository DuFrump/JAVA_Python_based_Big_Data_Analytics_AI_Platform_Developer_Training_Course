// 연산자(Operator) 중에서 부호 연산자(Sign Operator)에 대해 배우는 예제입니다.

public class _13_Operator {
    public static void main(String[] args) {
        int x = 100;

        // + 연산자: 변수의 부호를 그대로 유지합니다. (실제로는 거의 사용하지 않음)
        int plusX = +x;

        // - 연산자: 변수의 부호를 반대로 바꿉니다.
        int minusX = -x;

        // [중요] 부호 연산자는 변수 x의 값 자체를 바꾸는 것이 아닙니다.
        // x의 값을 읽어와서 부호 연산을 수행한 "결과"를 새로운 변수에 저장하거나 출력하는 것입니다.

        System.out.println("원래 x 값: " + x);         // 출력: 100
        System.out.println("+x 결과: " + plusX);      // 출력: 100
        System.out.println("-x 결과: " + minusX);     // 출력: -100
        System.out.println("연산 후 x 값: " + x);     // 출력: 100 (x의 값은 변하지 않음)

        System.out.println("--------------------------");

        // 실수 타입에도 동일하게 적용됩니다.
        double d = 1.11;
        double result = -d; // -1.11

        System.out.println("-d 결과: " + -d);         // 출력: -1.11
        System.out.println("result 값: " + result);   // 출력: -1.11
        System.out.println("연산 후 d 값: " + d);     // 출력: 1.11 (d의 값은 변하지 않음)
    }
}
