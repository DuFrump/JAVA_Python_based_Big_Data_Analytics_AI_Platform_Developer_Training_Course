package _09_Mini_project;

// 필요한 동물 클래스들을 import 합니다.
import _09_Mini_project.Animals.Animals;
import _09_Mini_project.Animals.Cats;
import _09_Mini_project.Animals.Cows;
import _09_Mini_project.Animals.Dogs;

import java.util.Scanner;

// 🎯 프로젝트 개요
// 이 미니 프로젝트는 자바의 객체 지향 프로그래밍 개념 중 상속과 다형성을 활용하여
// 다양한 동물이 고유한 소리를 내는 시뮬레이터를 구현합니다.
// - `Animals`라는 부모 클래스를 만들고, `Cats`, `Cows`, `Dogs`와 같은 자식 클래스들이 이를 상속받습니다.
// - 각 자식 클래스는 `makeSound()` 메소드를 오버라이딩하여 자신만의 소리를 냅니다.
// - **다형성(polymorphism)**을 활용하여, 동일한 `Animals` 타입으로 서로 다른 동물 객체를 처리합니다.

public class Main {
    public static void main(String[] args) {
        // Scanner 객체 생성: 사용자 입력을 받기 위해 사용합니다.
        Scanner scanner = new Scanner(System.in);

        String input; // 사용자 입력을 저장할 변수

        System.out.println("--- 동물 사운드 시뮬레이터 ---");
        System.out.println("듣고 싶은 동물 이름을 입력하세요 (dog, cat, cow)");
        System.out.println("종료하려면 'exit'을 입력하세요.");

        // 무한 루프: 사용자가 'exit'을 입력할 때까지 반복합니다.
        while (true) {
            System.out.print("\n>> 입력: ");
            input = scanner.nextLine().toLowerCase(); // 사용자 입력을 소문자로 변환하여 저장

            // 종료 조건: 사용자가 "exit"을 입력하면 루프를 종료합니다.
            if (input.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // [1] 다형성 활용: `createAnimal()` 메소드는 `Animals` 타입의 객체를 반환합니다.
            // 실제 반환되는 객체는 입력에 따라 `Dogs`, `Cats`, `Cows` 중 하나입니다.
            Animals animal = createAnimal(input);

            // [2] 반환된 객체가 null이 아니면 `makeSound()` 메소드 호출
            // `animal.makeSound()`를 호출하면, 실제 객체(Dogs, Cats, Cows)에 오버라이딩된
            // `makeSound()` 메소드가 실행됩니다. 이것이 다형성의 핵심입니다.
            if (animal != null) {
                animal.makeSound();
            } else {
                System.out.println("알 수 없는 동물입니다. 다시 시도해주세요.");
            }
        }

        // Scanner 자원 해제
        scanner.close();
    }

    // `createAnimal` 메소드: 입력된 동물 이름에 따라 적절한 동물 객체를 생성하여 반환합니다.
    // 반환 타입이 `Animals`이므로, 모든 자식 클래스 객체를 `Animals` 타입으로 반환할 수 있습니다.
    public static Animals createAnimal(String type) {
        switch (type) {
            case "dog":
                return new Dogs();
            case "cat":
                return new Cats();
            case "cow":
                return new Cows();
            default:
                return null; // 유효하지 않은 입력일 경우 null 반환
        }
    }
}

