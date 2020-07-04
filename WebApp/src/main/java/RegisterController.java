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

@WebServlet(name = "/RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LoginDaoInter lgi= Contex.instanceLoginDao();

        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String email=req.getParameter("email");

        if (username.isEmpty()||username.equals("")){
            req.setAttribute("null","Username empty storage");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
            return;
        }
        if (password.isEmpty()||password.equals("")){
            req.setAttribute("null","Password empty storage");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
            return;
        }
        if (email.isEmpty()||email.equals("")){
            req.setAttribute("null","Email empty storage");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
            return;
        }

        List<Login> list= lgi.getAll();
        for (Login l:list) {
            if (username.equals(l.getUsername())){
                req.setAttribute("null","There is such a username");
                req.getRequestDispatcher("register.jsp").forward(req,resp);
                return;
            }
            if (email.equals(l.getEmail())){
                req.setAttribute("null","There is such a email");
                req.getRequestDispatcher("register.jsp").forward(req,resp);
                return;
            }
        }


            Login login=new Login(0,username,password,email,0,0);
            lgi.addLogin(login);
            resp.sendRedirect("index");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username="Username";
        String password="Password";
        req.setAttribute("username",username);
        req.setAttribute("password",password);
        req.getRequestDispatcher("register.jsp").forward(req,resp);
        return;

    }
}
