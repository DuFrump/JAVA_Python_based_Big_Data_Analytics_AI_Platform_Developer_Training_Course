// 인터페이스
interface Greeting {
    void sayHello();
}

public class AnonymousClassEX {
    public static void main(String[] args) {
        // 익명 클래스
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("안녕하세요!");
            }
        };

        // 실행
        greeting.sayHello();
    }
}
