package servlet;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import dao.admLoginDAO;
 
public class AdminLogin extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	        String admID = request.getParameter("adminID");
    	        String admPassword = request.getParameter("adminPassword");
    	        int check = new admLoginDAO().check(admID, admPassword);
    	        if(admID!=null&&admPassword!=null) {
    	        if(check == 1) {
    	    	  JOptionPane.showMessageDialog(null, "登陆成功！");
    	    	  request.getSession().setAttribute("admID", admID); 
        			request.getRequestDispatcher("adminWelcome.html").forward(request, response);
    	      }else if(check == 2) {
    	    	  JOptionPane.showMessageDialog(null, "密码错误，请重试");
    	    	  response.sendRedirect("admLogin.jsp");
    	      }else {
    	    	  JOptionPane.showMessageDialog(null, "账号不存在，请重新输入");
    	    	  response.sendRedirect("admLogin.jsp");
    	      }	  		
    	    }
    	 
    	    }
    }
