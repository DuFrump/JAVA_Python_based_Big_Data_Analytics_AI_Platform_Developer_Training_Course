package ClassBlackbox;

public class _07_Constructor {
    public static void main(String[] args) {
        BlackBox b1 = new BlackBox();
        b1.modelName = "까망이";
        b1.resolution = "FHD";
        b1.price = 200000;
        b1.color = "블랙";
        System.out.println(b1.modelName);
        System.out.println(b1.serialNumber);

        System.out.println("------------------------------------------");

        BlackBox b2 = new BlackBox();
        BlackBox b3 = new BlackBox();
        BlackBox b4 = new BlackBox();
        BlackBox b5 = new BlackBox();

        System.out.println("------------------------------------------");

        BlackBox b6 = new BlackBox("핑퐁이", "UHD", 300000, "분홍");
        System.out.println(b2.modelName);
        System.out.println(b2.resolution);
        System.out.println(b2.price);
        System.out.println(b2.color);
        System.out.println(b2.serialNumber);

        System.out.println("총 출고 대수 : " + BlackBox.counter);
    }
}
