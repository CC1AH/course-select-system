package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import bean.TakesItem;
import dao.StudentCourseDAO;
import dao.gradeDAO;

public class ScoreRegistrationServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	
		//捕获用户非法输入
		try{
			double grade = Double.parseDouble(request.getParameter("grade"));
			
			//更新教师录入的成绩,如果返回值为true说明更新成功
			if(new gradeDAO().updateScore(request.getParameter("stuID"),grade)){
				JOptionPane.showMessageDialog(null, "编辑成功!"); 
			}else
				JOptionPane.showMessageDialog(null, "编辑失败!"); 
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "输入成绩无效!");
		}
		
		//获取course_id重新传给ScoreListServlet,编辑成绩成功后仍能显示刚才的学生成绩列表而不需要重新搜索（相当于刷新）
		String course_id =(String) request.getSession().getAttribute("course_id");
		request.getRequestDispatcher("scoreList?course_id="+course_id+"").forward(request, response);
    }
	
}
