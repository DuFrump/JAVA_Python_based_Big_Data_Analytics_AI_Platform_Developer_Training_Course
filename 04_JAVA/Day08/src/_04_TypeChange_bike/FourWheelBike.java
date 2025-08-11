package _04_TypeChange_bike;

/**
 * 안녕하세요, 두프룸프님! 이번에는 `Bike` 클래스를 상속받는 '네발 자전거'를 만들어볼 거예요.
 * `FourWheelBike` 클래스는 `Bike` 클래스의 '자식 클래스(Subclass)'입니다.
 * 네발 자전거는 일반 자전거의 기본적인 속성(라이더 이름, 바퀴 수)과 기능(정보 출력, 달리기)을 물려받으면서도,
 * 자신만의 특별한 기능(보조 바퀴 부착)을 가지고 있고, 부모의 기능을 자신에게 맞게 사용할 수 있죠.
 *
 * 이 예제에서는 다음을 중점적으로 살펴볼 거예요:
 * 1. 부모 클래스의 생성자를 호출하여 필드를 초기화하는 방법 (`super()`)
 * 2. 부모 클래스의 메소드를 자식 클래스에서 '재정의(Overriding)'하면서 부모의 기능을 재활용하는 방법 (`super.메소드()`)
 * 3. 자식 클래스만의 고유한 메소드를 추가하고, 상속받은 필드를 활용하는 방법
 *
 * 자, 그럼 네발 자전거를 함께 만들어볼까요?
 */
public class FourWheelBike extends Bike {
    // 생성자(Constructor): `FourWheelBike` 객체를 만들 때 호출됩니다.
    // `super(riderName)`는 부모 클래스인 `Bike`의 생성자를 호출하는 거예요.
    // 이렇게 하면 부모 클래스에서 정의된 `riderName` 필드를 초기화할 수 있답니다.
    FourWheelBike(String riderName) {
        super(riderName);
    }

    // [1] 메소드 오버라이딩(Method Overriding): `info()` 메소드
    // `@Override` 어노테이션은 이 메소드가 부모 클래스(`Bike`)의 `info()` 메소드를
    // 재정의(Overriding)했다는 것을 명확히 알려줍니다.
    // 여기서는 `super.info()`를 호출하여 부모의 `info()` 메소드를 그대로 사용하고 있어요.
    // 만약 자식 클래스에서 부모의 기능을 그대로 사용하면서 추가적인 작업을 하고 싶을 때 유용하게 쓰입니다.
    @Override
    void info() {
        super.info(); // 부모 클래스의 info() 메소드를 호출하여 기본 정보를 출력합니다.
    }

    // [2] `FourWheelBike` 고유의 메소드: `addWheel()`
    // 이 메소드는 `FourWheelBike` 클래스에만 있는 특별한 기능이에요.
    // 자전거에 보조 바퀴를 부착하여 바퀴 수를 2개에서 4개로 변경하는 기능을 구현했습니다.
    // 부모로부터 상속받은 `wheel` 필드를 직접 변경하고 있죠?
    void addWheel() {
        if (wheel == 2) { // 현재 바퀴가 2개(기본 자전거)인 경우에만 보조 바퀴를 부착할 수 있어요.
            wheel = 4; // 바퀴 수를 4개로 변경합니다.
            System.out.printf("%s의 자전거에 보조 바퀴 부착! 이제 %d발 자전거가 되었어요!%n", riderName, wheel);
        } else {
            System.out.printf("%s의 자전거는 이미 보조 바퀴가 있거나 2발 자전거가 아닙니다!%n", riderName);
        }
    }
}
