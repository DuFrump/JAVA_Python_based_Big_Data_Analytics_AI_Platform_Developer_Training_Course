package pet;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("강아지와 고양이 중 어떤 동물을 고르실 것입니까? : ");
        String adopt = sc.next();

        if (adopt.equals("강아지")) {
            System.out.println("그렇다면 강아지의 이름을 정해주세요!");
            String dog_name = sc.next();
            System.out.println("그렇다면 강아지의 종을 정해주세요!");
            String dog_species = sc.next();

            dog myDog = new dog(dog_name, (int)(Math.random() * 5) + 1, dog_species);

            myDog.doggy_introduce();
            myDog.bark();
        } else {
            System.out.println("그렇다면 고양이의 이름을 정해주세요!");
            String cat_name = sc.next();
            System.out.println("그렇다면 고양이의 종을 정해주세요!");
            String cat_species = sc.next();

            cat myCat = new cat(cat_name, (int)(Math.random() * 5) + 1, cat_species);

            myCat.cat_introduce();
            myCat.cry();
        }
    }
}
