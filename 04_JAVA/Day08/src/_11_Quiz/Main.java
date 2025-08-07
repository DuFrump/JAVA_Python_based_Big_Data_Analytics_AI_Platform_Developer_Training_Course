package _11_Quiz;

// 필요한 햄버거 클래스들을 import 합니다.
import _11_Quiz.BurgerType.BulgogiBurger;
import _11_Quiz.BurgerType.CheeseBurger;
import _11_Quiz.BurgerType.Hamburger;
import _11_Quiz.BurgerType.ShrimpBurger;

// Main 클래스는 다양한 햄버거 객체를 생성하고, 다형성을 활용하여 조리 과정을 보여주는 예제입니다.
public class Main {
    public static void main(String[] args) {
        // [1] 다형성 활용: 부모 클래스(Hamburger) 타입의 배열에 자식 클래스 객체 할당
        // `Hamburger[] hamburgers = new Hamburger[4];`
        // - `Hamburger` 타입의 배열을 선언하여 다양한 종류의 햄버거 객체를 저장할 수 있습니다.
        // - 이는 코드의 유연성과 확장성을 높여줍니다.
        Hamburger[] hamburgers = new Hamburger[4];

        hamburgers[0] = new Hamburger();    // 일반 햄버거 객체
        hamburgers[1] = new ShrimpBurger(); // 새우버거 객체 (Hamburger 타입으로 참조)
        hamburgers[2] = new CheeseBurger(); // 치즈버거 객체 (Hamburger 타입으로 참조)
        hamburgers[3] = new BulgogiBurger(); // 불고기버거 객체 (Hamburger 타입으로 참조)

        // [2] 반복문을 통한 다형성 메소드 호출
        // 향상된 for 문을 사용하여 배열의 모든 햄버거 객체를 순회합니다.
        for (Hamburger hamburger : hamburgers) {
            System.out.println("------------------");
            // 각 햄버거 객체의 `cook()` 메소드를 호출합니다.
            // 실제 호출되는 `cook()` 메소드는 객체의 실제 타입(ShrimpBurger, CheeseBurger 등)에 따라 달라집니다.
            // 이것이 바로 다형성의 핵심입니다.
            hamburger.cook();
        }

        // 예상 출력:
        // --- 햄버거 조리 시작 ---
        // 양상추
        // 패티
        // --- 햄버거 조리 완료 ---
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
    }
}
