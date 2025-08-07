package _06_Inheritance_car.Car;

// SchoolBus 클래스는 Bus 클래스를 상속받는 자식 클래스입니다.
// `final` 키워드가 붙어 있으므로, SchoolBus 클래스는 더 이상 다른 클래스에게 상속될 수 없습니다.
public final class SchoolBus extends Bus {
    // 생성자: SchoolBus 객체를 생성할 때 호출됩니다.
    // `super(numberOfPeople)`를 통해 부모 클래스(Bus)의 생성자를 호출하여 `numberOfPeople`을 초기화합니다.
    public SchoolBus(int numberOfPeople) {
        super(numberOfPeople); // Bus 클래스의 생성자 호출
    }

    // 메소드 오버라이딩: `takePerson()`
    // 부모 클래스(Bus)의 `takePerson()` 메소드를 재정의합니다.
    // `super.takePerson()`을 통해 부모의 기능을 먼저 실행한 후, 추가적인 동작을 정의합니다.
    @Override
    public void takePerson() {
        super.takePerson(); // Bus 클래스의 takePerson() 메소드 호출
        System.out.println("학생들이 자리에 모두 착석하고 출발."); // 스쿨버스만의 추가 동작
    }

    // 메소드 오버라이딩: `ride()`
    // 부모 클래스(Car)로부터 상속받은 `ride()` 메소드를 재정의합니다.
    @Override
    public void ride() {
        System.out.println("시속 50km/h로 안전 운행합니다."); // 스쿨버스만의 주행 방식
        super.ride(); // Car 클래스의 ride() 메소드 호출 (달립니다. 출력)
    }
}
