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

	

	// ����ѧ����ID����ѡ�ε�course_id,sec_id,semester,year�������Ŀα���ѡ��
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

	// ����ѧ����ID��Ҫɾ����course_id,sec_id,semester,yearɾ��takes���е������
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

	// list�������г�������ѧ��ID��ѡ�����еĿγ�
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
	
	// ����һ������ѧ����ID���鿴�����޵���ѧ��
	public int listTot_creditsOfAStudnt(String studentID) {
		String sql = "SELECT tot_cred FROM student WHERE sID = ?";
		int totalCredits = 0; // ������¼ѧ����������ѧ�ֵı���
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
	
	// �г�ѧ��ͨ���Ŀγ�
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
	
	// �г�ѧ��ûͨ���Ŀγ�
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