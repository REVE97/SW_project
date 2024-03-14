package sku.lesson2.service;

import java.util.ArrayList;

import sku.lesson2.dao.MemberDAO;
import sku.lesson2.dto.MemberDTO;

public class MemberService {
	public boolean registMember(MemberDTO member) {
		boolean flag = false;
		MemberDAO dao = new MemberDAO();
		flag = dao.insert(member);
		return flag;
	}

	public ArrayList<MemberDTO> getMemberData() {
		// TODO Auto-generated method stub
		ArrayList<MemberDTO> list = new MemberDAO().selectAll();
		return list;
	}
	//조건 조회
	
	//수정
	
	//삭제
	
}
