package ClassBlackbox;

public class BlackBox {
    String modelName;
    String resolution;
    int price;
    String color;
    int serialNumber;

    static int counter = 0;
    static boolean conAutoReport = false;

    BlackBox () {
        System.out.println("기본 모델 출고");
        this.serialNumber = ++counter;
        System.out.printf("시리얼 넘버 발급 완료 : %d%n", this.serialNumber);
    }

    BlackBox(String modelName, String resolution, int price, String color) {
        this();

        this.modelName = modelName;
        this.serialNumber = serialNumber;
        this.resolution = resolution;
        this.price = price;
        this.color = color;
    }

    void autoReport() {
        if (conAutoReport) {
            System.out.println("충돌이 감지되어 자동으로 신고합니다.");
        } else {
            System.out.println("자동신고 기능이 없구먼유.");
        }
    }

    void insertMemoryCard(int capacity) {
        System.out.println("메모리 카드가 삽입되었습니다");
        System.out.println("용량은 " + capacity + "GB 입니다.");
    }

    int getVideoFileCount(int type) {
        if (type == 1 ) {
            return 9;
        } else if (type == 2) {
            return 1;
        }
        return 10;
    }

    void record(boolean showDateTime, boolean showSpeed, int min) {
        System.out.println("녹화를 시작합니다.");

        if (showDateTime) {
            System.out.println("영상의 날짜 정보가 표시됩니다.");
        }

        if (showSpeed) {
            System.out.println("영상의 속도 정보가 표시됩니다.");
        }

        System.out.printf("영상은 %d분 단위로 표시됩니다.%n", min);
    }

    void record() {
        System.out.println("입력된 값이 없으므로, 기본값으로 설정됩니다.");
        record(true,true,5);
    }

    // 스테틱 메서드 안에서는 스테틱 필드만 사용 가능
    static void callServiceCentre() {
        System.out.println("서비스 센터로 연결해 드리겠습니다. (1234-0000)");
        conAutoReport = false;
    }

    void appendModelName(String a) {
        this.modelName += a;

        System.out.println(modelName);
    }

    // 게터 / 세터
    String getModelName() { return modelName; }
    void setModelName(String modelName) { this.modelName = modelName; }

    String getResolution() {
        if (resolution == null || resolution.isEmpty()) {
            return "판매자에게 문의하십시오.";
        }

        return resolution;
    }
    void setResolution(String resolution) { this.resolution = resolution; }


    // 프라이스 게터/세터
    int getPrice() {
        if (price < 100000) {
            return 100000;
        }

        return price;
    }
    void setPrice(int price) { this.price = price; }

}
