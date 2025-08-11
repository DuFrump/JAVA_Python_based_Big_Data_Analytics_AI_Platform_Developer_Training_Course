package CarCarCar;

// Scanner, Map, HashMap 클래스를 사용하기 위해 import 해줍니다.
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 두프룸프님, 여기가 바로 프로그램이 시작되는 `main` 메서드가 있는 곳이에요!
 * `Car.java`라는 자동차 설계도를 만들었으니, 이제 그 설계도를 가지고
 * 진짜 자동차 객체를 만들어서 조립하고, 사용자로부터 정보를 입력받는 등
 * 실제 프로그램의 흐름을 만드는 역할을 하는 파일입니다.
 *
 * 여기서 배울 핵심 개념은
 * 1. `Scanner`를 이용한 사용자 입력 처리
 * 2. `Car` 클래스의 객체(인스턴스) 생성 및 활용
 * 3. `if-else` 조건문을 이용한 흐름 제어
 * 4. `Map`을 이용한 데이터 관리 (차량 모델명과 가격을 짝지어 저장)
 * 입니다. 천천히 코드를 따라가며 어떻게 프로그램이 동작하는지 살펴봐요!
 */
public class Main {
    public static void main(String[] args) {
        // 1. 사용자 입력을 받기 위한 Scanner 객체 생성
        // System.in은 키보드 입력을 의미해요.
        Scanner sc = new Scanner(System.in);

        // 2. Car 객체 생성
        // Car.java 설계도를 바탕으로 첫 번째 자동차 객체를 만듭니다.
        // 이 객체는 주로 메뉴를 보여주는 용도로 사용할 거예요.
        Car carForMenu = new Car();

        // 3. 사용자로부터 차종 입력받기
        System.out.print("원하시는 차종을 입력해 주세요. (SUV/스포츠카) : ");
        String carType = sc.next(); // 사용자가 입력한 문자열을 carType 변수에 저장

        // 4. 입력받은 차종에 맞는 브랜드 메뉴 보여주기
        // carForMenu 객체의 showBrandMenu 메서드를 호출합니다.
        carForMenu.showBrandMenu(carType);

        // 사용자가 1 또는 2를 입력할 것을 기대하고 입력을 받습니다.
        System.out.print("원하시는 브랜드의 번호를 입력해주세요: ");
        int brandChoice = sc.nextInt();

        // 5. 사용자의 선택에 따라 차량 모델 목록 보여주기
        // if-else 문을 통해 사용자가 선택한 차종과 브랜드에 따라 각기 다른 메서드를 호출해요.
        if (carType.equals("SUV")) {
            if (brandChoice == 1) {
                carForMenu.showFerrariModels();
            } else if (brandChoice == 2) {
                carForMenu.showGenesisModels();
            } else {
                System.out.println("ERROR: !!잘못된 브랜드 번호입니다. 다시 실행해주세요!!");
                return; // 프로그램을 즉시 종료합니다.
            }
        } else if (carType.equals("스포츠카")) {
            if (brandChoice == 1) {
                carForMenu.showPorscheModels();
            } else if (brandChoice == 2) {
                carForMenu.showBenzModels();
            } else {
                System.out.println("ERROR: !!잘못된 브랜드 번호입니다. 다시 실행해주세요!!");
                return;
            }
        } else {
            // 처음에 차종을 잘못 입력한 경우
            System.out.println("ERROR: !!차종을 잘못 입력하셨습니다. 다시 실행해주세요!!");
            return;
        }

        // 6. 사용자로부터 차량 모델명과 색상 입력받기
        System.out.print("원하시는 차량 모델의 이름을 정확히 입력해주세요: ");
        String carName = sc.next();

        System.out.print("원하시는 차량의 색상을 입력해주세요: ");
        String carColor = sc.next();

        // 7. 차량 모델명에 따른 가격 정보 설정하기 (Map 활용)
        // Map은 'Key-Value' 쌍으로 데이터를 저장하는 자료구조예요.
        // 여기서는 차량 이름(String)을 Key로, 가격(Integer)을 Value로 사용해서
        // 특정 모델의 가격을 쉽게 찾아올 수 있도록 했어요.
        Map<String, Integer> carPrices = new HashMap<>();
        carPrices.put("푸로산게", 570000000);
        carPrices.put("GV80", 80000000);
        carPrices.put("GV70", 65000000);
        carPrices.put("911", 210000000);
        carPrices.put("718", 190000000);
        carPrices.put("AMG GT", 150000000);
        carPrices.put("AMG GT R 프로", 211000000);

        // 사용자가 입력한 carName을 Key로 해서 Map에서 가격(Value)을 찾아옵니다.
        // getOrDefault는 Key에 해당하는 값이 있으면 그 값을, 없으면 기본값(여기서는 0)을 반환해요.
        int carPrice = carPrices.getOrDefault(carName, 0);

        // 만약 carPrice가 0이라면, 사용자가 모델명을 잘못 입력했다는 뜻이겠죠?
        if (carPrice == 0) {
            System.out.println("ERROR: !!모델명을 잘못 입력하셨습니다. 다시 실행해주세요!!");
            return;
        }

        // 8. 최종 자동차 객체 생성 및 정보 출력
        // 지금까지 사용자로부터 입력받은 모든 정보(차종, 이름, 가격, 색상)를 가지고
        // `Car`의 매개변수 있는 생성자를 호출하여 완벽한 자동차 객체를 만듭니다.
        Car myFinalCar = new Car(carType, carName, carPrice, carColor);

        // 완성된 자동차 객체의 introduce 메서드를 호출하여 최종 견적을 보여줍니다.
        myFinalCar.introduce();

        // 스캐너 사용이 끝났으면 닫아주는 것이 좋아요.
        sc.close();
    }
}