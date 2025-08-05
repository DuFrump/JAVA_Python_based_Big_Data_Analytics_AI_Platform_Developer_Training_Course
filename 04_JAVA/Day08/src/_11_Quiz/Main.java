package _11_Quiz;

import _11_Quiz.BurgerType.BulgogiBurger;
import _11_Quiz.BurgerType.CheeseBurger;
import _11_Quiz.BurgerType.Hamburger;
import _11_Quiz.BurgerType.ShrimpBurger;

public class Main {
    public static void main(String[] args) {
        Hamburger[] hamburgers = new Hamburger[4];

        hamburgers[0] = new Hamburger();
        hamburgers[1] = new ShrimpBurger();
        hamburgers[2] = new CheeseBurger();
        hamburgers[3] = new BulgogiBurger();

        for (Hamburger hamburger : hamburgers) {
            System.out.println("------------------");
            hamburger.cook();
        }
    }
}
