package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.DBInfos;
import bean.StudentItem;

public class stuLoginDAO {
	     	
		 public int check(String id,String password) {  
		    	
			 List<StudentItem> stuList = new ArrayList<StudentItem>();	
			 try {
				 Class.forName(DBInfos.DRIVER);
			    	Connection conn = DriverManager.getConnection(DBInfos.ConNam,DBInfos.usrNam,
							DBInfos.DbPasWrd);	
		        	Statement stmt = conn.createStatement();
		        	String sql = "select * from student";//查询数据
		        	ResultSet rs = stmt.executeQuery(sql);
		        	//ResultSet对象用于装载查询结果
		        	while (rs.next()) {     //循环读取数据库的表内容
		        		StudentItem stu  = new StudentItem();
						stu.setsID(rs.getString(1));
						stu.setPassword(rs.getString(5));
						stuList.add(stu);
		        		
	        	}
	        	rs.close();
	        	stmt.close();
	        	conn.close();
	        	for(int i = 0;i < stuList.size();i++) {
    	        	if(stuList.get(i).getsID().equals(id)) {	    	        		
    	        			if(stuList.get(i).getPassword().equals(password)) {
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
