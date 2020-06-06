package servlet;

import bean.StudentItem;
import dao.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateStudentItemServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String sID=request.getParameter("sID");
        String name = request.getParameter("name");
        String dept_name = request.getParameter("dept_name");
        int tot_cred = Integer.parseInt(request.getParameter("tot_cred"));
        StudentItem studentItem  = new StudentItem();
        studentItem.setsID(sID);
        studentItem.setName(name);
        studentItem.setDept_name(dept_name);
        studentItem.setTot_cred(tot_cred);
        
        new StudentDAO().update(studentItem);

        request.getRequestDispatcher("studentList?sID="+sID+"").forward(request, response);
    }
}