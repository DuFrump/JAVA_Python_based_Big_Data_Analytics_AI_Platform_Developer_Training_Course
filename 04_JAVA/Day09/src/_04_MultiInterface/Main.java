package _04_MultiInterface;

public class Main {
    public static void main(String[] args) {
        BlueToothMIC bm = new BlueToothMIC();

        bm.music();
        bm.sing();

        Microphone m = bm;
        m.sing();
//        m.music();

        Speaker s = bm;
//        s.sing();
        s.music();
    }
}
