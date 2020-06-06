package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.DBInfos;
import bean.Teacher;

public class teaLoginDAO {
	
	public int check(String id,String password) {  
		 List<Teacher> teaList = new ArrayList<Teacher>();
    	try {
    		Class.forName(DBInfos.DRIVER);
	    	Connection conn = DriverManager.getConnection(DBInfos.ConNam,DBInfos.usrNam,
					DBInfos.DbPasWrd);	
        	Statement stmt = conn.createStatement();
        	String sql = "select * from instructor";//查询数据
        	ResultSet rs = stmt.executeQuery(sql);
        	//ResultSet对象用于装载查询结果
        	while (rs.next()) {     //循环读取数据库的表内容
        		Teacher tea  = new Teacher();
				tea.setID(rs.getString(1));
				tea.setPassword(rs.getString(5));
				teaList.add(tea);
    	}
    	rs.close();
    	stmt.close();
    	conn.close();
    	for(int i = 0;i < teaList.size();i++) {
        	if(teaList.get(i).getID().equals(id)) {	    	        		
        			if(teaList.get(i).getPassword().equals(password)) {
        				return 1;//账号密码均正确
        			}else {
        				return 2;//账号存在但密码错误
        			}
        		}    	  		
        	}	
	} catch (Exception e) {
		e.printStackTrace();
	}
	return 3;
}   
}
