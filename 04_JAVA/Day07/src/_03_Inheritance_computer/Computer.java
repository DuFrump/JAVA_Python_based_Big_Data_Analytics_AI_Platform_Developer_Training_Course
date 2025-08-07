package _03_Inheritance_computer;

// Computer 클래스는 컴퓨터의 기본적인 기능을 나타내는 부모 클래스(Superclass)입니다.
// 모든 컴퓨터가 공통적으로 가질 수 있는 동작을 정의합니다.
public class Computer {
    // 메소드(Method): 컴퓨터를 켜는 기능입니다.
    void powerOn() {
        System.out.println("컴퓨터가 켜졌습니다.");
    }

    // 메소드(Method): 컴퓨터를 끄는 기능입니다.
    void powerOff() {
        System.out.println("컴퓨터가 꺼졌습니다.");
    }
}
