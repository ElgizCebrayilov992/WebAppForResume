import com.company.dao.inter.LoginDaoInter;
import com.company.entity.Login;
import com.company.main.Contex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "/Index", urlPatterns = {"/index"})
public class Index  extends HttpServlet {
    LoginDaoInter lgi= Contex.instanceLoginDao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

     try {

         String usernmae = req.getParameter("username");
         String password = req.getParameter("password");
         Login login = lgi.getByUsernameAndPassword(usernmae, password);

         if (login == null) {
             throw new IllegalArgumentException("email or password is incorrect!!");
         }

         if (login.getStatus_edit()==1&&login.getStatus_read()==1){
             req.getSession().setAttribute("logedInUser", login);
             resp.sendRedirect("adminpage");
         }else {
             req.getSession().setAttribute("logedInUser", login);
             resp.sendRedirect("help.html");
         }






     }catch (Exception e){
         e.printStackTrace();
         resp.sendRedirect("index.jsp?msg="+e.getMessage());
     }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username="Username";
        String password="Password";
        req.setAttribute("username",username);
        req.setAttribute("password",password);
        String mesaj=req.getParameter("msg");
        if (mesaj!=null){

        req.setAttribute("mesaj",mesaj);
        }
        req.getRequestDispatcher("index.jsp").forward(req,resp);

    }
}
