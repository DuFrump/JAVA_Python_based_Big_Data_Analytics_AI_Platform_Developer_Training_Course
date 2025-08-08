import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class _05_ArrayVsLinked {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        LinkedList<Integer> linkedList = new LinkedList<>();

        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(i);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("ArrayList 추가 시간 : " + duration);

        // LinkedList 연속적으로 데이터 추가
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList 추가 시간 : " + duration);

        startTime = System.nanoTime();
        // ArrayList 선택적 삽입
        arrayList.add(99, 100);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList 삽입 시간 : " + duration);

        startTime = System.nanoTime();
        // LinkedList 선택적 삽입
        linkedList.add(99, 100);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList 삽입 시간 : " + duration);

        // ArrayList 지우기
        startTime = System.nanoTime();

        for (int i = 9999; i >= 0; i--) {
            arrayList.remove(i);
        }

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList 지운 시간 : " + duration);

        // LinkedList 지우기
        startTime = System.nanoTime();

        for (int i = 9999; i >= 0; i--) {
            linkedList.remove(i);
        }

        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList 지운 시간 : " + duration);
    }
}
