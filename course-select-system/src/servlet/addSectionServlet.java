package servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.SectionItem;
import dao.SectionDAO;
 

public class addSectionServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String course_id = request.getParameter("course_id");
        String sec_id = request.getParameter("sec_id");
        String semester = request.getParameter("semester");
        int year  = Integer.parseInt(request.getParameter("year"));
        String building = request.getParameter("building");
        int room_no  = Integer.parseInt(request.getParameter("room_no"));
        String time_slot_id = request.getParameter("time_slot_id");
        
        
        SectionItem section = new SectionItem();
        section.setCourse_id(course_id);
        section.setSec_id(sec_id);
        section.setSemester(semester);
        section.setYear(year);
        section.setBuilding(building);
        section.setRoom_no(room_no);
        section.setTime_slot_id(time_slot_id);
        
     
        new SectionDAO().add(section);

        response.sendRedirect("listSection?name=adm");

    }
}

