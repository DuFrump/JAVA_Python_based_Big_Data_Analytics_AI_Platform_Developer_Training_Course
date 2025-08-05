package _05_Practice_Computer;

public class LG extends Computer {
    @Override
    void powerOn() {
        super.powerOn();
        System.out.println("사랑해요! LG!");
    }

    @Override
    void powerOff() {
        super.powerOff();
        System.out.println("사랑해요! LG!");
    }
}
