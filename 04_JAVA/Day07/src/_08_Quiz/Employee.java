package _08_Quiz;

public class Employee {
    private String name;
    protected String position;

    Employee(String name) {
        this.name = name;
        this.position = "직원";
    }

    public String getName() {
        return name;
    }

    void work() {
        System.out.printf("%s은(는) 업무를 수행합니다.%n", name);
    }

    void showInfo() {
        System.out.printf("%s / 직책: %s%n", name, position);
    }
}
