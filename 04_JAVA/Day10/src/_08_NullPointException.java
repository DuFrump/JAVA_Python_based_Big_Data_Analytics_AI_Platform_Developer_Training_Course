/**
 * 두프룸프님을 위한 주석 가이드:
 * 이 코드는 자바 개발자들이 가장 흔하게 마주치는 런타임 오류 중 하나인
 * 'NullPointerException (널 포인터 예외)'을 보여줍니다.
 *
 * [NullPointerException이란?]
 * 어떤 변수가 '아무것도 가리키고 있지 않은 상태(null)'인데,
 * 마치 무언가를 가리키고 있는 것처럼 그 변수의 멤버(메소드나 필드)에 접근하려고 할 때 발생합니다.
 *
 * [비유]
 * '리모컨'이 있는데, 이 리모컨이 '어떤 TV도 가리키고 있지 않은(null) 상태'라고 상상해 보세요.
 * 그런데 이 리모컨으로 'TV 채널을 바꾸려고(메소드 호출)' 한다면 어떻게 될까요?
 * 당연히 아무 일도 일어나지 않거나, 오류가 발생하겠죠?
 * NullPointerException이 바로 이런 상황입니다. 변수가 객체를 가리키지 않는데,
 * 그 객체의 기능을 사용하려 할 때 발생하는 '길 잃은 리모컨' 오류라고 생각하시면 됩니다.
 */
public class _08_NullPointException {
    public static void main(String[] args) {
        // 1. String 배열 타입의 변수 'strArray'를 선언했지만,
        //    아직 어떤 String 배열 객체도 생성해서 할당하지 않았습니다.
        //    즉, 'strArray'는 현재 'null' 값을 가지고 있습니다.
        //    (마치 TV를 가리키지 않는 리모컨과 같습니다.)
        String[] strArray = null;

        // 2. 이제 문제가 발생할 부분입니다.
        //    'strArray'가 null인 상태에서, 마치 유효한 배열 객체인 것처럼
        //    'strArray[0]'와 같이 배열의 첫 번째 요소에 접근하려고 시도합니다.
        //    'null'은 아무것도 가리키지 않으므로, 그 안에 어떤 요소도 있을 수 없습니다.
        //    따라서 이 줄에서 'NullPointerException'이 발생하며 프로그램이 비정상 종료됩니다.
        System.out.println(strArray[0]); // 여기서 NullPointerException 발생!

        // [NullPointerException을 피하는 방법]
        // 1. 변수를 사용하기 전에 반드시 초기화하거나, 유효한 객체를 할당해야 합니다.
        //    예시: String[] strArray2 = new String[3]; // 3칸짜리 String 배열 객체 생성
        //          System.out.println(strArray2[0]); // 이제 오류 없이 접근 가능

        // 2. 변수가 null인지 아닌지 미리 확인하는 'null 체크'를 습관화해야 합니다.
        //    예시:
        //    String myString = null;
        //    if (myString != null) { // null이 아닐 때만 안전하게 사용
        //        System.out.println(myString.length());
        //    } else {
        //        System.out.println("myString은 null입니다.");
        //    }
    }
}