package sku.lesson.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sku.lesson.service.QueryService;

public class MyServlet extends HttpServlet {
	//브라우저 요청 처리를 한다.
	//Get Post
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get");
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// resp로 부터 클라어언트 스트림 정보 획득
		System.out.println("post");
		//PrintWriter out = resp.getWriter();
		//out.print("Hello Servlet");
		String table = req.getParameter("table");
		if (table==null||table.equals("")){
			table = "book";
		}
		QueryService qs = new QueryService();
		String[][] result = qs.getData(table);
		for(String[] value : result) {
			System.out.println(Arrays.toString(value));
		}
		
		// client로 데이터 전달 ///////////////
		HttpSession session = req.getSession();
		session.setAttribute("data", result);
		/////////////////////////////////////////
		
		resp.sendRedirect("review/database.jsp");
	}
}
