package servlet;

import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import bean.TakesItem;
import dao.StudentCourseDAO;;
 
public class StudentCourseAddServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String stuID = (String) request.getSession().getAttribute("stuID");
    	new StudentCourseDAO().add(stuID, 
    			request.getParameter("course_id"), request.getParameter("sec_id"), 
    			request.getParameter("semester"), 
    			Integer.parseInt(request.getParameter("year")));
//    	JOptionPane.showMessageDialog(null, "Ñ¡¿Î³É¹¦"); 
        request.getRequestDispatcher("listStudentSection?name=student").forward(request, response);
 
    }
}
