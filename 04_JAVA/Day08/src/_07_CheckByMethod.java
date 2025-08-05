class Animal2 {
    void cry() {}
}

class Pig2 extends Animal2 {
    @Override
    void cry() {
        System.out.println("꿀꿀~");
    }
}

class Cow2 extends Animal2 {
    @Override
    void cry() {
        System.out.println("음메~");
    }
}

class Farm2 {
    void sound(Animal2 animal) {
        animal.cry();
    }
}

public class _07_CheckByMethod {
    public static void main(String[] args) {
        Farm2 farm2 = new Farm2();
        Pig2 pig2 = new Pig2();
        Cow2 cow2 = new Cow2();

        farm2.sound(pig2);
        farm2.sound(cow2);
    }
}
