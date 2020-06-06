package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.DBInfos;
import bean.StudentItem;

public class stuRegisterDAO {
	
	public void add(String stuID,String name,String dept_name,
			int tot_cred,String password) {
	try {
		Class.forName(DBInfos.DRIVER);
    	Connection conn = DriverManager.getConnection(DBInfos.ConNam,DBInfos.usrNam,
				DBInfos.DbPasWrd);	
    	String sql = "insert into student(stuID,name,dept_name,tot_cred,password)values(?,?,?,?,?)";
    	//添加数据
    	PreparedStatement ps = conn.prepareStatement(sql);
    	ps.setString(1,stuID);
    	ps.setString(2,name);
    	ps.setString(3,dept_name);
    	ps.setInt(4,tot_cred);
    	ps.setString(5,password);
    	ps.executeUpdate();
    	
    	ps.close();
    	conn.close();	
	} catch (Exception e) {
		e.printStackTrace();
	}
  }
	
	public boolean check(String id) {  
		List<StudentItem> stuList = new ArrayList<StudentItem>();
    	try {
    		 Class.forName(DBInfos.DRIVER);
		    	Connection conn = DriverManager.getConnection(DBInfos.ConNam,DBInfos.usrNam,
						DBInfos.DbPasWrd);
        	Statement stmt = conn.createStatement();
        	String sql = "select * from administrator";//查询数据
        	ResultSet rs = stmt.executeQuery(sql);
        	//ResultSet对象用于装载查询结果
        	while (rs.next()) {    //循环读取数据库的表内容
        		StudentItem stu  = new StudentItem();
				stu.setsID(rs.getString(1));
				stuList.add(stu);
        	}
        	rs.close();
        	stmt.close();
        	conn.close();
        	
        	for(int i = 0;i < stuList.size();i++) {
	        	if(stuList.get(i).getsID().equals(id)) {
	        		return true;
	        	}
	        }
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	return false;
    }    
}
