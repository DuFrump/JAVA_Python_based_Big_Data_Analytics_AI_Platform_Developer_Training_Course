package pet;

public class dog {
    String name;
    int age;
    String species;

    dog(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }

    void doggy_introduce() {
        System.out.println("안녕하세요. 저는 강아지입니다.");
        System.out.printf("저의 이름은 %s이고, 나이는 %d살 입니다. 저의 종은 %s(이)에요.%n", name, age, species);
        System.out.println("잘 부탁드립니다.");
    }

    void bark() {
        System.out.println("멍멍!!");
    }
}
