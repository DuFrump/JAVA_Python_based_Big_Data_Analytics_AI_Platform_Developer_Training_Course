public class _07_StringCompare {
    public static void main(String[] args) {
        // 문자열 비교
        String s1 = "Java";
        String s2 = "Python";

        System.out.println(s1.equals(s2));
        System.out.println(s1.equals("Java"));
        System.out.println(s2.equals("python"));
        System.out.println(s2.equalsIgnoreCase("python"));


        // 비교 심화 버전
        s1 = "1234";
        s2 = "1234";

        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);

        s1 = new String("1234");
        s2 = new String("1234");
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
        // equals ==> 내용 비교.
        // '==' ==> 주소 비교.
    }
}
