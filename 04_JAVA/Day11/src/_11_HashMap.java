import java.util.HashMap;
import java.util.Map;

/**
 * Java 선생님:
 * 두프룸프님, 드디어 컬렉션의 마지막 주인공, 'Map'을 만날 시간입니다!
 * Map은 List나 Set과는 전혀 다른 방식으로 데이터를 저장해요. 바로 'Key'와 'Value'를 하나의 쌍으로 묶어서 저장하는 방식입니다.
 *
 * [비유로 이해하기]
 * - Map: "영한사전"을 떠올려보세요.
 *   - Key: 우리가 찾고 싶은 '영어 단어' (예: "Apple")
 *   - Value: 그 단어에 해당하는 '한국어 뜻' (예: "사과")
 *   사전에서 단어("Apple")를 찾으면 그 뜻("사과")이 나오는 것처럼, Map에서는 Key를 주면 Value를 얻을 수 있습니다.
 *
 * [Map의 핵심 특징]
 * 1. Key는 절대로 중복될 수 없습니다. (사전에 똑같은 영어 단어가 여러 개 있을 수 없죠?)
 * 2. Value는 중복될 수 있습니다. (여러 영어 단어가 같은 한국어 뜻을 가질 수는 있죠. 예: "Fall" -> "가을", "Autumn" -> "가을")
 * 3. List처럼 순서가 보장되지 않습니다. (HashMap의 경우)
 */
public class _11_HashMap {
    public static void main(String[] args) {
        // <Key의 타입, Value의 타입>을 제네릭으로 지정해줍니다.
        // 여기서는 <String, String>이므로 "영어 단어(String)로 한국어 뜻(String)을 찾겠다"는 의미입니다.
        Map<String, String> dictionary = new HashMap<>();

        // 1. 데이터 추가 (put)
        System.out.println("--- 1. 사전에 단어 추가하기 ---");
        // put(Key, Value) 메서드를 사용해 데이터를 추가합니다.
        dictionary.put("Spring", "봄");
        dictionary.put("Summer", "여름");
        dictionary.put("Fall", "가을");
        dictionary.put("Winter", "겨울");

        // 만약 이미 존재하는 Key값으로 새로운 Value를 put하면, 기존의 Value가 덮어쓰기 됩니다.
        System.out.println("'Fall'이라는 단어의 뜻을 '단풍'으로 수정합니다...");
        dictionary.put("Fall", "단풍");

        System.out.println("현재 사전: " + dictionary);

        // 2. 데이터 조회 (get)
        System.out.println("\n--- 2. 단어 뜻 찾아보기 ---");
        // get(Key) 메서드를 사용하면 해당 Key에 연결된 Value를 가져올 수 있습니다.
        System.out.println("'Summer'의 뜻은? " + dictionary.get("Summer"));
        System.out.println("'Apple'의 뜻은? " + dictionary.get("Apple")); // 사전에 없는 단어는 null을 반환합니다.

        // 3. 데이터 확인 (containsKey, containsValue)
        System.out.println("\n--- 3. 단어 존재 여부 확인 ---");
        System.out.println("사전에 'Winter'라는 단어가 있나요? " + dictionary.containsKey("Winter"));
        System.out.println("사전에 '봄'이라는 뜻이 있나요? " + dictionary.containsValue("봄"));

        // 4. 데이터 삭제 (remove)
        System.out.println("\n--- 4. 단어 삭제하기 ---");
        System.out.println("'Fall' 단어를 삭제합니다...");
        dictionary.remove("Fall");
        System.out.println("삭제 후 사전: " + dictionary);

        // 5. Map의 전체 데이터 순회하기 (★중요★)
        // Map은 List처럼 인덱스가 없어서 for-each문을 바로 쓸 수 없어요. 대신 3가지 방법을 사용합니다.
        System.out.println("\n--- 5. 사전에 있는 모든 단어와 뜻 출력하기 ---");

        // 방법 1: keySet() - Key 꾸러미를 먼저 얻고, 각 Key로 Value를 찾아오기
        // 가장 일반적으로 많이 사용하는 방법입니다.
        System.out.println("\n[방법 1] keySet() 활용");
        for (String key : dictionary.keySet()) { // keySet()은 모든 Key들을 Set 형태로 반환합니다.
            String value = dictionary.get(key);
            System.out.printf("단어: %-10s | 뜻: %s\n", key, value);
        }

        // 방법 2: values() - Value 꾸러미만 필요할 때
        System.out.println("\n[방법 2] values() 활용 (사전에 있는 모든 뜻만 출력)");
        for (String value : dictionary.values()) {
            System.out.print(value + " ");
        }
        System.out.println();

        // 방법 3: entrySet() - Key와 Value 쌍(Entry) 꾸러미를 얻어오기
        // Key와 Value를 동시에 가져오므로, get()을 한번 더 호출할 필요가 없어 가장 효율적입니다.
        System.out.println("\n[방법 3] entrySet() 활용 (가장 효율적!)");
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.printf("단어: %-10s | 뜻: %s\n", key, value);
        }

        /*
         * Java 선생님 최종 정리:
         * Map은 "뭔가를 찾을 때" 아주 유용한 자료구조입니다.
         * - 학생의 학번(Key)으로 학생 정보(Value)를 찾거나,
         * - 상품의 ID(Key)로 상품 상세 정보(Value)를 찾거나,
         * - 사용자의 ID(Key)로 로그인 정보(Value)를 찾는 등
         * Key를 통해 Value를 빠르게 찾아야 하는 거의 모든 상황에서 사용됩니다. 꼭 마스터해두세요!
         */
    }
}