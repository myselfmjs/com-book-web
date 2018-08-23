package jdbc;

import java.sql.*;

/**
 * Created by majunsheng on 2017/6/29.
 */
public class testjdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/plusoft_test";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, "root", "root");
        String sql = "select * from t_position";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
    }
}
