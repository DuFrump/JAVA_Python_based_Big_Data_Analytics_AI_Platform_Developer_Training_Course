import java.util.ArrayList;
import java.util.List;

public class _04_ArrayList3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int temp = (int)(Math.random()*30) + 1;
            list.add(temp);
        }

        System.out.println("전체 데이터 : " + list);
//        System.out.println(list.get(2));

        // for문 돌려서 짝수만 뽑기
        System.out.print("짝수 : ");
        for (int i = 0; i < list.size(); i++) {
            int val = list.get(i);

            if (val % 2 == 0) {
                System.out.print(val + " ");
            }
        }
    }
}
