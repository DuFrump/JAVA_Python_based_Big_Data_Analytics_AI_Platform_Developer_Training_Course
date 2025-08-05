package _11_Quiz.BurgerType;

public class BulgogiBurger extends Hamburger {
    public BulgogiBurger() { super("불고기버거"); }

    @Override
    public void cook() {
        super.cook();
        System.out.println("치즈 추가");
        System.out.println("불고기 소스 추가");
    }
}
