import java.util.Collections;
import java.util.LinkedList;

/**
 * Java 선생님:
 * 두프룸프님, 이번에는 ArrayList의 단짝 친구이자 경쟁자인 LinkedList에 대해 알아볼게요.
 * "기차"라는 비유를 다시 떠올려보세요. 각 데이터(칸)가 앞뒤로 손을 잡고(링크) 연결된 구조!
 * 이 구조적인 특징 때문에, LinkedList는 리스트의 맨 앞과 맨 뒤에서 무언가를 할 때 아주 강력한 성능을 보여줍니다.
 */
public class _07_LinkedList {
    public static void main(String[] args) {
        // 이번에는 LinkedList로 리스트를 만들어 봅시다.
        LinkedList<String> list = new LinkedList<>();

        // 데이터 추가 (add는 기본적으로 맨 끝에 추가됩니다. addLast와 같아요.)
        list.add("레이첼");
        list.add("피비");
        list.add("조이");
        list.add("모니카");
        list.add("챈들러"); // '첸들러' -> '챈들러'로 수정해볼게요!
        list.add("로스");
        System.out.println("초기 리스트: " + list);

        // 1. 맨 앞/뒤 데이터 조회 (LinkedList 전용 기능)
        System.out.println("\n--- 1. 맨 앞/뒤 데이터 조회 ---");
        // get(0)도 가능하지만, LinkedList는 맨 앞/뒤 데이터를 위한 전용 메서드가 있어요. 훨씬 직관적이죠?
        System.out.println("리스트의 첫 번째 학생: " + list.getFirst());
        System.out.println("리스트의 마지막 학생: " + list.getLast());

        // 2. 맨 앞/뒤에 데이터 추가 (LinkedList 전용 기능)
        System.out.println("\n--- 2. 맨 앞/뒤에 데이터 추가 ---");
        // 기차의 맨 앞에 새로운 칸을 연결하는 것은 매우 간단한 작업입니다.
        list.addFirst("마이클");
        System.out.println("맨 앞에 '마이클' 추가 후: " + list);

        // 맨 뒤에 추가하는 것은 add()와 동일하게 동작합니다.
        list.addLast("제니스");
        System.out.println("맨 뒤에 '제니스' 추가 후: " + list);

        // 3. 데이터 삭제 (removeFirst, removeLast)
        System.out.println("\n--- 3. 데이터 삭제 ---");
        System.out.println("첫 학생(" + list.getFirst() + ")과 마지막 학생(" + list.getLast() + ")이 전학갑니다...");
        list.removeFirst(); // 맨 앞 칸 떼어내기
        list.removeLast();  // 맨 뒤 칸 떼어내기
        System.out.println("두 명 전학 후 남은 학생: " + list);
        System.out.println("남은 학생 수: " + list.size());

        // 4. ArrayList와 공통된 기능들
        // set, indexOf, contains, sort 등은 ArrayList와 사용법이 완전히 동일합니다.
        // List 인터페이스가 이런 기능들을 미리 약속해두었기 때문이죠.
        System.out.println("\n--- 4. 공통 기능들 ---");
        System.out.println("3번 인덱스 학생(" + list.get(3) + ")을 '토니'로 변경합니다.");
        list.set(3, "토니");
        System.out.println("변경 후: " + list);

        System.out.println("토니 학생은 몇 번 자리에 있나요? " + list.indexOf("토니") + "번 자리");

        if (list.contains("토니")) {
            System.out.println("네, 토니는 명단에 포함되어 있습니다.");
        }

        System.out.println("\n가나다순으로 정렬합니다...");
        Collections.sort(list);
        System.out.println("정렬 후: " + list);

        System.out.println("\n모든 학생이 졸업했습니다!");
        list.clear();
        if (list.isEmpty()) {
            System.out.println("리스트가 비어 있습니다. 남은 학생 수: " + list.size());
        }

        /*
         * Java 선생님 최종 정리:
         * LinkedList는 리스트의 맨 앞 또는 맨 뒤에서 데이터 추가/삭제가 매우 빈번할 때 사용하면 좋습니다.
         * 예를 들어, 최근 본 상품 목록(계속 맨 앞에 추가)이나 작업 대기열(Queue) 같은 기능을 만들 때 유용하죠.
         * 하지만 일반적인 상황에서는 조회 속도가 빠른 ArrayList가 더 좋은 선택일 때가 많다는 점, 꼭 기억해주세요!
         */
    }
}