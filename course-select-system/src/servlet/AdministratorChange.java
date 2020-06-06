package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import dao.changePasswordDAO;
import dao.admLoginDAO;


public class AdministratorChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	    protected void service(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	        String admID = request.getParameter("admID");
	    	        String oldPassword = request.getParameter("oldPassword");
	    	        String newPassword = request.getParameter("newPassword1");
	    	        	    	        	        
	    	        int check = new admLoginDAO().check(admID, oldPassword);
	    	        if(admID!=null&&oldPassword!=null&&newPassword!=null) {
	    	        if(check == 1) {
	    	        	new changePasswordDAO().admChange(admID,newPassword);
	        			JOptionPane.showMessageDialog(null, "修改成功！");
	        			request.getRequestDispatcher("administratorWelcome.html").forward(request, response);
	    	       
	    	        		}else if(check == 2) {
	    	        			JOptionPane.showMessageDialog(null, "旧密码错误，请重试");
	    	        			response.sendRedirect("admChange.jsp");
	    	        		}else {
	    	        			JOptionPane.showMessageDialog(null, "该账号不存在，请重新输入");
	    	        			response.sendRedirect("admChange.jsp");
	    	        		}
	    	        }
	    	   }    	
}
