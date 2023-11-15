
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckIdentitySql {
    public static List<User>fulfillSql(String username, String password,String identity)
    {    List<User> result=new ArrayList<User>();
         Connection c= DatabaseConnect.getConn();
        String sql;
         if(identity.equals("student"))
         {sql="select * from studentaccount where username=? and password=?";}
         else sql="select * from teacheraccount where username=? and password=?";
        try {
            PreparedStatement p=c.prepareStatement(sql);
            p.setString(1,username);
            p.setString(2,password);
            ResultSet r=p.executeQuery();
            while(r.next())
            { User t=new User();
                t.setId(r.getInt("id"));
               // t.setGender(r.getString("sex"));
                t.setUsername(r.getString("username"));
                t.setPassword(r.getString("password"));
                result.add(t);
               System.out.println(t);
            }
            c.close();
            p.close();
            r.close();
            return result;
        } catch (SQLException e) {
           e.printStackTrace();
          //  System.out.println("没有信息！");
            return null;
        }





    }
}
