// 객체 간의 타입 변환(Type Casting)과 다형성(Polymorphism)의 관계를 배우는 예제입니다.
// 특히 업캐스팅(Upcasting)과 다운캐스팅(Downcasting)의 가능 여부를 보여줍니다.

// [1] 클래스 계층 구조 정의
// 최상위 부모 클래스
class Car {
    String type = "자동차";
    void drive() { System.out.println("자동차가 달립니다."); }
}

// Car를 상속받는 Bus 클래스
class Bus extends Car {
    String type = "버스";
    @Override
    void drive() { System.out.println("버스가 승객을 싣고 달립니다."); }
    void carryPassengers() { System.out.println("승객을 태웁니다."); }
}

// Bus를 상속받는 SchoolBus 클래스
class SchoolBus extends Bus {
    String type = "스쿨버스";
    @Override
    void drive() { System.out.println("스쿨버스가 학생들을 태우고 달립니다."); }
    void pickUpStudents() { System.out.println("학생들을 태우러 갑니다."); }
}

// Car를 상속받는 OpenCar 클래스
class OpenCar {
    String type = "오픈카";
    void drive() { System.out.println("오픈카가 시원하게 달립니다."); }
    void openRoof() { System.out.println("지붕을 엽니다."); }
}

// OpenCar를 상속받는 SportsCar 클래스
class SportsCar extends OpenCar {
    String type = "스포츠카";
    @Override
    void drive() { System.out.println("스포츠카가 빠르게 달립니다."); }
    void boost() { System.out.println("부스터를 사용합니다."); }
}

public class _02_TypeChange {
    public static void main(String[] args) {
        // [2] 업캐스팅(Upcasting): 자식 객체를 부모 타입으로 참조하는 것 (자동으로 이루어짐)
        // - 항상 가능하며 안전합니다.
        // - 부모 타입의 참조 변수로는 부모 클래스에 정의된 멤버만 접근할 수 있습니다.
        // - 하지만 오버라이딩된 메소드는 실제 객체의 메소드가 호출됩니다.

        System.out.println("--- 업캐스팅 예시 ---");
        Car c1 = new SchoolBus(); // SchoolBus 객체를 Car 타입으로 참조 (조부모-자식)
        Car b1 = new Bus();       // Bus 객체를 Car 타입으로 참조 (부모-자식)
        Bus b2 = new SchoolBus(); // SchoolBus 객체를 Bus 타입으로 참조 (부모-자식)

        // Car c2 = new OpenCar();   // OpenCar 객체를 Car 타입으로 참조
        // Car c3 = new SportsCar(); // SportsCar 객체를 Car 타입으로 참조
        OpenCar oc = new SportsCar(); // SportsCar 객체를 OpenCar 타입으로 참조

        c1.drive(); // SchoolBus의 drive() 호출
        b1.drive(); // Bus의 drive() 호출
        b2.drive(); // SchoolBus의 drive() 호출
        // c3.drive(); // SportsCar의 drive() 호출

        System.out.println("
----------------------------------------
");

        // [3] 다운캐스팅(Downcasting): 부모 타입으로 참조되던 객체를 다시 자식 타입으로 변환하는 것
        // - 명시적 형변환이 필요합니다. `(자식타입)참조변수`
        // - 런타임 오류(ClassCastException)가 발생할 수 있으므로 `instanceof`로 확인 후 사용해야 안전합니다.

        System.out.println("--- 다운캐스팅 예시 ---");
        Car myCar = new SportsCar(); // SportsCar 객체를 Car 타입으로 업캐스팅
        // myCar.boost(); // 에러: Car 타입에는 boost() 메소드가 없음

        // myCar가 실제로 SportsCar 객체인지 확인 후 다운캐스팅
        if (myCar instanceof SportsCar) {
            SportsCar mySportsCar = (SportsCar) myCar; // 다운캐스팅
            mySportsCar.boost(); // 이제 SportsCar의 고유 메소드 호출 가능
        }

        System.out.println("
----------------------------------------
");

        // [4] 다형성이 불가능한 경우: 상속 관계가 없는 클래스 간의 타입 변환
        // - 다형성은 상속 계층 구조 내에서만 가능합니다.
        // - 서로 다른 계층에 있는 클래스(예: Bus와 OpenCar)는 직접적인 타입 변환이 불가능합니다.
        // 아래 주석을 해제하면 컴파일 에러가 발생합니다.
        // Bus b3 = new OpenCar(); // 에러: Incompatible types
        System.out.println("Bus와 OpenCar는 상속 관계가 아니므로 직접적인 타입 변환이 불가능합니다.");
    }
}
