package servlet;
 
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.StudentItem;
import dao.StudentDAO;;


public class StudentListServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	 String sID = (String)request.getParameter("sID");
       
         List<StudentItem> studentList = new StudentDAO().list(sID);
         request.setAttribute("studentList", studentList);
         request.getRequestDispatcher("StudentList.jsp").forward(request, response);

    }
}