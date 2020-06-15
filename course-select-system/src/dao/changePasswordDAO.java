package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import bean.DBInfos;

public class changePasswordDAO {

	public void stuChange(String stuID,String password) {
	
	try {
		Class.forName(DBInfos.DRIVER);
    	Connection conn = DriverManager.getConnection(DBInfos.ConNam,DBInfos.usrNam,
				DBInfos.DbPasWrd);	
    	String sql = "update student set password=? where sID="+stuID;
    	//更新密码
    	PreparedStatement ps = conn.prepareStatement(sql);
    	ps.setString(5,password);
    	ps.executeUpdate();
    	
    	ps.close();
    	conn.close();	
	} catch (Exception e) {
		e.printStackTrace();
	}
  }
	
	public void teaChange(String teaID,String password) {
		
		try {
			 Class.forName(DBInfos.DRIVER);
		    	Connection conn = DriverManager.getConnection(DBInfos.ConNam,DBInfos.usrNam,
						DBInfos.DbPasWrd);
	    	String sql = "update instructor set password=? where tID="+teaID;
	    	//更新密码
	    	PreparedStatement ps = conn.prepareStatement(sql);
	    	ps.setString(5,password);
	    	ps.executeUpdate();
	    	
	    	ps.close();
	    	conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	
	public void admChange(String admID,String password) {
		
		try {
			Class.forName(DBInfos.DRIVER);
	    	Connection conn = DriverManager.getConnection(DBInfos.ConNam,DBInfos.usrNam,
					DBInfos.DbPasWrd);	
	    	String sql = "update administrator set password=? where admID="+admID;
	    	//更新密码
	    	PreparedStatement ps = conn.prepareStatement(sql);
	    	ps.setString(2,password);
	    	ps.executeUpdate();
	    	
	    	ps.close();
	    	conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
}
