package _08_Quiz;

public class Main {
    public static void main(String[] args) {
        Employee em1 = new Employee("홍길동");
        Manager mng1 = new Manager("김철수");

        em1.work();
        em1.showInfo();

        System.out.println();

        mng1.work();
        mng1.showInfo();
    }
}
