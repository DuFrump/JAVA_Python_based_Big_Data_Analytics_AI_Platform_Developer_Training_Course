public class _02_Variable {
    public static void main(String[] args) {
        String name;
        int age;
        char bloodType;

        name = "홍길동";
        age = 20;
        bloodType = 'B';

        System.out.println(name);
        System.out.println(age);
        System.out.println(bloodType);

        System.out.println("제 이름은 " + name + "이고, 제 나이는 " + age + "이고, 제 혈액형은 " + bloodType + "입니다.");
        System.out.printf("제 이름은 %s이고, 제 나이는 %d이고, 제 혈액형은 %c입니다.", name, age, bloodType);
    }
}
