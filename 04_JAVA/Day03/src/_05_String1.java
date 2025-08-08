// 안녕하세요, 두프룸프님!
// 이 파일은 자바에서 '문자열(String)'을 다루는 다양한 방법들을 배우는 예제입니다.
// 문자열은 글자들이 나열된 형태의 데이터라고 생각하면 돼요. 예를 들어, "안녕하세요", "Java 프로그래밍" 같은 것들이죠.
// 자바는 이런 문자열을 편리하게 다룰 수 있도록 여러 가지 '메서드(기능)'들을 제공합니다.

public class _05_String1 { // 클래스 선언
    public static void main(String[] args) { // main 메서드: 프로그램 시작점

        // 우리가 다룰 문자열을 하나 선언해볼까요?
        String s = "I like Java, Python and C+.";

        System.out.println("원본 문자열: " + s); // 원본 문자열을 출력해봅니다.

        // 1. 문자열의 길이 알아내기 (length() 메서드)
        // length() 메서드는 문자열 안에 몇 개의 글자(문자)가 들어있는지 그 '개수'를 알려줍니다.
        // 공백(띄어쓰기)도 하나의 문자로 세어집니다.
        System.out.println("문자열의 길이: " + s.length()); // "I like Java, Python and C+."는 총 29개의 문자로 이루어져 있어요.

        // 2. 대소문자 변환하기 (toUpperCase(), toLowerCase() 메서드)
        // toUpperCase(): 문자열 안의 모든 영문자를 '대문자'로 바꿔줍니다. (한글이나 숫자는 변하지 않아요)
        // toLowerCase(): 문자열 안의 모든 영문자를 '소문자'로 바꿔줍니다.
        // ★ 중요: 이 메서드들은 원본 문자열을 직접 바꾸는 것이 아니라, '새로운' 변환된 문자열을 만들어서 반환합니다.
        System.out.println("대문자로 변환: " + s.toUpperCase()); // 출력: I LIKE JAVA, PYTHON AND C+.
        System.out.println("소문자로 변환: " + s.toLowerCase()); // 출력: i like java, python and c+.

        System.out.println("----------------------------------------"); // 구분선

        // 3. 특정 문자열이 포함되어 있는지 확인하기 (contains() 메서드)
        // contains() 메서드는 괄호 안에 있는 문자열이 현재 문자열 안에 '포함'되어 있는지 확인하고,
        // 포함되어 있으면 true(참), 없으면 false(거짓)를 반환합니다.
        // ★ 중요: 대소문자를 구분합니다!
        System.out.println("'Java' 포함 여부: " + s.contains("Java"));   // 출력: true (원본 문자열에 "Java"가 그대로 있어요)
        System.out.println("'java' 포함 여부: " + s.contains("java"));   // 출력: false (원본 문자열에는 소문자 "java"가 없어요)

        // 4. 특정 문자열의 위치 찾기 (indexOf(), lastIndexOf() 메서드)
        // 문자열에서 각 글자는 0부터 시작하는 '인덱스(위치 번호)'를 가지고 있어요.
        // 예를 들어 "Java"에서 'J'는 0번, 'a'는 1번, 'v'는 2번, 'a'는 3번 인덱스입니다.

        // indexOf(): 괄호 안의 문자열이 '처음'으로 나타나는 위치(인덱스)를 알려줍니다.
        // 만약 찾는 문자열이 없으면 -1을 반환합니다.
        System.out.println("'Java'의 첫 번째 위치: " + s.indexOf("Java")); // 출력: 7 (원본 문자열에서 'J'가 7번째 인덱스에 있어요)
        System.out.println("'a'의 첫 번째 위치: " + s.indexOf('a'));   // 출력: 3 (원본 문자열에서 'a'가 처음 나타나는 곳은 'like'의 'a'입니다.)

        // lastIndexOf(): 괄호 안의 문자열이 '마지막'으로 나타나는 위치(인덱스)를 알려줍니다.
        // 찾는 문자열이 없으면 마찬가지로 -1을 반환합니다.
        System.out.println("'a'의 마지막 위치: " + s.lastIndexOf('a')); // 출력: 27 (원본 문자열에서 'and'의 'a'가 마지막 'a'입니다.)

        // 5. 특정 문자열로 시작하거나 끝나는지 확인하기 (startsWith(), endsWith() 메서드)
        // startsWith(): 현재 문자열이 괄호 안의 문자열로 '시작'하는지 확인하고 true/false를 반환합니다.
        System.out.println("'I like'로 시작하는가?: " + s.startsWith("I like")); // 출력: true
        // endsWith(): 현재 문자열이 괄호 안의 문자열로 '끝나는지' 확인하고 true/false를 반환합니다.
        System.out.println("'C+.'로 끝나는가?: " + s.endsWith("C+."));   // 출력: true
    }
}
