// 안녕하세요, 두프룸프님!
// 이 파일은 앞서 배운 문자열(String)의 기본 기능들에 이어서,
// 문자열을 '변형'하거나 '결합'하는 더 다양한 방법들을 배우는 예제입니다.
// 마치 글자들을 자르고, 붙이고, 바꾸는 편집 기술을 배우는 것과 같아요!

public class _06_String2 { // 클래스 선언
    public static void main(String[] args) { // main 메서드: 프로그램 시작점

        String s = "I like Java, Python and C+."; // 예제로 사용할 문자열

        System.out.println("원본 문자열: " + s);

        // 1. 문자열 바꾸기 (replace() 메서드)
        // replace(oldChar, newChar): 특정 문자(char)를 다른 문자로 모두 바꿔줍니다.
        // replace(oldString, newString): 특정 문자열(String)을 다른 문자열로 모두 바꿔줍니다.
        // ★ 중요: 이 메서드도 원본 문자열을 바꾸는 것이 아니라, '새로운' 변형된 문자열을 반환합니다.
        System.out.println("'+'를 '#'으로 바꾸기: " + s.replace('+', '#')); // 출력: I like Java, Python and C#.

        // 2. 문자열 자르기 (substring() 메서드)
        // substring(startIndex): startIndex부터 문자열의 끝까지 잘라냅니다.
        // substring(startIndex, endIndex): startIndex부터 endIndex '전'까지 잘라냅니다. (endIndex는 포함되지 않아요!)
        // 인덱스는 0부터 시작하는 것을 잊지 마세요!
        System.out.println("인덱스 7부터 자르기: " + s.substring(7)); // 출력: Java, Python and C+.

        // substring()과 indexOf()를 함께 활용하는 예시
        // 먼저 "Java"가 시작하는 인덱스를 찾고, 마침표('.')가 시작하는 인덱스를 찾아서 그 사이를 잘라냅니다.
        System.out.println("'Java'부터 마침표 전까지 자르기: " + s.substring(s.indexOf("Java"), s.indexOf("."))); // 출력: Java, Python and C+

        System.out.println("----------------------------------------"); // 구분선

        // 3. 잘라낸 문자열을 변수에 저장하여 사용하기
        // 메서드가 반환하는 새로운 문자열을 변수에 저장해서 재활용할 수 있어요.
        String java_cut = s.substring(7); // "Java, Python and C+." 이라는 새로운 문자열이 java_cut 변수에 저장됩니다.
        System.out.println("잘라낸 문자열 변수: " + java_cut);

        System.out.println("----------------------------------------"); // 구분선

        // 4. 공백 제거하기 (trim() 메서드)
        // trim() 메서드는 문자열의 '양 끝'에 있는 모든 공백(띄어쓰기, 탭, 줄바꿈 등)을 제거합니다.
        // 문자열 중간에 있는 공백은 제거하지 않아요.
        s = "          I love you.   "; // 양 끝에 공백이 많은 새로운 문자열을 할당

        System.out.println("공백이 있는 원본 문자열: [" + s + "]"); // 공백을 눈으로 확인하기 위해 대괄호로 감싸서 출력
        System.out.println("trim() 후 문자열: [" + s.trim() + "]"); // 출력: [I love you.]

        System.out.println("----------------------------------------"); // 구분선

        // 5. 문자열 결합하기 ( + 연산자, concat() 메서드)
        // 두 개 이상의 문자열을 하나로 합치는 방법입니다.
        String s1 = "I love";
        String s2 = "you.";

        // 방법 1: + 연산자 사용 (가장 흔하고 편리한 방법)
        // 문자열과 문자열을 +로 연결하면 두 문자열이 합쳐집니다.
        System.out.println("+" + " 연산자로 결합: " + (s1 + s2)); // 출력: I loveyou.
        System.out.println("+" + " 연산자로 공백과 함께 결합: " + (s1 + " " + s2)); // 출력: I love you.

        // 방법 2: concat() 메서드 사용
        // concat() 메서드는 현재 문자열 뒤에 괄호 안의 문자열을 붙여서 새로운 문자열을 반환합니다.
        System.out.println("concat()으로 결합: " + s1.concat(s2)); // 출력: I loveyou.
        // 여러 번 연결할 수도 있어요.
        System.out.println("concat()으로 공백과 함께 결합: " + s1.concat(" ").concat(s2)); // 출력: I love you.

        // 일반적으로 문자열 결합에는 + 연산자가 더 직관적이고 많이 사용됩니다.
    }
}
