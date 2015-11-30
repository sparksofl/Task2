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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		try {
			if (User.create(User.getSignUpParams(request))) {
				HttpSession session = request.getSession(false);
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
