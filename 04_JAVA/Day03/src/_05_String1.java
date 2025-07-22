import com.sun.security.jgss.GSSUtil;

import java.util.Locale;

public class _05_String1 {
    public static void main(String[] args) {
        String s = "I like Java, Python and C+.";

        System.out.println(s);

        // 문자열의 길이
        System.out.println(s.length());

        // 대소문자 변환
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());

        // 포함 관계
        System.out.println(s.contains("Java"));
        System.out.println(s.contains("java"));
        System.out.println(s.indexOf("Java"));
        System.out.println(s.indexOf('a')); // 처음 만나는 위치 인덱스
        System.out.println(s.lastIndexOf('a')); // 마지막 만나는 위치 인덱스
        System.out.println(s.startsWith("I like")); // 문장의 시작이 이것인가?
        System.out.println(s.endsWith("C+.")); // 문장의 마지막이 이것인가?
    }
}
