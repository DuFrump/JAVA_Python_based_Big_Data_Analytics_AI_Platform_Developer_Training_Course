package _12_Day08LastQuiz;

// [1] Animal2 클래스: 모든 동물의 기본적인 소리 기능을 정의하는 부모 클래스
class Animal2 {
    public void makeSound2() {
        System.out.println("동물이 소리를 냅니다.");
    }
}

// [2] Dog2 클래스: Animal2를 상속받아 개의 소리를 오버라이딩
class Dog2 extends Animal2 {
    @Override
    public void makeSound2() {
        super.makeSound2(); // 부모의 기본 소리 출력
        System.out.println("멍멍!"); // 개만의 소리 추가
    }
}

// [3] Cat2 클래스: Animal2를 상속받아 고양이의 소리를 오버라이딩
class Cat2 extends Animal2 {
    @Override
    public void makeSound2() {
        super.makeSound2(); // 부모의 기본 소리 출력
        System.out.println("야옹~"); // 고양이만의 소리 추가
    }
}

// [4] Cow2 클래스: Animal2를 상속받아 소의 소리를 오버라이딩
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
        Animal2 dog1 = new Dog2();
        Animal2 cat1 = new Cat2();
        Animal2 cow1 = new Cow2();

        System.out.println("--- 다형성을 활용한 동물 소리 재생 ---");
        // [6] 단일 메소드를 통한 다양한 객체 처리
        // `makeAnimalSound()` 메소드는 `Animal2` 타입의 매개변수를 받습니다.
        // 이 메소드 내에서 `animal.makeSound2()`를 호출하면, 실제 객체에 오버라이딩된
        // `makeAnimalSound()` 메소드가 실행됩니다. (동적 바인딩)
        makeAnimalSound(dog1);
        makeAnimalSound(cat1);
        makeAnimalSound(cow1);

        System.out.println("
----------------------------------------
");
        System.out.println("이 방식은 새로운 동물이 추가되어도 `makeAnimalSound` 메소드를 수정할 필요가 없습니다.");
        System.out.println("이는 코드의 유연성과 확장성을 크게 향상시킵니다.");
    }

    // [7] 모든 동물의 소리를 재생하는 단일 메소드
    // `Animal2` 타입의 매개변수를 받으므로, `Animal2`를 상속받는 모든 객체를 처리할 수 있습니다.
    public static void makeAnimalSound(Animal2 animal) {
        animal.makeSound2();
    }
}
