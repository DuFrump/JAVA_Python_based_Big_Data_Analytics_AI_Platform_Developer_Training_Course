import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _12_Iterator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            int temp = 2 * i;
            list.add(temp);
        }
        System.out.println(list);

        // 이터레이터 = 반복자

        Iterator<Integer> iter = list.iterator();
        int count = 0;

        while (iter.hasNext()) {
            int val = iter.next();
            System.out.println("list 데이터[" + (count++) + "] : " + val);
        }
    }


}
