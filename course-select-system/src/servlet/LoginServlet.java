package servlet;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import dao.stuLoginDAO;
 
public class LoginServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	/*
        String studentID = request.getParameter("studentID");
        String StudentPassword = request.getParameter("StudentPassword");
        //先假定了账号是10236密码是123
        if ("10236".equals(studentID) && "111".equals(StudentPassword)) {
//        	JOptionPane.showMessageDialog(null, "登录成功，欢迎你");
        	request.getSession().setAttribute("stuID", studentID);  //请求封装属性studentID
            response.sendRedirect("studentWelcome.html");
        } else {
//        	JOptionPane.showMessageDialog(null, "用户名或密码错误，请重试!");
            response.sendRedirect("studentLogin.html");
        }
        */
    	
        String studentID = request.getParameter("studentID");
        String StudentPassword = request.getParameter("StudentPassword");
  
        
        int check = new stuLoginDAO().check(studentID, StudentPassword);
        if(studentID!=null&&StudentPassword!=null) {
        if(check == 1) {
    	  JOptionPane.showMessageDialog(null, "登陆成功！");
    	  request.getSession().setAttribute("stuID", studentID);  
			request.getRequestDispatcher("studentWelcome.html").forward(request, response);
			
      }else if(check == 2) {
    	  JOptionPane.showMessageDialog(null, "密码错误，请重试");
    	  response.sendRedirect("studentLogin.html");
      }else {
    	  JOptionPane.showMessageDialog(null, "账号不存在，请重新输入");
    	  response.sendRedirect("studentLogin.html");
      }	    	
 
    }
}
    }