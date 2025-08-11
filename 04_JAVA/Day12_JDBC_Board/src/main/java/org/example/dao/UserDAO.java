package org.example.dao;

import org.example.model.User;
import org.example.config.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public void insert(User user) {
        String sql = "INSERT INTO employee (name, age) VALUES (?, ?)";

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement preStmt = conn.prepareStatement(sql)
                ) {
                preStmt.setString(1, user.getName());
                preStmt.setInt(2, user.getAge());
                preStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM employee";

        try(
                Connection conn = DBUtil.getConnection();
                PreparedStatement prestmt = conn.prepareStatement(sql);
                ResultSet rs = prestmt.executeQuery();
                ) {
                while (rs.next()) {
                    User user = new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("age")
                    );
                    list.add(user);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateName(User user) {
        String sql = "UPDATE employee SET name = ? WHERE id = ?";

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement prestmt = conn.prepareStatement(sql)
                ) {
                prestmt.setString(1, user.getName());
                prestmt.setInt(2, user.getId());
                int result = prestmt.executeUpdate();

                if (result == 0) {
                    System.out.println("행당 ID가 없습니다.");
                } else {
                    System.out.println("이름이 성공적으로 수정되었습니다.");
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement prestmt = conn.prepareStatement(sql)
                ) {
                prestmt.setInt(1, id);
                prestmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
