package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello-session")
public class HelloSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);
		String username = null;
		if (session != null) {
			Object value = session.getAttribute("username");
			if (value != null) {
				username = value.toString();
			}
		}

		if (username == null || username.isEmpty()) {
			response.sendRedirect(request.getContextPath() + "/SessionLogin.html");
			return;
		}

		out.println("Xin chao (Session) " + username + "<br>");
		out.println("<a href='" + request.getContextPath() + "/logout-session'>Logout (Session)</a>");
	}
} 