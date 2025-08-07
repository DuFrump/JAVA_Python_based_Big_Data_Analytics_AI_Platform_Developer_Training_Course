// String 클래스의 다양한 메소드(기능)들을 배우는 예제입니다.

public class _05_String1 {
    public static void main(String[] args) {
        String s = "I like Java, Python and C+.";

        System.out.println("원본 문자열: " + s);

        // 1. 문자열의 길이 (length() 메소드)
        // 문자열에 포함된 문자의 개수를 반환합니다.
        System.out.println("문자열의 길이: " + s.length()); // 출력: 29

        // 2. 대소문자 변환 (toUpperCase(), toLowerCase() 메소드)
        // toUpperCase(): 모든 문자를 대문자로 변환한 새로운 문자열을 반환합니다.
        System.out.println("대문자로 변환: " + s.toUpperCase());
        // toLowerCase(): 모든 문자를 소문자로 변환한 새로운 문자열을 반환합니다.
        System.out.println("소문자로 변환: " + s.toLowerCase());

        System.out.println("----------------------------------------");

        // 3. 포함 관계 확인 (contains() 메소드)
        // 특정 문자열이 포함되어 있는지 여부를 boolean 값으로 반환합니다.
        System.out.println("'Java' 포함 여부: " + s.contains("Java"));   // 출력: true (대소문자 구분)
        System.out.println("'java' 포함 여부: " + s.contains("java"));   // 출력: false

        // 4. 문자열 위치 찾기 (indexOf(), lastIndexOf() 메소드)
        // indexOf(): 특정 문자열이 처음으로 나타나는 위치(인덱스)를 반환합니다. 없으면 -1 반환.
        // 인덱스는 0부터 시작합니다.
        System.out.println("'Java'의 첫 번째 위치: " + s.indexOf("Java")); // 출력: 7
        System.out.println("'a'의 첫 번째 위치: " + s.indexOf('a'));   // 출력: 3

        // lastIndexOf(): 특정 문자열이 마지막으로 나타나는 위치(인덱스)를 반환합니다. 없으면 -1 반환.
        System.out.println("'a'의 마지막 위치: " + s.lastIndexOf('a')); // 출력: 27

        // 5. 시작/끝 문자열 확인 (startsWith(), endsWith() 메소드)
        // startsWith(): 특정 문자열로 시작하는지 여부를 boolean 값으로 반환합니다.
        System.out.println("'I like'로 시작하는가?: " + s.startsWith("I like")); // 출력: true
        // endsWith(): 특정 문자열로 끝나는지 여부를 boolean 값으로 반환합니다.
        System.out.println("'C+.'로 끝나는가?: " + s.endsWith("C+."));   // 출력: true
    }
}
