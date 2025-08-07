package _04_TypeChange_bike;

// Bike 클래스는 모든 자전거의 기본적인 속성과 기능을 나타내는 부모 클래스(Superclass)입니다.
public class Bike {
    // 필드: 자전거를 타는 사람의 이름과 바퀴 수를 저장합니다.
    String riderName; // 라이더 이름
    int wheel = 2;    // 바퀴 수 (기본값 2)

    // 생성자: Bike 객체를 생성할 때 라이더 이름을 초기화합니다.
    Bike(String riderName) {
        this.riderName = riderName;
    }

    // 메소드: 자전거의 정보를 출력합니다.
    void info() {
        System.out.printf("%s의 자전거는 %d발 자전거 입니다.%n", riderName, wheel);
    }

    // 메소드: 자전거가 달리는 소리를 출력합니다.
    void ride() {
        System.out.println("~~~씽씽~~~");
    }
}
