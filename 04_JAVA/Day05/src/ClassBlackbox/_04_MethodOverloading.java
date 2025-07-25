package ClassBlackbox;

public class _04_MethodOverloading {
    public static void main(String[] args) {
        BlackBox b1 = new BlackBox();

        b1.modelName = "까망이";

        System.out.println("----------------------------------------");
        b1.record(false, false, 1);
        System.out.println("----------------------------------------");
        b1.record(true, false, 10);
        System.out.println("----------------------------------------");
        b1.record(true, true, 3);
        System.out.println("----------------------------------------");
        b1.record();
    }
}
