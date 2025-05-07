package com.nuist.utils;

import com.mysql.jdbc.Driver;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;


    static {
        try{
            // 1.定位路径
            InputStream inputStream = new FileInputStream("D:/NUIST/Java/Projects/maven-test/src/main/resources/config/jdbc.properties");
//            InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("src/main/resources/config/jdbc.properties");
            // 2.加载配置文件
            Properties prop = new Properties();
            System.out.println(inputStream);
            prop.load(inputStream);
            // 3.加载配置数据
            driverClass = prop.getProperty("driverClass");
            url = prop.getProperty("url");
            username = prop.getProperty("user");
            password = prop.getProperty("password");
            // 4.注册驱动
            Class.forName(driverClass);
            System.out.println("驱动加载成功！");
        }catch (Exception e){
            System.out.println("驱动加载失败！");
            System.out.println(e.getMessage());
        }
    }


    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, username, password);
            return con;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return con;
        }

    }

    public static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }

    }

    public static void close(Connection conn, Statement stmt) throws SQLException {
        close(conn, stmt, null);
    }
}
