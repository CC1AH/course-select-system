package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import dao.stuRegisterDAO;


public class StudentRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	    protected void service(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	        String stuID = request.getParameter("stuID");
	    	        String name = request.getParameter("name");
	    	        String dept_name = request.getParameter("dept_name");
	    	        String tot_cred = request.getParameter("tot_cred");
	    	        String stuPassword = request.getParameter("password1");
	    	        
	    	        boolean check = new stuRegisterDAO().check(stuID);
	    	        if(stuID!=null&&name!=null&&dept_name!=null&&
	    	        		tot_cred!=null&&stuPassword!=null) {
	    	        if(check) {
	    	        	JOptionPane.showMessageDialog(null, "���˺��ѱ�ע�ᣬ����������");
	    	        	response.sendRedirect("stuRegister.jsp");
	    	        }else{
	    	        	new stuRegisterDAO().add(stuID,name,dept_name,Integer.parseInt(tot_cred),stuPassword);
	    	        	//����¼�������ݿ�	
	    	        	JOptionPane.showMessageDialog(null, "ע��ɹ���");
	    	        	request.getRequestDispatcher("studentWelcome.html").forward(request, response);
	    	        	}
	    	        }
	    	    }

}
