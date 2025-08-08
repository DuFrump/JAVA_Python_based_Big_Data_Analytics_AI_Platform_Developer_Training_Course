import java.util.ArrayList;
import java.util.Collections;

/**
 * Java 선생님:
 * 두프룸프님, 이번 예제는 ArrayList의 유용한 기능들을 총정리하는 시간이에요.
 * 지금까지 배운 것들을 복습하고, 몇 가지 새로운 기술들을 더 배워서 ArrayList를 자유자재로 다뤄봅시다!
 */
public class _06_ArrayList4 {
    public static void main(String[] args) {
        // 컬렉션 프레임워크를 사용하기 전, 일반 배열의 한계를 다시 한번 생각해봅시다.
        int[] array = new int[3];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        // 단순하고 빠르지만, 크기가 고정되어 있어 유연하지 못했죠.

        // 그래서 우리는 고무줄처럼 유연한 ArrayList를 사용합니다!
        ArrayList<String> list = new ArrayList<>();

        // 1. 데이터 추가 (add)
        System.out.println("--- 1. 수강 신청 명단 ---");
        list.add("홍길동");
        list.add("박명수");
        list.add("정형돈");
        list.add("강호동");
        list.add("김종국");
        System.out.println("초기 신청 학생: " + list);

        // 2. 데이터 삭제 (remove)
        System.out.println("\n--- 2. 데이터 삭제 ---");
        System.out.println("현재 신청 학생 수 : " + list.size());

        // remove()는 두 가지 방법으로 사용할 수 있어요.
        // (1) remove(index): 특정 위치의 학생을 삭제 (지난 예제에서 배움)
        // (2) remove(Object): 특정 이름을 가진 학생을 직접 찾아서 삭제. 훨씬 직관적이죠?
        System.out.println("박명수 학생이 이사를 갔습니다...");
        list.remove("박명수");
        System.out.println("남은 신청 학생 수 : " + list.size());
        System.out.println("삭제 후 1번 인덱스는 누구? : " + list.get(1) + " (정형돈 학생이 앞으로 당겨졌네요)");

        // 마지막 학생을 삭제하고 싶을 땐 이렇게 응용할 수 있어요.
        // list.size()가 4이므로, 마지막 인덱스는 3. 즉 list.size() - 1 입니다.
        System.out.println("\n마지막 학생(" + list.get(list.size() - 1) + ")이 수강을 포기했습니다...");
        list.remove(list.size() - 1);
        System.out.println("최종 학생 명단: " + list);

        // 3. 데이터 변경 (set)
        System.out.println("\n--- 3. 데이터 변경 ---");
        System.out.println("수강권 양도 전 0번 학생: " + list.get(0));
        list.set(0, "이수근"); // 0번 인덱스의 "홍길동"을 "이수근"으로 교체
        System.out.println("수강권 양도 후 0번 학생: " + list.get(0));
        System.out.println("현재 학생 명단: " + list);

        // 4. 데이터 검색 (indexOf, contains)
        System.out.println("\n--- 4. 데이터 검색 ---");
        // indexOf(Object): 학생의 이름으로 몇 번 인덱스에 있는지 확인할 수 있어요.
        System.out.println("정형돈 학생은 몇 번 자리에 있나요? " + list.indexOf("정형돈") + "번 자리");

        // contains(Object): 특정 학생이 명단에 있는지 없는지 (true/false) 확인할 수 있어요.
        System.out.println("명단에 정형돈 학생이 있나요?");
        if (list.contains("정형돈")) { // if (true) 와 같음
            System.out.println("네, 포함되어 있습니다.");
        } else {
            System.out.println("아니요, 없습니다.");
        }

        // 5. 전체 삭제 및 비어있는지 확인 (clear, isEmpty)
        System.out.println("\n--- 5. 전체 삭제 및 확인 ---");
        list.clear(); // 모든 학생이 수강을 취소했습니다.
        System.out.println("clear() 후 명단: " + list);

        // isEmpty(): 리스트가 텅 비었는지 (true/false) 확인합니다.
        if (list.isEmpty()) {
            System.out.println("리스트가 비어있습니다. 현재 학생 수: " + list.size());
        }

        // 6. 정렬 (Collections.sort)
        System.out.println("\n--- 6. 정렬 ---");
        System.out.println("다음 학기 수강생들이 신청했습니다.");
        list.add("레이첼");
        list.add("피비");
        list.add("모니카");
        list.add("조이");
        list.add("챈들러");
        list.add("로스");
        System.out.println("신청 순서: " + list);

        // Collections는 컬렉션을 다루는 데 유용한 도구들을 모아놓은 클래스예요.
        // Collections.sort(list)는 리스트를 가나다순(오름차순)으로 예쁘게 정렬해줍니다.
        Collections.sort(list);
        System.out.println("가나다순 정렬 후: " + list);
    }
}