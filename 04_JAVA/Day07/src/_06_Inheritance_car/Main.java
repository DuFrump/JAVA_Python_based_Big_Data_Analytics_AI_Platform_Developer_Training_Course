package _06_Inheritance_car;

// Car, Bus, SchoolBus 클래스를 사용하기 위해 import 합니다.
// 같은 패키지 내의 Car 폴더에 있으므로 명시적으로 import 해야 합니다.
import _06_Inheritance_car.Car.Car;
import _06_Inheritance_car.Car.Bus;
import _06_Inheritance_car.Car.SchoolBus;

/**
 * 여섯 번째 예제의 마지막 파일, Main 클래스입니다!
 * 여기서는 우리가 만든 Car, Bus, SchoolBus 클래스들의 객체를 생성하고,
 * 그 기능들을 호출하면서 '다단계 상속'과 '메소드 오버라이딩'이 어떻게 동작하는지
 * 직접 확인하는 중요한 시간이에요.
 *
 * 'public static void main(String[] args)' 메소드는 자바 프로그램이 시작되는 지점이라는 것,
 * 이제는 잘 아시죠? 여기서 객체를 만들고 메소드를 호출하면서 동작을 살펴봅시다.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("--- [1] Car 객체 테스트 ---");
        Car myCar = new Car();
        myCar.ride(); // Car 클래스의 ride() 메소드 호출: "달립니다."

        System.out.println("\n--- [2] Bus 객체 테스트 ---");
        // Bus 객체 생성 시 초기 승객 수를 전달합니다.
        Bus myBus = new Bus(5);
        myBus.ride(); // Bus 클래스에서 오버라이딩된 ride() 메소드 호출: "버스가 승객을 태우고 달립니다."
        myBus.takePerson(); // Bus 클래스의 takePerson() 메소드 호출

        System.out.println("\n--- [3] SchoolBus 객체 테스트 ---");
        // SchoolBus 객체 생성 시 초기 승객 수를 전달합니다.
        SchoolBus mySchoolBus = new SchoolBus(10);

        System.out.println("\n--- 스쿨버스 운행 시작 ---");

        // [3-1] takePerson() 메소드 호출
        // SchoolBus에서 오버라이딩된 takePerson() 메소드가 호출됩니다.
        // 이 메소드 내부에서 super.takePerson()을 통해 Bus 클래스의 takePerson()도 호출됩니다.
        mySchoolBus.takePerson();
        // 예상 출력:
        // 승객이 버스에 탑승했습니다.
        // 현재까지 탑승한 승객의 수 : 11명
        // 학생들이 자리에 모두 착석하고 출발합니다.

        System.out.println("----------------------------------------");

        // [3-2] ride() 메소드 호출
        // SchoolBus에서 오버라이딩된 ride() 메소드가 호출됩니다.
        // 이 메소드 내부에서 super.ride()를 통해 Bus 클래스의 ride()가 호출되고,
        // Bus의 ride() 내부에서 다시 super.ride()를 통해 Car 클래스의 ride()가 호출됩니다.
        mySchoolBus.ride();
        // 예상 출력:
        // 스쿨버스가 시속 50km/h로 안전 운행합니다.
        // 버스가 승객을 태우고 달립니다.
        // 달립니다.

        System.out.println("\n--- 스쿨버스 운행 종료 ---");

        System.out.println("\n--- 모든 자동차 예제 테스트 완료 ---");
        System.out.println("다단계 상속과 메소드 오버라이딩이 어떻게 동작하는지 잘 이해하셨기를 바랍니다!");
    }
}