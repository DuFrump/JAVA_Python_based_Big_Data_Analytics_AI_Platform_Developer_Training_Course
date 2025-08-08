/**
 * 변수에 저장된 값을 서로 교환(swap)하는 방법을 배웁니다.
 * 두 개의 컵에 담긴 음료를 서로 바꾸는 상황을 생각하면 쉽습니다.
 * 내용물을 잠시 다른 곳에 옮겨 담을 빈 컵이 하나 더 필요한 것과 같습니다.
 */
public class _03_Variable2 {
    public static void main(String[] args) {

        // --------------- 변수 값 교환 (Swap) ---------------

        // 두 개의 정수 변수를 선언하고 동시에 초기화합니다.
        int myAge = 20;     // 내 나이를 저장하는 컵
        int yourAge = 30;   // 친구 나이를 저장하는 컵

        // 값을 임시로 저장할 변수를 선언합니다.
        // 두 컵의 내용물을 바꾸려면, 잠시 한쪽의 내용물을 담아둘 빈 컵이 필요합니다.
        // 이 'tempAge'가 바로 그 "빈 컵" 역할을 합니다.
        int tempAge; // temp는 temporary(임시의)의 줄임말입니다.

        System.out.println("--- 값 교환 전 ---");
        System.out.println("myAge 컵: " + myAge);   // 출력: 20
        System.out.println("yourAge 컵: " + yourAge); // 출력: 30
        System.out.println();

        // *** 두 변수의 값을 바꾸는 핵심 로직 (Swap Logic) ***
        // 비유: 콜라가 든 컵(myAge)과 사이다가 든 컵(yourAge)을 바꾸기

        // 1. myAge의 값(20)을 임시 변수 tempAge에 백업합니다.
        //    (tempAge: 20, myAge: 20, yourAge: 30)
        //    비유: 콜라(myAge)를 빈 컵(tempAge)에 잠시 부어둡니다.
        tempAge = myAge;

        // 2. yourAge의 값(30)을 myAge에 저장합니다.
        //    이때, myAge에 원래 있던 값 20은 30으로 덮어쓰여 사라집니다. (그래서 백업이 중요!)
        //    (tempAge: 20, myAge: 30, yourAge: 30)
        //    비유: 이제 비어있는 콜라 컵(myAge)에 사이다(yourAge)를 붓습니다.
        myAge = yourAge;

        // 3. 임시 변수 tempAge에 저장해두었던 원래 myAge의 값(20)을 yourAge에 저장합니다.
        //    (tempAge: 20, myAge: 30, yourAge: 20)
        //    비유: 빈 사이다 컵(yourAge)에 아까 빈 컵(tempAge)에 담아뒀던 콜라를 붓습니다.
        yourAge = tempAge;

        System.out.println("--- 값 교환 후 ---");
        System.out.println("myAge 컵: " + myAge);   // 출력: 30 (사이다가 담김)
        System.out.println("yourAge 컵: " + yourAge); // 출력: 20 (콜라가 담김)
    }
}