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
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignUp() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("invalid", true);
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession(false);
		if (request.getParameter("login").length() < 5) {
			request.setAttribute("message", "Login must be at least 5 characters");
			doGet(request, response);
			return;
		} else if (request.getParameter("password").length() < 3) {
			request.setAttribute("message", "Password must be at least 3 characters");
			doGet(request, response);
			return;
		} else if (request.getParameter("email").indexOf('@') == -1) {
			request.setAttribute("message", "Email must contain a '@' character");
			doGet(request, response);
			return;
		} else {
			try {
				if (User.create(User.getSignUpParams(request))) {
					//User u = User.findUser(session.getAttribute("fullname").toString());
					//session.setAttribute("fullname", session.getAttribute("fullname"));
					//session.setAttribute("role", u.getAttr("isAdmin").equals("t") ? "Admin" : "User");
					session.setAttribute("allUsers", User.getAll());
					response.sendRedirect("index.jsp");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
