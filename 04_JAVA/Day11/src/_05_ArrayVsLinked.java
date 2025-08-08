import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Java 선생님:
 * 두프룸프님, 이번 시간은 정말 정말 중요합니다. List 인터페이스의 대표적인 두 구현체,
 * ArrayList와 LinkedList가 어떻게 다르고, 언제 무엇을 써야 하는지 확실하게 알아볼 거예요.
 * 이건 마치 우리가 서울에서 부산을 갈 때, KTX를 탈지 비행기를 탈지 결정하는 것과 같아요.
 * 상황에 맞는 최적의 도구를 선택하는 능력은 뛰어난 개발자의 필수 덕목입니다!
 *
 * [비유로 이해하기]
 * - ArrayList: "아파트" 같아요. 각 집(데이터)이 101호, 102호, 103호... 처럼 연속된 주소(인덱스)를 가져요.
 *   - 장점: 주소(인덱스)만 알면 엘리베이터 타고 한 번에 찾아갈 수 있어요. (조회 속도 빠름 - get(i))
 *   - 단점: 중간에 한 집이 이사 가거나(삭제), 새로운 집이 끼어들면(삽입), 그 뒤에 있는 모든 집들이 주소를 바꾸고 이사를 해야 해요. (삽입/삭제 느림)
 *
 * - LinkedList: "기차" 같아요. 각 칸(데이터)이 앞뒤 칸과 손을 잡고(링크) 연결되어 있는 모습이에요.
 *   - 장점: 중간에 한 칸이 빠지거나(삭제) 새로운 칸이 끼어들 때(삽입), 그냥 앞뒤 칸과 잡은 손만 바꾸면 끝나요. 나머지 칸들은 가만히 있어도 되죠. (삽입/삭제 빠름)
 *   - 단점: 100번째 칸을 찾아가려면, 1번 칸부터 순서대로 하나씩 전부 거쳐가야 해요. (조회 속도 느림 - get(i))
 *
 * 아래 코드를 통해 이 비유가 실제 성능으로 어떻게 나타나는지 직접 확인해 봅시다!
 */
public class _05_ArrayVsLinked {
    public static void main(String[] args) {
        // 테스트를 위해 두 종류의 리스트를 준비합니다.
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long startTime, endTime, duration;

        System.out.println("--- [테스트 1] 순차적으로 데이터 100만 건 추가 ---");
        // 아파트(ArrayList)의 맨 끝, 기차(LinkedList)의 맨 끝에 계속 데이터를 추가하는 상황입니다.
        // 이런 경우에는 둘 다 기존 데이터의 이동이 없기 때문에 성능 차이가 거의 나지 않아요.

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList 순차 추가 시간 : " + duration);

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList 순차 추가 시간: " + duration);


        System.out.println("\n--- [테스트 2] 중간에 데이터 10만 건 삽입 ---");
        // 여기가 핵심입니다! 아파트 중간(500번 인덱스)에 계속 새로운 집을 끼워 넣는 상황이에요.
        // ArrayList는 삽입할 때마다 뒤에 있는 모든 데이터들이 한 칸씩 밀려나는 대규모 이사를 해야 해서 매우 느립니다.
        // 반면 LinkedList는 그냥 앞뒤 칸과 연결된 링크만 바꿔주면 되니 훨씬 빠르죠.

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(500, i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList 중간 삽입 시간 : " + duration);

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(500, i);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList 중간 삽입 시간: " + duration);
        System.out.println("-> LinkedList가 압도적으로 빠른 것을 확인할 수 있습니다!");

        System.out.println("\n--- [테스트 3] 중간 데이터 1만 건 삭제 ---");
        // 삽입과 마찬가지로, 중간의 데이터를 삭제할 때도 대규모 자리 이동이 필요한 ArrayList가 매우 불리합니다.

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.remove(500);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("ArrayList 중간 삭제 시간 : " + duration);

        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.remove(500);
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("LinkedList 중간 삭제 시간: " + duration);
        System.out.println("-> 역시 LinkedList가 훨씬 빠릅니다.");

        /*
         * Java 선생님 최종 정리:
         *
         * [ArrayList는 이럴 때 사용하세요!]
         * 1. 데이터 조회가 빈번하게 일어날 때 (get(i)을 많이 쓸 때)
         * 2. 데이터의 맨 끝에서만 추가/삭제가 일어날 때
         * -> 대부분의 일반적인 상황에서는 ArrayList가 더 좋은 선택인 경우가 많습니다.
         *
         * [LinkedList는 이럴 때 사용하세요!]
         * 1. 데이터의 중간에서 추가/삭제가 빈번하게 일어날 때 (add(i, e), remove(i)를 많이 쓸 때)
         * -> 데이터의 양이 매우 많고, 중간 삽입/삭제가 핵심 기능일 때 강력한 성능을 발휘합니다.
         *
         * 두프룸프님, 앞으로 어떤 List를 써야 할지 고민될 땐, "아파트와 기차" 비유를 꼭 떠올려보세요!
         */
    }
}