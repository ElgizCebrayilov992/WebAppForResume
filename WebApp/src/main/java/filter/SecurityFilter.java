//package filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//@WebFilter(filterName = "SecurityFilter",urlPatterns = {"*"})
//public class SecurityFilter  implements Filter
//{
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//        try {
//            HttpServletRequest req= (HttpServletRequest) servletRequest;
//            HttpServletResponse res=(HttpServletResponse) servletResponse;
//
//            if (req.getRequestURI().contains("/index")&&req.getSession().getAttribute("loggedInUser")==null){
//                res.sendRedirect("index");
//            }else {
//                filterChain.doFilter(req,res);
//            }
//
//        }catch (Exception ex){
//            ex.printStackTrace();
//            System.out.println("error mesaji: "+ex.getMessage());
//
//        }
//    }
//}
