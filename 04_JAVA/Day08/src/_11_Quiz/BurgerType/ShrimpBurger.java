package _11_Quiz.BurgerType;

public class ShrimpBurger extends Hamburger {
    public ShrimpBurger() { super("새우버거"); }

    @Override
    public void cook() {
        super.cook();
        System.out.println("새우 추가");
    }
}
