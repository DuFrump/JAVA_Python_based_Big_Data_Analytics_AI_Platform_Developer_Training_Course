package _06_Inheritance_car.Car;

/**
 * Bus 클래스는 Car 클래스를 상속받는 '자식 클래스'입니다.
 * 'extends Car'를 통해 Car의 모든 속성과 기능을 물려받습니다.
 *
 * 이 클래스에서는 일반적인 자동차의 기능(달리기) 외에,
 * '버스'만이 가질 수 있는 특별한 속성(승객 수)과 기능(승객 탑승)을 추가해 볼 거예요.
 */
public class Bus extends Car {

    // === 필드 (Fields) ===
    // Car 클래스로부터는 특별한 필드를 물려받지 않았지만,
    // 버스만의 고유한 속성인 '현재 탑승한 승객 수'를 저장할 변수를 추가합니다.
    int numberOfPeople;

    // === 생성자 (Constructor) ===
    /**
     * Bus 객체를 생성할 때 호출되는 생성자입니다.
     * 버스를 만들 때 초기 승객 수를 설정할 수 있도록 매개변수를 받습니다.
     *
     * 참고: 부모 클래스인 Car에는 매개변수 있는 생성자가 없으므로,
     * 여기서 super()를 명시적으로 호출할 필요는 없습니다.
     * 컴파일러가 자동으로 super() (매개변수 없는 부모 생성자)를 호출해줍니다.
     */
    public Bus(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople; // 매개변수로 받은 승객 수로 필드를 초기화
    }

    // === 메소드 (Methods) ===
    /**
     * 승객이 버스에 탑승하는 기능을 수행하는 메소드입니다.
     * 이 메소드가 호출되면 승객 수가 1 증가하고, 현재 탑승한 승객 수를 출력합니다.
     */
    public void takePerson() {
        System.out.println("승객이 버스에 탑승했습니다.");
        numberOfPeople++; // 승객 수 1 증가
        System.out.printf("현재까지 탑승한 승객의 수 : %d명%n", numberOfPeople);
    }

    /**
     * (추가) 부모 클래스의 ride() 메소드를 오버라이딩하여 버스에 맞게 변경해볼까요?
     * 버스는 승객을 태우고 달린다는 의미를 추가할 수 있습니다.
     */
    @Override
    public void ride() {
        System.out.println("버스가 승객을 태우고 달립니다.");
    }
}