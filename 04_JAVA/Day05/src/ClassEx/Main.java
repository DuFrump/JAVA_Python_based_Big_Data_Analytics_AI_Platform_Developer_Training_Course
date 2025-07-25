package ClassEx;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Dog dog1 = new Dog("누렁이", 3);
        Dog dog2 = new Dog("바둑이", 2);
        Dog dog3 = new Dog("흰둥이");
        Dog dog4 = new Dog();


        dog1.introduce();
        dog2.introduce();
        dog1.weare();

        System.out.println("누렁이의 나이는 " + dog1.getAge() + " 살");
        dog1.setAge(4);
        System.out.println("누렁이의 나이는 " + dog1.getAge() + " 살");

        dog3.introduce();
        dog3.setAge(1);
        dog3.introduce();

        System.out.println("----------------------------");

        dog4.setName("까매");
        dog4.setAge(-1);
        dog4.introduce();
        System.out.println("------------------------------");
        dog4.setAge(1);
        dog4.introduce();

        System.out.println("우리는 " + Dog.bark + " 짖어요");

        System.out.println("자기 소개 횟수: " + Dog.count);


        System.out.println("----------------------------------");

        Cat nabi = new Cat("나비", 8);

        nabi.cry();
        nabi.introduce();

        System.out.println("제 이름은 " + nabi.name);
        System.out.println("제 나이는 " + nabi.age);

        nabi.introduce_dream("행복한 고양이");

        int poopy = nabi.feed_unga(5);
        System.out.println("결론적으로 똥 싸는 횟수는 : " + poopy);

        int poopy2 = nabi.feed_unga(2, 2);
        System.out.printf("결론적으로 똥 싸는 횟수는 : %d%n", poopy2);
    }
}
