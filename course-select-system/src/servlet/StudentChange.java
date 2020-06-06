package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import dao.changePasswordDAO;
import dao.stuLoginDAO;

public class StudentChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	    protected void service(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	        String stuID = request.getParameter("stuID");
	    	        String oldPassword = request.getParameter("oldPassword");
	    	        String newPassword = request.getParameter("newPassword1");
	    	       
	    	        int check = new stuLoginDAO().check(stuID, oldPassword);
	    	        if(stuID!=null&&oldPassword!=null&&newPassword!=null) {
	    	        if(check == 1) {
	    	        	new changePasswordDAO().stuChange(stuID,newPassword);
	        			JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
	        			request.getRequestDispatcher("studentWelcome.html").forward(request, response);
	    	        		}else if(check == 2) {
	    	        			JOptionPane.showMessageDialog(null, "���������������");
	    	        			response.sendRedirect("stuChange.jsp");
	    	        		}else {
	    	        			JOptionPane.showMessageDialog(null, "���˺Ų����ڣ�����������");
	    	        			response.sendRedirect("stuChange.jsp");
	    	        		} 
	    	        }
	    	    }
}
