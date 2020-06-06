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
	
		//�����û��Ƿ�����
		try{
			double grade = Double.parseDouble(request.getParameter("grade"));
			
			//���½�ʦ¼��ĳɼ�,�������ֵΪtrue˵�����³ɹ�
			if(new gradeDAO().updateScore(request.getParameter("stuID"),grade)){
				JOptionPane.showMessageDialog(null, "�༭�ɹ�!"); 
			}else
				JOptionPane.showMessageDialog(null, "�༭ʧ��!"); 
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "����ɼ���Ч!");
		}
		
		//��ȡcourse_id���´���ScoreListServlet,�༭�ɼ��ɹ���������ʾ�ղŵ�ѧ���ɼ��б������Ҫ�����������൱��ˢ�£�
		String course_id =(String) request.getSession().getAttribute("course_id");
		request.getRequestDispatcher("scoreList?course_id="+course_id+"").forward(request, response);
    }
	
}
