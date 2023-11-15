
import StudentSelectSystem.StudentDatabaseOperate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnect {
    public static Connection getConn()
    {
      /*  String driverName = "com.mysql.cj.jdbc.Driver";*/
        String driverName = "com.mysql.cj.jdbc.Driver";//com.mysql.cj.jdbc.Driver//com.mysql.jdbc.Driver
        String url = "jdbc:mysql://localhost:3306/mybatis";
        String userName = "root";
        String password = "mqw12345";
        try {
            Class.forName(driverName);
            Connection coon;
            coon=(Connection) DriverManager.getConnection(url,userName,password);
            //System.out.println("链接成功！");
            return coon;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("数据库连接失败!");

        }
        return null;

    }

    public static boolean Register(String name, String password ,String identity,String major){
        boolean flag=false;
        Connection c=getConn();String sql;
        if(identity.equals("teacher"))
        sql="insert into teacheraccount (username,password) values(?,?)";
        else sql="insert into studentaccount (username,password) values(?,?)";
        try {
            PreparedStatement p=c.prepareStatement(sql);
            p.setString(1,name);
            p.setString(2,password);
            p.executeUpdate();
            c.close();
            p.close();
            StudentDatabaseOperate.insertInfoByNameAndMajor(name,major);
            flag=true;
        } catch (SQLException e) {
            flag=false;
            e.printStackTrace();

        }


        return flag;
    }




























}
