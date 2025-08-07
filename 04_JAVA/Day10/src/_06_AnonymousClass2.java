/**
 * 두프룸프님을 위한 주석 가이드:
 * 이 코드는 '인터페이스'와 '익명 클래스'를 함께 사용하는 실전 예제입니다.
 * "어떤 일이 일어났을 때(이벤트), 어떤 행동을 할지(로직)를 분리"하는 매우 중요한 패턴을 보여줍니다.
 *
 * [비유]
 * buttonClickListener는 '스마트폰 버튼 기능 명세서(규칙)'입니다.
 * Button 클래스는 실제 '물리 버튼 부품'입니다.
 * main 메소드는 '사용자가 버튼의 기능을 설정하고 누르는 과정'입니다.
 * 이 코드는 "버튼을 누르면 어떤 행동을 할지, 그 행동의 내용을 외부에서 정해서 주입"하는 방식입니다.
 */

// [1. 버튼 기능 명세서 (인터페이스)]
// "우리 스마트폰의 버튼에는 'click()'이라는 이름의 기능 하나를 반드시 만들어 넣어야 합니다."
// 라고 정해놓은 '규칙(interface)' 또는 '가이드라인'과 같습니다.
// 이렇게 interface는 "이런 기능을 만들어야 해!" 라고 약속만 정해놓은 껍데기입니다.
interface buttonClickListener {
    void click(); // 버튼을 눌렀을 때 동작할 메소드의 '이름'과 '형식'만 정의합니다.
}

public class _06_AnonymousClass2 {

    // [2. 물리적인 버튼 부품 (내부 클래스)]
    // 실제 '버튼' 부품에 해당합니다.
    public class Button {
        // 버튼 내부에 "어떤 기능을 실행할지" 저장할 수 있는 빈 슬롯(메모리)입니다.
        // '버튼 기능 명세서(buttonClickListener)'를 따르는 기능만 이 슬롯에 장착할 수 있습니다.
        private buttonClickListener listener;

        // 외부에서 만든 '기능'을 전달받아 버튼의 슬롯에 장착하는 메소드입니다.
        // (예: 측면 버튼을 '카메라 켜기' 기능으로 설정하는 과정)
        public void setButtonListener(buttonClickListener listener) {
            this.listener = listener;
        }

        // 사용자가 실제로 버튼을 "딸깍" 누르는 행동입니다.
        public void click() {
            // 버튼에 기능이 장착되어 있다면(null이 아니라면),
            if (listener != null) {
                // 내부에 장착된 그 기능(listener)의 click() 메소드를 실행합니다.
                this.listener.click();
            }
        }
    }

    // [3. 사용자가 스마트폰을 켜서 버튼을 설정하고 누르는 과정]
    public static void main(String[] args) {
        // 1. 버튼 부품을 준비합니다.
        // 사용자가 스마트폰(_06_AnonymousClass2)에서 '측면 버튼(Button)'을 찾아냅니다.
        _06_AnonymousClass2 exam = new _06_AnonymousClass2();
        _06_AnonymousClass2.Button button = exam.new Button();

        // 2. "버튼을 누르면 어떤 동작을 할지" 그 내용을 즉석에서 만듭니다. (핵심!)
        // buttonClickListener라는 '규칙'을 따르는 기능을 이름 없이(Anonymous), 즉석에서 만들어서 버튼에 장착합니다.
        button.setButtonListener(new buttonClickListener() {
            // '규칙'에 따라 click() 메소드의 실제 내용을 채워 넣습니다.
            @Override
            public void click() {
                System.out.println("버튼을 눌렀습니다. 카메라 앱이 실행됩니다.");
            }
        });

        // 3. 실제로 버튼을 누릅니다.
        // 이 코드가 실행되면, 버튼은 내부에 장착된 익명 클래스의 click() 메소드를 실행하여
        // "버튼을 눌렀습니다. 카메라 앱이 실행됩니다."를 화면에 출력하게 됩니다.
        button.click();
    }
}
