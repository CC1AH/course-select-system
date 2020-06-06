package servlet;

import bean.InstructorItem;
import dao.InstructorDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateInstructorItemServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String tID=request.getParameter("tID");
        String name = request.getParameter("name");
        String dept_name = request.getParameter("dept_name");
        int salary = Integer.parseInt(request.getParameter("salary"));
        InstructorItem instructorItem  = new InstructorItem();
        instructorItem.settID(tID);
        instructorItem.setName(name);
        instructorItem.setDept_name(dept_name);
        instructorItem.setSalary(salary);
        
        new InstructorDAO().update(instructorItem);

        request.getRequestDispatcher("instructorOprate?ID="+tID+"").forward(request, response);
    }
}