public class _00_Generics {
    public static void main(String[] args) {
        Integer[] iArray = {1, 2, 3, 4, 5};
        Double[] dArray = {1.0, 2.0, 3.0, 4.0, 5.0};
        String[] sArray = {"A", "B", "C", "D", "E"};

        System.out.println("-------------------------------");

//        printIntegerArray(iArray);
//        printDoubleArray(dArray);
//        printStringArray(sArray);

        printAnyArray(iArray);
        printAnyArray(dArray);
        printAnyArray(sArray);
    }

    private static <T> void printAnyArray(T[] array) {
        for (T t : array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    private static void printStringArray(String[] sArray) {
        for (String s : sArray) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    private static void printIntegerArray(Integer[] iArray) {
        for (Integer i : iArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void printDoubleArray(Double[] dArray) {
        for (Double d : dArray) {
            System.out.print(d + " ");
        }
        System.out.println();
    }
}
