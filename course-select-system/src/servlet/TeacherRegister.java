package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import dao.teaRegisterDAO;


public class TeacherRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	    protected void service(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	        String teaID = request.getParameter("teaID");
	    	        String name = request.getParameter("name");
	    	        String dept_name = request.getParameter("dept_name");
	    	        String salary = request.getParameter("salary");
	    	        String teaPassword = request.getParameter("password1");
	    	        
	    	        boolean check = new teaRegisterDAO().check(teaID);
	    	        if(teaID!=null&&name!=null&&dept_name!=null&&
	    	        		salary!=null&&teaPassword!=null) {
	    	        if(check) {
	    	        	JOptionPane.showMessageDialog(null, "���˺��ѱ�ע�ᣬ����������");
	    	        	response.sendRedirect("teaRegister.jsp");
	    	        }else {
	    	        	new teaRegisterDAO().add(teaID,name,dept_name,Integer.parseInt(salary),teaPassword);
	    	        	//����¼�������ݿ�	
	    	        	JOptionPane.showMessageDialog(null, "ע��ɹ���");
	    	        	request.getRequestDispatcher("teacherWelcome.html").forward(request, response);
	    	        	}
	    	        }
	    	    }

}
