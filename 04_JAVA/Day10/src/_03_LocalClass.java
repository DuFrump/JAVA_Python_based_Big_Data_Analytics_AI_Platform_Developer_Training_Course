/**
 * 두프룸프님을 위한 주석 가이드:
 * 이 코드는 '지역 내부 클래스(Local Inner Class)'를 보여줍니다.
 * 특정 메소드 블록 안에서만 선언되고 사용되는, 가장 좁은 범위를 가지는 클래스입니다.
 *
 * [비유]
 * getUnit이라는 '요리 레시피' 메소드 안에서만 잠깐 사용하고 버리는 '임시 계량컵'(Unit 클래스)과 같습니다.
 * 그 요리가 끝나면(메소드가 종료되면) 다른 곳에서는 그 계량컵을 볼 수도, 쓸 수도 없습니다.
 */
public class _03_LocalClass {
    // 바깥 클래스의 인스턴스 변수
    private int speed = 10;

    // 특정 유닛을 생성하고 움직이게 하는 메소드
    public void getUnit(String unitName) {

        // 이것이 바로 '지역 내부 클래스'입니다. getUnit 메소드 안에서만 유효합니다.
        class Unit {
            // 지역 내부 클래스의 메소드
            public void move() {
                // 자신을 감싸고 있는 메소드의 매개변수(unitName)나
                // 바깥 클래스의 멤버(speed)에 자유롭게 접근할 수 있습니다.
                System.out.printf("%s이(가) %d의 속도로 이동합니다.%n", unitName, speed);
            }
        }

        // 지역 클래스는 선언된 그 메소드 안에서만 객체로 만들고 사용할 수 있습니다.
        Unit unit = new Unit();
        unit.move();
    }

    public static void main(String[] args) {
        _03_LocalClass local = new _03_LocalClass();

        // getUnit 메소드를 호출하면, 그 안의 지역 클래스 Unit이 생성되고 사용된 후 사라집니다.
        local.getUnit("마린");
        local.getUnit("질럿");
    }
}
