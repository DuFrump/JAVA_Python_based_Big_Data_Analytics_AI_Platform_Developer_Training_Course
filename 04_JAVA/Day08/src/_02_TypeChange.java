/**
 * 안녕하세요, 두프룸프님! 오늘은 Java에서 객체 간의 '타입 변환(Type Casting)'에 대해 자세히 알아볼 거예요.
 * 특히 어제 배운 다형성(Polymorphism)과 밀접한 관련이 있는 '업캐스팅(Upcasting)'과 '다운캐스팅(Downcasting)'을 중심으로 살펴볼 겁니다.
 *
 * 타입 변환은 마치 물건을 담는 상자를 바꾸는 것과 같아요.
 * 작은 상자(자식 타입)에 담긴 물건을 더 큰 상자(부모 타입)에 넣는 것은 쉽고 안전하지만 (업캐스팅),
 * 큰 상자에 담긴 물건을 작은 상자에 넣으려면 그 물건이 정말 작은 상자에 들어갈 수 있는지 확인해야 하죠 (다운캐스팅).
 *
 * 이 예제에서는 다음을 중점적으로 배울 거예요:
 * 1. 클래스 간의 상속 계층 구조를 이해하기
 * 2. 업캐스팅(Upcasting): 언제, 왜 사용하며, 어떤 특징이 있는지
 * 3. 다운캐스팅(Downcasting): 언제 필요하며, 어떤 위험이 있고, 어떻게 안전하게 사용하는지 (`instanceof` 키워드)
 * 4. 상속 관계가 없는 클래스 간에는 타입 변환이 불가능하다는 점
 *
 * 이 개념들을 잘 익히면 Java 객체 지향 프로그래밍을 더욱 유연하고 강력하게 활용할 수 있답니다!
 */

// [1] 클래스 계층 구조 정의: 자동차 가족을 만들어볼까요?
// 최상위 부모 클래스: 모든 자동차의 공통적인 특징을 정의합니다.
class Car {
    String type = "자동차";
    void drive() { System.out.println("자동차가 달립니다."); }
}

// Car를 상속받는 Bus 클래스: 일반 자동차보다 더 많은 승객을 태울 수 있는 버스입니다.
class Bus extends Car {
    String type = "버스";
    @Override // 부모의 drive() 메소드를 버스에 맞게 재정의했어요.
    void drive() { System.out.println("버스가 승객을 싣고 달립니다."); }
    void carryPassengers() { System.out.println("승객을 태웁니다."); }
}

// Bus를 상속받는 SchoolBus 클래스: 학생들을 위한 특별한 버스입니다.
class SchoolBus extends Bus {
    String type = "스쿨버스";
    @Override // 부모의 drive() 메소드를 스쿨버스에 맞게 재정의했어요.
    void    drive() { System.out.println("스쿨버스가 학생들을 태우고 달립니다."); }
    void pickUpStudents() { System.out.println("학생들을 태우러 갑니다."); }
}

// Car를 상속받는 OpenCar 클래스: 지붕을 열 수 있는 자동차입니다.
// 여기서 중요한 점! OpenCar도 Car의 한 종류이므로 Car를 상속받도록 수정했어요.
// 이렇게 해야 나중에 Car 타입으로 OpenCar나 SportsCar를 참조할 수 있답니다.
class OpenCar extends Car {
    String type = "오픈카";
    @Override // 부모의 drive() 메소드를 오픈카에 맞게 재정의했어요.
    void drive() { System.out.println("오픈카가 시원하게 달립니다."); }
    void openRoof() { System.out.println("지붕을 엽니다."); }
}

// OpenCar를 상속받는 SportsCar 클래스: 빠르고 강력한 스포츠카입니다.
class SportsCar extends OpenCar {
    String type = "스포츠카";
    @Override // 부모의 drive() 메소드를 스포츠카에 맞게 재정의했어요.
    void drive() { System.out.println("스포츠카가 빠르게 달립니다."); }
    void boost() { System.out.println("부스터를 사용합니다."); }
}

public class _02_TypeChange {
    public static void main(String[] args) {
        // [2] 업캐스팅(Upcasting): 자식 객체를 부모 타입으로 참조하는 것
        // - 업캐스팅은 항상 '자동으로' 이루어지며 매우 안전합니다. 왜냐하면 자식은 부모의 모든 것을 가지고 있기 때문이죠.
        // - 부모 타입의 참조 변수로는 부모 클래스에 정의된 멤버(필드, 메소드)만 접근할 수 있어요.
        // - 하지만! 오버라이딩된 메소드를 호출하면, 실제 객체(자식)의 메소드가 실행됩니다. (이것이 다형성의 핵심!)

        System.out.println("\n--- 업캐스팅 예시 ---");
        Car c1 = new SchoolBus(); // SchoolBus 객체를 Car 타입으로 참조 (조부모-자식 관계)
        Car b1 = new Bus();       // Bus 객체를 Car 타입으로 참조 (부모-자식 관계)
        Bus b2 = new SchoolBus(); // SchoolBus 객체를 Bus 타입으로 참조 (부모-자식 관계)

        // OpenCar와 SportsCar도 이제 Car를 상속받으므로, 이렇게 업캐스팅이 가능합니다!
        Car c2 = new OpenCar();   // OpenCar 객체를 Car 타입으로 참조
        Car c3 = new SportsCar(); // SportsCar 객체를 Car 타입으로 참조
        OpenCar oc = new SportsCar(); // SportsCar 객체를 OpenCar 타입으로 참조

        c1.drive(); // SchoolBus의 drive() 호출: "스쿨버스가 학생들을 태우고 달립니다."
        b1.drive(); // Bus의 drive() 호출: "버스가 승객을 싣고 달립니다."
        b2.drive(); // SchoolBus의 drive() 호출: "스쿨버스가 학생들을 태우고 달립니다."
        c2.drive(); // OpenCar의 drive() 호출: "오픈카가 시원하게 달립니다."
        c3.drive(); // SportsCar의 drive() 호출: "스포츠카가 빠르게 달립니다."
        oc.drive(); // SportsCar의 drive() 호출: "스포츠카가 빠르게 달립니다."

        System.out.println("\n----------------------------------------\n");

        // [3] 다운캐스팅(Downcasting): 부모 타입으로 참조되던 객체를 다시 자식 타입으로 변환하는 것
        // - 다운캐스팅은 '명시적 형변환'이 필요합니다. `(자식타입)참조변수` 형태로 작성해야 해요.
        // - 런타임에 'ClassCastException'이라는 오류가 발생할 수 있으므로, 항상 'instanceof' 연산자로
        //   실제 객체의 타입을 확인한 후 사용하는 것이 안전합니다. 마치 작은 상자에 물건이 들어갈지 확인하는 것처럼요!

        System.out.println("--- 다운캐스팅 예시 ---");
        Car myCar = new SportsCar(); // SportsCar 객체를 Car 타입으로 업캐스팅
        // myCar.boost(); // 에러 발생! Car 타입에는 boost() 메소드가 없기 때문이에요.
        //                 // 실제 객체는 SportsCar지만, 참조 변수의 타입이 Car라서 접근이 안 됩니다.

        // myCar가 실제로 SportsCar 객체인지 'instanceof'로 확인 후 다운캐스팅을 시도합니다.
        if (myCar instanceof SportsCar) {
            SportsCar mySportsCar = (SportsCar) myCar; // 안전하게 다운캐스팅!
            mySportsCar.boost(); // 이제 SportsCar의 고유 메소드인 boost()를 호출할 수 있어요!
            System.out.println("myCar는 SportsCar 타입이므로 boost() 메소드를 호출했습니다.");
        } else {
            System.out.println("myCar는 SportsCar 타입이 아닙니다.");
        }

        // 또 다른 다운캐스팅 예시: Bus 객체를 Car 타입으로 업캐스팅 후 다시 Bus로 다운캐스팅
        Car someCar = new Bus();
        if (someCar instanceof Bus) {
            Bus someBus = (Bus) someCar; // Car 타입의 someCar를 Bus 타입으로 다운캐스팅
            someBus.carryPassengers(); // Bus의 고유 메소드 호출
            System.out.println("someCar는 Bus 타입이므로 carryPassengers() 메소드를 호출했습니다.");
        } else {
            System.out.println("someCar는 Bus 타입이 아닙니다.");
        }

        System.out.println("\n----------------------------------------\n");

        // [4] 다형성이 불가능한 경우: 상속 관계가 없는 클래스 간의 타입 변환
        // - 다형성은 오직 '상속 계층 구조' 내에서만 가능합니다.
        // - 서로 다른 계층에 있는 클래스(예: Bus와 OpenCar)는 직접적인 타입 변환이 불가능합니다.
        //   컴파일러가 이 관계를 알 수 없기 때문이죠.
        // 아래 주석을 해제하면 'Incompatible types' 컴파일 에러가 발생합니다.
        // Bus b3 = new OpenCar(); // 에러: OpenCar는 Bus의 자식이 아니므로 직접 할당 불가!
        System.out.println("Bus와 OpenCar는 상속 관계가 아니므로 직접적인 타입 변환이 불가능합니다.");

        System.out.println("\n두프룸프님, 타입 변환과 다형성 개념이 이제 좀 더 명확해지셨나요? 이 개념들을 잘 활용하면");
        System.out.println("더욱 유연하고 강력한 객체 지향 프로그램을 만들 수 있답니다!");
    }
}
