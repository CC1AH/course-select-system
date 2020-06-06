package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.DBInfos;
import bean.TeachesItem;

public class TeacherCourseDAO {
	
	public TeacherCourseDAO() {
		try {
			Class.forName(DBInfos.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				DBInfos.ConNam,DBInfos.usrNam,
				DBInfos.DbPasWrd);
	}

	
	//列出该ID的教师本学期教学课表
	public List<TeachesItem> list(String teacherID) {
		return list(0, Integer.MAX_VALUE, teacherID);
	}
		
	public List<TeachesItem> list(int start, int count, String teacherID) {
		List<TeachesItem> teachesList = new ArrayList<TeachesItem>();
		
		String sql = "select * from teaches where tID = ?";
		try (Connection c = getConnection(); PreparedStatement pstat = c.prepareStatement(sql);)
		{
			//设置sql参数
			pstat.setString(1, teacherID);

			ResultSet resultSet = pstat.executeQuery(); //获取结果集
			
			while(resultSet.next()) {
				TeachesItem teachesItem = new TeachesItem();
				teachesItem.setID(resultSet.getString(1));
				teachesItem.setCourse_id(resultSet.getString(2));
				teachesItem.setSec_id(resultSet.getString(3));
				teachesItem.setSemester(resultSet.getString(4));
				teachesItem.setYear(resultSet.getInt(5));
				
				teachesList.add(teachesItem);//加入列表
			}
			
			//关闭连接
			resultSet.close();
			pstat.close();
			c.close();
			
		} catch (SQLException e) {
			
				e.printStackTrace();
			}

		return teachesList;
	}
}
