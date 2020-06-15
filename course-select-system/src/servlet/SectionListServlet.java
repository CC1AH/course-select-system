package servlet;
 
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import bean.SectionItem;
import dao.SectionDAO;
import dao.SectionVariableDAO;
 //���servlet


public class SectionListServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String id = (String) request.getParameter("name");
    	List<SectionItem> sectionList = new SectionDAO().list();
        request.setAttribute("sectionList", sectionList);
        request.setAttribute("sections", sectionList);
        //ѧ��ѡ��ҳ��
        if ("student".equals(id)) {
        	if(new SectionVariableDAO().getSectionVarible())
        		request.getRequestDispatcher("selectStudentCourse.jsp").forward(request, response);
        	else 
        		JOptionPane.showMessageDialog(null, "��ǰ����ѡ�ν׶�!");
        } else{
        //��ʦ����Ա�鿴ȫУ�γ�ҳ��
        	request.getRequestDispatcher("SectionList.jsp").forward(request, response);
        }
      
    }
}