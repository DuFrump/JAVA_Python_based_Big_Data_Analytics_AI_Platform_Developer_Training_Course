// 배열(Array)의 선언, 초기화, 요소 접근, 그리고 `length` 속성을 배우는 예제입니다.
// 배열은 같은 타입의 여러 변수를 하나의 이름으로 묶어서 다루는 자료구조입니다.

public class _08_Array {
    public static void main(String[] args) {
        // [1] 배열을 사용하지 않고 여러 변수를 선언한 경우
        // 변수가 많아지면 관리하기 어렵고, 반복문을 사용할 수 없습니다.
        String a = "알파";
        String b = "브라보";
        String c = "찰리";
        String d = "델타";
        String e = "에코";
        String f = "폭스프롯";
        String g = "골프";
        String h = "호텔";
        String i = "인디아";
        String j = "줄리엣";
        String k = "킬로";
        String l = "라마";

        System.out.printf("토끼와 거북이 동화에 문제가 생겼다.%n");
        System.out.printf("%s 출동!%n", g);
        System.out.printf("%s 출동!%n", b);
        System.out.printf("%s 출동!%n", e);
        System.out.printf("%s 출동!%n%n%n", l);

        System.out.println("
----------------------------------------
");

        // [2] 배열 선언 및 초기화 (방법 1: 선언과 동시에 초기화)
        // String[] teamsign: String 타입의 배열을 선언합니다.
        // { ... }: 중괄호 안에 초기값을 나열하여 배열을 초기화합니다.
        String[] teamsign = {"Alpha", "Bravo", "Charlie", "Delta", "Echo"};

        // 배열 요소 접근: `배열이름[인덱스]` 형태로 접근합니다. 인덱스는 0부터 시작합니다.
        System.out.printf("%s 출동!%n", teamsign[0]); // 첫 번째 요소 (인덱스 0)
        System.out.printf("%s 출동!%n", teamsign[1]); // 두 번째 요소 (인덱스 1)
        System.out.printf("%s 출동!%n", teamsign[2]); // 세 번째 요소 (인덱스 2)
        System.out.printf("%s 출동!%n%n", teamsign[3]); // 네 번째 요소 (인덱스 3)

        // 반복문을 사용하여 배열의 모든 요소에 접근할 수 있습니다.
        System.out.println("--- 반복문으로 배열 요소 출력 ---");
        for (int m = 0; m < teamsign.length; m++) { // teamsign.length는 배열의 길이를 반환합니다.
            System.out.printf("%s 출동!%n", teamsign[m]);
        }

        System.out.println("
----------------------------------------
");

        // [3] 배열 선언 및 초기화 (방법 2: 크기만 지정하고 나중에 값 할당)
        // new int[3]: int 타입의 요소를 3개 저장할 수 있는 배열을 생성합니다.
        // 배열 생성 시 기본값으로 초기화됩니다. (정수형은 0, 실수형은 0.0, boolean은 false, 참조형은 null)
        int[] numbers = new int[3];
        numbers[0] = 1; // 첫 번째 요소에 1 할당
        numbers[1] = 5; // 두 번째 요소에 5 할당
        numbers[2] = 7; // 세 번째 요소에 7 할당

        System.out.println("--- numbers 배열 요소 출력 ---");
        for (int m = 0; m < numbers.length; m++) {
            System.out.println(numbers[m]);
        }

        System.out.println("
----------------------------------------
");

        // [4] 배열 생성 시 기본값 확인
        int[] intArray = new int[5];       // 정수형 배열 (모든 요소 0으로 초기화)
        String[] strArray = new String[5]; // 문자열 배열 (모든 요소 null로 초기화)

        // [5] 배열 선언 및 초기화 (방법 3: 선언과 동시에 초기화, 크기 자동 지정)
        int[] varArray = {1, 2, 3, 4, 5};

        System.out.println("intArray[0] = " + intArray[0]); // 0
        System.out.println("intArray[1] = " + intArray[1]); // 0

        System.out.println("strArray[0] = " + strArray[0]); // null
        System.out.println("strArray[1] = " + strArray[1]); // null

        System.out.println("varArray[0] = " + varArray[0]); // 1
        System.out.println("varArray[1] = " + varArray[1]); // 2

        System.out.println("
----------------------------------------
");

        // [6] 배열의 길이 (`length` 속성)
        // 배열의 크기(요소의 개수)를 반환합니다.
        System.out.println("intArray의 길이: " + intArray.length); // 5
        System.out.println("strArray의 길이: " + strArray.length); // 5
        System.out.println("numbers의 길이: " + numbers.length); // 3
    }
}
