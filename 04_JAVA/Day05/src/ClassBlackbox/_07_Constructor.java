package ClassBlackbox;

/**
 * 두프룸프님, 이번 시간에는 객체 지향 프로그래밍의 꽃! '생성자(Constructor)'에 대해 배울게요.
 *
 * 생성자는 `new` 키워드로 객체(제품)를 생성할 때, 딱 한 번 자동으로 호출되는 특별한 메소드예요.
 * 메소드와 비슷하게 생겼지만, 리턴 타입(void, int 등)이 없고 이름이 반드시 클래스 이름과 똑같아야 한다는 규칙이 있어요.
 *
 * 주된 역할은 객체가 처음 만들어질 때 필요한 값들을 설정(초기화)해주는 것입니다.
 * 예를 들어, 제품의 시리얼 번호를 자동으로 부여하거나, 필수 값들을 미리 설정해두는 중요한 작업을 수행하죠.
 */
public class _07_Constructor {
    public static void main(String[] args) {
        // [1] 기본 생성자 호출
        // `new BlackBox()` 를 호출하면, BlackBox.java에 있는 `BlackBox()` 생성자가 실행됩니다.
        // 이 생성자는 "기본 모델 출고"라는 메시지를 출력하고, static 변수 counter를 1 증가시켜서
        // 새로운 시리얼 번호를 발급해주는 역할을 해요.
        BlackBox b1 = new BlackBox();
        // 생성자가 시리얼 번호는 자동으로 부여했지만, 다른 값들은 아직 비어있어요.
        // 그래서 우리가 직접 값을 넣어줘야 합니다.
        b1.modelName = "까망이";
        b1.resolution = "FHD";
        b1.price = 200000;
        b1.color = "블랙";

        System.out.println(b1.modelName + " (시리얼 번호: " + b1.serialNumber + ")");

        System.out.println("------------------------------------------");

        // new BlackBox()를 호출할 때마다 생성자가 실행되어 counter가 1씩 계속 증가해요.
        BlackBox b2 = new BlackBox(); // serialNumber는 2가 됨
        System.out.println("b2의 시리얼 번호: " + b2.serialNumber);
        BlackBox b3 = new BlackBox(); // serialNumber는 3이 됨
        System.out.println("b3의 시리얼 번호: " + b3.serialNumber);

        System.out.println("------------------------------------------");

        // [2] 파라미터가 있는 생성자 호출 (오버로딩된 생성자)
        // 객체를 만들 때부터 필요한 모든 정보를 전달해서 한 번에 완제품을 만들고 싶을 때 사용해요.
        // 이렇게 하면 객체를 만들고 나서 일일이 값을 설정해 줄 필요가 없어서 훨씬 편리하답니다.
        BlackBox b6 = new BlackBox("핑퐁이", "UHD", 300000, "분홍");

        // BlackBox.java의 해당 생성자를 보면, 내부에서 `this()` 라는 코드를 먼저 호출해요.
        // `this()`는 이 클래스의 다른 생성자(여기서는 기본 생성자)를 호출하라는 의미입니다.
        // 따라서 시리얼 번호를 발급하는 작업이 먼저 수행되고, 그 다음에 전달받은 값들을 설정하게 되죠. (b6의 시리얼 번호는 4가 됩니다)

        System.out.println("모델명: " + b6.modelName);
        System.out.println("해상도: " + b6.resolution);
        System.out.println("가격: " + b6.price);
        System.out.println("색상: " + b6.color);
        System.out.println("시리얼 번호: " + b6.serialNumber);

        System.out.println("\n지금까지 출고된 총 제품 수: " + BlackBox.counter); // static 변수인 counter를 통해 총 몇 개의 객체가 생성되었는지 알 수 있어요.
    }
}