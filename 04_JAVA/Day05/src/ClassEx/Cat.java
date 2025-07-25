package ClassEx;

// public == 어디서든.
// protected == 같은 패키지 + 다른 패키지는 상속 받았을 때만.
// default == 같은 패키지 안에서만.
// private == 그 클래스 안에서만.

// 클래스는 public or default만.

public class Cat {

    String name;    // name 필드
    int age;        // age 필드

    public Cat(String name, int age) { // 생성자 (객체를 만들 때 사용됨)
        this.name = name;
        this.age = age;
    }

    public void cry() {                                    // cry 메서드 생성
        System.out.println("Meow~ Meow~");
    }

    void introduce() {
        System.out.printf("이름은 %s, 나이는 %d살 입니다.%n", name, age);
    }

    void introduce_dream(String dream) {
        System.out.printf("나는 %s라는 이름의 고양이에요. 나이는 %d살이고, 제 꿈은 행복한 %s 입니다.%n", name, age, dream);
    }

    int feed_unga(int bob) {
        System.out.printf("이 고양이는 %s인데요..%n", name);
        System.out.printf("밥을 %d번 먹었네..?%n", bob);

        int unga = bob * 2;
        return unga;
    }

    // 파라미터 개수가 다르거나
    // 자료형이 다르거나
    // 순서가 다르거나
    // 가 가능하면 메서드 오버로딩이 가능하다!!
    int feed_unga(int bob, int moul) { // 메서드 오버로딩
        System.out.printf("저는 %s인데요..%n", name);
        System.out.printf("밥을 %d 번, 물을 %d번 먹었습니다.%n", bob, moul);
        return bob + moul;
    }
}
