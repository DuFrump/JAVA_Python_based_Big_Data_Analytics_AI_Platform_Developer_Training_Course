import java.util.ArrayList;
import java.util.Collections;

public class _06_ArrayList4 {
    public static void main(String[] args) {
        int[] array = new int[3];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        // 간단하다, 단순하다
        // 크기가 정해져있어서 맘대로 늘리거나 줄일 수 없다.

        // 컬렉션 프레임워크 (List.... Set, Map)
        ArrayList<String> list = new ArrayList<>();

        // 데이터 추가
        list.add("홍길동");
        list.add("박명수");
        list.add("정형돈");
        list.add("강호동");
        list.add("김종국");

        // 데이터 조회 (인덱스 기준)
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));

        System.out.println("----------------------");

        // 데이터 삭제
        System.out.println("신청 학생 수 : " + list.size());
        // 명수가 이사를 갔습니다.
        list.remove("박명수");
        System.out.println("남은 신청 학생 수 : " + list.size());
        System.out.println("인덱스 1번은 누구? : " + list.get(1));

        System.out.println("----------------------");

        list.remove(list.size() - 1);
        System.out.println(list.size());

        System.out.println("----------------------");

        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("전체 학생 : " + list);

        System.out.println("----------------------");

        // 변경
        System.out.println("수강권 양도 전 : " + list.get(0));
        list.set(0, "이수근");
        System.out.println("수강권 양도 후 : " + list.get(0));

        // 확인 indexOf, contains
        System.out.println("정형돈 몇 번? " + list.indexOf("정형돈") + "번");

        // 정형돈이 포함이 되어있나?
        if (list.contains("정형돈") == true) {
            System.out.println("정형돈이 포함 되어있습니다.");
        } else {
            System.out.println("정형돈 없음");
        }

        System.out.println("----------------------");

        // 전체 삭제
        list.clear();
        if (list.isEmpty()) {
            System.out.println("리스트가 비어있습니다.");
            System.out.println("리스트 사이즈는 : " + list.size());
        }

        System.out.println("-----------------------");

        // 다음 학기에 새로 공부를 시작
        list.add("레이첼");
        list.add("피비");
        list.add("모니카");
        list.add("조이");
        list.add("챈들러");
        list.add("테리");
        list.add("로스");

        System.out.println("전체 학생 : " + list);

        // 가나다 순으로 정렬
        Collections.sort(list);
        System.out.println("정렬 후 : " + list);
    }
}
