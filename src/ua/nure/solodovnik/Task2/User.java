package ua.nure.solodovnik.Task2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

public class User {
	private static String[] loginParams = {"login", "pword"};
	private static String[] signupParams = {"uname", "pword", "fname", "email"};
	
	public static String[] getLoginParams(HttpServletRequest request) {
		return getParams(request, loginParams);
	}
	
	public static String[] getSignUpParams(HttpServletRequest request) {
		return getParams(request, signupParams);
	}
	
	private static String[] getParams(HttpServletRequest request, String[] params) {
		String[] result = new String[params.length];
		for (int i = 0; i < params.length; i++) {
			result[i] = request.getParameter(params[i]);
		}
		return result;
	}
	
	public boolean create(String[] params) throws SQLException {
		Connection c = CreatingConnection.getConnection();
		Statement s = c.createStatement();
		String query = String.format("INSERT INTO users VALUES ('%s', '%s', '%s', '%s', false);", params[0], params[1], params[2], params[3]);
		return s.executeUpdate(query) != 0;
	}
}
