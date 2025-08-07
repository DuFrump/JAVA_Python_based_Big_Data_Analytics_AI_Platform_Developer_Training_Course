package _09_Mini_project.Animals;

// Animals 클래스는 모든 동물의 기본적인 특성을 나타내는 부모 클래스(Superclass)입니다.
// 다형성(Polymorphism)을 보여주기 위한 기반 클래스 역할을 합니다.
public class Animals {
    // 메소드: 동물이 소리를 내는 기능을 정의합니다.
    // 이 메소드는 자식 클래스에서 각 동물의 특성에 맞게 오버라이딩될 것입니다.
    public void makeSound() {
        System.out.println("동물이 소리를 냅니다.");
    }
}
