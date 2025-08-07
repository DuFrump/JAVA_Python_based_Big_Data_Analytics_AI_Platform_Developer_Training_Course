// 이스케이프 시퀀스(Escape Sequence)에 대해 배우는 예제입니다.
// 이스케이프 시퀀스는 특수한 기능을 수행하거나, 일반적인 방법으로는 표현하기 어려운 문자를 문자열 내에 포함할 때 사용합니다.
// 역슬래시(\)와 특정 문자 조합으로 이루어집니다.

public class _08_EscapeSequence {
    public static void main(String[] args) {
        // [1] 
 : 줄바꿈 (New Line)
        System.out.println("--- 
 (줄바꿈) ---");
        System.out.println("날씨가");
        System.out.println("정말");
        System.out.println("좋아요.");

        // 위 세 줄의 출력을 
을 사용하여 한 줄로 표현할 수 있습니다.
        System.out.println("날씨가
정말
좋아요.");

        System.out.println("
----------------------------------------
");

        // [2] 	 : 탭 (Tab)
        // 일정한 간격으로 띄어쓰기를 할 때 사용합니다.
        System.out.println("--- 	 (탭) ---");
        System.out.println("빽다방 2000원");
        System.out.println("스타벅스 5000원");

        // 	를 사용하여 정렬된 형태로 출력할 수 있습니다.
        System.out.println("빽다방	2000원");
        System.out.println("스타벅스	5000원");

        System.out.println("
----------------------------------------
");

        // [3] \ : 역슬래시 (Backslash)
        // 역슬래시 자체를 문자열 내에 표현하고 싶을 때 사용합니다. (이스케이프 시퀀스의 시작 문자이므로 두 번 써야 함)
        System.out.println("--- \\ (역슬래시) ---");
        // 파일 경로 등을 출력할 때 유용합니다.
        System.out.println("C:\\Program Files\\Java");

        System.out.println("
----------------------------------------
");

        // [4] \" : 큰따옴표 (Double Quote)
        // 문자열 내에 큰따옴표를 포함하고 싶을 때 사용합니다.
        System.out.println("--- \" (큰따옴표) ---");
        System.out.println("그녀가 나한테 말했다. \"배고프니?\"");

        System.out.println("
----------------------------------------
");

        // [5] \' : 작은따옴표 (Single Quote)
        // 문자열 내에 작은따옴표를 포함하고 싶을 때 사용합니다.
        // char 타입에서는 작은따옴표를 이스케이프할 필요가 없지만, String 내에서는 필요할 수 있습니다.
        System.out.println("--- \' (작은따옴표) ---");
        System.out.println("너의 속마음이 들리는 거 같아. \'아.. 배고파..\'");
    }
}
