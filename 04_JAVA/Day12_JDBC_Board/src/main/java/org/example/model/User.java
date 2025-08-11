package org.example.model; // 이 파일이 속한 패키지를 선언합니다. 'model'은 데이터의 구조를 정의하는 클래스들을 모아두는 곳입니다.

/**
 * User 클래스는 사용자(User)의 정보를 담는 모델(Model) 또는 데이터 전송 객체(DTO: Data Transfer Object)입니다.
 * 데이터베이스의 'employee' 테이블의 각 행(row)과 매핑되어 사용자의 ID, 이름, 나이 정보를 표현합니다.
 * 이러한 클래스를 POJO(Plain Old Java Object)라고도 부르며, 주로 데이터를 저장하고 전달하는 역할을 합니다.
 */
public class User {
    // 필드 (Fields): 사용자 정보의 각 속성을 나타냅니다.
    // private 접근 제어자를 사용하여 외부에서 직접 접근하는 것을 막고, Getter/Setter 메서드를 통해 접근하도록 합니다.
    // 이는 '캡슐화(Encapsulation)'라는 객체 지향 프로그래밍의 중요한 개념입니다.
    private int id;       // 사용자의 고유 식별자 (데이터베이스의 기본 키와 매핑될 수 있습니다.)
    private String name;  // 사용자의 이름
    private int age;      // 사용자의 나이

    /** 
     * 생성자 (Constructors)
     * 객체를 생성할 때 호출되어 필드를 초기화하는 특별한 메서드입니다.
     */

    /**
     * 기본 생성자 (Default Constructor)
     * 매개변수가 없는 생성자입니다. User 객체를 생성할 때 초기값을 지정하지 않고 빈 객체를 만들 때 사용합니다.
     * 예: `User user = new User();`
     */
    public User() {};

    /**
     * 모든 필드를 초기화하는 생성자
     * 데이터베이스에서 모든 정보를 가져와 User 객체를 만들 때 유용합니다.
     * @param id 사용자의 고유 ID
     * @param name 사용자의 이름
     * @param age 사용자의 나이
     */
    public User(int id, String name, int age) {
        this.id = id;     // 매개변수 id를 현재 객체의 id 필드에 할당합니다. (this는 현재 객체를 의미합니다.)
        this.name = name; // 매개변수 name을 현재 객체의 name 필드에 할당합니다.
        this.age = age;   // 매개변수 age를 현재 객체의 age 필드에 할당합니다.
    }

    /**
     * 이름과 나이만 초기화하는 생성자
     * 새로운 사용자를 데이터베이스에 추가할 때 (ID는 데이터베이스에서 자동 생성될 경우) 유용합니다.
     * @param name 사용자의 이름
     * @param age 사용자의 나이
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /** 
     * 게터 (Getter) 및 세터 (Setter) 메서드
     * private 필드에 안전하게 접근하고 값을 변경할 수 있도록 하는 공용(public) 메서드입니다.
     */

    /**
     * 사용자의 ID를 반환합니다.
     * @return 사용자의 ID
     */
    public int getId() { 
        return id; 
    }

    /**
     * 사용자의 ID를 설정합니다.
     * @param id 설정할 사용자의 ID
     */
    public void setId(int id) { 
        this.id = id; 
    }

    /**
     * 사용자의 이름을 반환합니다.
     * @return 사용자의 이름
     */
    public String getName() { 
        return name; 
    }

    /**
     * 사용자의 이름을 설정합니다.
     * @param name 설정할 사용자의 이름
     */
    public void setName(String name) { 
        this.name = name; 
    }

    /**
     * 사용자의 나이를 반환합니다.
     * @return 사용자의 나이
     */
    public int getAge() { 
        return age; 
    }

    /**
     * 사용자의 나이를 설정합니다.
     * @param age 설정할 사용자의 나이
     */
    public void setAge(int age) { 
        this.age = age; 
    }

    // toString() 메서드를 오버라이드하여 객체의 정보를 문자열로 쉽게 확인할 수 있도록 할 수도 있습니다.
    // @Override
    // public String toString() {
    //     return "User{" +
    //            "id=" + id +
    //            ", name='" + name + "'" +
    //            ", age=" + age +
    //            '}';
    // }
}