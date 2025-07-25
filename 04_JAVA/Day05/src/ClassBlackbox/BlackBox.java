package ClassBlackbox;

public class BlackBox {
    String modelName;
    String resolution;
    int price;
    String color;
    int serialNumber;

    static boolean conAutoReport = false;

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

}
