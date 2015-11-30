package ua.nure.solodovnik.Task2;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SingIn
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("validated", true);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User u = User.findUser(request.getParameter("email"));
			
			if (!u.paramIsValid("email", u.getAttr("email")) || !u.paramIsValid("password", u.getAttr("password"))) {
				doGet(request, response);
				return;
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("fullname", u.getAttr("fullname"));
				session.setAttribute("role", u.getAttr("isAdmin").equals("t") ? "Admin" : "User");
				session.setAttribute("allUsers", User.getAll());
				response.sendRedirect("index.jsp");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
