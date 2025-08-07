// `instanceof` 연산자와 `==` 연산자를 사용하여 객체의 타입과 참조를 비교하는 예제입니다.

// [1] 클래스 계층 구조 정의
// 부모 클래스
class Animal3 {}

// Animal3을 상속받는 자식 클래스
class Pig3 extends Animal3 {}

public class _08_InstanceOf {
    public static void main(String[] args) {
        // [2] 객체 생성 및 참조
        Pig3 pig3 = new Pig3(); // Pig3 타입의 객체 pig3 생성
        Pig3 pig4 = new Pig3(); // 또 다른 Pig3 타입의 객체 pig4 생성
        Animal3 animal = pig3;  // 다형성: Animal3 타입의 참조 변수 animal이 pig3 객체를 참조

        // [3] `instanceof` 연산자 사용
        // `animal instanceof Pig3`: animal이 참조하는 객체가 Pig3 타입의 인스턴스인지 확인
        // animal은 실제 Pig3 객체를 참조하고 있으므로 true를 반환합니다.
        if (animal instanceof Pig3) {
            System.out.println("객체 변수 animal은 Pig3 타입으로 생성된 객체입니다.");
        }
        /*
         * 설명:
         * `animal`은 `Pig3`로 생성된 객체를 참조하고 있는 `Animal3` 타입의 객체 변수입니다.
         * `animal instanceof Pig3`는 객체 변수 `animal`이 참조하는 객체가 `Pig3` 타입의 인스턴스인지 확인합니다.
         */

        System.out.println("
----------------------------------------
");

        // [4] `==` 연산자 사용
        // `==` 연산자는 두 참조 변수가 "같은 객체"를 참조하고 있는지 (메모리 주소가 같은지) 비교합니다.

        // `animal`과 `pig3`는 같은 `Pig3` 객체를 참조하고 있으므로 `true`를 반환합니다.
        if (animal == pig3) {
            System.out.println("객체 변수 animal과 pig3는 같은 객체를 참조하고 있습니다.");
        }
        // 설명: `==`는 주소가 같은지 아닌지 판단하는 것이므로, `pig3`와 `animal`은 같은 주소값을 가지고 있습니다.

        // `animal`과 `pig4`는 서로 다른 `Pig3` 객체를 참조하고 있으므로 `true`를 반환합니다.
        if (animal != pig4) {
            System.out.println("animal과 pig4는 같은 객체를 참조하고 있지 않습니다.");
        }
        // 설명: `animal`과 `pig4`는 서로 다른 객체를 참조하고 있기 때문에 같은 주소값을 가지고 있지 않습니다.
    }
}
