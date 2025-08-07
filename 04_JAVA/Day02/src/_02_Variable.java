// 변수의 선언(declaration)과 할당(assignment)을 분리해서 사용하는 방법을 배우는 예제입니다.

public class _02_Variable {
    public static void main(String[] args) {
        // 1. 변수 선언: 데이터를 저장할 공간을 미리 만드는 과정입니다.
        // 어떤 종류(타입)의 데이터를 저장할지, 변수 이름은 무엇으로 할지 정합니다.
        String name;      // 문자열(String)을 저장할 'name' 변수 선언
        int age;          // 정수(int)를 저장할 'age' 변수 선언
        char bloodType;   // 문자(char)를 저장할 'bloodType' 변수 선언

        // 2. 값 할당(초기화): 선언된 변수에 실제 데이터를 저장하는 과정입니다.
        name = "홍길동";
        age = 20;
        bloodType = 'B'; // char 타입은 작은따옴표('')를 사용합니다.

        // 3. 변수 사용: 변수에 저장된 값을 읽어와서 사용합니다.
        System.out.println(name);
        System.out.println(age);
        System.out.println(bloodType);

        // println을 사용하여 변수와 문자열을 + 연산자로 연결하여 출력
        System.out.println("제 이름은 " + name + "이고, 제 나이는 " + age + "이고, 제 혈액형은 " + bloodType + "입니다.");

        // printf를 사용하여 형식 지정자(%s, %d, %c)를 이용해 변수 값을 출력
        // %s: String, %d: int, %c: char
        System.out.printf("제 이름은 %s이고, 제 나이는 %d이고, 제 혈액형은 %c입니다.", name, age, bloodType);
    }
}
