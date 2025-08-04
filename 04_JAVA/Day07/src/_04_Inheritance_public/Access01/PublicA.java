package _04_Inheritance_public.Access01;

public class PublicA {
    public int a;


    private PublicA(int a) {
        this.a = a;
    }

    public void printA() {
        System.out.println("PublicA 클래스의 printA() 메서드 입니다.");

    }

    DefaultC dc = new DefaultC();

    void methodA() {
        dc.variableC = 20;
    }
}