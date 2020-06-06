package servlet;
 
import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.TakesItem;
import dao.StudentCourseDAO;;
 
public class StudentCourseListServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String id = (String) request.getParameter("name");
    	String stuID = (String) request.getSession().getAttribute("stuID");
    	List<TakesItem> takesList = new StudentCourseDAO().list(stuID);
        request.setAttribute("tekesList", takesList);
        if ("look".equals(id)) {
        	request.getRequestDispatcher("studentCourseList.jsp").forward(request, response);
        	
        } else if ("delete".equals(id)) {
        	request.getRequestDispatcher("deleteStudentCourse.jsp").forward(request, response);
        }
 
    }
}