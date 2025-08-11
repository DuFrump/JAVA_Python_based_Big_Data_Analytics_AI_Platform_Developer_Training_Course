package pet;

/**
 * 두프룸프님, pet 예제의 강아지(Dog) 클래스 설계도입니다.
 * 이 클래스는 강아지 객체를 만들기 위한 가장 기본적인 정보들(이름, 나이, 품종)과
 * 간단한 행동(자기소개, 짖기)을 정의하고 있어요.
 * 아주 심플한 구조를 통해 클래스의 기본을 다시 한번 다져봅시다.
 */
public class Dog {
    // === 필드 (Fields) ===
    // 이 강아지 객체가 가질 3가지 주요 정보입니다.
    String name;    // 이름
    int age;        // 나이
    String species; // 품종 (예: 말티즈, 푸들 등)

    // === 생성자 (Constructor) ===
    // `new Dog(...)`를 호출할 때, 이름, 나이, 품종 정보를 모두 받아서
    // 새로운 강아지 객체를 생성하는 역할을 합니다.
    Dog(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }

    // === 메소드 (Methods) ===

    // 강아지가 자기소개를 하는 메소드
    void doggy_introduce() {
        System.out.println("안녕하세요! 저는 강아지입니다.");
        System.out.printf("제 이름은 %s이고, %d살이에요. 품종은 %s랍니다.\n", name, age, species);
        System.out.println("멍멍! 잘 부탁드려요!");
    }

    // 강아지가 짖는 메소드
    void bark() {
        System.out.println("멍멍!! 왈왈!!");
    }
}
