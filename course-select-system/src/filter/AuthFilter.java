package filter;
 
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class AuthFilter implements Filter {
 
    @Override
    public void destroy() {
 
    }
 
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
 
        String uri = request.getRequestURI();
        if (true) {
            chain.doFilter(request, response);
            return;
        }
 
        String studentID = (String) request.getSession().getAttribute("stuID");
        String teacherID = (String) request.getSession().getAttribute("teaID");
        String adminID = (String) request.getSession().getAttribute("admID");
        if (studentID==null&&teacherID==null&&adminID==null) {
            response.sendRedirect("LoginInChosen.html");
            return;
        }
 
        chain.doFilter(request, response);
    }
 
    @Override
    public void init(FilterConfig arg0) throws ServletException {
 
    }
 
}