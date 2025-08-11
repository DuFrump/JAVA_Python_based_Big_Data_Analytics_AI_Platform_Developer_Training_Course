package game01;

/**
 * 두프룸프님, 드디어 미니 RPG 게임의 시작점, `Main` 클래스입니다!
 * 이 클래스의 역할은 단 하나, 바로 게임의 엔진에 시동을 거는 것이에요.
 *
 * `GameMechanism`이라는 게임의 핵심 장치를 만들고(`new GameMechanism()`),
 * 그 장치의 `start()` 버튼을 눌러서(`game.start()`) 게임을 시작시키는 거죠.
 *
 * 이렇게 `main` 메서드는 프로그램의 전체적인 시작과 끝을 관리하는
 * 가장 중요한 역할을 한답니다.
 */
public class Main {
    /**
     * Java 프로그램이 실행될 때 가장 먼저 호출되는 진입점(Entry Point)
     * @param args 프로그램 실행 시 전달되는 인자들 (지금은 사용하지 않아요)
     */
    public static void main(String[] args) {
        // 1. GameMechanism 객체를 생성합니다.
        //    이 순간 GameMechanism의 생성자가 호출되어
        //    플레이어, 상점, 스캐너 등이 메모리에 준비됩니다.
        GameMechanism game = new GameMechanism();

        // 2. 생성된 game 객체의 start() 메서드를 호출하여 게임을 시작합니다.
        //    이제 프로그램의 제어권은 GameMechanism의 start() 메서드로 넘어가
        //    그 안의 게임 루프가 실행되기 시작합니다.
        game.start();
    }
}