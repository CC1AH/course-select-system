package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.DBInfos;
import bean.SectionVariableItem;

public class SectionVariableDAO {
	public SectionVariableDAO() {
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
	public void update(boolean section_variable) {
		  
        String sql = "update section_variable set section_variable= ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setBoolean(1, section_variable);
      
            ps.execute();
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
  
    }
}
