package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(urlPatterns= {"/hello","/xin-chao"})
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter printWriter = response.getWriter();
		String name=
		"";
		//Nhận cookie
		Cookie[] cookie = request.getCookies();
		if (cookie != null) {
			for (Cookie c: cookie) {
				if(c.getName().equals("username")) {
					name = c.getValue();
				}
			}
		}
		if(name.equals("")){
			//chuyển sang trang Login.html
			response.sendRedirect(request.getContextPath() + "/Login.html");
			return;
		}
		//hiển thị lên trang bằng đối tượng PrintWriter()
		printWriter.println("Xin chao " + name + "<br>");
		printWriter.println("<a href='" + request.getContextPath() + "/logout-cookie'>Logout (Cookie)</a>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
