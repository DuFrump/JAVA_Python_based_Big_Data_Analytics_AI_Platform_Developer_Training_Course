package _03_Phone2;

public class Main {
    public static void main(String[] args) {
        Person jimin = new Person(new PineapplePhone2());

        jimin.turnOnPhone();

        for(int i = 1; i < 6; i++) {
            jimin.watchYouTube();

            if (i % 3 == 0) {
                jimin.chargePhone();
            }
        }

        jimin.buyNewPhone(new ThreeStarPhone2());
        jimin.turnOnPhone();

        for(int i = 1; i < 5; i++) {
            jimin.watchYouTube();

            if (i % 2 == 0) {
                jimin.chargePhone();
            }
        }
    }
}
