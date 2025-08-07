/**
 * 두프룸프님을 위한 주석 가이드:
 * 이 코드는 '정적 내부 클래스(Static Inner Class)'를 보여줍니다.
 * static 키워드가 붙어서, 바깥 클래스의 객체를 만들지 않아도 독립적으로 사용할 수 있는 클래스입니다.
 *
 * [비유]
 * 바깥 클래스 PrintOut이 '대학교'라면, 정적 내부 클래스 Out은 그 대학교 소속의 '부설 연구소'와 같습니다.
 * 연구소는 대학교 이름(PrintOut)만 알면 바로 찾아가서 이용(객체 생성)할 수 있습니다.
 * 굳이 특정 학생(PrintOut 객체)을 통할 필요가 없습니다.
 * 중요한 점: 연구소(Out)는 대학교의 공용 시설(static 멤버)은 쓸 수 있지만, 특정 학생의 사물함(인스턴스 멤버)은 알 수도 없고 쓸 수도 없습니다.
 */
class PrintOut {
    // static 변수. PrintOut 클래스 자체에 속하며 모든 객체가 공유합니다. (대학교 공용 시설)
    private static int val = 100;

    // 이것이 바로 '정적 내부 클래스'입니다.
    public static class Out {
        // 정적 내부 클래스의 메소드
        public void println(String str) {
            System.out.println(str);

            // 바깥 클래스의 static 멤버(val)에는 자유롭게 접근할 수 있습니다.
            int result = val + 10;
            System.out.println("바깥 클래스의 static 변수 val: " + val);

            // 만약 PrintOut 클래스에 인스턴스 변수(e.g., private int speed)가 있더라도,
            // 여기서는 접근할 수 없습니다. 어떤 PrintOut 객체의 speed인지 특정할 수 없기 때문입니다.
        }
    }
}

public class _02_StaticClass {
    public static void main(String[] args) {
        String str = "정적 내부 클래스 테스트";

        // 정적 내부 클래스는 바깥 클래스의 객체 생성 없이 바로 객체를 만들 수 있습니다.
        // 형식: 바깥클래스.내부클래스 변수명 = new 바깥클래스.내부클래스();
        PrintOut.Out out = new PrintOut.Out();

        // 내부 클래스의 메소드를 호출합니다.
        out.println(str);
    }
}
