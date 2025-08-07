// 변수의 값을 서로 교환(swap)하는 방법을 배우는 예제입니다.

public class _03_Variable2 {
    public static void main(String[] args) {
        // 두 개의 정수 변수를 선언하고 초기화합니다.
        int myAge = 20;
        int yourAge = 30;

        // 값을 임시로 저장할 변수를 선언합니다.
        int tempAge; // ourAge -> tempAge 로 변수명 변경 (의미를 더 명확하게)

        System.out.println("--- 값 교환 전 ---");
        System.out.println("myAge: " + myAge);   // 출력: 20
        System.out.println("yourAge: " + yourAge); // 출력: 30
        System.out.println();

        // 두 변수의 값을 바꾸는 과정 (Swap Logic)
        // 1. myAge의 값을 임시 변수 tempAge에 저장합니다.
        //    (tempAge: 20, myAge: 20, yourAge: 30)
        tempAge = myAge;

        // 2. yourAge의 값을 myAge에 저장합니다. (기존 myAge의 값 20은 사라집니다)
        //    (tempAge: 20, myAge: 30, yourAge: 30)
        myAge = yourAge;

        // 3. 임시 변수 tempAge에 저장해두었던 원래 myAge의 값을 yourAge에 저장합니다.
        //    (tempAge: 20, myAge: 30, yourAge: 20)
        yourAge = tempAge;

        System.out.println("--- 값 교환 후 ---");
        System.out.println("myAge: " + myAge);   // 출력: 30
        System.out.println("yourAge: " + yourAge); // 출력: 20
    }
}
