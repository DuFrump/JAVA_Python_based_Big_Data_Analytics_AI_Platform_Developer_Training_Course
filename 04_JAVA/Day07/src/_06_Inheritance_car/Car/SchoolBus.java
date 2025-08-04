package _06_Inheritance_car.Car;

public final class SchoolBus extends Bus {
    public SchoolBus(int numberOfPeople) {
        super(numberOfPeople); // 버스 클래스의 생성자 호출
    }

    @Override
    public void takePerson() {
        super.takePerson();
        System.out.println("학생들이 자리에 모두 착석하고 출발.");
    }

    @Override
    public void ride() {
        System.out.println("시속 50km/h로 안전 운행합니다.");
        super.ride();
    }
}
