/**
 * Java 선생님:
 * 두프룸프님, 오늘은 컬렉션의 핵심 개념인 '제네릭(Generics)'에 대해 배워볼 거예요.
 * 제네릭은 '데이터 타입을 나중에 지정하는' 기능이라고 생각하면 쉬워요.
 *
 * 마치 우리가 음료수 가게에서 "어떤 음료든 담을 수 있는 컵"을 먼저 만들고,
 * 손님이 주문하면 그 컵에 콜라를 담거나, 사이다를 담거나, 주스를 담는 것과 같아요.
 * 여기서 '컵'이 제네릭 클래스나 메서드이고, '콜라', '사이다', '주스'가 실제 데이터 타입(Integer, Double, String 등)이 되는 거죠.
 *
 * 제네릭을 사용하면,
 * 1. 컴파일 시 타입 체크: 잘못된 타입의 데이터가 들어오는 것을 미리 방지할 수 있어요. (타입 안정성)
 * 2. 코드 중복 감소: 타입별로 똑같은 코드를 여러 번 작성할 필요가 없어져요.
 *
 * 아래 예제를 통해 제네릭이 왜 필요한지, 어떻게 사용하는지 직접 확인해 봅시다!
 */
public class _00_Generics {
    public static void main(String[] args) {
        // 다양한 타입의 배열들을 준비했어요.
        Integer[] iArray = {1, 2, 3, 4, 5};
        Double[] dArray = {1.0, 2.0, 3.0, 4.0, 5.0};
        String[] sArray = {"A", "B", "C", "D", "E"};

        System.out.println("--- 제네릭을 사용하지 않았을 때 ---");
        // 만약 제네릭이 없다면, 각 데이터 타입별로 출력 메서드를 따로 만들어야 해요.
        // printIntegerArray, printDoubleArray, printStringArray 처럼요.
        // 기능은 똑같은데 타입만 다르다고 메서드를 3개나 만드는 건 비효율적이죠?
        printIntegerArray(iArray);
        printDoubleArray(dArray);
        printStringArray(sArray);

        System.out.println("\n--- 제네릭 메서드를 사용했을 때 ---");
        // 제네릭을 사용하면, 어떤 타입의 배열이든 처리할 수 있는 '만능' 메서드 하나만 있으면 돼요.
        // printAnyArray 메서드 하나로 Integer, Double, String 배열을 모두 출력할 수 있죠.
        // 훨씬 깔끔하고 효율적이지 않나요?
        printAnyArray(iArray);
        printAnyArray(dArray);
        printAnyArray(sArray);
    }

    /**
     * Java 선생님:
     * 자, 여기가 바로 제네릭 메서드의 핵심입니다!
     *
     * private static <T> void printAnyArray(T[] array)
     *
     * 1. <T>: "이제부터 이 메서드 안에서 'T'라는 이름으로 타입을 다룰 겁니다" 라고 선언하는 부분이에요.
     *          T는 Type의 약자로, 보통 관례적으로 사용해요. E(Element), K(Key), V(Value) 등 다른 문자를 써도 괜찮아요.
     *
     * 2. T[] array: "메서드의 파라미터로 'T' 타입의 배열을 받을 겁니다" 라는 뜻이에요.
     *              만약 iArray(Integer 배열)가 들어오면 T는 Integer가 되고,
     *              dArray(Double 배열)가 들어오면 T는 Double이 되는 거죠.
     *
     * 3. for (T t : array): "배열(array) 안에 있는 각 요소를 't'라는 변수에 담아서 사용할 건데, 이 t의 타입은 T입니다" 라는 의미예요.
     *
     * 이렇게 제네릭을 사용하면, 메서드를 호출하는 시점에 실제 타입이 결정되기 때문에
     * 어떤 타입의 배열이 들어와도 유연하게 처리할 수 있는 만능 메서드가 탄생하는 거랍니다!
     */
    private static <T> void printAnyArray(T[] array) {
        for (T t : array) { // 배열의 각 요소를 순회합니다. t의 타입은 메서드가 호출될 때 결정돼요.
            System.out.print(t + " ");
        }
        System.out.println();
    }

    // --- 아래는 제네릭을 사용하지 않은 경우의 코드들입니다. ---
    // 기능은 동일하지만, 각 타입별로 메서드가 따로 존재해야 하는 불편함이 있죠.

    private static void printStringArray(String[] sArray) {
        for (String s : sArray) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    private static void printIntegerArray(Integer[] iArray) {
        for (Integer i : iArray) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void printDoubleArray(Double[] dArray) {
        for (Double d : dArray) {
            System.out.print(d + " ");
        }
        System.out.println();
    }
}