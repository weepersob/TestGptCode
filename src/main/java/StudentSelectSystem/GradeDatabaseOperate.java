package StudentSelectSystem;

import com.mysql.cj.jdbc.ConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDatabaseOperate {
    /* f=true 已选课程
       false 未选课程;
    */

    public static List<Course> findCourseSelectByStudent(Student s,boolean f){
        List<Course> selectCourse=new ArrayList<>();
        Connection c=DataConnect.getConn();
        int stuNo=s.getNo();
        String sql="";
        if(f){

            sql="select * from courseinfo where no in (select g.courseNo from gradeinfo g where stuNo=?)";
        }
       else{
           sql="select * from courseinfo where no not in (select g.courseNo from gradeinfo g where stuNo=?)";
        }try{
            PreparedStatement p=c.prepareStatement(sql);
            p.setInt(1,stuNo);
            ResultSet r=p.executeQuery();
          selectCourse=CourseDatabaseOperate.coursesResult(r);
          c.close();
          p.close();
          r.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



        return selectCourse;
    }










    public  static int getStudentNo(String name)
    {   int no=-1;
        Connection c=DataConnect.getConn();
        String sql="select no from studentinfo where name=?";
        try {
            PreparedStatement p=c.prepareStatement(sql);
            p.setString(1,name);
            ResultSet r=p.executeQuery();
            while(r.next())
            {
                no=r.getInt("no");
            }
            r.close();
            p.close();
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return no;
    }
    public  static String getCName(int con)
    {   String name=null;
        Connection c=DataConnect.getConn();
        String sql="select name from courseinfo where no=?";
        try {
            PreparedStatement p=c.prepareStatement(sql);
           p.setInt(1,con);
            ResultSet r=p.executeQuery();
            while(r.next())
            {
                name=r.getString("name");
            }
            r.close();
            p.close();
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return name;
    }
    public static List<TempInfo> removeOneSelect(String name,int cno,int stuNo)
    {   List<TempInfo>T=null;
         Connection c=DataConnect.getConn();
         String sql="delete from gradeinfo where courseNo=? and stuNo=?";
        try {
            PreparedStatement p=c.prepareStatement(sql);
            p.setInt(1,cno);
            p.setInt(2,stuNo);
            p.executeUpdate();
            p.close();
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
           String cname=getCName(cno);
           T=getSelectAll(cname);
        return T;
    }








    public static List<TempInfo> getSelectAll(String CourseName){//获取选这一门课程的全部学生;
        List<Student> re=new ArrayList<>();
        List<TempInfo> T=new ArrayList<>();
        Connection c=DataConnect.getConn();
        String sql = "SELECT s.* FROM studentinfo s " +
                "JOIN gradeinfo g ON s.no = g.stuNo " +
                "JOIN courseinfo c ON g.courseNo = c.no " +
                "WHERE c.name = ?";
        try{
            PreparedStatement p=c.prepareStatement(sql);
            p.setString(1,CourseName);
            ResultSet r=p.executeQuery();
            while(r.next())
            {Student t=new Student();
                t.setName(r.getString("name"));
                t.setMajor(r.getString("major"));
                re.add(t);
            }
            r.close();
            p.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
 int CourseNo=-1;double CourseMark=-1;
        String sql2="select no,score from courseinfo where name=?";
        try {PreparedStatement p2=c.prepareStatement(sql2);
              p2.setString(1,CourseName);
              ResultSet r2=p2.executeQuery();
              while(r2.next())
              { CourseNo=r2.getInt("no");
              CourseMark=r2.getDouble("score");}
            c.close();
            p2.close();
            r2.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



     for (Student s:re){
         TempInfo t=new TempInfo();
         t.setName(s.getName());
         t.setMajor(s.getMajor());
         t.setCourseNo(CourseNo);
        t.setCourseName(CourseName);
        t.setCourseMark(CourseMark);

  T.add(t);

     }

        return T;
    }

























    public static Grade getOneByStuAndCourse(Student s1,Course c1)
{
    String sql = "and (g.stuNo='" + s1.getNo() + "'  and g.courseNo='" + c1.getNo() + "')";
    List<Grade> gra=new ArrayList<>();
    gra=search(sql);
    if(gra.isEmpty())
    {return null;}
    return gra.get(0);

}
public static List<Grade> search(String sql1)
{
    List<Grade> results=new ArrayList<>();
    Connection c=DataConnect.getConn();
    String sql = "SELECT g.no, s.no AS stuNo, s.name AS stuName, s.major, "
            + "c.no AS courseNo, c.name AS courseName, c.score, "
            + "g.grade "
            + "FROM studentinfo s, courseinfo c, gradeinfo g where s.no=g.stuNo and c.no=courseNo ";

               sql+=sql1;
      try {
          PreparedStatement p=c.prepareStatement(sql);
          ResultSet r=p.executeQuery();
          while (r.next())
          {
              int no=r.getInt("no");
              int stuNo=r.getInt("stuNo");
              String stuName=r.getString("stuName");
              String major=r.getString("major");
              int courseNo=r.getInt("courseNo");
              String courseName=r.getString("courseName");
              int mark=r.getInt(7);
              double score=r.getDouble(8);
              Student stu=new Student(stuNo,stuName,major);
              Course course=new Course(courseNo,courseName,mark);
              Grade grade=new Grade();
              grade.setCourse(course);
              grade.setId(no);
              grade.setGrade(score);
              grade.setStudent(stu);
              results.add(grade);
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }

return results;
}

public static void insert(Grade g)
{
    Connection c=DataConnect.getConn();
    String sql="insert into gradeinfo(stuNo,courseNO) values(?,?)";
    try {
        PreparedStatement p=c.prepareStatement(sql);
        p.setInt(1,g.getStudent().getNo());
        p.setInt(2,g.getCourse().getNo());
        p.executeUpdate();
        p.close();
        c.close();
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("插入失败!");
    }


}


    public static boolean insertAPI(int stuNo,int courseNo)
    {    boolean flag=false;
        Connection c=DataConnect.getConn();
        String sql="insert into gradeinfo(stuNo,courseNO) values(?,?)";
        try {
            PreparedStatement p=c.prepareStatement(sql);
            p.setInt(1,stuNo);
            p.setInt(2,courseNo);
            p.executeUpdate();
            p.close();
            c.close();
            flag=true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("插入失败!");
        }

return flag;
    }






public static int updateGrade(double grade,int no)
{  int i=0;
    Connection c=DataConnect.getConn();
    String sql="update gradeinfo set grade=? where no=?";;
    try {
        PreparedStatement p=c.prepareStatement(sql);
        p.setDouble(1,grade);
        p.setInt(2,no);
       i=p.executeUpdate();
        p.close();
        c.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

return i;
}

public static List<Grade> findGradesByCourse(Course c){
        List<Grade> grades=new ArrayList<>();
    String sql = "and c.no=" + c.getNo();
    grades = search(sql);
    return grades;
}


public static List<Grade> findGradesByStudent(Student s){
        List<Grade> grades=new ArrayList<>();
        String sql=" and s.no="+s.getNo();
          grades=search(sql);
          return grades;
}







}
