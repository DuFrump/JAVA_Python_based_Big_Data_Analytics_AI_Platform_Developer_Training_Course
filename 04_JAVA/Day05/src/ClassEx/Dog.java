package ClassEx;

/**
 * 두프룸프님, 이번에는 강아지(Dog) 클래스 설계도를 살펴볼게요.
 * 이 클래스는 `private` 키워드, 생성자 오버로딩, Getter/Setter 등 중요한 개념들을 담고 있어요.
 * Cat 클래스와 비교하면서 어떤 점이 다른지 살펴보는 것도 좋은 공부가 될 거예요.
 */
public class Dog {

    // === 필드 (Fields) ===

    // [1] private 인스턴스 변수
    // `private`은 "이 클래스 안에서만 접근할 수 있다"는 가장 강력한 접근 제한자예요.
    // 이렇게 변수를 private으로 잠궈두면, 외부에서 `dog1.name = "점박이"` 처럼 마음대로 값을 바꿀 수 없게 됩니다.
    // 데이터를 안전하게 보호하기 위한 첫걸음, 바로 캡슐화의 시작입니다!
    private String name; // 이름
    private int age;     // 나이

    // [2] static(클래스) 변수
    // Dog 클래스로 만든 모든 강아지 객체들이 함께 공유하는 값이에요.
    static String bark = "멍멍"; // 모든 강아지는 똑같이 "멍멍" 짖는다고 정해뒀어요.
    static int count = 0;      // `introduce` 메소드가 호출된 총 횟수를 세기 위한 공유 카운터입니다.

    // === 생성자 (Constructors) ===
    // 생성자 오버로딩을 통해 다양한 방법으로 Dog 객체를 만들 수 있도록 준비해뒀어요.

    // [1] 기본 생성자
    public Dog() {}

    // [2] 이름만 받는 생성자
    public Dog(String name) {
        this.name = name;
    }

    // [3] 이름과 나이를 모두 받는 생성자
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // === Getter & Setter ===
    // private으로 잠궈둔 변수들에 안전하게 접근할 수 있도록 통로(메소드)를 열어주는 시간이에요.

    // age 변수에 대한 Getter
    public int getAge() { return age; }

    // name 변수에 대한 Getter (getNmame -> getName 오타 수정)
    public String getName() { return name; }

    // age 변수에 대한 Setter
    public void setAge(int age) {
        // 나이는 1살 이상이어야 한다는 비즈니스 로직(규칙)을 추가했어요.
        // 이렇게 Setter를 통해 잘못된 값이 들어오는 것을 막을 수 있습니다.
        if(age >= 1) {
            this.age = age;
        } else {
            System.out.println("나이는 1살 이상으로만 설정할 수 있어요!");
        }
    }

    // name 변수에 대한 Setter
    public void setName(String name) { this.name = name; }


    // === 메소드 (Methods) ===

    public void weare() {
        System.out.println("우리는 강아지 입니다.");
    }

    // 자기소개 메소드
    public void introduce() {
        System.out.println("제 이름은 " + this.name + "이고, 나이는 " + this.age + "살이에요.");
        count++; // 자기소개를 할 때마다 모든 강아지가 공유하는 count를 1씩 증가시켜요.
    }

    // 짖는 메소드 (barkSound -> bark 오타 수정)
    public void bark() {
        // this.name은 이 객체의 이름을, bark는 모든 강아지가 공유하는 짖는 소리를 가져와요.
        System.out.println(this.name + "이(가) " + bark + "! 하고 짖습니다.");
    }
}