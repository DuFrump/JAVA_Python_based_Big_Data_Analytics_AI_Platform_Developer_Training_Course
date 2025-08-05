package _04_TypeChange_bike;

public class Main {
    public static void main(String[] args) {
        // b1은 Bike이면서 FourWheelBike를 참조 (다형성)
        Bike b1 = new FourWheelBike("김무개");

        b1.info();
        b1.ride();
//        b1.addWheel(); <---------- 자식 클래스 고유 메서드이기 때문에 가져올 수 없음.

        System.out.println("------------------------");

        FourWheelBike fwb1 = (FourWheelBike) b1;

        fwb1.addWheel();
        fwb1.info();
        fwb1.ride();

        /**
         * 모든 부모 타입 객체를 자식 타입으로 변환 할 수 있는 것은 아니다!!
         * 부모 타입 객체가 실제로 자식 타입 객체일 때만 강제 변환이 가능하다!!
         *
         * 즉, 부모 타입으로 반환된 객체가 실제로 자식 클래스의 객체라면 자식 타입으로 강제 변환할 수 있지만,
         * 그렇지 않으면 ClassCastException이 발생한다!!
         */
    }
}
