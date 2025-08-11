package _07_Inheritance_book;

/**
 * 일곱 번째 예제에 오신 것을 환영합니다!
 * 이 예제는 첫 번째 '책' 예제와 비슷해 보이지만,
 * 여기서는 'final' 키워드가 메소드에 적용될 때 어떤 의미를 가지는지,
 * 그리고 매개변수를 받는 '생성자'가 상속 관계에서 어떻게 사용되는지
 * 다시 한번 집중적으로 배워볼 거예요.
 *
 * 이 Book 클래스는 '제목'과 '작가'라는 속성을 가지며,
 * 이 정보를 출력하는 메소드들을 포함하는 '부모 클래스' 역할을 합니다.
 * 특히, 'final' 메소드를 통해 자식 클래스에서 변경할 수 없는 기능을 정의하는 방법을 보여줄 겁니다.
 */
public class Book {
    // === 필드 (Fields) ===
    String title;  // 책의 제목을 저장할 변수
    String author; // 책의 작가를 저장할 변수

    // === 생성자 (Constructor) ===
    /**
     * Book 객체를 생성할 때 호출되는 생성자입니다.
     * 책의 제목과 작가를 매개변수로 받아서 필드를 초기화합니다.
     */
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // === 메소드 (Methods) ===

    /**
     * [1] final 메소드: info_title()
     * 'final' 키워드가 붙은 메소드는 자식 클래스에서 '오버라이딩(재정의)'할 수 없습니다.
     * 즉, 이 메소드의 기능은 이 Book 클래스에서 최종적으로 결정되며,
     * 이 Book을 상속받는 자식 클래스(예: Comic)에서는 info_title() 메소드를 변경할 수 없습니다.
     *
     * 이 메소드는 책의 제목을 출력하는 기능을 합니다.
     */
    final void info_title() {
        System.out.printf("책의 제목은 %s입니다.%n", title);
    }

    /**
     * [2] 일반 메소드: info_author()
     * 이 메소드에는 'final' 키워드가 붙어 있지 않으므로,
     * 자식 클래스에서 자유롭게 오버라이딩(재정의)할 수 있습니다.
     *
     * 이 메소드는 책의 작가를 출력하는 기능을 합니다.
     */
    void info_author() {
        System.out.printf("책의 작가는 %s입니다.%n", author);
    }
}