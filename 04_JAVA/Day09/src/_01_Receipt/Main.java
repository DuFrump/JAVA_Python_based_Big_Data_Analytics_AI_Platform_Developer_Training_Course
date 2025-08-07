package _01_Receipt;

// Main 클래스는 Recipe 추상 클래스와 이를 상속받는 자식 클래스들을 사용하는 예제입니다.
public class Main {
    public static void main(String[] args) {
        // [1] 추상 클래스는 직접 객체를 생성할 수 없습니다.
        // 아래 주석을 해제하면 컴파일 에러가 발생합니다.
        // Recipe r = new Recipe(); // 에러: Recipe is abstract; cannot be instantiated
        System.out.println("Recipe는 추상 클래스이므로 직접 객체 생성이 불가능합니다.");

        System.out.println("
----------------------------------------
");

        // [2] PastaRecipe 객체 생성 및 사용
        // PastaRecipe는 Recipe를 상속받아 구현된 클래스이므로 객체 생성이 가능합니다.
        PastaRecipe pr = new PastaRecipe("최현석");
        System.out.println("--- 파스타 레시피 ---");
        pr.info();      // Recipe 클래스에서 상속받은 info() 메소드 호출
        pr.makePasta(); // PastaRecipe 고유의 makePasta() 메소드 호출

        System.out.println("
====================================
");

        // [3] StakeRecipe 객체 생성 및 사용
        // StakeRecipe도 Recipe를 상속받아 구현된 클래스이므로 객체 생성이 가능합니다.
        StakeRecipe sr = new StakeRecipe("맛피아");
        System.out.println("--- 스테이크 레시피 ---");
        sr.info();       // Recipe 클래스에서 상속받은 info() 메소드 호출
        sr.grillStake(); // StakeRecipe 고유의 grillStake() 메소드 호출

        System.out.println("
----------------------------------------
");

        // [4] 다형성 활용 (추상 클래스 타입으로 자식 객체 참조)
        // 추상 클래스 타입의 참조 변수는 자식 클래스의 객체를 참조할 수 있습니다.
        // 이를 통해 다양한 레시피 객체를 일관된 방식으로 다룰 수 있습니다.
        Recipe recipe1 = new PastaRecipe("백종원");
        Recipe recipe2 = new StakeRecipe("고든 램지");

        System.out.println("--- 다형성을 활용한 레시피 정보 ---");
        recipe1.info();
        recipe2.info();

        // recipe1.makePasta(); // 에러: Recipe 타입에는 makePasta() 메소드가 없음
        // 자식 클래스 고유의 메소드를 호출하려면 다운캐스팅이 필요합니다.
        if (recipe1 instanceof PastaRecipe) {
            ((PastaRecipe) recipe1).makePasta();
        }
    }
}
