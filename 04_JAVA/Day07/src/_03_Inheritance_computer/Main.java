package _03_Inheritance_computer;

/**
 * 세 번째 예제의 마지막 파일, Main 클래스입니다!
 * 여기서는 우리가 만든 Computer와 Samsung 클래스를 실제로 사용해보면서,
 * 상속과 메소드 오버라이딩이 어떻게 동작하는지 눈으로 확인하는 중요한 시간이에요.
 *
 * 'public static void main(String[] args)' 메소드는 자바 프로그램이 시작되는 지점이라는 것,
 * 이제는 잘 아시죠? 여기서 객체를 만들고 메소드를 호출하면서 동작을 살펴봅시다.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("--- Samsung 컴퓨터 객체 테스트 ---");

        // [1] Samsung 클래스의 객체 생성
        // Samsung은 Computer를 상속받았고, powerOn() 메소드를 오버라이딩했습니다.
        Samsung mySamsung = new Samsung();

        // 오버라이딩된 powerOn() 메소드가 호출됩니다.
        // Samsung 클래스의 powerOn() 안에서 super.powerOn()을 호출했기 때문에,
        // 부모의 메시지("컴퓨터가 켜졌습니다.")와 자식의 메시티("!I love Samsung!")가 모두 출력됩니다.
        mySamsung.powerOn();

        // powerOff()는 Samsung 클래스에서 오버라이딩되지 않았습니다.
        // 따라서 부모 클래스인 Computer의 powerOff() 메소드가 호출됩니다.
        mySamsung.powerOff();

        // Samsung 클래스에만 있는 고유한 메소드인 runBixby()를 호출합니다.
        mySamsung.runBixby();

        System.out.println("\n----------------------------------------\n");

        System.out.println("--- 일반 Computer 객체 테스트 ---");

        // [2] Computer 클래스의 객체 생성
        // Computer 클래스는 오버라이딩된 메소드가 없으므로, 자신의 메소드를 호출합니다.
        Computer genericComputer = new Computer();

        genericComputer.powerOn();
        genericComputer.powerOff();

        // 이 예제를 통해 상속을 통해 부모의 기능을 물려받고,
        // 필요에 따라 오버라이딩하여 기능을 변경하거나,
        // 자식 클래스만의 새로운 기능을 추가할 수 있다는 것을 이해하셨기를 바랍니다!
    }
}