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
@WebServlet("/SingIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("validated", true);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] params = User.getLoginParams(request);
		User u = new User(params);

		try {
			if (!u.paramIsValid("email", u.getAttr("email")) || !u.paramIsValid("password", u.getAttr("password"))) {
				request.setAttribute("error", "Invalid email or password");
				request.setAttribute("validated", false);
				doGet(request, response);
				return;
			} else {
				request.setAttribute("validated", true);
				HttpSession session = request.getSession();
				u = User.findUser(u.getAttr("email"));
				session.setAttribute("fullname", u.getAttr("fullname"));
				response.sendRedirect("index.jsp");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
