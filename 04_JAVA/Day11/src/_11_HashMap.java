import java.util.HashMap;
import java.util.Map;

public class _11_HashMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("Spring", "봄");
        map.put("Summer", "여름");
        map.put("Fall", "가을");
        map.put("Winter", "겨울");

        map.put("spring", "용수철");
        map.put("Autumn", "가을");

        System.out.println(map);

        map.remove("Autumn");

        System.out.println(map);

        // 특정 키가 존재 하는지
        System.out.println(map.containsKey("Spring"));
        // 특정 밸류가 존재 하는지
        System.out.println(map.containsValue("얼음"));
        // Key에 해당하는 값 불러오기
        System.out.println(map.get("Summer"));


        // 전체 삭제
        map.clear();
        if (map.isEmpty()) {
            System.out.println("현재 맵 리스트가 비어있습니다.");
            System.out.printf("남은 데이터 수 : %d%n", map.size());
        }

        // 리스트 다시 채워넣기
        map.put("조이", "배우");
        map.put("챈들러", "회사원");
        map.put("로스", "교수");
        map.put("테리", "개발자");
        map.put("레이첼", "디자이너");
        map.put("모니카", "요리사");
        map.put("피비", "마사지사");

        System.out.println(map);

        System.out.println("--------------------------------------");
        // key 값 확인
        for (String key : map.keySet()) {
            System.out.print(key + " ");
        }

        System.out.println();
        System.out.println("--------------------------------------");

        // value 값 확인
        for (String value : map.values()) {
            System.out.print(value + " ");
        }

        System.out.println();
        System.out.println("--------------------------------------");

        // key와 value 함께 뽑아내기
        for (String key : map.keySet()) {
            System.out.println("이름 : " + key + "\t\t직업 : " + map.get(key));
        }
    }
}
