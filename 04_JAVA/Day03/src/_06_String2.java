public class _06_String2 {
    public static void main(String[] args) {
        String s = "I like Java, Python and C+.";

        // 문자열 반환
        System.out.println(s.replace('+', '#'));
        System.out.println(s.substring(7));
        System.out.println(s.indexOf("Java"));
        System.out.println(s.substring(s.indexOf("Java"), s.indexOf(".")));


        // 변수에 넣어서 사용
        String java_cut = s.substring(7);
        System.out.println(java_cut);


        // 공백 제거
        s = "          I love you.   ";

        System.out.println(s);
        System.out.println(s.trim());


        // 문자열 결합
        String s1 = "I love";
        String s2 = "you.";

        System.out.println(s1 + s2);
        System.out.println(s1 + " " + s2);
        System.out.println(s1.concat(s2));
        System.out.println(s1.concat(" ").concat(s2));
    }
}
