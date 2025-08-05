package _04_TypeChange_bike;

public class Bike {
    String riderName;
    int wheel = 2;

    Bike(String riderName) {
        this.riderName = riderName;
    }

    void info() {
        System.out.printf("%s의 자전거는 %d발 자전거 입니다.%n", riderName, wheel);
    }

    void ride() {
        System.out.println("~~~씽씽~~~");
    }
}
