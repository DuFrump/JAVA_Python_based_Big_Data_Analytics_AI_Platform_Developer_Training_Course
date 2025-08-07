package _02_Inheritance_person;

// Main 클래스는 Person과 Customer 클래스를 사용하여 객체를 생성하고 상속 관계를 확인하는 예제입니다.
public class Main {
    public static void main(String[] args) {
        // [1] Customer 객체 생성 및 사용
        // Customer 클래스의 객체 c01을 생성합니다.
        // 생성자 호출 시 이름, 나이, 성별(Person으로부터 상속), 회원번호(Customer 고유)를 전달합니다.
        Customer c01 = new Customer("김수한", 26, 'M', 300403);
        c01.enter(); // c01 객체의 enter() 메소드 호출

        // [2] 두 번째 Customer 객체 생성 및 사용
        Customer c02 = new Customer("조무개", 30, 'F', 300404);
        c02.enter();

        // [3] 유효하지 않은 성별 값으로 Customer 객체 생성 및 사용
        // Customer 클래스의 enter() 메소드에서 'D'와 같은 유효하지 않은 성별 값에 대한 처리를 확인할 수 있습니다.
        Customer c03 = new Customer("한무개", 22, 'D', 300405);
        c03.enter();

        System.out.println("
----------------------------------------
");

        // [4] 부모 클래스(Person)의 메소드 호출 (상속받은 메소드)
        // Customer 객체는 Person으로부터 상속받은 info() 메소드도 사용할 수 있습니다.
        System.out.println("--- Person 클래스의 info() 메소드 호출 (Customer 객체) ---");
        c01.info();
        c02.info();
        c03.info();

        // [5] Person 객체 직접 생성 및 사용
        System.out.println("
--- Person 객체 직접 생성 ---");
        Person p01 = new Person("박철수", 40, 'M');
        p01.info();
    }
}
