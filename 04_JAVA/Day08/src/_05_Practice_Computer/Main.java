package _05_Practice_Computer;

public class Main {
    public static void main(String[] args) {
        ComputerRoom cr1 = new ComputerRoom();

//        cr1.computer1 = new Samsung(); <====  Samsung computer1 = new Samsung();
//        cr1.computer2 = new Samsung();
//        cr1.computer1 = new LG();  <========  LG computer1 = new LG();
//        cr1.computer2 = new LG();

        cr1.computer1 = new Samsung(); // <==   Computer computer1 = new Computer();
        cr1.computer2 = new LG();
        cr1.computer3 = new Samsung();
        cr1.computer4 = new LG();


        cr1.allPowerOn();
        cr1.allPowerOff();

    }
}
