import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.printf("이름 : %s, 나이 : %d%n", name, age);
    }
}

public class _09_ArrayList {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("철수", 23));
        people.add(new Person("영희", 31));
        people.add(new Person("민수", 26));
        people.add(new Person("영수", 19));
        people.add(new Person("민희", 43));
        people.add(new Person("규희", 26));

        for (Person p : people) {
            p.introduce();
        }
    }
}
