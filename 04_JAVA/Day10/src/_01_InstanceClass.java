/**
 * 두프룸프님을 위한 주석 가이드:
 * 이 코드는 '인스턴스 내부 클래스'를 보여줍니다.
 * 바깥 클래스의 객체(인스턴스)가 있어야만 생성하고 사용할 수 있는 클래스입니다.
 *
 * [비유]
 * 바깥 클래스 Calculator가 '설계도'라면, 내부 클래스 Calc는 그 설계도 안에만 존재하는 '엔진 설계도'입니다.
 * Calculator 객체(실제 자동차)를 만들어야만, 그 안의 Calc 엔진도 실체가 생겨서 움직일 수 있습니다.
 * 중요한 점: 엔진(Calc)은 자동차(Calculator)의 부품(val1, val2)을 마음대로 가져다 쓸 수 있습니다.
 */
class Calculator {
    // Calculator 객체가 생성될 때마다 각자 가지게 되는 변수 (인스턴스 변수)
    private int val1;
    private int val2;

    // 모든 Calculator 객체들이 공유하는 하나의 변수 (클래스 변수)
    static int sum = 0;

    // 생성자: Calculator 객체를 만들 때 val1, val2 값을 설정합니다.
    public Calculator(int val1, int val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    // 이것이 바로 '인스턴스 내부 클래스'입니다.
    public class Calc {
        // 내부 클래스의 메소드
        public int add() {
            // 바깥 클래스의 인스턴스 변수(val1, val2)에 자유롭게 접근할 수 있습니다.
            // 또한 바깥 클래스의 static 변수(sum)에도 접근 가능합니다.
            sum = val1 + val2;
            return val1 + val2;
        }
    }
}

public class _01_InstanceClass {
    public static void main(String[] args) {
        // 1. 바깥 클래스인 Calculator의 객체를 먼저 생성해야 합니다.
        Calculator cal = new Calculator(10, 11);

        // 2. 생성된 바깥 클래스 객체(cal)를 통해 내부 클래스 Calc의 객체를 생성합니다.
        //    (마치 자동차가 출고된 후에야 그 안의 엔진을 켤 수 있는 것과 같습니다.)
        Calculator.Calc c = cal.new Calc();

        // 3. 내부 클래스의 메소드를 호출합니다.
        System.out.printf("합계 : %d", c.add());
    }
}
