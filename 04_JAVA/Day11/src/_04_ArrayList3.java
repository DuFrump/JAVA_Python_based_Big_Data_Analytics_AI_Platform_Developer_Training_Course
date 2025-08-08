import java.util.ArrayList;
import java.util.List;

/**
 * Java 선생님:
 * 두프룸프님, 이번 예제는 정말 중요해요. 리스트에 담겨있는 데이터들을 하나씩 꺼내서
 * 우리가 원하는 조건에 맞는 값들만 골라내는 방법을 배울 거거든요.
 * 이건 마치 "과일 바구니에서 사과만 골라내기" 같은 작업으로, 모든 프로그래밍의 기본이 되는 로직입니다.
 */
public class _04_ArrayList3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        // 1. 데이터 준비
        // 1부터 30까지의 숫자 중, 무작위로 10개를 뽑아서 리스트에 추가합니다.
        // Math.random()은 0.0 이상 1.0 미만의 실수를 반환해요.
        // 여기에 30을 곱하면 0.0 ~ 29.99... 가 되고, 1을 더하면 1.0 ~ 30.99... 가 됩니다.
        // 마지막으로 (int)로 형변환해서 소수점을 버리면 1 ~ 30 사이의 정수를 얻을 수 있죠.
        for (int i = 0; i < 10; i++) {
            int temp = (int)(Math.random()*30) + 1;
            list.add(temp);
        }

        System.out.println("전체 데이터 : " + list);

        // 2. 짝수만 골라내기
        // 이제 이 리스트에서 짝수만 골라서 출력해볼 거예요. 세 가지 방법을 보여드릴게요.

        // 방법 1: 가장 기본적인 for문 사용 (C언어 스타일)
        // 인덱스를 직접 다루기 때문에, 특정 위치의 값을 변경하거나 삭제할 때 유용합니다.
        System.out.print("\n방법 1 (기본 for문) - 짝수 : ");
        for (int i = 0; i < list.size(); i++) { // i가 0부터 리스트 크기보다 작을 때까지 1씩 증가하며 반복
            int val = list.get(i); // i번째 인덱스의 값을 하나씩 꺼내와서 val에 저장

            if (val % 2 == 0) { // val을 2로 나눈 나머지가 0이면 짝수!
                System.out.print(val + " ");
            }
        }
        System.out.println(); // 줄바꿈

        // 방법 2: 향상된 for문 (for-each) 사용
        // 인덱스가 필요 없고, 리스트의 모든 요소를 처음부터 끝까지 순회하기만 할 때 아주 편리해요. 코드가 훨씬 깔끔해지죠.
        System.out.print("방법 2 (향상된 for문) - 짝수 : ");
        for (int val : list) { // "list 안에 있는 모든 요소를 처음부터 하나씩 val에 담아서 반복해줘" 라는 의미
            if (val % 2 == 0) {
                System.out.print(val + " ");
            }
        }
        System.out.println();

        // 방법 3: Java 8 스트림(Stream) API 사용 (★가장 중요★)
        // Java 선생님: 두프룸프님이 앞으로 데이터/AI 분야로 나아가려면 이 방법과 반드시 친해져야 해요!
        // 스트림은 "데이터의 흐름"을 만들어서, 물 흐르듯이 데이터를 처리하는 기법입니다.
        // 코드가 간결해지고, 데이터를 병렬로 처리하여 성능을 높이는 데에도 유리해요.
        System.out.print("방법 3 (스트림 API) - 짝수 : ");
        list.stream() // 1. 리스트를 스트림(데이터의 흐름)으로 변환
            .filter(val -> val % 2 == 0) // 2. filter: 흐름을 통과하는 데이터 중 조건(짝수)에 맞는 것만 남김 (필터링)
            .forEach(val -> System.out.print(val + " ")); // 3. forEach: 필터링된 데이터 각각에 대해 출력 작업을 수행

        System.out.println("\n\nJava 선생님: 세 방법 모두 결과는 같지만, 코드가 어떻게 변하는지 느껴지시나요?");
        System.out.println("특히 스트림 방식은 '무엇을' 할 것인지(짝수 필터링, 출력)에만 집중하게 해줘서 가독성이 높답니다.");
    }
}