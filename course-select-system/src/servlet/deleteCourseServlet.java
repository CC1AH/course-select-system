package servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.CourseItem;
import dao.CourseDAO;
 

public class deleteCourseServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	   String course_id = request.getParameter("course_id");
           new CourseDAO().delete(course_id);
        response.sendRedirect("CourseList");

    }
}

