package _05_Inheritance_camera;

/**
 * 안녕하세요, 두프룸프님!
 * 이 파일은 'final' 키워드의 모든 것을 한눈에 정리하고 이해하기 위한 특별한 예제입니다.
 * 'final'은 자바에서 '최종적인', '변경 불가능한'이라는 의미를 가지며,
 * 변수(필드), 메소드, 클래스 세 가지 요소에 적용될 수 있습니다.
 * 각각에 적용될 때 어떤 의미를 가지는지 자세히 살펴봅시다!
 */
public class _0805_11_Final {
    public static void main(String[] args) {

        System.out.println("--- [1] final 필드 (변수) 예시 ---");
        // final 필드는 한 번 초기화되면 값을 변경할 수 없는 '상수'가 됩니다.
        // ActionCam 클래스의 LENS 필드가 final로 선언되어 있습니다.
        ActionCam actionCam = new ActionCam();

        // actionCam.LENS는 final 필드이므로 값을 변경하려고 하면 컴파일 에러가 발생합니다.
        // 아래 주석을 해제하면 에러를 확인할 수 있습니다.
        // actionCam.LENS = "표준렌즈"; // 에러: cannot assign a value to final variable LENS
        System.out.println("ActionCam의 렌즈: " + actionCam.LENS); // "광각렌즈" 출력

        // final 필드는 객체마다 다른 값을 가질 수 있지만, 한 번 설정되면 변경 불가합니다.
        // (참고: static final은 모든 객체가 공유하는 단 하나의 상수입니다.)

        System.out.println("\n--- [2] final 메소드 예시 ---");
        // final 메소드는 자식 클래스에서 오버라이딩(재정의)할 수 없습니다.
        // ActionCam 클래스의 makeVideo() 메소드는 final로 선언되어 있습니다.

        // ActionCam 객체에서 makeVideo() 호출
        actionCam.makeVideo(); // "액션 카메라 : 광각렌즈로 촬영한 비디오를 제작" 출력

        // SlowActionCam은 ActionCam을 상속받았지만, makeVideo()를 오버라이딩할 수 없습니다.
        SlowActionCam slowActionCam = new SlowActionCam();
        // SlowActionCam 객체에서 makeVideo() 호출 시, ActionCam의 final makeVideo()가 실행됩니다.
        slowActionCam.makeVideo(); // "액션 카메라 : 광각렌즈로 촬영한 비디오를 제작" 출력

        // 만약 SlowActionCam에서 makeVideo()를 오버라이딩하려고 시도하면 컴파일 에러가 발생합니다.
        // (SlowActionCam.java 파일에서 주석 처리된 부분을 확인해 보세요.)

        System.out.println("\n--- [3] final 클래스 예시 ---");
        // 클래스에 final 키워드를 붙이면 해당 클래스는 더 이상 다른 클래스에게 '상속될 수 없습니다'.
        // 즉, final 클래스는 부모 클래스가 될 수 없습니다.
        // 예시: public final class MyFinalClass { ... }
        //
        // 왜 이런 클래스가 필요할까요?
        // - 보안: 클래스의 핵심 로직이 변경되는 것을 막아 보안을 강화할 수 있습니다.
        // - 일관성: 클래스의 동작이 항상 예측 가능하도록 보장합니다.
        // - 성능: 컴파일러가 최적화하는 데 도움이 될 수 있습니다.
        //
        // 자바의 대표적인 final 클래스: String, Math, Integer 등 래퍼(Wrapper) 클래스들
        // 이 클래스들은 불변(immutable)하며, 상속을 통해 변경되는 것을 막아 안정성을 보장합니다.

        System.out.println("\n--- final 키워드 정리 ---");
        System.out.println("final 필드: 한 번 초기화되면 값 변경 불가 (상수)");
        System.out.println("final 메소드: 자식 클래스에서 오버라이딩 불가");
        System.out.println("final 클래스: 다른 클래스에게 상속 불가");
        System.out.println("final 키워드를 통해 코드의 안정성과 예측 가능성을 높일 수 있습니다!");
    }
}