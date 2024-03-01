package sku.lesson.db.try1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GisaDAO {
	
	public boolean insert(ArrayList<Student> list) throws SQLException{
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();	
		String sql = "insert into gisa values (?,?,?,?,?,?,?,?,?,?,?)";		
		int affectedCount = 0;
		PreparedStatement pstmt = null;
		try {
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			int count = 0;
			for(Student student : list) {
				pstmt.setInt(1, student.getStdNo());
				pstmt.setString(2, student.getEmail());
				pstmt.setInt(3, student.getKor());
				pstmt.setInt(4, student.getEng());
				pstmt.setInt(5, student.getMath());
				pstmt.setInt(6, student.getSci());
				pstmt.setInt(7, student.getHist());
				pstmt.setInt(8, student.getTotal());
				pstmt.setString(9, student.getMgrCode());
				pstmt.setString(10, student.getAccCode());
				pstmt.setString(11, student.getLocCode());
				pstmt.addBatch();
				count = count + 1;
				if(count%100==0) {
					int[] temp = pstmt.executeBatch();
					affectedCount += temp.length;
					System.out.println("batch execute!");
				}
				//affectedCount += pstmt.executeUpdate();
			}
			
			if(affectedCount>0) {
				System.out.println(affectedCount);
				flag = true;
			}
			con.commit();
			//con.setAutoCommit(true);
		} catch(SQLException se) {
			con.rollback();
			//con.setAutoCommit(true);
		} finally {
			con.setAutoCommit(true);
		}
		ConnectionManager.closeConnection(null, pstmt, con);
		
		return flag;
	}
	
	public boolean insertNew(ArrayList<Student> list) throws SQLException{
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();	
		String sql = "insert into gisa values (?,?,?,?,?,?,?,?,?,?,?)";		
		int affectedCount = 0;
		PreparedStatement pstmt = null;
		try {
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(sql);
			for(Student student : list) {
				pstmt.setInt(1, student.getStdNo());
				pstmt.setString(2, student.getEmail());
				pstmt.setInt(3, student.getKor());
				pstmt.setInt(4, student.getEng());
				pstmt.setInt(5, student.getMath());
				pstmt.setInt(6, student.getSci());
				pstmt.setInt(7, student.getHist());
				pstmt.setInt(8, student.getTotal());
				pstmt.setString(9, student.getMgrCode());
				pstmt.setString(10, student.getAccCode());
				pstmt.setString(11, student.getLocCode());
				affectedCount += pstmt.executeUpdate();
			}
			
			if(affectedCount>0) {
				System.out.println(affectedCount);
				flag = true;
			}
			con.commit();
			//con.setAutoCommit(true);
		} catch(SQLException se) {
			con.rollback();
			//con.setAutoCommit(true);
		} finally {
			con.setAutoCommit(true);
		}
		ConnectionManager.closeConnection(null, pstmt, con);
		
		return flag;
	}
	
	public boolean insertOld(ArrayList<Student> list) throws SQLException{
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		String sql = "insert into gisa values (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		int affectedCount = 0;
		for(Student student : list) {
			pstmt.setInt(1, student.getStdNo());
			pstmt.setString(2, student.getEmail());
			pstmt.setInt(3, student.getKor());
			pstmt.setInt(4, student.getEng());
			pstmt.setInt(5, student.getMath());
			pstmt.setInt(6, student.getSci());
			pstmt.setInt(7, student.getHist());
			pstmt.setInt(8, student.getTotal());
			pstmt.setString(9, student.getMgrCode());
			pstmt.setString(10, student.getAccCode());
			pstmt.setString(11, student.getLocCode());
			affectedCount += pstmt.executeUpdate();
		}
		
		if(affectedCount>0) {
			System.out.println(affectedCount);
			flag = true;
		}
		ConnectionManager.closeConnection(null, pstmt, con);
		
		return flag;
	}
	
	public boolean insert(Student student) throws SQLException {
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		String sql = "insert into gisa values (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, student.getStdNo());
		pstmt.setString(2, student.getEmail());
		pstmt.setInt(3, student.getKor());
		pstmt.setInt(4, student.getEng());
		pstmt.setInt(5, student.getMath());
		pstmt.setInt(6, student.getSci());
		pstmt.setInt(7, student.getHist());
		pstmt.setInt(8, student.getTotal());
		pstmt.setString(9, student.getMgrCode());
		pstmt.setString(10, student.getAccCode());
		pstmt.setString(11, student.getLocCode());
		int affectedCount = pstmt.executeUpdate();
		if(affectedCount>0) {
			flag = true;
		}
		ConnectionManager.closeConnection(null, pstmt, con);
		return flag;
	}
	public boolean insert(String sql) throws SQLException {
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		Statement stmt = con.createStatement();
		int affectedCount = stmt.executeUpdate(sql);
		ConnectionManager.closeConnection(null, stmt, con);
		if(affectedCount>0) {
			flag = true;
		}
		return flag;
	}
	
	public boolean delete(String sql) throws SQLException {
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		Statement stmt = con.createStatement();
		int affectedCount = stmt.executeUpdate(sql);
		ConnectionManager.closeConnection(null, stmt, con);
		if(affectedCount>0) {
			flag = true;
		}
		return flag;
	}
}
