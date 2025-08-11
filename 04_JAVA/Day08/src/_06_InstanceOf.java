/**
 * 안녕하세요, 두프룸프님! 오늘은 Java에서 객체의 '실제 타입'을 확인하는 아주 유용한 연산자인
 * `instanceof`에 대해 배워볼 거예요.
 *
 * `instanceof` 연산자는 객체가 특정 클래스의 인스턴스인지, 또는 특정 인터페이스를 구현했는지 여부를 검사합니다.
 * 특히 다형성(Polymorphism)을 사용하여 부모 타입으로 자식 객체를 참조할 때,
 * 자식 객체만의 고유한 메소드나 필드에 접근하기 전에 안전하게 타입을 확인하는 데 필수적으로 사용됩니다.
 *
 * 이 예제에서는 다음을 중점적으로 살펴볼 거예요:
 * 1. 간단한 클래스 상속 계층 구조 만들기
 * 2. `instanceof`를 사용하여 객체의 타입을 조건문으로 확인하는 방법
 * 3. `instanceof`를 이용한 '안전한 다운캐스팅' 방법
 *
 * `instanceof`를 잘 활용하면 런타임 오류(`ClassCastException`)를 방지하고
 * 더욱 견고한 코드를 작성할 수 있답니다!
 */

// [1] 클래스 계층 구조 정의: 동물 가족을 만들어볼까요?
// 부모 클래스: 모든 동물의 공통적인 특징을 정의합니다.
class Animal {}

// Animal을 상속받는 자식 클래스들: 돼지와 소는 동물입니다.
class Pig extends Animal {}
class Cow extends Animal {}

// [2] Farm 클래스: `instanceof`를 활용하여 동물의 소리를 구분하는 예시
class Farm {
    // `sound` 메소드는 `Animal` 타입의 매개변수를 받습니다. (다형성)
    // 즉, `Animal`을 상속받는 어떤 동물이든 이 메소드의 매개변수로 전달될 수 있어요.
    void sound(Animal animal) {
        // `instanceof` 연산자: `객체 instanceof 클래스명`
        // 이 연산자는 왼쪽에 있는 `객체`가 오른쪽에 있는 `클래스명`의 인스턴스이거나,
        // 그 클래스를 상속받은 자식 클래스의 인스턴스이면 `true`를 반환합니다.
        // 이를 통해 런타임에 객체의 실제 타입을 안전하게 확인할 수 있습니다.
        if (animal instanceof Pig) {
            // `animal`이 `Pig` 타입의 객체라면 돼지 소리를 출력합니다.
            System.out.println("꿀꿀!");
        } else if (animal instanceof Cow) { // `animal`이 `Cow` 타입의 객체라면 소 소리를 출력합니다.
            System.out.println("음메~");
        } else {
            // `Pig`도 `Cow`도 아니라면 알 수 없는 동물 소리를 출력합니다.
            System.out.println("알 수 없는 동물 소리.");
        }
    }
}

public class _06_InstanceOf {
    public static void main(String[] args) {
        // Farm 객체 생성: 우리 농장을 만들어요.
        Farm farm1 = new Farm();

        // Pig와 Cow 객체 생성: 농장에 살 동물들을 만들어요.
        Pig pig1 = new Pig();
        Cow cow1 = new Cow();

        System.out.println("\n--- 동물의 소리 확인 (instanceof 사용) ---");
        // `farm1.sound(pig1)` 호출 시, `sound` 메소드의 `animal` 매개변수는 `Pig` 객체를 참조합니다.
        // `instanceof Pig` 조건이 `true`가 되어 "꿀꿀!"이 출력됩니다.
        farm1.sound(pig1); // 출력: 꿀꿀! (sound(Animal animal = new Pig()))

        // `farm1.sound(cow1)` 호출 시, `sound` 메소드의 `animal` 매개변수는 `Cow` 객체를 참조합니다.
        // `instanceof Pig`는 `false`이고, `instanceof Cow` 조건이 `true`가 되어 "음메~"가 출력됩니다.
        farm1.sound(cow1); // 출력: 음메~ (sound(Animal animal = new Cow()))

        System.out.println("\n----------------------------------------\n");

        // [3] `instanceof`를 이용한 안전한 다운캐스팅
        // 다형성으로 인해 부모 타입(`Animal`)으로 자식 객체(`Pig`)를 참조하고 있는 상황이에요.
        Animal someAnimal = new Pig(); // Animal 타입으로 Pig 객체 참조

        // `instanceof`를 사용하여 객체의 실제 타입을 확인한 후 다운캐스팅하면
        // `ClassCastException` (런타임 오류)을 방지할 수 있습니다. 아주 중요해요!
        if (someAnimal instanceof Pig) { // `someAnimal`이 `Pig`의 인스턴스인지 확인
            Pig p = (Pig) someAnimal; // `someAnimal`이 `Pig` 타입임을 확인했으니 안전하게 다운캐스팅!
            System.out.println("이 동물은 돼지입니다. (다운캐스팅 성공)");
        } else {
            System.out.println("이 동물은 돼지가 아닙니다.");
        }

        // 이번에는 `Cow` 객체를 `Animal` 타입으로 참조해볼게요.
        Animal anotherAnimal = new Cow();
        // `anotherAnimal`이 `Pig`의 인스턴스인지 확인합니다.
        // 실제로는 `Cow` 객체이므로 `instanceof Pig`는 `false`가 됩니다.
        if (anotherAnimal instanceof Pig) {
            // 이 블록은 실행되지 않습니다. 만약 `instanceof` 없이 강제 다운캐스팅을 시도했다면
            // `ClassCastException`이 발생했을 거예요!
            Pig p = (Pig) anotherAnimal; // ClassCastException 발생 가능성 있음 (실제로는 Cow 객체)
            System.out.println("이 동물은 돼지입니다. (다운캐스팅 성공)");
        } else {
            System.out.println("이 동물은 돼지가 아닙니다. (다운캐스팅 시도 안 함)");
        }

        System.out.println("\n두프룸프님, `instanceof` 연산자를 통해 객체의 타입을 안전하게 확인하고");
        System.out.println("다운캐스팅하는 방법을 잘 이해하셨기를 바랍니다!");
    }
}
