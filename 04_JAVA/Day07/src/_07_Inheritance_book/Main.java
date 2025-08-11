package _07_Inheritance_book;

/**
 * 일곱 번째 예제의 마지막 파일, Main 클래스입니다!
 * 여기서는 우리가 만든 Book과 Comic 클래스들의 객체를 생성하고,
 * 그 기능들을 호출하면서 'final' 메소드와 '메소드 오버라이딩'이 어떻게 동작하는지
 * 직접 확인하는 중요한 시간이에요.
 *
 * 'public static void main(String[] args)' 메소드는 자바 프로그램이 시작되는 지점이라는 것,
 * 이제는 잘 아시죠? 여기서 객체를 만들고 메소드를 호출하면서 동작을 살펴봅시다.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("--- [1] Book 객체 테스트 ---");
        // Book 객체 생성: 제목과 작가를 전달하여 초기화합니다.
        Book novel = new Book("어린 왕자", "앙투안 드 생텍쥐페리");
        novel.info_title();  // Book의 final info_title() 호출
        novel.info_author(); // Book의 info_author() 호출

        System.out.println("\n--- [2] Comic 객체 테스트 ---");
        // Comic 객체 생성: 제목, 작가, 컬러 여부를 전달하여 초기화합니다.
        // 이 순간, Comic 생성자 내부에서 super(title, author)를 통해 Book 생성자가 먼저 호출됩니다.
        Comic comicBook = new Comic("포켓몬스터", "미상의 일본인", false);

        System.out.println("\n--- Comic 객체의 info_everything() 메소드 호출 ---");
        // comicBook 객체의 info_everything() 메소드를 호출합니다.
        // 이 메소드 내부에서 info_title(), info_author(), info_color()가 순서대로 호출됩니다.
        // 각 메소드가 어떤 클래스의 어떤 버전으로 실행되는지 주목해 주세요.
        comicBook.info_everything();

        // 예상 출력:
        // 책의 제목은 포켓몬스터입니다. (Book의 final info_title() 호출)
        // 이 만화책의 저자는 미상의 일본인입니다. (Comic에서 오버라이딩된 info_author() 호출)
        // 이 만화책은 흑백 만화책입니다. (Comic 고유의 info_color() 호출)

        System.out.println("\n--- 모든 책 예제 테스트 완료 ---");
        System.out.println("final 메소드와 오버라이딩된 메소드가 어떻게 동작하는지 잘 이해하셨기를 바랍니다!");
    }
}