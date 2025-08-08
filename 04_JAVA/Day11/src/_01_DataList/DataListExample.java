package _01_DataList;

/**
 * Java 선생님:
 * 두프룸프님, 이번 예제에서는 우리가 만든 DataList를 직접 사용해보면서
 * 제네릭을 썼을 때와 안 썼을 때 어떤 차이가 있는지 확실하게 비교해볼 거예요.
 */
public class DataListExample {
    public static void main(String[] args) {

        System.out.println("--- 제네릭을 사용하지 않았을 경우 ---");
        // 제네릭 없이 DataList를 만들면, 내부적으로는 Object 타입으로 데이터를 다루게 돼요.
        // 마치 "내용물 스티커가 없는 상자"와 같아서, 온갖 종류의 물건(데이터)을 다 담을 수 있죠.
        DataList list_before = new DataList();

        // 정수, 문자열, 실수... 타입 구분 없이 마구 넣을 수 있습니다. 넣을 땐 편해 보이죠?
        list_before.add(10);
        list_before.add("문자");
        list_before.add(10.33);

        // 하지만 상자를 열어서(데이터를 꺼내서) 사용하려면 아주 골치 아파집니다.
        for (int i = 0; i < list_before.size(); i++) {
            Object data = list_before.get(i); // 일단 모든 걸 '물건(Object)'으로 꺼내요.
            System.out.println("꺼낸 데이터: " + data);

            // 이 물건이 장난감(Integer)인지, 책(String)인지, 과일(Double)인지 일일이 확인해야 해요.
            // 이게 바로 instanceof 연산자입니다. 그리고 맞는 타입으로 다시 변신(형변환)시켜야만 쓸 수 있죠.
            // 너무 번거롭고, 만약 새로운 타입이 추가되면 이 if-else문은 계속 길어질 거예요. 끔찍하죠?
            if(data instanceof Integer) {
                System.out.println("이건 정수네요! 값은: " + (int)data  );
            } else if (data instanceof Double) {
                System.out.println("이건 실수네요! 값은: " + (double)data);
            } else if (data instanceof String) {
                System.out.println("이건 문자열이네요! 내용은: " + (String)data);
            }
        }

        System.out.println("\n--- 제네릭을 사용하여 타입을 지정한 경우 ---");
        // 이제 제네릭을 사용해봅시다! "이 상자는 오직 과일(String)만 담는 상자입니다" 라고 선언하는 거예요.
        // DataList<String> list_after = new DataList<String>(); 이렇게 쓰는 게 정석이지만,
        // 뒤에 오는 <>는 비워둬도 Java가 알아서 타입을 추론해줘요. 이걸 '다이아몬드 연산자'라고 부릅니다.
        DataList<String> list_after = new DataList<>();

        // 이제 이 리스트는 'String' 타입 전용 리스트가 되었어요.
        list_after.add("사과");
        list_after.add("바나나");
        list_after.add("딸기");

        // 만약 다른 타입을 넣으려고 하면? 아래 코드의 주석을 풀고 실행해보세요.
        // list_after.add(123); // 컴파일러가 "여긴 String만 넣기로 했잖아요!" 하면서 오류를 바로 알려줍니다. 안전하죠!

        // 데이터를 꺼내 쓸 때도 훨씬 간단해집니다.
        for (int i = 0; i < list_after.size(); i++) {
            // get() 메서드가 반환하는 타입은 이제 Object가 아니라, 우리가 지정한 String이 됩니다.
            // 그래서 귀찮은 타입 확인이나 형변환 과정이 전혀 필요 없어요.
            String fruit = list_after.get(i);
            System.out.println("꺼낸 과일: " + fruit.toUpperCase()); // .toUpperCase() 같은 String 전용 메서드도 바로 쓸 수 있죠.
        }

        /*
         * Java 선생님 최종 정리:
         * 제네릭은 "실수할 여지를 미리 막아주는 안전장치"이자 "귀찮은 형변환을 없애주는 편리한 도구"입니다.
         * 데이터를 다룰 때는 항상 타입을 명확히 지정하는 습관을 들이는 것이
         * 앞으로 두프룸프님이 만들어갈 데이터/AI 프로그램의 안정성과 효율성을 크게 높여줄 거예요!
         */
    }
}