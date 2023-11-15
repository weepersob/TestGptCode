import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;

@WebServlet(name = "MyNewLoginPage", value = "/MyNewLoginPage")
public class MyNewLoginPage extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
      String username=request.getParameter("username");
      String password=request.getParameter("password");
      String identity=request.getParameter("identity");
        System.out.println(username);
        System.out.println(password);
        System.out.println(identity);
        List<User> r= CheckIdentitySql.fulfillSql(username, password,identity);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw=response.getWriter();
        System.out.println(r);
        if(!r.isEmpty()){
            pw.write("登陆成功！");

        }
        else {
            pw.write("登陆失败！");

        }
    }

}
