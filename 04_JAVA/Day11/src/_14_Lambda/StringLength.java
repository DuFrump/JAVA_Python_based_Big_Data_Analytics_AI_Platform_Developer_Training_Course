package _14_Lambda;

/**
 * Java 선생님:
 * 이 인터페이스는 "어떤 객체(String s)를 받아서, 그것을 다른 형태의 값(int)으로 변환하여 반환하는"
 * 형태의 기능을 위한 '틀'입니다.
 *
 * 예를 들어, "문자열(String)을 받아서 그 길이(int)를 반환하기",
 * "학생(Student) 객체를 받아서 점수(int)를 반환하기",
 * "파일(File) 객체를 받아서 파일 크기(int)를 반환하기" 와 같은 모든 변환 기능이 이 형태로 표현될 수 있습니다.
 *
 * 이렇게 "입력 A를 출력 B로 맵핑(mapping) 또는 변환(transform)하는" 함수를 프로그래밍에서는
 * **'Function(함수)'**이라고 부릅니다. 가장 보편적인 형태의 함수이죠.
 * 이 Function은 나중에 배울 스트림(Stream)의 map() 메서드에서 핵심적인 역할을 담당합니다.
 * "A의 흐름을 B의 흐름으로 바꿔줘!" 라고 할 때 바로 이 Function을 사용하는 거죠.
 * (예: 학생 객체의 스트림 -> 학생 이름(String)의 스트림으로 변환)
 *
 * Java에서 기본으로 제공하는 `Function<T, R>` 인터페이스가 이와 똑같은 역할을 합니다.
 * (T 타입을 받아 R 타입을 반환)
 */
@FunctionalInterface
public interface StringLength {
    int getLength(String s);
}