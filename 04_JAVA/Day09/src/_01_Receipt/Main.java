/**
 * 안녕하세요, 두프룸프님! 이번 예제에서는 자바의 '추상 클래스(Abstract Class)'와
 * 다시 한번 '다형성(Polymorphism)' 개념을 레시피 예제를 통해 깊이 있게 다뤄볼 거예요.
 *
 * <오늘 배울 핵심 개념>
 * 1.  **추상 클래스 (Abstract Class)**:
 *     - 'abstract' 키워드로 선언된 클래스예요. 이 클래스는 직접 객체를 만들 수 없어요.
 *       (예: `new Recipe()`는 불가능!)
 *     - 미완성된 메소드, 즉 '추상 메소드(Abstract Method)'를 가질 수 있어요.
 *       추상 메소드는 선언만 있고 구현(몸체)이 없는 메소드를 말해요.
 *       (예: `public abstract void make();`)
 *     - 추상 클래스를 상속받는 자식 클래스는 부모의 추상 메소드를 반드시 구현(오버라이딩)해야 해요.
 *       만약 구현하지 않으면, 그 자식 클래스도 추상 클래스가 되어야 합니다.
 *     - 추상 클래스는 자식 클래스들에게 공통된 틀이나 기능을 제공하면서도,
 *       자식 클래스마다 다르게 구현되어야 할 부분을 강제하는 역할을 합니다.
 *
 * 2.  **다형성 (Polymorphism) 심화**: (DeliveryApp.java에서 배운 내용을 다시 한번!) 
 *     - 추상 클래스도 다형성의 대상이 될 수 있어요.
 *     - 추상 클래스 타입의 참조 변수가 자식 클래스의 객체를 참조할 수 있습니다.
 *       (예: `Recipe recipe1 = new PastaRecipe("백종원");`)
 *     - 이를 통해 여러 종류의 자식 객체들을 하나의 부모 타입으로 묶어 일관되게 처리할 수 있어요.
 *     - 하지만 부모 타입으로 참조할 때는 부모 클래스에 정의된 메소드만 호출할 수 있다는 점을 기억해야 해요.
 *       자식 클래스 고유의 메소드를 호출하려면 '다운캐스팅(Downcasting)'이 필요합니다.
 *
 * 이 예제를 통해 추상 클래스가 어떻게 코드의 구조를 잡고,
 * 다형성과 함께 유연하고 확장 가능한 프로그램을 만드는 데 기여하는지 이해할 수 있을 거예요.
 * 함께 코드를 분석하며 개념을 확실히 다져봅시다!
 */

package _01_Receipt;

// Main 클래스는 Recipe 추상 클래스와 이를 상속받는 자식 클래스들을 사용하는 예제입니다.
// 프로그램의 시작점인 main 메소드를 포함하고 있습니다.
public class Main {
    public static void main(String[] args) {
        // [1] 추상 클래스는 직접 객체를 생성할 수 없습니다.
        // 추상 클래스는 '미완성된 설계도'와 같아서, 그 자체로는 실제 물건(객체)을 만들 수 없어요.
        // 아래 주석을 해제하면 컴파일 에러가 발생합니다.
        // Recipe r = new Recipe(); // 에러 메시지: Recipe is abstract; cannot be instantiated
        System.out.println("Recipe는 추상 클래스이므로 직접 객체 생성이 불가능합니다.");

        System.out.println("----------------------------------------");

        // [2] PastaRecipe 객체 생성 및 사용
        // PastaRecipe는 Recipe 추상 클래스를 상속받아 모든 추상 메소드를 구현했기 때문에,
        // '완성된 설계도'가 되어 객체 생성이 가능합니다.
        PastaRecipe pr = new PastaRecipe("최현석");
        System.out.println("--- 파스타 레시피 ---");
        pr.info();      // Recipe 클래스에서 상속받은 info() 메소드 호출
        pr.makePasta(); // PastaRecipe 클래스에만 있는 고유의 makePasta() 메소드 호출

        System.out.println("====================================");

        // [3] StakeRecipe 객체 생성 및 사용
        // StakeRecipe도 Recipe 추상 클래스를 상속받아 구현된 클래스이므로 객체 생성이 가능합니다.
        StakeRecipe sr = new StakeRecipe("맛피아");
        System.out.println("--- 스테이크 레시피 ---");
        sr.info();       // Recipe 클래스에서 상속받은 info() 메소드 호출
        sr.grillStake(); // StakeRecipe 클래스에만 있는 고유의 grillStake() 메소드 호출

        System.out.println("----------------------------------------");

        // [4] 다형성 활용 (추상 클래스 타입으로 자식 객체 참조)
        // 추상 클래스 타입의 참조 변수(Recipe)는 그 추상 클래스를 상속받은 자식 클래스의 객체(PastaRecipe, StakeRecipe)를 참조할 수 있습니다.
        // 이는 다양한 종류의 레시피 객체들을 'Recipe'라는 하나의 공통된 타입으로 묶어 일관되게 다룰 수 있게 해줍니다.
        Recipe recipe1 = new PastaRecipe("백종원"); // Recipe 타입으로 PastaRecipe 객체 참조
        Recipe recipe2 = new StakeRecipe("고든 램지"); // Recipe 타입으로 StakeRecipe 객체 참조

        System.out.println("--- 다형성을 활용한 레시피 정보 ---");
        recipe1.info(); // 실제 객체(PastaRecipe)의 info()가 호출됩니다.
        recipe2.info(); // 실제 객체(StakeRecipe)의 info()가 호출됩니다.

        // recipe1.makePasta(); // 컴파일 에러 발생!
        // 왜냐하면 recipe1은 'Recipe' 타입으로 선언되었기 때문에,
        // 'Recipe' 클래스에 정의된 메소드(info())만 호출할 수 있습니다.
        // 'makePasta()' 메소드는 'PastaRecipe' 클래스에만 있는 고유한 메소드이므로,
        // 'Recipe' 타입의 참조 변수로는 직접 호출할 수 없습니다.

        // 자식 클래스 고유의 메소드를 호출하려면 '다운캐스팅(Downcasting)'이 필요합니다.
        // 다운캐스팅은 부모 타입의 참조 변수를 자식 타입으로 다시 변환하는 것을 말해요.
        // 이때, 'instanceof' 연산자를 사용하여 실제 객체의 타입이 맞는지 확인하는 것이 안전합니다.
        if (recipe1 instanceof PastaRecipe) { // recipe1이 PastaRecipe의 인스턴스인지 확인
            // 맞다면, PastaRecipe 타입으로 강제 형 변환(다운캐스팅)하여 makePasta() 메소드를 호출합니다.
            ((PastaRecipe) recipe1).makePasta();
        }

        // StakeRecipe도 마찬가지로 다운캐스팅을 통해 고유 메소드를 호출할 수 있습니다.
        if (recipe2 instanceof StakeRecipe) {
            ((StakeRecipe) recipe2).grillStake();
        }
    }
}