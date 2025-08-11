package ClassBlackbox;

/**
 * 두프룸프님, 드디어 객체 지향 프로그래밍(OOP)의 첫걸음을 떼는 시간이네요! 반갑습니다.
 * 이번 시간에는 '클래스'와 '객체', 그리고 '인스턴스 변수'에 대해 배울 거예요.
 *
 * - 클래스(Class): "이런이런 부품과 기능으로 제품을 만드세요"라고 정의해놓은 '설계도'예요. (여기서는 BlackBox.java 파일)
 * - 객체(Object) 또는 인스턴스(Instance): 그 설계도를 바탕으로 실제로 만들어 낸 '제품'을 의미해요. (여기서는 b1)
 * - 인스턴스 변수(Instance Variables): 각 제품마다 가질 수 있는 고유한 특징(값)들을 말해요. (예: 모델명, 가격, 색상 등)
 *
 * 붕어빵 틀(클래스)로 여러 붕어빵(객체)을 찍어내고, 각 붕어빵은 속재료(인스턴스 변수)가 팥이 될 수도, 슈크림이 될 수도 있는 것과 같답니다.
 */
public class _01_InstanceVariables {
    public static void main(String[] args) {
        // BlackBox.java 라는 설계도를 이용해서 첫 번째 블랙박스 제품을 만들어 볼게요.
        // new BlackBox(); -> "BlackBox 설계도 보고 제품 하나 만들어주세요!" 라는 요청입니다.
        // 만들어진 제품은 b1 이라는 이름표를 붙여서 우리가 사용할 수 있도록 합니다.
        BlackBox b1 = new BlackBox();

        // 이제 막 공장에서 나온 b1 제품의 세부 사양을 정해주는 시간이에요.
        // b1 제품의('.') 모델명(modelName)은 "까망이"로 정한다.
        b1.modelName = "까망이";
        // b1 제품의('.') 해상도(resolution)는 "FHD"로 정한다.
        b1.resolution = "FHD";
        // b1 제품의('.') 가격(price)은 200000으로 정한다.
        b1.price = 200000;
        // b1 제품의('.') 색상(color)은 "블랙"으로 정한다.
        b1.color = "블랙";

        // 자, 이제 b1 제품의 정보가 잘 설정되었는지 하나씩 출력해서 확인해 봅시다.
        System.out.println("첫 번째 블랙박스, 모델명: " + b1.modelName);
        System.out.println("해상도: " + b1.resolution);
        System.out.println("가격: " + b1.price + "원");
        System.out.println("색상: " + b1.color);

        System.out.println("\n----------------------------------------\n");

        // 설계도만 있으면 얼마든지 새로운 제품을 만들어 낼 수 있어요!
        // 두 번째 블랙박스 제품 b2를 만들어 볼까요?
        BlackBox b2 = new BlackBox();
        b2.modelName = "하양이";
        b2.resolution = "UHD";
        b2.price = 300000;
        b2.color = "화이트";

        System.out.println("두 번째 블랙박스, 모델명: " + b2.modelName);
        System.out.println("해상도: " + b2.resolution);
        System.out.println("가격: " + b2.price + "원");
        System.out.println("색상: " + b2.color);

        // [선생님 TIP]
        // b1과 b2는 같은 BlackBox 설계도로 만들었지만, 서로 다른 정보를 가진 별개의 제품(객체)이에요.
        // 이것이 바로 객체 지향 프로그래밍의 핵심! 하나의 설계도로 다양한 특징을 가진 여러 객체를 효율적으로 관리할 수 있게 된답니다.
    }
}