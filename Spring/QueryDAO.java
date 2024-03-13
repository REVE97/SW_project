package sku.lesson.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class QueryDAO {
	public String[] getColumnNames() {
		//요청한 결과의 컬럼값
		
		return null;
	}
	
	public String[][] select(String table) throws SQLException{
		//요청한 결과 내용(값)
		Connection con = this.getConnection();
		String sql = "select * from "+table+" limit 5;";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ResultSetMetaData rsmd = (ResultSetMetaData)rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		System.out.println(columnCount);
		String[] columnNames = new String[columnCount];
		for(int i=0;i<columnCount;i++){
			columnNames[i] = rsmd.getColumnName(i+1);
		}
		String[][] values = new String[6][columnCount];
		//System.out.println(Arrays.toString(columnNames));
		values[0] = columnNames;
		System.out.println(Arrays.toString(columnNames));
		int count = 1 ;
		while(rs.next()){
			for(int i=0;i<columnCount;i++){
				values[count][i] = rs.getString(columnNames[i]);
			}
			count = count + 1;
		}

		rs.close();
		stmt.close();
		con.close();	
		return values;
	}
	
	private Connection getConnection() {
		String id = "root";
		String pwd = "1q2w3e4r";
		String driver = "com.mysql.cj.jdbc.Driver";
		String jdbcURL = "jdbc:mysql://localhost:3306/sku";
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(jdbcURL,id,pwd);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return con;
	}
}
