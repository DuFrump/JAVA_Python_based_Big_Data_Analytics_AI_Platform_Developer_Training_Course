package _04_TypeChange_bike;

// Main 클래스는 Bike와 FourWheelBike 클래스를 사용하여 객체를 생성하고
// 다형성(Polymorphism)과 다운캐스팅(Downcasting)의 동작을 확인하는 예제입니다.
public class Main {
    public static void main(String[] args) {
        // [1] 다형성: 부모 클래스 타입으로 자식 클래스 객체 참조
        // `Bike b1 = new FourWheelBike("김무개");`
        // - b1은 Bike 타입이지만, 실제 참조하는 객체는 FourWheelBike 타입입니다.
        // - b1을 통해서는 Bike 클래스에 정의된 멤버만 접근할 수 있습니다.
        // - 하지만 메소드를 호출할 경우, 실제 객체(FourWheelBike)에 오버라이딩된 메소드가 호출됩니다.
        Bike b1 = new FourWheelBike("김무개");

        System.out.println("--- Bike 타입으로 FourWheelBike 객체 참조 ---");
        b1.info(); // FourWheelBike는 info()를 오버라이딩하지 않았으므로 Bike의 info() 호출
        b1.ride(); // Bike의 ride() 호출

        // [중요] 자식 클래스 고유의 메소드에는 부모 타입의 참조 변수로 접근할 수 없습니다.
        // 아래 주석을 해제하면 컴파일 에러가 발생합니다.
        // b1.addWheel(); // 에러: cannot find symbol (Bike 클래스에는 addWheel() 메소드가 없음)
        System.out.println("b1.addWheel()은 컴파일 에러 발생 (자식 고유 메소드 접근 불가)");

        System.out.println("
----------------------------------------
");

        // [2] 다운캐스팅(Downcasting): 부모 타입으로 참조되던 객체를 다시 자식 타입으로 변환
        // - 명시적 형변환이 필요합니다: `(자식타입)참조변수`
        // - `instanceof` 연산자로 안전하게 형변환 가능한지 확인 후 사용해야 런타임 오류를 방지할 수 있습니다.

        // b1은 실제 FourWheelBike 객체이므로, FourWheelBike 타입으로 다운캐스팅이 가능합니다.
        if (b1 instanceof FourWheelBike) { // b1이 FourWheelBike 타입의 인스턴스인지 확인
            FourWheelBike fwb1 = (FourWheelBike) b1; // 다운캐스팅

            System.out.println("--- 다운캐스팅 후 FourWheelBike 객체 사용 ---");
            fwb1.addWheel(); // 이제 FourWheelBike 고유의 addWheel() 호출 가능
            fwb1.info();     // FourWheelBike는 info()를 오버라이딩하지 않았으므로 Bike의 info() 호출
            fwb1.ride();     // Bike의 ride() 호출
        }

        /**
         * [중요] 모든 부모 타입 객체를 자식 타입으로 변환할 수 있는 것은 아닙니다!
         * 부모 타입 객체가 실제로 자식 타입 객체일 때만 강제 변환(다운캐스팅)이 가능합니다.
         *
         * 즉, 부모 타입으로 참조된 객체가 실제로 자식 클래스의 객체라면 자식 타입으로 강제 변환할 수 있지만,
         * 그렇지 않으면 `ClassCastException` (런타임 오류)이 발생합니다.
         *
         * 예시: `Bike bike = new Bike("일반 라이더");`
         *       `FourWheelBike fwb = (FourWheelBike) bike;` // 이 경우 ClassCastException 발생!
         *       (bike는 실제 Bike 객체이지 FourWheelBike 객체가 아니기 때문)
         */
    }
}
