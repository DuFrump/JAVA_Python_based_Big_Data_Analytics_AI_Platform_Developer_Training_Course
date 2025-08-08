import java.util.Collections;
import java.util.LinkedList;

public class _07_LinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("레이첼");
        list.add("피비");
        list.add("조이");
        list.add("모니카");
        list.add("테리");
        list.add("첸들러");
        list.add("로스");
        System.out.println("리스트 목록 : " + list);

        System.out.println("리스트 0 번째 : " + list.get(0));
        System.out.println("리스트 첫 번째 목록 : " + list.getFirst());
        System.out.println("리스트 마지막 목록 : " + list.getLast());

        System.out.println("---------------------");

        // 맨 앞에 추가 addFirst
        list.addFirst("마이클");
        System.out.println("맨 앞에 추가 후 리스트 목록 : " + list);

        // 지정 추가 add
        System.out.println("---------------------");
        list.add(1, "제니스");
        System.out.println("1번에 지정 추가 후 리스트 목록 : " + list);

        // 삭제
        System.out.println("---------------------");
        list.remove(4);
        System.out.println("4번 지정 삭제 후 리스트 목록 : " + list);

        // 처음 학생과 마지막 학생 전학
        System.out.println("-----------두 명 전학----------");
        list.removeFirst();
        list.removeLast();
        System.out.println("남은 학생 수 : " + list.size());
        System.out.println("남은 학생 목록 : " + list);

        // set indexOf contains clear isEmpty Collections.sort()
        System.out.println("------------------------------");
        list.set(3, "토니");
        list.indexOf("토니");
        System.out.println(list);
        System.out.println("토니는 " + list.indexOf("토니") + "번이다.");

        Collections.sort(list);
        System.out.println("정렬 후 리스트 목록 : " + list);

        if (list.contains("토니") == true) {
            System.out.println("토니는 포함되어 있습니다.");
        } else {
            System.out.println("토니는 포함되어 있지 않습니다.");
        }

        list.clear();
        System.out.println(list);

        if (list.isEmpty()) {
            System.out.println("리스트가 비어 있습니다.");
        }
    }
}
