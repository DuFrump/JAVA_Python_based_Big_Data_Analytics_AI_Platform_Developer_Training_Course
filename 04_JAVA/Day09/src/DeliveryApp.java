import java.util.Scanner;

/**
 * <요구사항>
 * - Menu라는 부모 클래스를 만들고, 이름과 가격 필드를 가집니다. V
 * - order() 메서드는 주문 시 출력되는 내용을 담당하며, 메뉴별로 다르게 오버라이딩합니다. V
 * - Chicken, Pizza, Jokbal 클래스를 Menu 클래스를 상속받아 각각 구현하세요. V
 * - Scanner를 이용하여 사용자로부터 메뉴를 선택하도록 하세요. V
 * - 사용자가 0을 입력할 때까지 반복해서 주문을 받습니다. V
 * - 주문된 메뉴는 차례대로 출력되며, 각 메뉴의 order() 메서드가 실행되어야 합니다. V
 * - 실행 클래스 작성시 다형성을 이용합니다. V
 * - DeliveryApp.java  이라는 하나의 파일 안에 모든 클래스를 작성하시오. V
 *
 * <실행 예시>
 * === 메뉴를 선택하세요 ===
 * 1. 치킨
 * 2. 피자
 * 3. 족발
 * 0. 종료
 * 선택: 2
 * 피자(15000원)를 주문합니다. 도우는 얇은 걸로 선택되었습니다.
 *
 * === 메뉴를 선택하세요 ===
 * 1. 치킨
 * 2. 피자
 * 3. 족발
 * 0. 종료
 * 선택: 1
 * 치킨(17000원)을 주문합니다. 양념 소스를 선택하셨습니다.
 *
 * === 메뉴를 선택하세요 ===
 * 1. 치킨
 * 2. 피자
 * 3. 족발
 * 0. 종료
 * 선택: 0
 * 주문이 종료되었습니다. 감사합니다!
 * */

// Menu 클래스는 모든 메뉴의 기본적인 속성(이름, 가격)과 주문 기능을 정의하는 부모 클래스입니다.
class Menu {
    String name;  // 메뉴 이름
    int price;    // 메뉴 가격

    // 생성자: 메뉴 이름과 가격을 받아 초기화합니다.
    Menu(String name, int price){
        this.name = name;
        this.price = price;
    }

    // 주문 메소드: 기본적인 주문 메시지를 출력합니다.
    // 이 메소드는 자식 클래스에서 각 메뉴에 맞게 오버라이딩될 것입니다.
    void order() {
        System.out.printf("%s(%d원)을(를) 주문합니다.", name, price);
    }
}

// Chicken 클래스는 Menu 클래스를 상속받는 자식 클래스입니다.
// 치킨 메뉴의 특화된 주문 메시지를 정의합니다.
class Chicken extends Menu {
    // 생성자: 부모 클래스의 생성자를 호출하여 이름과 가격을 초기화합니다.
    Chicken() {
        super("치킨", 17000);
    }

    // 주문 메소드 오버라이딩: 치킨 주문 시 추가 메시지를 출력합니다.
    @Override
    void order() {
        super.order(); // 부모의 order() 메소드 호출 (기본 주문 메시지 출력)
        System.out.println(" 양념 소스를 선택하셨습니다."); // 치킨만의 추가 메시지
    }
}

// Pizza 클래스는 Menu 클래스를 상속받는 자식 클래스입니다.
// 피자 메뉴의 특화된 주문 메시지를 정의합니다.
class Pizza extends Menu {
     // 생성자: 부모 클래스의 생성자를 호출하여 이름과 가격을 초기화합니다.
     Pizza() {
        super("피자", 15000);
    }

    // 주문 메소드 오버라이딩: 피자 주문 시 추가 메시지를 출력합니다.
    @Override
    void order() {
        super.order(); // 부모의 order() 메소드 호출
        System.out.println(" 도우는 얇은 걸로 선택되었습니다."); // 피자만의 추가 메시지
    }
}

// Jokbal 클래스는 Menu 클래스를 상속받는 자식 클래스입니다.
// 족발 메뉴의 특화된 주문 메시지를 정의합니다.
class Jokbal extends Menu {
    // 생성자: 부모 클래스의 생성자를 호출하여 이름과 가격을 초기화합니다.
    Jokbal() {
        super("족발", 34000);
    }

    // 주문 메소드 오버라이딩: 족발 주문 시 추가 메시지를 출력합니다.
    @Override
    void order() {
        super.order(); // 부모의 order() 메소드 호출
        System.out.println(" 막국수가 추가로 제공됩니다."); // 족발만의 추가 메시지
    }
}

// DeliveryApp 클래스는 배달 앱의 메인 실행 클래스입니다.
// 사용자로부터 메뉴를 선택받아 주문을 처리하며, 다형성을 적극적으로 활용합니다.
public class DeliveryApp {
    public static void main(String[] args) {
        // [1] 다형성 활용: 부모 클래스(Menu) 타입의 배열에 자식 클래스 객체 할당
        // 이 배열은 Chicken, Pizza, Jokbal 객체를 모두 담을 수 있습니다.
        // 이를 통해 다양한 메뉴를 일관된 방식으로 관리하고 처리할 수 있습니다.
        Menu[] menus = {
                new Chicken(),
                new Pizza(),
                new Jokbal()
        };

        // Scanner 객체 생성: 사용자 입력을 받기 위해 사용합니다.
        Scanner sc = new Scanner(System.in);

        // [2] 주문 반복 루프: 사용자가 0을 입력할 때까지 반복해서 주문을 받습니다.
        while (true) {
            System.out.println("=== 메뉴를 선택하세요 ===");
            // 배열을 순회하며 메뉴 이름을 동적으로 출력합니다.
            for (int i = 0; i < menus.length; i++) {
                System.out.printf("%d. %s\n", i + 1, menus[i].name);
            }
            System.out.println("0. 종료");
            System.out.print("선택 : ");
            int choice = sc.nextInt(); // 사용자로부터 메뉴 번호 입력받기

            // [3] 종료 조건
            if (choice == 0) {
                System.out.println("주문이 종료되었습니다. 감사합니다!");
                break; // 반복문 종료
            }

            // [4] 유효성 검사 및 주문 처리
            // 사용자의 선택이 유효한 범위 내에 있는지 확인합니다.
            if (choice >= 1 && choice <= menus.length) {
                // 여기서 다형성이 가장 잘 드러납니다.
                // `Menu` 타입의 참조 변수 `selectedMenu`가 실제로는 `Chicken`, `Pizza`, `Jokbal` 객체를 가리킵니다.
                Menu selectedMenu = menus[choice - 1];

                // `selectedMenu.order()`를 호출하면,
                // 실제 객체가 무엇이든 그 객체에 맞게 오버라이딩된 `order()` 메소드가 실행됩니다.
                selectedMenu.order();
            } else {
                System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요.");
            }
            System.out.println(); // 메뉴 선택 후 한 줄 띄우기
        }
        // [5] Scanner 자원 해제
        sc.close();
    }
}
