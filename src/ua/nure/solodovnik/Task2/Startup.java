package ua.nure.solodovnik.Task2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Startup
 */
@WebServlet("")
public class Startup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object check = session.getAttribute("fullname");
		if (check == null) {
			System.out.println(check);
			System.out.println("null");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			System.out.println(check);
			System.out.println("not null");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
