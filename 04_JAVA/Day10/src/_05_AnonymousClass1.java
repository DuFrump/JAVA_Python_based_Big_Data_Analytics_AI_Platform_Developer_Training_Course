/**
 * 두프룸프님을 위한 주석 가이드:
 * 이 코드는 '익명 내부 클래스(Anonymous Inner Class)'의 기본 개념을 보여줍니다.
 * 이름 그대로, 이름이 없는 클래스를 의미합니다. 클래스 정의와 객체 생성을 동시에 하므로,
 * 딱 한 번만 사용할 클래스를 만들 때 유용합니다. (일회용 클래스)
 *
 * [비유]
 * Coffee 클래스는 프랜차이즈 카페의 '기본 매뉴얼'입니다.
 * 익명 클래스로 만든 special 객체는 단골 손님을 위한 '특별 응대'를 하는, 딱 한 명의 직원과 같습니다.
 * 이 직원은 기본 매뉴얼을 따르면서도, 자신만의 특별한 서비스를 추가합니다.
 * 이 특별한 응대는 오직 special 객체에만 해당되며, 다른 일반 객체(c1, c2)에는 영향을 주지 않습니다.
 */
public class _05_AnonymousClass1 {

    public static void main(String[] args) {
        // 1. 일반적인 방법으로 Coffee 객체를 생성합니다. (기본 매뉴얼대로 행동)
        Coffee c1 = new Coffee();
        c1.order("아메리카노");
        c1.returnTray();
        System.out.println("------------------");

        Coffee c2 = new Coffee();
        c2.order("카페라떼");
        c2.returnTray();
        System.out.println("------------------");

        // 2. 익명 클래스를 사용하여 Coffee 객체를 생성합니다. (특별 응대!)
        // new Coffee() { ... }; 부분이 바로 이름 없는 클래스를 정의하고 동시에 객체를 생성하는 부분입니다.
        Coffee special = new Coffee() {
            // Coffee 클래스의 order 메소드를 재정의(Override)합니다.
            @Override
            public void order(String coffee) {
                // super.order(coffee)는 부모 클래스(Coffee)의 원래 기능을 그대로 호출하는 부분입니다.
                super.order(coffee);
                // 거기에 새로운 기능을 덧붙입니다.
                System.out.println("케이크 서비스 추가요~");
            }

            // returnTray 메소드도 완전히 새로운 행동으로 재정의합니다.
            @Override
            public void returnTray() {
                System.out.println("커피잔 이리 줄래? 내가 치워줄게~");
            }
        };

        // special 객체로 메소드를 호출하면, 재정의된 특별한 기능이 실행됩니다.
        special.order("아이스 아메리카노");
        special.returnTray();
    }
}

// 카페의 '기본 매뉴얼' 역할을 하는 Coffee 클래스
class Coffee {
    public void order(String coffee) {
        System.out.printf("주문하신 %s 나왔습니다.%n", coffee);
    }

    public void returnTray() {
        System.out.println("커피잔 반납이 완료 되었습니다.");
    }
}
