package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.TakesItem;
import bean.DBInfos;

public class StudentCourseDAO {

	public StudentCourseDAO() {
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

	

	// 根据学生的ID和他选课的course_id,sec_id,semester,year增加他的课表，即选课
	public void add(String stu_id, String course_id, String sec_id, String semester, int year) {

		String sql = "insert into takes values(?,?,?,?,?,0)";
		try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);)

		{

			ps.setString(1, stu_id);
			ps.setString(2, course_id);
			ps.setString(3, sec_id);
			ps.setString(4, semester);
			ps.setInt(5, year);

			ps.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// 根据学生的ID和要删除的course_id,sec_id,semester,year删除takes表中的这个课
	public void delete(String stu_id, String course_id, String sec_id, String semester, int year) {
		String sql = "delete from takes where sID = ? and course_id = ? and sec_id = ? and semester = ? "
				+ "and year = ?";

		try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, stu_id);
			ps.setString(2, course_id);
			ps.setString(3, sec_id);
			ps.setString(4, semester);
			ps.setInt(5, year);
			ps.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// list函数是列出给定的学生ID所选的所有的课程
	public List<TakesItem> list(String studentID) {
		return list(0, Integer.MAX_VALUE, studentID);
	}

	public List<TakesItem> list(int start, int count, String studentID) {
		List<TakesItem> tekesList = new ArrayList<TakesItem>();

		String sql = "select * from takes where sID = ? limit ?,? ";

		try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, studentID);
			ps.setInt(2, start);
			ps.setInt(3, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TakesItem takesItem = new TakesItem();
				String ID = rs.getString(1);
				String course_id = rs.getString(2);
				String sec_id = rs.getString(3);
				String semester = rs.getString(4);
				int year = rs.getInt(5);
				double grade = rs.getDouble(6);

				takesItem.setID(ID);
				takesItem.setCourse_id(course_id);
				takesItem.setSec_id(sec_id);
				takesItem.setSemester(semester);
				takesItem.setYear(year);
				takesItem.setGrade(grade);

				tekesList.add(takesItem);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return tekesList;
	}
	
	// 新增一个根据学生的ID，查看他所修的总学分
	public int listTot_creditsOfAStudnt(String studentID) {
		String sql = "SELECT tot_cred FROM student WHERE sID = ?";
		int totalCredits = 0; // 用来记录学生的已修总学分的变量
		try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, studentID);
			

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				totalCredits = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCredits;
	}
	
	// 列出学生通过的课程
	public List<TakesItem> listPassedCourse(String studentID) {
		List<TakesItem> tekesList = new ArrayList<TakesItem>();

		String sql = "select * from takes where sID = ? && grade >= 60";

		try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, studentID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TakesItem takesItem = new TakesItem();
				String ID = rs.getString(1);
				String course_id = rs.getString(2);
				String sec_id = rs.getString(3);
				String semester = rs.getString(4);
				int year = rs.getInt(5);
				double grade = rs.getDouble(6);

				takesItem.setID(ID);
				takesItem.setCourse_id(course_id);
				takesItem.setSec_id(sec_id);
				takesItem.setSemester(semester);
				takesItem.setYear(year);
				takesItem.setGrade(grade);

				tekesList.add(takesItem);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return tekesList;
	}
	
	// 列出学生没通过的课程
	public List<TakesItem> listNotPassedCourse(String studentID) {
		List<TakesItem> tekesList = new ArrayList<TakesItem>();

		String sql = "select * from takes where sID = ? && grade < 60";

		try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, studentID);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TakesItem takesItem = new TakesItem();
				String ID = rs.getString(1);
				String course_id = rs.getString(2);
				String sec_id = rs.getString(3);
				String semester = rs.getString(4);
				int year = rs.getInt(5);
				double grade = rs.getDouble(6);

				takesItem.setID(ID);
				takesItem.setCourse_id(course_id);
				takesItem.setSec_id(sec_id);
				takesItem.setSemester(semester);
				takesItem.setYear(year);
				takesItem.setGrade(grade);

				tekesList.add(takesItem);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return tekesList;
	}
}