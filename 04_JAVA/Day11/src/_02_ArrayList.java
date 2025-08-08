import java.util.ArrayList;
import java.util.List;

public class _02_ArrayList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("딸기");
        list.add("바나나");
        list.add("망고");

        System.out.println("리스트 내용 1 : " + list);

        list.add(2, "수박");

        System.out.println("리스트 내용 2 : " + list);

        list.set(1, "복숭아");
        list.set(0, "파인애플");

        System.out.println("리스트 내용 3 :" + list);
    }
}
