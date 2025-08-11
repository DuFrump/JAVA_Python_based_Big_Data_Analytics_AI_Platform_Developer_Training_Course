package _11_Quiz;

// 필요한 햄버거 클래스들을 import 합니다.
import _11_Quiz.BurgerType.BulgogiBurger;
import _11_Quiz.BurgerType.CheeseBurger;
import _11_Quiz.BurgerType.Hamburger;
import _11_Quiz.BurgerType.ShrimpBurger;

/**
 * 안녕하세요, 두프룸프님! 이제 우리가 만든 다양한 햄버거 클래스들을 활용하여
 * '다형성(Polymorphism)'이 실제 코드에서 어떻게 강력하게 사용되는지 확인해볼 시간이에요.
 *
 * 이 `Main` 클래스에서는 다음을 중점적으로 살펴볼 겁니다:
 * 1. 부모 클래스(`Hamburger`) 타입의 배열에 다양한 자식 클래스 객체들을 저장하는 방법
 * 2. 반복문을 통해 이 배열의 각 객체에 동일한 메소드(`cook()`)를 호출했을 때,
 *    객체의 실제 타입에 따라 오버라이딩된 메소드가 어떻게 다르게 동작하는지 확인하기
 *
 * 코드를 실행하면서 각 햄버거의 조리 과정이 어떻게 다르게 출력되는지 주의 깊게 살펴보세요.
 * 이것이 바로 객체 지향 프로그래밍의 유연성과 확장성을 보여주는 좋은 예시랍니다!
 */
public class Main {
    public static void main(String[] args) {
        // [1] 다형성 활용: 부모 클래스(`Hamburger`) 타입의 배열에 자식 클래스 객체 할당
        // `Hamburger[] hamburgers = new Hamburger[4];`
        // - `Hamburger` 타입의 배열을 선언하면, `Hamburger` 클래스뿐만 아니라
        //   `Hamburger`를 상속받는 모든 자식 클래스(`ShrimpBurger`, `CheeseBurger`, `BulgogiBurger`)의
        //   객체도 이 배열에 저장할 수 있습니다. 이것이 다형성의 큰 장점 중 하나입니다.
        // - 이렇게 하면 코드의 유연성과 확장성을 높여줍니다. 새로운 햄버거 종류가 추가되어도
        //   이 배열의 타입을 변경할 필요가 없죠!
        Hamburger[] hamburgers = new Hamburger[4];

        hamburgers[0] = new Hamburger();    // 일반 햄버거 객체를 배열의 첫 번째 요소에 할당
        hamburgers[1] = new ShrimpBurger(); // 새우버거 객체를 `Hamburger` 타입으로 참조하여 배열에 할당
        hamburgers[2] = new CheeseBurger(); // 치즈버거 객체를 `Hamburger` 타입으로 참조하여 배열에 할당
        hamburgers[3] = new BulgogiBurger(); // 불고기버거 객체를 `Hamburger` 타입으로 참조하여 배열에 할당

        // [2] 반복문을 통한 다형성 메소드 호출
        System.out.println("--- 햄버거 조리 시작 ---");
        // 향상된 for 문을 사용하여 배열의 모든 햄버거 객체를 순회합니다.
        for (Hamburger hamburger : hamburgers) {
            System.out.println("------------------");
            // 각 햄버거 객체의 `cook()` 메소드를 호출합니다.
            // 여기서 중요한 점은, `hamburger.cook()`이라고 동일하게 호출하지만,
            // 실제 호출되는 `cook()` 메소드는 객체의 실제 타입(예: `ShrimpBurger`, `CheeseBurger`)에 따라
            // 오버라이딩된 메소드가 실행된다는 것입니다. 이것이 바로 다형성의 핵심입니다!
            hamburger.cook();
        }

        // 예상 출력:
        // --- 햄버거 조리 시작 ---
        // ------------------
        // --- 햄버버 조리 시작 ---
        // 양상추
        // 패티
        // --- 햄버버 조리 완료 ---
        // ------------------
        // --- 새우버거 조리 시작 ---
        // 양상추
        // 패티
        // 새우 추가
        // --- 새우버거 조리 완료 ---
        // ------------------
        // --- 치즈버거 조리 시작 ---
        // 양상추
        // 패티
        // 치즈 추가
        // --- 치즈버거 조리 완료 ---
        // ------------------
        // --- 불고기버거 조리 시작 ---
        // 양상추
        // 패티
        // 치즈 추가
        // 불고기 소스 추가
        // --- 불고기버거 조리 완료 ---

        System.out.println("두프룸프님, 햄버거 퀴즈를 통해 다형성이 실제 코드에서 어떻게 활용되는지 잘 이해하셨기를 바랍니다!");
    }
}
