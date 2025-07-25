package ClassEx;

public class Dog {

    private String name;   // 필드
    private int age;       //
    static String bark = "멍멍";
    static int count;


    public Dog() {}   // 생성자 1

    public Dog(String name) { // 생성자 2
        this.name = name;
    }

    public Dog(String name, int age) {  // 생성자 3
        this.name = name;
        this.age = age;
    }


    public int getAge() { return age; }  // 게터

    public String getNmame() { return name; }

    public void setAge(int age) {   // 세터
        if(age >= 1) {
            this.age = age;
        } else {
            System.out.println("나이는 1살부터 입력 가능!!");
        }
    }

    public void setName(String name) { this.name = name; }


    public void weare() {  // 메서드
        System.out.println("우리는 강아지 입니다.");
    }

    public void introduce() {   // 메서드
        System.out.println("이름은 " + this.name + " 나이는 " + this.age);
        count++;
    }
}
