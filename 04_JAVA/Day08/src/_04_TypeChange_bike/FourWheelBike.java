package _04_TypeChange_bike;

// FourWheelBike 클래스는 Bike 클래스를 상속받는 자식 클래스(Subclass)입니다.
// 네발 자전거의 특성과 기능을 정의합니다.
public class FourWheelBike extends Bike {
    // 생성자: FourWheelBike 객체를 생성할 때 호출됩니다.
    // `super(riderName)`를 통해 부모 클래스(Bike)의 생성자를 호출하여 `riderName`을 초기화합니다.
    FourWheelBike(String riderName) {
        super(riderName);
    }

    // [1] 메소드 오버라이딩: `info()`
    // 부모 클래스(Bike)의 `info()` 메소드를 재정의합니다.
    // 여기서는 `super.info()`를 호출하여 부모의 기능을 그대로 사용합니다.
    @Override
    void info() {
        super.info();
    }

    // [2] FourWheelBike 고유의 메소드: `addWheel()`
    // 자전거에 보조 바퀴를 부착하는 기능을 정의합니다.
    // 부모로부터 상속받은 `wheel` 필드를 직접 변경합니다.
    void addWheel() {
        if (wheel == 2) { // 현재 바퀴가 2개(기본 자전거)인 경우에만 보조 바퀴 부착
            wheel = 4; // 바퀴 수를 4개로 변경
            System.out.printf("%s의 자전거에 보조 바퀴 부착!%n", riderName);
        } else {
            System.out.printf("%s의 자전거는 이미 보조 바퀴가 있음!%n", riderName);
        }
    }
}
