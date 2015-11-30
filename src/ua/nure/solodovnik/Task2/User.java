package ua.nure.solodovnik.Task2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class User {
	private HashMap<String, String> attrs = new HashMap<String, String>();
	
	public User() {}
	
	public User(String[] params) {
		String[] temp = signupParams;
		for (int i = 0; i < params.length; i++) {
			attrs.put(temp[i], params[i]);
		}
	}
	
	private static String[] signupParams = {"login", "password", "fullname", "email", "isAdmin"};
		
	public static String[] getSignUpParams(HttpServletRequest request) {
		return getParams(request, signupParams);
	}
	
	public static String getParam(HttpServletRequest request, String name) {
		return request.getParameter(name);
	}
	
	public String getAttr(String attrName) {
		return this.attrs.get(attrName);
	}
	
	private static String[] getParams(HttpServletRequest request, String[] params) {
		String[] result = new String[params.length];
		for (int i = 0; i < params.length; i++) {
			result[i] = request.getParameter(params[i]);
		}
		return result;
	}
	
	public static User findUser(String email) throws SQLException {
		Connection c = PSQLConnection.getConnection();
		Statement s = c.createStatement();
		String query = "SELECT * FROM users WHERE email='" + email + "';";
		ResultSet rs = s.executeQuery(query);
		
		String[] attrs = new String[5];
		while(rs.next()){
			for (int i = 1; i <= attrs.length; i++) {
				attrs[i - 1] = rs.getString(i);
			}
		}
		User u = new User(attrs);
		
		c.close();
		s.close();
		rs.close();
		
		return u;
	}
	
	public static User[] getAll() throws SQLException {
		User[] users = new User[getQueryCounter("SELECT COUNT(*) FROM users;")];
		
		Connection c = PSQLConnection.getConnection();
		Statement s = c.createStatement();
		String query = "SELECT * FROM users;";
		ResultSet rs = s.executeQuery(query);
		
		String[] attrs = new String[5];
		int j = 0;
		while(rs.next()){
			for (int i = 1; i <= attrs.length; i++) {
				attrs[i - 1] = rs.getString(i);
			}
			users[j++] = new User(attrs);
		}
		
		c.close();
		s.close();
		rs.close();
		
		return users;
	}
	
	private static int getQueryCounter(String query) throws SQLException {
		Connection c = PSQLConnection.getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery(query);
		
		int count = 0;
		while(rs.next()){
			count = rs.getInt("count");
		}
		
		c.close();
		s.close();
		rs.close();
		
		return count;
	}
	
//	private static void closeConnections(Object[] array) throws SQLException {
//		for (Object o : array) {
//			((Connection) o).close();
//		}
//	}
	
	public static boolean create(String[] params) throws SQLException {
		Connection c = PSQLConnection.getConnection();
		Statement s = c.createStatement();
		String query = String.format("INSERT INTO users VALUES ('%s', '%s', '%s', '%s', false);", params[0], params[1], params[2], params[3]);
		
		int counter = s.executeUpdate(query);
		
		c.close();
		s.close();
		
		return counter!= 0;
	}
	
	public static boolean delete(String login) throws SQLException {
		Connection c = PSQLConnection.getConnection();
		Statement s = c.createStatement();
		String query = String.format("DELETE FROM users WHERE login='" + login + "';");
		
		int counter = s.executeUpdate(query);
		
		c.close();
		s.close();
		
		return counter!= 0;
	}
	
	public boolean paramIsValid(String param, String value) throws SQLException {
		String query = String.format("SELECT COUNT(*) AS count FROM users WHERE " + param + "='%s';", value);
		
		return (getQueryCounter(query) > 0);
	}
}
