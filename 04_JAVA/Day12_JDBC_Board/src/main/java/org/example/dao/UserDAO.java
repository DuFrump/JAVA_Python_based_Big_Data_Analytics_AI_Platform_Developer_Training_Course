package org.example.dao; // 이 파일이 속한 패키지를 선언합니다. 'dao'는 Data Access Object의 약자로, 데이터베이스 접근 로직을 담당하는 클래스들을 모아두는 곳입니다.

import org.example.model.User;   // 사용자 정보를 담는 User 모델 클래스를 가져옵니다.
import org.example.config.DBUtil; // 데이터베이스 연결 유틸리티 클래스를 가져옵니다. 데이터베이스 연결을 쉽게 얻을 수 있도록 돕습니다.

import java.sql.Connection;         // 자바와 데이터베이스 간의 연결을 나타내는 인터페이스입니다.
import java.sql.PreparedStatement;  // SQL 쿼리를 미리 컴파일하여 효율적이고 안전하게 실행할 수 있도록 돕는 인터페이스입니다.
import java.sql.ResultSet;          // SELECT 쿼리 실행 결과로 반환되는 데이터 집합을 나타내는 인터페이스입니다.
import java.sql.SQLException;       // JDBC 작업 중 발생할 수 있는 데이터베이스 관련 예외를 처리하기 위한 클래스입니다.
import java.util.ArrayList;         // 동적으로 크기가 조절되는 리스트를 구현하는 클래스입니다. 여러 User 객체를 저장할 때 사용합니다.
import java.util.List;              // 컬렉션 프레임워크의 최상위 인터페이스 중 하나로, 순서가 있는 데이터의 집합을 나타냅니다.

/**
 * UserDAO (Data Access Object) 클래스는 사용자(User) 데이터와 데이터베이스 간의 상호작용을 담당합니다.
 * 이 클래스는 데이터베이스에 사용자 정보를 삽입(insert), 조회(select), 수정(update), 삭제(delete)하는 메서드를 제공합니다.
 * JDBC(Java Database Connectivity)를 사용하여 데이터베이스와 통신합니다.
 */
public class UserDAO {

    /**
     * 새로운 사용자 정보를 데이터베이스에 삽입(저장)합니다.
     * @param user 데이터베이스에 저장할 사용자 정보(이름, 나이)를 담고 있는 User 객체입니다.
     */
    public void insert(User user) {
        // SQL INSERT 쿼리문입니다.
        // 'employee' 테이블에 'name'과 'age' 값을 삽입합니다.
        // '?'는 PreparedStatement의 플레이스홀더로, 나중에 실제 값으로 채워집니다. (SQL Injection 방지)
        String sql = "INSERT INTO employee (name, age) VALUES (?, ?)";

        // try-with-resources 구문: JDBC 자원(Connection, PreparedStatement)을 자동으로 닫아줍니다.
        // 이를 통해 자원 누수를 방지하고 코드 가독성을 높일 수 있습니다.
        try (
                // DBUtil.getConnection()을 호출하여 데이터베이스 연결(Connection)을 얻습니다.
                Connection conn = DBUtil.getConnection();
                // SQL 쿼리를 실행하기 위한 PreparedStatement 객체를 생성합니다.
                // 이 객체는 SQL 쿼리를 미리 준비하여 효율적인 실행을 가능하게 합니다.
                PreparedStatement preStmt = conn.prepareStatement(sql)
                ) {
                // PreparedStatement의 플레이스홀더(?)에 실제 값을 설정합니다.
                // 첫 번째 '?'에는 User 객체의 이름을, 두 번째 '?'에는 나이를 설정합니다.
                preStmt.setString(1, user.getName()); // 첫 번째 '?'에 사용자 이름 설정
                preStmt.setInt(2, user.getAge());     // 두 번째 '?'에 사용자 나이 설정
                
                // SQL INSERT 쿼리를 실행합니다.
                // executeUpdate()는 INSERT, UPDATE, DELETE와 같이 데이터베이스의 내용을 변경하는 쿼리를 실행할 때 사용하며,
                // 변경된 행의 수를 반환합니다. (여기서는 반환값을 사용하지 않습니다.)
                preStmt.executeUpdate();
                System.out.println("데이터 삽입 성공!");
        } catch (SQLException e) {
            // 데이터베이스 관련 예외(SQL 오류 등)가 발생하면 이곳에서 처리합니다.
            // e.printStackTrace()는 예외 발생 시 스택 트레이스를 콘솔에 출력하여 디버깅에 도움을 줍니다.
            System.err.println("데이터 삽입 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 데이터베이스에 저장된 모든 사용자 정보를 조회합니다.
     * @return 모든 사용자 정보를 담고 있는 User 객체들의 리스트를 반환합니다. 조회된 사용자가 없으면 빈 리스트를 반환합니다.
     */
    public List<User> getAll() {
        // 조회된 User 객체들을 저장할 빈 ArrayList를 생성합니다.
        List<User> list = new ArrayList<>();
        // SQL SELECT 쿼리문입니다. 'employee' 테이블의 모든 컬럼(*)을 조회합니다.
        String sql = "SELECT * FROM employee";

        // try-with-resources 구문: JDBC 자원(Connection, PreparedStatement, ResultSet)을 자동으로 닫아줍니다.
        try(
                Connection conn = DBUtil.getConnection();         // 데이터베이스 연결을 얻습니다.
                PreparedStatement prestmt = conn.prepareStatement(sql); // SQL 쿼리를 준비합니다.
                ResultSet rs = prestmt.executeQuery();            // SQL SELECT 쿼리를 실행하고 결과를 ResultSet으로 받습니다.
                ) {
                // ResultSet의 next() 메서드는 다음 행이 있는지 확인하고, 있다면 다음 행으로 커서를 이동시킵니다.
                // 모든 행을 순회하며 데이터를 읽어옵니다.
                while (rs.next()) {
                    // 현재 행의 데이터를 읽어와 새로운 User 객체를 생성합니다.
                    // rs.getInt("컬럼명") 또는 rs.getString("컬럼명")을 사용하여 해당 컬럼의 값을 가져옵니다.
                    User user = new User(
                            rs.getInt("id"),       // 'id' 컬럼의 정수 값 가져오기
                            rs.getString("name"),   // 'name' 컬럼의 문자열 값 가져오기
                            rs.getInt("age")        // 'age' 컬럼의 정수 값 가져오기
                    );
                    list.add(user); // 생성된 User 객체를 리스트에 추가합니다.
                }
        } catch (SQLException e) {
            // 데이터베이스 관련 예외 처리
            System.err.println("데이터 조회 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
        return list; // 모든 사용자 정보가 담긴 리스트를 반환합니다.
    }

    /**
     * 특정 사용자의 이름을 수정합니다.
     * @param user 수정할 사용자 정보(ID, 변경할 이름)를 담고 있는 User 객체입니다.
     */
    public void updateName(User user) {
        // SQL UPDATE 쿼리문입니다.
        // 'employee' 테이블에서 'id'가 일치하는 행의 'name'을 수정합니다.
        String sql = "UPDATE employee SET name = ? WHERE id = ?";

        // try-with-resources 구문
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement prestmt = conn.prepareStatement(sql)
                ) {
                // PreparedStatement의 플레이스홀더에 값을 설정합니다.
                prestmt.setString(1, user.getName()); // 첫 번째 '?'에 변경할 이름 설정
                prestmt.setInt(2, user.getId());     // 두 번째 '?'에 수정할 사용자 ID 설정
                
                // SQL UPDATE 쿼리를 실행하고, 변경된 행의 수를 반환받습니다.
                int result = prestmt.executeUpdate();

                // 변경된 행의 수가 0이면 해당 ID를 가진 사용자가 없다는 의미입니다.
                if (result == 0) {
                    System.out.println("해당 ID를 가진 사용자가 없습니다. 수정 실패.");
                } else {
                    System.out.println("사용자 이름이 성공적으로 수정되었습니다.");
                }
        } catch (SQLException e) {
            // 데이터베이스 관련 예외 처리
            System.err.println("데이터 수정 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 특정 사용자를 데이터베이스에서 삭제합니다.
     * @param id 삭제할 사용자의 고유 ID입니다.
     */
    public void delete(int id) {
        // SQL DELETE 쿼리문입니다.
        // 'employee' 테이블에서 'id'가 일치하는 행을 삭제합니다.
        String sql = "DELETE FROM employee WHERE id = ?";

        // try-with-resources 구문
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement prestmt = conn.prepareStatement(sql)
                ) {
                // PreparedStatement의 플레이스홀더에 삭제할 사용자 ID를 설정합니다.
                prestmt.setInt(1, id);
                
                // SQL DELETE 쿼리를 실행합니다.
                // executeUpdate()는 삭제된 행의 수를 반환합니다. (여기서는 반환값을 사용하지 않습니다.)
                prestmt.executeUpdate();
                System.out.printf("ID %d번 사용자 삭제 성공!%n", id);
        } catch (SQLException e) {
            // 데이터베이스 관련 예외 처리
            System.err.println("데이터 삭제 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}