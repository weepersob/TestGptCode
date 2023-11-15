package StudentSelectSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataConnect {
    public static Connection getConn()
        {   String driverName = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/mystudent";
            String userName = "root";
            String password = "mqw12345";
            try {
                Class.forName(driverName);
                Connection coon;
                coon=(Connection) DriverManager.getConnection(url,userName,password);
               return coon;
            } catch (ClassNotFoundException e) {
              e.printStackTrace();
            }catch (SQLException e){
                e.printStackTrace();
                System.out.println("数据库连接失败!");
            }
               return null;
              
        }
        public static void executeSql(Connection c,String sql)
        {
            try {
                PreparedStatement p=c.prepareStatement(sql);
                p.executeUpdate();
                p.close();
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("sql语句执行异常!");
            }


        }
}
