/**
 * 두프룸프님, 프로그래밍의 새로운 세계, '배열(Array)'에 오신 것을 환영합니다!
 * 지금까지는 변수 하나에 값 하나만 저장했죠? (ex: int num = 10;)
 * 하지만 만약 우리 반 학생 30명의 점수를 저장해야 한다면, 변수를 30개나 만들어야 할까요? 너무 힘들겠죠!
 *
 * 배열은 바로 이럴 때 사용하는 '데이터 보관함' 또는 '아파트' 같은 개념이에요.
 * 하나의 이름(배열 변수)으로, 같은 타입의 데이터 여러 개를 한 줄로 쭉~ 보관할 수 있는 공간이죠.
 * 각 데이터는 0번 방, 1번 방, 2번 방... 처럼 고유한 방 번호(인덱스, index)를 갖게 됩니다.
 * ★★★ 가장 중요한 점! 이 방 번호는 항상 0부터 시작한다는 사실! ★★★
 *
 * 이 예제에서는 배열을 왜 써야 하는지, 어떻게 만들고 사용하는지, 그리고 for문과 얼마나 찰떡궁합인지 알아볼 거예요.
 */
public class _08_Array {
    public static void main(String[] args) {
        // [1] 만약 배열이 없다면? -> 변수를 일일이 만들어야 해서 너무 불편해요.
        String name1 = "김두프";
        String name2 = "박루프";
        String name3 = "이프룸";
        // ... 30명이면 30개 만들어야 함 ...
        System.out.println(name1 + "님 안녕하세요!");
        System.out.println(name2 + "님 안녕하세요!");
        System.out.println(name3 + "님 안녕하세요!");

        System.out.println("\n----------------------------------------\n");

        // [2] 배열 사용하기 (선언과 동시에 값 목록을 넣어주기)
        // String 타입의 데이터를 담을 수 있는, 방 3개짜리 아파트(배열)를 짓고 바로 입주시키는 것과 같아요.
        String[] names = {"김두프", "박루프", "이프룸"};

        // 배열의 각 방(요소)에 접근할 때는 `배열이름[방번호]` 형식을 사용해요.
        // 방 번호(인덱스)는 0부터 시작하는 것, 절대 잊지 마세요!
        System.out.println(names[0] + "님 안녕하세요!"); // 0번 방(첫 번째) 입주민
        System.out.println(names[1] + "님 안녕하세요!"); // 1번 방(두 번째) 입주민
        System.out.println(names[2] + "님 안녕하세요!"); // 2번 방(세 번째) 입주민
        // System.out.println(names[3]); // Error! 3번 방은 없으므로 에러가 발생해요. (ArrayIndexOutOfBoundsException)

        System.out.println("\n--- for문과 배열은 최고의 짝꿍! ---");
        // 배열의 길이(방의 개수)는 `배열이름.length` 로 알 수 있어요. names.length는 3이겠죠?
        // for문을 이용하면 배열의 모든 방을 처음부터 끝까지 순서대로 방문할 수 있답니다.
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + "님, 환영합니다!");
        }

        System.out.println("\n----------------------------------------\n");

        // [3] 배열 사용하기 (방 개수만 정해서 만들기)
        // "일단 정수(int)를 담을 수 있는 방 5개짜리 아파트를 지어줘! 입주는 나중에 시킬게."
        int[] scores = new int[5]; // new 키워드는 새로운 아파트(배열 객체)를 짓는 행위라고 생각하세요.

        // 나중에 각 방에 값을 할당(입주)할 수 있어요.
        scores[0] = 100;
        scores[1] = 80;
        scores[2] = 95;
        scores[3] = 70;
        scores[4] = 88;

        System.out.println("--- 학생 5명의 점수 출력 ---");
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            System.out.println((i + 1) + "번 학생의 점수: " + scores[i]);
            sum += scores[i]; // 점수 총합 구하기
        }
        System.out.println("학생들의 총점: " + sum);
        System.out.println("학생들의 평균: " + (double)sum / scores.length);

        System.out.println("\n----------------------------------------\n");

        // [4] 배열을 만들면 방은 무엇으로 채워져 있을까? (기본 초기값)
        // 값을 넣어주지 않고 방만 만들면, Java가 자동으로 기본값으로 채워줘요.
        int[] intArray = new int[3];       // 숫자 타입(int, double 등)은 0으로 채워져요.
        boolean[] boolArray = new boolean[3]; // boolean 타입은 false로 채워져요.
        String[] strArray = new String[3]; // 문자열, 클래스 등 참조 타입은 null로 채워져요. (null은 '아무것도 없다', '비어있다'는 뜻)

        System.out.println("int 배열의 0번 방: " + intArray[0]);
        System.out.println("boolean 배열의 0번 방: " + boolArray[0]);
        System.out.println("String 배열의 0번 방: " + strArray[0]);
    }
}