package servlet;

import bean.StudentItem;
import dao.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class editStudentNameServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sID = request.getParameter("sID");
        String name = request.getParameter("name");
        StudentItem studentItem =new StudentDAO().get(sID);
        request.setAttribute("studentItem", studentItem);
        request.getRequestDispatcher("editStudentName.jsp").forward(request, response);
    }
}