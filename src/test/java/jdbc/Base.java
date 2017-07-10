package jdbc;




import java.sql.*;

/**
 * Created by majunsheng on 2017/6/30.
 */
public class Base {

    public Connection connection;
    public PreparedStatement pstmt;
    public Statement stmt;
    public ResultSet result;

    //建立连接
    public boolean getConnection(){
        //获取 drivar、url、用户名、密码
        String driver = ConfigManagerr.getintance().getValues("driver");
        String url = ConfigManagerr.getintance().getValues("url");
        String name = ConfigManagerr.getintance().getValues("username");
        String password = ConfigManagerr.getintance().getValues("password");

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,name,password);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 查询
     * @param sql
     * @return
     */
    public ResultSet executeSQL(String sql){
        getConnection();
        try {
           pstmt = connection.prepareStatement(sql);

            result = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 关闭数据库连接
     * @return
     * @throws SQLException
     */
    public boolean CloneConnection() throws SQLException {
        if(result !=null){
            result.close();
        }
        if(stmt != null){
            stmt.close();
        }
        if(pstmt != null){
            pstmt.close();
        }
        if(connection != null){
            connection.close();
        }
        return true;
    }
}
