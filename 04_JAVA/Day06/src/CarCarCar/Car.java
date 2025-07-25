package CarCarCar;

public class Car {
    String carType;
    String carName;
    int carPrice;
    String carColor;

    Car() {}

    Car(String carType, String carName, int carPrice, String carColor) {
        this.carType = carType;
        this.carName = carName;
        this.carPrice = carPrice;
        this.carColor = carColor;
    }

    void car_type_menu (String carType) {
        if(carType.equals("SUV")) {
            System.out.println("SUV 차 브랜드를 선택해주세요.");
            System.out.println("1. Ferrari");
            System.out.println("2. Genesis");
        } else if(carType.equals("스포츠카")) {
            System.out.println("스포츠카 브랜드를 선택해주세요.");
            System.out.println("1. Porsche");
            System.out.println("2. Benz");
        } else {
            System.out.println("SUV, 스포츠카 중 하나를 골라주세요.");
        }
    }

    void car_type_menu_brand_Ferrari () {
        System.out.println("페라리 SUV를 골라주세요. (이름을 정확하게 입력해주세요.)");
        System.out.println("푸로산게");
    }

    void car_type_menu_brand_Genesis () {
        System.out.println("제네시스 SUV를 골라주세요. (이름을 정확하게 입력해주세요.)");
        System.out.println("GV80");
        System.out.println("GV70");
    }

    void car_type_menu_brand_Porsche () {
        System.out.println("포르쉐 스포츠카를 골라주세요. (이름을 정확하게 입력해주세요.)");
        System.out.println("911");
        System.out.println("718");
    }

    void car_type_menu_brand_Benz () {
        System.out.println("벤츠 스포츠카를 골라주세요. (이름을 정확하게 입력해주세요.)");
        System.out.println("AMG GT");
        System.out.println("AMG GT R 프로");
    }

    void car_introduce() {
        System.out.printf("%n%n=============> 최종 견적 <=============%n");
        System.out.printf("차종 : %s%n", this.carType);
        System.out.printf("차 모델 : %s%n", this.carName);
        System.out.printf("차 가격 : %d%n", this.carPrice);
        System.out.printf("차 색상 : %s%n", this.carColor);
    }
}
