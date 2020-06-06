package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SectionItem;
import dao.SectionDAO;

public class SomeSectionListServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		String courseTitle = request.getParameter("courseTitle");
    	List<SectionItem> sectionList = new SectionDAO().listOnCourseTitle(courseTitle);
        request.setAttribute("sectionList", sectionList);
     
        request.getRequestDispatcher("selectStudentCourse.jsp").forward(request, response);
      
 
    }
}
