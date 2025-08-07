package _07_Inheritance_book;

// Book 클래스는 책의 기본적인 정보를 나타내는 부모 클래스(Superclass)입니다.
// `final` 메소드를 포함하여 상속 시 오버라이딩 제한을 보여줍니다.
public class Book {
    // 필드: 책의 제목과 작가를 저장합니다.
    String title;  // 책의 제목
    String author; // 책의 작가

    // 생성자: Book 객체를 생성할 때 제목과 작가를 초기화합니다.
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // [1] `final` 메소드: `info_title()`
    // `final` 키워드가 붙은 메소드는 자식 클래스에서 오버라이딩(재정의)할 수 없습니다.
    // 이 메소드는 책의 제목을 출력합니다.
    final void info_title() {
        System.out.printf("책의 제목은 %s입니다.%n", title);
    }

    // [2] 일반 메소드: `info_author()`
    // 이 메소드는 자식 클래스에서 오버라이딩할 수 있습니다.
    // 책의 작가를 출력합니다.
    void info_author() {
        System.out.printf("책의 작가는 %s입니다.%n", author);
    }
}
