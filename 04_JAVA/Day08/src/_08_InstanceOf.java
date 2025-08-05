class Animal3 {}
class Pig3 extends Animal3 {}

public class _08_InstanceOf {
    public static void main(String[] args) {
        Pig3 pig3 = new Pig3();
        Pig3 pig4 = new Pig3();
        Animal3 animal = pig3;

        if (animal instanceof Pig3) {
            System.out.println("객체 변수 animal은 Pig3 타입으로 생성된 객체입니다.");
        } /**
         * animal은 Pig3로 생성된 객체를 참조하고 있는 Animal3 타입의 객체 변수이다.
         * animal instanceof Pig3 --- 객체변수 animal이 객체타입 Pig3로 생성된 것인지 확인.
         * */

        if (animal == pig3) {
            System.out.println("객체 변수 animal과 pig3는 같은 객체를 참조하고 있습니다.");
        } // ==는 주소가 같은지 아닌지 판단하는 것이므로, pig3와 animal은 같은 주소값을 가지고 있다.

        if (animal != pig4) {
            System.out.println("animal과 pig4는 같은 객체를 참조하고 있지 않습니다.");
        } // 하지만 animal과 pig4는 연결이 되어있는 객체가 아니기 때문에 같은 주소값을 가지고 있지 않다.
    }
}
