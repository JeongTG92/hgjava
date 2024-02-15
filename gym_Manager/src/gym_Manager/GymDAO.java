package gym_Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GymDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	public boolean Insertmb(Member mb) {
		sql = "insert into mb (name,\r\n"
				+ "            email,\r\n"
				+ "            birth_date,\r\n"
				+ "            mw,\r\n"
				+ "            address,\r\n"
				+ "            phone)\r\n"
				+ "values (?,\r\n"
				+ "        ?,\r\n"
				+ "        ?,\r\n"
				+ "        ?,\r\n"
				+ "        ?,\r\n"
				+ "        ?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mb.getName());
			psmt.setString(2, mb.getEmail());
			psmt.setString(3, mb.getBirth());
			psmt.setString(4, mb.getGender());
			psmt.setString(5, mb.getAddress());
			psmt.setString(6, mb.getPhone());
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
//	public boolean updateMb() {
//		
//	}
	
	
}
