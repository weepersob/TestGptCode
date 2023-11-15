import StudentSelectSystem.GradeDatabaseOperate;
import StudentSelectSystem.TempInfo;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RemoveSelect", value = "/RemoveSelect")
public class RemoveSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String courseNo=request.getParameter("courseNo");
        String courseName=request.getParameter("courseName");
        String name=request.getParameter("name");
  int cNo=Integer.parseInt(courseNo);
        System.out.println(courseName);
        System.out.println(courseNo);
        System.out.println(name);

        List<TempInfo> T=null;
        int no= GradeDatabaseOperate.getStudentNo(name);
                T=GradeDatabaseOperate.removeOneSelect(name,cNo,no);
        if (T.isEmpty()&&T!=null)T=null;
        String js= JSON.toJSONString(T);
        System.out.println(js);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(js);





    }
}
