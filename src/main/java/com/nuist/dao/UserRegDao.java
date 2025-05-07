package com.nuist.dao;

import com.nuist.entity.User;
import com.nuist.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRegDao {
    private User user;

    public int insertUser(User user) throws SQLException {
        String userName = user.getUserName();
        String userPwd = user.getUserPwd();
        String sql = "insert into user(id,userName,userPwd) values(null,?,?)";
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, userName);
        ps.setString(2, userPwd);
        int res = ps.executeUpdate();
        JDBCUtil.close(conn, ps, null);
        return res;
    }


}
