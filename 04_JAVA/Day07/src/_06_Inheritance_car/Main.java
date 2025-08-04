package _06_Inheritance_car;

import _06_Inheritance_car.Car.SchoolBus;

public class Main {
    public static void main(String[] args) {
        SchoolBus sb01 = new SchoolBus(10);

        sb01.takePerson();
        sb01.ride();
    }
}
