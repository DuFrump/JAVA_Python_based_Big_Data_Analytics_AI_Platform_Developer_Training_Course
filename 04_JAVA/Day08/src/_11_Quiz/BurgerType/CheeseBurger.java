package _11_Quiz.BurgerType;

public class CheeseBurger extends Hamburger{
    public CheeseBurger() { super("치즈버거"); }

    @Override
    public void cook() {
        super.cook();
        System.out.println("치즈 추가");
    }
}
