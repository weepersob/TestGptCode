import StudentSelectSystem.GradeDatabaseOperate;
import StudentSelectSystem.Student;
import StudentSelectSystem.StudentDatabaseOperate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ModifyStudent", value = "/ModifyStudent")
public class ModifyStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.setCharacterEncoding("utf-8");
        String name=request.getParameter("name");
        String major=request.getParameter("major");
        System.out.println(name);
        System.out.println(major);
           int stuNo= GradeDatabaseOperate.getStudentNo(name);
        System.out.println(stuNo);
       /* try {
            StudentDatabaseOperate.updateAPI(new Student(stuNo,name,major));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

*/
    }
}
