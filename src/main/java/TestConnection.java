
import StudentSelectSystem.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TestConnection {
    public static void main(String[] args) throws Exception {
       // List<User> r=ActualizeSql.fulfillSql("张三","123");
       // System.out.println(r);
        //System.out.println(GradeDatabaseOperate.getSelectAll("语文"));
        /*List<Course2> C=null;
        C= CourseGovern.addCourseAPI("法语",5);
        System.out.println(C);*/
      /*  List<TempInfo> t= new ArrayList<>();
        t=GradeDatabaseOperate.getSelectAll("pole");
        System.out.println(t);
        t=GradeDatabaseOperate.removeOneSelect("pole",7,2);
        System.out.println(t);*/
       /* int b=GradeDatabaseOperate.getStudentNo("张三");
        System.out.println(b);*/


        System.out.println( CourseDatabaseOperate.updateCourseAPI("rap",2.3,16));
    }
}
