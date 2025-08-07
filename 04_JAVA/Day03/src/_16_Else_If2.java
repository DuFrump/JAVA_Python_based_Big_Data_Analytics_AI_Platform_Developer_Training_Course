// `if-else if-else` 조건문을 사용하여 여러 상황에 따른 의사결정을 시뮬레이션하는 예제입니다.

public class _16_Else_If2 {
    public static void main(String[] args) {
        // 메뉴 선택 상황을 가정합니다.
        // 제육 덮밥, 돈까스, 김치찌개 중 하나를 선택하는 시나리오입니다.

        boolean jaeyook = true;   // 제육 덮밥을 먹을 수 있는지 여부
        boolean donggass = false; // 돈까스를 먹을 수 있는지 여부

        System.out.println("언제 와? 뭐 먹을거? 시켜놓을게.");

        // [1] 첫 번째 조건: 제육 덮밥을 먹을 수 있는가?
        // `jaeyook == true`는 `jaeyook`으로 간결하게 표현할 수 있습니다.
        if (jaeyook) {
            System.out.println("제육 시켜줘.");
        } 
        // [2] 두 번째 조건: 돈까스를 먹을 수 있는가? (제육 덮밥을 먹을 수 없을 때만 검사)
        else if (donggass) {
            System.out.println("그럼 돈까스 먹지 뭐.");
        } 
        // [3] 모든 조건이 거짓일 때: 제육 덮밥도, 돈까스도 먹을 수 없을 때
        else {
            System.out.println("아.. 김치찌개 말곤 안 된대? 김치찌개 먹어야지 뭐..");
        }
        System.out.println("금방 갈게. 전화 끊어.");
    }
}

