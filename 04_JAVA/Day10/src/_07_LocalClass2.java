/**
 * 두프룸프님을 위한 주석 가이드:
 * 이 코드는 '지역 내부 클래스(Local Inner Class)'의 또 다른 예시를 보여줍니다.
 * 지역 클래스는 특정 메소드 안에서만 정의되고 사용되는 클래스로,
 * 해당 메소드의 실행이 끝나면 더 이상 존재하지 않는 일회성 클래스라고 생각할 수 있습니다.
 *
 * [비유]
 * myMethod라는 '특정 작업 공간' 안에서만 사용되는 '임시 도구' (LocalClass)와 같습니다.
 * 이 도구는 그 작업 공간 안에서만 만들어지고 사용되며, 작업이 끝나면 사라집니다.
 * 다른 작업 공간에서는 이 도구를 알 수도, 사용할 수도 없습니다.
 */
public class _07_LocalClass2 {

    /**
     * 이 메소드 안에서 지역 클래스 LocalClass가 정의되고 사용됩니다.
     */
    void myMethod() {
        // 이곳에 'LocalClass'라는 지역 내부 클래스를 정의합니다.
        // 이 클래스는 오직 myMethod() 안에서만 유효합니다.
        class LocalClass {
            /**
             * 지역 클래스 LocalClass의 메소드입니다.
             * 이 메소드는 LocalClass의 인스턴스를 통해 호출됩니다.
             */
            void display() {
                System.out.println("지역 클래스에서 실행됨!");
                // 참고: 지역 클래스는 자신을 감싸는 메소드의 final 또는
                //      effectively final(사실상 final) 지역 변수에 접근할 수 있습니다.
                //      (이 예제에는 해당 변수가 없지만, 중요한 특징입니다.)
            }
        }

        // myMethod() 안에서만 LocalClass의 인스턴스를 생성할 수 있습니다.
        LocalClass local = new LocalClass();

        // 생성된 인스턴스를 통해 display() 메소드를 호출합니다.
        local.display();
    }

    /**
     * 프로그램의 시작점인 main 메소드입니다.
     */
    public static void main(String[] args) {
        // _07_LocalClass2 클래스의 객체를 생성합니다.
        _07_LocalClass2 outer = new _07_LocalClass2();
        // myMethod()를 호출하여 그 안에서 정의된 지역 클래스가 실행되도록 합니다.
        outer.myMethod();
    }
}