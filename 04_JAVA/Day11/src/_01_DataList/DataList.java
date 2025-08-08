package _01_DataList;

/**
 * Java 선생님:
 * 두프룸프님, 이번에는 우리가 직접 제네릭 클래스를 만들어 볼 거예요.
 * 우리가 흔히 쓰는 ArrayList가 내부적으로 어떻게 동작하는지 흉내 내면서
 * 제네릭의 강력함을 다시 한번 느껴보는 시간입니다.
 *
 * 클래스 이름 옆에 <E> 보이시죠? 이게 바로 "이 클래스는 제네릭 클래스입니다" 라는 선언이에요.
 * E는 Element(요소)의 약자로, "어떤 타입의 요소(Element)든 담을 수 있다"는 의미를 가집니다.
 * 사용자가 이 클래스를 만들 때 타입을 지정하면(예: DataList<String>), 클래스 내부의 모든 E가
 * 지정된 타입(String)으로 변신하게 됩니다. 마법 같죠?
 */
public class DataList<E> { // <E>를 붙여 제네릭 클래스로 선언!

    // 내부적으로 데이터를 저장할 배열입니다.
    // 예전에는 모든 걸 담으려고 Object[]를 썼지만, 이러면 꺼내 쓸 때마다 어떤 타입인지 몰라 불안하고,
    // 매번 (String), (Integer) 처럼 형변환을 해줘야 해서 불편했어요.
    // 하지만 제네릭을 사용하면, 이 배열은 DataList<String>으로 만들면 String[]이 되고,
    // DataList<Integer>로 만들면 Integer[]가 된답니다. 처음부터 타입이 정해지니 안전하고 편리하죠.
    private E[] data;
    private int size; // 현재 저장된 데이터의 개수
    private int defaultSize = 10; // 사용자가 크기를 정하지 않았을 때의 기본 크기

    // 기본 생성자: 사용자가 크기를 지정하지 않으면 기본 크기(10)의 배열을 생성합니다.
    public DataList() {
        // data = new E[defaultSize]; -> 이런! 제네릭 타입으로는 바로 배열을 만들 수 없어요. new E[]는 문법 오류!
        // Java의 제네릭은 컴파일 타임에만 타입 정보를 가지고, 런타임에는 타입 정보가 사라지기 때문이에요. (타입 소거)
        // 그래서 약간의 트릭이 필요합니다. 우선 Object 배열로 만든 다음, (E[])로 강제 형변환을 해주는 거죠.
        // "일단 Object로 공간을 만들고, 여긴 E 타입만 들어올 거라고 믿고 쓰자!" 라는 의미입니다.
        data = (E[]) new Object[defaultSize];
    }

    // 사용자가 직접 크기를 지정하는 생성자
    public DataList(int size) {
        data = (E[]) new Object[size];
    }

    /**
     * Java 선생님:
     * 리스트에 새로운 데이터를 추가하는 메서드입니다.
     * 파라미터 타입이 E로 되어 있죠? 그래서 DataList<String>이었다면 String만 받을 수 있고,
     * DataList<Integer>였다면 Integer만 받을 수 있게 됩니다.
     * 만약 다른 타입을 넣으려고 하면 컴파일러가 "타입이 맞지 않습니다!" 하고 바로 알려주니 실수를 줄일 수 있어요.
     */
    public void add(E value) {
        data[size++] = value; // 현재 크기(size) 위치에 데이터를 넣고, size를 1 증가시킵니다.
    }

    /**
     * Java 선생님:
     * 특정 위치(index)에 있는 데이터를 꺼내오는 메서드입니다.
     * 반환 타입이 E인 것을 주목하세요! Object가 아니에요.
     * 덕분에 우리는 이 메서드에서 나온 결과를 굳이 형변환할 필요가 없답니다.
     * DataList<String>에서 get()을 하면 당연히 String이 나오고,
     * DataList<Integer>에서 get()을 하면 당연히 Integer가 나오니까요.
     */
    public Object get(int index) {
        return data[index];
    }

    // 현재 리스트에 저장된 데이터의 개수를 반환하는 메서드
    public int size() {
        return size;
    }
}