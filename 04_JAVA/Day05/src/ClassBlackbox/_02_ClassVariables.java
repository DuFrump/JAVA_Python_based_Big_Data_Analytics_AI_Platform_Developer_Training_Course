package ClassBlackbox;

/**
 * 안녕하세요, 두프룸프님. 이번에는 '클래스 변수(Class Variables)'에 대해 알아볼게요.
 * 지난 시간에 배운 '인스턴스 변수'와 비교하면서 들으면 이해가 더 쉬울 거예요.
 *
 * - 인스턴스 변수: 각 객체(제품)마다 별도로 가지는 값. (예: b1의 모델명은 "까망이", b2의 모델명은 "하양이")
 * - 클래스 변수 (static 변수): 모든 객체(제품)가 함께 공유하는 하나의 값. (예: 모든 블랙박스 제품의 자동 신고 기능 ON/OFF 여부)
 *
 * 클래스 변수는 변수 앞에 `static` 이라는 키워드를 붙여서 만들어요.
 * 이 클래스로부터 만들어진 모든 객체들은 이 `static` 변수 값을 함께 사용하고, 함께 영향을 받습니다.
 * 마치 하나의 중앙 서버에서 모든 기기의 설정을 한 번에 바꾸는 것과 비슷해요!
 */
public class _02_ClassVariables {
    public static void main(String[] args) {
        // 이전처럼 블랙박스 객체(제품)를 두 개 만들어 볼게요.
        BlackBox b1 = new BlackBox();
        b1.modelName = "까망이";

        BlackBox b2 = new BlackBox();
        b2.modelName = "하양이";

        // 현재 "자동 신고 기능"이 개발되기 전이라고 상상해 봅시다.
        // BlackBox.java 설계도에 `static boolean conAutoReport = false;` 라고 되어있을 거예요.
        // `static` 변수는 모든 객체가 공유하므로, b1과 b2 모두 이 기능이 꺼져(false) 있습니다.
        System.out.println("--- 기능 개발 전 ---");
        System.out.println(b1.modelName + " 자동 신고 기능: " + b1.conAutoReport); // b1을 통해 확인
        System.out.println(b2.modelName + " 자동 신고 기능: " + b2.conAutoReport); // b2를 통해 확인

        // [선생님 TIP] static 변수는 특정 객체에 속한 것이 아니라 클래스 전체에 속한 것이므로,
        // b1.conAutoReport 처럼 객체 이름을 통해 접근하는 것보다
        // BlackBox.conAutoReport 처럼 클래스 이름을 직접 사용해서 접근하는 것이 더 바람직한 코드 스타일입니다!
        System.out.println("모든 블랙박스 제품의 자동 신고 기능: " + BlackBox.conAutoReport + "\n");

        // 드디어! 우리 회사가 자동 신고 기능을 개발 완료했습니다!
        // 이제 모든 블랙박스 제품에 이 기능을 켜줘야겠죠?
        // 클래스 변수인 conAutoReport 값을 true로 딱 한 번만 바꿔주면...
        BlackBox.conAutoReport = true;

        // ...이 클래스로 만든 모든 객체(b1, b2, 그리고 앞으로 만들 모든 BlackBox 객체)에
        // 이 변경사항이 즉시 적용됩니다. 정말 편리하죠?
        System.out.println("--- 기능 개발 후 ---");
        System.out.println(b1.modelName + " 자동 신고 기능: " + b1.conAutoReport); // b1도 ON
        System.out.println(b2.modelName + " 자동 신고 기능: " + b2.conAutoReport); // b2도 ON
        System.out.println("모든 블랙박스 제품의 자동 신고 기능: " + BlackBox.conAutoReport);
    }
}