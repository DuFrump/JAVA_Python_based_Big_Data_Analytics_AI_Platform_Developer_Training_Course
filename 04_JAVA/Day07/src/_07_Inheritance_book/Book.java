package _07_Inheritance_book;

public class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    final void info_title() {
        System.out.printf("책의 제목은 %s입니다.%n", title);
    }

    void info_author() {
        System.out.printf("책의 작가는 %s입니다.%n", author);
    }
}
