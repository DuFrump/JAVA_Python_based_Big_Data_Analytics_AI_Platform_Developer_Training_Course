class Animal {}
class Pig extends Animal {}
class Cow extends Animal {}

class Farm {
    void sound(Animal animal) {
        if (animal instanceof Pig) {
            System.out.println("꿀꿀!");
        } else {
            System.out.println("음메~");
        }
    }
}

public class _06_InstanceOf {
    public static void main(String[] args) {
        Farm farm1 = new Farm();
        Pig pig1 = new Pig();
        Cow cow1 = new Cow();

        farm1.sound(pig1); // sound(Animal animal = new Pig())
        farm1.sound(cow1);
    }
}
