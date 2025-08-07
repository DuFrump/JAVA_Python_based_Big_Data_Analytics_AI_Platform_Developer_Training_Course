package _02_Phone;

// Main 클래스는 Phone 추상 클래스와 이를 구현한 PineapplePhone 클래스를 사용하는 예제입니다.
public class Main {
    public static void main(String[] args) {
        // [1] PineapplePhone 객체 생성
        // PineapplePhone은 Phone 추상 클래스를 구현한 클래스이므로 객체 생성이 가능합니다.
        PineapplePhone pp = new PineapplePhone();

        System.out.println("--- 파인애플 폰 동작 ---");

        // [2] `powerOn()` 메소드 호출
        // Phone 클래스에서 상속받은 일반 메소드입니다.
        pp.powerOn(); // 출력: 핸드폰이 켜집니다.

        // [3] `openingLogo()` 메소드 호출
        // Phone 클래스의 추상 메소드를 PineapplePhone에서 구현한 메소드입니다.
        pp.openingLogo(); // 출력: ★★★

        // [4] `powerOff()` 메소드 호출
        // Phone 클래스에서 상속받은 일반 메소드입니다.
        pp.powerOff(); // 출력: 핸드폰이 꺼집니다.
    }
}
