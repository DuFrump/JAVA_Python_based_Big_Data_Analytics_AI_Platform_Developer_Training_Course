class Parent1 {
    public void display() {
        System.out.println("부모 클래스의 display() 메서드입니다.");
    }
}

class Child1 extends Parent1 {
    @Override
    public void display() {
        System.out.println("자식 클래스의 display() 메서드입니다.");
    }

    // 위에 있는 메서드를 오버로딩함
    /** Overloading */
    public void display(String str) {
        System.out.println(str);
    }
}

public class _10_OverloadingOverriding {

    public static void main(String[] args) {
        Child1 ch = new Child1();
        ch.display();

        Parent1 pa = new Parent1();
        pa.display();

        Parent1 pa1 = new Child1();
        pa1.display();

        ch.display("이건 문자열을 따로 받게끔 만든 Overloading 메서드입니다.");
        // pa.display("이건 문자열을 따로 받게끔 만든 Overloading 메서드입니다."); <------------ Overloading 메서드가 Child1 클래스에 있는 메서드이기 때문입니다.
    }
}
