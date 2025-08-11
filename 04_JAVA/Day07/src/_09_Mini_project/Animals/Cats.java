package _09_Mini_project.Animals;

/**
 * Cats 클래스는 Animals 클래스를 상속받는 '자식 클래스'입니다.
 * 'extends Animals'를 통해 Animals의 모든 속성과 기능을 물려받습니다.
 *
 * 이 클래스에서는 '고양이'라는 특정 동물의 특성에 맞게
 * 부모 클래스인 Animals의 makeSound() 메소드를 오버라이딩하여
 * 고유한 소리를 내도록 구현할 거예요.
 */
public class Cats extends Animals {

    // === 메소드 (Methods) ===

    /**
     * 메소드 오버라이딩: makeSound()
     * 부모 클래스(Animals)의 makeSound() 메소드를 재정의합니다.
     *
     * '@Override' 어노테이션은 이 메소드가 부모의 메소드를 오버라이딩했음을 명시적으로 알려줍니다.
     *
     * 'super.makeSound()'를 통해 부모인 Animals의 makeSound() 기능을 먼저 실행하여
     * "동물이 소리를 냅니다."라는 일반적인 메시지를 출력합니다.
     * 그 후에 고양이만의 소리인 "야옹~"을 추가로 출력합니다.
     * 이렇게 하면 부모의 기능을 재사용하면서 자식 클래스만의 특성을 추가할 수 있습니다.
     */
    @Override
    public void makeSound() {
        super.makeSound(); // 부모 클래스의 makeSound() 메소드 호출
        System.out.println("야옹~"); // 고양이만의 소리 추가
    }
}