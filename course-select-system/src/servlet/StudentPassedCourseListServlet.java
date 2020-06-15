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
 * ����ѧ���鿴ѧ�ֺͷ������޿γ̵�����
 * @author ����
 *
 */
public class StudentPassedCourseListServlet extends HttpServlet {
	 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String id = (String) request.getParameter("name");
    	String stuID = (String) request.getSession().getAttribute("stuID");
    	// ���ѧ������ѧ��
    	int totalCredits = new StudentCourseDAO().listTot_creditsOfAStudnt(stuID);
    	List<TakesItem> tekesList = new StudentCourseDAO().listPassedCourse(stuID);
    	request.setAttribute("totalCredits", totalCredits);
        request.setAttribute("tekesList", tekesList);
      
        request.getRequestDispatcher("studentPassedCourseList.jsp").forward(request, response);
      
 
    }
}