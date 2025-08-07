package _05_Practice_Computer;

// ComputerRoom 클래스는 여러 대의 컴퓨터를 관리하고 제어하는 기능을 제공합니다.
// 다형성(Polymorphism)을 활용하여 다양한 종류의 컴퓨터를 일괄적으로 다룹니다.
public class ComputerRoom {
    // [1] 다형성 활용: 부모 클래스(Computer) 타입의 참조 변수로 자식 클래스 객체를 참조
    // 이렇게 선언하면 Samsung, LG 등 어떤 종류의 Computer 객체든 저장할 수 있습니다.
    Computer computer1;
    Computer computer2;
    Computer computer3;
    Computer computer4;

    // [참고] 아래와 같이 특정 자식 클래스 타입으로 선언하면 해당 타입의 객체만 저장할 수 있어 유연성이 떨어집니다.
    // Samsung computer1;
    // Samsung computer2;
    // LG computer1;
    // LG computer2;

    // 모든 컴퓨터의 전원을 켜는 메소드
    void allPowerOn() {
        // 각 computer 변수가 참조하는 실제 객체(Samsung, LG, Computer)에 따라
        // 오버라이딩된 `powerOn()` 메소드가 호출됩니다. (다형성)
        computer1.powerOn();
        computer2.powerOn();
        computer3.powerOn();
        computer4.powerOn();
    }

    // 모든 컴퓨터의 전원을 끄는 메소드
    void allPowerOff() {
        // `powerOff()` 메소드는 Samsung에서는 오버라이딩되지 않았고, LG에서는 오버라이딩되었습니다.
        // 따라서 Samsung 객체는 Computer의 powerOff()를, LG 객체는 LG의 powerOff()를 호출합니다.
        computer1.powerOff();
        computer2.powerOff();
        computer3.powerOff();
        computer4.powerOff();
    }
}
