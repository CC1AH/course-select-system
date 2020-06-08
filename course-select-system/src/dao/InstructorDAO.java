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
import bean.InstructorItem;


public class InstructorDAO {

	public InstructorDAO() {
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
	public List<InstructorItem> list(String tID) {
		return list(0, Integer.MAX_VALUE,tID);
	}

	public List<InstructorItem> list(int start, int count, String teacherID) {
		List<InstructorItem> instructorList = new ArrayList<InstructorItem>();

		String sql = "select * from instructor where teaID = ?";

		try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, teacherID);
//			ps.setInt(1, start);
//			ps.setInt(2, count);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				InstructorItem instructorItem = new InstructorItem();

				String tID = rs.getString(1);
				String name = rs.getString(2);
				String dept_name = rs.getString(3);
				int salary = rs.getInt(4);
				
		
				instructorItem.settID(tID);
				instructorItem.setName(name);
				instructorItem.setDept_name(dept_name);
				instructorItem.setSalary(salary);
			
				instructorList.add(instructorItem);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return instructorList;
	}
	   public void add(InstructorItem instructor) {
		   
	        String sql = "insert into instructor values(?,?,?,?)";
	        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	       
	        	ps.setString(1, instructor.tID);
	            ps.setString(2, instructor.name);
	            ps.setString(3, instructor.dept_name);
	            ps.setInt(4, instructor.salary);
	  
	            ps.execute();
	  
	           
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	    }
	   public InstructorItem get(String tID) {
		   InstructorItem instructorItem = null;
	  
	        try (Connection c = getConnection(); Statement s = c.createStatement();) {
	  
	            String sql = "select * from instructor where teaID = " + tID;
	  
	            ResultSet rs = s.executeQuery(sql);
	  
	            if (rs.next()) {
	            	instructorItem = new InstructorItem();
	//                String sID = rs.getString(1);
	                String name = rs.getString(2);
	                String dept_name = rs.getString(3);
	                int salary = rs.getInt(4);
	               
	                instructorItem.tID = tID;
	                instructorItem.name = name;
	                instructorItem.dept_name = dept_name;
	                instructorItem.salary = salary;
	            }
	  
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	        return instructorItem;
	    }
	   public void update(InstructorItem instructorItem) {
		   
	        String sql = "update instructor set name = ? , dept_name = ? , salary = ? where teaID = ?";
	        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	  
	            ps.setString(1,instructorItem.name);
	            ps.setString(2,instructorItem.dept_name);
	            ps.setInt(3,instructorItem.salary);
	            ps.setString(4, instructorItem.tID);
	  
	            ps.execute();
	  
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	  
	    }
}