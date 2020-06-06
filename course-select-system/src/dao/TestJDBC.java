package dao;
  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import bean.DBInfos;
  
public class TestJDBC {
    public static void main(String[] args) {
  
        try {
        	Class.forName(DBInfos.DRIVER);
	    	Connection conn = DriverManager.getConnection(DBInfos.ConNam,DBInfos.usrNam,
					DBInfos.DbPasWrd);	
  
            // 注意：使用的是 java.sql.Statement
            // 不要不小心使用到： com.mysql.jdbc.Statement;
            Statement s = conn.createStatement();
  
            System.out.println("获取 Statement对象： " + s);
  
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  
    }
}