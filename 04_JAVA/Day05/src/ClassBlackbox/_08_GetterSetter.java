package ClassBlackbox;

/**
 * 두프룸프님, 드디어 객체 지향의 핵심 원칙 중 하나인 '캡슐화(Encapsulation)'와 관련된
 * 'Getter'와 'Setter' 메소드에 대해 배울 시간이에요. 조금 어려운 개념일 수 있지만 아주 중요하답니다!
 *
 * 캡슐화는 "소중한 데이터는 꽁꽁 숨겨두고, 정해진 통로(메소드)를 통해서만 접근을 허용하라"는 원칙이에요.
 * 왜냐하면, 객체의 변수(데이터)를 외부에서 마음대로 바꾸게 내버려두면,
 * 가격이 음수가 되거나, 필수 값이 비어있는 등 예상치 못한 심각한 오류가 발생할 수 있기 때문이죠.
 *
 * - Setter: 외부에서 전달된 값이 올바른지 검사한 후, 안전하게 변수 값을 설정(Set)하는 역할을 해요. (입력 데이터 검증)
 * - Getter: 변수 값을 외부에 보여주기 전에, 적절한 형태로 가공하거나, 정해진 값만 보여주도록 제어하는 역할을 해요. (출력 데이터 가공)
 */
public class _08_GetterSetter {
    public static void main(String[] args) {
        BlackBox b1 = new BlackBox();
        b1.modelName = "까망이";
        // b1.price = 200000; // 원래는 이렇게 직접 접근하면 안돼요! (지금은 변수가 public이라 가능)
        // b1.color = "블랙";

        // [1] Setter를 사용하지 않았을 때의 문제점
        // 누군가 실수로 가격을 음수로 설정하려고 한다면? 막을 방법이 없어요.
        // b1.price = -5000;
        // System.out.println("잘못 설정된 가격: " + b1.price);

        System.out.println("--- Getter & Setter 사용 ---");

        // [2] Setter: 안전하게 값 설정하기
        // 이제부터 가격은 반드시 setPrice() 라는 문지기(메소드)를 통해서만 설정하도록 약속해요.
        // BlackBox.java의 setPrice() 메소드 안에는 "만약 10만원보다 작은 값이 들어오면, 강제로 10만원으로 설정한다"는 로직이 들어있어요.
        b1.setPrice(200000); // 20만원은 정상 범위이므로 그대로 설정됩니다.

        // [3] Getter: 안전하게 값 가져오기
        // 가격을 확인할 때도 반드시 getPrice() 라는 문지기를 통해 확인해요.
        System.out.println("현재 설정된 가격: " + b1.getPrice() + "원");

        // 만약 누군가 실수로 가격을 -5000원으로 설정하려고 시도하면?
        b1.setPrice(-5000);
        // setPrice() 메소드 안의 방어 로직 덕분에, b1의 가격은 10만원으로 설정될 거예요.
        System.out.println("잘못된 값 입력 후 가격: " + b1.getPrice() + "원");

        System.out.println("------------------------------------------");

        // [4] Getter의 또 다른 활용
        // b1 객체의 해상도(resolution)는 현재 설정된 적이 없어서 null 상태예요.
        // 이 때 getResolution()을 호출하면, BlackBox.java에 있는 Getter가
        // "null이면 '판매자에게 문의하십시오.' 라는 안내 문구를 대신 보여줘라" 라고 처리해준답니다.
        // 이렇게 하면 사용자에게 텅 빈 값(null) 대신 친절한 안내를 보여줄 수 있죠.
        System.out.println("b1의 해상도: " + b1.getResolution());

        /*
        [선생님 TIP]
        실무에서는 모든 인스턴스 변수를 `private`으로 선언해서 외부의 직접적인 접근을 막고,
        반드시 `public`으로 열어둔 Getter와 Setter를 통해서만 데이터에 접근하도록 만드는 것이 기본 규칙입니다.
        이것이 바로 캡슐화를 통해 데이터의 무결성을 지키고, 코드의 안정성을 높이는 방법이랍니다!
        */
    }
}