package ua.nure.solodovnik.Task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PSQLConnection {
	public static void main(String[] args) {
        
	}
	
	public static Connection getConnection() {
		Connection con = null;
		try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loading success!");

            String url = "jdbc:postgresql://127.0.0.1/task2";
            String name = "eclipseuser";
            String password = "eclipseuser";
            try {
                con = DriverManager.getConnection(url, name, password);
                return con;
                //System.out.println("Connected.");
                //con.close();
                //System.out.println("Disconnected.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		return con;
	}
}
