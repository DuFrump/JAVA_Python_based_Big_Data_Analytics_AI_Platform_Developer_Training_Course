// 조건문 `if-else if`와 논리 연산자(`||`, OR)를 활용하는 예제입니다.

public class _11_If2 {
    public static void main(String[] args) {
        int hour = 20; // 현재 시간 (24시간제)
        boolean morning_coffee = false; // 아침에 커피를 마셨는지 여부

        // [1] 첫 번째 if 조건: hour가 17보다 크거나 (오후 5시 이후) 또는 morning_coffee가 true이면
        // (hour > 17)은 20 > 17 이므로 true
        // (morning_coffee == true)는 false == true 이므로 false
        // (true || false)는 true 이므로 첫 번째 if 블록이 실행됩니다.
        if(hour > 17 || morning_coffee == true) {
            System.out.println("커피를 마시지 않겠습니다.");
        } 
        // [2] 두 번째 else if 조건: 첫 번째 if 조건이 거짓일 때만 검사합니다.
        // 현재 hour > 17 || morning_coffee == true 가 참이므로 이 else if 블록은 실행되지 않습니다.
        // 만약 첫 번째 if 조건이 거짓이었다면, 이 조건 (hour < 17 || morning_coffee == false)을 검사합니다.
        // (hour < 17)은 20 < 17 이므로 false
        // (morning_coffee == false)는 false == false 이므로 true
        // (false || true)는 true
        else if(hour < 17 || morning_coffee == false) {
            System.out.println("커피 한 잔 하겠습니다.");
        }
        // 참고: boolean 변수 `morning_coffee == true`는 `morning_coffee`로,
        // `morning_coffee == false`는 `!morning_coffee`로 간결하게 표현할 수 있습니다.
    }
}

