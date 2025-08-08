import java.util.Arrays;
import java.util.List;

/**
 * Java 선생님:
 * 두프룸프님, 드디어 오늘 배움의 최종 목적지, '스트림(Stream)'에 도착했습니다!
 * 스트림은 "데이터 처리 파이프라인"이라고 생각하면 가장 이해하기 쉬워요.
 *
 * [비유로 이해하기]
 * - 스트림: "생수 공장의 생산 라인"
 *   1. 수원지에서 물을 끌어온다. (스트림 생성: .stream())
 *   2. 필터로 불순물을 거른다. (중간 연산: .filter())
 *   3. 미네랄을 첨가하는 등 가공한다. (중간 연산: .map())
 *   4. 병에 담는다. (최종 연산: .forEach(), .collect() 등)
 *
 * 이처럼, 스트림은 원본 데이터를 건드리지 않고, 데이터가 파이프라인을 흘러가면서
 * 여러 단계의 처리(중간 연산)를 거쳐, 최종적으로 우리가 원하는 결과물(최종 연산)을 만들어내는 기술입니다.
 * 코드가 간결해지고, "무엇을" 할 것인지에만 집중할 수 있게 도와주는 아주 강력한 도구죠.
 * 데이터/AI 분야에서는 대용량 데이터를 다룰 때 이 스트림을 자유자재로 사용하는 능력이 필수입니다!
 */
public class _15_Stream {
    public static void main(String[] args) {

        // --- 예제 1: 필터링 (Filtering) ---
        System.out.println("--- 예제 1: 리스트에서 짝수만 골라내기 ---");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream() // 1. 숫자 리스트를 데이터의 흐름(Stream)으로 만든다.
               .filter(n -> n % 2 == 0) // 2. [중간 연산] 짝수인지 검사(Predicate)해서, 조건을 통과하는 데이터만 남긴다.
               .forEach(System.out::println); // 3. [최종 연산] 남은 데이터들을 하나씩 화면에 출력(Consumer)한다.
                                              // System.out::println 은 s -> System.out.println(s) 와 똑같은 '메서드 참조' 문법입니다.

        // --- 예제 2: 변환 (Mapping) ---
        System.out.println("\n--- 예제 2: 모든 문자를 대문자로 바꾸기 ---");
        List<String> words = Arrays.asList("Java", "Lambda", "Stream");

        words.stream() // 1. 문자열 리스트를 스트림으로 만든다.
             .map(s -> s.toUpperCase()) // 2. [중간 연산] 각 문자열(s)을 대문자로 변환(Function)한 새로운 스트림을 만든다.
             .forEach(System.out::println); // 3. [최종 연산] 변환된 문자열들을 출력한다.

        // --- 예제 3: 필터링과 변환 조합 ---
        System.out.println("\n--- 예제 3: '김'씨 성을 가진 사람의 이름 길이만 출력하기 ---");
        List<String> names = Arrays.asList("김철수", "이영희", "박민지", "김민준");

        names.stream() // 1. 이름 리스트를 스트림으로 만든다.
             .filter(name -> name.startsWith("김")) // 2. [중간 연산] '김'으로 시작하는 이름만 남긴다.
             .map(name -> name.length()) // 3. [중간 연산] 남은 이름(String)들을 그 길이(Integer)로 변환한다.
             .forEach(nameLength -> System.out.println("이름 길이: " + nameLength)); // 4. [최종 연산] 변환된 길이들을 출력한다.

        // --- 예제 4: 개수 제한 (Limit) ---
        System.out.println("\n--- 예제 4: 3보다 큰 숫자 중, 앞의 2개만 출력하기 ---");
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        list3.stream()
             .filter(n -> n > 3) // 1. [4, 5, 6, 7, 8] 이 남는다.
             .limit(2)           // 2. [중간 연산] 그 중에서 앞에 2개만 잘라낸다. -> [4, 5]
             .forEach(System.out::println); // 3. [최종 연산] 4와 5를 출력한다.

        /*
         * Java 선생님 최종 정리:
         * 스트림은 마치 레고 블록을 조립하는 것과 같아요.
         * filter, map, limit 같은 다양한 기능(중간 연산) 블록들을 필요한 순서대로 연결해서
         * 내가 원하는 결과물을 만들어내는 거죠. 이 파이프라인 구조에 익숙해지는 것이 중요합니다.
         * 앞으로는 복잡한 for문과 if문 대신, 이 스트림을 사용해서 데이터를 우아하게 처리하는 연습을 계속해봅시다!
         */
    }
}