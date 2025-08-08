import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Java 선생님:
 * 두프룸프님, 이번에는 컬렉션의 요소를 순회하는 또 다른 방법인 'Iterator(반복자)'에 대해 배워볼게요.
 * 지금은 우리가 for-each문을 더 즐겨 쓰지만, Iterator는 Java 컬렉션 프레임워크의 아주 근본이 되는 중요한 개념입니다.
 * 특히, 컬렉션을 순회하면서 안전하게 요소를 삭제해야 할 때 반드시 필요하답니다.
 *
 * [비유로 이해하기]
 * - Iterator: "컬렉션 탐험가"라고 생각해보세요. 이 탐험가는 리스트나 셋 같은 데이터 묶음을 처음부터 끝까지 여행합니다.
 *   - 탐험가는 항상 "다음 탐험할 곳이 남아있나?" (hasNext()) 라고 먼저 확인해요.
 *   - 남아있다면, "다음 장소로 이동해서 보물을 꺼내온다!" (next()) 행동을 하죠.
 *   - 이 과정을 더 이상 탐험할 곳이 없을 때까지 반복하는 거예요.
 */
public class _12_Iterator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10); list.add(20); list.add(30); list.add(40); list.add(50);
        System.out.println("탐험할 리스트: " + list);

        // 1. Iterator(탐험가) 얻기
        // 모든 컬렉션(List, Set 등)은 iterator() 메서드를 가지고 있어요.
        // 이 메서드를 호출해서 해당 컬렉션 전용 탐험가를 얻어옵니다.
        System.out.println("\n리스트 탐험을 시작합니다!");
        Iterator<Integer> iter = list.iterator();

        // 2. while문과 함께 탐험 시작
        // "다음 탐험할 곳이 있는 동안(while) 계속 탐험한다" 라는 의미의 코드를 작성합니다.
        while (iter.hasNext()) { // hasNext(): 다음에 꺼낼 데이터가 있으면 true, 없으면 false를 반환.
            // next(): 다음 데이터를 실제로 꺼내오고, 탐험가는 다음 위치로 한 칸 이동합니다.
            int val = iter.next();
            System.out.println("탐험가가 발견한 보물: " + val);
        }

        System.out.println("\n탐험 종료! 모든 보물을 발견했습니다.");

        // Java 선생님의 추가 팁!
        // Iterator는 일회용이에요. 한번 끝까지 탐험하고 나면 다시 처음으로 돌아갈 수 없어요.
        // 만약 다시 순회하고 싶다면, 새로운 탐험가(Iterator)를 다시 얻어와야 합니다.
        System.out.println("탐험이 끝난 탐험가에게 다시 물어보면? hasNext() -> " + iter.hasNext()); // false

        /*
         * Java 선생님 최종 정리:
         * for-each문은 사실 내부적으로 이 Iterator를 사용해서 동작하는, 편리한 버전(Syntactic Sugar)입니다.
         * 평소에는 for-each문을 쓰는 게 편하지만, 다음 예제에서 배울 "순회 중 안전한 삭제"를 위해서는
         * Iterator의 동작 원리를 반드시 이해하고 있어야 합니다. 이 탐험가의 세 가지 행동(hasNext, next, remove)을 꼭 기억해주세요!
         */
    }
}