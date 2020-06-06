package servlet;
 
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.InstructorItem;
import dao.InstructorDAO;;


public class instructorOprateServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	 String tID = (String)request.getParameter("ID");
       
         List<InstructorItem> instructorList = new InstructorDAO().list(tID);
         request.setAttribute("instructorList", instructorList);
         request.getRequestDispatcher("instructorOprate.jsp").forward(request, response);
  
    }
}