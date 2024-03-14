package sku.lesson2.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sku.lesson2.dto.MemberDTO;
import sku.lesson2.service.MemberService;

/**
 * Servlet implementation class ExampleServlet
 */
@WebServlet("/ExampleServlet")
public class ExampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExampleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String cmd = request.getParameter("command");
		cmd = (cmd==null)?"list":cmd;
		String url = null;
		//list요청 
		if(cmd.equals("list")) {
			url = "./member/list.jsp";
			MemberService ms = new MemberService();
			ArrayList<MemberDTO> list = ms.getMemberData();
			HttpSession session = request.getSession();
			session.setAttribute("list", list);
		} else if(cmd.equals("regist")){
			String name = request.getParameter("userName");
			String id = request.getParameter("userId");
			String pwd = request.getParameter("userPwd");
			Timestamp date = new Timestamp(System.currentTimeMillis());
			MemberDTO dto = new MemberDTO(id, name, pwd, date);
			System.out.println(dto);
			//service 에게 전달
			MemberService ms = new MemberService();
			boolean flag = ms.registMember(dto);
			url = "./ExampleServlet?command=list";
		} else if(cmd.equals("registView")) {
			url = "./member/regist.jsp";
		} else if(cmd.equals("updateView")) {
			url="./member/update.jsp";
			String id = request.getParameter("userId");
			System.out.println("uv >>> "+id);
		} else if(cmd.equals("search")) {
			url="./member/detail.jsp";
			String id = request.getParameter("userId");
			System.out.println("search >>> "+id);
		} else if(cmd.equals("delete")) {
			url="./ExampleServlet?command=list";
			String id = request.getParameter("userId");
			System.out.println("delete >>> "+id);
		} else if(cmd.equals("update")) {
			url = "./ExampleServlet?command=search";
		}
		response.sendRedirect(url);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
