package ClassEx;

// `java.util.Scanner`는 사용자의 키보드 입력을 받기 위해 필요한 도구(클래스)를 가져오는 코드예요.
// 지금 이 파일에서는 사용되고 있지 않지만, 나중에 프로그램을 확장할 때를 위해 남겨둔 것 같네요!
import java.util.Scanner;

/**
 * 두프룸프님, 드디어 실행 시간입니다!
 * 이 Main 클래스는 우리가 만든 Cat과 Dog라는 설계도를 가지고
 * 실제 강아지와 고양이 객체를 만들어서 살아 움직이게 하는 역할을 해요.
 *
 * `main` 메소드 안의 코드를 한 줄 한 줄 따라가면서,
 * 객체가 어떻게 만들어지고, 메소드가 어떻게 호출되며, 그 결과가 어떻게 나타나는지 함께 지켜봐요!
 */
public class Main {
    public static void main(String[] args) {

        // === 강아지(Dog) 파트 ===
        System.out.println("--- 강아지들을 소개합니다! ---");

        // Dog 클래스(설계도)로 4마리의 강아지(객체)를 만듭니다.
        Dog dog1 = new Dog("누렁이", 3); // 이름과 나이를 모두 알려주며 생성
        Dog dog2 = new Dog("바둑이", 2);
        Dog dog3 = new Dog("흰둥이");     // 이름만 알려주고 생성 (나이는 0인 상태)
        Dog dog4 = new Dog();           // 아무 정보 없이 기본으로 생성 (이름은 null, 나이는 0인 상태)

        // 각 강아지에게 자기소개를 시켜볼까요?
        dog1.introduce(); // "제 이름은 누렁이이고, 나이는 3살이에요."
        dog2.introduce(); // "제 이름은 바둑이이고, 나이는 2살이에요."

        // Getter/Setter를 사용해서 안전하게 데이터에 접근해 봅시다.
        System.out.println("누렁이의 나이(수정 전): " + dog1.getAge() + "살");
        dog1.setAge(4); // 누렁이의 나이를 4살로 변경!
        System.out.println("누렁이의 나이(수정 후): " + dog1.getAge() + "살");

        System.out.println("\n--- 아직 정보가 부족한 강아지들 ---");
        dog3.introduce(); // "제 이름은 흰둥이이고, 나이는 0살이에요."
        dog3.setAge(1);   // 흰둥이의 나이를 1살로 설정
        dog3.introduce(); // "제 이름은 흰둥이이고, 나이는 1살이에요."

        // Setter의 유효성 검사 기능을 테스트해볼게요.
        dog4.setName("까망이");
        dog4.setAge(-1);  // 나이를 -1살로 설정하려고 시도!
        // 하지만 Dog 클래스의 setAge() 메소드에 "1살 이상만 가능하다"는 방어 코드가 있어서, 이 값은 무시될 거예요.
        dog4.introduce(); // "제 이름은 까망이이고, 나이는 0살이에요." (나이는 여전히 0)

        dog4.setAge(1);   // 이번엔 정상적으로 1살로 설정
        dog4.introduce(); // "제 이름은 까망이이고, 나이는 1살이에요."

        System.out.println("\n--- 다 함께 짖어볼까? ---");
        dog1.bark(); // "누렁이이(가) 멍멍! 하고 짖습니다."

        // static 변수인 count를 클래스 이름으로 직접 접근해서 총 자기소개 횟수를 확인해요.
        System.out.println("지금까지 강아지들이 자기소개한 총 횟수: " + Dog.count);


        System.out.println("\n----------------------------------\n");

        // === 고양이(Cat) 파트 ===
        System.out.println("--- 이번엔 고양이를 소개합니다! ---");

        // Cat 클래스(설계도)로 "나비"라는 이름의 고양이(객체)를 만듭니다.
        Cat nabi = new Cat("나비", 8);

        nabi.cry();      // "야옹~ 야옹~"
        nabi.introduce(); // "제 이름은 나비이고, 나이는 8살이에요."

        // Cat 클래스의 변수들은 private이 아니므로 직접 접근이 가능해요.
        System.out.println("이름 확인: " + nabi.name);
        System.out.println("나이 확인: " + nabi.age);

        nabi.introduce_dream("츄르 부자");

        System.out.println("\n--- 메소드 오버로딩 테스트 ---");
        // 밥을 5번 줬을 때, 응가 횟수는? (bob * 2)
        int poopy = nabi.feed_unga(5);
        System.out.println("결과적으로 응가 횟수는: " + poopy + "번");

        // 밥 2번, 물 2번 줬을 때, 응가 횟수는? (bob + moul)
        int poopy2 = nabi.feed_unga(2, 2);
        System.out.printf("결과적으로 응가 횟수는: %d번\n", poopy2);
    }
}