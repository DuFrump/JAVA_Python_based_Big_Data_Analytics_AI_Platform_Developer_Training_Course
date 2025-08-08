// 안녕하세요, 두프룸프님!
// 이 파일은 앞서 배운 `if` 조건문에 '논리 연산자'를 결합하여
// 더 복잡하고 다양한 조건들을 처리하는 방법을 배우는 예제입니다.
// 특히 `|| (OR)` 연산자를 중심으로 살펴볼 거예요.

public class _11_If2 { // 클래스 선언
    public static void main(String[] args) { // main 메서드: 프로그램 시작점

        int hour = 20; // 현재 시간을 24시간제로 설정 (예: 오후 8시)
        boolean morning_coffee = false; // 아침에 커피를 마셨는지 여부 (false: 안 마심, true: 마심)

        // [1] `if` 조건문과 `|| (OR)` 논리 연산자
        // `||` (OR 연산자): 두 개의 조건 중 '하나라도' 참(true)이면 전체 조건이 참(true)이 됩니다.
        // 마치 "A이거나 B이면" 이라는 의미와 같아요.
        // (조건1 || 조건2)
        // - 조건1이 true이면, 조건2는 검사하지 않고 전체가 true
        // - 조건1이 false이면, 조건2를 검사하여 조건2가 true이면 전체가 true, false이면 전체가 false

        // 현재 상황: hour = 20, morning_coffee = false
        // 조건식: (hour > 17 || morning_coffee == true)
        //         (20 > 17) || (false == true)
        //         (true)    || (false)
        //         -> 결과는 true (OR 연산자는 하나라도 true이면 true)
        if(hour > 17 || morning_coffee == true) { // 만약 시간이 오후 5시(17시)보다 늦었거나, 아침에 커피를 마셨다면...
            System.out.println("커피를 마시지 않겠습니다."); // 이 코드가 실행됩니다.
        } 
        // [2] `else if` 조건문
        // `else if`는 바로 위 `if` 또는 `else if`의 조건이 거짓(false)일 때만 검사됩니다.
        // 현재 예시에서는 첫 번째 `if` 조건이 참(true)이었으므로, 이 `else if` 블록은 실행되지 않습니다.
        // 하지만 만약 첫 번째 `if` 조건이 거짓이었다면, 이 `else if` 조건이 검사되었을 거예요.

        // (가정: 만약 첫 번째 if 조건이 거짓이었다면)
        // 조건식: (hour < 17 || morning_coffee == false)
        //         (20 < 17) || (false == false)
        //         (false)   || (true)
        //         -> 결과는 true
        else if(hour < 17 || morning_coffee == false) { // 만약 시간이 오후 5시(17시)보다 이르거나, 아침에 커피를 안 마셨다면...
            System.out.println("커피 한 잔 하겠습니다.");
        }

        // ★ 팁: boolean 변수 간결하게 표현하기
        // `morning_coffee == true`는 그냥 `morning_coffee`라고만 써도 같은 의미입니다.
        // `morning_coffee == false`는 `!morning_coffee`라고만 써도 같은 의미입니다. (`!`는 논리 부정 연산자)
        // 코드를 더 간결하고 읽기 쉽게 만들 수 있어요!
    }
}

