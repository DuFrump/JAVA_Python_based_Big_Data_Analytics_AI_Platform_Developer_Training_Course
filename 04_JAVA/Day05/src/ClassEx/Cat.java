package ClassEx;

/**
 * 두프룸프님, 이번에는 고양이(Cat) 클래스 설계도를 함께 봐요!
 * 이 클래스는 Dog 클래스보다는 간단하지만, 클래스의 기본적인 구성 요소와
 * 메소드 오버로딩의 개념을 이해하기에 아주 좋은 예제랍니다.
 */
public class Cat {

    // === 필드 (Fields) ===
    // 고양이 객체가 가질 데이터들입니다.
    // Dog 클래스와 달리 접근 제한자(public, private 등)를 생략했네요.
    // 이렇게 생략하면 `default` 접근 제한자가 적용되어, 같은 `ClassEx` 패키지 내에서는 자유롭게 접근할 수 있어요.
    String name;    // 이름
    int age;        // 나이

    // === 생성자 (Constructor) ===
    // `new Cat("나비", 8)` 처럼 객체를 생성할 때 이름과 나이를 반드시 받아서
    // 초기화해주는 역할을 합니다.
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // === 메소드 (Methods) ===

    // 우는 행동을 표현하는 메소드
    public void cry() {
        System.out.println("야옹~ 야옹~");
    }

    // 자기소개를 하는 메소드
    void introduce() {
        // printf를 사용해서 서식이 있는 문자열을 출력해요.
        // %s는 문자열(String), %d는 정수(decimal) 자리에 변수 값이 들어갑니다.
        System.out.printf("제 이름은 %s이고, 나이는 %d살이에요.\n", name, age);
    }

    // 꿈을 소개하는 메소드. 꿈(dream)이라는 추가 정보를 파라미터로 받아요.
    void introduce_dream(String dream) {
        System.out.printf("저는 %s라는 이름의 고양이예요. 나이는 %d살이고, 제 꿈은 행복한 %s가 되는 것이랍니다.\n", name, age, dream);
    }

    // --- 메소드 오버로딩 예제 ---
    // 똑같은 이름의 `feed_unga` 메소드가 두 개 있지만, 파라미터가 달라서 다른 기능을 수행해요.

    // [1] 밥 먹은 횟수만 받아서 응가 횟수를 계산하는 메소드
    // "밥을 먹으면 꼭 두 번씩 응가한다"는 재미있는 규칙을 가지고 있네요!
    int feed_unga(int bob) {
        System.out.printf("이 고양이(%s)는...\n", name);
        System.out.printf("밥을 %d번 먹었네요?\n", bob);

        int unga = bob * 2;
        // 이 메소드를 호출한 곳으로 계산된 응가 횟수(unga)를 돌려줍니다(return).
        return unga;
    }

    // [2] 밥 먹은 횟수와 물 마신 횟수를 모두 받아서 계산하는 메소드 (오버로딩)
    // 파라미터의 개수가 위 메소드와 다르기 때문에, 자바는 둘을 다른 메소드로 인식해요.
    int feed_unga(int bob, int moul) {
        System.out.printf("저(%s)는 말이죠...\n", name);
        System.out.printf("밥을 %d번, 물을 %d번 먹었어요.\n", bob, moul);
        // 여기서는 밥 먹은 횟수와 물 마신 횟수를 단순히 더한 값을 응가 횟수로 돌려주네요.
        return bob + moul;
    }
}