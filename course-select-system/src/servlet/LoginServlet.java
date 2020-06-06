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
        //�ȼٶ����˺���10236������123
        if ("10236".equals(studentID) && "111".equals(StudentPassword)) {
//        	JOptionPane.showMessageDialog(null, "��¼�ɹ�����ӭ��");
        	request.getSession().setAttribute("stuID", studentID);  //�����װ����studentID
            response.sendRedirect("studentWelcome.html");
        } else {
//        	JOptionPane.showMessageDialog(null, "�û������������������!");
            response.sendRedirect("studentLogin.html");
        }
        */
    	
        String studentID = request.getParameter("studentID");
        String StudentPassword = request.getParameter("StudentPassword");
  
        
        int check = new stuLoginDAO().check(studentID, StudentPassword);
        if(studentID!=null&&StudentPassword!=null) {
        if(check == 1) {
    	  JOptionPane.showMessageDialog(null, "��½�ɹ���");
    	  request.getSession().setAttribute("stuID", studentID);  
			request.getRequestDispatcher("studentWelcome.html").forward(request, response);
			
      }else if(check == 2) {
    	  JOptionPane.showMessageDialog(null, "�������������");
    	  response.sendRedirect("studentLogin.html");
      }else {
    	  JOptionPane.showMessageDialog(null, "�˺Ų����ڣ�����������");
    	  response.sendRedirect("studentLogin.html");
      }	    	
 
    }
}
    }