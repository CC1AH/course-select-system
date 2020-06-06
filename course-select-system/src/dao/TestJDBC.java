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
  
            // ע�⣺ʹ�õ��� java.sql.Statement
            // ��Ҫ��С��ʹ�õ��� com.mysql.jdbc.Statement;
            Statement s = conn.createStatement();
  
            System.out.println("��ȡ Statement���� " + s);
  
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
  
    }
}