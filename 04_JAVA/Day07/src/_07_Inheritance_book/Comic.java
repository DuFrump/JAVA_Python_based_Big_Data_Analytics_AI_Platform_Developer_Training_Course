package _07_Inheritance_book;

public class Comic extends Book {
    boolean isColor;

    Comic(String title, String author, boolean isColor) {
        super(title, author);
        this.isColor = isColor;
    }

    // 부모 메서드에서 final이 선언 되었으면 오버라이딩이 불가능하다.
//    @Override
//    void info_title() {
//        System.out.printf("이 만화책의 제목은 %s입니다.%n", title);
//    }

    @Override // annotation
    void info_author() {
        System.out.printf("이 만화책의 저자는 %s입니다.%n", author);
    }

    void info_color() {
        if (isColor == true) {
            System.out.println("이 만화책은 컬러 만화책입니다.");
        } else {
            System.out.println("이 만화책은 흑백 만화책입니다.");
        }
    }

    void info_everything() {
        info_title();
        info_author();
        info_color();
    }
}
