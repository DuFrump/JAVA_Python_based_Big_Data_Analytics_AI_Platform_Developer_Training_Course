package org.example.config; // 이 파일이 속한 패키지를 선언합니다. 'config'는 설정(Configuration) 관련 클래스들을 모아두는 곳입니다.

import java.sql.Connection;    // 자바와 데이터베이스 간의 연결을 나타내는 인터페이스입니다.
import java.sql.DriverManager; // JDBC 드라이버를 관리하고 데이터베이스 연결을 설정하는 클래스입니다.
import java.sql.SQLException;  // JDBC 작업 중 발생할 수 있는 데이터베이스 관련 예외를 처리하기 위한 클래스입니다.

/**
 * DBUtil 클래스는 데이터베이스 연결을 위한 유틸리티(도우미) 클래스입니다.
 * 데이터베이스 연결 정보를 관리하고, 다른 클래스에서 쉽게 데이터베이스 연결을 얻을 수 있도록 정적(static) 메서드를 제공합니다.
 */
public class DBUtil {

    // 데이터베이스 연결에 필요한 정보들을 상수로 정의합니다.
    // private: 이 클래스 내에서만 접근 가능하도록 합니다. (보안 및 캡슐화)
    // static: 객체를 생성하지 않고도 클래스 이름으로 직접 접근할 수 있도록 합니다. (예: DBUtil.URL)
    // final: 한 번 초기화되면 값을 변경할 수 없는 상수임을 나타냅니다.
    private static final String URL = "jdbc:mysql://localhost:3306/my_db77"; // 데이터베이스 URL (JDBC 드라이버, 호스트, 포트, 데이터베이스 이름 포함)
    private static final String USER = "root";                               // 데이터베이스 접속 사용자 이름
    private static final String PASSWORD = "1234";                           // 데이터베이스 접속 비밀번호

    /**
     * 데이터베이스 연결(Connection) 객체를 반환하는 정적(static) 메서드입니다.
     * 이 메서드를 호출하면 데이터베이스에 연결됩니다.
     * @return 데이터베이스 연결을 나타내는 Connection 객체
     * @throws SQLException 데이터베이스 연결 중 오류가 발생할 경우 SQLException을 발생시킵니다.
     *                      이 메서드를 호출하는 쪽에서 이 예외를 처리해야 합니다.
     */
    public static Connection getConnection() throws SQLException {
        // DriverManager.getConnection() 메서드를 사용하여 데이터베이스에 연결하고 Connection 객체를 반환합니다.
        // 이 메서드는 URL, 사용자 이름, 비밀번호를 인자로 받습니다.
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}