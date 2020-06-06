package servlet;

import bean.InstructorItem;
import dao.InstructorDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class editInstructorDept_nameServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tID = request.getParameter("tID");
        String dept_name = request.getParameter("dept_name");
        InstructorItem instructorItem = new InstructorDAO().get(tID);
        request.setAttribute("InstructorItem", instructorItem);
        request.getRequestDispatcher("editInstructorDept_name.jsp").forward(request, response);
    }
}