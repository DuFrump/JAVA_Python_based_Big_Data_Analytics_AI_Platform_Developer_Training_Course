package _06_Inheritance_car.Car;

public class Bus extends Car {
    int numberOfPeople;

    Bus(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    void takePerson() {
        System.out.println("승객이 버스에 탑승했습니다.");
        numberOfPeople++;

        System.out.printf("현재까지 탑승한 승객의 수 : %d명%n", numberOfPeople);
    }
}
