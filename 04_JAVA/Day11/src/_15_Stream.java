import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_Stream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        list.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        List<String> list2 = Arrays.asList("Java", "Lambda", "Stream");

        list2.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        List<String> names = Arrays.asList("김철수", "이영희", "김민수");

        names.stream()
                .filter(name -> name.startsWith("김"))
                .forEach(System.out::println);

        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5, 6);

        list3.stream()
                .filter(n -> n > 3)
                .limit(2)
                .forEach(System.out::println);
    }
}
