package _06_Inheritance_car;

// SchoolBus 클래스를 사용하기 위해 import 합니다.
import _06_Inheritance_car.Car.SchoolBus;

// Main 클래스는 SchoolBus 객체를 생성하고 메소드를 호출하여 상속과 오버라이딩의 동작을 확인하는 예제입니다.
public class Main {
    public static void main(String[] args) {
        // SchoolBus 객체 sb01을 생성합니다.
        // 생성자 호출 시 초기 승객 수(10명)를 전달합니다.
        SchoolBus sb01 = new SchoolBus(10);

        System.out.println("--- 스쿨버스 운행 시작 ---");

        // [1] `takePerson()` 메소드 호출
        // SchoolBus에서 오버라이딩된 `takePerson()` 메소드가 호출됩니다.
        // 이 메소드 내부에서 `super.takePerson()`을 통해 Bus 클래스의 `takePerson()`도 호출됩니다.
        sb01.takePerson();
        // 예상 출력:
        // 승객이 버스에 탑승했습니다.
        // 현재까지 탑승한 승객의 수 : 11명
        // 학생들이 자리에 모두 착석하고 출발.

        System.out.println("
----------------------------------------
");

        // [2] `ride()` 메소드 호출
        // SchoolBus에서 오버라이딩된 `ride()` 메소드가 호출됩니다.
        // 이 메소드 내부에서 `super.ride()`를 통해 Car 클래스의 `ride()`도 호출됩니다.
        sb01.ride();
        // 예상 출력:
        // 시속 50km/h로 안전 운행합니다.
        // 달립니다.

        System.out.println("
--- 스쿨버스 운행 종료 ---");
    }
}
