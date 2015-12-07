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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Update() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
//			HttpSession session = request.getSession(false);
			if (request.getParameter("login") != null) {
				String login = request.getParameter("login");
				User u = User.findUser("login", login);
				request.setAttribute("user", u);				
			}
//			session.setAttribute("allUsers", User.getAll());
			request.getRequestDispatcher("/edit.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (request.getParameter("password").length() < 3) {
			request.setAttribute("invalid", true);
			request.setAttribute("message", "Password must be at least 3 characters");
			doGet(request, response);
			//request.getRequestDispatcher("/edit.jsp").forward(request, response);
			return;
		} else if (request.getParameter("email").indexOf('@') == -1) {
			request.setAttribute("invalid", true);
			request.setAttribute("message", "Email must contain a '@' character");
			doGet(request, response);
			return;
		} else {
			try {
				String login = request.getParameter("login");
				User.update("password", request.getParameter("password"), login);
				User.update("email", request.getParameter("email"), request.getParameter("login").toString());
				User.update("fullname", request.getParameter("fullname"), request.getParameter("login").toString());
				session.setAttribute("allUsers", User.getAll());
				response.sendRedirect("index.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
