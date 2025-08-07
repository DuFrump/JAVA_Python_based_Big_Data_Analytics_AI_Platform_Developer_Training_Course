package _03_TypeChange_calendar;

// Calendar 클래스는 모든 달력의 기본적인 속성과 기능을 나타내는 부모 클래스(Superclass)입니다.
public class Calendar {
    // 필드: 달력의 색상과 월 수를 저장합니다.
    String color;  // 달력의 색상
    int months;    // 달력의 월 수 (예: 12월까지)

    // 생성자: Calendar 객체를 생성할 때 색상과 월 수를 초기화합니다.
    Calendar(String color, int months) {
        this.color = color;
        this.months = months;
    }

    // 메소드: 달력의 기본 정보를 출력합니다.
    void info() {
        System.out.printf("%s 달력은 %d월까지 있습니다.%n", color, months);
    }

    // 메소드: 달력을 벽에 걸 수 있음을 나타냅니다.
    void hanging() {
        System.out.printf("%s 달력은 벽에 걸 수 있습니다.%n", color);
    }
}
