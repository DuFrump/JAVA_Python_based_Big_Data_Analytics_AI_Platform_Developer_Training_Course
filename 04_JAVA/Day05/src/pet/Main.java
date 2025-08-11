package pet;

import java.util.Scanner; // 사용자의 키보드 입력을 받기 위한 Scanner 도구를 가져옵니다.

/**
 * 두프룸프님, 드디어 마지막 파일입니다! 이 Main 클래스는 사용자와 직접 소통하는 반려동물 입양 프로그램이에요.
 *
 * 이 예제를 통해 우리가 만든 Dog, Cat 클래스가 어떻게 실제 프로그램에서 사용되는지,
 * 그리고 사용자의 선택에 따라 어떻게 다른 객체가 생성되고 다른 행동을 하는지 확인할 수 있습니다.
 * 지금까지 배운 모든 지식을 활용하는 실전 예제라고 할 수 있죠. 함께 코드를 분석해봐요!
 */
public class Main {
    public static void main(String[] args) {
        // Scanner 도구를 실제로 사용할 수 있도록 `sc`라는 이름으로 객체를 생성합니다.
        // `System.in`은 키보드 입력을 의미해요.
        Scanner sc = new Scanner(System.in);

        // 사용자에게 어떤 동물을 원하는지 물어봅니다.
        System.out.print("강아지와 고양이 중 어떤 동물을 원하세요? : ");
        // 사용자가 키보드로 입력한 후 엔터를 치면, 그 단어를 읽어서 `adopt`라는 문자열 변수에 저장합니다.
        String adopt = sc.next();

        // `if/else` 문을 사용해서 사용자의 선택에 따라 다른 코드를 실행합니다.
        // 만약 사용자가 "강아지"라고 입력했다면?
        if (adopt.equals("강아지")) { // 문자열 비교는 `==`가 아닌 `.equals()` 메소드를 사용해야 정확해요!

            System.out.println("강아지를 선택하셨군요! 강아지의 이름을 지어주세요: ");
            String dog_name = sc.next(); // 강아지 이름을 입력받습니다.

            System.out.println("강아지의 품종은 무엇인가요? : ");
            String dog_species = sc.next(); // 강아지 품종을 입력받습니다.

            // 이제 입력받은 정보로 새로운 Dog 객체를 생성합니다!
            // 나이는 1~5살 사이의 랜덤한 숫자로 정해줄게요。
            // `Math.random()`은 0.0 이상 1.0 미만의 실수를 반환해요.
            // `* 5`를 하면 0.0 ~ 5.0 미만
            // `+ 1`을 하면 1.0 ~ 6.0 미만
            // `(int)`로 정수만 남기면 최종적으로 1, 2, 3, 4, 5 중 하나의 값이 됩니다.
            int randomAge = (int)(Math.random() * 5) + 1;

            // 사용자가 입력한 이름, 품종과 랜덤으로 정해진 나이로 Dog 객체 `myDog`를 생성합니다。
            Dog myDog = new Dog(dog_name, randomAge, dog_species);

            System.out.println("\n--- 당신만의 강아지가 태어났어요! ---");
            // 방금 만든 `myDog` 객체의 메소드를 호출해서 자기소개와 짖는 행동을 시켜봅니다.
            myDog.doggy_introduce();
            myDog.bark();

        } else { // 사용자가 "강아지"가 아닌 다른 것을 입력했다면 (여기서는 고양이를 선택한 것으로 간주)

            System.out.println("고양이를 선택하셨군요! 고양이의 이름을 지어주세요: ");
            String cat_name = sc.next(); // 고양이 이름을 입력받습니다.

            System.out.println("고양이의 품종은 무엇인가요? : ");
            String cat_species = sc.next(); // 고양이 품종을 입력받습니다。

            int randomAge = (int)(Math.random() * 5) + 1; // 나이를 랜덤으로 정합니다.

            // 사용자가 입력한 정보로 Cat 객체 `myCat`을 생성합니다.
            Cat myCat = new Cat(cat_name, randomAge, cat_species);

            System.out.println("\n--- 당신만의 고양이가 태어났어요! ---");
            // 방금 만든 `myCat` 객체의 메소드를 호출합니다.
            myCat.cat_introduce();
            myCat.cry();
        }

        // Scanner 사용이 끝났으면 닫아주는 것이 좋아요.
        sc.close();
    }
}