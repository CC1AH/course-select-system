package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import bean.AdministratorItem;
import bean.DBInfos;

public class admLoginDAO {
	 
	 public int check(String id,String password) {  
	    	
		 List<AdministratorItem> admList = new ArrayList<AdministratorItem>();
		 try {
	    		Class.forName(DBInfos.DRIVER);
	        	Connection conn = DriverManager.getConnection(DBInfos.ConNam,DBInfos.usrNam,
						DBInfos.DbPasWrd);	
	        	Statement stmt = conn.createStatement();
	        	String sql = "select * from administrator";//��ѯ����
	        	ResultSet rs = stmt.executeQuery(sql);
	        	//ResultSet��������װ�ز�ѯ���
	        	while (rs.next()) {    //ѭ����ȡ���ݿ�ı�����
	        		AdministratorItem adm  = new AdministratorItem();
					adm.setID(rs.getString(1));
					adm.setPassword(rs.getString(2));
					admList.add(adm);
	        		
	        	}	        
	        	rs.close();
	        	stmt.close();
	        	conn.close();
	    	        for(int i = 0;i < admList.size();i+=2) {
	    	        	System.out.println(admList.get(i).getID());
	    	        	if(admList.get(i).getID().equals(id)) {	    	        		
	    	        			if(admList.get(i).getPassword().equals(password)) {
	    	        				return 1;//�˺��������ȷ
	    	        			}else {
	    	        				return 2;//�˺Ŵ��ڵ��������
	    	        			}
	    	        		}    	  		
	    	        	}	    	       	
	    	} catch (Exception e) {
				e.printStackTrace();
			}
	    	return 3;
	    }

}
