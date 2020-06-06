package servlet;

import java.io.IOException;
import bean.TakesItem;
import java.util.*;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import dao.StudentDAO;
import bean.StudentItem;
import dao.InstructorDAO;
import bean.InstructorItem;

public class informationCRUDServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String ID = (String)request.getParameter("ID");
        String[] status = request.getParameterValues("status");
        String value = status[0];   
        
        if ("student".equals(value)) {
        	List<StudentItem> studentList = new StudentDAO().list(ID);
        	request.setAttribute("studentList", studentList);
        	request.getRequestDispatcher("StudentOprate.jsp").forward(request, response);  //修改学生信息
        }else{
        	List<InstructorItem> InstructorList = new InstructorDAO().list(ID);
            request.setAttribute("instructorList", InstructorList);
            request.getRequestDispatcher("instructorOprate.jsp").forward(request, response);  //查看学生教师信息
        }

    }
 
}