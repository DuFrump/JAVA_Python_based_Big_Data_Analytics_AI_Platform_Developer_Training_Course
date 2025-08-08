/**
 * 변수(Variable)의 선언(declaration)과 할당(assignment)에 대해 배웁니다.
 * 변수는 데이터를 저장하기 위한 메모리 공간에 붙이는 이름입니다.
 * 마치 물건을 담는 상자에 이름표를 붙이는 것과 같습니다.
 */
public class _02_Variable {
    public static void main(String[] args) {

        // --------------- 변수 선언과 할당을 따로 하는 경우 ---------------

        // 1. 변수 선언 (Declaration)
        // - 데이터를 저장할 공간을 메모리에 미리 만드는 과정입니다.
        // - 어떤 종류(타입)의 데이터를 저장할지, 변수 이름은 무엇으로 할지 정합니다.
        // - 형식: [자료형] [변수이름];

        String name;      // 문자열(String) 데이터를 저장할 수 있는 'name'이라는 이름의 상자를 만듭니다.
        int age;          // 정수(int) 데이터를 저장할 수 있는 'age'라는 이름의 상자를 만듭니다.
        char bloodType;   // 문자(char) 하나를 저장할 수 있는 'bloodType'이라는 이름의 상자를 만듭니다.

        // 2. 값 할당 (Assignment)
        // - 선언된 변수(상자)에 실제 데이터를 저장하는 과정입니다. '=' 기호를 사용합니다.
        // - 이 과정을 "초기화(Initialization)"라고도 부릅니다.

        name = "홍길동";   // 'name' 상자에 "홍길동"이라는 문자열을 넣습니다.
        age = 20;         // 'age' 상자에 20이라는 정수를 넣습니다.
        bloodType = 'B';  // 'bloodType' 상자에 'B'라는 문자를 넣습니다. (char 타입은 작은따옴표 '' 사용)

        // 3. 변수 사용 (Utilization)
        // - 변수에 저장된 값을 읽어와서 사용합니다.
        // - 변수 이름을 부르면, 그 안에 저장된 데이터가 나옵니다.

        System.out.println(name);      // "홍길동" 출력
        System.out.println(age);       // 20 출력
        System.out.println(bloodType); // 'B' 출력

        // --------------- 변수를 활용한 문장 출력 ---------------

        // 방법 1: println과 '+' 연산자 사용하기
        // 문자열과 변수를 '+' 기호로 연결하여 하나의 긴 문장으로 만들어 출력합니다.
        System.out.println("제 이름은 " + name + "이고, 제 나이는 " + age + "이고, 제 혈액형은 " + bloodType + "형입니다.");

        // 방법 2: printf와 형식 지정자 사용하기
        // 어제 배운 printf를 사용하면 코드가 더 간결해질 수 있습니다.
        // %s: String, %d: int, %c: char
        System.out.printf("제 이름은 %s이고, 제 나이는 %d이고, 제 혈액형은 %c형입니다.%n", name, age, bloodType);
    }
}