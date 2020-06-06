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
		 
		 
		 String course_id = request.getParameter("course_id");//��ȡ����Ŀγ̺�

		 String teaID = (String) request.getSession().getAttribute("teaID");//��ȡ��ǰ��ʦid
		
		 //�жϵ�ǰ��ʦ�Ƿ��������ȡ�ÿγ�ѧ���������ο���ʦ
		 if(new gradeDAO().checkIdentity(course_id, teaID)) {
		 
			 List<TakesItem> gradeList = new gradeDAO().list(course_id); //�ÿγ̺�������Ӧ��ѧ���б�
			 request.setAttribute("gradeList", gradeList);
		 
			 //��װ��course_id,��ScoreRegistrationServlet�б༭�ɼ��ɹ���������ʾ�ÿγ̵�ѧ���ɼ��б�
			 request.getSession().setAttribute("course_id", course_id);
		}
		else {
			 JOptionPane.showMessageDialog(null, "�Բ��������Ǹÿγ̵��ν���ʦ��û��Ȩ�ޱ༭�ÿγ�ѧ���ɼ�!"); 
		 }
		 
		 request.getRequestDispatcher("scoreRegistration.jsp").forward(request, response);
		 
	 }
}
