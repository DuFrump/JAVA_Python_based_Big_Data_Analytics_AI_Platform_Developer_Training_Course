package _14_Lambda;

/**
 * Java 선생님:
 * 이 인터페이스는 "두 개의 정수(int a, int b)를 받아서, 연산 후 하나의 정수(int)를 반환하는"
 * 형태의 기능을 위한 '틀'입니다.
 *
 * 덧셈, 뺄셈, 곱셈 등 두 개의 입력으로 하나의 결과를 만들어내는 모든 연산이
 * 이 Calculator 인터페이스의 형태, 즉 람다식으로 표현될 수 있습니다.
 *
 * Java에서 기본으로 제공하는 함수형 인터페이스 중에는
 * `BiFunction<T, U, R>` 가 이와 유사한 역할을 합니다.
 * (T, U 타입 두 개를 받아 R 타입을 반환)
 */
@FunctionalInterface
public interface Calculator {
    int compute(int a, int b);
}