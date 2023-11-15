import StudentSelectSystem.GradeGovern;
import StudentSelectSystem.TempInfo;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentPage", value = "/StudentPage")
public class StudentPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TempInfo> t=new ArrayList<>();
        request.setCharacterEncoding("utf-8");
        String StudentNo=request.getParameter("StudentNo");
        String name=request.getParameter("name");
        String tway=request.getParameter("way");
        int way=Integer.parseInt(tway);
        System.out.println(name);
        System.out.println(StudentNo);
        System.out.println(way);
        int no=Integer.parseInt(StudentNo);
        try {
           t= GradeGovern.webCoursePageGet(no,name,way);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(t);
        System.out.println("***********************************************");
        String js= JSON.toJSONString(t);
        response.setContentType("text/json;charset=utf-8");
           response.getWriter().write(js);
    }
}
