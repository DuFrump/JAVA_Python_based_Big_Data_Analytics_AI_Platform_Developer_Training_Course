import java.util.ArrayList;
import java.util.List;

/**
 * Java 선생님:
 * 두프룸프님, 이번에는 우리가 직접 만든 클래스(객체)를 ArrayList에 담아볼 거예요.
 * 지금까지는 String, Integer처럼 Java가 미리 만들어 둔 데이터 타입만 사용했죠?
 * 하지만 실제 프로그래밍에서는 이름, 나이, 주소 등 여러 정보를 하나로 묶어서 다뤄야 할 때가 많아요.
 * 그럴 때 사용하는 것이 바로 '클래스'와 '객체'입니다.
 */

// 먼저, 사람의 이름(name)과 나이(age) 정보를 하나로 묶어줄 'Person'이라는 설계도를 만듭니다.
class Person {
    String name;
    int age;

    // 생성자: Person 객체가 처음 만들어질 때 이름과 나이를 받아서 초기화하는 역할을 해요.
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 자기소개 기능(메서드)도 만들어 줍시다.
    public void introduce() {
        System.out.printf("안녕하세요, 제 이름은 %s이고 나이는 %d살입니다.\n", name, age);
    }

    // Java 선생님의 추가 팁!
    // 그냥 객체를 출력하면 "Person@1f32e575" 같은 이상한 값이 나와요.
    // 객체를 출력할 때 이름과 나이가 예쁘게 나오게 하려면 toString() 메서드를 오버라이드(재정의)해주면 좋아요.
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class _09_ArrayList {
    public static void main(String[] args) {
        // 이제, String을 담는 리스트가 아닌, Person 객체를 담는 리스트를 만들어 볼게요.
        // 제네릭(<>) 안에 우리가 만든 Person 클래스를 쏙 넣어주면 끝! 정말 간단하죠?
        List<Person> people = new ArrayList<>();

        System.out.println("--- 명단에 사람 추가 ---");
        // 리스트에 Person 객체를 생성해서 바로 추가합니다.
        people.add(new Person("철수", 23));
        people.add(new Person("영희", 31));
        people.add(new Person("민수", 26));
        people.add(new Person("영수", 19));
        people.add(new Person("민희", 43));

        // toString()을 오버라이드했기 때문에, 리스트를 그냥 출력해도 내용이 예쁘게 보입니다.
        System.out.println("전체 명단: " + people);

        System.out.println("\n--- 모든 사람 자기소개 시작! ---");
        // 향상된 for문을 사용해서 리스트에 있는 Person 객체를 한 명씩 꺼내옵니다.
        for (Person p : people) {
            // p는 이제 단순한 숫자나 문자열이 아니라, name과 age를 모두 가진 'Person' 객체입니다.
            // 그래서 Person 클래스 안에 만들어 둔 introduce() 메서드를 바로 호출할 수 있죠.
            p.introduce();
        }

        /*
         * Java 선생님 최종 정리:
         * ArrayList와 같은 컬렉션에는 우리가 원하는 어떤 형태의 객체든 담을 수 있습니다.
         * 이렇게 여러 데이터를 묶은 객체를 리스트로 관리하는 것은,
         * 학생 명단, 상품 목록, 게임 캐릭터 목록 등 현실 세계의 데이터를 다루는 모든 프로그램의 기본이 됩니다.
         * 이 구조를 잘 이해해두는 것이 정말 중요해요!
         */
    }
}