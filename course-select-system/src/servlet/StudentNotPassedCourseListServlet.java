package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.TakesItem;
import dao.StudentCourseDAO;

/**
 * ����ѧ���鿴δͨ���γ̵�����
 * @author ����
 *
 */
public class StudentNotPassedCourseListServlet extends HttpServlet {
	 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String id = (String) request.getParameter("name");
    	String stuID = (String) request.getSession().getAttribute("stuID");
    	List<TakesItem> tekesList = new StudentCourseDAO().listNotPassedCourse(stuID);
        request.setAttribute("tekesList", tekesList);
      
        request.getRequestDispatcher("studentCourseList.jsp").forward(request, response);
      
 
    }
}