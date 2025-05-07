package com.nuist.dao;

import com.nuist.entity.User;
import com.nuist.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginDao {
    private User user;

    public UserLoginDao() {}

    public User getUserByNameAndPwd(String name, String pwd) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from user where userName = ? and userPwd = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, pwd);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            Integer id = rs.getInt("id");
            String userName = rs.getString("userName");
            String userPwd = rs.getString("userPwd");
            user = new User(id, userName, userPwd);
            JDBCUtil.close(conn, ps, rs);
            return user;
        }
        JDBCUtil.close(conn, ps, rs);
        return user;
    }
}
