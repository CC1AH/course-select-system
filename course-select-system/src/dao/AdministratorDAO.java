package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.AdministratorItem;
import bean.DBInfos;
import bean.StudentItem;

public class AdministratorDAO {

		public AdministratorDAO() {
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
		
		 public void update(AdministratorItem administrator) {
			   
		        String sql = "update administrator set password = ? where admID = ?";
		        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
		        	
		        	ps.setString(1, administrator.password);
		            ps.setString(2, administrator.admID);
		         
		          
		  
		            ps.execute();
		  
		        } catch (SQLException e) {
		  
		            e.printStackTrace();
		        }
		  
		    }
		 
		 public  AdministratorItem get(String ID) {
			 AdministratorItem administratorItem = null;
		  
		        try (Connection c = getConnection(); Statement s = c.createStatement();) {
		  
		            String sql = "select * from administrator where admID = " + ID;
		  
		            ResultSet rs = s.executeQuery(sql);
		  
		            if (rs.next()) {
		            	administratorItem = new AdministratorItem();
		         //   	String sID = rs.getString(1);
		                String admID = rs.getString(1);
		                String password = rs.getString(2);
		            
		               
		                administratorItem.admID = admID;
		                administratorItem.password = password;
		              
		            }
		  
		        } catch (SQLException e) {
		  
		            e.printStackTrace();
		        }
		        return administratorItem;
		    }
}
