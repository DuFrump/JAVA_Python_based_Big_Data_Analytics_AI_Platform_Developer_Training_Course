package _11_Quiz.BurgerType;

public class Hamburger {
    protected String name;

    public Hamburger() { this("햄버거"); }

    public Hamburger(String name) {
        this.name = name;
    }

    public void cook() {
        System.out.printf("%s 재료%n", this.name);
        System.out.println("양상추");
        System.out.println("패티");
    }
}
