package _02_Inheritance_person;

public class Person {
    String name;
    int age;
    char gender;

    Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    void info() {
        String genderString = "";

        if (gender == 'M') {
            genderString = "남자";
        } else {
            genderString = "여자";
        }

        System.out.printf("제 이름은 %s이고, 제 나이는 %d입니다. %s입니다.", name, age, genderString);
    }
}
