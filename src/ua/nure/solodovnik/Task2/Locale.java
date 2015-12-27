package ua.nure.solodovnik.Task2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebServlet("/locale")
public class Locale extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(Locale.class);

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String locale = req.getParameter("newLocale");
		HttpSession session = req.getSession();
		session.setAttribute("currentLocale", locale);
		resp.sendRedirect(req.getContextPath() + "/list");
	}

}