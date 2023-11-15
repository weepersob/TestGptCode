package StudentSelectSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDatabaseOperate {
    public static void insertInfo(Student s){
        Connection con=DataConnect.getConn();
        String sql="insert into studentinfo(name,major) values(?,?)";
   // DataConnect.executeSql(con,sql);
        try {
            PreparedStatement p= con.prepareStatement(sql);
            p.setString(1,s.getName());
            p.setString(2,s.getMajor());
            p.executeUpdate();
            p.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void insertInfoByNameAndMajor(String name,String major){
        Connection con=DataConnect.getConn();
        String sql="insert into studentinfo(name,major) values(?,?)";
        // DataConnect.executeSql(con,sql);
        try {
            PreparedStatement p= con.prepareStatement(sql);
            p.setString(1,name);
            p.setString(2,major);
            p.executeUpdate();
            p.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }








    public static void delete(int no){
        Connection c=DataConnect.getConn();
        String sql="delete from studentinfo where no=?";
        try {
            PreparedStatement p=c.prepareStatement(sql);
            p.setInt(1,no);
            p.executeUpdate();
            p.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("操作失败!");
        }
    }
    public static Student getOneStudent(int no)
    {
        Connection c=DataConnect.getConn();
        String sql="select * from studentinfo where no=?";
        try {
            PreparedStatement p=c.prepareStatement(sql);
            p.setInt(1,no);
            ResultSet result=p.executeQuery();
            while(result.next()){
                int stuNo=result.getInt("no");
                String name=result.getString("name");
                String major=result.getString("major");
                Student s=new Student(stuNo,name,major);
                p.close();
                c.close();
                result.close();
                return s;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("操作失败!");

        }

  return null;
    }

    public static Student getOneStudentApi(int no,String name)
    {
        Connection c=DataConnect.getConn();
        String sql="select * from studentinfo where no=? and name=?";
        try {
            PreparedStatement p=c.prepareStatement(sql);
            p.setInt(1,no);
            p.setString(2,name);
            ResultSet result=p.executeQuery();
            while(result.next()){
                int stuNo=result.getInt("no");
                String n=result.getString("name");
                String major=result.getString("major");
                Student s=new Student(stuNo,name,major);
                p.close();
                c.close();
                result.close();
                return s;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("操作失败!");

        }

        return null;
    }


    public static void update(Student s) throws SQLException { Connection c=DataConnect.getConn();
        String sql="update studentinfo set name=?,major=? where no=?";
        try {
            PreparedStatement p=c.prepareStatement(sql);
            p.setString(1,s.getName());
            p.setString(2,s.getMajor());
            p.setInt(3,s.getNo());
            p.executeUpdate();
            p.close();
            c.close();
        }catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("操作失败!");
        }
    }

    public static boolean updateAPI(Student s) throws SQLException {
         boolean f=false;
        Connection c=DataConnect.getConn();
        String sql="update studentinfo set name=?,major=? where no=?";
        try {
            PreparedStatement p=c.prepareStatement(sql);
            p.setString(1,s.getName());
            p.setString(2,s.getMajor());
            p.setInt(3,s.getNo());
            p.executeUpdate();
            p.close();
            c.close();
            f=true;
        }catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("操作失败!");
            f=false;
        }
        return f;
    }
















    public static List<Student> seekStudent(String key)
    {
        List<Student> stu=new ArrayList<Student>();
        Connection c=DataConnect.getConn();
        String sql="select * from studentinfo where name like ? or major like ? or no like ?";
        try {
            PreparedStatement p=c.prepareStatement(sql);
            p.setString(1,"%"+key+"%");
            p.setString(2,"%"+key+"%");
            p.setString(3,"%"+key+"%");
            ResultSet r=p.executeQuery();
            while (r.next())
            { int stuNo=r.getInt("no");
                String name=r.getString("name");
                String major=r.getString("major");
                Student t=new Student(stuNo,name,major);
                stu.add(t);
            }
            r.close();
            p.close();
            c.close();
            return stu;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("操作失败!");
        } catch (Exception e) {
           e.printStackTrace();
        }
return null;

    }











}
