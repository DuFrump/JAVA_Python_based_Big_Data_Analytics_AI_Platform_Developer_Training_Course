import java.util.ArrayList;
import java.util.List;

public class _03_ArrayList2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < 10; i++ ) {
            int temp = 2 * i;
            list.add(temp);
        }

        System.out.println("리스트 값 : " + list);

        list.remove(3);

        System.out.println("리스트 값 : " + list);
    }
}
