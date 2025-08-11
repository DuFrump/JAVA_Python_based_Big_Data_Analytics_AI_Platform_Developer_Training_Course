package _07_Inheritance_book;

/**
 * Comic 클래스는 Book 클래스를 상속받는 '자식 클래스'입니다.
 * 'extends Book'을 통해 Book의 모든 속성과 기능을 물려받습니다.
 *
 * 이 클래스에서는 'final' 메소드가 자식 클래스에서 오버라이딩될 수 없다는
 * 중요한 규칙을 다시 한번 확인해 볼 거예요.
 * 또한, 부모의 일반 메소드를 오버라이딩하고, 만화책만의 새로운 기능을 추가하는 방법을 살펴봅시다.
 */
public class Comic extends Book {

    // === 필드 (Fields) ===
    // Book 클래스로부터 title, author를 물려받았습니다.
    // 여기에 만화책만의 속성인 '컬러 여부'를 추가합니다.
    boolean isColor; // 만화책이 컬러인지 흑백인지 저장할 변수 (true: 컬러, false: 흑백)

    // === 생성자 (Constructor) ===
    /**
     * Comic 객체를 생성할 때 호출되는 생성자입니다.
     * 만화책의 제목, 작가, 그리고 컬러 여부를 매개변수로 받습니다.
     *
     * 'super(title, author)'를 통해 부모 클래스(Book)의 생성자를 호출하여
     * Book의 title과 author 필드를 초기화합니다.
     * 자식 클래스의 생성자에서 부모 클래스의 생성자를 호출할 때는 반드시 첫 줄에 와야 합니다.
     */
    Comic(String title, String author, boolean isColor) {
        super(title, author); // 부모 클래스(Book)의 생성자 호출
        this.isColor = isColor; // Comic 클래스 고유의 필드 초기화
    }

    // === 메소드 (Methods) ===

    /**
     * [1] final 메소드 오버라이딩 불가 예시
     * 부모 클래스(Book)의 info_title() 메소드는 'final'로 선언되어 있습니다.
     * 'final' 메소드는 자식 클래스에서 오버라이딩(재정의)할 수 없습니다.
     *
     * 만약 아래 주석 처리된 코드를 해제하면 컴파일 에러가 발생할 것입니다.
     * 이는 'final' 키워드가 메소드의 기능을 최종적으로 확정하여,
     * 더 이상 변경되지 않도록 보호하는 역할을 한다는 것을 보여줍니다.
     */
    // @Override
    // void info_title() { // 에러: info_title() in Book cannot be overridden
    //     System.out.printf("이 만화책의 제목은 %s입니다.%n", title);
    // }

    /**
     * [2] 메소드 오버라이딩: info_author()
     * 부모 클래스(Book)의 info_author() 메소드를 재정의합니다.
     * 이 메소드에는 'final' 키워드가 붙어 있지 않으므로,
     * Comic 클래스에 맞게 기능을 변경할 수 있습니다.
     *
     * '@Override' 어노테이션은 이 메소드가 부모의 메소드를 오버라이딩했음을 명시적으로 알려줍니다.
     */
    @Override
    void info_author() {
        System.out.printf("이 만화책의 저자는 %s입니다.%n", author);
    }

    /**
     * [3] Comic 클래스 고유의 메소드: info_color()
     * 이 메소드는 Comic 클래스에만 존재하는 고유한 기능입니다.
     * 부모 클래스인 Book에는 없는 기능이죠.
     * 만화책의 컬러 여부를 출력하는 기능을 합니다.
     */
    void info_color() {
        if (isColor) { // isColor == true 와 동일한 의미입니다.
            System.out.println("이 만화책은 컬러 만화책입니다.");
        } else {
            System.out.println("이 만화책은 흑백 만화책입니다.");
        }
    }

    /**
     * [4] 여러 메소드를 조합하여 사용하는 메소드: info_everything()
     * 이 메소드는 부모로부터 상속받은 메소드(info_title)와
     * 오버라이딩된 메소드(info_author), 그리고 자신의 고유 메소드(info_color)를
     * 모두 호출하여 만화책의 모든 정보를 한 번에 출력하는 기능을 합니다.
     *
     * 이를 통해 상속과 오버라이딩, 그리고 새로운 기능 추가가 어떻게 조화를 이루는지 볼 수 있습니다.
     */
    void info_everything() {
        info_title();  // 부모의 final 메소드 호출 (오버라이딩 불가)
        info_author(); // 오버라이딩된 메소드 호출
        info_color();  // Comic 고유의 메소드 호출
    }
}