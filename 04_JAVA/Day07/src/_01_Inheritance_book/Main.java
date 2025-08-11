package _01_Inheritance_book;

/**
 * 드디어 마지막 Main 클래스입니다!
 * 이 클래스는 우리가 만든 Book과 Comic 클래스를 실제로 사용하는 '실행 공간'이에요.
 * 'public static void main(String[] args)' 메소드는 자바 프로그램이 가장 먼저 실행을 시작하는 특별한 장소랍니다.
 *
 * 여기서는 클래스라는 '설계도'를 가지고 'new'라는 키워드를 사용해서
 * 실제 메모리 공간에 존재하는 '객체(Object)'를 만들어 볼 거예요.
 * 그리고 그 객체들이 어떻게 동작하는지 눈으로 직접 확인해 봅시다!
 */
public class Main {
    public static void main(String[] args) {

        // --- Book 객체 생성 및 사용 ---
        System.out.println("--- 부모 클래스인 Book 객체 테스트 ---");

        // Book book1 = new Book();
        // 1. Book book1; -> Book 클래스 타입의 참조 변수 'book1'을 선언합니다. book1은 리모컨이라고 생각하면 쉬워요.
        // 2. new Book(); -> 'new' 키워드로 Book 클래스의 실제 객체(인스턴스)를 메모리에 만듭니다. 이게 TV 본체예요.
        // 3. = (대입 연산자) -> 만들어진 Book 객체의 주소(위치)를 참조 변수 book1(리모컨)에 연결해줍니다.
        Book book1 = new Book();

        // 이제 book1 리모컨으로 Book 객체를 조종할 수 있어요.
        // book1 객체의 title과 price 속성에 값을 넣어줍니다.
        book1.title = "자바의 정석";
        book1.price = 30000;

        // book1 객체의 info() 기능을 실행합니다.
        book1.info(); // 결과: "책 이름은 자바의 정석이고, 책 가격은 30000입니다." 가 출력됩니다.

        System.out.println("\n--- 자식 클래스인 Comic 객체 테스트 ---"); // \n은 줄바꿈을 위한 기호예요.

        // --- Comic 객체 생성 및 사용 ---
        // 이번에는 Comic 클래스의 객체를 만들어 볼게요. 과정은 Book과 똑같습니다.
        Comic comic1 = new Comic();

        // comic1 객체의 속성에 값을 넣어줍니다.
        // 보세요! title과 price는 Comic 클래스에 직접 만든 적이 없지만,
        // 부모인 Book으로부터 물려받았기 때문에 당연하게 사용할 수 있습니다.
        comic1.title = "원피스 108권";
        comic1.price = 5500;
        // author는 Comic 클래스에 새로 추가한 속성이죠.
        comic1.author = "오다 에이치로";

        // comic1 객체의 info() 기능을 실행합니다.
        // 과연 어떤 결과가 나올까요?
        // Comic 클래스에서 info() 메소드를 '오버라이딩' 했기 때문에,
        // 부모의 info()가 아닌, 자식의 info()가 실행됩니다.
        comic1.info();
        // 결과:
        // "책 이름은 원피스 108권이고, 책 가격은 5500입니다." (super.info() 덕분)
        // "이 만화책의 작가는 오다 에이치로입니다." (Comic 클래스에 추가한 기능)

        // 이렇게 상속과 오버라이딩을 통해 코드의 재사용성을 높이고,
        // 클래스 간의 관계를 명확하게 표현할 수 있답니다. 정말 멋지죠?
    }
}