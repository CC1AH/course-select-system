package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import dao.admRegisterDAO;


public class AdministratorRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	    protected void service(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	        String admID = request.getParameter("admID");	        
	    	        String admPassword = request.getParameter("password1");
	    	        	    	        
	    	        boolean check = new admRegisterDAO().check(admID);
	    	        if(admID!=null&&admPassword!=null) {
	    	        if(check) {
	    	        	JOptionPane.showMessageDialog(null, "该账号已被注册，请重新输入");
	    	        	response.sendRedirect("admRegister.jsp");
	    	        }else if(admID!=null&&admPassword!=null) {
	    	        	new admRegisterDAO().add(admID,admPassword);
	    	        	//将记录插入数据库	
	    	        	JOptionPane.showMessageDialog(null, "注册成功！");
	    	        	request.getRequestDispatcher("administratorWelcome.html").forward(request, response);
	    	        	}
	    	        }		 
	    	    }
}
