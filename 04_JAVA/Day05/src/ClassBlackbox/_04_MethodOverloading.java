package ClassBlackbox;

/**
 * 두프룸프님, 이번에는 '메소드 오버로딩(Method Overloading)'이라는 재미있는 개념을 배워볼게요.
 *
 * 오버로딩(Overloading)은 '과적하다'라는 뜻인데, 여기서는 "하나의 메소드 이름에 여러 기능을 싣는다"라고 이해하면 쉬워요.
 * 즉, 메소드의 이름은 똑같이 유지하면서, 괄호 안에 들어가는 전달값(파라미터)의 개수나 타입을 다르게 해서
 * 여러 버전의 메소드를 만드는 것을 말합니다.
 *
 * 왜 이런 기능이 필요할까요?
 * 사용하는 사람이 다양한 상황에 맞춰 편리하게 메소드를 호출할 수 있도록 도와주기 위해서예요.
 * 예를 들어, "녹화"라는 같은 기능을 사용하더라도, 상세 옵션을 다 주고 싶을 때도 있고, 그냥 기본값으로 편하게 쓰고 싶을 때도 있잖아요?
 * 그 모든 경우를 똑같은 `record()` 라는 이름으로 처리할 수 있게 해준답니다.
 */
public class _04_MethodOverloading {
    public static void main(String[] args) {
        BlackBox b1 = new BlackBox();
        b1.modelName = "까망이";

        // BlackBox.java 설계도에는 record() 라는 이름의 메소드가 두 개 정의되어 있어요.
        // 1. record(boolean showDateTime, boolean showSpeed, int min)
        // 2. record()
        // 자바는 우리가 메소드를 호출할 때 괄호 안에 어떤 값들을 넣어주는지를 보고,
        // 둘 중에 어떤 record() 메소드를 실행해야 할지 똑똑하게 구분한답니다.

        System.out.println("--- 상세 옵션을 모두 지정하여 녹화 ---");
        // 날짜 표시(false), 속도 표시(false), 1분 단위로 녹화
        b1.record(false, false, 1);

        System.out.println("\n--- 일부 옵션만 변경하여 녹화 ---");
        // 날짜 표시(true), 속도 표시(false), 10분 단위로 녹화
        b1.record(true, false, 10);

        System.out.println("\n--- 모든 옵션을 켜고 녹화 ---");
        // 날짜 표시(true), 속도 표시(true), 3분 단위로 녹화
        b1.record(true, true, 3);

        System.out.println("\n--- 기본값으로 녹화 ---");
        // 괄호 안에 아무것도 넣어주지 않으면, BlackBox.java에 정의된 record() 메소드가 호출됩니다.
        // 이 메소드는 내부적으로 record(true, true, 5)를 다시 호출해서
        // 결국 날짜/속도 표시를 켜고 5분 단위로 녹화하는 기본 동작을 수행하게 돼요. 정말 편리하죠?
        b1.record();

        /*
        [선생님 TIP]
        메소드 오버로딩은 사용하는 사람의 편의성을 크게 높여주는 기능이에요.
        개발자는 다양한 경우의 수를 미리 대비해서 여러 버전의 메소드를 만들어두고,
        사용자는 그저 원하는 만큼의 정보만 전달해서 같은 이름의 메소드를 호출하면 되니까요!
        */
    }
}