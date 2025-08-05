package _05_Practice_Computer;

public class ComputerRoom {
//    Samsung computer1;
//    Samsung computer2;
//    LG computer1;
//    LG computer2;

    Computer computer1;
    Computer computer2;
    Computer computer3;
    Computer computer4;

    void allPowerOn() {
        computer1.powerOn(); // 오버라이딩 해서 변형시킴
        computer2.powerOn();
        computer3.powerOn();
        computer4.powerOn();
    }

    void allPowerOff() {
        computer1.powerOff(); // 부모클래스에 있는 메서드
        computer2.powerOff();
        computer3.powerOff();
        computer4.powerOff();
    }
}
