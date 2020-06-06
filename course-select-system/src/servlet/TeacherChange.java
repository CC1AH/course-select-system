package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import dao.changePasswordDAO;
import dao.teaLoginDAO;


public class TeacherChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	    protected void service(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	    	        String teaID = request.getParameter("teaID");
	    	        String oldPassword = request.getParameter("oldPassword");
	    	        String newPassword = request.getParameter("newPassword1");
	    	        int check = new teaLoginDAO().check(teaID, oldPassword);
	    	        if(teaID!=null&&newPassword!=null&&oldPassword!=null) {
	    	        if(check == 1) {
	    	        	new changePasswordDAO().teaChange(teaID,newPassword);
	        			JOptionPane.showMessageDialog(null, "修改成功！");
	        			request.getRequestDispatcher("teacherWelcome.html").forward(request, response);
	    	        		}else if(check == 2) {
	    	        			JOptionPane.showMessageDialog(null, "旧密码错误，请重试");
	    	        			response.sendRedirect("teaChange.jsp");
	    	        		}else {
	    	        			JOptionPane.showMessageDialog(null, "该账号不存在，请重新输入");
	    	        			response.sendRedirect("teaChange.jsp");
	    	        		} 	   	 
	    	        	}
	    	        }
}
