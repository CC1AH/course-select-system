package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bean.DBInfos;
import bean.TakesItem;
import bean.TeachesItem;


public class gradeDAO{
	
	public gradeDAO() {
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
	
	//返回成绩表
	public List<TakesItem> list(String course_id){
		return list(0, Integer.MAX_VALUE, course_id);
	}
	
	//功能：根据传入课程号course_id获取对应学生列表
	public List<TakesItem> list(int start, int count, String course_id){
		List<TakesItem> gradeList = new ArrayList<TakesItem>();
		
		String sql = "select sID,name,course_id,title,sec_id,semester,year,grade "
				+ "from (takes natural join student) join course using(course_id) " 
				+ "where takes.course_id = ?";
		
		try(Connection c = getConnection(); PreparedStatement pstat = c.prepareStatement(sql);){
			
			
			System.out.println(course_id);//（调试）打印参数course_id
			
			pstat.setString(1,course_id);//设置sql参数

			ResultSet resultSet = pstat.executeQuery(); //获取结果集
			
			System.out.println("ROW："+resultSet.getRow());//（调试）打印结果集行数
			
			
			while(resultSet.next()) {
				TakesItem gradeItem = new TakesItem();
				
				gradeItem.setID(resultSet.getString(1));
				gradeItem.setStuName(resultSet.getString(2));
				gradeItem.setCourse_id(resultSet.getString(3));
				gradeItem.setCourseName(resultSet.getString(4));
				gradeItem.setSec_id(resultSet.getString(5));
				gradeItem.setSemester(resultSet.getString(6));
				gradeItem.setYear(resultSet.getInt(7));
				gradeItem.setGrade(resultSet.getDouble(8));
				
				gradeList.add(gradeItem);//加入列表
			}
			
			//关闭连接
			resultSet.close();
			pstat.close();
			c.close();
			
		}catch (SQLException e) {
			
			System.out.println("返回成绩表出问题");
	
			e.printStackTrace();
		}
		
		return gradeList;
	}
	
	
	//功能：判断当前教师是否是请求获取该课程学生名单的任课老师
	public boolean checkIdentity(String course_id,String teaID) {
		
		//定义一个教师列表，以处理一门课程有多个任教老师的情况
		List<String> listTeachers = new ArrayList<String>();
		
		String sql = "select tID from teaches where course_id = ?";
		
		System.out.println("course_id="+course_id);//(调试) 打印传入课程号
		System.out.println("teaID="+teaID); //（调试）打印当前教师id
		
		try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);)
		{
			ps.setString(1,course_id);//设置sql参数
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				listTeachers.add(rs.getString(1));
			}
			
			//关闭连接
			rs.close();
			ps.close();
			c.close();
			
			//如果当前教师id包含在任课教师id集中，则返回true
			if(listTeachers.contains(teaID))
				return true;
			
		}catch (SQLException e) {

			e.printStackTrace();
			System.out.println("查询任课教师id出问题");
		}
		
		return false;
	}
	
	
	
	//功能：更新教师录入的成绩
public boolean updateScore(String stu_id, String course_id,double grade) {
		
		
		String sql="update takes set grade = ? "+" where sID = ?"+"and course_id = ?";
		try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);)

		{
			
			//如果更新成绩低于60，更新数据库为59
			if(grade<60)
				ps.setDouble(1, 59);
			else
				ps.setDouble(1, grade);
			
			ps.setString(2, stu_id);
			
			/*****修改部分*******/
			ps.setString(3, course_id);
			/*****修改部分*******/
			
			int row = ps.executeUpdate(); //若返回的更新行数为1，说明修改成绩成功
			if(row==1) {
				
				//关闭连接
				c.close();
	            ps.close();
	            
	            return true;
			}
			else {
				//（调试）如果修改失败，输出信息
				System.out.println("stu_id="+stu_id);
				System.out.println("grade="+grade);
				System.out.println("row="+row);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
		
	}
	
}