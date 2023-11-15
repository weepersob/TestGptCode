import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterPage", value = "/RegisterPage")
public class RegisterPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username=request.getParameter("RegisterName");
        String password=request.getParameter("RegisterPassword");
        String major=request.getParameter("RegisterMajor");
        String identity=request.getParameter("RegisterIdentity");
        System.out.println(username);
        System.out.println(password);
        System.out.println(major);
        System.out.println(identity);
       boolean f=DatabaseConnect.Register(username,password,identity,major);
        String js= JSON.toJSONString(f);
        System.out.println(js);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(js);

    }
}
