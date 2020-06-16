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
	
	//���سɼ���
	public List<TakesItem> list(String course_id){
		return list(0, Integer.MAX_VALUE, course_id);
	}
	
	//���ܣ����ݴ���γ̺�course_id��ȡ��Ӧѧ���б�
	public List<TakesItem> list(int start, int count, String course_id){
		List<TakesItem> gradeList = new ArrayList<TakesItem>();
		
		String sql = "select sID,name,course_id,title,sec_id,semester,year,grade "
				+ "from (takes natural join student) join course using(course_id) " 
				+ "where takes.course_id = ?";
		
		try(Connection c = getConnection(); PreparedStatement pstat = c.prepareStatement(sql);){
			
			
			System.out.println(course_id);//�����ԣ���ӡ����course_id
			
			pstat.setString(1,course_id);//����sql����

			ResultSet resultSet = pstat.executeQuery(); //��ȡ�����
			
			System.out.println("ROW��"+resultSet.getRow());//�����ԣ���ӡ���������
			
			
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
				
				gradeList.add(gradeItem);//�����б�
			}
			
			//�ر�����
			resultSet.close();
			pstat.close();
			c.close();
			
		}catch (SQLException e) {
			
			System.out.println("���سɼ��������");
	
			e.printStackTrace();
		}
		
		return gradeList;
	}
	
	
	//���ܣ��жϵ�ǰ��ʦ�Ƿ��������ȡ�ÿγ�ѧ���������ο���ʦ
	public boolean checkIdentity(String course_id,String teaID) {
		
		//����һ����ʦ�б��Դ���һ�ſγ��ж���ν���ʦ�����
		List<String> listTeachers = new ArrayList<String>();
		
		String sql = "select tID from teaches where course_id = ?";
		
		System.out.println("course_id="+course_id);//(����) ��ӡ����γ̺�
		System.out.println("teaID="+teaID); //�����ԣ���ӡ��ǰ��ʦid
		
		try(Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);)
		{
			ps.setString(1,course_id);//����sql����
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				listTeachers.add(rs.getString(1));
			}
			
			//�ر�����
			rs.close();
			ps.close();
			c.close();
			
			//�����ǰ��ʦid�������ον�ʦid���У��򷵻�true
			if(listTeachers.contains(teaID))
				return true;
			
		}catch (SQLException e) {

			e.printStackTrace();
			System.out.println("��ѯ�ον�ʦid������");
		}
		
		return false;
	}
	
	
	
	//���ܣ����½�ʦ¼��ĳɼ�
public boolean updateScore(String stu_id, String course_id,double grade) {
		
		
		String sql="update takes set grade = ? "+" where sID = ?"+"and course_id = ?";
		try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);)

		{
			
			//������³ɼ�����60���������ݿ�Ϊ59
			if(grade<60)
				ps.setDouble(1, 59);
			else
				ps.setDouble(1, grade);
			
			ps.setString(2, stu_id);
			
			/*****�޸Ĳ���*******/
			ps.setString(3, course_id);
			/*****�޸Ĳ���*******/
			
			int row = ps.executeUpdate(); //�����صĸ�������Ϊ1��˵���޸ĳɼ��ɹ�
			if(row==1) {
				
				//�ر�����
				c.close();
	            ps.close();
	            
	            return true;
			}
			else {
				//�����ԣ�����޸�ʧ�ܣ������Ϣ
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