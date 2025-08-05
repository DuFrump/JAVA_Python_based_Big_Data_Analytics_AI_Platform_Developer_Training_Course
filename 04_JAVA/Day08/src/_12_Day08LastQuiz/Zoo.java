package _12_Day08LastQuiz;

class Dog {
    public void makeSound() {
        System.out.println("멍멍!");
    }
}

class Cat {
    public void makeSound() {
        System.out.println("야옹~");
    }
}

class Cow {
    public void makeSound() {
        System.out.println("음메~");
    }
}

public class Zoo {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Cat cat1 = new Cat();
        Cow cow1 = new Cow();

        playDogSound(dog1);
        playCatSound(cat1);
        playCowSound(cow1);
    }

    public static void playDogSound(Dog dog) {
        dog.makeSound();
    }

    public static void playCatSound(Cat cat) {
        cat.makeSound();
    }

    public static void playCowSound(Cow cow) {
        cow.makeSound();
    }
}
