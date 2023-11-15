import StudentSelectSystem.Course;
import StudentSelectSystem.Course2;
import StudentSelectSystem.CourseDatabaseOperate;
import StudentSelectSystem.CourseGovern;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CourseTablePage", value = "/CourseTablePage")
public class CourseTablePage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
         String cName=request.getParameter("name");
         String cScore=request.getParameter("score");
        System.out.println(cName);
        System.out.println(cScore);
        List<Course2> C = null;
         if(cScore==null||cName==null) {
             C = CourseDatabaseOperate.seekCourseApi();} else {
             double score=Double.parseDouble(cScore);
             try {
                C=CourseGovern.addCourseAPI(cName,score);
             } catch (Exception e) {
                 throw new RuntimeException(e);
             }
         }
         if (C.isEmpty() && C != null) C = null;
             String js = JSON.toJSONString(C);
             System.out.println(js);
             response.setContentType("text/json;charset=utf-8");
             response.getWriter().write(js);

    }
}
