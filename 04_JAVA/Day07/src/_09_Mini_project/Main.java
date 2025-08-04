package _09_Mini_project;

import _09_Mini_project.Animals.Animals;
import _09_Mini_project.Animals.Cats;
import _09_Mini_project.Animals.Cows;
import _09_Mini_project.Animals.Dogs;

import java.util.Scanner;

// 🎯 프로젝트 개요
// 다양한 동물 클래스를 만들어서, 각 동물이 고유한 소리를 내도록 구성
// Animal이라는 추상 클래스 혹은 슈퍼클래스를 만들고, 하위 클래스에서 오버라이딩
// **다형성(polymorphism)**을 활용해서, 동일한 타입으로 서로 다른 객체를 처리

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("어떤 동물을 원하시나요? : ");
        String input;

        System.out.println("동물 사운드 시뮬레이터입니다!");
        System.out.println("듣고 싶은 동물 이름을 입력하세요 (dog, cat, cow)");
        System.out.println("종료하려면 'exit'을 입력하세요.");

        while (true) {
            System.out.print("\n>> 입력: ");
            input = scanner.nextLine().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            Animals animal = createAnimal(input);
            if (animal != null) {
                animal.makeSound();
            } else {
                System.out.println("알 수 없는 동물입니다. 다시 시도해주세요.");
            }
        }

        scanner.close();
    }

    public static Animals createAnimal(String type) {
        switch (type) {
            case "dog":
                return new Dogs();
            case "cat":
                return new Cats();
            case "cow":
                return new Cows();
            default:
                return null;
        }
    }
}
