package _03_Inheritance_computer;

public class Main {
    public static void main(String[] args) {
        Samsung comp01 = new Samsung();

        comp01.powerOn();
        comp01.powerOff();


        Computer comp02 = new Computer();

        comp02.powerOn();
        comp02.powerOff();
    }
}
