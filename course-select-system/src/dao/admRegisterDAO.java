package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import bean.AdministratorItem;
import bean.DBInfos;

public class admRegisterDAO {
	
	public void add(String id,String password) {
		
	try {
		Class.forName(DBInfos.DRIVER);
    	Connection conn = DriverManager.getConnection(DBInfos.ConNam,DBInfos.usrNam,
				DBInfos.DbPasWrd);	
    	String sql = "insert into administrator(admID,password)values(?,?)";
    	//添加数据
    	PreparedStatement ps = conn.prepareStatement(sql);
    	ps.setString(1,id);
    	ps.setString(2,password);
    	ps.executeUpdate();
    	
    	ps.close();
    	conn.close();	
	} catch (Exception e) {
		e.printStackTrace();
	}
  }
	
	 public boolean check(String id) {  
	    	//ArrayList<String> list = new ArrayList<String>();
		 List<AdministratorItem> admList = new ArrayList<AdministratorItem>();	
		 try {
			 Class.forName(DBInfos.DRIVER);
		    	Connection conn = DriverManager.getConnection(DBInfos.ConNam,DBInfos.usrNam,
						DBInfos.DbPasWrd);
	        	Statement stmt = conn.createStatement();
	        	String sql = "select * from administrator";//查询数据
	        	ResultSet rs = stmt.executeQuery(sql);
	        	//ResultSet对象用于装载查询结果
	        	while (rs.next()) {    //循环读取数据库的表内容
	        		AdministratorItem adm  = new AdministratorItem();
					adm.setID(rs.getString(1));
					admList.add(adm);
	        		
	        	}
	        	rs.close();
	        	stmt.close();
	        	conn.close();
	        	
	        	for(int i = 0;i < admList.size();i++) {
    	        	if(admList.get(i).getID().equals(id)) {
    	        		return true;
    	        	}
    	        }
	    	} catch (Exception e) {
				e.printStackTrace();
			}
	    	return false;
	    }    
}
