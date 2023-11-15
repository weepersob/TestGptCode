import StudentSelectSystem.Course2;
import StudentSelectSystem.CourseDatabaseOperate;
import StudentSelectSystem.GradeDatabaseOperate;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ModifyCourse", value = "/ModifyCourse")
public class ModifyCourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String cname=request.getParameter("name");
        String cscore=request.getParameter("score");
        String cNo=request.getParameter("no");
        double score=Double.parseDouble(cscore);
        int no=Integer.parseInt(cNo);
       List<Course2> C=CourseDatabaseOperate.updateCourseAPI(cname,score,no);

        System.out.println(cname);
        System.out.println(score);
        System.out.println(cNo);

        if (C.isEmpty()&& C != null) C = null;
        String js = JSON.toJSONString(C);
        System.out.println(js);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(js);


















    }
}
