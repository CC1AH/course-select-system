package servlet;

import java.io.IOException;
import bean.TakesItem;
import bean.TeachesItem;
import java.util.*;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import dao.StudentCourseDAO;
import dao.TeacherCourseDAO;

public class StudentOrTeacher extends HttpServlet {
 

	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String ID = (String)request.getParameter("ID");
        String status = request.getParameter("status");
        
        if ("student".equals(status)) {
        	List<TakesItem> tekesList = new StudentCourseDAO().list(ID);
            request.setAttribute("tekesList", tekesList);
            request.getRequestDispatcher("StudentCourseOperate.jsp").forward(request, response);  //查看学生选课信息
        } else {
        	List<TeachesItem> teachesList = new TeacherCourseDAO().list(ID);
            request.setAttribute("teachesList", teachesList);
            request.getRequestDispatcher("TeacherCourseList.jsp").forward(request, response);  //查看学生教师信息
        }
 		
    }
 
}