package _03_TypeChange_calendar;

public class DeskCalendar extends Calendar {
    DeskCalendar(String color, int months) {
        super(color, months);
    }

    @Override
    void hanging() {
        System.out.printf("%s 달력을 벽에 걸려면 추가 고리 필요.%n", color);
    }

    void onTheDesk() {
        System.out.printf("%s 달력은 책상에 세울 수 있습니다.%n", color);
    }
}
