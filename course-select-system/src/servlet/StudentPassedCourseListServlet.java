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
 * 处理学生查看学分和访问已修课程的请求
 * @author 梁堉
 *
 */
public class StudentPassedCourseListServlet extends HttpServlet {
	 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String id = (String) request.getParameter("name");
    	String stuID = (String) request.getSession().getAttribute("stuID");
    	// 获得学生的总学分
    	int totalCredits = new StudentCourseDAO().listTot_creditsOfAStudnt(stuID);
    	List<TakesItem> tekesList = new StudentCourseDAO().listPassedCourse(stuID);
    	request.setAttribute("totalCredits", totalCredits);
        request.setAttribute("tekesList", tekesList);
      
        request.getRequestDispatcher("studentPassedCourseList.jsp").forward(request, response);
      
 
    }
}