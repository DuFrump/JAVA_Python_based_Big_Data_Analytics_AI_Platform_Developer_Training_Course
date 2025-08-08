import java.util.ArrayList;
import java.util.List;

// 학생의 이름(name)과 수강 과목(subject) 정보를 담는 Student 클래스입니다.
class Student {
    String name;
    String subject;

    Student(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    void introduce() {
        System.out.printf("이름: %s, 수강 과목: %s\n", name, subject);
    }
}

/**
 * Java 선생님:
 * 두프룸프님, 지금까지 배운 내용을 바탕으로 재미있는 퀴즈를 풀어볼 시간이에요.
 * "학생 명단(ArrayList)에서, '자바' 과목을 수강하는 학생들의 이름만 모두 출력하기!"
 * 이게 오늘의 문제입니다. 어떻게 해결할 수 있을지 함께 고민해 봅시다.
 */
public class _10_Quiz_ArrayList {
    public static void main(String[] args) {
        // 먼저, Student 객체를 담을 수 있는 ArrayList를 준비합니다.
        List<Student> list = new ArrayList<>();

        // 학생 데이터를 추가합니다.
        list.add(new Student("가나나", "자바"));
        list.add(new Student("박디도", "파이썬"));
        list.add(new Student("이삭", "C++"));
        list.add(new Student("황금별", "파이썬"));
        list.add(new Student("예만해", "자바"));
        list.add(new Student("엄청나", "C"));
        list.add(new Student("김보나벤투라", "파이썬"));
        list.add(new Student("윤동주", "자바"));

        System.out.println("--- 전체 학생 명단 ---");
        // for-each문을 사용해 전체 학생 정보를 먼저 확인해볼까요?
        for (Student s : list) {
            s.introduce();
        }

        System.out.println("\n--- [퀴즈 풀이] 자바 수강생 찾기 ---");

        // [풀이 전략]
        // 1. 학생 명단(list)을 처음부터 끝까지 한 명씩 확인한다. (for-each 문 사용)
        // 2. 각 학생(s)의 수강 과목(s.subject)이 "자바"와 일치하는지 확인한다. (if 문 사용)
        // 3. 만약 일치한다면, 그 학생의 이름(s.name)을 출력한다.

        // 풀이 1: for-each와 if문 사용
        System.out.println("\n[방법 1] for-each와 if문 사용");
        System.out.println("자바를 배운 학생 목록:");
        for (Student s : list) {
            // Java 선생님의 ★매우 중요한 팁★
            // 문자열의 내용이 같은지 비교할 때는 등호(==)를 쓰면 절대 안 돼요!
            // == 는 "두 변수가 똑같은 메모리 주소에 있는 객체를 가리키나?"를 비교하는 연산자입니다.
            // 내용이 같더라도 서로 다른 객체일 수 있기 때문에, 반드시 .equals() 메서드를 사용해야 합니다.
            if (s.subject.equals("자바")) {
                System.out.println("- " + s.name);
            }
        }

        // 풀이 2: 스트림 API 사용 (데이터/AI 전문가를 위한 방법!)
        // 이 방법이 훨씬 간결하고, 데이터가 많아졌을 때의 성능 관리에도 유리합니다.
        System.out.println("\n[방법 2] 스트림 API 사용");
        System.out.println("자바를 배운 학생 목록:");
        list.stream() // 1. 학생 명단 리스트를 데이터의 흐름(Stream)으로 변환
            .filter(s -> s.subject.equals("자바")) // 2. 수강 과목이 "자바"인 학생만 남도록 필터링
            .forEach(s -> System.out.println("- " + s.name)); // 3. 필터링된 학생들의 이름을 출력

        /*
         * Java 선생님 최종 정리:
         * 이 퀴즈는 컬렉션에서 원하는 데이터를 '필터링'하는 가장 대표적인 예시입니다.
         * 앞으로 두프룸프님이 다루게 될 수많은 데이터 속에서 의미 있는 정보를 찾아내는 작업의
         * 가장 기초적인 형태라고 할 수 있죠. 두 가지 방법 모두 꼭 이해하고 넘어가세요!
         */
    }
}