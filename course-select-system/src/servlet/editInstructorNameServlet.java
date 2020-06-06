package servlet;

import bean.InstructorItem;
import dao.InstructorDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class editInstructorNameServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tID = request.getParameter("tID");
        String name = request.getParameter("name");
        InstructorItem instructorItem =new InstructorDAO().get(tID);
        request.setAttribute("InstructorItem", instructorItem);
        request.getRequestDispatcher("editInstructorName.jsp").forward(request, response);
    }
}