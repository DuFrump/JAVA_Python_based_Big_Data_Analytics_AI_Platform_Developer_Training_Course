package _01_Receipt;

public class Main {
    public static void main(String[] args) {
        // Recipe r = new Recipe(); 추상 클래스는 직접 객체 생성이 안됨.

        PastaRecipe pr = new PastaRecipe("최현석");
        pr.info();
        pr.makePasta();

        System.out.println("================================");

        StakeRecipe sr = new StakeRecipe("맛피아");
        sr.info();
        sr.grillStake();
    }
}
