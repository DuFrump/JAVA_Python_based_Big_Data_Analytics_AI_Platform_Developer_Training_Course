package _14_Lambda;

/**
 * Java 선생님:
 * 이 인터페이스는 "어떤 값(int n)을 받아서, 그것이 특정 조건을 만족하는지 여부(boolean)를 반환하는"
 * 형태의 기능을 위한 '틀'입니다.
 *
 * 예를 들어, "n이 짝수인가?", "n이 10보다 큰가?", "n이 소수인가?" 와 같이
 * 질문에 대한 대답이 '예(true)' 또는 '아니오(false)'로 나오는 모든 기능들이 이 형태로 표현될 수 있습니다.
 *
 * 이렇게 무언가를 받아 true/false를 반환하는 함수를 프로그래밍에서는
 * **'Predicate(프레디킷, 서술어)'**이라고 부릅니다. 이름이 멋있죠?
 * 이 Predicate는 나중에 배울 스트림(Stream)의 filter() 메서드에서 핵심적인 역할을 담당합니다.
 * "이 조건을 만족하는 데이터만 남겨줘!" 라고 할 때 바로 이 Predicate를 사용하는 거죠.
 *
 * Java에서 기본으로 제공하는 `Predicate<T>` 인터페이스가 이와 똑같은 역할을 합니다.
 */
@FunctionalInterface
public interface Condition {
    boolean test(int n);
}