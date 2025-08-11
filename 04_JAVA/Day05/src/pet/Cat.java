package pet;

/**
 * 두프룸프님, 이번에는 pet 예제의 고양이(Cat) 클래스 설계도예요.
 * Dog 클래스와 마찬가지로, 고양이 객체를 만들기 위한 기본적인 정보와 행동을 정의합니다.
 * 두 클래스를 비교하며 공통점과 차이점을 발견해보세요!
 */
public class Cat {
    // === 필드 (Fields) ===
    // 이 고양이 객체가 가질 3가지 주요 정보입니다.
    String name;    // 이름
    int age;        // 나이
    String species; // 품종 (예: 코리안숏헤어, 러시안블루 등)

    // === 생성자 (Constructor) ===
    // `new Cat(...)`를 호출할 때, 이름, 나이, 품종 정보를 모두 받아서
    // 새로운 고양이 객체를 생성하는 역할을 합니다.
    Cat(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }

    // === 메소드 (Methods) ===

    // 고양이가 자기소개를 하는 메소드
    void cat_introduce() {
        System.out.println("안녕하세요, 저는 고양이예요.");
        System.out.printf("제 이름은 %s, 나이는 %d살이고, 종은 %s랍니다.\n", name, age, species);
        System.out.println("잘 부탁드려요. 야옹~");
    }

    // 고양이가 우는 메소드
    void cry() {
        System.out.println("야옹~ 그르릉...");
    }
}
