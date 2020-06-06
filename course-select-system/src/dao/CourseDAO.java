package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.CourseItem;
import bean.DBInfos;

public class CourseDAO {

	public CourseDAO() {
		try {
			Class.forName(DBInfos.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				DBInfos.ConNam,DBInfos.usrNam,
				DBInfos.DbPasWrd);
	}
	// list函数是列出所有的course
	public List<CourseItem> list() {
		return list(0, Integer.MAX_VALUE);
	}

	public List<CourseItem> list(int start, int count) {
		List<CourseItem> courseList = new ArrayList<CourseItem>();

		String sql = "select * from course limit ?,? ";

		try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			
			ps.setInt(1, start);
			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CourseItem courseItem = new CourseItem();

				String course_id = rs.getString(1);
				String title = rs.getString(2);
				String dept_name = rs.getString(3);
				int credits = rs.getInt(4);
				
				
				courseItem.setCourse_id(course_id);
				courseItem.setTitle(title);
				courseItem.setDept_name(dept_name);
				courseItem.setCredits(credits);
			
				courseList.add(courseItem);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return courseList;
	}
	   public void add(CourseItem course) {
		   
	        String sql = "insert into course values(?,?,?,?)";
	        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	       
	        	ps.setString(1, course.course_id);
	            ps.setString(2, course.title);
	            ps.setString(3, course.dept_name);
	            ps.setInt(4, course.credits);
	  
	            ps.execute();
	  
	           
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	    }
	   public void delete(String course_id) {
		    String sql = "delete from course where course_id = ?" ;
		    
	        try (Connection c = getConnection(); PreparedStatement s = c.prepareStatement(sql);) {
	        	s.setString(1, course_id);
	         
	            s.execute();
	  
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	    }
}
