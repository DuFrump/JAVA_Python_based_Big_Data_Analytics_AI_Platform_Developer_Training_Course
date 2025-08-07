package _07_Inheritance_book;

// Comic 클래스는 Book 클래스를 상속받는 자식 클래스(Subclass)입니다.
// 만화책에 특화된 속성과 기능을 추가하고, 부모 클래스의 메소드를 오버라이딩합니다.
public class Comic extends Book {
    // 필드: 만화책의 컬러 여부를 저장합니다.
    boolean isColor;

    // 생성자: Comic 객체를 생성할 때 호출됩니다.
    // `super(title, author)`를 통해 부모 클래스(Book)의 생성자를 호출하여 필드를 초기화합니다.
    Comic(String title, String author, boolean isColor) {
        super(title, author);
        this.isColor = isColor;
    }

    // [1] `final` 메소드 오버라이딩 불가 예시
    // 부모 클래스(Book)의 `info_title()` 메소드는 `final`로 선언되어 있습니다.
    // `final` 메소드는 자식 클래스에서 오버라이딩할 수 없습니다.
    // 아래 주석을 해제하면 컴파일 에러가 발생합니다.
    // @Override
    // void info_title() { // 에러: info_title() in Book cannot be overridden
    //     System.out.printf("이 만화책의 제목은 %s입니다.%n", title);
    // }

    // [2] 메소드 오버라이딩: `info_author()`
    // 부모 클래스(Book)의 `info_author()` 메소드를 재정의합니다.
    // `@Override` 어노테이션은 이 메소드가 오버라이딩되었음을 명시합니다.
    @Override // annotation
    void info_author() {
        System.out.printf("이 만화책의 저자는 %s입니다.%n", author);
    }

    // [3] Comic 클래스 고유의 메소드: `info_color()`
    // 만화책의 컬러 여부를 출력하는 기능입니다.
    void info_color() {
        if (isColor) { // `isColor == true`는 `isColor`로 간결하게 표현 가능
            System.out.println("이 만화책은 컬러 만화책입니다.");
        } else {
            System.out.println("이 만화책은 흑백 만화책입니다.");
        }
    }

    // [4] 여러 메소드를 조합하여 사용하는 메소드: `info_everything()`
    // 부모로부터 상속받은 메소드와 자신의 고유 메소드를 함께 호출하여 모든 정보를 출력합니다.
    void info_everything() {
        info_title();  // 부모의 final 메소드 호출
        info_author(); // 오버라이딩된 메소드 호출
        info_color();  // Comic 고유의 메소드 호출
    }
}
