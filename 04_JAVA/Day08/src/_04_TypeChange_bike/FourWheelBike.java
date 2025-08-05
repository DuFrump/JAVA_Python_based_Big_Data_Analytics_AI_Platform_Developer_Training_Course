package _04_TypeChange_bike;

public class FourWheelBike extends Bike {
    FourWheelBike(String riderName) {
        super(riderName);
    }

    @Override
    void info() {
        super.info();
    }

    void addWheel() {
        if (wheel == 2) {
            wheel = 4;
            System.out.printf("%s의 자전거에 보조 바퀴 부착!%n", riderName);
        } else {
            System.out.printf("%s의 자전거는 이미 보조 바퀴가 있음!%n", riderName);
        }
    }
}
