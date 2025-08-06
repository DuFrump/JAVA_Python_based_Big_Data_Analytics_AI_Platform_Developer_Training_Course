package _02_Phone;

public abstract class Phone {
    abstract void openingLogo(); // 자식 클래스에서 무조건 오버라이딩 해야함.

    void powerOn() {
        // openingLogo();
        System.out.println("핸드폰이 켜집니다.");
    }

    void powerOff() {
        System.out.println("핸드폰이 꺼집니다.");
    }
}
