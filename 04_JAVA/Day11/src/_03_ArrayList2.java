import java.util.ArrayList;
import java.util.List;

/**
 * Java 선생님:
 * 두프룸프님, 이번에는 ArrayList의 다른 중요한 기능들을 배워볼게요.
 * 데이터를 넣었으니, 이제 꺼내고(get), 개수를 세고(size), 삭제하는(remove) 방법을 알아야겠죠?
 */
public class _03_ArrayList2 {
    public static void main(String[] args) {
        // 이번에는 정수(Integer)를 담는 ArrayList를 만들어 보겠습니다.
        List<Integer> list = new ArrayList<>();

        // for문을 사용해서 리스트에 2의 배수를 9개 담아볼게요. (2, 4, 6, ..., 18)
        for (int i = 1; i < 10; i++ ) {
            int temp = 2 * i;
            list.add(temp);
        }

        System.out.println("--- 초기 리스트 상태 ---");
        System.out.println("리스트 내용: " + list);

        // 1. 데이터 조회 (get)
        // get(index) 메서드는 해당 위치의 데이터를 반환합니다. 인덱스는 0부터 시작하는 것, 잊지 마세요!
        System.out.println("\n--- 1. get: 데이터 조회 ---");
        System.out.println("0번 인덱스의 값: " + list.get(0)); // 맨 앞의 값
        System.out.println("3번 인덱스의 값: " + list.get(3));

        // 2. 리스트 크기 확인 (size)
        // size() 메서드는 리스트에 들어있는 데이터의 총 개수를 알려줍니다.
        System.out.println("\n--- 2. size: 리스트 크기 확인 ---");
        System.out.println("현재 리스트의 크기: " + list.size());

        // 3. 데이터 삭제 (remove)
        // remove(index)는 특정 위치의 데이터를 삭제합니다.
        // 데이터가 삭제되면, 그 뒤에 있던 데이터들이 앞으로 한 칸씩 당겨져서 빈자리를 메웁니다.
        // 그래서 리스트의 인덱스가 재조정돼요. 이건 매우 중요한 특징입니다!
        System.out.println("\n--- 3. remove: 데이터 삭제 ---");
        System.out.println("3번 인덱스의 값(" + list.get(3) + ")을 삭제합니다...");
        list.remove(3); // 3번 인덱스에 있던 '8'이 삭제됩니다.

        // [2, 4, 6, 8, 10, 12, 14, 16, 18] 에서 3번 인덱스인 8이 삭제되면,
        // [2, 4, 6, 10, 12, 14, 16, 18] 이 됩니다.
        // 원래 4번 인덱스였던 '10'이 새로운 3번 인덱스가 되었죠?
        System.out.println("삭제 후 리스트 내용: " + list);
        System.out.println("삭제 후 3번 인덱스의 값: " + list.get(3)); // 이제 10이 출력됩니다.
        System.out.println("삭제 후 리스트 크기: " + list.size()); // 크기가 1 줄었어요.

        // 4. 모든 데이터 삭제 (clear)
        // clear()는 리스트의 모든 요소를 한 번에 깨끗하게 지웁니다.
        System.out.println("\n--- 4. clear: 모든 데이터 삭제 ---");
        list.clear();
        System.out.println("clear() 후 리스트 내용: " + list);
        System.out.println("clear() 후 리스트 크기: " + list.size());
    }
}