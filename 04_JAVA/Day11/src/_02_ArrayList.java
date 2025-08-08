import java.util.ArrayList;
import java.util.List;

/**
 * Java 선생님:
 * 두프룸프님, 이제부터는 Java가 우리를 위해 미리 만들어 놓은 강력한 도구, '컬렉션 프레임워크'를 배워볼 거예요.
 * 그 첫 번째 주자는 바로 'ArrayList'입니다!
 *
 * 'ArrayList'는 이름 그대로 '배열(Array)'과 '리스트(List)'의 특징을 합친 거예요.
 * 일반 배열은 처음에 크기를 정하면 바꿀 수 없어서 불편했죠?
 * ArrayList는 마치 "고무줄처럼 길이가 자유자재로 늘어나는 똑똑한 배열"이라고 생각하면 쉬워요.
 * 데이터를 추가하면 알아서 공간을 늘리고, 삭제하면 공간을 줄여줍니다. 정말 편리하죠?
 */
public class _02_ArrayList {
    public static void main(String[] args) {

        // Java 선생님: ArrayList를 만드는 가장 표준적인 방법입니다.
        // List<String> list = new ArrayList<>();
        //
        // 1. List<String> : "앞으로 이 변수(list)는 문자열(String)만 담는 리스트(List)의 규칙을 따를 겁니다" 라는 선언이에요.
        //    List는 인터페이스(규칙, 설계도)입니다. "리스트라면 이런 기능들은(add, get, set, remove 등) 반드시 있어야 해!" 라고 정해놓은 약속이죠.
        //
        // 2. new ArrayList<>(): "그 규칙을 실제로 구현한 것들 중에서, 저는 ArrayList 방식으로 만들겠습니다!" 라는 의미예요.
        //    마치 "자동차(List)를 살 건데, 모델은 아반떼(ArrayList)로 주세요" 하는 것과 같아요.
        //    이렇게 인터페이스(List)로 선언하고 구현체(ArrayList)로 생성하는 습관을 들이면, 나중에 다른 리스트(LinkedList 등)로 쉽게 바꿀 수 있는 유연한 코드가 된답니다.
        List<String> list = new ArrayList<>();

        // 1. 데이터 추가 (add)
        // 리스트의 맨 끝에 순서대로 데이터를 추가합니다.
        System.out.println("--- 1. add: 데이터 순차적 추가 ---");
        list.add("딸기");   // [딸기]
        list.add("바나나"); // [딸기, 바나나]
        list.add("망고");   // [딸기, 바나나, 망고]

        // list.toString()이 자동으로 호출되어 내용물이 예쁘게 출력됩니다.
        System.out.println("현재 리스트: " + list);

        // 2. 특정 위치에 데이터 추가 (add with index)
        // add(index, element)는 특정 위치(index)에 데이터를 끼워 넣습니다.
        // 기존에 있던 데이터들은 뒤로 한 칸씩 밀려나요.
        System.out.println("\n--- 2. add(index, element): 데이터 중간에 삽입 ---");
        System.out.println("2번 인덱스에 '수박'을 추가합니다...");
        list.add(2, "수박"); // [딸기, 바나나, 수박, 망고]
                               // 원래 2번 인덱스에 있던 '망고'가 3번으로 밀려났어요.

        System.out.println("현재 리스트: " + list);

        // 3. 데이터 변경 (set)
        // set(index, element)는 특정 위치(index)의 데이터를 새로운 데이터로 '교체'합니다.
        // add처럼 끼워 넣는 게 아니라, 덮어쓰는 거예요. 리스트의 전체 크기는 변하지 않아요.
        System.out.println("\n--- 3. set: 데이터 교체 ---");
        System.out.println("1번 인덱스를 '복숭아'로, 0번 인덱스를 '파인애플'로 교체합니다...");
        list.set(1, "복숭아");    // [딸기, 복숭아, 수박, 망고] -> '바나나'가 '복숭아'로 변경됨
        list.set(0, "파인애플"); // [파인애플, 복숭아, 수박, 망고] -> '딸기'가 '파인애플'로 변경됨

        System.out.println("최종 리스트: " + list);
    }
}