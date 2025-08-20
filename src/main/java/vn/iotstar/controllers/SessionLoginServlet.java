package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session-login")
public class SessionLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String user = request.getParameter("username");
		String pass = request.getParameter("password");

		if ("trung".equals(user) && "123".equals(pass)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("username", user);
			session.setMaxInactiveInterval(60);
			response.sendRedirect(request.getContextPath() + "/hello-session");
		} else {
			response.sendRedirect(request.getContextPath() + "/SessionLogin.html");
		}
	}
} 