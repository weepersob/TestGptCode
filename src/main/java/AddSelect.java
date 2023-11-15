import StudentSelectSystem.GradeDatabaseOperate;
import StudentSelectSystem.GradeGovern;
import StudentSelectSystem.TempInfo;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddSelect", value = "/AddSelect")
public class AddSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("name");
        String cNo=request.getParameter("courseNo");
        int CNO=Integer.parseInt(cNo);
        System.out.println(name);
        System.out.println(CNO);
        int no=GradeDatabaseOperate.getStudentNo(name);
       boolean f= GradeDatabaseOperate.insertAPI(no,CNO);
       String re= f ?"success":"failure";
        String js= JSON.toJSONString(re);
        System.out.println(js);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(js);


    }
}
