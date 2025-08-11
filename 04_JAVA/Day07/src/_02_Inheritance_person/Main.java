package _02_Inheritance_person;

/**
 * 두 번째 예제의 마지막 파일, Main 클래스입니다!
 * 여기서는 우리가 만든 Person과 Customer 클래스를 실제로 사용해보면서,
 * 상속과 생성자의 관계를 눈으로 확인하는 중요한 시간이에요.
 *
 * 'public static void main(String[] args)' 메소드는 자바 프로그램이 시작되는 지점이라는 것,
 * 이제는 잘 아시죠? 여기서 객체를 만들고 메소드를 호출하면서 동작을 살펴봅시다.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("--- Customer 객체 생성 및 사용 ---");

        // [1] 첫 번째 Customer 객체 생성
        // Customer 객체를 생성할 때는 Person의 생성자가 요구하는 정보(이름, 나이, 성별)와
        // Customer 고유의 정보(회원번호)를 모두 전달해야 합니다.
        // 이 순간, Customer 생성자 내부에서 super()를 통해 Person 생성자가 먼저 호출됩니다.
        Customer c01 = new Customer("김수한", 26, 'M', 300403);
        System.out.println("c01 객체 생성 완료!");

        // c01 객체의 enter() 메소드 호출: Customer 클래스에 정의된 입장 메시지를 출력합니다.
        c01.enter();

        System.out.println("\n--- 두 번째 Customer 객체 생성 및 사용 ---");

        // [2] 두 번째 Customer 객체 생성
        Customer c02 = new Customer("조무개", 30, 'F', 300404);
        System.out.println("c02 객체 생성 완료!");
        c02.enter();

        System.out.println("\n--- 유효하지 않은 성별 값으로 Customer 객체 생성 및 사용 ---");

        // [3] 유효하지 않은 성별 값으로 Customer 객체 생성
        // 'D'와 같은 유효하지 않은 성별 값을 넣었을 때,
        // Customer 클래스의 enter() 메소드에서 어떻게 처리되는지 확인해 보세요.
        Customer c03 = new Customer("한무개", 22, 'D', 300405);
        System.out.println("c03 객체 생성 완료!");
        c03.enter();

        System.out.println("\n----------------------------------------\n");

        // [4] Customer 객체에서 부모 클래스(Person)의 info() 메소드 호출 (오버라이딩된 메소드)
        // Customer 클래스에서 info() 메소드를 오버라이딩했기 때문에,
        // Customer 객체에서 info()를 호출하면 Customer에 정의된 info()가 실행됩니다.
        // 이 info() 메소드 안에서는 super.info()를 통해 부모의 info()도 함께 호출하고 있죠.
        System.out.println("--- Customer 객체에서 info() 메소드 호출 (오버라이딩 확인) ---");
        System.out.println("c01의 정보:");
        c01.info();
        System.out.println("\nc02의 정보:");
        c02.info();
        System.out.println("\nc03의 정보:");
        c03.info();

        System.out.println("\n--- Person 객체 직접 생성 및 사용 ---");

        // [5] Person 객체 직접 생성
        // Customer가 아닌, 순수한 Person 객체를 생성해봅니다.
        // Person 클래스의 생성자를 사용하여 이름, 나이, 성별을 전달합니다.
        Person p01 = new Person("박철수", 40, 'M');
        System.out.println("p01 객체 생성 완료!");
        p01.info(); // Person 클래스의 info() 메소드가 실행됩니다.

        // 이 예제를 통해 상속 관계에서 생성자가 어떻게 동작하고,
        // 메소드 오버라이딩이 실제 객체의 동작에 어떤 영향을 미치는지 잘 이해하셨기를 바랍니다!
    }
}