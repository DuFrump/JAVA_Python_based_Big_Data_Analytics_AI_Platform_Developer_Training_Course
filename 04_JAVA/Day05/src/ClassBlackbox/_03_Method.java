package ClassBlackbox;

/**
 * 두프룸프님, 이번에는 객체의 '행동'을 정의하는 '메소드(Method)'에 대해 배워볼게요.
 *
 * 지금까지는 블랙박스 객체의 데이터(모델명, 가격 등)를 직접 설정하고 읽어왔죠?
 * 메소드는 이 객체가 스스로 할 수 있는 '동작'이나 '기능'을 만들어주는 역할을 해요.
 * 예를 들어 "자동으로 신고해라!", "메모리 카드를 삽입해라!", "녹화된 영상 개수를 알려줘!" 같은 것들이죠.
 *
 * 클래스(설계도)에 이런 메소드들을 미리 잘 만들어두면, 우리는 객체를 사용할 때
 * 그 객체가 어떤 복잡한 과정을 거쳐 동작하는지 몰라도, 단순히 메소드 이름만 불러서
 * 원하는 기능을 쉽고 안전하게 사용할 수 있답니다.
 */
public class _03_Method {
    public static void main(String[] args) {
        BlackBox b1 = new BlackBox();
        b1.modelName = "까망이";

        // [1] 반환값이 없는(void) 메소드 호출
        // BlackBox.java에 정의된 autoReport() 라는 메소드를 호출(call)해 볼게요.
        // 이 메소드는 "자동 신고 기능이 켜져 있으면 신고 문구를 출력하고, 꺼져 있으면 다른 문구를 출력"하는 동작을 합니다.

        // 처음에는 static 변수인 conAutoReport가 false(기능 꺼짐) 상태일 거예요.
        System.out.println("\n--- 자동 신고 기능 테스트 ---");
        b1.autoReport(); // "자동신고 기능이 없구먼유." 라고 출력될 거예요.

        // 이제 모든 블랙박스의 자동 신고 기능을 켜봅시다.
        BlackBox.conAutoReport = true;

        // 다시 한 번 autoReport() 메소드를 호출하면? 이젠 기능이 켜졌으니 다른 결과가 나오겠죠!
        b1.autoReport(); // "충돌이 감지되어 자동으로 신고합니다." 라고 출력될 거예요.

        System.out.println("\n--- 메모리 카드 삽입 테스트 ---");
        // [2] 값을 전달해야 하는(파라미터가 있는) 메소드 호출
        // insertMemoryCard() 메소드는 삽입할 메모리 카드의 용량(capacity)을 알려줘야 해요.
        // 괄호 안에 숫자 128을 넣어주면, 이 값이 메소드로 전달됩니다.
        b1.insertMemoryCard(128);

        System.out.println("\n--- 영상 파일 개수 확인 테스트 ---");
        // [3] 처리 결과를 돌려주는(반환값이 있는) 메소드 호출
        // getVideoFileCount() 메소드는 영상 종류(type)를 알려주면, 그 종류에 해당하는 파일 개수를 '알려주는'(반환하는) 기능을 해요.
        // 1은 일반 영상, 2는 이벤트(충격) 영상을 의미한다고 약속했어요.

        // b1.getVideoFileCount(1)을 실행하면, 메소드가 계산한 결과(숫자 9)를 우리에게 돌려줍니다.
        // 우리는 그 돌아온 값을 fileCount 라는 정수 변수에 저장해서 사용할 수 있어요.
        int fileCount = b1.getVideoFileCount(1);
        System.out.println("일반 영상 파일 수: " + fileCount + "개");

        // 이번에는 이벤트 영상(2)의 개수를 물어볼까요?
        fileCount = b1.getVideoFileCount(2);
        System.out.println("이벤트 영상 파일 수: " + fileCount + "개");
    }
}