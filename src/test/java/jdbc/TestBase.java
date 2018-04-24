package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by majunsheng on 2017/6/30.
 */
public class TestBase {
    public static void main(String[] args) throws SQLException {

        String sql = "select * from student";
        /*List<String> param = new ArrayList<String>();
        param.add("2");*/

        Base base = new Base();
        ResultSet rs = base.executeSQL(sql);
        while (rs.next()){
            System.out.println(rs.getString("id")+ "-" + rs.getString("name"));
        }

    }
}
