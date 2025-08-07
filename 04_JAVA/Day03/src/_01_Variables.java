// Day03의 첫 번째 예제로, 변수와 Scanner를 활용한 기본적인 입출력을 다룹니다.

import java.util.Scanner; // Scanner 클래스를 사용하기 위해 import 합니다.

public class _01_Variables {
    public static void main(String[] args) {
        // 사용자에게 이름을 물어보는 메시지 출력
        System.out.print("이름을 알려주세요. : ");

        // String 타입의 변수 greeting을 선언하고 초기화합니다.
        String greeting = "안녕하세요";

        // Scanner 객체를 생성하여 사용자 입력을 받을 준비를 합니다.
        Scanner sc = new Scanner(System.in);
        // sc.next()를 사용하여 사용자로부터 단어(공백 전까지의 문자열)를 입력받아 name 변수에 저장합니다.
        String name = sc.next();

        // 입력받은 이름과 greeting 변수를 조합하여 출력합니다.
        // %s는 문자열을 위한 형식 지정자입니다.
        System.out.printf("%s! %s님!%n", greeting, name);

        // 사용자에게 날씨와 시간을 물어보는 메시지 출력
        System.out.print("혹시 오늘의 날씨와 시간을 띄어쓰기로 알려주실 수 있으신가요? : ");
        // 두 개의 단어를 각각 weather와 time 변수에 저장합니다.
        String weather = sc.next();
        String time = sc.next();

        // 입력받은 날씨와 시간을 조합하여 출력합니다.
        System.out.printf("아하! 오늘의 날씨는 %s이고, 시간은 %s이군요.%n", weather, time);

        System.out.println("
----------------------------------------
");

        // 다양한 데이터 타입의 변수를 선언하고 초기화합니다.
        int age = 28;             // 정수형 (나이)
        double height = 181.5;    // 실수형 (키)
        char gender = 'M';          // 문자형 (성별)
        short seat_number = 1;    // 짧은 정수형 (좌석 번호)
        boolean is_goodman = true; // 논리형 (참/거짓)

        // 모든 변수들을 조합하여 하나의 문장으로 출력합니다.
        // 각 변수의 데이터 타입에 맞는 형식 지정자(%s, %d, %f, %c, %b)를 사용합니다.
        System.out.printf("저의 이름은 %s이고, 나이는 %d, 키는 %.1f, 성별은 %c입니다. 학원에서 저의 자리는 %d번이고, 저는 좋은 사람입니다. %b!
",
                name, age, height, gender, seat_number, is_goodman);

        // Scanner 객체를 닫아 자원을 해제합니다.
        sc.close();
    }
}
