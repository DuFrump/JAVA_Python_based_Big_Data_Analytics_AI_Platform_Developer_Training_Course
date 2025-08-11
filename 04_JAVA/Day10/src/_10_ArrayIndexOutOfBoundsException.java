/**
 * 두프룸프님을 위한 주석 가이드:
 * 이 코드는 'ArrayIndexOutOfBoundsException (배열 인덱스 범위 초과 예외)'을 보여줍니다.
 * 이 예외는 배열의 유효한 인덱스 범위를 벗어난 위치에 접근하려고 할 때 발생합니다.
 *
 * [ArrayIndexOutOfBoundsException이란?]
 * 자바에서 배열은 생성될 때 정해진 크기를 가집니다.
 * 그리고 배열의 요소에 접근할 때는 '인덱스(index)'라는 번호를 사용하는데,
 * 이 인덱스는 항상 0부터 시작하여 '배열의 길이 - 1'까지가 유효한 범위입니다.
 * 이 범위를 벗어난 인덱스로 접근하려고 하면 이 예외가 발생합니다.
 *
 * [비유]
 * '아파트 동 호수'에 비유할 수 있습니다.
 * 101호부터 105호까지 총 5개의 호실이 있는 아파트가 있다고 가정해 봅시다.
 * (배열의 길이가 5인 경우, 인덱스는 0부터 4까지입니다.)
 * 그런데 누군가 106호(인덱스 5)를 찾아가려고 한다면,
 * "그런 호수는 존재하지 않습니다!"라는 오류가 발생하겠죠?
 * ArrayIndexOutOfBoundsException이 바로 이런 상황입니다.
 */
public class _10_ArrayIndexOutOfBoundsException {
    public static void main(String[] args) {
        // 1. 정수형 배열 'arr'을 선언하고 초기화합니다.
        //    이 배열은 5개의 요소를 가지고 있습니다: {1, 6, 7, 9, 10}
        //    배열의 길이는 5입니다. (arr.length = 5)
        //    유효한 인덱스 범위는 0부터 (길이-1)인 4까지입니다.
        //    즉, arr[0], arr[1], arr[2], arr[3], arr[4]만 유효합니다.
        int[] arr = {1, 6, 7, 9, 10};

        // 2. 이제 문제가 발생할 부분입니다.
        //    arr[5]는 배열의 유효한 인덱스 범위(0~4)를 벗어난 위치입니다.
        //    배열은 0부터 시작하므로, 5번째 인덱스는 실제로는 6번째 요소를 의미하며,
        //    이 배열에는 6번째 요소가 존재하지 않습니다.
        //    따라서 이 줄에서 'ArrayIndexOutOfBoundsException'이 발생하며 프로그램이 비정상 종료됩니다.
        System.out.println(arr[5]); // 여기서 ArrayIndexOutOfBoundsException 발생!

        // [ArrayIndexOutOfBoundsException을 피하는 방법]
        // 1. 배열의 길이를 항상 확인하여 유효한 인덱스 범위 내에서 접근해야 합니다.
        //    예시:
        //    for (int i = 0; i < arr.length; i++) { // i는 0부터 arr.length-1까지 반복
        //        System.out.println(arr[i]);
        //    }

        // 2. 향상된 for 문(Enhanced For Loop)을 사용하면 인덱스를 직접 다룰 필요가 없어
        //    이런 종류의 예외를 방지할 수 있습니다.
        //    예시:
        //    for (int value : arr) {
        //        System.out.println(value);
        //    }
    }
}