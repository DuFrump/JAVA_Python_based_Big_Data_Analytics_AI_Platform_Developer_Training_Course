// 안녕하세요, 두프룸프님!
// 이 파일은 자바 프로그래밍의 가장 기본이 되는 '변수'와 '사용자 입력' 그리고 '출력'에 대해 배우는 예제입니다.
// 마치 우리가 대화하듯이 컴퓨터와 소통하는 방법을 익히는 시간이라고 생각하면 돼요!

// 1. Scanner 클래스 불러오기 (import)
// Scanner는 사용자로부터 키보드 입력을 받기 위해 자바에서 제공하는 아주 유용한 도구예요.
// 이 도구를 사용하려면 먼저 "나 Scanner 쓸 거야!" 하고 자바에게 알려줘야 해요. 그게 바로 'import' 문입니다.
import java.util.Scanner; // java.util 패키지 안에 있는 Scanner 클래스를 가져와서 사용하겠다는 뜻이에요.

public class _01_Variables { // 이 파일의 이름과 똑같은 '클래스'를 선언합니다. 자바 프로그램의 기본 단위예요.
    // main 메서드: 자바 프로그램은 여기서부터 시작해요!
    // 마치 건물의 '정문'과 같아서, 프로그램이 실행되면 가장 먼저 이 문으로 들어와서 코드를 읽기 시작합니다.
    public static void main(String[] args) {

        // 2. 화면에 메시지 출력하기 (System.out.print / println)
        // System.out.print()는 괄호 안의 내용을 화면에 출력하고, 커서를 그 줄의 끝에 둡니다.
        // System.out.println()은 출력 후 다음 줄로 커서를 옮겨줘요. (ln = line new)
        System.out.print("이름을 알려주세요. : "); // 사용자에게 이름을 물어보는 메시지를 출력합니다.

        // 3. 변수 선언과 초기화 (Variables)
        // '변수'는 데이터를 저장하는 '상자'라고 생각하면 돼요.
        // 상자마다 어떤 종류의 데이터를 넣을지(데이터 타입) 정하고, 상자 이름을 붙여줍니다.
        // String greeting = "안녕하세요";
        // -> String: 문자열(글자들)을 저장할 수 있는 상자 종류 (데이터 타입)
        // -> greeting: 상자의 이름 (변수명)
        // -> "안녕하세요": 상자에 넣을 데이터 (값)
        // -> =: 상자에 값을 넣는다는 의미 (할당 연산자)
        String greeting = "안녕하세요"; // '안녕하세요'라는 문자열을 담을 'greeting'이라는 상자를 만들었어요.

        // 4. 사용자 입력 받기 (Scanner 활용)
        // Scanner 객체 생성: 사용자 입력을 받을 준비를 합니다.
        // System.in은 '표준 입력 스트림', 즉 키보드를 의미해요.
        Scanner sc = new Scanner(System.in);
        // sc.next(): 사용자가 키보드로 입력한 '단어' 하나(공백 전까지의 문자열)를 읽어옵니다.
        // 읽어온 단어를 'name'이라는 String 타입 상자에 저장합니다.
        String name = sc.next(); // 사용자로부터 이름을 입력받아 name 변수에 저장합니다.

        // 5. 형식화된 출력 (System.out.printf)
        // System.out.printf()는 C언어의 printf처럼 특정 형식에 맞춰 출력할 때 사용해요.
        // %s: String(문자열) 변수의 값이 들어갈 자리
        // %n: 줄 바꿈 (운영체제에 따라 \n 또는 \r\n이 될 수 있어 %n을 쓰는 것이 더 좋아요!)
        System.out.printf("%s! %s님!%n", greeting, name); // "안녕하세요! [입력받은 이름]님!" 형태로 출력됩니다.

        System.out.print("혹시 오늘의 날씨와 시간을 띄어쓰기로 알려주실 수 있으신가요? : ");
        // sc.next()를 두 번 사용하면, 사용자가 띄어쓰기로 구분하여 입력한 두 개의 단어를 각각 읽어올 수 있어요.
        String weather = sc.next(); // 첫 번째 단어(날씨)를 weather 변수에 저장
        String time = sc.next();    // 두 번째 단어(시간)를 time 변수에 저장

        System.out.printf("아하! 오늘의 날씨는 %s이고, 시간은 %s이군요.%n", weather, time);

        System.out.println("\n----------------------------------------\n"); // 구분선 출력

        // 6. 다양한 데이터 타입의 변수들
        // 자바에는 여러 종류의 데이터를 저장하기 위한 다양한 '데이터 타입'이 있어요.
        // 마치 물건 종류에 따라 다른 모양의 상자를 쓰는 것과 같아요.
        int age = 28;             // int: 정수(소수점이 없는 숫자)를 저장하는 상자. 예: 나이, 개수
        double height = 181.5;    // double: 실수(소수점이 있는 숫자)를 저장하는 상자. 예: 키, 몸무게
        char gender = 'M';          // char: 단 하나의 문자(글자)를 저장하는 상자. 작은따옴표('')로 감싸요. 예: 성별 'M', 'F'
        short seat_number = 1;    // short: int보다 작은 범위의 정수를 저장하는 상자. 메모리를 아낄 때 사용해요.
        boolean is_goodman = true; // boolean: 참(true) 또는 거짓(false)만 저장하는 상자. 예: ~인가요? (네/아니오)

        // 7. 모든 변수를 활용한 복합 출력
        // printf를 이용해 여러 종류의 변수들을 한 문장 안에 넣어 출력할 수 있어요.
        // 각 데이터 타입에 맞는 '형식 지정자'를 사용해야 합니다.
        // %s: String (문자열)
        // %d: Decimal (정수 - int, short 등)
        // %f: Floating-point (실수 - double, float)
        // %.1f: 소수점 첫째 자리까지 출력하는 실수 (예: 181.500000 -> 181.5)
        // %c: Character (문자)
        // %b: Boolean (논리값 - true/false)
        System.out.printf("저의 이름은 %s이고, 나이는 %d, 키는 %.1f, 성별은 %c입니다. 학원에서 저의 자리는 %d번이고, 저는 좋은 사람입니다. %b!%n",
                name, age, height, gender, seat_number, is_goodman);

        // 8. Scanner 자원 해제 (sc.close())
        // Scanner를 다 사용했으면, 컴퓨터 자원을 효율적으로 사용하기 위해 닫아주는 것이 좋아요.
        // 마치 사용한 도구를 제자리에 두는 것과 같습니다.
        sc.close();
    }
}
