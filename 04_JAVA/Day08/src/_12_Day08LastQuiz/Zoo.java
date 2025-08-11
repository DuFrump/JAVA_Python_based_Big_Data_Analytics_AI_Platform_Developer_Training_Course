package _12_Day08LastQuiz;

/**
 * 안녕하세요, 두프룸프님! 오늘의 마지막 퀴즈 예제입니다.
 * 이 `Zoo` 클래스는 '다형성(Polymorphism)'을 활용하지 않고
 * 각 동물 객체를 개별적으로 다루는 방식을 보여주는 예제입니다.
 *
 * 이 방식은 언뜻 보기에는 간단해 보일 수 있지만,
 * 새로운 동물이 추가될 때마다 코드를 계속 수정해야 하는 '코드의 중복'과 '확장성 부족'이라는
 * 심각한 단점을 가지고 있습니다.
 *
 * 이 예제를 통해 다형성을 사용하지 않았을 때 발생하는 문제점을 명확히 이해하고,
 * 다음 `Zoo2.java` 예제에서 다형성이 어떻게 이 문제들을 해결하는지 비교해볼 거예요.
 *
 * 자, 그럼 다형성 없는 동물원을 함께 살펴볼까요?
 */

// [1] Dog 클래스: 개의 소리를 정의합니다.
// 이 클래스는 오직 개의 소리를 내는 `makeSound()` 메소드만을 가지고 있습니다.
class Dog {
    public void makeSound() {
        System.out.println("멍멍!");
    }
}

// [2] Cat 클래스: 고양이의 소리를 정의합니다.
// 이 클래스도 오직 고양이의 소리를 내는 `makeSound()` 메소드만을 가지고 있습니다.
class Cat {
    public void makeSound() {
        System.out.println("야옹~");
    }
}

// [3] Cow 클래스: 소의 소리를 정의합니다.
// 이 클래스 역시 오직 소의 소리를 내는 `makeSound()` 메소드만을 가지고 있습니다.
class Cow {
    public void makeSound() {
        System.out.println("음메~");
    }
}

// Zoo 클래스는 다형성을 활용하지 않고 각 동물 객체를 개별적으로 다루는 예제입니다.
// 이 방식은 코드의 중복이 많고 확장성이 떨어진다는 단점이 있습니다.
public class Zoo {
    public static void main(String[] args) {
        // 각 동물 객체 생성: 각 동물의 종류에 맞춰 개별적으로 객체를 생성합니다.
        Dog dog1 = new Dog();
        Cat cat1 = new Cat();
        Cow cow1 = new Cow();

        System.out.println("--- 다형성 없이 각 동물 소리 재생 ---");
        // 각 동물 타입에 맞는 별도의 메소드를 호출하여 소리를 재생합니다.
        // `playDogSound`, `playCatSound`, `playCowSound` 메소드를 각각 호출해야 합니다.
        playDogSound(dog1);
        playCatSound(cat1);
        playCowSound(cow1);

        System.out.println("----------------------------------------");
        System.out.println("이 방식은 새로운 동물이 추가될 때마다 새로운 `playXXXSound` 메소드를 추가해야 합니다.");
        System.out.println("이는 코드의 중복을 야기하고 유지보수를 어렵게 만듭니다.");
    }

    // Dog 객체의 소리를 재생하는 메소드
    // 이 메소드는 오직 `Dog` 타입의 객체만 매개변수로 받을 수 있습니다.
    public static void playDogSound(Dog dog) {
        dog.makeSound();
    }

    // Cat 객체의 소리를 재생하는 메소드
    // 이 메소드는 오직 `Cat` 타입의 객체만 매개변수로 받을 수 있습니다.
    public static void playCatSound(Cat cat) {
        cat.makeSound();
    }

    // Cow 객체의 소리를 재생하는 메소드
    // 이 메소드는 오직 `Cow` 타입의 객체만 매개변수로 받을 수 있습니다.
    public static void playCowSound(Cow cow) {
        cow.makeSound();
    }
}
