/**
 * 두프룸프님, 이번에는 배열을 다룰 때 우리의 코딩을 훨씬 편하게 만들어주는
 * 마법의 도구 상자, 'Arrays 클래스'에 대해 배워볼 거예요.
 * 우리가 직접 for문을 돌려서 구현해야 했던 여러 기능들(정렬, 출력, 비교 등)을
 * Arrays 클래스가 미리 다 만들어놓고 제공해준답니다. 우리는 그냥 가져다 쓰기만 하면 돼요!
 *
 * 그리고 아주 아주 중요한 '배열 복사'의 두 가지 방식,
 * '얕은 복사(Shallow Copy)'와 '깊은 복사(Deep Copy)'의 차이점도 알아볼 거예요.
 * 이 개념을 이해해야 나중에 데이터가 의도치 않게 변하는 무서운 버그를 막을 수 있답니다!
 */
import java.util.Arrays; // 마법 도구 상자를 쓰려면, 먼저 "가져와줘!" 하고 import를 해줘야 해요.

public class _11_Arrays {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 8, 4, 9, 3, 7, 6};

        // [1] Arrays.toString() : 배열을 예쁘게 출력하기
        // 그냥 배열 변수를 출력하면 이상한 글자가 나와요. (ex: [I@1b6d3586)
        // Arrays.toString()을 쓰면 for문 없이도 내용물을 한눈에 볼 수 있게 문자열로 만들어줍니다.
        System.out.println("그냥 출력: " + arr);
        System.out.println("Arrays.toString() 사용: " + Arrays.toString(arr));

        // [2] Arrays.sort() : 배열을 오름차순으로 정렬하기
        // for문을 몇 겹으로 돌면서 복잡하게 로직을 짤 필요 없이, 단 한 줄이면 정렬 끝!
        System.out.println("\n--- 정렬 기능 사용 ---");
        Arrays.sort(arr);
        System.out.println("정렬 후: " + Arrays.toString(arr));

        System.out.println("\n----------------------------------------\n");

        // [3] 얕은 복사 (Shallow Copy) : 주소값 복사
        // 이건 마치 '집 열쇠'만 복사해서 친구에게 주는 것과 같아요.
        // 집은 한 채인데, 열쇠만 두 개가 된 상황이죠.
        System.out.println("--- 얕은 복사 (Shallow Copy) ---");
        int[] original = {10, 20, 30};
        int[] copyKey = original; // original이 가리키는 집의 주소(열쇠)를 copyKey에게도 줌

        System.out.println("복사 직후 original: " + Arrays.toString(original));
        System.out.println("복사 직후 copyKey:  " + Arrays.toString(copyKey));

        // 친구(copyKey)가 1번 방(인덱스 1)의 가구를 99로 바꿔버렸다!
        copyKey[1] = 99;
        System.out.println("\ncopyKey 변경 후 copyKey:  " + Arrays.toString(copyKey));

        // 그러면 어떻게 될까요? 당연히 원래 우리 집(original)의 가구도 바뀌어 있겠죠!
        System.out.println("copyKey 변경 후 original: " + Arrays.toString(original) + " <- original도 바뀌어버림!");

        System.out.println("\n----------------------------------------\n");

        // [4] 깊은 복사 (Deep Copy) : 실제 값 복사
        // 이건 마치 '똑같은 집을 한 채 더 지어서' 친구에게 주는 것과 같아요.
        // 완전히 독립된 두 개의 집이 생긴 거죠.
        System.out.println("--- 깊은 복사 (Deep Copy) ---");
        int[] realOriginal = {10, 20, 30};

        // Arrays.copyOf(원본배열, 복사할길이) : 원본과 똑같은 내용물을 가진 새로운 집(배열)을 지어줍니다.
        int[] newHouse = Arrays.copyOf(realOriginal, realOriginal.length);

        System.out.println("복사 직후 realOriginal: " + Arrays.toString(realOriginal));
        System.out.println("복사 직후 newHouse:     " + Arrays.toString(newHouse));

        // 이번엔 원본 집(realOriginal)의 0번 방 가구를 77로 바꿔볼게요.
        realOriginal[0] = 77;
        System.out.println("\nrealOriginal 변경 후 realOriginal: " + Arrays.toString(realOriginal));

        // 친구네 새 집(newHouse)은 아무런 영향을 받지 않은 것을 볼 수 있습니다!
        System.out.println("realOriginal 변경 후 newHouse:     " + Arrays.toString(newHouse) + " <- newHouse는 그대로!");
    }
}