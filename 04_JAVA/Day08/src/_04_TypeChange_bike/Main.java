package _04_TypeChange_bike;

/**
 * 안녕하세요, 두프룸프님! 이제 `Bike`와 `FourWheelBike` 클래스를 직접 사용해보면서
 * 우리가 배운 다형성(Polymorphism)과 다운캐스팅(Downcasting) 개념이 실제로 어떻게 동작하는지 확인해볼 시간이에요.
 *
 * 이 `Main` 클래스에서는 다음을 중점적으로 살펴볼 겁니다:
 * 1. 다형성을 활용하여 부모 타입(`Bike`)의 참조 변수로 자식 객체(`FourWheelBike`)를 참조할 때의 동작 방식
 * 2. 부모 타입으로 참조된 자식 객체의 고유 메소드에 접근하기 위해 '다운캐스팅'을 어떻게 사용하는지
 * 3. 잘못된 다운캐스팅 시 발생할 수 있는 `ClassCastException`에 대해 이해하기
 *
 * 코드를 실행하면서 각 출력 결과를 주의 깊게 살펴보세요. 그럼 시작해볼까요?
 */
public class Main {
    public static void main(String[] args) {
        // [1] 다형성(Polymorphism) 예시: 부모 클래스 타입으로 자식 클래스 객체 참조
        // `Bike b1 = new FourWheelBike("김무개");`
        // - `b1`은 겉으로는 `Bike` 타입처럼 보이지만, 실제로는 `FourWheelBike` 객체를 가리키고 있어요.
        // - `b1`을 통해서는 `Bike` 클래스에 정의된 메소드만 호출할 수 있습니다.
        // - 하지만! 만약 `FourWheelBike`에서 부모의 메소드를 오버라이딩했다면, 실제 객체인 `FourWheelBike`의 오버라이딩된 메소드가 호출됩니다.
        Bike b1 = new FourWheelBike("김무개"); // "김무개" 라이더의 네발 자전거를 Bike 타입으로 참조

        System.out.println("--- Bike 타입으로 FourWheelBike 객체 참조 ---");
        b1.info(); // `FourWheelBike`는 `info()`를 오버라이딩하지 않았으므로, 부모인 `Bike`의 `info()`가 호출됩니다.
                   // 출력: "김무개의 자전거는 2발 자전거 입니다."
        b1.ride(); // `Bike`의 `ride()` 메소드 호출: "~~~씽씽~~~"

        // [중요] 자식 클래스 고유의 메소드에는 부모 타입의 참조 변수로 직접 접근할 수 없습니다.
        // `b1`은 `Bike` 타입이므로, `Bike` 클래스에 없는 `addWheel()` 메소드를 호출하려고 하면
        // 컴파일러가 해당 메소드를 찾을 수 없다고 오류를 발생시킵니다.
        // 아래 주석을 해제하면 `cannot find symbol` 컴파일 에러가 발생합니다.
        // b1.addWheel(); // 에러: Bike 클래스에는 addWheel() 메소드가 없음
        System.out.println("b1.addWheel()은 컴파일 에러 발생 (자식 고유 메소드 접근 불가)");

        System.out.println("\n----------------------------------------\n");

        // [2] 다운캐스팅(Downcasting)을 통한 자식 고유 메소드 접근
        // 부모 타입으로 참조되던 객체를 다시 자식 타입으로 변환하는 것을 '다운캐스팅'이라고 합니다.
        // 다운캐스팅은 런타임 오류(`ClassCastException`)가 발생할 수 있으므로,
        // `instanceof` 연산자로 안전하게 형변환 가능한지 '반드시' 확인한 후 사용해야 합니다.

        // `b1`은 실제 `FourWheelBike` 객체이므로, `FourWheelBike` 타입으로 다운캐스팅이 가능합니다.
        if (b1 instanceof FourWheelBike) { // `b1`이 `FourWheelBike`의 인스턴스인지 확인
            FourWheelBike fwb1 = (FourWheelBike) b1; // 안전하게 `Bike` 타입의 `b1`을 `FourWheelBike` 타입으로 다운캐스팅

            System.out.println("--- 다운캐스팅 후 FourWheelBike 객체 사용 ---");
            fwb1.addWheel(); // 이제 `FourWheelBike` 고유의 `addWheel()` 메소드를 호출할 수 있어요!
                             // 출력: "김무개의 자전거에 보조 바퀴 부착! 이제 4발 자전거가 되었어요!"
            fwb1.info();     // `FourWheelBike`는 `info()`를 오버라이딩하지 않았으므로 `Bike`의 `info()` 호출
                             // 출력: "김무개의 자전거는 4발 자전거 입니다."
            fwb1.ride();     // `Bike`의 `ride()` 호출: "~~~씽씽~~~"
        } else {
            System.out.println("b1은 FourWheelBike 타입이 아닙니다. 다운캐스팅 불가.");
        }

        /**
         * [중요] 모든 부모 타입 객체를 자식 타입으로 변환할 수 있는 것은 아닙니다!
         * 부모 타입 객체가 실제로 자식 타입 객체일 때만 강제 변환(다운캐스팅)이 가능합니다.
         *
         * 즉, 부모 타입으로 참조된 객체가 실제로 자식 클래스의 객체라면 자식 타입으로 강제 변환할 수 있지만,
         * 그렇지 않으면 `ClassCastException` (런타임 오류)이 발생합니다.
         *
         * 예시: `Bike bike = new Bike("일반 라이더");` // 실제 객체는 `Bike` 타입
         *       `FourWheelBike fwb = (FourWheelBike) bike;` // 이 경우 `ClassCastException` 발생!
         *       (왜냐하면 `bike`는 실제 `Bike` 객체이지 `FourWheelBike` 객체가 아니기 때문입니다.)
         */

        System.out.println("\n두프룸프님, 자전거 예제를 통해 다형성과 다운캐스팅이 어떻게 동작하는지 잘 이해하셨기를 바랍니다!");
    }
}
