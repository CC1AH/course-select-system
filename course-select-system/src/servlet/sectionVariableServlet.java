package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SectionVariableDAO;

public class sectionVariableServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
	 boolean judge_boo ;
	 String[] status = request.getParameterValues("status");
	 String value = status[0];

	 if(value.equals("true")){
	      judge_boo = true;
	    }else{
	      judge_boo = false;
	    }
	 
     new SectionVariableDAO().update(judge_boo);
     response.sendRedirect("adminWelcome.html");
     
	}
}