package servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.CourseItem;
import dao.CourseDAO;
 

public class addCourseServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String course_id = request.getParameter("course_id");
        String title = request.getParameter("title");
        String dept_name = request.getParameter("dept_name");
        int credits  = Integer.parseInt(request.getParameter("credits"));
        CourseItem course = new CourseItem();
        course.setCourse_id(course_id);
        course.setTitle(title);
        course.setDept_name(dept_name);
        course.setCredits(credits);
      
        new CourseDAO().add(course);

        response.sendRedirect("CourseList");

    }
}

