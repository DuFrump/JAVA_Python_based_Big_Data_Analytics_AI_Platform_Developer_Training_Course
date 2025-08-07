package _03_TypeChange_calendar;

// DeskCalendar 클래스는 Calendar 클래스를 상속받는 자식 클래스(Subclass)입니다.
// 탁상 달력만의 특성과 기능을 정의하고, 부모 클래스의 메소드를 오버라이딩합니다.
public class DeskCalendar extends Calendar {
    // 생성자: DeskCalendar 객체를 생성할 때 호출됩니다.
    // `super(color, months)`를 통해 부모 클래스(Calendar)의 생성자를 호출하여 필드를 초기화합니다.
    DeskCalendar(String color, int months) {
        super(color, months);
    }

    // [1] 메소드 오버라이딩: `hanging()`
    // 부모 클래스(Calendar)의 `hanging()` 메소드를 재정의합니다.
    // 탁상 달력은 벽에 걸 수 있지만, 추가적인 설명이 필요합니다.
    @Override
    void hanging() {
        System.out.printf("%s 달력을 벽에 걸려면 추가 고리 필요.%n", color);
    }

    // [2] DeskCalendar 고유의 메소드: `onTheDesk()`
    // 탁상 달력은 책상에 세울 수 있는 기능을 정의합니다.
    void onTheDesk() {
        System.out.printf("%s 달력은 책상에 세울 수 있습니다.%n", color);
    }
}
