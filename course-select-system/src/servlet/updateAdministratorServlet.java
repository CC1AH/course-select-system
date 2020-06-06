package servlet;

import bean.AdministratorItem;
import dao.AdministratorDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateAdministratorServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String admID=request.getParameter("admID");
        String password = request.getParameter("password");
       
        AdministratorItem administrator  = new AdministratorItem();
        administrator.setAdmID(admID);
        administrator.setPassword(password);
        
        
        new AdministratorDAO().update(administrator);

        request.getRequestDispatcher("adminLogin.html").forward(request, response);
    }
}