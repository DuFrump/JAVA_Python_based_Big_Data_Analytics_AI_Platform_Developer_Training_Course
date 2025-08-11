/**
 * 안녕하세요, 두프룸프님! 오늘은 Java에서 객체를 다룰 때 자주 헷갈리는 두 가지 연산자,
 * `instanceof`와 `==`의 차이점을 명확하게 이해하는 시간을 가질 거예요.
 *
 * `instanceof`는 객체의 '타입'을 확인하는 연산자이고,
 * `==`는 두 참조 변수가 '같은 객체'(메모리 주소)를 가리키는지 확인하는 연산자입니다.
 * 이 둘의 차이를 정확히 아는 것은 객체 지향 프로그래밍에서 매우 중요하답니다!
 *
 * 이 예제에서는 다음을 중점적으로 살펴볼 거예요:
 * 1. 간단한 클래스 상속 구조를 통해 객체 생성 및 참조 이해하기
 * 2. `instanceof` 연산자가 객체의 실제 타입을 어떻게 확인하는지
 * 3. `==` 연산자가 객체의 참조(메모리 주소)를 어떻게 비교하는지
 *
 * 자, 그럼 두 연산자의 차이를 함께 파헤쳐볼까요?
 */

// [1] 클래스 계층 구조 정의: 간단한 동물 가족을 만들어볼까요?
// 부모 클래스: 모든 동물의 공통적인 특징을 정의합니다.
class Animal3 {}

// Animal3을 상속받는 자식 클래스: 돼지(Pig3)
class Pig3 extends Animal3 {}

public class _08_InstanceOf {
    public static void main(String[] args) {
        // [2] 객체 생성 및 참조
        // `new Pig3()`를 통해 메모리에 새로운 `Pig3` 객체를 만들고, `pig3` 참조 변수가 이 객체를 가리킵니다.
        Pig3 pig3 = new Pig3(); 
        // 또 다른 `new Pig3()`를 통해 메모리에 완전히 새로운 `Pig3` 객체를 만들고, `pig4` 참조 변수가 이 객체를 가리킵니다.
        Pig3 pig4 = new Pig3(); 
        // 다형성: `Animal3` 타입의 참조 변수 `animal`이 `pig3`가 가리키는 '같은 객체'를 참조합니다.
        // 즉, `animal`과 `pig3`는 메모리 상의 동일한 `Pig3` 객체를 가리키고 있어요.
        Animal3 animal = pig3;  

        // [3] `instanceof` 연산자 사용: 객체의 '타입' 확인
        // `animal instanceof Pig3`는 `animal`이 참조하는 객체가 `Pig3` 타입의 인스턴스인지 확인합니다.
        // `animal`은 실제 `Pig3` 객체를 참조하고 있으므로 `true`를 반환합니다.
        if (animal instanceof Pig3) {
            System.out.println("객체 변수 animal은 Pig3 타입으로 생성된 객체입니다. (instanceof 결과: true)");
        }
        /*
         * 설명:
         * `animal`은 `Pig3`로 생성된 객체를 참조하고 있는 `Animal3` 타입의 객체 변수입니다.
         * `animal instanceof Pig3`는 객체 변수 `animal`이 참조하는 객체가 `Pig3` 타입의 인스턴스인지 확인합니다.
         * 여기서 중요한 것은 `animal` 변수의 선언 타입(`Animal3`)이 아니라, `animal`이 '실제로 가리키는 객체'의 타입입니다.
         */

        System.out.println("----------------------------------------");

        // [4] `==` 연산자 사용: 두 참조 변수가 '같은 객체'를 참조하는지 (메모리 주소 비교)
        // `==` 연산자는 두 참조 변수가 메모리 상에서 동일한 객체를 가리키고 있는지 (즉, 메모리 주소가 같은지) 비교합니다.

        // `animal`과 `pig3`는 같은 `Pig3` 객체를 참조하고 있으므로 `true`를 반환합니다.
        if (animal == pig3) {
            System.out.println("객체 변수 animal과 pig3는 같은 객체를 참조하고 있습니다. (== 결과: true)");
        }
        // 설명: `==`는 주소가 같은지 아닌지 판단하는 것이므로, `pig3`와 `animal`은 같은 주소값을 가지고 있습니다.

        // `animal`과 `pig4`는 서로 다른 `Pig3` 객체를 참조하고 있으므로 `false`를 반환합니다.
        // `pig3`와 `pig4`는 각각 `new Pig3()`를 통해 별도로 생성된 객체이기 때문입니다.
        if (animal != pig4) {
            System.out.println("animal과 pig4는 같은 객체를 참조하고 있지 않습니다. (== 결과: false)");
        }
        // 설명: `animal`과 `pig4`는 서로 다른 객체를 참조하고 있기 때문에 같은 주소값을 가지고 있지 않습니다.

        System.out.println("\n두프룸프님, `instanceof`와 `==` 연산자의 차이를 명확히 이해하셨기를 바랍니다!");
    }
}
