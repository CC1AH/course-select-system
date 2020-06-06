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
 
public class StudentCourseDeleteServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   /* 	String stuID = (String) request.getSession().getAttribute("stuID");
    	String stuID = (String) request.getParameter("student_id");
    	new StudentCourseDAO().delete(request.getParameter("student_id"), 
    			request.getParameter("course_id"), request.getParameter("sec_id"), 
    			request.getParameter("semester"), 
    			Integer.parseInt(request.getParameter("year")));

        request.getRequestDispatcher("StudentCourseList?sID="+stuID+"").forward(request, response);*/
    	String stuID = (String) request.getSession().getAttribute("stuID");
    	new StudentCourseDAO().delete(request.getParameter("student_id"), 
    			request.getParameter("course_id"), request.getParameter("sec_id"), 
    			request.getParameter("semester"), 
    			Integer.parseInt(request.getParameter("year")));
//    	JOptionPane.showMessageDialog(null, "³É¹¦ÍË¿Î"); 
        request.getRequestDispatcher("listStudentCourse?name=delete").forward(request, response);
    }
}