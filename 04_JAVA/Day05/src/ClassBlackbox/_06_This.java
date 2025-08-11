package ClassBlackbox;

/**
 * 두프룸프님, 이번 시간에는 'this' 라는 키워드에 대해 배워볼게요.
 * 'this'는 아주 특별한 키워드로, '바로 이 객체 자신'을 가리키는 리모컨 같은 역할을 해요.
 *
 * 메소드 안에서 코드를 작성하다 보면, 메소드로 전달된 값(파라미터)과
 * 객체가 원래 가지고 있던 값(인스턴스 변수)의 이름이 똑같아서 헷갈리는 경우가 생길 수 있어요.
 * 이럴 때 `this.` 를 앞에 붙여주면 "이건 파라미터가 아니라, 내(객체)가 가진 인스턴스 변수야!" 라고
 * 명확하게 구분해 줄 수 있답니다.
 *
 * 코드를 통해 `this`가 어떻게 쓰이는지 함께 살펴봅시다.
 */
public class _06_This {
    public static void main(String[] args) {
        BlackBox b1 = new BlackBox();
        b1.modelName = "까망이"; // b1 객체의 modelName 인스턴스 변수에 "까망이"를 저장

        // appendModelName 메소드를 호출해서 모델명 뒤에 "(최신버전)" 이라는 글자를 덧붙여 볼게요.
        // BlackBox.java의 appendModelName 메소드를 한 번 볼까요?
        // public void appendModelName(String a) {
        //     this.modelName += a; // -> "이 객체(this)의 모델명(modelName)에 파라미터 a를 더해라"
        // }
        b1.appendModelName("(최신버전)");

        // 최종적으로 b1 객체의 모델명이 어떻게 바뀌었는지 출력해 봅시다.
        System.out.println("최종 모델명: " + b1.modelName);

        /*
        [선생님 TIP - this가 꼭 필요한 순간!]

        사실 위 예제에서는 파라미터 이름이 a 라서 this를 생략하고 그냥 modelName += a; 라고 써도 괜찮아요.
        하지만, 보통은 파라미터 이름과 인스턴스 변수 이름을 똑같이 만드는 경우가 많습니다.
        BlackBox.java의 setModelName 메소드를 예로 들어 볼게요.

        public void setModelName(String modelName) {
            this.modelName = modelName;
        }

        여기서 만약 this를 빼고 `modelName = modelName;` 이라고 썼다면,
        컴퓨터는 "파라미터 modelName에 파라미터 modelName 값을 넣어라" 라는 이상한 명령으로 알아들어요.
        객체의 인스턴스 변수에는 아무런 변화가 없게 되는 거죠.

        `this.modelName = modelName;` 이라고 써야만
        "이 객체의 인스턴스 변수 modelName에 파라미터로 전달된 modelName 값을 저장해라" 라고
        정확하게 명령할 수 있답니다. 그래서 `this`는 꼭 필요한 친구예요!
        */
    }
}