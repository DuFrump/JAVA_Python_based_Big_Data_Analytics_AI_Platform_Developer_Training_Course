import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Java 선생님:
 * 두프룸프님, 이번에는 새로운 종류의 컬렉션인 'Set'에 대해 배워볼 거예요.
 * Set을 가장 잘 표현하는 단어는 "집합"입니다. 수학 시간에 배운 집합의 두 가지 중요한 특징, 기억나시나요?
 * 1. 원소의 중복을 허용하지 않는다.
 * 2. 원소 사이에 순서가 없다.
 * Java의 Set, 특히 HashSet은 이 특징을 그대로 가지고 있어요.
 *
 * [비유로 이해하기]
 * - Set: "복주머니"나 "장바구니" 같아요. 필요한 물건들을 그냥 막 담아요. (순서 없음)
 *        이미 주머니에 있는 물건을 또 넣으려고 하면, 그냥 "어차피 있네" 하고 무시해요. (중복 불가)
 * - List: "번호표가 있는 사물함" 같아요. 0번 사물함, 1번 사물함... 순서대로 물건을 넣죠. (순서 있음)
 *         같은 물건이라도 다른 사물함에 넣으면 별개의 것으로 취급해요. (중복 허용)
 *
 * 아래 예제를 통해 Set의 특징을 알아봅시다!
 */
public class _08_HashSet {
    public static void main(String[] args) {
        // Set도 List처럼 인터페이스로 선언하고, HashSet 구현체로 생성하는 것이 좋은 습관입니다.
        Set<String> set = new HashSet<>();

        // 1. 데이터 추가 (add)
        System.out.println("--- 1. 장바구니에 물건 담기 ---");
        set.add("삼겹살");
        set.add("쌈장");
        set.add("음료");
        set.add("야채");
        set.add("소금");
        System.out.println("현재 장바구니: " + set);

        // 이미 들어있는 "삼겹살"을 또 추가해 봅시다.
        System.out.println("\n'삼겹살'을 또 추가해볼게요...");
        set.add("삼겹살"); // 이 코드는 무시됩니다. Set은 중복을 허용하지 않으니까요!
        set.add("후추");
        set.add("삼겹살"); // 이것도 무시!
        set.add("버섯");

        // 2. 크기 확인 (size)
        // "삼겹살"을 여러 번 추가했지만, 실제로는 한 개만 들어간 것으로 취급됩니다.
        System.out.println("\n--- 2. 장바구니 확인 ---");
        System.out.println("총 구매할 상품 종류: " + set.size() + "가지");

        // 3. 순서가 보장되지 않음
        // 데이터를 추가한 순서와 실제 출력되는 순서가 다른 것을 확인하세요.
        // HashSet은 내부적으로 '해시(hash)'라는 복잡한 방법으로 데이터를 저장하기 때문에 순서를 따지지 않아요.
        // 그 대신, 데이터가 얼마나 많은지와 상관없이 "이 물건이 장바구니에 있나?" (contains)를 매우 빠르게 확인할 수 있습니다.
        System.out.println("최종 장바구니 목록: " + set);

        // 4. 데이터 포함 확인 (contains)
        System.out.println("\n--- 3. 특정 상품 확인 및 삭제 ---");
        if (set.contains("삼겹살")) {
            System.out.println("네, 삼겹살은 이미 목록에 있습니다.");
        }

        // 5. 데이터 삭제 (remove)
        System.out.println("삼겹살을 구매했습니다...");
        set.remove("삼겹살");
        System.out.println("구매 후 남은 목록: " + set);
        System.out.println("남은 상품 종류: " + set.size() + "가지");

        // 6. 전체 삭제 (clear)
        set.clear();
        if (set.isEmpty()) {
            System.out.println("\n장바구니를 모두 비웠습니다. 남은 목록: " + set.size());
        }

        System.out.println("\n--------------------------------------");
        System.out.println("Java 선생님의 추가 설명: 정렬되는 Set도 있을까요?");
        System.out.println("네! 그럴 땐 TreeSet을 사용하면 됩니다.");

        // TreeSet은 데이터를 추가할 때마다 자동으로 오름차순 정렬을 해주는 아주 착한 Set이에요.
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(5);
        treeSet.add(100);
        treeSet.add(1);
        treeSet.add(5); // 중복된 5는 무시됩니다.

        System.out.println("HashSet (순서 없음): " + new HashSet<>(treeSet));
        System.out.println("TreeSet (자동 정렬): " + treeSet);

        /*
         * Java 선생님 최종 정리:
         * - List: 순서가 중요하고, 데이터 중복이 허용될 때 사용. (게시판 글 목록, 학생 명단 등)
         * - Set: 중복을 막아야 하고, 순서가 중요하지 않을 때 사용. (사용자의 권한 목록, 추천 상품 목록 등)
         * 상황에 맞는 컬렉션을 선택하는 것이 데이터 처리의 첫걸음입니다!
         */
    }
}