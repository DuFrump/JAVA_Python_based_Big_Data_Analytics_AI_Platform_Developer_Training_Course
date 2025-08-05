package _12_Day08LastQuiz;

class Animal2 {
    public void makeSound2() {
        System.out.println("동물이 소리를 냅니다.");
    }
}

class Dog2 extends Animal2 {
    @Override
    public void makeSound2() {
        super.makeSound2();
        System.out.println("멍멍!");
    }
}

class Cat2 extends Animal2 {
    @Override
    public void makeSound2() {
        super.makeSound2();
        System.out.println("야옹~");
    }
}

class Cow2 extends Animal2 {
    @Override
    public void makeSound2() {
        super.makeSound2();
        System.out.println("음메~");
    }
}

public class Zoo2 {
    public static void main(String[] args) {
        Animal2 dog1 = new Dog2();
        Animal2 cat1 = new Cat2();
        Animal2 cow1 = new Cow2();

        makeAnimalSound(dog1);
        makeAnimalSound(cat1);
        makeAnimalSound(cow1);
    }

    public static void makeAnimalSound(Animal2 animal) {
        animal.makeSound2();
    }
}
