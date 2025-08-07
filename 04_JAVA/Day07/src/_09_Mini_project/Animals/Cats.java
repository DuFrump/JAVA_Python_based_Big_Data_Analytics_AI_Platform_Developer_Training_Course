package _09_Mini_project.Animals;

// Cats 클래스는 Animals 클래스를 상속받는 자식 클래스입니다.
// 고양이의 특성을 정의합니다.
public class Cats extends Animals {
    // 메소드 오버라이딩: `makeSound()`
    // 부모 클래스(Animals)의 `makeSound()` 메소드를 재정의합니다.
    // `super.makeSound()`를 통해 부모의 기능을 먼저 실행한 후, 고양이만의 소리를 추가합니다.
    @Override
    public void makeSound() {
        super.makeSound(); // "동물이 소리를 냅니다." 출력
        System.out.println("야옹~"); // 고양이만의 소리 추가
    }
}
