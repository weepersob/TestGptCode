package StudentSelectSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDatabaseOperate {
    public static void insertCourse(Course cou)
    {
        Connection c=DataConnect.getConn();
        String sql="insert into courseinfo(name,score) values(?,?)";
       try {
           PreparedStatement p=c.prepareStatement(sql);
           p.setString(1,cou.getName());
           p.setDouble(2,cou.getScore());
           p.executeUpdate();
           p.close();
           c.close();
       } catch (SQLException e) {
           e.printStackTrace();
           System.out.println("课程插入失败!");
       }


    }
    public static void deleteCourseData(int no)
    {     Connection c=DataConnect.getConn();
        String sql="delete from courseinfo where no=?";
        try {
            PreparedStatement p=c.prepareStatement(sql);
            p.setInt(1,no);
            p.executeUpdate();
            p.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("删除课程失败!");
        }
    }

    public static Course getOneCourse(int no){
        Connection c=DataConnect.getConn();
        String sql="select * from courseinfo where no=?";
        try {
            PreparedStatement p=c.prepareStatement(sql);
            p.setInt(1,no);
            ResultSet r=p.executeQuery();
            while(r.next())
            {  int n=r.getInt("no");
                String name=r.getString("name");
                double score=r.getDouble("score");
                Course t=new Course(no,name,score);
                p.close();
                c.close();
                return  t;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
          return null;

    }
    public static void updateCourse(Course s){
        Connection c=DataConnect.getConn();
        String sql="update courseinfo set name=?,score=? where no=?";
        try {
            PreparedStatement p=c.prepareStatement(sql);
            p.setString(1,s.getName());
            p.setDouble(2,s.getScore());
            p.setInt(3,s.getNo());
            p.executeUpdate();
            p.close();
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static List<Course2> updateCourseAPI(String cName,double cScore,int no){
        List<Course2> r=new ArrayList<>();
        Connection c=DataConnect.getConn();
        String sql="update courseinfo set name=?,score=? where no=?";
        try {
            PreparedStatement p=c.prepareStatement(sql);
            p.setString(1,cName);
            p.setDouble(2,cScore);
            p.setInt(3,no);
            p.executeUpdate();
            p.close();
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        r=seekCourseApi();
        return r;
    }


    public static List<Course> seekCourse(String key)
    {  List<Course> t=new ArrayList<Course>();
        Connection c=DataConnect.getConn();
        String sql="select * from courseinfo where no like ? or name like ?";
        try {
            PreparedStatement p=c.prepareStatement(sql);
            p.setString(1,"%"+key+"%");
            p.setString(2,"%"+key+"%");
            ResultSet r=p.executeQuery();
            while(r.next()){
                int n=r.getInt("no");
                String name=r.getString("name");
                double marks=r.getDouble("score");
                Course k=new Course(n,name,marks);
                t.add(k);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return t;
    }



    public static List<Course2> seekCourseApi()
    {  List<Course2> C2=new ArrayList<>();
        String key="";
        List<Course> t=new ArrayList<Course>();
        Connection c=DataConnect.getConn();
        String sql="select * from courseinfo where no like ? or name like ?";
        try {
            PreparedStatement p=c.prepareStatement(sql);
            p.setString(1,"%"+key+"%");
            p.setString(2,"%"+key+"%");
            ResultSet r=p.executeQuery();
            while(r.next()){
                int n=r.getInt("no");
                String name=r.getString("name");
                double marks=r.getDouble("score");
                Course k=new Course(n,name,marks);
                t.add(k);

            }
            c.close();
            p.close();
            r.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for(Course k:t){
            Course2 d=new Course2();
            d.setNo(k.getNo());
            d.setName(k.getName());
            d.setScore(k.getScore());
            C2.add(d);
        }





        return C2;

    }























  public static List<Course> coursesResult(ResultSet result){
        List<Course> course=new ArrayList<>();
        try{

            while(result.next()){
                int no= result.getInt("no");
                String name= result.getString("name");
                double score= result.getDouble("score");
                Course t=new Course(no,name,score);
                course.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
return course;

  }











}
