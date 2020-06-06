package servlet;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import dao.teaLoginDAO;
 
public class TeacherLogin extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	        String teaID = request.getParameter("teacherID");
    	        String teaPassword = request.getParameter("teacherPassword");
    	        int check = new teaLoginDAO().check(teaID, teaPassword);
    	        if(teaID!=null&&teaPassword!=null) {
    	        if(check == 1) {
    	        	request.getSession().setAttribute("teaID", teaID); 
    	    	  JOptionPane.showMessageDialog(null, "登陆成功！");
        			request.getRequestDispatcher("teacherWelcome.html").forward(request, response);
    
    	      }else if(check == 2) {
    	    	  JOptionPane.showMessageDialog(null, "密码错误，请重试");
    	    	  response.sendRedirect("teacherLogin.html");
    	      }else {
    	    	  JOptionPane.showMessageDialog(null, "账号不存在，请重新输入");
    	    	  response.sendRedirect("teacherLogin.html");
    	      }	    	 
    	  }
    }
}
