package _08_Quiz;

public class Manager extends Employee {
    Manager(String name) {
        super(name);
        this.position = "관리자";
    }

    @Override
    void work() {
        String name = getName();
        System.out.printf("%s은(는) 회의를 주재합니다.%n", name);
    }

    @Override
    void showInfo() {
        super.showInfo();
        System.out.println("추가 역할: 팀 관리");
    }
}
