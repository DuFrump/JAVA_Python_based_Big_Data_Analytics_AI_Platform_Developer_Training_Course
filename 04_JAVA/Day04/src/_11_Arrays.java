// `java.util.Arrays` 클래스의 유용한 메소드와 배열 복사 시 주의할 점을 배우는 예제입니다.
// `Arrays` 클래스는 배열을 다루는 데 유용한 정적(static) 메소드들을 제공합니다.

import java.util.Arrays; // Arrays 클래스를 사용하기 위해 import 합니다.

public class _11_Arrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 7, 9, 8, 4, 6, 3};

        // [1] `Arrays.toString()`: 배열의 모든 요소를 문자열 형태로 반환합니다.
        // 배열의 내용을 쉽게 확인하는 데 유용합니다.
        System.out.println("원본 배열: " + Arrays.toString(arr));

        // [2] `Arrays.sort()`: 배열의 요소를 오름차순으로 정렬합니다.
        Arrays.sort(arr);
        System.out.println("정렬된 배열: " + Arrays.toString(arr));

        System.out.println("
----------------------------------------
");

        // [3] 배열 복사 시 주의할 점: 참조 복사 (얕은 복사)
        // 배열은 참조 타입이므로, 단순히 `=` 연산자로 복사하면 같은 배열 객체를 가리키게 됩니다.
        // 즉, 한 쪽 배열의 내용을 변경하면 다른 쪽 배열의 내용도 함께 변경됩니다.
        int[] arr01 = {1, 2, 3};
        int[] arr02 = arr01; // arr02는 arr01이 가리키는 배열 객체와 동일한 객체를 가리키게 됩니다.

        arr02[1] = 10; // arr02의 두 번째 요소 변경

        System.out.println("arr01 (참조 복사 후): " + Arrays.toString(arr01)); // arr01도 변경됨: [1, 10, 3]
        System.out.println("arr02 (참조 복사 후): " + Arrays.toString(arr02)); // arr02: [1, 10, 3]

        System.out.println("
----------------------------------------
");

        // [4] 배열 복사 시 주의할 점: 값 복사 (깊은 복사)
        // `Arrays.copyOf()`: 배열의 내용을 새로운 배열로 복사합니다.
        // 원본 배열의 변경이 복사된 배열에 영향을 주지 않습니다.
        int[] arr03 = {1, 2, 3};
        // arr03의 모든 요소를 새로운 배열 arr04에 복사합니다.
        int[] arr04 = Arrays.copyOf(arr03, arr03.length);

        arr03[2] = 10; // arr03의 세 번째 요소 변경

        System.out.println("arr03 (값 복사 후): " + Arrays.toString(arr03)); // arr03만 변경됨: [1, 2, 10]
        System.out.println("arr04 (값 복사 후): " + Arrays.toString(arr04)); // arr04는 변경되지 않음: [1, 2, 3]
    }
}
