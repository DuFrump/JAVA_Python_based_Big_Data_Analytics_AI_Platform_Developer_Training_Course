package _03_TypeChange_calendar;

public class Main {
    public static void main(String[] args) {
        Calendar c1 = new Calendar("빨간색", 12);
        DeskCalendar dc1 = new DeskCalendar("검정색", 12);

        c1.hanging();
        dc1.info();
        dc1.hanging();
        dc1.onTheDesk();

        System.out.println("====================================");

        Calendar c2 = new DeskCalendar("파랑색", 12);
        c2.info();
        c2.hanging();
//        c2.onTheDesk(); -------------> 자식에게만 있는 메서드라서 사용 불가 (Override 된 메서드도 아니고 자식에게만 가지고 있는 메서드)
    }
}
