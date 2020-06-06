package servlet;

import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import bean.TakesItem;
import dao.gradeDAO;


public class ScoreListServlet extends HttpServlet {
	 protected void service(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException { 
		 
		 
		 String course_id = request.getParameter("course_id");//获取传入的课程号

		 String teaID = (String) request.getSession().getAttribute("teaID");//获取当前教师id
		
		 //判断当前教师是否是请求获取该课程学生名单的任课老师
		 if(new gradeDAO().checkIdentity(course_id, teaID)) {
		 
			 List<TakesItem> gradeList = new gradeDAO().list(course_id); //用课程号搜索对应的学生列表
			 request.setAttribute("gradeList", gradeList);
		 
			 //封装该course_id,在ScoreRegistrationServlet中编辑成绩成功后仍能显示该课程的学生成绩列表
			 request.getSession().setAttribute("course_id", course_id);
		}
		else {
			 JOptionPane.showMessageDialog(null, "对不起，您不是该课程的任教老师，没有权限编辑该课程学生成绩!"); 
		 }
		 
		 request.getRequestDispatcher("scoreRegistration.jsp").forward(request, response);
		 
	 }
}
