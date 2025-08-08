// 변수(Variable)를 선언하고 값을 저장하며 사용하는 방법을 배우는 예제입니다.

public class _03_Variables {
    public static void main(String[] args) {
        // [변수 (Variable)]
        // 데이터를 임시로 저장하기 위한 메모리 공간에 붙이는 이름입니다.
        // 변수를 사용하면 데이터를 재사용하거나 변경하기 용이해집니다.

        // --- 변수의 선언과 초기화 ---
        // 형식: [데이터타입] [변수이름] = [값];

        // 1. 변수 선언: `name`이라는 이름의 String 타입 변수를 저장할 공간을 만듭니다.
        String name;
        // 2. 변수 초기화: `name` 변수에 "홍길동"이라는 값을 처음으로 할당(저장)합니다.
        name = "홍길동";

        // 선언과 초기화를 동시에 할 수도 있습니다.
        int hour = 10; // 정수(int) 타입의 변수 `hour`를 선언하고 10으로 초기화

        // 변수에 저장된 값을 사용하여 문자열을 조합하고 출력합니다.
        System.out.println(name + "님, 안녕하세요! " + hour + "시에 만나요!");
        System.out.println();

        // --- 변수 값 변경 ---
        // 한 번 선언된 변수의 값은 다시 변경할 수 있습니다.
        hour = 14; // `hour` 변수의 값을 14로 변경
        System.out.println(name + "님, 약속시간이 " + hour + "시로 변경되었습니다.");
        System.out.println();

        // --- 다양한 데이터 타입의 변수 활용 ---

        // 실수(double) 타입: 키, 몸무게 등 정밀한 소수점 데이터에 사용
        double height = 175.6;

        // 문자(char) 타입: 단 하나의 문자를 저장. 작은따옴표('')를 사용합니다.
        // 성별(M/F), 혈액형(A/B/O/AB) 등 한 글자로 표현 가능한 데이터에 사용
        char gender = 'M';

        // 불리언(boolean) 타입: 참/거짓 두 가지 상태를 저장
        // 로그인 여부, 동의 여부 등 논리적인 상태를 표현할 때 사용
        boolean isKorean = true;

        System.out.println("--- 자기소개 ---");
        System.out.println("이름: " + name);
        System.out.println("키: " + height + "cm");
        System.out.println("성별: " + gender);
        System.out.println("한국인입니까? " + isKorean);
        System.out.println();

        // --- 더 큰 숫자나 정밀한 실수를 위한 데이터 타입 ---

        // long 타입: int의 범위를 넘어가는 매우 큰 정수를 다룰 때 사용
        // 값 뒤에 'l' 또는 'L'을 붙여 long 타입임을 명시합니다.
        // 예: 은행 계좌 잔액, 국가 예산 등
        long balance = 100_000_000_000L; // 숫자를 읽기 쉽게 하기 위해 중간에 언더바(_) 사용 가능
        System.out.println("통장 잔액: " + balance + "원");

        // float 타입: double보다 덜 정밀하지만 메모리를 적게 사용하는 실수를 다룰 때 사용
        // 값 뒤에 'f' 또는 'F'를 붙여 float 타입임을 명시합니다.
        // 예: 게임의 좌표값, 간단한 통계 데이터 등
        float weight = 72.5f;
        System.out.println("몸무게: " + weight + "kg");
    }
}