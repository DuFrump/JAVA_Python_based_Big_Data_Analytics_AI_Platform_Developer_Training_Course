package CarCarCar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Car myCar = new Car();

        System.out.print("원하시는 차종을 입력해 주세요. (SUV/스포츠카) : ");
        String car_type = sc.next();

        myCar.car_type_menu(car_type);
        int car_brand = sc.nextInt();

        if (car_type.equals("SUV") && car_brand == 1) {
            myCar.car_type_menu_brand_Ferrari ();
        } else if (car_type.equals("SUV") && car_brand == 2) {
            myCar.car_type_menu_brand_Genesis ();
        } else if (car_type.equals("스포츠카") && car_brand == 1) {
            myCar.car_type_menu_brand_Porsche ();
        } else if (car_type.equals("스포츠카") && car_brand == 2) {
            myCar.car_type_menu_brand_Benz ();
        } else {
            System.out.println("ERROR: !!다시 실행해주세요!!");
        }
        String car_name = sc.next();

        System.out.print("차 색상을 알려주세요. : ");
        String car_color = sc.next();

        int car_price = 0;

        if(car_name.equals("푸로산게")) {
            car_price += 570000000;
        } else if(car_name.equals("GV80")) {
            car_price += 80000000;
        } else if(car_name.equals("GV70")) {
            car_price += 65000000;
        } else if(car_name.equals("911")) {
            car_price += 210000000;
        } else if(car_name.equals("718")) {
            car_price += 190000000;
        } else if(car_name.equals("AMG GT")) {
            car_price += 150000000;
        } else if(car_name.equals("AMG GT R 프로")) {
            car_price += 211000000;
        } else {
            System.out.println("ERROR: !!다시 실행해주세요!!");
        }

        Car myRealCar = new Car(car_type, car_name, car_price, car_color);

        myRealCar.car_introduce();
    }
}
