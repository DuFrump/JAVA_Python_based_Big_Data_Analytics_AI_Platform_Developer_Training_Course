package ClassBlackbox;

/**
 * 안녕하세요, 두프룸프님! 이 파일은 우리가 지금까지 배운 모든 객체 지향 개념의 집합체,
 * 바로 '블랙박스'를 만드는 상세한 설계도(클래스)입니다.
 *
 * 이 설계도 안에는 제품의 특징을 나타내는 변수들과, 제품이 할 수 있는 다양한 기능(메소드)들이 정의되어 있어요.
 * 이 파일 하나를 잘 이해하면, 클래스를 어떻게 만들고 활용하는지에 대한 전체적인 그림을 그릴 수 있을 거예요.
 * 각 부분이 어떤 역할을 하는지, 주석을 따라 차근차근 살펴보세요!
 */
public class BlackBox {
    // === 필드 (Fields) 또는 멤버 변수 (Member Variables) ===
    // 이 클래스로부터 만들어지는 모든 객체(제품)들이 갖게 될 데이터의 종류를 정의합니다.

    // [1] 인스턴스 변수 (Instance Variables)
    //  - 객체마다 고유한 값을 가지는 변수들입니다.
    //  - 예: b1의 모델명은 "까망이", b2의 모델명은 "하양이"처럼 각기 다른 값을 가질 수 있어요.
    String modelName;  // 모델명
    String resolution; // 해상도
    int price;         // 가격
    String color;      // 색상
    int serialNumber;  // 시리얼 번호 (고유 번호)

    // [2] 클래스 변수 (Class Variables 또는 static Variables)
    //  - `static` 키워드가 붙어있으며, 이 클래스로 만든 모든 객체들이 '공유'하는 단 하나의 변수입니다.
    //  - 예: 모든 블랙박스 제품에 적용되는 공통 설정 값 등에 사용됩니다.
    static int counter = 0; // 생성된 제품의 수를 세기 위한 카운터. 모든 객체가 이 값을 공유해요.
    static boolean canAutoReport = false; // 자동 신고 기능 ON/OFF 여부. 모든 객체에 동일하게 적용돼요.

    // === 생성자 (Constructors) ===
    // `new BlackBox()` 처럼 객체를 생성할 때, 자동으로 호출되어 초기화 작업을 수행합니다.

    // [1] 기본 생성자 (파라미터가 없는 생성자)
    //  - 객체가 생성될 때 가장 기본적인 초기화 작업을 담당해요.
    BlackBox() {
        System.out.println("기본 생성자 호출: 새로운 제품을 준비합니다.");
        // `this`는 '이 객체'를 의미해요. 즉, "이 객체의 시리얼 번호"를 설정하겠다는 뜻입니다.
        // ++counter는 static 변수인 counter 값을 1 증가시킨 후, 그 값을 사용하라는 의미입니다.
        this.serialNumber = ++counter;
        System.out.println("새로운 시리얼 번호가 발급되었습니다: " + this.serialNumber);
    }

    // [2] 오버로딩된 생성자 (파라미터가 있는 생성자)
    //  - 객체를 만들 때부터 필요한 모든 정보를 전달받아, 한 번에 완제품을 만들고 싶을 때 사용해요.
    BlackBox(String modelName, String resolution, int price, String color) {
        // `this()`는 이 클래스의 다른 생성자(여기서는 기본 생성자)를 먼저 호출하라는 의미예요.
        // 따라서 시리얼 번호를 발급하는 작업이 먼저 수행되고, 그 다음에 아래 코드들이 실행됩니다.
        this();

        System.out.println("사용자 정의 생성자 호출: 전달받은 값으로 제품을 설정합니다.");
        // `this.modelName`은 이 객체의 인스턴스 변수를, 그냥 `modelName`은 파라미터로 전달된 값을 의미해요.
        // `this`를 통해 둘을 명확히 구분해줍니다.
        this.modelName = modelName;
        this.resolution = resolution;
        this.price = price;
        this.color = color;
    }

    // === 메소드 (Methods) ===
    // 객체가 수행할 수 있는 다양한 동작(기능)들을 정의합니다.

    // [1] 클래스 메소드 (static Method)
    //  - 객체를 만들지 않고도 `클래스이름.메소드이름()`으로 바로 호출할 수 있는 공통 기능입니다.
    //  - static 메소드 안에서는 static 변수만 사용할 수 있다는 점을 꼭 기억하세요!
    static void callServiceCenter() {
        System.out.println("서비스 센터(1588-0000)로 연결합니다.");
        // canAutoReport = false; // static 메소드에서 static 변수 접근 가능
        // modelName = "test"; // Error: static 메소드에서 인스턴스 변수 접근 불가
    }

    // [2] 인스턴스 메소드
    //  - 반드시 객체를 생성한 후에, `객체이름.메소드이름()`으로 호출해야 하는 기능입니다.
    //  - 해당 객체의 인스턴스 변수들을 마음껏 사용할 수 있어요.
    void autoReport() {
        if (canAutoReport) { // static 변수는 인스턴스 메소드에서도 물론 사용 가능해요.
            System.out.println("충돌이 감지되어 자동으로 신고합니다.");
        } else {
            System.out.println("자동 신고 기능이 비활성화되어 있습니다.");
        }
    }

    void insertMemoryCard(int capacity) {
        System.out.println("메모리 카드가 삽입되었습니다. 용량: " + capacity + "GB");
    }

    // 값을 반환하는(return) 메소드
    int getVideoFileCount(int type) {
        if (type == 1) { // type 1: 일반 영상
            return 9;
        } else if (type == 2) { // type 2: 이벤트 영상
            return 1;
        }
        return 10; // 일반 영상 + 이벤트 영상
    }

    // [3] 오버로딩된 인스턴스 메소드
    //  - 이름은 같지만 파라미터가 다른 여러 버전의 메소드를 만들 수 있어요.
    void record(boolean showDateTime, boolean showSpeed, int min) {
        System.out.println("녹화를 시작합니다.");
        if (showDateTime) {
            System.out.println("영상에 날짜/시간 정보가 표시됩니다.");
        }
        if (showSpeed) {
            System.out.println("영상에 속도 정보가 표시됩니다.");
        }
        System.out.println("영상은 " + min + "분 단위로 기록됩니다.");
    }

    // 파라미터가 없는 record() 메소드. 사용자의 편의를 위해 기본값을 설정해줘요.
    void record() {
        // 내부적으로 다른 record 메소드를 호출해서 기본 동작을 수행합니다.
        record(true, true, 5);
    }

    // === Getter & Setter ===
    // 캡슐화를 위해, 외부에서 변수에 직접 접근하는 것을 막고
    // 이 메소드들을 통해서만 안전하게 값을 가져가거나(Get) 설정(Set)하도록 합니다.

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getResolution() {
        if (resolution == null || resolution.isEmpty()) {
            return "판매자에게 문의하세요."; // 데이터가 없는 경우, 친절한 안내 메시지 반환
        }
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 100000) {
            this.price = 100000; // 잘못된 가격이 들어오면, 최소 가격 10만원으로 방어
        } else {
            this.price = price;
        }
    }
}