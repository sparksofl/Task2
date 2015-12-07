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
			User u = User.findUser("email", request.getParameter("email"));
			System.out.println("servlet pass" + User.getParam(request, "password"));
			System.out.println("servlet email" + User.getParam(request, "email"));
			if (!u.passIsCorrect(User.getParam(request, "password"), User.getParam(request, "email"))) {
				request.setAttribute("invalid", true);
				request.setAttribute("message", "Incorrect login or password");
				doGet(request, response);
				return;
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("fullname", u.getAttr("fullname"));
				session.setAttribute("login", u.getAttr("login"));
				session.setAttribute("role", u.getAttr("isAdmin").equals("t") ? "Admin" : "User");
				session.setAttribute("allUsers", User.getAll());
				response.sendRedirect("index.jsp");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
