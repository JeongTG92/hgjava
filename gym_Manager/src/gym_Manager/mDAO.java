package gym_Manager;

import java.sql.Connection;
import java.sql.DriverManager;

import oracle.net.nt.ConnectDescription;

public class mDAO {
	public static Connection conn;
	
	public static Connection getConn() {
		try {
			Class.forName("oracle.jdbc.OraleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "yedam", "yedam");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
		
	
}
