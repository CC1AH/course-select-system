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
    	String sql = "update student set password=? where stuID="+stuID;
    	//��������
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
	    	String sql = "update instructor set password=? where stuID="+teaID;
	    	//��������
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
			Class.forName("com.mysql.jdbc.Driver");
	    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/��ѧ��ѡ��?useSSL=false&serverTimezone=UTC","root",
					"111");
	    	String sql = "update administrator set password=? where stuID="+admID;
	    	//��������
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