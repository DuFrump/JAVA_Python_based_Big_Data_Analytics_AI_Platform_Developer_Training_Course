package ClassBlackbox;

public class _08_GetterSetter {
    public static void main(String[] args) {
        BlackBox b1 = new BlackBox();

        b1.modelName = "까망이";
        b1.price = 200000;
        b1.color = "블랙";

        // 할인 행사~~
        b1.price -= 5000;
        System.out.println("가격 : " + b1.price);


        // 게터 세터
        b1.setPrice(200000);
        System.out.println(b1.getPrice());

        b1.setPrice(-5000);
        System.out.println(b1.getPrice());

        System.out.println("화질은 " + b1.getResolution());


        BlackBox b2 = new BlackBox("까망이", "FHD", 500000, "블랙");

        System.out.println(b2.getModelName());

        b2.setPrice(300000);

        System.out.println(b2.getPrice());
    }
}
