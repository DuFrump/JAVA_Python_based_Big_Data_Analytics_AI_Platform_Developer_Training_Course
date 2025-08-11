package _04_Inheritance_public.Access01;

/**
 * DefaultC 클래스는 클래스 선언 앞에 'public'이나 다른 접근 제어자가 붙어있지 않죠?
 * 이렇게 아무것도 명시하지 않으면, 이 클래스는 'default' (또는 package-private) 접근 제어자를 가집니다.
 *
 * 'default' 접근 제어자의 의미는 다음과 같아요:
 * - 같은 패키지(_04_Inheritance_public.Access01) 내의 다른 클래스에서는 이 DefaultC 클래스를 자유롭게 사용할 수 있습니다.
 * - 하지만 다른 패키지에서는 이 DefaultC 클래스를 import하거나 사용할 수 없습니다.
 *   마치 '우리 동네 사람들만 들어올 수 있는 가게'와 같다고 생각하면 됩니다.
 *
 * 이 예제를 통해 클래스 자체에도 접근 제어자가 적용된다는 것을 이해할 수 있습니다.
 */
class DefaultC { // 클래스 앞에 아무것도 없으면 default (package-private) 접근 제어자입니다.

    // === 필드 (Fields) ===
    // 클래스 자체는 default 접근이지만, 이 필드는 public으로 선언되었습니다.
    // 따라서 같은 패키지 내에서는 DefaultC 객체를 만들고 이 variableC 필드에 접근할 수 있습니다.
    // 다른 패키지에서는 DefaultC 클래스 자체에 접근할 수 없으므로, 이 필드에도 접근할 수 없습니다.
    public int variableC;

    // === 메소드 (Methods) ===
    // default 접근 제어자를 가진 메소드도 추가해볼까요?
    void defaultMethodInDefaultClass() {
        System.out.println("DefaultC 클래스의 default 메소드입니다.");
    }
}