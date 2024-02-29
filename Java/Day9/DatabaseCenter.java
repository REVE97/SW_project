package sku.lesson.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseCenter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//connectDatabase 호출
		DatabaseCenter dc = new DatabaseCenter();
		dc.testQuery();
	}
	
	public void testQuery() {
		//DAO의 select 호출 코드 작성
		BookDAO dao = new BookDAO();
		dao.select("select * from book");
	}
	
	public void test() {
		try {
			this.connectDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void connectDatabase() throws SQLException, ClassNotFoundException {
		String id = "root";
		String pwd = "1q2w3e4r";
		String driver = "com.mysql.cj.jdbc.Driver";
		String jdbcURL = "jdbc:mysql://localhost:3306/gisa";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbcURL,id,pwd);
		if(con!=null) {
			System.out.println("conneting database");
			con.close();
		} else {
			System.out.println("connection fail");
		}
	}

}
