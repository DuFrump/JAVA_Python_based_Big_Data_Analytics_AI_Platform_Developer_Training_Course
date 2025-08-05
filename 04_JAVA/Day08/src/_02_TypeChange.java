class Car {}

class Bus extends Car {}
class SchoolBus extends Bus {}

class OpenCar extends Car {}
class SportsCar extends OpenCar {}

public class _02_TypeChange {
    public static void main(String[] args) {
        Car c1 = new SchoolBus();
        Car b1 = new Bus();
        Bus b2 = new SchoolBus();

        Car c2 = new OpenCar();
        Car c3 = new SportsCar();
        OpenCar oc = new SportsCar();

        // 다형성은 위 아래로만 가능. (부모 자식 / 조부모 자식 / 조부모 부모 등등..)
//        Bus b3 = new OpenCar();
    }
}
