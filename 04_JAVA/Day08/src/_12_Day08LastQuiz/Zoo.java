package _12_Day08LastQuiz;

// [1] Dog 클래스: 개의 소리를 정의합니다.
class Dog {
    public void makeSound() {
        System.out.println("멍멍!");
    }
}

// [2] Cat 클래스: 고양이의 소리를 정의합니다.
class Cat {
    public void makeSound() {
        System.out.println("야옹~");
    }
}

// [3] Cow 클래스: 소의 소리를 정의합니다.
class Cow {
    public void makeSound() {
        System.out.println("음메~");
    }
}

// Zoo 클래스는 다형성을 활용하지 않고 각 동물 객체를 개별적으로 다루는 예제입니다.
// 이 방식은 코드의 중복이 많고 확장성이 떨어진다는 단점이 있습니다.
public class Zoo {
    public static void main(String[] args) {
        // 각 동물 객체 생성
        Dog dog1 = new Dog();
        Cat cat1 = new Cat();
        Cow cow1 = new Cow();

        System.out.println("--- 다형성 없이 각 동물 소리 재생 ---");
        // 각 동물 타입에 맞는 별도의 메소드를 호출하여 소리를 재생합니다.
        playDogSound(dog1);
        playCatSound(cat1);
        playCowSound(cow1);

        System.out.println("
----------------------------------------
");
        System.out.println("이 방식은 새로운 동물이 추가될 때마다 새로운 `playXXXSound` 메소드를 추가해야 합니다.");
        System.out.println("이는 코드의 중복을 야기하고 유지보수를 어렵게 만듭니다.");
    }

    // Dog 객체의 소리를 재생하는 메소드
    public static void playDogSound(Dog dog) {
        dog.makeSound();
    }

    // Cat 객체의 소리를 재생하는 메소드
    public static void playCatSound(Cat cat) {
        cat.makeSound();
    }

    // Cow 객체의 소리를 재생하는 메소드
    public static void playCowSound(Cow cow) {
        cow.makeSound();
    }
}
