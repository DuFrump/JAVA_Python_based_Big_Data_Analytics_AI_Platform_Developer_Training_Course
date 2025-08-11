package org.example; // 이 파일이 속한 패키지를 선언합니다. 자바는 코드를 체계적으로 관리하기 위해 패키지 단위를 사용합니다.

import org.example.dao.UserDAO; // 사용자 데이터베이스 접근 객체(DAO)를 가져옵니다. 데이터베이스와 상호작용하는 기능을 담당합니다.
import org.example.model.User;   // 사용자 정보를 담는 모델(데이터) 객체를 가져옵니다. User 클래스는 사용자의 ID, 이름, 나이 등의 속성을 가집니다.

import java.util.List;   // 여러 User 객체를 담을 수 있는 리스트(컬렉션)를 사용하기 위해 import 합니다.
import java.util.Scanner; // 사용자로부터 키보드 입력을 받기 위해 Scanner 클래스를 import 합니다.

/**
 * 이 클래스는 프로그램의 시작점입니다.
 * 사용자에게 메뉴를 보여주고, 선택에 따라 사용자 정보를 조회, 추가, 수정, 삭제하는 기능을 수행합니다.
 * 데이터베이스와의 실제 상호작용은 UserDAO 클래스에 위임합니다.
 */
public class Main {
    /**
     * 프로그램이 시작될 때 가장 먼저 실행되는 메서드입니다.
     * 모든 자바 애플리케이션은 이 main 메서드부터 실행됩니다.
     * @param args 명령줄에서 전달되는 인자들을 받을 수 있는 배열입니다. (여기서는 사용되지 않습니다.)
     */
    public static void main(String[] args) {
        // UserDAO 객체를 생성합니다.
        // 이 객체를 통해 데이터베이스에 사용자 정보를 넣고(insert), 가져오고(select), 수정하고(update), 삭제(delete)하는 등의 작업을 수행합니다.
        UserDAO dao = new UserDAO(); 
        
        // Scanner 객체를 생성합니다.
        // System.in은 표준 입력 스트림, 즉 키보드를 의미합니다.
        // 이 객체를 사용하여 사용자로부터 키보드 입력을 받을 수 있습니다.
        Scanner sc = new Scanner(System.in); 

        // 무한 루프를 시작합니다.
        // 사용자가 '0'을 입력하여 프로그램을 종료하기 전까지 계속해서 메뉴를 보여주고 입력을 받습니다.
        while (true) {
            // 사용자에게 보여줄 메뉴를 출력합니다.
            System.out.println("[1]조회   [2]추가   [3]이름수정    [4]삭제    [0]종료");
            System.out.print("번호 입력 : "); // 사용자에게 번호 입력을 요청하는 메시지를 출력합니다.

            int number; // 사용자가 입력할 메뉴 번호를 저장할 변수입니다.
            try {
                // 사용자가 입력한 한 줄(nextLine())을 읽어서 정수(Integer.parseInt())로 변환합니다.
                // 예를 들어, 사용자가 "1"을 입력하면 정수 1로 변환됩니다.
                number = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                // 만약 사용자가 숫자가 아닌 다른 문자(예: "abc")를 입력하면 NumberFormatException이 발생합니다.
                // 이 예외를 잡아서 사용자에게 올바른 입력을 요청하는 메시지를 출력합니다.
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                continue; // 현재 루프를 건너뛰고 다시 메뉴를 보여줍니다.
            }


            // 사용자가 입력한 번호에 따라 다른 기능을 수행합니다.
            if (number == 1) {
                // 1. 사용자 전체 조회 기능
                System.out.println("--- 사용자 목록 조회 ---");
                // UserDAO의 getAll() 메서드를 호출하여 데이터베이스의 모든 사용자 정보를 가져옵니다.
                // 가져온 사용자 정보들은 User 객체들의 리스트 형태로 반환됩니다.
                List<User> users = dao.getAll();
                
                // 가져온 사용자 리스트를 하나씩 반복하면서 정보를 출력합니다.
                for (User user : users) {
                    System.out.println("아이디 : " + user.getId() + ", 이름 : " + user.getName() + ", 나이 : " + user.getAge());
                }
                System.out.println("--------------------");
            } else if (number == 2) {
                // 2. 사용자 추가 기능
                System.out.println("--- 사용자 추가 ---");
                System.out.print("이름 입력 : ");
                String name = sc.nextLine(); // 사용자로부터 이름을 입력받습니다.
                System.out.print("나이 입력 : ");
                int age; // 나이를 저장할 변수입니다.
                try {
                    age = Integer.parseInt(sc.nextLine()); // 사용자로부터 나이를 입력받아 정수로 변환합니다.
                } catch (NumberFormatException e) {
                    System.out.println("나이는 숫자로 입력해주세요.");
                    continue;
                }

                // 입력받은 이름과 나이로 새로운 User 객체를 생성합니다.
                User user1 = new User(name, age);
                // UserDAO의 insert() 메서드를 호출하여 이 User 객체의 정보를 데이터베이스에 저장합니다.
                dao.insert(user1);
                System.out.println("사용자 추가 완료!");
                System.out.println("--------------------");
            } else if (number == 3) {
                // 3. 사용자 이름 수정 기능
                System.out.println("--- 사용자 이름 수정 ---");
                System.out.print("수정할 ID 입력 : ");
                int id; // 수정할 사용자의 ID를 저장할 변수입니다.
                try {
                    id = Integer.parseInt(sc.nextLine()); // 사용자로부터 ID를 입력받아 정수로 변환합니다.
                } catch (NumberFormatException e) {
                    System.out.println("ID는 숫자로 입력해주세요.");
                    continue;
                }
                System.out.print("변경할 이름 입력 : ");
                String name = sc.nextLine(); // 사용자로부터 변경할 이름을 입력받습니다.

                // 수정할 정보를 담을 User 객체를 생성합니다.
                // 여기서는 ID와 변경할 이름만 필요하므로, 해당 필드만 설정합니다.
                User user2 = new User();
                user2.setId(id); // 수정할 사용자의 ID를 설정합니다.
                user2.setName(name); // 변경할 이름을 설정합니다.
                
                // UserDAO의 updateName() 메서드를 호출하여 해당 ID의 사용자 이름을 수정합니다.
                dao.updateName(user2);
                System.out.println("사용자 이름 수정 완료!");
                System.out.println("--------------------");
            } else if (number == 4) {
                // 4. 사용자 삭제 기능
                System.out.println("--- 사용자 삭제 ---");
                System.out.print("삭제할 ID 입력 : ");
                int id; // 삭제할 사용자의 ID를 저장할 변수입니다.
                try {
                    id = Integer.parseInt(sc.nextLine()); // 사용자로부터 ID를 입력받아 정수로 변환합니다.
                } catch (NumberFormatException e) {
                    System.out.println("ID는 숫자로 입력해주세요.");
                    continue;
                }
                // UserDAO의 delete() 메서드를 호출하여 해당 ID의 사용자를 데이터베이스에서 삭제합니다.
                dao.delete(id);
                System.out.printf("ID %d번 삭제 완료!%n", id); // 삭제 완료 메시지를 출력합니다.
                System.out.println("--------------------");
            } else if (number == 0) {
                // 0. 프로그램 종료 기능
                System.out.println("프로그램이 종료됩니다.");
                break; // 무한 루프를 종료하고 프로그램을 끝냅니다.
            } else {
                // 그 외의 잘못된 번호를 입력했을 경우
                System.out.println("잘못된 번호를 입력하셨습니다. 메뉴를 다시 확인해주세요.");
            }
        }
        // 프로그램이 종료될 때 Scanner 객체를 닫아 자원을 해제합니다.
        // 이는 좋은 프로그래밍 습관입니다.
        sc.close(); 
    }
}