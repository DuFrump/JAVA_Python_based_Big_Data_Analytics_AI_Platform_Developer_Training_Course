/**
 * 안녕하세요, 두프룸프님! 오늘은 자바의 아주 중요한 개념인 '상속(Inheritance)'과 '다형성(Polymorphism)'을
 * 배달 앱 예제를 통해 함께 공부해볼 거예요.
 *
 * <오늘 배울 핵심 개념>
 * 1.  **상속 (Inheritance)**: 부모 클래스의 속성과 기능을 자식 클래스가 물려받아 사용하는 것을 말해요.
 *     코드의 재사용성을 높이고, 클래스 간의 관계를 명확하게 설정할 수 있게 해줍니다.
 *     예를 들어, '메뉴'라는 부모 클래스를 만들고, '치킨', '피자', '족발' 같은 자식 클래스들이
 *     '메뉴'의 기본적인 속성(이름, 가격)을 물려받아 사용하는 것이죠.
 *
 * 2.  **다형성 (Polymorphism)**: '여러 가지 형태를 가질 수 있는 능력'을 의미해요.
 *     자바에서는 하나의 객체가 여러 타입을 가질 수 있다는 것을 뜻합니다.
 *     특히, 부모 클래스 타입의 참조 변수가 자식 클래스의 인스턴스를 참조할 수 있고,
 *     이때 오버라이딩된 메소드를 호출하면 실제 객체의 메소드가 실행되는 특징이 있어요.
 *     이 예제에서는 'Menu' 타입의 배열에 'Chicken', 'Pizza', 'Jokbal' 객체를 모두 담고,
 *     각 객체의 'order()' 메소드를 호출할 때, 실제 객체에 맞는 주문 메시지가 출력되는 것을 볼 수 있습니다.
 *
 * 이 예제를 통해 여러분은 객체 지향 프로그래밍의 강력함을 직접 경험하게 될 거예요.
 * 코드를 한 줄 한 줄 따라가면서 상속과 다형성이 어떻게 동작하는지 함께 살펴봅시다!
 */

import java.util.Scanner;

/**
 * Menu 클래스는 모든 메뉴의 기본적인 속성(이름, 가격)과 주문 기능을 정의하는 부모 클래스입니다.
 * 이 클래스는 자식 클래스들에게 공통된 기능을 제공하여 코드의 재사용성을 높입니다.
 */
class Menu {
    String name;  // 메뉴의 이름을 저장하는 변수입니다.
    int price;    // 메뉴의 가격을 저장하는 변수입니다.

    /**
     * Menu 클래스의 생성자입니다.
     * 새로운 Menu 객체를 만들 때, 메뉴의 이름과 가격을 받아 초기화합니다.
     * @param name 메뉴의 이름
     * @param price 메뉴의 가격
     */
    Menu(String name, int price){
        this.name = name;
        this.price = price;
    }

    /**
     * 주문 메소드: 기본적인 주문 메시지를 출력합니다.
     * 이 메소드는 자식 클래스에서 각 메뉴의 특성에 맞게 '오버라이딩(Overriding)'될 것입니다.
     * 오버라이딩이란, 부모 클래스에 정의된 메소드를 자식 클래스에서 자신의 필요에 맞게 재정의하는 것을 말해요.
     */
    void order() {
        System.out.printf("%s(%d원)을(를) 주문합니다.", name, price);
    }
}

/**
 * Chicken 클래스는 Menu 클래스를 상속받는 자식 클래스입니다.
 * 'extends Menu' 키워드를 사용하여 Menu 클래스의 모든 속성과 메소드를 물려받습니다.
 * 치킨 메뉴의 특화된 주문 메시지를 정의합니다.
 */
class Chicken extends Menu {
    /**
     * Chicken 클래스의 생성자입니다.
     * 'super()'를 사용하여 부모 클래스(Menu)의 생성자를 호출하고,
     * 치킨의 이름("치킨")과 가격(17000)으로 초기화합니다.
     */
    Chicken() {
        super("치킨", 17000);
    }

    /**
     * order() 메소드를 오버라이딩합니다.
     * '@Override' 어노테이션은 이 메소드가 부모 클래스의 메소드를 재정의한다는 것을 명시적으로 알려줍니다.
     * 'super.order()'를 호출하여 부모의 기본적인 주문 메시지를 먼저 출력한 후,
     * 치킨에 특화된 추가 메시지를 출력합니다.
     */
    @Override
    void order() {
        super.order(); // 부모의 order() 메소드 호출 (예: "치킨(17000원)을(를) 주문합니다.")
        System.out.println(" 양념 소스를 선택하셨습니다."); // 치킨만의 추가 메시지
    }
}

/**
 * Pizza 클래스는 Menu 클래스를 상속받는 자식 클래스입니다.
 * 피자 메뉴의 특화된 주문 메시지를 정의합니다.
 */
class Pizza extends Menu {
    /**
     * Pizza 클래스의 생성자입니다.
     * 부모 클래스(Menu)의 생성자를 호출하여 피자의 이름("피자")과 가격(15000)으로 초기화합니다.
     */
    Pizza() {
        super("피자", 15000);
    }

    /**
     * order() 메소드를 오버라이딩합니다.
     * 'super.order()'를 호출하여 부모의 기본적인 주문 메시지를 먼저 출력한 후,
     * 피자에 특화된 추가 메시지를 출력합니다.
     */
    @Override
    void order() {
        super.order(); // 부모의 order() 메소드 호출 (예: "피자(15000원)을(를) 주문합니다.")
        System.out.println(" 도우는 얇은 걸로 선택되었습니다."); // 피자만의 추가 메시지
    }
}

/**
 * Jokbal 클래스는 Menu 클래스를 상속받는 자식 클래스입니다.
 * 족발 메뉴의 특화된 주문 메시지를 정의합니다.
 */
class Jokbal extends Menu {
    /**
     * Jokbal 클래스의 생성자입니다.
     * 부모 클래스(Menu)의 생성자를 호출하여 족발의 이름("족발")과 가격(34000)으로 초기화합니다.
     */
    Jokbal() {
        super("족발", 34000);
    }

    /**
     * order() 메소드를 오버라이딩합니다.
     * 'super.order()'를 호출하여 부모의 기본적인 주문 메시지를 먼저 출력한 후,
     * 족발에 특화된 추가 메시지를 출력합니다.
     */
    @Override
    void order() {
        super.order(); // 부모의 order() 메소드 호출 (예: "족발(34000원)을(를) 주문합니다.")
        System.out.println(" 막국수가 추가로 제공됩니다."); // 족발만의 추가 메시지
    }
}

/**
 * DeliveryApp 클래스는 배달 앱의 메인 실행 클래스입니다.
 * 사용자로부터 메뉴를 선택받아 주문을 처리하며, '다형성'을 적극적으로 활용합니다.
 * 이 클래스의 main 메소드에서 프로그램이 시작됩니다.
 */
public class DeliveryApp {
    public static void main(String[] args) {
        // [1] 다형성 활용: 부모 클래스(Menu) 타입의 배열에 자식 클래스 객체 할당
        // 이 배열은 Chicken, Pizza, Jokbal 객체를 모두 담을 수 있습니다.
        // 자바에서 부모 타입의 참조 변수가 자식 객체를 참조할 수 있는 것이 바로 다형성의 핵심입니다.
        // 이를 통해 다양한 메뉴를 일관된 'Menu' 타입으로 관리하고 처리할 수 있습니다.
        Menu[] menus = {
                new Chicken(), // Menu 타입이지만 실제로는 Chicken 객체
                new Pizza(),   // Menu 타입이지만 실제로는 Pizza 객체
                new Jokbal()   // Menu 타입이지만 실제로는 Jokbal 객체
        };

        // Scanner 객체 생성: 사용자 입력을 받기 위해 사용합니다.
        // 사용자로부터 키보드 입력을 받을 때 사용하는 표준 자바 클래스입니다.
        Scanner sc = new Scanner(System.in);

        // [2] 주문 반복 루프: 사용자가 '0'을 입력할 때까지 반복해서 주문을 받습니다.
        // 'while(true)'는 무한 루프를 의미하며, 'break' 문을 통해 특정 조건에서 루프를 종료시킵니다.
        while (true) {
            System.out.println("=== 메뉴를 선택하세요 ===");
            // 배열을 순회하며 메뉴 이름을 동적으로 출력합니다.
            // 이렇게 하면 새로운 메뉴가 추가되어도 이 부분의 코드를 수정할 필요가 없습니다.
            for (int i = 0; i < menus.length; i++) {
                System.out.printf("%d. %s\n", i + 1, menus[i].name);
            }
            System.out.println("0. 종료");
            System.out.print("선택 : ");
            int choice = sc.nextInt(); // 사용자로부터 메뉴 번호 입력받기

            // [3] 종료 조건 확인
            // 사용자가 '0'을 입력하면 프로그램을 종료합니다.
            if (choice == 0) {
                System.out.println("주문이 종료되었습니다. 감사합니다!");
                break; // 'while' 반복문을 빠져나갑니다.
            }

            // [4] 유효성 검사 및 주문 처리
            // 사용자의 선택이 유효한 메뉴 번호 범위 내에 있는지 확인합니다.
            if (choice >= 1 && choice <= menus.length) {
                // 여기서 다형성이 가장 잘 드러납니다!
                // 'Menu' 타입의 참조 변수 'selectedMenu'가 실제로는 사용자가 선택한
                // 'Chicken', 'Pizza', 또는 'Jokbal' 객체를 가리킵니다.
                Menu selectedMenu = menus[choice - 1]; // 배열 인덱스는 0부터 시작하므로 'choice - 1'

                // 'selectedMenu.order()'를 호출하면,
                // 자바의 '동적 바인딩(Dynamic Binding)' 덕분에 실제 객체(Chicken, Pizza, Jokbal)에 맞게
                // 오버라이딩된 'order()' 메소드가 실행됩니다.
                // 예를 들어, '치킨'을 선택했다면 Chicken 클래스의 order()가, '피자'를 선택했다면 Pizza 클래스의 order()가 호출됩니다.
                selectedMenu.order();
            } else {
                // 유효하지 않은 번호를 입력했을 경우 메시지를 출력합니다.
                System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요.");
            }
            System.out.println(); // 메뉴 선택 후 가독성을 위해 한 줄 띄웁니다.
        }
        // [5] Scanner 자원 해제
        // Scanner 객체가 사용했던 시스템 자원을 반환하여 메모리 누수를 방지합니다.
        // 프로그램이 종료되기 전에 항상 호출하는 것이 좋습니다.
        sc.close();
    }
}