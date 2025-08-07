package _03_Inheritance_computer;

// Main 클래스는 Computer와 Samsung 클래스를 사용하여 객체를 생성하고
// 메소드 오버라이딩의 동작을 확인하는 예제입니다.
public class Main {
    public static void main(String[] args) {
        // [1] Samsung 클래스의 객체 생성 및 메소드 호출
        // Samsung은 Computer를 상속받았고, powerOn() 메소드를 오버라이딩했습니다.
        Samsung comp01 = new Samsung();

        System.out.println("--- Samsung 컴퓨터 ---");
        // 오버라이딩된 powerOn() 메소드가 호출됩니다.
        comp01.powerOn();  // 출력: 컴퓨터가 켜졌습니다.
                           //       !I love Samsung!

        // powerOff()는 Samsung 클래스에서 오버라이딩되지 않았으므로,
        // 부모 클래스인 Computer의 powerOff() 메소드가 호출됩니다.
        comp01.powerOff(); // 출력: 컴퓨터가 꺼졌습니다.

        System.out.println("
----------------------------------------
");

        // [2] Computer 클래스의 객체 생성 및 메소드 호출
        // Computer 클래스는 오버라이딩된 메소드가 없으므로, 자신의 메소드를 호출합니다.
        Computer comp02 = new Computer();

        System.out.println("--- 일반 컴퓨터 ---");
        comp02.powerOn();  // 출력: 컴퓨터가 켜졌습니다.
        comp02.powerOff(); // 출력: 컴퓨터가 꺼졌습니다.
    }
}
