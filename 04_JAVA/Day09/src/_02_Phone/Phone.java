package _02_Phone;

// Phone 클래스는 추상 클래스(Abstract Class)입니다.
// 모든 휴대폰의 공통적인 기능을 정의하며, 특정 기능(openingLogo)은 자식 클래스에서 반드시 구현하도록 강제합니다.
public abstract class Phone {
    // 추상 메소드(Abstract Method): `openingLogo()`
    // - 선언만 있고 구현(몸체)이 없는 메소드입니다.
    // - `abstract` 키워드를 사용하며, 반드시 추상 클래스 내에 선언되어야 합니다.
    // - 이 메소드는 자식 클래스에서 무조건 오버라이딩하여 구현해야 합니다.
    abstract void openingLogo();

    // 일반 메소드: 핸드폰 전원을 켜는 기능
    void powerOn() {
        // `openingLogo()`를 여기서 호출하면, 실제 실행 시에는 자식 클래스에서 구현된 메소드가 호출됩니다.
        // openingLogo(); // 주석 처리된 이유는, 자식 클래스에서 구현된 로고가 먼저 보이고 싶을 때 사용
        System.out.println("핸드폰이 켜집니다.");
    }

    // 일반 메소드: 핸드폰 전원을 끄는 기능
    void powerOff() {
        System.out.println("핸드폰이 꺼집니다.");
    }
}
