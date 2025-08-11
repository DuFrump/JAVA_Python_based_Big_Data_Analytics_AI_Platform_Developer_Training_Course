package _12_Day08LastQuiz;

/**
 * 안녕하세요, 두프룸프님! 오늘의 마지막 퀴즈 예제, `Zoo2`입니다.
 * 이 클래스는 `Zoo.java`와는 다르게 '다형성(Polymorphism)'을 적극적으로 활용하여
 * 모든 동물의 소리를 유연하고 효율적으로 재생하는 방법을 보여줍니다.
 *
 * `Zoo.java`에서 보았듯이, 다형성을 사용하지 않으면 새로운 동물이 추가될 때마다
 * 코드를 계속 수정해야 하는 비효율적인 상황이 발생합니다.
 * 하지만 이 `Zoo2` 예제를 통해 다형성이 어떻게 이러한 문제들을 해결하고,
 * 코드의 '유연성', '확장성', 그리고 '유지보수 용이성'을 크게 향상시키는지 직접 확인해볼 거예요.
 *
 * 자, 그럼 다형성을 활용한 스마트한 동물원을 함께 살펴볼까요?
 */

// [1] Animal2 클래스: 모든 동물의 기본적인 소리 기능을 정의하는 부모 클래스
// 이 클래스는 모든 동물이 공통적으로 가질 수 있는 `makeSound2()` 메소드를 정의합니다.
// 자식 클래스들이 이 메소드를 자신에게 맞게 재정의(오버라이딩)할 거예요.
class Animal2 {
    public void makeSound2() {
        System.out.println("동물이 소리를 냅니다.");
    }
}

// [2] Dog2 클래스: Animal2를 상속받아 개의 소리를 오버라이딩
// `Dog2`는 `Animal2`의 `makeSound2()` 메소드를 재정의하여 개만의 소리를 추가합니다.
class Dog2 extends Animal2 {
    @Override
    public void makeSound2() {
        super.makeSound2(); // 부모의 기본 소리 출력 (선택 사항, 여기서는 "동물이 소리를 냅니다." 출력)
        System.out.println("멍멍!"); // 개만의 소리 추가
    }
}

// [3] Cat2 클래스: Animal2를 상속받아 고양이의 소리를 오버라이딩
// `Cat2`는 `Animal2`의 `makeSound2()` 메소드를 재정의하여 고양이만의 소리를 추가합니다.
class Cat2 extends Animal2 {
    @Override
    public void makeSound2() {
        super.makeSound2(); // 부모의 기본 소리 출력
        System.out.println("야옹~"); // 고양이만의 소리 추가
    }
}

// [4] Cow2 클래스: Animal2를 상속받아 소의 소리를 오버라이딩
// `Cow2`는 `Animal2`의 `makeSound2()` 메소드를 재정의하여 소만의 소리를 추가합니다.
class Cow2 extends Animal2 {
    @Override
    public void makeSound2() {
        super.makeSound2(); // 부모의 기본 소리 출력
        System.out.println("음메~"); // 소만의 소리 추가
    }
}

// Zoo2 클래스는 다형성(Polymorphism)을 활용하여 모든 동물의 소리를 재생하는 예제입니다.
// `Zoo.java`와 비교하여 코드의 유연성, 확장성, 중복 감소의 장점을 보여줍니다.
public class Zoo2 {
    public static void main(String[] args) {
        // [5] 다형성 활용: 부모 클래스 타입으로 자식 클래스 객체 참조
        // `Animal2` 타입의 참조 변수에 `Dog2`, `Cat2`, `Cow2` 객체를 할당합니다.
        // 이렇게 하면 `Animal2`를 상속받는 어떤 동물이든 이 변수에 저장할 수 있습니다.
        Animal2 dog1 = new Dog2();
        Animal2 cat1 = new Cat2();
        Animal2 cow1 = new Cow2();

        System.out.println("--- 다형성을 활용한 동물 소리 재생 ---");
        // [6] 단일 메소드를 통한 다양한 객체 처리
        // `makeAnimalSound()` 메소드는 `Animal2` 타입의 매개변수를 받습니다.
        // 이 메소드 내에서 `animal.makeSound2()`를 호출하면, 실제 객체(예: `Dog2`, `Cat2`, `Cow2`)에
        // 오버라이딩된 `makeSound2()` 메소드가 실행됩니다. 이것이 바로 '동적 바인딩'입니다.
        // 즉, 동일한 메소드 호출이 객체의 실제 타입에 따라 다르게 동작하는 것이죠!
        makeAnimalSound(dog1);
        makeAnimalSound(cat1);
        makeAnimalSound(cow1);

        System.out.println("----------------------------------------");
        System.out.println("이 방식은 새로운 동물이 추가되어도 `makeAnimalSound` 메소드를 수정할 필요가 없습니다.");
        System.out.println("새로운 동물 클래스만 `Animal2`를 상속받고 `makeSound2()`를 오버라이딩하면 됩니다.");
        System.out.println("이는 코드의 유연성과 확장성을 크게 향상시킵니다.");

        System.out.println("\n두프룸프님, 다형성을 활용한 동물원 예제를 통해 객체 지향 프로그래밍의 강력함을 잘 이해하셨기를 바랍니다!");
    }

    // [7] 모든 동물의 소리를 재생하는 단일 메소드
    // 이 `makeAnimalSound` 메소드는 `Animal2` 타입의 매개변수를 받으므로,
    // `Animal2`를 상속받는 모든 객체(Dog2, Cat2, Cow2 등)를 처리할 수 있습니다.
    // `Zoo.java`에서처럼 각 동물마다 별도의 메소드를 만들 필요가 없어 코드 중복이 사라집니다.
    public static void makeAnimalSound(Animal2 animal) {
        animal.makeSound2();
    }
}
