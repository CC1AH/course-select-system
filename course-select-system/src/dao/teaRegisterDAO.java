package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.DBInfos;
import bean.Teacher;

public class teaRegisterDAO {	
	public void add(String stuID,String name,String dept_name,
			int salary,String password) {

	try {
		Class.forName(DBInfos.DRIVER);
    	Connection conn = DriverManager.getConnection(DBInfos.ConNam,DBInfos.usrNam,
				DBInfos.DbPasWrd);	
    	String sql = "insert into instructor(tID,name,dept_name,salary,password)values(?,?,?,?,?)";
    	//添加数据
    	PreparedStatement ps = conn.prepareStatement(sql);
    	ps.setString(1,stuID);
    	ps.setString(2,name);
    	ps.setString(3,dept_name);
    	ps.setInt(4,salary);
    	ps.setString(5,password);
    	ps.executeUpdate();
    	
    	ps.close();
    	conn.close();	
	} catch (Exception e) {
		e.printStackTrace();
	}
  }
	
	public boolean check(String id) {  
		 List<Teacher> teaList = new ArrayList<Teacher>();
    	try {
    		 Class.forName(DBInfos.DRIVER);
		    	Connection conn = DriverManager.getConnection(DBInfos.ConNam,DBInfos.usrNam,
						DBInfos.DbPasWrd);
        	Statement stmt = conn.createStatement();
        	String sql = "select * from instructor";//查询数据
        	ResultSet rs = stmt.executeQuery(sql);
        	//ResultSet对象用于装载查询结果
        	while (rs.next()) {  
        		Teacher tea  = new Teacher();
				tea.setID(rs.getString(1));
				teaList.add(tea);
        		
        	}
        	rs.close();
        	stmt.close();
        	conn.close();
        	
        	for(int i = 0;i < teaList.size();i++) {
	        	if(teaList.get(i).getID().equals(id)) {
	        		return true;
	        	}
	        }
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	return false;
    }     
}
