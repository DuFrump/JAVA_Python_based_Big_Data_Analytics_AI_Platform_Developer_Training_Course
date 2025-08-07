public class _07_LocalClass2 {

    void myMethod() {
        class LocalClass {
            void display() {
                System.out.println("지역 클래스에서 실행됨!");
            }
        }

        LocalClass local = new LocalClass(); // 지역 클래스의 인스턴스 생성
        local.display();
    }

    public static void main(String[] args) {
        _07_LocalClass2 outer = new _07_LocalClass2();
        outer.myMethod();
    }
}
