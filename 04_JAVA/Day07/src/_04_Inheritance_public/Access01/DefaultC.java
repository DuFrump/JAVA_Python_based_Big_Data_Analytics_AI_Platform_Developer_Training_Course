package _04_Inheritance_public.Access01;

// DefaultC 클래스는 접근 제어자를 명시하지 않았으므로 `default` (package-private) 접근 제어자를 가집니다.
// `default` 클래스는 동일 패키지(`_04_Inheritance_public.Access01`) 내에서만 접근 가능합니다.
// 다른 패키지에서는 이 클래스를 import하거나 사용할 수 없습니다.
class DefaultC {
    // `public` 필드: 클래스 자체는 default이지만, 필드는 public이므로
    // 동일 패키지 내에서는 어디서든 접근 가능합니다.
    public int variableC;
}
