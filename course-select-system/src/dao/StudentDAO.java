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
import bean.StudentItem;

public class StudentDAO {

	public StudentDAO() {
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
	public List<StudentItem> list(String studentID) {
		return list(0, Integer.MAX_VALUE,studentID);
	}

	public List<StudentItem> list(int start, int count, String studentID) {
		List<StudentItem> studentList = new ArrayList<StudentItem>();

		String sql = "select * from student where stuID = ?";

		try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, studentID);
//			ps.setInt(1, start);
//			ps.setInt(2, count);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				StudentItem studentItem = new StudentItem();

				String sID = rs.getString(1);
				String name = rs.getString(2);
				String dept_name = rs.getString(3);
				int tot_cred = rs.getInt(4);
				
				
				studentItem.setsID(sID);
				studentItem.setName(name);
				studentItem.setDept_name(dept_name);
				studentItem.setTot_cred(tot_cred);
			
				studentList.add(studentItem);
				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return studentList;
	}
	   public void add(StudentItem student) {
		   
	        String sql = "insert into student values(?,?,?,?)";
	        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	       
	        	ps.setString(1, student.sID);
	            ps.setString(2, student.name);
	            ps.setString(3, student.dept_name);
	            ps.setInt(4, student.tot_cred);
	  
	            ps.execute();
	  
	           
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	    }
	   public void delete(String sID) {
		    String sql = "delete from student where course_id = ?" ;
		    
	        try (Connection c = getConnection(); PreparedStatement s = c.prepareStatement(sql);) {
	        	s.setString(1, sID);
	         
	            s.execute();
	  
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	    }
	   
	   public StudentItem get(String sID) {
		   StudentItem studentItem = null;
	  
	        try (Connection c = getConnection(); Statement s = c.createStatement();) {
	  
	            String sql = "select * from student where sID = " + sID;
	  
	            ResultSet rs = s.executeQuery(sql);
	  
	            if (rs.next()) {
	            	studentItem = new StudentItem();
	//                String sID = rs.getString(1);
	                String name = rs.getString(2);
	                String dept_name = rs.getString(3);
	                int tot_cred = rs.getInt(4);
	               
	                studentItem.sID = sID;
	                studentItem.name = name;
	                studentItem.dept_name = dept_name;
	                studentItem.tot_cred = tot_cred;
	            }
	  
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	        return studentItem;
	    }
	   
	   public void update(StudentItem studentItem) {
		   
	        String sql = "update student set name = ? , dept_name = ? , tot_cred = ? where sID = ?";
	        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
	  
	            ps.setString(1, studentItem.name);
	            ps.setString(2, studentItem.dept_name);
	            ps.setInt(3, studentItem.tot_cred);
	            ps.setString(4, studentItem.sID);
	  
	            ps.execute();
	  
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	  
	    }
}
