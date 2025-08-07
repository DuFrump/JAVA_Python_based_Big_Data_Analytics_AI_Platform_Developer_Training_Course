/**
 * 두프룸프님을 위한 주석 가이드:
 * 이 코드는 내부 클래스의 '접근 제어'와 '캡슐화'를 보여주는 예제입니다.
 * private으로 선언된 내부 클래스는 외부에서 직접 접근할 수 없지만,
 * 바깥 클래스가 허용하는 메소드를 통해서만 간접적으로 사용할 수 있습니다.
 *
 * [비유]
 * InClass는 '비밀의 방'과 같습니다. private으로 잠겨있어 외부인은 존재조차 모릅니다.
 * getInClass() 메소드는 집주인(_04_ClassPermit)이 특별히 열어주는 '비밀의 문'입니다.
 * 외부에서는 이 문을 통해서만 비밀의 방 안의 기능(print())을 이용할 수 있습니다.
 * 이렇게 내부의 복잡한 구조는 숨기고, 허용된 기능만 외부에 노출하는 것을 '캡슐화'라고 합니다.
 */
public class _04_ClassPermit {

    // private으로 선언된 인스턴스 내부 클래스입니다.
    // 이 클래스는 _04_ClassPermit 클래스 내부에서만 사용할 수 있습니다.
    private class InClass {
        public void print() {
            System.out.println("private 내부 클래스의 print 메소드입니다.");
        }
    }

    // private 내부 클래스인 InClass의 객체를 생성해서 반환해주는 public 메소드입니다.
    // 외부와 내부를 연결해주는 '창구' 역할을 합니다.
    public InClass getInClass() {
        return new InClass();
    }

    public static void main(String[] args) {
        _04_ClassPermit permit = new _04_ClassPermit();

        // 아래 코드는 private 클래스에 직접 접근하려 하므로 컴파일 에러가 발생합니다.
        // _04_ClassPermit.InClass myInClass = permit.new InClass(); // (X) 불가능

        // public 메소드인 getInClass()를 통해 InClass 객체를 얻어온 후,
        // 그 객체의 print() 메소드를 호출합니다. 이것이 유일한 사용 방법입니다.
        // permit.getInClass()는 InClass 타입의 객체를 반환합니다.
        permit.getInClass().print();
    }
}
