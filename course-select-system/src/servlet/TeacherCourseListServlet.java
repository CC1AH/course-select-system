 package servlet;

import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.TeachesItem;
import dao.TeacherCourseDAO;

public class TeacherCourseListServlet extends HttpServlet {
   
	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String teaID = (String) request.getSession().getAttribute("teaID");
    	List<TeachesItem> teachesList = new TeacherCourseDAO().list(teaID);
        request.setAttribute("teachesList", teachesList);
        request.getRequestDispatcher("teacherCourseList.jsp").forward(request, response);
    }
}