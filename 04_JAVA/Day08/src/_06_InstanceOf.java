// `instanceof` 연산자를 사용하여 객체의 실제 타입을 확인하는 방법을 배우는 예제입니다.
// `instanceof`는 객체가 특정 클래스의 인스턴스인지, 또는 특정 인터페이스를 구현했는지 여부를 검사합니다.

// [1] 클래스 계층 구조 정의
// 부모 클래스
class Animal {}

// Animal을 상속받는 자식 클래스
class Pig extends Animal {}
class Cow extends Animal {}

// [2] Farm 클래스: `instanceof`를 활용하여 동물의 소리를 구분
class Farm {
    // `sound` 메소드는 `Animal` 타입의 매개변수를 받습니다. (다형성)
    void sound(Animal animal) {
        // `instanceof` 연산자: `객체 instanceof 클래스명`
        // 객체가 지정된 클래스의 인스턴스이거나, 그 클래스를 상속받은 자식 클래스의 인스턴스이면 `true`를 반환합니다.
        if (animal instanceof Pig) {
            // `animal`이 `Pig` 타입의 객체라면 돼지 소리를 출력
            System.out.println("꿀꿀!");
        } else if (animal instanceof Cow) { // `animal`이 `Cow` 타입의 객체라면 소 소리를 출력
            System.out.println("음메~");
        } else {
            System.out.println("알 수 없는 동물 소리.");
        }
    }
}

public class _06_InstanceOf {
    public static void main(String[] args) {
        // Farm 객체 생성
        Farm farm1 = new Farm();

        // Pig와 Cow 객체 생성
        Pig pig1 = new Pig();
        Cow cow1 = new Cow();

        System.out.println("--- 동물의 소리 확인 (instanceof 사용) ---");
        // `farm1.sound(pig1)` 호출 시, `animal` 매개변수는 `Pig` 객체를 참조합니다.
        farm1.sound(pig1); // 출력: 꿀꿀! (sound(Animal animal = new Pig()))

        // `farm1.sound(cow1)` 호출 시, `animal` 매개변수는 `Cow` 객체를 참조합니다.
        farm1.sound(cow1); // 출력: 음메~ (sound(Animal animal = new Cow()))

        System.out.println("
----------------------------------------
");

        // [3] `instanceof`를 이용한 안전한 다운캐스팅
        // `instanceof`를 사용하여 객체의 실제 타입을 확인한 후 다운캐스팅하면
        // `ClassCastException`을 방지할 수 있습니다.
        Animal someAnimal = new Pig(); // Animal 타입으로 Pig 객체 참조

        if (someAnimal instanceof Pig) {
            Pig p = (Pig) someAnimal; // 안전하게 다운캐스팅
            System.out.println("이 동물은 돼지입니다. (다운캐스팅 성공)");
        } else {
            System.out.println("이 동물은 돼지가 아닙니다.");
        }

        Animal anotherAnimal = new Cow();
        if (anotherAnimal instanceof Pig) {
            Pig p = (Pig) anotherAnimal; // ClassCastException 발생 가능성 있음 (실제로는 Cow 객체)
            System.out.println("이 동물은 돼지입니다. (다운캐스팅 성공)");
        } else {
            System.out.println("이 동물은 돼지가 아닙니다. (다운캐스팅 시도 안 함)");
        }
    }
}
