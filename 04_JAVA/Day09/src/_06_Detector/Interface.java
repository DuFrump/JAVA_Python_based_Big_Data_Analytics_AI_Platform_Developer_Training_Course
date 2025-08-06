package _06_Detector;

public class Interface {
    public static void main(String[] args) {
        Detectable d1 = new FireDetector();
        d1.detect();

        Detectable d2 = new AdvancedFireDetector();
        d2.detect();

        Detectable d3 = new AccidentDetector();
        d3.detect();
    }
}
