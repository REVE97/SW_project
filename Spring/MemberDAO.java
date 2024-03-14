package sku.lesson2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import sku.lesson2.dto.MemberDTO;
import sku.lesson2.utils.ConnectionManager;

public class MemberDAO {
	public boolean insert(MemberDTO member) {
		boolean flag = false;
		Connection con = ConnectionManager.getConnection();
		String sql = "insert into member values (?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserName());
			pstmt.setTimestamp(4, member.getRegistDate());
			int affectedCount = pstmt.executeUpdate();
			if(affectedCount>0) {
				flag = true;
			}
			ConnectionManager.closeConnection(null, pstmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

	public ArrayList<MemberDTO> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<MemberDTO> list = null;
		list = new ArrayList<MemberDTO>();
		MemberDTO member = null;
		String sql = "select * from member";
		Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String pwd = rs.getString(2);
				String name = rs.getString(3);
				Timestamp date = rs.getTimestamp(4);
				member = new MemberDTO(id, name, pwd, date);
				list.add(member);
			}
			ConnectionManager.closeConnection(rs, pstmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}






