package _01_Inheritance_book;

// Book 클래스는 책의 기본적인 정보를 나타내는 부모 클래스(Superclass)입니다.
// 이 클래스는 모든 종류의 책이 공통적으로 가질 수 있는 속성과 기능을 정의합니다.
public class Book {
    // 필드(Field): 책의 속성을 나타내는 변수들입니다.
    String title; // 책의 제목을 저장하는 문자열 변수
    int price;    // 책의 가격을 저장하는 정수 변수

    // 메소드(Method): 책과 관련된 동작을 정의합니다.
    // 책의 정보를 콘솔에 출력하는 기능입니다.
    void info() {
        System.out.printf("책 이름은 %s이고, 책 가격은 %d입니다.%n", title, price);
    }
}
