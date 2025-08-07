package _07_Inheritance_book;

// Main 클래스는 Book과 Comic 클래스를 사용하여 객체를 생성하고
// 상속 및 메소드 오버라이딩의 동작을 확인하는 예제입니다.
public class Main {
    public static void main(String[] args) {
        // Comic 클래스의 객체 comicBook을 생성합니다.
        // 생성자 호출 시 제목, 작가, 컬러 여부를 전달합니다.
        Comic comicBook = new Comic("포켓몬스터", "미상의 일본인", false);

        // comicBook 객체의 `info_everything()` 메소드를 호출합니다.
        // 이 메소드 내부에서 `info_title()`, `info_author()`, `info_color()`가 순서대로 호출됩니다.
        // - `info_title()`: Book 클래스의 `final` 메소드가 호출됩니다.
        // - `info_author()`: Comic 클래스에서 오버라이딩된 메소드가 호출됩니다.
        // - `info_color()`: Comic 클래스 고유의 메소드가 호출됩니다.
        comicBook.info_everything();

        // 예상 출력:
        // 책의 제목은 포켓몬스터입니다.
        // 이 만화책의 저자는 미상의 일본인입니다.
        // 이 만화책은 흑백 만화책입니다.
    }
}
