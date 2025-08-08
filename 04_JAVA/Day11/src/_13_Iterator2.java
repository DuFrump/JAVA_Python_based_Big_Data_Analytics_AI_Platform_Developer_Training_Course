import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _13_Iterator2 {
    public static void main(String[] args) {
        // 이터레이터

        List<String> list = new ArrayList<>();
        list.add("유재석");
        list.add("알 수 없음");
        list.add("박명수");
        list.add("알 수 없음");
        list.add("정준하");
        list.add("알 수 없음");
        list.add("정형돈");
        list.add("알 수 없음");
        list.add("하하");
        list.add("알 수 없음");
        list.add("노홍철");

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("------------------------------");

        Iterator<String> it = list.iterator();
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());


        System.out.println("------------------------------");


        it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            String s = it.next();
            if (s.contains("(알 수 없음)")) {
                it.remove(); // 삭제
            }
        }

        it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
