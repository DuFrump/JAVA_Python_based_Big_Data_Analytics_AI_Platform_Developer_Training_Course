package _09_Mini_project;

// 필요한 동물 클래스들을 import 합니다.
// Animals 패키지 내의 클래스들이므로 명시적으로 import 해야 합니다.
import _09_Mini_project.Animals.Animals;
import _09_Mini_project.Animals.Cats;
import _09_Mini_project.Animals.Cows;
import _09_Mini_project.Animals.Dogs;

import java.util.Scanner; // 사용자 입력을 받기 위한 Scanner 클래스 import

/**
 * 아홉 번째 예제, '미니 프로젝트'의 마지막 파일, Main 클래스입니다!
 * 이 미니 프로젝트는 자바의 객체 지향 프로그래밍 개념 중 '상속'과 '다형성'을 활용하여
 * 사용자가 입력한 동물 이름에 따라 해당 동물의 소리를 들려주는 간단한 시뮬레이터를 구현합니다.
 *
 * 🎯 프로젝트 개요:
 * - `Animals`라는 부모 클래스를 만들고, `Cats`, `Cows`, `Dogs`와 같은 자식 클래스들이 이를 상속받습니다.
 * - 각 자식 클래스는 `makeSound()` 메소드를 오버라이딩하여 자신만의 소리를 냅니다.
 * - **다형성(Polymorphism)**을 활용하여, 동일한 `Animals` 타입으로 서로 다른 동물 객체를 처리합니다.
 *   이를 통해 코드를 유연하고 확장 가능하게 만들 수 있습니다.
 *
 * 이 파일을 통해 상속과 다형성이 실제 프로그램에서 어떻게 유용하게 사용되는지 경험해 봅시다!
 */
public class Main {
    public static void main(String[] args) {
        // Scanner 객체 생성: 사용자로부터 키보드 입력을 받기 위해 사용합니다.
        Scanner scanner = new Scanner(System.in);

        String input; // 사용자 입력을 저장할 변수

        System.out.println("--- 동물 사운드 시뮬레이터 ---");
        System.out.println("듣고 싶은 동물 이름을 입력하세요 (dog, cat, cow)");
        System.out.println("종료하려면 'exit'을 입력하세요.");

        // 무한 루프: 사용자가 'exit'을 입력할 때까지 프로그램이 계속 실행됩니다.
        while (true) {
            System.out.print("\n>> 입력: ");
            // 사용자 입력을 읽고, 소문자로 변환하여 input 변수에 저장합니다.
            // toLowerCase()를 사용하는 이유는 사용자가 대소문자를 섞어 입력해도
            // 정확하게 인식하기 위함입니다. (예: "Dog", "DOG" 모두 "dog"으로 처리)
            input = scanner.nextLine().toLowerCase();

            // 종료 조건: 사용자가 "exit"을 입력하면 루프를 종료하고 프로그램을 끝냅니다.
            if (input.equals("exit")) { // 문자열 비교는 == 대신 equals() 메소드를 사용합니다.
                System.out.println("프로그램을 종료합니다. 안녕히 계세요, 두프룸프님!");
                break; // 루프를 빠져나갑니다.
            }

            // [1] 다형성 활용: createAnimal() 메소드는 Animals 타입의 객체를 반환합니다.
            // 사용자의 입력("dog", "cat", "cow")에 따라 실제 반환되는 객체는
            // Dogs, Cats, Cows 중 하나가 됩니다. 하지만 이 객체는 Animals 타입의 참조 변수에 저장됩니다.
            Animals animal = createAnimal(input);

            // [2] 반환된 객체가 null이 아니면 makeSound() 메소드 호출
            // createAnimal() 메소드에서 유효하지 않은 입력일 경우 null을 반환하므로,
            // null 체크를 통해 NullPointerException을 방지합니다.
            if (animal != null) {
                // animal.makeSound()를 호출하면, 실제 객체(Dogs, Cats, Cows)에 오버라이딩된
                // makeSound() 메소드가 실행됩니다. 이것이 바로 다형성의 핵심입니다.
                // 컴파일 시점에는 Animals의 makeSound()가 호출될 것으로 보이지만,
                // 런타임 시점에는 실제 객체의 makeSound()가 호출됩니다.
                animal.makeSound();
            } else {
                System.out.println("알 수 없는 동물입니다. 'dog', 'cat', 'cow' 중 하나를 입력해주세요.");
            }
        }

        // Scanner 자원 해제:
        // Scanner 객체가 사용했던 시스템 자원(입력 스트림)을 반환하여 메모리 누수를 방지합니다.
        // 프로그램이 종료될 때 반드시 호출하는 것이 좋습니다.
        scanner.close();
    }

    /**
     * createAnimal 메소드:
     * 입력된 동물 이름(type)에 따라 적절한 동물 객체를 생성하여 반환합니다.
     * 반환 타입이 `Animals`이므로, 모든 자식 클래스 객체를 `Animals` 타입으로 반환할 수 있습니다.
     * 이것 또한 다형성의 중요한 활용 예시입니다.
     *
     * @param type 사용자가 입력한 동물 이름 (dog, cat, cow)
     * @return 입력된 타입에 해당하는 Animals 객체 (유효하지 않은 입력 시 null 반환)
     */
    public static Animals createAnimal(String type) {
        switch (type) {
            case "dog":
                return new Dogs(); // Dogs 객체를 생성하여 Animals 타입으로 반환
            case "cat":
                return new Cats(); // Cats 객체를 생성하여 Animals 타입으로 반환
            case "cow":
                return new Cows(); // Cows 객체를 생성하여 Animals 타입으로 반환
            default:
                return null; // 유효하지 않은 입력일 경우 null 반환
        }
    }
}