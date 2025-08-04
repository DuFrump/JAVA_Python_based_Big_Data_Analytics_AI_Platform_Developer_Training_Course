package _03_Inheritance_computer;

public class Samsung extends Computer {
    @Override
    void powerOn() {
        super.powerOn();
        System.out.println("!I love Samsung!");
    }
}
