package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout-cookie")
public class LogoutCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie expired = new Cookie("username", "");
		expired.setMaxAge(0);
		expired.setPath(request.getContextPath().isEmpty() ? "/" : request.getContextPath());
		response.addCookie(expired);
		response.sendRedirect(request.getContextPath() + "/Login.html");
	}
} 