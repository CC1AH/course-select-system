package servlet;
 
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.CourseItem;
import dao.CourseDAO;;
 //���servlet


public class CourseListServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<CourseItem> courses = new CourseDAO().list();
        request.setAttribute("courses", courses);
        request.getRequestDispatcher("CourseList.jsp").forward(request, response);

    }
}