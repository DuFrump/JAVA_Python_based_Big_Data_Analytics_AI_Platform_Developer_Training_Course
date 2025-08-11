package CarCarCar;

/**
 * 두프룸프님, 이번에는 '자동차'라는 개념을 코드로 표현하는 방법을 배워볼게요.
 * 우리가 '자동차'하면 떠오르는 특징들(종류, 이름, 가격, 색상 등)이 있죠?
 * 이런 특징들을 '속성(field)'이라고 부르고, 자동차가 할 수 있는 행동들(메뉴 보여주기, 자기소개하기 등)을
 * '메서드(method)'라고 불러요.
 *
 * 이 `Car.java` 파일은 바로 그 '자동차'의 설계도(클래스) 역할을 하는 곳이에요.
 * 이 설계도만 잘 만들어두면, 나중에 `Main.java`에서 이 설계도를 가지고
 * 실제 자동차 객체를 만들어서 사용할 수 있게 된답니다.
 */
public class Car {
    // 1. 자동차의 속성 (멤버 변수 또는 필드)
    // 자동차가 어떤 데이터들로 구성될지 정의하는 부분이에요.
    String carType;  // 차종 (예: "SUV", "스포츠카")
    String carName;  // 자동차 모델명 (예: "GV80", "911")
    int carPrice;    // 가격
    String carColor; // 색상

    // 2. 생성자 (Constructor)
    // '생성자'는 자동차 객체를 처음 만들 때 호출되는 특별한 메서드예요.
    // 주로 객체의 초기값을 설정하는 역할을 하죠.

    /**
     * 기본 생성자 (매개변수 없음)
     * `new Car()` 이렇게 호출하면 이 생성자가 실행돼요.
     * 지금은 아무런 동작도 하지 않지만, 필요에 따라 초기화 코드를 넣을 수 있어요.
     */
    Car() {}

    /**
     * 매개변수가 있는 생성자
     * 자동차를 만들 때 필요한 모든 정보를 받아서 한 번에 초기화해줘요.
     * `new Car("SUV", "GV80", 80000000, "검정색")` 처럼 사용하죠.
     *
     * 'this' 키워드는 '이 객체 자신의' 라는 뜻이에요.
     * `this.carType`은 이 객체의 carType 속성을 의미하고,
     * 오른쪽에 있는 `carType`은 생성자를 통해 전달받은 매개변수 값을 의미해요.
     */
    Car(String carType, String carName, int carPrice, String carColor) {
        this.carType = carType;
        this.carName = carName;
        this.carPrice = carPrice;
        this.carColor = carColor;
    }

    // 3. 자동차의 기능 (메서드)
    // 자동차 객체가 수행할 수 있는 동작들을 정의하는 부분이에요.

    /**
     * 선택한 차종에 맞는 브랜드 메뉴를 보여주는 메서드
     * @param carType 사용자가 입력한 차종 ("SUV" 또는 "스포츠카")
     */
    void showBrandMenu(String carType) {
        if (carType.equals("SUV")) {
            System.out.println("--- SUV 브랜드를 선택해주세요 ---");
            System.out.println("1. Ferrari");
            System.out.println("2. Genesis");
        } else if (carType.equals("스포츠카")) {
            System.out.println("--- 스포츠카 브랜드를 선택해주세요 ---");
            System.out.println("1. Porsche");
            System.out.println("2. Benz");
        } else {
            // .equals()는 문자열 내용을 비교하는 메서드예요. '=='와는 다르니 주의!
            System.out.println("앗! SUV 또는 스포츠카 중에서만 선택해주세요.");
        }
    }

    // 각 브랜드별 차량 모델을 보여주는 메서드들
    // 나중에는 이 부분도 더 효율적으로 개선할 수 있는 방법이 있답니다!
    void showFerrariModels() {
        System.out.println("--- 페라리 SUV 모델을 선택해주세요 (이름을 정확하게 입력!) ---");
        System.out.println("- 푸로산게");
    }

    void showGenesisModels() {
        System.out.println("--- 제네시스 SUV 모델을 선택해주세요 (이름을 정확하게 입력!) ---");
        System.out.println("- GV80");
        System.out.println("- GV70");
    }

    void showPorscheModels() {
        System.out.println("--- 포르쉐 스포츠카 모델을 선택해주세요 (이름을 정확하게 입력!) ---");
        System.out.println("- 911");
        System.out.println("- 718");
    }

    void showBenzModels() {
        System.out.println("--- 벤츠 스포츠카 모델을 선택해주세요 (이름을 정확하게 입력!) ---");
        System.out.println("- AMG GT");
        System.out.println("- AMG GT R 프로");
    }

    /**
     * 최종적으로 선택된 자동차의 정보를 예쁘게 출력해주는 메서드
     */
    void introduce() {
        // printf를 사용하면 %s (문자열), %d (정수) 같은 서식 지정자로
        // 변수 값을 깔끔하게 출력할 수 있어요. %n은 줄바꿈을 의미해요.
        System.out.printf("%n%n=============> 최종 견적 <=============%n");
        System.out.printf("차종 : %s%n", this.carType);
        System.out.printf("차 모델 : %s%n", this.carName);
        System.out.printf("차 가격 : %,d원%n", this.carPrice); // %,d는 숫자에 3자리마다 콤마를 찍어줘요.
        System.out.printf("차 색상 : %s%n", this.carColor);
        System.out.println("========================================");
    }
}