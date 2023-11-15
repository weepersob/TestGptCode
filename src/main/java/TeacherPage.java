import StudentSelectSystem.GradeDatabaseOperate;
import StudentSelectSystem.TempInfo;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TeacherPage", value = "/TeacherPage")
public class TeacherPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String CourseName=request.getParameter("courseMg");
        System.out.println(CourseName);
        List<TempInfo> T=null;
   T= GradeDatabaseOperate.getSelectAll(CourseName);
        if (T.isEmpty()&&T!=null)T=null;
        String js= JSON.toJSONString(T);
        System.out.println(js);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(js);


    }
}
