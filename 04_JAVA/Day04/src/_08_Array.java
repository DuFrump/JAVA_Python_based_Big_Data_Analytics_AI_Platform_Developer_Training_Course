public class _08_Array {
    public static void main(String[] args) {
        String a = "알파";
        String b = "브라보";
        String c = "찰리";
        String d = "델타";
        String e = "에코";
        String f = "폭스프롯";
        String g = "골프";
        String h = "호텔";
        String i = "인디아";
        String j = "줄리엣";
        String k = "킬로";
        String l = "라마";

        System.out.printf("토끼와 거북이 동화에 문제가 생겼다.%n");
        System.out.printf("%s 출동!%n", g);
        System.out.printf("%s 출동!%n", b);
        System.out.printf("%s 출동!%n", e);
        System.out.printf("%s 출동!%n%n%n", l);

        String[] teamsign = {"Alpha", "Bravo", "Charlie", "Delta", "Echo"};
        System.out.printf("%s 출동!%n", teamsign[0]);
        System.out.printf("%s 출동!%n", teamsign[1]);
        System.out.printf("%s 출동!%n", teamsign[2]);
        System.out.printf("%s 출동!%n%n", teamsign[3]);

        for (int m = 0; m < 5; m++) {
            System.out.printf("%s 출동!%n", teamsign[m]);
        }

        int[] numbers = new int[3];
        numbers[0] = 1;
        numbers[1] = 5;
        numbers[2] = 7;

        for (int m = 0; m < numbers.length; m++) {
            System.out.println(numbers[m]);
        }

        System.out.println("----------------------------------");

        int[] intArray = new int[5];
        String[] strArray = new String[5];

        int[] varArray = {1, 2, 3, 4, 5};

        System.out.println("intArray[0] = " + intArray[0]);
        System.out.println("intArray[1] = " + intArray[1]);

        System.out.println("strArray[0] = " + strArray[0]);
        System.out.println("strArray[1] = " + strArray[1]);

        System.out.println("varArray[0] = " + varArray[0]);
        System.out.println("varArray[1] = " + varArray[1]);


        // 배열의 길이
        System.out.println(intArray.length);
        System.out.println(strArray.length);
        System.out.println(numbers.length);
    }
}
