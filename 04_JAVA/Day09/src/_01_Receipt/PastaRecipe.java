package _01_Receipt;

// PastaRecipe 클래스는 Recipe 추상 클래스를 상속받는 자식 클래스입니다.
// 파스타 레시피만의 특성과 조리법을 정의합니다.
public class PastaRecipe extends Recipe {
    // 생성자: PastaRecipe 객체를 생성할 때 호출됩니다.
    // `super(chef)`를 통해 부모 클래스(Recipe)의 생성자를 호출하여 `chef` 필드를 초기화합니다.
    PastaRecipe(String chef){
        super(chef);
    }

    // 메소드: 파스타를 만드는 과정을 정의합니다.
    void makePasta() {
        System.out.println("파스타를 맛있게 만듭니다.");
    }

    // [참고] 만약 Recipe 클래스에 추상 메소드가 있었다면,
    // PastaRecipe 클래스는 해당 추상 메소드를 반드시 오버라이딩하여 구현해야 합니다.
}
