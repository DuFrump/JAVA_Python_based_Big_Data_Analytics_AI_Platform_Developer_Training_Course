package _07_Reporter;

// Reportable 인터페이스는 보고 기능을 가진 모든 객체가 가져야 할 공통적인 기능을 정의합니다.
// 이 인터페이스를 구현하는 클래스는 `report()` 메소드를 반드시 구현해야 합니다.
public interface Reportable {
    // 추상 메소드: `report()`
    // 보고하는 기능을 정의합니다.
    void report();
}
