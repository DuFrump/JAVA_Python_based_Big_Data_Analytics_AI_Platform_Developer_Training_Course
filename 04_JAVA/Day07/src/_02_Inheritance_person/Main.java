package _02_Inheritance_person;

public class Main {
    public static void main(String[] args) {
        Customer c01 = new Customer("김수한", 26, 'M', 300403);
        c01.enter();

        Customer c02 = new Customer("조무개", 30, 'F', 300404);
        c02.enter();

        Customer c03 = new Customer("한무개", 22, 'D', 300405);
        c03.enter();
    }
}
