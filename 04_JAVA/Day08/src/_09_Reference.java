/**
 * 안녕하세요, 두프룸프님!
 * 오늘은 자바 프로그래밍의 아주 중요한 개념인 '기본 자료형(Primitive Type)'과 '참조 자료형(Reference Type)'에 대해 함께 알아볼 거예요.
 * 이 두 가지는 데이터를 저장하고 다루는 방식이 완전히 다르기 때문에, 이 차이를 명확히 이해하는 것이 자바를 마스터하는 첫걸음이랍니다.
 * 특히 변수에 값을 할당하거나 메소드에 전달할 때 어떤 일이 일어나는지 집중해서 살펴볼게요.
 *
 * 이 예제에서는 다음을 중점적으로 살펴볼 거예요:
 * 1. 기본 자료형의 특징과 배열 초기값
 * 2. 참조 자료형의 특징과 배열 초기값
 * 3. 기본 자료형 변수 할당 시 '값 전달 (Call by Value)' 방식
 * 4. 참조 자료형 변수 할당 시 '참조 전달 (Call by Reference)' 방식
 * 5. 메소드 호출 시 참조 자료형 전달 방식
 *
 * 이 개념들을 잘 이해하면 메모리 관리와 객체 지향 프로그래밍에 대한 이해가 훨씬 깊어질 거예요!
 */

// 먼저, 참조 자료형의 예시로 사용할 'Camera' 클래스를 정의해볼까요?
// 이 클래스는 카메라의 '이름'이라는 속성을 가지고 있어요.
class Camera {
    String name; // 카메라의 이름을 저장할 변수

    // 생성자: Camera 객체를 만들 때 이름을 초기화해주는 역할을 해요.
    Camera(String name) {
        this.name = name;
    }
}

public class _09_Reference {
    public static void main(String[] args) {
        // [1] 기본 자료형 (Primitive Type)의 특징과 배열 초기값
        // 기본 자료형은 실제 값(데이터)을 변수 공간에 직접 저장해요.
        // 자바에는 8가지 기본 자료형이 있어요: byte, short, int, long (정수), float, double (실수), char (문자), boolean (논리).
        // 이들은 모두 소문자로 시작하는 것을 볼 수 있죠?
        // 기본 자료형 변수는 null 값을 가질 수 없고, 메소드를 가질 수도 없어요.

        System.out.println("--- 기본 자료형 배열의 초기값 확인 ---");
        // 정수형 배열은 선언만 하면 자동으로 0으로 초기화돼요. 신기하죠?
        int[] i = new int[3];
        System.out.println("int 배열 i[0]: " + i[0]); // 출력: 0
        System.out.println("int 배열 i[1]: " + i[1]); // 출력: 0

        // 실수형 배열은 0.0으로 자동 초기화된답니다.
        double[] d = new double[1];
        System.out.println("double 배열 d[0]: " + d[0]); // 출력: 0.0

        System.out.println("\n----------------------------------------\n");

        // [2] 참조 자료형 (Reference Type)의 특징과 배열 초기값
        // 참조 자료형은 실제 값(객체)이 '힙(Heap)'이라는 특별한 메모리 공간에 저장되고,
        // 변수 공간에는 그 객체의 '메모리 주소(참조값)'만 저장돼요.
        // String, 배열, 그리고 우리가 직접 만든 클래스(예: Camera) 등이 모두 참조 자료형이에요.
        // 이들은 대문자로 시작하는 것을 볼 수 있죠?
        // 참조 자료형 변수는 null 값을 가질 수 있고, 객체가 가진 다양한 메소드를 사용할 수 있어요.

        System.out.println("--- 참조 자료형 배열의 초기값 확인 ---");
        // 참조 자료형 배열은 선언만 하면 자동으로 null로 초기화돼요. '아직 아무것도 참조하고 있지 않다'는 뜻이죠.
        String[] s = new String[3];
        System.out.println("String 배열 s[0]: " + s[0]); // 출력: null

        Camera[] a = new Camera[3];
        System.out.println("Camera 배열 a[0] == null: " + (a[0] == null)); // 출력: true

        System.out.println("\n=================================\n");

        // [3] 기본 자료형 변수 할당 시 '값 전달 (Call by Value)'
        // 기본 자료형 변수를 다른 변수에 할당할 때는 '값' 자체가 복사돼요.
        // 즉, 두 변수는 완전히 독립적인 메모리 공간을 가지게 된답니다.
        int c = 10;
        int b = 20;

        System.out.println("--- 기본 자료형 값 전달 예시 ---");
        System.out.println("초기 c: " + c + ", b: " + b); // 출력: c: 10, b: 20

        b = c; // c의 값(10)이 b에 복사돼요. 이제 b도 10이 되죠.
        System.out.println("b = c 후 c: " + c + ", b: " + b); // 출력: c: 10, b: 10

        b = 30; // b의 값을 30으로 변경해도 c에는 아무런 영향이 없어요. 왜냐하면 독립적이니까요!
        System.out.println("b = 30 후 c: " + c + ", b: " + b); // 출력: c: 10, b: 30

        c = 40; // 마찬가지로 c의 값을 변경해도 b에는 영향이 없어요.
        System.out.println("c = 40 후 c: " + c + ", b: " + b); // 출력: c: 40, b: 30

        System.out.println("\n=================================\n");

        // [4] 참조 자료형 변수 할당 시 '참조 전달 (Call by Reference)'
        // 참조 자료형 변수를 다른 변수에 할당할 때는 '객체의 주소(참조값)'가 복사돼요.
        // 그래서 두 변수는 '같은 객체'를 가리키게 된답니다. 마치 하나의 리모컨으로 같은 TV를 조작하는 것과 같아요.
        Camera c1 = new Camera("카메라1"); // 새로운 Camera 객체 생성
        Camera c2 = new Camera("카메라2"); // 또 다른 Camera 객체 생성

        System.out.println("--- 참조 자료형 참조 전달 예시 ---");
        System.out.println("초기 c1.name: " + c1.name + ", c2.name: " + c2.name); // 출력: c1.name: 카메라1, c2.name: 카메라2

        c1 = c2; // c1이 c2가 참조하는 객체(카메라2)를 참조하게 돼요. 원래 c1이 참조하던 객체(카메라1)는 이제 아무도 참조하지 않게 되죠.
        System.out.println("c1 = c2 후 c1.name: " + c1.name + ", c2.name: " + c2.name); // 출력: c1.name: 카메라2, c2.name: 카메라2

        c2.name = "고장난 카메라"; // c2가 참조하는 객체의 이름을 변경해볼까요?
        System.out.println("c2.name 변경 후 c1.name: " + c1.name + ", c2.name: " + c2.name); // 출력: c1.name: 고장난 카메라, c2.name: 고장난 카메라
        // 설명: c1과 c2가 같은 객체를 참조하고 있기 때문에, c2를 통해 객체의 내용을 변경하면 c1을 통해서도 변경된 내용이 보이는 거예요!

        System.out.println("\n=================================\n");

        // [5] 메소드 호출 시 참조 자료형 전달 (Call by Reference)'
        // 메소드에 참조 자료형 변수를 전달할 때도 마찬가지로 '객체의 주소(참조값)'가 복사되어 전달돼요.
        // 따라서 메소드 안에서 객체의 내용을 변경하면, 원본 객체의 내용도 함께 변경된답니다.
        System.out.println("--- 메소드 호출 시 참조 전달 예시 ---");
        System.out.println("메소드 호출 전 c2.name: " + c2.name); // 출력: 고장난 카메라
        changeName(c2); // c2가 참조하는 객체의 주소를 changeName 메소드에 전달
        System.out.println("메소드 호출 후 c2.name: " + c2.name); // 출력: 잘못된 카메라
        System.out.println("메소드 호출 후 c1.name: " + c1.name); // 출력: 잘못된 카메라 (c1과 c2는 여전히 같은 객체를 참조하고 있어요!)
    }

    // 메소드: Camera 객체의 이름을 변경하는 역할을 해요.
    // 이 메소드는 Camera 객체의 '참조값'을 매개변수로 받기 때문에,
    // 메소드 내부에서 객체의 속성(name)을 변경하면 원본 객체에도 그 변경이 반영된답니다.
    public static void changeName(Camera camera) {
        camera.name = "잘못된 카메라";
    }
}
