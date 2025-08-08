import java.util.ArrayList;

// Student 클래스
class Student {
    String name;
    String subject;

    Student(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    void introduce() {
        System.out.printf("이름 : %s, 배운 과목 : %s%n", name, subject);
    }
}

public class _10_Quiz_ArrayList {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("가나나", "자바"));
        list.add(new Student("박디도", "파이썬"));
        list.add(new Student("이삭", "C++"));
        list.add(new Student("황금별", "파이썬"));
        list.add(new Student("예만해", "자바"));
        list.add(new Student("엄청나", "C"));
        list.add(new Student("김보나벤투라", "파이썬"));
        list.add(new Student("윤동주", "자바"));

        // for 문 돌리기.
        for (Student s : list) {
            s.introduce();
        }

        System.out.println("-------------------------");

        // equals 사용 -> 자바를 배운 학생 이름만 뽑기
        for (Student s : list) {
            if (s.subject.equals("자바")) {
                System.out.println("자바를 배운 학생 목록 : " + s.name);
            }
        }
    }
}
