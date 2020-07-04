import com.company.dao.inter.CountriesDaoInter;
import com.company.dao.inter.LoginDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.Countries;
import com.company.entity.Login;
import com.company.entity.User;
import com.company.main.Contex;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


@WebServlet(name = "/AdminPageController", urlPatterns = {"/adminpage"})
public class AdminPageController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Login login= (Login) req.getSession().getAttribute("logedInUser");
//        System.out.println("You username: "+login.getUsername());

        HashMap<String, Integer> listeler = new HashMap<String, Integer>();

        int userlist=0;
        UserDaoInter udi=Contex.instanceUserDao();
        List<User> list=udi.getAll();
        for (User u:list) {
            userlist++;
           // System.out.println("user sayi: "+userlist);
        }
        listeler.put("userlist",userlist);

        int loginList=0;
        LoginDaoInter ldi=Contex.instanceLoginDao();
        List<Login> logins=ldi.getAll();
        for (Login l:logins) {
            loginList++;
           // System.out.println("login sayi: "+loginList);
        }
        listeler.put("loginList",loginList);


        int countryList=0;
        CountriesDaoInter cdi=Contex.instanceCountriesDao();
        List<Countries> con=cdi.getAll();
        for (Countries s:con) {
            countryList++;
           // System.out.println("countryLis sayi: "+countryList);
        }
        listeler.put("countryList",countryList);
        System.out.println("salamalar");
        System.out.println("listeler: "+listeler.get("countryList"));

        req.setAttribute("listeler",listeler);

        req.setAttribute("login",login);
        req.getRequestDispatcher("admin.jsp").forward(req,resp);



    }

    
}
