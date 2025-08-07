package _01_Inheritance_book;

// Main 클래스는 Book과 Comic 클래스를 사용하여 객체를 생성하고 상속 관계를 확인하는 예제입니다.
public class Main {
    public static void main(String[] args) {
        // Comic 클래스의 객체 comic01을 생성합니다.
        // Comic은 Book을 상속받았으므로, Book의 필드와 메소드를 사용할 수 있습니다.
        Comic comic01 = new Comic();

        // comic01 객체의 title과 price 필드에 값을 할당합니다.
        // 이 필드들은 Book 클래스로부터 상속받은 것입니다.
        comic01.title = "포켓몬스터";
        comic01.price = 8500;

        // comic01 객체의 info() 메소드를 호출합니다.
        // 이 메소드 역시 Book 클래스로부터 상속받은 것입니다.
        comic01.info(); // 출력: 책 이름은 포켓몬스터이고, 책 가격은 8500입니다.

        // Book 클래스의 객체를 직접 생성할 수도 있습니다.
        Book book01 = new Book();
        book01.title = "자바의 정석";
        book01.price = 30000;
        book01.info();
    }
}
