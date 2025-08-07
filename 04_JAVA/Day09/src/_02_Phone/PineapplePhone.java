package _02_Phone;

// PineapplePhone 클래스는 Phone 추상 클래스를 상속받는 자식 클래스입니다.
// Phone 클래스의 추상 메소드인 `openingLogo()`를 반드시 구현해야 합니다.
public class PineapplePhone extends Phone {
    // 추상 메소드 구현: `openingLogo()`
    // 부모 클래스(Phone)의 추상 메소드를 오버라이딩하여 파인애플 폰만의 로고를 출력합니다.
    @Override
    void openingLogo() {
        System.out.println("★★★"); // 파인애플 폰의 로고 출력
    }

    // [참고] Phone 클래스의 일반 메소드(powerOn(), powerOff())는 별도로 오버라이딩하지 않아도
    // PineapplePhone 객체에서 그대로 사용할 수 있습니다.
}
