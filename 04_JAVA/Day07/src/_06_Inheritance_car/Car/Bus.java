package _06_Inheritance_car.Car;

// Bus 클래스는 Car 클래스를 상속받는 자식 클래스입니다.
// 버스만의 특성과 기능을 정의합니다.
public class Bus extends Car {
    // 필드: 버스에 탑승한 승객 수를 저장합니다.
    int numberOfPeople;

    // 생성자: Bus 객체를 생성할 때 호출됩니다.
    // `numberOfPeople` 필드를 초기화합니다.
    Bus(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    // 메소드: 승객이 버스에 탑승하는 기능을 정의합니다.
    void takePerson() {
        System.out.println("승객이 버스에 탑승했습니다.");
        numberOfPeople++; // 승객 수 1 증가

        System.out.printf("현재까지 탑승한 승객의 수 : %d명%n", numberOfPeople);
    }
}
