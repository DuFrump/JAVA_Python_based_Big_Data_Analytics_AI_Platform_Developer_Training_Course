import java.util.HashSet;

public class _08_HashSet {
    public static void main(String[] args) {
        // 세트
        HashSet<String> set = new HashSet<>();
        set.add("삼겹살");
        set.add("쌈장");
        set.add("음료");
        set.add("야채");
        set.add("소금");
        set.add("삼겹살");
        set.add("후추");
        set.add("삼겹살");
        set.add("버섯");
        set.add("소주");

        System.out.println("총 구매 상품 수 : " + set.size());
        System.out.println("구매 리스트 : " + set);

        System.out.println("-----------------------------");

        // 확인
        if (set.contains("삼겹살")) {
            System.out.println("삼겹살 사러 가겠습니다.");
        }

        // 삭제, 사이즈
        System.out.println("목록 수 (삼겹살 구매 전) : " + set.size());
        set.remove("삼겹살");
        System.out.println("목록 수 (삼겹살 구매 후) : " + set.size());

        System.out.println("-----------------------------");

        // 전체 삭제
        set.clear();
        if (set.isEmpty()) {
            System.out.println("남은 목록 : " + set.size());
        }

        System.out.println("-----------------------------");

        // set은 중복, 순서가 보장이 안된다!!

        HashSet<Integer> inSet = new HashSet<>();
        inSet.add(1);
        inSet.add(14);
        inSet.add(4);
        inSet.add(60);
        inSet.add(43);
        inSet.add(65);
        inSet.add(12);
        inSet.add(23);
        inSet.add(8);

        System.out.println(inSet);
    }
}
