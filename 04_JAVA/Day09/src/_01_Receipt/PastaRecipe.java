package _01_Receipt;

public class PastaRecipe extends Recipe {
    PastaRecipe(String chef){
        super(chef);
    }

    void makePasta() {
        System.out.println("파스타를 맛있게 만듭니다.");
    }
}
