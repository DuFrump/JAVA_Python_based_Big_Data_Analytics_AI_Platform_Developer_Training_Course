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

class Menu {
    String name;
    int price;

    Menu(String name, int price){
        this.name = name;
        this.price = price;
    }

    void order() {
        System.out.printf("%s(%d원)을(를) 주문합니다.", name, price);
    }
}

class Chicken extends Menu {
    Chicken(String name, int price) {
        super(name, price);
    }

    @Override
    void order() {
        super.order();
        System.out.println(" 양념 소스를 선택하셨습니다.");
    }
}

class Pizza extends Menu {
     Pizza(String name, int price) {
        super(name, price);
    }

    @Override
    void order() {
        super.order();
        System.out.println(" 도우는 얇은 걸로 선택되었습니다.");
    }
}

class Jokbal extends Menu {
    Jokbal(String name, int price) {
        super(name, price);
    }

    @Override
    void order() {
        super.order();
        System.out.println(" 막국수가 추가로 제공됩니다.");
    }
}

public class DeliveryApp {
    public static void main(String[] args) {
        Menu menu1 = new Chicken("치킨", 17000);
        Menu menu2 = new Pizza("피자", 15000);
        Menu menu3 = new Jokbal("족발", 34000);

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("=== 메뉴를 선택하세요 ===");
            System.out.println("1. 치킨");
            System.out.println("2. 피자");
            System.out.println("3. 족발");
            System.out.println("0. 종료");
            System.out.print("선택 : ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    menu1.order();
                    break;
                case 2:
                    menu2.order();
                    break;
                case 3:
                    menu3.order();
                    break;
                case 0:
                    System.out.println("주문이 종료되었습니다. 감사합니다!");
                    return;
                default :
                    System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요.");
                    break;
            }

            System.out.println();
        }
    }
}
