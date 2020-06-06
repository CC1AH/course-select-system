package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.DBInfos;
import bean.SectionItem;

public class SectionDAO {

	public SectionDAO() {
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
	// list函数是列出所有的section
	

	public List<SectionItem> list() {
		List<SectionItem> sectionList = new ArrayList<SectionItem>();

		
		String sql = "SELECT course_id,"
				+ "sec_id,"
				+ "semester,"
				+ "YEAR,"
				+ "title," // 课程名
				+ "NAME,"  // 教师名
				+ "credits,"  // 学分
				+ "course.`dept_name`,"  // 课程所在的系
				+ "building,"  //课所在的大楼
				+ "room_no,"  //房间号
				+ "DAY,"
				+ "start_time,"
				+ "end_time "
				+ "FROM section "
				+ "NATURAL JOIN teaches "
				+ "NATURAL JOIN instructor "
				+ "JOIN course USING(course_id) "
				+ "NATURAL JOIN "
				+ "time_slot";

		try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				SectionItem sectionItem = new SectionItem();

				String course_id = rs.getString(1);
				String sec_id = rs.getString(2);
				String semester = rs.getString(3);
				int year = rs.getInt(4);
				String courseName = rs.getString(5);
				String teacherName = rs.getString(6);
				int credits = rs.getInt(7);
				String departname = rs.getString(8);
				String building = rs.getString(9);
				int room_no = rs.getInt(10);
				String day = rs.getString(11);
				String start_time = rs.getString(12);
				String end_time = rs.getString(13);
				
				sectionItem.setCourse_id(course_id);
				sectionItem.setSec_id(sec_id);
				sectionItem.setSemester(semester);
				sectionItem.setYear(year);
				sectionItem.setCourseName(courseName);
				sectionItem.setTeacherName(teacherName);
				sectionItem.setCredits(credits);
				sectionItem.setDepartname(departname);
				sectionItem.setBuilding(building);
				sectionItem.setRoom_no(room_no);
				sectionItem.setDay(day);
				sectionItem.setStart_time(start_time);
				sectionItem.setEnd_time(end_time);

				sectionList.add(sectionItem);
			}
			
			//关闭连接
			rs.close();
			ps.close();
			c.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return sectionList;
	}

	public List<SectionItem> listOnCourseTitle(String courseTitle) {
		List<SectionItem> sectionList = new ArrayList<SectionItem>();
		// 先通过course的title找到course的ID号保存在course_id中
		String sql = "select * from course where title = ?";
		String course_idForSection = null;
		try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, courseTitle);
		

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				course_idForSection = rs.getString(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		// 再通过course_id在section表中找到section
		String sqlForSection = "SELECT course_id,"
				+ "sec_id,"
				+ "semester,"
				+ "YEAR,"
				+ "title," // 课程名
				+ "NAME,"  // 教师名
				+ "credits,"  // 学分
				+ "course.`dept_name`,"  // 课程所在的系
				+ "building,"  //课所在的大楼
				+ "room_no,"  //房间号
				+ "DAY,"
				+ "start_time,"
				+ "end_time "
				+ "FROM section "
				+ "NATURAL JOIN teaches "
				+ "NATURAL JOIN instructor "
				+ "JOIN course USING(course_id) "
				+ "NATURAL JOIN "
				+ "time_slot"
				+ " where course_id = ? ";
		
		try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sqlForSection);) {

			
			ps.setString(1, course_idForSection);
			

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				SectionItem sectionItem = new SectionItem();

				String course_id = rs.getString(1);
				String sec_id = rs.getString(2);
				String semester = rs.getString(3);
				int year = rs.getInt(4);
				String courseName = rs.getString(5);
				String teacherName = rs.getString(6);
				int credits = rs.getInt(7);
				String departname = rs.getString(8);
				String building = rs.getString(9);
				int room_no = rs.getInt(10);
				String day = rs.getString(11);
				String start_time = rs.getString(12);
				String end_time = rs.getString(13);
				
				sectionItem.setCourse_id(course_id);
				sectionItem.setSec_id(sec_id);
				sectionItem.setSemester(semester);
				sectionItem.setYear(year);
				sectionItem.setCourseName(courseName);
				sectionItem.setTeacherName(teacherName);
				sectionItem.setCredits(credits);
				sectionItem.setDepartname(departname);
				sectionItem.setBuilding(building);
				sectionItem.setRoom_no(room_no);
				sectionItem.setDay(day);
				sectionItem.setStart_time(start_time);
				sectionItem.setEnd_time(end_time);

				sectionList.add(sectionItem);
			}
			
			//关闭连接
			rs.close();
			ps.close();
			c.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return sectionList;
	}
	/*何明锦 加的方法*/
	 public void add(SectionItem section) {
		   
	        String sql = "insert into section values(?,?,?,?,?,?,?)";
	        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	       
	        	ps.setString(1, section.course_id);
	            ps.setString(2, section.sec_id);
	            ps.setString(3, section.semester);
	            ps.setInt(4, section.year);
	            ps.setString(5, section.building);
	            ps.setInt(6,section.room_no);
	            ps.setString(7,section.time_slot_id);
	            ps.execute();
	  
	           
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	    }
	
}
