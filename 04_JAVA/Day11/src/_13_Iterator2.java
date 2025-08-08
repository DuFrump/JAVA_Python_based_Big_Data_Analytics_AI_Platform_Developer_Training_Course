import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Java 선생님:
 * 두프룸프님, 이번 시간은 Iterator의 존재 이유이자 가장 중요한 활용법을 배우는 시간입니다.
 * 바로 "컬렉션을 순회하면서 안전하게 요소를 삭제하는 방법"입니다.
 *
 * [상황]
 * 명단에 "알 수 없음" 이라는 잘못된 데이터들이 섞여있습니다.
 * 우리의 임무는, 명단을 쭉 훑어보면서 "알 수 없음"을 모두 제거하는 것입니다.
 */
public class _13_Iterator2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("유재석");
        list.add("알 수 없음");
        list.add("박명수");
        list.add("알 수 없음");
        list.add("정준하");
        list.add("알 수 없음");
        list.add("정형돈");

        System.out.println("--- 수정 전 명단 ---");
        System.out.println(list);

        // [잘못된 방법] for-each 문 안에서 list.remove() 호출하기
        // 아래 코드의 주석을 풀고 실행하면 "ConcurrentModificationException"이라는 무서운 오류가 발생합니다.
        /*
        for (String s : list) {
            if (s.equals("알 수 없음")) {
                list.remove(s); // 오류 발생!
            }
        }
        */
        // Java 선생님: 왜 오류가 날까요?
        // for-each문은 내부적으로 Iterator(탐험가)를 사용해서 리스트를 여행하고 있어요.
        // 그런데 여행 도중에 외부에서 직접 리스트(지도)의 내용을 수정(remove)해버리면,
        // 탐험가는 자기가 보고 있던 지도가 갑자기 바뀌어버려서 혼란에 빠지게 됩니다. (데이터 불일치)
        // Java는 이런 위험한 상황을 감지하고 예외(Exception)를 발생시켜 프로그램을 멈추는 거예요.


        // [올바른 방법] Iterator를 사용해서 안전하게 삭제하기
        // 이럴 때 "탐험가(Iterator)에게 직접 삭제를 요청"해야 합니다. 그래야 탐험가가 혼란에 빠지지 않아요.
        System.out.println("\n--- '알 수 없음' 데이터 삭제 중... ---");

        // 1. 탐험가(Iterator)를 얻습니다.
        Iterator<String> it = list.iterator();

        // 2. 탐험할 곳이 남아있는 동안 반복합니다.
        while (it.hasNext()) {
            // 3. ★★★★★ 중요 ★★★★★
            //    next()는 반드시 반복문 안에서 "한 번만" 호출해야 합니다.
            //    next()를 호출하는 순간, 탐험가는 다음 칸으로 이동하기 때문이에요.
            String s = it.next(); // 다음 요소를 꺼내서 s에 저장하고, 탐험가는 다음 위치로 이동.

            // 4. 꺼내온 값(s)이 "알 수 없음"과 같은지 확인합니다.
            if (s.equals("알 수 없음")) {
                // 5. 만약 같다면, 탐험가에게 "방금 네가 꺼내온 바로 그 요소를 삭제해줘!" 라고 요청합니다.
                it.remove();
            }
        }

        System.out.println("\n--- 수정 후 최종 명단 ---");
        System.out.println(list);

        /*
         * Java 선생님 최종 정리:
         * "리스트를 순회하면서 특정 요소를 삭제하고 싶다" 라는 생각이 들면,
         * 반사적으로 "아! Iterator의 remove()를 써야겠다!" 라고 떠올릴 수 있어야 합니다.
         * 이것은 Java 개발자들 사이의 매우 중요한 약속(Convention)이랍니다.
         */
    }
}