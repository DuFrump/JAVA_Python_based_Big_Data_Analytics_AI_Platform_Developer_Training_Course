package _06_Inheritance_car.Car;

/**
 * SchoolBus 클래스는 Bus 클래스를 상속받는 '자식 클래스'입니다.
 * 'extends Bus'를 통해 Bus의 모든 속성과 기능을 물려받습니다.
 *
 * 이로써 'Car -> Bus -> SchoolBus'로 이어지는
 * '다단계 상속(Multi-level Inheritance)'의 구조를 가지게 됩니다.
 *
 * 또한, 이 클래스에는 'final' 키워드가 붙어 있습니다.
 * 'final class SchoolBus'는 SchoolBus 클래스가 더 이상 다른 클래스에게
 * 상속될 수 없다는 것을 의미합니다. 즉, SchoolBus는 '최종적인' 클래스입니다.
 *
 * 스쿨버스만의 특성과 기능을 추가하면서 다단계 상속과 final 클래스의 의미를 함께 살펴봅시다.
 */
public final class SchoolBus extends Bus { // final 클래스: 더 이상 상속될 수 없습니다.

    // === 생성자 (Constructor) ===
    /**
     * SchoolBus 객체를 생성할 때 호출되는 생성자입니다.
     * 'super(numberOfPeople)'를 통해 부모 클래스(Bus)의 생성자를 호출하여
     * Bus의 numberOfPeople 필드를 초기화합니다.
     *
     * 다단계 상속에서는 가장 마지막 자식 클래스의 생성자가 호출될 때,
     * 그 부모의 생성자, 그리고 그 부모의 부모 생성자... 순으로
     * 최상위 부모까지 생성자가 연쇄적으로 호출됩니다.
     */
    public SchoolBus(int numberOfPeople) {
        super(numberOfPeople); // Bus 클래스의 생성자 호출
    }

    // === 메소드 (Methods) ===

    /**
     * 메소드 오버라이딩: takePerson()
     * 부모 클래스(Bus)의 takePerson() 메소드를 재정의합니다.
     *
     * 'super.takePerson()'을 통해 부모인 Bus의 takePerson() 기능을 먼저 실행한 후,
     * 스쿨버스만의 추가적인 동작(학생들이 착석하고 출발)을 정의합니다.
     */
    @Override
    public void takePerson() {
        super.takePerson(); // Bus 클래스의 takePerson() 메소드 호출 (승객 수 증가 및 출력)
        System.out.println("학생들이 자리에 모두 착석하고 출발합니다."); // 스쿨버스만의 추가 동작
    }

    /**
     * 메소드 오버라이딩: ride()
     * 부모 클래스(Car)로부터 상속받은 ride() 메소드를 재정의합니다.
     * (Bus 클래스에서도 ride()를 오버라이딩했으므로, 이 메소드는 Bus의 ride()를 오버라이딩합니다.)
     *
     * 스쿨버스만의 주행 방식(안전 운행)을 출력하고,
     * 'super.ride()'를 통해 바로 위 부모인 Bus 클래스의 ride() 메소드를 호출합니다.
     * 만약 Bus의 ride()가 없었다면 Car의 ride()가 호출되었을 것입니다.
     */
    @Override
    public void ride() {
        System.out.println("스쿨버스가 시속 50km/h로 안전 운행합니다."); // 스쿨버스만의 주행 방식
        super.ride(); // Bus 클래스의 ride() 메소드 호출 (Bus의 ride()가 없다면 Car의 ride() 호출)
    }
}