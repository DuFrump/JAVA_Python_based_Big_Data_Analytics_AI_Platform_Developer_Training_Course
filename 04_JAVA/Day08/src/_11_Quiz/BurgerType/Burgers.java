package _11_Quiz.BurgerType;

public class Burgers {
    String name;

    Burgers(String name) {
        this.name = name;
    }

    void cook() {
        System.out.printf("%s 재료%n", name);
        System.out.println("양상추");
        System.out.println("패티");

        if (name.contains("새우")) {
            System.out.println("새우 추가");
        } else if (name.contains("치즈")) {
            System.out.println("치즈 추가");
        }
    }
}
